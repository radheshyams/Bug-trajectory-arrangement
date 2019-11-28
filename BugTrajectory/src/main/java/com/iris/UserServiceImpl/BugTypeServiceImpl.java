package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.BugTypeService;
import com.iris.model.BugType;
import com.iris.userDao.BugTypeDao;

@Service("bugTypeService")
@Transactional
public class BugTypeServiceImpl implements BugTypeService {

	@Autowired
	BugTypeDao bugTypeDao;
	public List<BugType> getAllBugType() {
		
		return bugTypeDao.getAllBugType();
	}

}
