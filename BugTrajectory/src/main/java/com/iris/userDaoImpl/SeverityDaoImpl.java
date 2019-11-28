package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.Severity;
import com.iris.userDao.SeverityDao;
@Repository("severityDao")
public class SeverityDaoImpl implements SeverityDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Severity> getAllSev() {
		
		try{
            Session session=sessionFactory.getCurrentSession();
            Query s=session.createQuery("from com.iris.model.Severity");
            List<Severity> sevList=s.list();
            return sevList;
			}
		catch (Exception e) {
            e.printStackTrace();
		}

		return null;
	}

}
