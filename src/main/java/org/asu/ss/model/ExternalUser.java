package org.asu.ss.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "e_users")
public class ExternalUser {
	
	@Id
	@Column(name = "cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cust_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="l_name")
	private String l_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_carrier")
	private String mobile_carrier;
	
	@Column(name="acc_nos")
	private String acc_nos;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="trusted_ips")
	private String trusted_ips;
	
	@Column(name="trusted_devices")
	private String trusted_devices;
	
	@Column(name="org_name")
	private String org_name;
	
	@Column(name="org_id")
	private String org_id;
	
	@Column(name="ssn")
	private long ssn;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="last_login_time")
	private Date last_login_time;
	
	@Column(name="dob")
	private Date dob;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_carrier() {
		return mobile_carrier;
	}
	public void setMobile_carrier(String mobile_carrier) {
		this.mobile_carrier = mobile_carrier;
	}
	public String getAcc_nos() {
		return acc_nos;
	}
	public void setAcc_nos(String acc_nos) {
		this.acc_nos = acc_nos;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTrusted_ips() {
		return trusted_ips;
	}
	public void setTrusted_ips(String trusted_ips) {
		this.trusted_ips = trusted_ips;
	}
	public String getTrusted_devices() {
		return trusted_devices;
	}
	public void setTrusted_devices(String trusted_devices) {
		this.trusted_devices = trusted_devices;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String string) {
		this.mobile = string;
	}
	public java.util.Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public ExternalUser() {
		super();
	}
	
	public ExternalUser(long cust_id, String username, String password, String user_type, String f_name, String l_name,
			String email, String mobile_carrier, String acc_nos, String gender, String address, String trusted_ips,
			String trusted_devices, String org_name, String org_id, long ssn, String mobile, Date last_login_time,
			Date dob) {
		super();
		this.cust_id = cust_id;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.mobile_carrier = mobile_carrier;
		this.acc_nos = acc_nos;
		this.gender = gender;
		this.address = address;
		this.trusted_ips = trusted_ips;
		this.trusted_devices = trusted_devices;
		this.org_name = org_name;
		this.org_id = org_id;
		this.ssn = ssn;
		this.mobile = mobile;
		this.last_login_time = last_login_time;
		this.dob = dob;
	}
	
	
}
