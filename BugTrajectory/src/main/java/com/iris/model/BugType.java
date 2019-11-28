package com.iris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Type")
public class BugType {
	
	@Id
	@Column(name="bug_Type_Id")
	private String bugTypeId;
	@Column(name="bug_Type_Name")
	private String bugTypeName;
	public String getBugTypeId() {
		return bugTypeId;
	}
	public void setBugTypeId(String bugTypeId) {
		this.bugTypeId = bugTypeId;
	}
	public String getBugTypeName() {
		return bugTypeName;
	}
	public void setBugTypeName(String bugTypeName) {
		this.bugTypeName = bugTypeName;
	}
	@Override
	public String toString() {
		return "BugType [bugTypeId=" + bugTypeId + ", bugTypeName=" + bugTypeName + "]";
	}
	

}
