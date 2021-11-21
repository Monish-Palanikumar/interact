package com.hcl.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "iid")
	private Integer iid;

	@Column(name = "sid")
	private Integer sid;

	@Column(name = "start")
	private Time start;

	@Column(name = "end")
	private Time end;

	public Booking() {
		super();
	}

	public Booking(Integer iid, Integer sid, Time start, Time end) {
		super();
		this.iid = iid;
		this.sid = sid;
		this.start = start;
		this.end = end;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", iid=" + iid + ", sid=" + sid + ", start=" + start + ", end=" + end + "]";
	}

}
