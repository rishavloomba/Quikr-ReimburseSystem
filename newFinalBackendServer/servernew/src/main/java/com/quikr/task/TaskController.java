package com.quikr.task;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quikr.requests.EmpPublish;
import com.quikr.requests.FetchReq;
import com.quikr.requests.FilterReq;
import com.quikr.requests.FinanceUpdate;
import com.quikr.requests.ManagerUpdate;
//import com.quikr.requests.Tasks;




@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskservice;
	
	@RequestMapping("/tasks")  
	public List<Task> getAllTasks(){
		return taskservice.getAllTasks();
	}
	
	//employees mappings
	
	@RequestMapping(value="/tasks/emp") //get tasks acc tofetch - all, pending , approved, published 
	public List<Task> getTasksForEmp(@RequestBody FetchReq req) {
		return taskservice.getTasksForEmp(req.getId(),req.getTofetch());
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/tasks/emp/addTask") //emp add task
	public void addTask(@RequestBody Task task) {
		taskservice.addTask(task);
	}
	/*
	@RequestMapping(method=RequestMethod.POST ,value="/tasks/emp/addTasks")
	public void addTasks(@RequestBody EmpRequests req) {
		taskservice.addTasks(req);
	}*/
	
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/tasks/emp/updateTask") //emp update task
	public void updateTask(@RequestBody Task task){
		taskservice.updateTask(task);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="tasks/emp/publish")//emp publish tasks
	public void publishAll(@RequestBody EmpPublish req) {
		taskservice.publishTasks(req.getEmpid(),req.getTopublish());
	}
	
	//manager mappings

	@RequestMapping("/tasks/manager") //for managers tofetch- pending ,approved,all
	public List<Task> getTasksForManager(@RequestBody FetchReq req){
		return taskservice.getTasksForManager(req.getId(),req.getTofetch());
	
	}

	@RequestMapping(method=RequestMethod.PUT,value="/tasks/manager/updateTask")//for updating status of task
	public void updateTaskByManager(@RequestBody ManagerUpdate req){
		taskservice.updateTaskByManager(req);	
	}
	

	
	@RequestMapping("tasks/finance")//show all tasks that are approved by manager
	public List<Task> getTasksForFinance(){
		return taskservice.getTaskForFinance();
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="tasks/finance/paid/")//for finance to pay
	public void setPaid(@RequestBody FinanceUpdate req) {
		taskservice.setPaid(req.getTaskid());
	}
	
	@RequestMapping("tasks/manager/filter")
	public List<Task> groupByMonth(@RequestBody FilterReq req){
		return taskservice.filterBy(req.getId(),req.getMonth(),req.getYear());
		
	}
	
	/*
	@RequestMapping("tasks/manager/filter") //to complete
	public List<Task> filterBy(@RequestBody Filter filter) {
		return taskservice.filter(filter.getFilterby(),filter.getValues());
	}
	*/
	
	
}

