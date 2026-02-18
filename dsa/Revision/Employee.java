package dsa.Revision;

import java.time.*;

public class Employee {
	private int employeeid;
	private String employeename;
	private String email;
	private long phone;
	private String gender;
	private LocalDate dateofBirth;
	private LocalTime timeofBirth;
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(int employeeid, String employeename, String email, long phone, String gender, LocalDate dateofBirth,
			LocalTime timeofBirth, double salary) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.dateofBirth = dateofBirth;
		this.timeofBirth = timeofBirth;
		this.salary = salary;
	}


	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public LocalTime getTimeofBirth() {
		return timeofBirth;
	}
	public void setTimeofBirth(LocalTime timeofBirth) {
		this.timeofBirth = timeofBirth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}