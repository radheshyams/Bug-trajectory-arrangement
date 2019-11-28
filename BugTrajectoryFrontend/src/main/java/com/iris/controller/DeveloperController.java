package com.iris.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.UserService.BugDetailsService;
import com.iris.UserService.BugStatusService;
import com.iris.UserService.BugStatusUpdateService;
import com.iris.model.BugDetails;
import com.iris.model.BugStatus;
import com.iris.model.User;

@Controller
public class DeveloperController {
	@Autowired
	BugStatusService bugStatusService;
	@Autowired
	BugStatusUpdateService bugStatusUpdateservice;
	@Autowired
	BugDetailsService bugDetailsService;
	@Autowired
	HttpSession session;
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null) {
		map.addAttribute("msg","Session doesnt exist.. Login First");
		return true;
		}
		return false;
		}
	
	@RequestMapping(value="/assignBug",method=RequestMethod.GET)
	public ModelAndView getBug(ModelMap map){
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		
	       User userObj=(User) session.getAttribute("uObj");
	       		int user_Id=userObj.getUser_Id();
	       		List<BugDetails> bugList=bugDetailsService.getBugDetail(user_Id);
	    

	       		System.out.println("Bug List Corresponding................. "+bugList);
		
	       		ModelAndView mv=new ModelAndView("AssignBugToDeveloper");
	       		mv.addObject("AssignedBugDetail", bugList);
		  
		
	return mv;
	}
	@RequestMapping(value="/UpdateBugStatus/{bugAllocateId}",method=RequestMethod.GET)
	public ModelAndView getUpdateBugStatus(@PathVariable int bugAllocateId,ModelMap map){
		
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		
		BugDetails bugDetails=bugDetailsService.getBugDetailsById(bugAllocateId);
		
		
		System.out.println("Bug Allocated Id : "+bugAllocateId);
		List<BugStatus>bgStatusList=bugStatusService.getAllBugStatus();
		
		
		 ModelAndView mv=new ModelAndView("UpdateBugStatus");
		 mv.addObject("bgstusList",bgStatusList);
		 mv.addObject("bgDetail", bugDetails);
		 return mv;
		
		
	}@RequestMapping(value="/fixbug",method=RequestMethod.GET)
	   public ModelAndView bugAssigned(@RequestParam int bugAllocateId,@RequestParam String projectId,@RequestParam String status,@RequestParam("actualStartDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date actualStartDate,@RequestParam("actualEndDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date actualEndDate,ModelMap map)
	   { 
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}

	      
	       BugDetails bugAssign=bugDetailsService.getBugDetailsById(bugAllocateId);
	       bugAssign.setProjectId(projectId);
	       bugAssign.setStatusId(status);
	       bugAssign.setActualStartDate(actualStartDate);
	       bugAssign.setActualEndDate(actualEndDate);
	       bugDetailsService.updateBugDetail(bugAssign);
	      
	       
	       User userObj=(User) session.getAttribute("uObj");
      		
	       int user_Id=userObj.getUser_Id();
      		List<BugDetails> bugList=bugDetailsService.getBugDetail(user_Id);
   

      		System.out.println("Bug List Corresponding................. "+bugList);
	
      		ModelAndView mv=new ModelAndView("AssignBugToDeveloper");
      		mv.addObject("AssignedBugDetail", bugList);
      		return mv;
	       //return new  ModelAndView("AssignedBugToDeveloper");
	   }

}
