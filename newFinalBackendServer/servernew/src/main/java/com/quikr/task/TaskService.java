package com.quikr.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.quikr.form.Form;
import com.quikr.form.FormRepository;

import com.quikr.requests.MTask;
import com.quikr.requests.ManagerUpdate;


@Service
public class TaskService {
	@Autowired
	private TaskRepository taskrepository;
	@Autowired 
	private FormRepository formrepository;
	
	public List<Task> getAllTasks(){ //get all tasks
		List<Task> all=new ArrayList<>();
		 taskrepository.findAll().forEach(all::add);
		 return all;
	}
	
	//for employeees
	 public void addTask(Task t) { //add tasks to tasks table //
		   t.setStatus("pending");
		   
		   t.setCreated_date(new Date());
		   t.setUpdated_date(new Date());
		   t.setPublished(false);
		   taskrepository.save(t);	   
	 }
	 /*
	 public void addTasks(EmpRequests req) {//add tasks for emp
	
		for(MTask temp:req.getTasks())
		{   Task t=new Task();
		    t.setManagerid(req.getManagerid());
	     	t.setEmpid(req.getEmpid());
		    t.setExpense_date(temp.getExpense_date());
			t.setBusiness_meal(temp.getBusiness_meal());
			t.setTotal_expense(temp.getTotal_exp());
			t.setHotel_stay(temp.getHotel_stay());
			t.setTravel_exp(temp.getTravel_exp());
			t.setTelephone_exp(temp.getTelephone_exp());
			t.setDescription(temp.getDescription());
			
			addTask(t);
		}
	 }
	 
	 public void addTasks(EmpRequests req) {
		 
		 Form f=new Form(req.getEmpid(),req.getManagerid(),req.getTotal_exp());
		 formrepository.save(f);
		 
		 int formid=1;
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
			 newt.setPublished(false);
			 newt.setExpense_date(new Date());
			 newt.setFormid(formid);
			 
			 taskrepository.save(newt);
			 
			 
		 }
		 
	 }*/
	 //for testing
	 public List<Task> getAllTasksOfEmp(int id){ //get all tasks of emp with empid
		   List<Task> emptasks=new ArrayList<Task>();
		   emptasks=taskrepository.findAllByEmpid(id);
			return emptasks;
			
			
	 }
	 ///
	 
	 public List<Task> FindByEmpidAndPublished(int empid) {//
			return taskrepository.findByEmpidAndPublished(empid);
			
	}  
	 public List<Task> getTasksForEmp(int empid,String tofetch) {//according to status with asc of published date//
		   if(tofetch.equals("all"))			   return taskrepository.findAllByEmpid(empid);         
		   else if(tofetch.equals("published"))	   return taskrepository.findByEmpidAndPublished(empid); 	
		   else 							 	   return taskrepository.getTasksForEmp(empid,tofetch); //for pending or approved
		   
	 }
	 
	  public void updateTask(Task t) { //for tasks editing by emp//
		   findandsetTask(t.getTaskid(),t);
	   }
	
	  /*
	  public void publishTask(int id,int taskid) {
		   taskrepository.publish(taskid);
	  }
	  */
	  public void publishTasks(int id,ArrayList<Integer> taskids) {//
		  for(int t : taskids) {
			  taskrepository.publish(t);
		  }
	  }
	  //for manager
	  
	  public List<Task> getTasksForManager(int id,String tofetch){ //get all tasks for manager with manager id//
			
			if(tofetch.equals("all")) return taskrepository.findAllByManagerid(id);
			else 					  return taskrepository.findByMidAndToFetch(id,tofetch) ; //with published=true
			
		}
	  
	 
	   public void updateTaskByManager(ManagerUpdate resp) {//
		  
		   Task temp=taskrepository.findByTaskid(resp.getTaskid());
		   
		   Date date=new Date();
		   temp.setPublished_date(date);;
		   temp.setStatus(resp.getStatus());
		   taskrepository.save(temp);
		   
		  
	   }
	   
	   public void findandsetTask(int taskid,Task t) {//
		   Task temp=taskrepository.findByTaskid(taskid);  
		   temp.setTaskid(taskid);
		   temp.setManagerid(t.getManagerid());
		   temp.setTravel_exp(t.getTravel_exp());
		   temp.setTelephone_exp(t.getTelephone_exp());
		   temp.setBusiness_meal(t.getBusiness_meal());
		   temp.setDescription(t.getDescription());
		   temp.setHotel_stay(t.getHotel_stay());
		   temp.setTotal_expense(t.getTotal_expense());
		   temp.setUpdated_date(new Date());
		   temp.setCreated_date(new Date());
		   temp.setPublished_date(new Date());
		   temp.setExpense_date(t.getExpense_date());
		   temp.setStatus("pending");
		   taskrepository.save(temp);
	   }	 
	
	    public List<Task> getTaskForFinance() {//
		// TODO Auto-generated method stub
		 return taskrepository.allApproved();
	   }

	   public void setPaid(int taskid){//
		   taskrepository.setPaid(taskid);
		   System.out.println(taskid);
	   }

		public List<Task> filterBy(int managerid,int month,int year) {//
			return taskrepository.filterBy(managerid,month,year);
			
		}	   
		
		/*
		public List<Task> filter(ArrayList<String> filterby,ArrayList<Integer> values){
			for(int i=0;i<filterby.size();i++) {
				taskrepository.filter(filterby.get(i),values.get(i));//to complete
			}
		}
       */
   
}
