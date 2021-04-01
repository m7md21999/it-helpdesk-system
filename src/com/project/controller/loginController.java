package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.User;
import com.project.service.mainService;


@Controller
public class loginController {
	
	@Autowired
	mainService mService;
	
	@RequestMapping("/")
	public String indexPage(Model model){
		model.addAttribute("msg", "enter email and password below!");
		return "index";
		
	}
	
	@RequestMapping("/supervisorLogin")
	public ModelAndView returnSuperVisor (@RequestParam("email") String user_email , @RequestParam("password") String user_password , Model model){
		User user = mService.Login(user_email, user_password);
			if( user == null )
				return new ModelAndView("index","msg"," please enter a valid email and password");
			
			if(user.getDept_name().equals("Information technology"))
				return new ModelAndView("t-mainPage" , "user" , user);
			
			if(user.getDept_name().equals("Supervisors"))
				return new ModelAndView ("redirect:/supervisor/manageUsers");
			
			return new ModelAndView("e-mainPage", "user" , user);
		
	}
	

        @RequestMapping(value="/logout",method = RequestMethod.GET)
        public String logout(){
            return "redirect:/";
        }
	

}
