package com.iris.UserService;

import java.util.List;

import com.iris.model.Project;

public interface ProjectService {
	public List<Project> getAllProject();
	public Project getProjectById(String projectId);
	public boolean updateProject(Project pObj);

}
