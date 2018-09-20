package com.sony;

import org.springframework.stereotype.Component;

@Component
public class Employee 
{
	private String ename;
	private int epoints;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEpoints() {
		return epoints;
	}
	public void setEpoints(int epoints) {
		this.epoints = epoints;
	}
	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", epoints=" + epoints + "]";
	}
	
}
