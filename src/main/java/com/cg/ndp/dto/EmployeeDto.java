package com.cg.ndp.dto;

public class EmployeeDto {

	private int employeeId;
	private String password;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(int employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", password=" + password + "]";
	}
	
}
