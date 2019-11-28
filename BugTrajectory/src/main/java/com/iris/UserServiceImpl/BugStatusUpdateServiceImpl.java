package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.BugStatusUpdateService;
import com.iris.model.BugDetails;

import com.iris.userDao.BugStatusUpdateDao;
@Service("bugStatusUpdateservice")
@Transactional
public class BugStatusUpdateServiceImpl implements BugStatusUpdateService {
	@Autowired
	BugStatusUpdateDao bugStatusUpdateDao;
	public List<BugDetails> getAllotedBugToUpdate() {
		
		return bugStatusUpdateDao.getAllotedBugToUpdate();
	}

}
