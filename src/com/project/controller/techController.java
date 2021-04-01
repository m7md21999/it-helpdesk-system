package com.project.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.project.service.mailService;
import com.project.service.requestService;
import com.project.service.techService;

@Controller
@RequestMapping("/technician")
public class techController {
	
	@Autowired
	private techService tService;
	
	@Autowired
	private requestService rService;
	
	@Autowired
	private mailService emailService;
	
	@RequestMapping("/updatePersonalInfo/{id}")
	public ModelAndView updatePersonalInformation(@PathVariable("id") int id, Model model){
		User user = tService.findUser(id);
		model.addAttribute("user", user);
		return new ModelAndView( "t-editInfo");
	}
	
	@RequestMapping("/updatePersonalInfo/techconfirmUpdate")
	public ModelAndView techconfirmUpdate (@Valid @ModelAttribute("user") User user, BindingResult rs){
		if(rs.hasErrors())
			return new ModelAndView("t-editInfo");
		
		tService.updateUser(user);
		return new ModelAndView("t-mainPage" , "user" , user);
	}
	
	
	@RequestMapping("/viewAllReqs/{id}")
	public String requestHistory(@PathVariable("id") int id , Model model){
		List<Request> reqsList = rService.getRequests(id);
		model.addAttribute("user",rService.findUser(id));
		model.addAttribute("reqsList" , reqsList);
		return "t-allRequests";
	}
	
	@RequestMapping("/viewAllReqs/techRequestDetails/{id}")
	public String empReqDetails(@PathVariable("id") int req_id, Model model){
		Request request = rService.getRequest(req_id);
		User emp = tService.findUser(request.getEmp_id());
		model.addAttribute("req", request);
		model.addAttribute("emp" , emp);
		model.addAttribute("user", rService.findUser(req_id));
		ReqSol reqSol = rService.CheckRequestSoltion(req_id);
		
		if(reqSol == null){
			return "t-requestdetailsNoSolution";
		}
		model.addAttribute("reqSol", reqSol);
		return "t-requestdetails";
	}
	
	@RequestMapping("/viewAllReqs/techRequestDetails/closeRequest/{id}")
	public String closeTheRequest(@PathVariable("id") int id , Model model){
		ReqSol reqSol = new ReqSol();
		model.addAttribute("user", rService.findUser(id));
		model.addAttribute("reqSol", reqSol);
		model.addAttribute("req_id", id);
		return "t-closeRequest";
	}
	@RequestMapping(value="/viewAllReqs/techRequestDetails/closeRequest/confirmCloseRequest/{id}", method= RequestMethod.POST)
	public ModelAndView confrimClosingRequest (@PathVariable("id") int id ,@ModelAttribute("reqSol") ReqSol reqSol,BindingResult br, Model model){
		if (br.hasErrors())
			return new ModelAndView("t-closeRequest");
		
		
		reqSol.setFinshDate(new java.sql.Date(new java.util.Date().getTime()));
		reqSol.setReq_id(id);
		rService.closeRequest(reqSol);
		
		Request request = rService.getRequest(reqSol.getReq_id());
		User user = rService.findUser(request.getTech_id());
		User emp = rService.findUser(request.getEmp_id());
		emailService.notfiyEmail(emp.getEmail(),"Request ID#: "+id+" has been solved!"
				," Your request has been closed by the technician, Please check the website for the technician's report.");
		
		return new ModelAndView("t-mainPage", "user", user);		
	}
	
	@RequestMapping("/viewNewestRequests/{id}")
	public String Newestrequests(@PathVariable("id") int id , Model model){
		List<Request> reqsList = rService.getRequests(id);
		Date date = new Date (new java.util.Date().getTime());
		List<Request> reqsListNew = new ArrayList<>();
		for (Request req : reqsList){
			if (date.compareTo(req.getAssignedDate()) < 2 && !req.getStatus().equals("Closed")){
				reqsListNew.add(req);
			}

		}
		
		model.addAttribute("user",rService.findUser(id));
		model.addAttribute("reqsList" , reqsListNew);
		User user = tService.findUser(id);
		return "t-newestRequests";
	}
	@RequestMapping("/viewNewestRequests/techRequestDetails/{id}")
	public String NempReqDetails(@PathVariable("id") int req_id, Model model){
		Request request = rService.getRequest(req_id);
		User emp = tService.findUser(request.getEmp_id());
		model.addAttribute("req", request);
		model.addAttribute("emp" , emp);
		model.addAttribute("user", rService.findUser(req_id));
		ReqSol reqSol = rService.CheckRequestSoltion(req_id);
		
		if(reqSol == null){
			return "t-requestdetailsNoSolution";
		}
		model.addAttribute("reqSol", reqSol);
		return "t-requestdetails";
	}
	
	@RequestMapping("/viewNewestRequests/techRequestDetails/closeRequest/{id}")
	public String NcloseTheRequest(@PathVariable("id") int id , Model model){
		ReqSol reqSol = new ReqSol();
		model.addAttribute("user", rService.findUser(id));
		model.addAttribute("reqSol", reqSol);
		model.addAttribute("req_id", id);
		return "t-closeRequest";
	}
	@RequestMapping(value="/viewNewestRequests/techRequestDetails/closeRequest/confirmCloseRequest/{id}", method= RequestMethod.POST)
	public ModelAndView NconfrimClosingRequest (@PathVariable("id") int id ,@ModelAttribute("reqSol") ReqSol reqSol,BindingResult br, Model model){
		if (br.hasErrors())
			return new ModelAndView("t-closeRequest");
		
		
		reqSol.setFinshDate(new java.sql.Date(new java.util.Date().getTime()));
		reqSol.setReq_id(id);
		rService.closeRequest(reqSol);
		
		Request request = rService.getRequest(reqSol.getReq_id());
		User user = rService.findUser(request.getTech_id());
		User emp = rService.findUser(request.getEmp_id());
		emailService.notfiyEmail(emp.getEmail(),"Request ID#: "+id+" has been solved!"
				," Your request has been closed by the technician, Please check the website for the technician's report.");
		
		return new ModelAndView("t-mainPage", "user", user);		
	}
	
	
}
