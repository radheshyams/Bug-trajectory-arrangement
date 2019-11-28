package com.iris.userDao;

import java.util.List;

import com.iris.model.BugDetails;

public interface BugStatusUpdateDao {
	public List <BugDetails> getAllotedBugToUpdate();

}
