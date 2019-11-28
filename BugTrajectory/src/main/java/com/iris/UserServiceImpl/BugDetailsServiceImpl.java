package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.BugDetailsService;
import com.iris.model.BugDetails;
import com.iris.userDao.BugDetailsDao;


@Service("bugDetailsService")
@Transactional
public class BugDetailsServiceImpl implements BugDetailsService {
	
	@Autowired
	BugDetailsDao bugDetailsDao;
	public boolean saveBugAllocationByTeater(BugDetails bugDetailObj) {
		
		return bugDetailsDao.saveBugAllocationByTeater(bugDetailObj);
	}
	public BugDetails getBugDetailsById(int bugAllocateId) {
		
		return bugDetailsDao.getBugDetailsById(bugAllocateId);
	}
	public boolean updateBugDetail(BugDetails bugDetailObject) {
		
		return bugDetailsDao.updateBugDetail(bugDetailObject);
	}
	public List<BugDetails> getBugDetail(int user_Id) {
		
		return bugDetailsDao.getBugDetail(user_Id);
	}

}
