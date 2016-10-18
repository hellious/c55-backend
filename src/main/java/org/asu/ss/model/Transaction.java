package org.asu.ss.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@Column(name = "t_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long t_id;

	@Column(name = "from_acc")
	private long from_acc;

	@Column(name = "to_acc")
	private long to_acc;

	@Column(name = "t_timestamp")
	private Time t_timestamp;

	@Column(name = "t_amount")
	private double t_amount;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "severity")
	private String severity;

	public long getT_id() {
		return t_id;
	}

	public void setT_id(long t_id) {
		this.t_id = t_id;
	}

	public long getFrom_acc() {
		return from_acc;
	}

	public void setFrom_acc(long from_acc) {
		this.from_acc = from_acc;
	}

	public long getTo_acc() {
		return to_acc;
	}

	public void setTo_acc(long to_acc) {
		this.to_acc = to_acc;
	}

	public Time getT_timestamp() {
		return t_timestamp;
	}

	public void setT_timestamp(Time t_timestamp) {
		this.t_timestamp = t_timestamp;
	}

	public double getT_amount() {
		return t_amount;
	}

	public void setT_amount(double t_amount) {
		this.t_amount = t_amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Transaction() {
		super();
	}

	public Transaction(long t_id, long from_acc, long to_acc, Time t_timestamp, double t_amount, String remarks,
			String severity) {
		super();
		this.t_id = t_id;
		this.from_acc = from_acc;
		this.to_acc = to_acc;
		this.t_timestamp = t_timestamp;
		this.t_amount = t_amount;
		this.remarks = remarks;
		this.severity = severity;
	}
}
