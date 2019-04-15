package com.quikr.task;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer>{

	public List<Task> findByManagerid(int id) ;
	
	public List<Task> findAllByEmpid(int id);

	public Task findByTaskid(int taskid);

	public List<Task> findAllByManagerid(int id);
	
	@Query(value="SELECT * FROM Tasks WHERE EMPID=?1 AND STATUS LIKE ?2 ORDER BY PUBLISHED_DATE",nativeQuery= true)//
	public List<Task> getTasksForEmp(int empid,String status);
	
	@Query(value = "SELECT * FROM Tasks WHERE EMPID= ?1 AND PUBLISHED=TRUE", nativeQuery = true)
	public List<Task> findByEmpidAndPublished(int empid);
	
	@Query(value="SELECT * FROM Tasks WHERE PUBLISHED=TRUE AND STATUS LIKE 'approved' ",nativeQuery= true)
	public List<Task> accStatusAndPublished();
	
	@Query(value="SELECT * FROM Tasks WHERE STATUS LIKE 'approved' ",nativeQuery=true)
	public List<Task> allApproved() ;
	

	@Query(value="SELECT * FROM Tasks WHERE MANAGERID=?1 AND MONTH(PUBLISHED_DATE)=?2 AND YEAR(PUBLISHED_DATE)=?3 ",nativeQuery=true) //group by pending
	public List<Task> filterBy(int managerid, int month,int year);
	
	@Modifying
	@Transactional   //for publishing task
	@Query(value="UPDATE Tasks SET PUBLISHED=TRUE WHERE TASKID=?1",nativeQuery=true)
	public void  publish(int taskid);
	
	@Modifying
	@Transactional   //for setting paid column
	@Query(value="UPDATE Tasks SET PAID=TRUE WHERE TASKID=?1",nativeQuery=true)
	public void  setPaid(int taskid);
	
	@Query(value="SELECT * FROM Tasks WHERE MANAGERID=?1 AND PUBLISHED=TRUE AND STATUS=?2 ",nativeQuery=true)
	public List<Task> findByMidAndToFetch(int id,String tofetch);
	
	/*
    @Query(value="SELECT * FROM Tasks WHERE ?1=")
    public List<Task> filter(ArrayList<String> filterby,ArrayList<Integer> values);   
    */
	
	
	////
	@Query(value="SELECT * FROM Tasks WHERE FORMID=?1",nativeQuery=true)
	public ArrayList<Task> getFormTasks(int formid);
	
	@Modifying
	@Transactional 
	  @Query(value="DELETE FROM Tasks WHERE FORMID=?1 ",nativeQuery=true)
	   public void deleteAllWithFormId(int formid);
}
