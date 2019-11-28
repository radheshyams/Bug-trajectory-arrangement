package com.iris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bug_Status")
public class BugStatus {
	
	@Id
	@Column(name="status_id")
	private String id;
	@Column(name="status_Name")
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BugStatus [id=" + id + ", name=" + name + "]";
	}

}
