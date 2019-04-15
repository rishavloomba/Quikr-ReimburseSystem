package com.quikr.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikr.form.requests.EmpRequest;
import com.quikr.form.requests.FormUpdate;
import com.quikr.requests.MTask;
import com.quikr.task.Task;
import com.quikr.task.TaskRepository;

@Service
public class FormService {
	@Autowired
	FormRepository formrepository;
	
	@Autowired 
	TaskRepository taskrepository;
	
	public void addForm(EmpRequest req) {
		 Form f=new Form(req.getEmpid(),req.getManagerid(),req.getTotal_exp(),"pending");
		 formrepository.save(f);
		 
		 for(MTask t:req.getTasks()) {
			 Task newt=new Task();
			 newt.setBusiness_meal(t.getBusiness_meal());
			 newt.setHotel_stay(t.getHotel_stay());
			 newt.setTravel_exp(t.getTravel_exp());
			 newt.setTelephone_exp(t.getTelephone_exp());
			 newt.setDescription(t.getDescription());
	
			 newt.setEmpid(req.getEmpid());
			 newt.setManagerid(req.getManagerid());
			 newt.setTotal_expense(req.getTotal_exp());
			 
			 newt.setCreated_date(new Date());
			 newt.setUpdated_date(new Date());
			 
			 newt.setStatus("pending");
			 newt.setPublished(true);
			 newt.setExpense_date(new Date());
			 newt.setFormid(formrepository.getMaxFormId().getFormid());
			 
			 taskrepository.save(newt);
			 
			 
		 }
	}
	
	public ArrayList<ArrayList<Task>> getForms(int empid,String tofetch){
		ArrayList<Integer> formids;
		
		if(tofetch.equals("all"))   formids=new ArrayList<Integer>(formrepository.getAllFormIdsForEmp(empid));
		else				        formids=new ArrayList<Integer>(formrepository.getAllFormIdsForEmp(empid,tofetch));
 		
		
		ArrayList<ArrayList<Task>> forms=new ArrayList<ArrayList<Task>>();
	    
		for(int formid:formids) {
			//forms.add(new ArrayList<Task>());
			forms.add(taskrepository.getFormTasks(formid));
		}
		return forms;
		
		 ////pending
	}
	
	public void updateForm(FormUpdate req) {
		ArrayList<Task> tasks=new ArrayList<Task>();
		
		int empid=formrepository.getEmpId(req.getFormid());//get corresponding empid for form id
		int managerid=112;
		taskrepository.deleteAllWithFormId(req.getFormid());
		for(MTask t:req.getTasks()) {
			 Task newt=new Task();
			 newt.setBusiness_meal(t.getBusiness_meal());
			 newt.setHotel_stay(t.getHotel_stay());
			 newt.setTravel_exp(t.getTravel_exp());
			 newt.setTelephone_exp(t.getTelephone_exp());
			 newt.setDescription(t.getDescription());
	
			 newt.setEmpid(empid);
			 newt.setManagerid(managerid);
			 newt.setTotal_expense(req.getTotal_exp());
			 
			 newt.setCreated_date(new Date());
			 newt.setUpdated_date(new Date());
			 
			 newt.setStatus("pending");
			 newt.setPublished(false);
			 newt.setExpense_date(new Date());
			 newt.setFormid(req.getFormid());
			 
			 taskrepository.save(newt);
		}
		
	}
	
	public void toPublish(int formid) {
		
		formrepository.publish(formid);
	}
  /*
	public ArrayList<ArrayList<Task>> getViewForManager(int id, String tofetch) {
		ArrayList<Integer> formids;
		
		if(tofetch.equals("all")) formids=new ArrayList<Integer>(formrepository.getAllFormIdsForManager(id));
		else  					  formids=new ArrayList<Integer>(formrepository.getAllFormIdsForManager(id,tofetch));
		ArrayList<ArrayList<Task>> forms=new ArrayList<ArrayList<Task>>();
		for(int formid:formids) {
			forms.add(new ArrayList<Task>(taskrepository.getFormTasks(formid)));
		}
		return forms;
	}
	*/
	public Map<Integer,Map<Integer,ArrayList<MTask>>> getViewForManager(int id, String tofetch) {
		ArrayList<Integer> formids;
		
		if(tofetch.equals("all")) formids=new ArrayList<Integer>(formrepository.getAllFormIdsForManager(id));
		else  					  formids=new ArrayList<Integer>(formrepository.getAllFormIdsForManager(id,tofetch));
		//ArrayList<ArrayList<Task>> forms=new ArrayList<ArrayList<Task>>();
		Map<Integer,Map<Integer,ArrayList<MTask>>> toreturn =new HashMap<Integer,Map<Integer,ArrayList<MTask>>>();
		for(int formid:formids) {
			int empid=formrepository.getEmpId(formid);
			if(toreturn.containsKey(empid)==false) {
			toreturn.put(empid,new HashMap<Integer,ArrayList<MTask>>());
			}
			ArrayList<Task> temp=new ArrayList<Task>(taskrepository.getFormTasks(formid));
			ArrayList<MTask> finaltemp=new ArrayList<MTask>();
			
			for(Task t:temp) {
				MTask toput=new MTask(t);
				finaltemp.add(toput);
			}
			
			
			toreturn.get(empid).put(formid,finaltemp);
			
		   //toreturn.get(empid).add(new ArrayList<Task>(taskrepository.getFormTasks(formid)));
		}
		return toreturn;
	}
/*
	public void managerFormUpdate(int formid, int managerid, String status) {
		formrepository.managerFormUpdate(formid,managerid,status);
		
	}*/
}
