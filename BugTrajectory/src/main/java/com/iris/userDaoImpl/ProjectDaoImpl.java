package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.Project;
import com.iris.model.User;
import com.iris.userDao.ProjectDao;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Project> getAllProjects() {
		try{
            Session session=sessionFactory.getCurrentSession();
            Query r=session.createQuery("from com.iris.model.Project");
            List<Project> prList=r.list();
            return prList;
			}
		catch (Exception e) {
            e.printStackTrace();
		}

		return null;
	}

	public Project getProjectById(String projectId) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			Project pObj=session.get(Project.class,projectId);
			return pObj;
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		return null;
	}

	public boolean updateProject(Project pObj) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(pObj);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		return false;
	}

}
