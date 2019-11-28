package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.BugDetails;

import com.iris.userDao.BugStatusUpdateDao;
@Repository("bugStatusUpdateDao")
public class BugStatusUpdateDaoImpl implements BugStatusUpdateDao {
	@Autowired
	SessionFactory sessionFactory;
		
	public List <BugDetails> getAllotedBugToUpdate() {
		try{
	        Session session=sessionFactory.getCurrentSession();
	        Query b=session.createQuery("from com.iris.model.BugDetails");
	        List<BugDetails> bgdetailList=b.list();
	       
	        return bgdetailList;
			}
		catch (Exception e) {
	        e.printStackTrace();
		}

		return null;
		
	
	}
}
