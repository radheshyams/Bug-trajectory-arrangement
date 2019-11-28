package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.BugStatusService;
import com.iris.model.BugStatus;
import com.iris.userDao.BugStatusDao;

@Transactional
@Service("bugStatusService")
public class BugStatusServiceImpl implements BugStatusService {

	@Autowired
	BugStatusDao bugStatusDao;
	public List<BugStatus> getAllBugStatus() {
		
		return bugStatusDao.getAllBugStatus();
	}

}
