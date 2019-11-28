package com.iris.UserService;

import java.util.List;

import com.iris.model.BugDetails;

public interface BugDetailsService {
	public boolean saveBugAllocationByTeater(BugDetails bugDetailObj);
	public BugDetails getBugDetailsById(int bugAllocateId);
	public boolean updateBugDetail(BugDetails bugDetailObject);
	public List<BugDetails> getBugDetail(int user_Id);
}
