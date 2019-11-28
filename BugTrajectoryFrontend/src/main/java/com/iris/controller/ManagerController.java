package com.iris.controller;

import java.util.ArrayList;
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
import com.iris.UserService.ProjectService;
import com.iris.UserService.UserService;
import com.iris.model.BugDetails;
import com.iris.model.BugStatus;
import com.iris.model.Project;
import com.iris.model.User;

@Controller
public class ManagerController {
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
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

	
	@RequestMapping(value="/Manager",method=RequestMethod.POST)
	  public ModelAndView getProjectAllocation(@RequestParam String project,@RequestParam int[] Developer,@RequestParam int[] Tester,ModelMap map){

			if(checkSession(map)) {
				return new ModelAndView("Login");
				}
        
	       Project pObj=projectService.getProjectById(project);
	       
	         List<User> usersList=pObj.getUser();
	              
	              for(int i:Developer) {
	                     
	                     User uObj=userService.getUserById(i);

	                     uObj.getProjects().add(pObj);
	                     
	                     usersList.add(uObj);
	                     }
	              
	              for(int i:Tester) {
	                     User uObj=userService.getUserById(i);
	                     uObj.getProjects().add(pObj);
	                     usersList.add(uObj);
	              }
	              
	              pObj.setUser(usersList);
	              
	              try {
	                projectService.updateProject(pObj);
	                map.addAttribute("msg","Project Allocated to developer and tester");
	              }
	              catch (Exception e) {
	            	  map.addAttribute("msg","Project Allocated has already been allocated to developer and tester");
				}
	              
	   
		
		List<Project> prList=projectService.getAllProject();
	
		List<User> deList=userService.getAllDev();
	
		List<User> tsList=userService.getAllTest();
		
		ModelAndView mv=new ModelAndView("ManagerPage");
		mv.addObject("proList",prList);
		mv.addObject("devList",deList);
		mv.addObject("tstList",tsList);
		return mv;
	}
	@RequestMapping(value="/ViewReportedBug",method=RequestMethod.GET)
	public ModelAndView getBug(ModelMap map){
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
		List<BugDetails>bgdetailList=bugStatusUpdateservice.getAllotedBugToUpdate();
		
		ModelAndView mv=new ModelAndView("ViewReportedBug");
		
		mv.addObject("bugDetailList",bgdetailList);
	return mv;

}
	
	@RequestMapping(value="/assignBug/{bugAllocateId}",method=RequestMethod.GET)
	public ModelAndView bugAssigning(@PathVariable("bugAllocateId")int bugAllocateId,ModelMap map)
		{	
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
			BugDetails bugDetailObj=bugDetailsService.getBugDetailsById(bugAllocateId);
			List<BugStatus> bgStatusList=bugStatusService.getAllBugStatus();
			Project pObj=projectService.getProjectById(bugDetailObj.getProjectId());
            List<User> usersList=pObj.getUser();
            List<User> developersList=new ArrayList<>();
            
            for(User userObj:usersList) {
                   if(userObj.getRole().equals("Developer")) {
                         developersList.add(userObj);
                   }
                   
            }
			ModelAndView mv=new ModelAndView("BugToDeveloper");
			mv.addObject("bugDetailsObject",bugDetailObj);
			System.out.println("Get The bug Details "+bugDetailObj);
			mv.addObject("bugStatusList",bgStatusList);
			mv.addObject("devList",developersList);
			return mv;
		}
    @RequestMapping(value="/assigned",method=RequestMethod.GET)
    public ModelAndView bugAssignedToDeveloper(@RequestParam int bugAllocateId,@RequestParam int userId,@RequestParam String projectId,@RequestParam String statusId,@RequestParam("plannedStartdate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date plannedStartdate,@RequestParam("plannedEndDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date plannedEndDate,ModelMap map)
    { 
    	if(checkSession(map)) {
			return new ModelAndView("Login");
			}
    	 System.out.println("Not Found AnyThing");
           BugDetails bugDetailObject=bugDetailsService.getBugDetailsById(bugAllocateId);
           bugDetailObject.setProjectId(projectId);
           bugDetailObject.setStatusId(statusId);
           bugDetailObject.setUserId(userId);
           bugDetailObject.setPlannedStartdate(plannedStartdate);
           bugDetailObject.setPlannedEndDate(plannedEndDate);
          
           bugDetailsService.updateBugDetail(bugDetailObject);
           ModelAndView mv=new ModelAndView("ViewReportedBug");
           List<BugDetails>bgdetailList=bugStatusUpdateservice.getAllotedBugToUpdate();
           mv.addObject("bugDetailList",bgdetailList);
           return mv;
    }



}
