package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.BugStatus;
import com.iris.userDao.BugStatusDao;

@Repository("bugStatusDao")
public class BugStatusDaoImpl implements BugStatusDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<BugStatus> getAllBugStatus() {
		try{
	        Session session=sessionFactory.getCurrentSession();
	        Query s=session.createQuery("from com.iris.model.BugStatus");
	        List<BugStatus> bgStatusList=s.list();
	        System.out.println("bug status list"+bgStatusList);
	        return bgStatusList;
			}
		catch (Exception e) {
	        e.printStackTrace();
		}

		return null;
}



	
	
}