package org.asu.ss.model;

import javax.persistence.Entity;

@Entity
public class CustomerDetail {
	
	public CustomerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDetail(long cust_id) {
		super();
		this.cust_id = cust_id;
	}

	long cust_id;

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	
	

}
