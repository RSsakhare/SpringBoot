package com.bean;

import jakarta.persistence.*;

@Entity
@Table(name="Emp")
public class Employee {

	@Id
	@Column(name="eid",length = 5)
	int eid;
	@Column(name="ename",length = 20)
	String ename;
	@Column(name="esal",length = 7)
	int esal;
	public Employee()
	{
		super();
		
	}
	public Employee(int eid, String ename, int esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
}
