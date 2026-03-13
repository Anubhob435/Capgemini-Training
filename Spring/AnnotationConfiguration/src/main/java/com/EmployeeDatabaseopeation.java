package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com" )
public class EmployeeDatabaseopeation {
	
	public EmployeeDatabaseopeation(){
		System.out.println("Creation of bean");
	}
	
	public void insertEmployeeDetails() {
		
	}
}