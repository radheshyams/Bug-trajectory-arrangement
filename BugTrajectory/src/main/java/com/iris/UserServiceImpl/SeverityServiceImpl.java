package com.iris.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.UserService.SeverityService;
import com.iris.model.Severity;
import com.iris.userDao.SeverityDao;
@Transactional
@Service("severityService")
public class SeverityServiceImpl implements SeverityService {

	@Autowired
	SeverityDao severityDao;
	public List<Severity> getAllSev() {
		
		return severityDao.getAllSev();
	}

}
