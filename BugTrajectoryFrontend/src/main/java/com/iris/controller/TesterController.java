package com.iris.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.UserService.BugDetailsService;
import com.iris.UserService.BugStatusService;
import com.iris.UserService.BugTypeService;
import com.iris.UserService.ProjectService;
import com.iris.UserService.SeverityService;
import com.iris.model.BugDetails;
import com.iris.model.BugStatus;
import com.iris.model.BugType;
import com.iris.model.Project;
import com.iris.model.Severity;
import com.iris.model.User;

@Controller
public class TesterController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	SeverityService severityService;
	@Autowired
	BugTypeService bugTypeService;
	
	@Autowired
	BugStatusService bugStatusService;
	
	@Autowired
	BugDetailsService bugDetailsService;
	
	@Autowired
	ProjectService projectService;
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null) {
		map.addAttribute("msg","Session doesnt exist.. Login First");
		return true;
		}
		return false;
		}

	
	@RequestMapping(value="/BugAllocate/{pId}",method=RequestMethod.GET)
	public ModelAndView getBug(@PathVariable("pId")String pId,@RequestParam(name="msg",required=false)String msg,ModelMap map){
		
		if(checkSession(map)) {
			return new ModelAndView("Login");
			}
    
		List<Severity> sevList=severityService.getAllSev();
		List<BugType> bgTypeList=bugTypeService.getAllBugType();
		List<BugStatus> bgStatusList=bugStatusService.getAllBugStatus();
		User uObj=(User)session.getAttribute("uObj");
		
		
		ModelAndView mv=new ModelAndView("BugAllocate");
		mv.addObject("seList", sevList);
		mv.addObject("bgList", bgTypeList);
		mv.addObject("bgstusList", bgStatusList);
		session.setAttribute("projectObj",projectService.getProjectById(pId));
		session.setAttribute("uObj",uObj);
		return mv;
	}
	
	@RequestMapping(value="/bugAllocate",method=RequestMethod.GET)
    public String getBugAllocationDetails(@RequestParam(name="bugType") String bug,@RequestParam(name="severity") String severity,@RequestParam(name="desc") String description,ModelMap map)
    	{
		if(checkSession(map)) {
			return "Login";
			}
    
          	
           Project pObj=(Project)session.getAttribute("projectObj");
           User uObj=(User)session.getAttribute("uObj");
                        
           BugDetails bugDetailObj = new BugDetails();
           bugDetailObj.setUserId(uObj.getUser_Id());
           bugDetailObj.setStatusId("B101");
           bugDetailObj.setBugTypeId(bug);
           bugDetailObj.setSeverityId(severity);
           bugDetailObj.setDesc(description);
           bugDetailObj.setProjectId(pObj.getpId());
           
           
            bugDetailsService.saveBugAllocationByTeater(bugDetailObj);
           return "BugSuccess";
           
    }

	

	
	

}
