package com.quikr.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository emprepository;
	
	public Emp getEmpByEmpId(int empid) {
		
		return emprepository.findByEmpid(empid);
	}

}
