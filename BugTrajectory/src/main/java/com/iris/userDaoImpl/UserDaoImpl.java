package com.iris.userDaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.model.User;
import com.iris.userDao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public User validateUser(String email, String password) {
		try {
			
		Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from com.iris.model.User where email=:email and password=:password");
        query.setParameter("email",email);
        query.setParameter("password", password);
        List<User> userList=query.list();
        if (userList!=null ) {
                     return userList.get(0);
              }
        
        else {
             
              session.close();
        	}

			}
			catch (Exception e) {
					e.printStackTrace();
				}
			return null;
	}


	public List<User> getAllDev() {
		try{
            Session session=sessionFactory.getCurrentSession();
         Query p=session.createQuery("from com.iris.model.User where role='Developer'");
         List<User> deList=p.list();
         return deList;
			}
		catch (Exception e) {
            e.printStackTrace();
		}

		return null;
	}
	public List<User> getAllTest() {
		try{
            Session session=sessionFactory.getCurrentSession();
         Query q=session.createQuery("from com.iris.model.User where role='Tester'");
         List<User> tsList=q.list();
         return tsList;
			}
		catch (Exception e) {
            e.printStackTrace();
		}

		return null;
	}

	public User getUserById(int userId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User userObj=session.get(User.class,userId);
			return userObj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
