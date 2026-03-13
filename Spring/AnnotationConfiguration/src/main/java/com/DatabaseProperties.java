package com;

import org.springframework.stereotype.Component;

@Component("dbproperties")
public class DatabaseProperties {
	
		public DatabaseProperties() {
			System.out.println("Object is created");
		}
		
		public String mysqlProperties() {
			return "jdbc:mysql://localhost:3306?user=root&password=admin";
		}
}
