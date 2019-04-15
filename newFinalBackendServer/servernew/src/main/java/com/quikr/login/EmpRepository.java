package com.quikr.login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends CrudRepository<Emp,Integer>{
	
	public Emp findByEmpid(int empid);

}
