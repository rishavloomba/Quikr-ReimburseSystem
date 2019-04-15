package com.quikr.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empS;

	@RequestMapping("/login/{empid}")
	public Emp getEmpById(@PathVariable("empid") int empid) {
		
		return empS.getEmpByEmpId(empid);
	}
}
