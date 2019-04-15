package com.quikr.form;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quikr.form.requests.EmpRequest;
import com.quikr.form.requests.FormPublish;
import com.quikr.form.requests.FormUpdate;
import com.quikr.form.requests.ManagerFormUpdate;
import com.quikr.requests.FetchReq;
import com.quikr.requests.MTask;
import com.quikr.task.Task;

@RestController
public class FormController {
	@Autowired
	FormService formservice;
	
	@RequestMapping("/formhi")
	public String formhi() {
		return "formhi";
	}
	
	@RequestMapping("/Forms")  //gives FORMS  in form of ArrayList<ArrayList<Task>>
	public ArrayList<ArrayList<Task>> Forms(@RequestBody FetchReq req)
	{
		return formservice.getForms(req.getId(),req.getTofetch());
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/Forms/addForm")
	public void addForm(@RequestBody EmpRequest req) {
		formservice.addForm(req);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Form/updateForm")
	public void updateForm(@RequestBody FormUpdate req) {
		formservice.updateForm(req);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Form/publish")
	public void publishForm(@RequestBody FormPublish topublish) {
		formservice.toPublish(topublish.getFormid());
	}
	/*
	@RequestMapping("/Forms/manager")
	public ArrayList<ArrayList<Task>> managerView(@RequestBody FetchReq req) {
		return formservice.getViewForManager(req.getId(),req.getTofetch());
	}
	*/
	/*
	@RequestMapping("/Forms/manager")
	public ArrayList<ArrayList<Task>> managerView(@RequestBody FetchReq req) {
		return formservice.getViewForManager(req.getId(),req.getTofetch());
	}*/

	@RequestMapping("/Form/manager")
	public Map<Integer,Map<Integer,ArrayList<MTask>>>  managerView(@RequestBody FetchReq req){
		
		return formservice.getViewForManager(req.getId(), req.getTofetch());
	}
	/*
	@RequestMapping("Forms/manager/updateForm")
	public void managerUpdate(@RequestBody ManagerFormUpdate req) {
		formservice.managerFormUpdate(req.getFormid(),req.getManagerid(),req.getStatus());
	}
	*/
}
