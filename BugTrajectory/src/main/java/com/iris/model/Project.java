package com.iris.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project {
	@Id
	@Column(name="project_id")
	private String pId;
	
	@Column(name="project_name")
	private String pName;
	
	 @ManyToMany(mappedBy="projects",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	 private List<User> user = new ArrayList<User>();

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", pName=" + pName + ", user=" + user + "]";
	}

	
	 
	 
	
}
