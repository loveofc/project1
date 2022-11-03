package com.j.dto;

public class StoreDTO {
	String storename;
	String phone;
	String newaddr;
	String oldaddr;
	String runtime;
	String sub1;
	String sub2;
	
	public StoreDTO(){}
	public StoreDTO(String storename,String phone,String newaddr,
	String oldaddr,String runtime,	String sub1,String sub2) {
		this.storename=storename;
		this.phone=phone;
		this.newaddr=newaddr;
		this.oldaddr=oldaddr;
		this.runtime=runtime;
		this.sub1=sub1;
		this.sub2=sub2;
	}
	
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNewaddr() {
		return newaddr;
	}
	public void setNewaddr(String newaddr) {
		this.newaddr = newaddr;
	}
	public String getOldaddr() {
		return oldaddr;
	}
	public void setOldaddr(String oldaddr) {
		this.oldaddr = oldaddr;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtimme) {
		this.runtime = runtimme;
	}
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	
}
