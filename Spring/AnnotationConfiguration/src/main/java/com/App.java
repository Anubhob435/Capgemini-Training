package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(DatabaseProperties.class);
        String[] beanDefinitionNames= context.getBeanDefinitionNames();
        		for (String names : beanDefinitionNames) {
					System.out.println(names);
				}
        		EmployeeDatabaseopeation operation = context.getBean(EmployeeDatabaseopeation.class);
        		operation.insertEmployeeDetails();
    }
}