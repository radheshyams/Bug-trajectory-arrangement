package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.BugDetails;
import com.iris.userDao.BugDetailsDao;

@Repository("bugDetailsDao")
public class BugDetailsDaoImpl implements BugDetailsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean saveBugAllocationByTeater(BugDetails bugDetailObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(bugDetailObj);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public BugDetails getBugDetailsById(int bugAllocateId) {
		try {
            Session session=sessionFactory.getCurrentSession();
            BugDetails bugDetailObj=session.get(BugDetails.class,bugAllocateId);
            return bugDetailObj;
     }
     catch (Exception e) {
            e.printStackTrace();
     }

		return null;
	}
	public boolean updateBugDetail(BugDetails bugDetailObject) {
		try {
			 Session session=sessionFactory.getCurrentSession();
			 session.update(bugDetailObject);
			 System.out.println("object founf for saving"+bugDetailObject);
			 return true;
		}
		catch (Exception e) {
            e.printStackTrace();
     }
		
		return false;
	}
	public List<BugDetails> getBugDetail(int user_Id) {
        try{
        Session session=sessionFactory.getCurrentSession();
    	Query q=session.createQuery("from com.iris.model.BugDetails where user_Id=:user_Id");
    	q.setParameter("user_Id",user_Id);
    	List<BugDetails> bugList=q.list();
    	return bugList;
        }catch (Exception e) {
        e.printStackTrace();
        }
        return null;
 }


}
