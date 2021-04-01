package com.project.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.empService;
import com.project.service.mailService;
import com.project.service.requestService;

@Controller
@RequestMapping("/employee")
public class empController {
	
	@Autowired
	empService eService;
	
	@Autowired
	requestService rService;
	
	
	@RequestMapping("/updatePersonalInfo/{id}")
	public String updatePersonalInformation(@PathVariable("id") int id, Model model){
		User user = eService.findUser(id);
		model.addAttribute("user",user);
		return "e-editInfo";
	}
	@RequestMapping(value="/updatePersonalInfo/empconfirmUpdate" , method = RequestMethod.POST)
	public ModelAndView empConfirmUpdate (@ModelAttribute("user") User user){
		eService.updateUser(user);
		return new ModelAndView("e-mainPage" ,"user" , user);
	}
	
	@RequestMapping("/makeNewReq/{id}")
	public String createNewReq (@PathVariable("id") int id, Model model){
		Request request = new Request();
		request.setStatus("New");
		model.addAttribute("newReq", request);
		model.addAttribute("user_id" , id);
		model.addAttribute("user",rService.findUser(id));
		return "e-createRequest";
	}
	@RequestMapping("/makeNewReq/createReqConfirmation")
	public ModelAndView createNewReqConfrimation(@Valid @ModelAttribute("newReq") Request request, BindingResult br){
		if (br.hasErrors())
			return new ModelAndView ("e-createRequest");
		
		
		
		request.setDate(new java.sql.Date(new java.util.Date().getTime()));
		rService.createRequest(request);
		User user = rService.findUser(request.getEmp_id());
		return new ModelAndView("e-mainPage" , "user" , user);
	}
	
	@RequestMapping("/viewAllReqs/{id}")
	public String requestHistory(@PathVariable("id") int id ,Model model){
		List<Request> reqsList = rService.getRequests(id);
		model.addAttribute("user",rService.findUser(id));
		model.addAttribute("reqsList" , reqsList);
		return "e-allRequests";
	}
	
	@RequestMapping("/viewAllReqs/empRequestDetails/{id}")
	public String empReqDetails(@PathVariable("id") int req_id, Model model){
		Request request = rService.getRequest(req_id);
		model.addAttribute("user", rService.findUser(request.getEmp_id()));
		model.addAttribute("req", request);
		ReqSol reqSol = rService.CheckRequestSoltion(req_id);
		
		if(reqSol == null ){
			if (request.getStatus().equals("Assigned")){
			model.addAttribute("tech", rService.findUser(request.getTech_id()));
			}
			return "e-requestdetails";
		}
		model.addAttribute("tech", rService.findUser(request.getTech_id()));
		return "e-requestdetailsWithTech";
	}
	
	@RequestMapping("/viewAllReqs/empRequestDetails/techReport/{id}")
	public String emptechReport(@PathVariable("id") int id, Model model){
		ReqSol reqSol = rService.CheckRequestSoltion(id);
		model.addAttribute("user",rService.findUser(id));
		model.addAttribute("reqSol", reqSol);
		return "e-techReport";
	}
	
	@RequestMapping("/viewAllReqs/empRequestDetails/deleteRequest/{id}")
	public ModelAndView confrimDelete (@PathVariable("id") int id , Model model){
		Request request = rService.getRequest(id);
		User user = rService.findUser(request.getEmp_id());
		rService.deleteRequest(id);
		return new ModelAndView ("e-mainPage" ,"user", user);
	}
}
