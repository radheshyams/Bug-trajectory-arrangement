package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.ProjectService;
import com.iris.model.Project;
import com.iris.userDao.ProjectDao;

@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDao projectDao;
	public List<Project> getAllProject() {
		
		try {
			return projectDao.getAllProjects();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}
	public Project getProjectById(String projectId) {
		
		return projectDao.getProjectById(projectId);
	}
	public boolean updateProject(Project pObj) {
			
		return projectDao.updateProject(pObj);
	}

}
