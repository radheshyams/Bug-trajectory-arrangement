package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.BugType;
import com.iris.userDao.BugTypeDao;
@Repository("bugTypeDao")
public class BugTypeDaoImpl implements BugTypeDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<BugType> getAllBugType() {
		
		try{
            Session session=sessionFactory.getCurrentSession();
            Query b=session.createQuery("from com.iris.model.BugType");
            List<BugType> bgTypeList=b.list();
            return bgTypeList;
			}
		catch (Exception e) {
            e.printStackTrace();
		}

		return null;
}
}
