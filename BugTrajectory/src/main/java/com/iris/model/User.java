package com.iris.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Valid_user")
public class User {
	@Id
	private int user_Id;
	private String user_Name;
	private String password;
	private String role;
	@Column(name="Email")
	private String email;
	
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Project_Allocation_table",
	joinColumns={@JoinColumn(name="user_Id")},
	inverseJoinColumns = { @JoinColumn(name = "project_id") })
	private List<Project> projects=new ArrayList<Project>();
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLoginId() {
		return email;
	}
	public void setLoginId(String loginId) {
		this.email = loginId;
	}

	
	

}
