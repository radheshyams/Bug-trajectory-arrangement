package com.iris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Severity")
public class Severity {
	
	@Id
	@Column(name="sev_Id")
	private String sevId;
	@Column(name="sev_Type")
	private String sevType;
	public String getSevId() {
		return sevId;
	}
	public void setSevId(String sevId) {
		this.sevId = sevId;
	}
	public String getSevType() {
		return sevType;
	}
	public void setSevType(String sevType) {
		this.sevType = sevType;
	}
	@Override
	public String toString() {
		return "Severity [sevId=" + sevId + ", sevType=" + sevType + "]";
	}
	

}
