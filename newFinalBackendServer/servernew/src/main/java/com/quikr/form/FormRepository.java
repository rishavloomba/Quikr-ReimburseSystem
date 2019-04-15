package com.quikr.form;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quikr.task.Task;

public interface FormRepository extends CrudRepository<Form, Integer> {

	@Query(value = "SELECT * FROM Tform ORDER BY FORMID DESC LIMIT 1", nativeQuery = true)
	public Form getMaxFormId();

	@Query(value = "SELECT FORMID FROM Tform WHERE EMPID=?1", nativeQuery = true)
	public ArrayList<Integer> getAllFormIdsForEmp(int empid);

	@Query(value = "SELECT FORMID FROM Tform WHERE EMPID=?1 AND STATUS LIKE ?2 AND PUBLISHED=TRUE", nativeQuery = true)
	public ArrayList<Integer> getAllFormIdsForEmp(int empid, String tofetch);

	@Query(value = "SELECT FORMID FROM Tform WHERE MANAGERID=?1 AND PUBLISHED=TRUE", nativeQuery = true)
	public ArrayList<Integer> getAllFormIdsForManager(int managerid);

	@Query(value = "SELECT FORMID FROM Tform WHERE MANAGERID=?1 AND PUBLISHED=TRUE AND STATUS LIKE ?2", nativeQuery = true)
	public ArrayList<Integer> getAllFormIdsForManager(int mangerid, String tofetch);

	@Query(value = "SELECT EMPID FROM Tform WHERE FORMID=?1", nativeQuery = true)
	public int getEmpId(int formid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Tform SET PUBLISHED=TRUE WHERE FORMID=?1", nativeQuery = true)
	public void publish(int formid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Tform SET STATUS=?3 WHERE FORMID=?1", nativeQuery = true)
	public void managerFormUdpate(int formid, int managerid, String status);
}
