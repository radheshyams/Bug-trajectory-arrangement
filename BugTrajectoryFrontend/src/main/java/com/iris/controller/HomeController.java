package com.iris.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.UserService.ProjectService;
import com.iris.UserService.UserService;
import com.iris.model.Project;
import com.iris.model.User;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value= {"/","Login"},method=RequestMethod.GET)	
	public String anyMsg(){
		return "Login";
	}
	@Autowired
	HttpSession session;
	
		
	
	@RequestMapping(value="/Signin",method=RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam (value="email") String email,@RequestParam(value="password") String password){
		User userObj=userService.validateUser(email,password);
		if(userObj!=null){
			session.setAttribute("uObj",userObj);
			if(userObj.getRole().equals("Manager")) {
				List<Project> prList=projectService.getAllProject();
				
				List<User> deList=userService.getAllDev();
				List<User> tsList=userService.getAllTest();
			
				ModelAndView mv=new ModelAndView("ManagerPage");
				mv.addObject("proList",prList);
				mv.addObject("devList",deList);
				mv.addObject("tstList",tsList);
				return mv;
			}
			else if(userObj.getRole().equals("Tester")) {
				int Id=userObj.getUser_Id();
				User uObj=userService.getUserById(Id);
				List <Project>testproList=uObj.getProjects();
				ModelAndView mv=new ModelAndView("TesterPage");
				mv.addObject("tstproList",testproList);
				return mv;
			}
			else if(userObj.getRole().equals("Developer")) {
				int Id=userObj.getUser_Id();
				User dObj=userService.getUserById(Id);
				List <Project>devproList=dObj.getProjects();
				
				ModelAndView mv=new ModelAndView("DevPage");
				mv.addObject("devList",devproList);
				return mv;
			}

		}
		return new ModelAndView("Login");
		}
	
	
			@RequestMapping(value= {"logout"}, method=RequestMethod.GET )
			public String logout(ModelMap map) {
					map.addAttribute("msg", "you are successfully logout");
					session.removeAttribute("uObj");
					session.invalidate();
					return "Login";
				}

	
	}
