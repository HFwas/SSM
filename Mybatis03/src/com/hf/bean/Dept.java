package com.hf.bean;

import java.util.List;

public class Dept {
	
	private Integer did;
	private String dname;
	private List<Dept> emps;
	public List<Dept> getEmps() {
		return emps;
	}
	public void setEmps(List<Dept> emps) {
		this.emps = emps;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + ", emps=" + emps + "]";
	}
	
}
