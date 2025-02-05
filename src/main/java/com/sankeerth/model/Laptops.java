package com.sankeerth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int pcost;
	private int pqty;
	private String pimage;
	public Laptops() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptops(int pid, String pname, int pcost, int pqty, String pimage) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pqty = pqty;
		this.pimage = pimage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	@Override
	public String toString() {
		return "Laptops [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pqty=" + pqty + ", pimage=" + pimage
				+ "]";
	}
	
	
	
	
}
