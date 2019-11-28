package com.iris.userDao;

import java.util.List;

import com.iris.model.Project;

public interface ProjectDao {
	public List<Project> getAllProjects();
	public Project getProjectById(String projectId);
	public boolean updateProject(Project pObj);

}
