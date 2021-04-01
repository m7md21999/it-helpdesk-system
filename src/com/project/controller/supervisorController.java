package com.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.mailService;
import com.project.service.requestService;
import com.project.service.supervisorService;

@Controller
@RequestMapping("/supervisor")
public class supervisorController {
	
	@Autowired
	private supervisorService sService;
	
	@Autowired
	private requestService rService;
	
	@Autowired
	private mailService emailService;
		
	@RequestMapping("/manageUsers")
	public String manageUsers(Model model){
		return "s-manageUsers-form";	
	}
	
	@RequestMapping("/allUsersList")
	public String AllUsersList(Model model){
		List<User> usersList = sService.getUsers();
		model.addAttribute("usersList", usersList);
		return "s-allUsersList";
	}
	@RequestMapping("/allUsersListDept")
	public String allUsersListDept(){
		return "s-allUsersListDept";
	}
	
	@RequestMapping("/showUsersDept")
	public String showUsersDept(@RequestParam("dept_name") String dept_name, Model model){
		List<User> usersList = sService.getUsers(dept_name);
		model.addAttribute("usersList", usersList);
		return "s-allUsersList";
	}
	
	@RequestMapping("/addNewUser")
	public String addNewUser (Model model){
		User user = new User();
		model.addAttribute("user" , user);
		return "s-addNewUser";
	}
	
	@RequestMapping("/addUserConfirmation")
	public ModelAndView addUserConfitmation(@Valid @ModelAttribute("user") User user, BindingResult br ){
		if (br.hasErrors()){
			return new ModelAndView("s-addNewUser");
		} else {
		
		sService.createUser(user);
		return new ModelAndView("redirect:/supervisor/allUsersList");
		}
	}
	
	@RequestMapping("/editUser/{id}")
	public String editUser(@PathVariable("id") int id, Model model){
		User user = sService.findUser(id);
		model.addAttribute("user", user);
		return "s-editUser";
	}
	
	@RequestMapping(value ="/editUserConfirmation", method = RequestMethod.POST)
	public ModelAndView editUserConfritmation(@ModelAttribute("user") User user, BindingResult br ){
		if (br.hasErrors())
			return new ModelAndView ("s-editUser");
		
		sService.updateUser(user);
		return new ModelAndView("s-manageUsers-form");
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id){
		sService.deleteUser(id);
		return "redirect:/supervisor/allUsersList";
	}
	
	@RequestMapping("/manageRequests")
	public String ManageRequestsMethod(Model model){
		List<Request> reqsList = rService.getNewHighPriortyRequests();
		model.addAttribute("msg", "New-High Requests");
		model.addAttribute("reqsList" , reqsList);
		return "s-manageRequests";
	}
	
	@RequestMapping("/newRequests")
	public ModelAndView getNewRequests (){
		List<Request> reqsList = rService.getNewRequests();
		return new ModelAndView("s-manageRequests" , "reqsList", reqsList);
	}
	
	@RequestMapping("/highPriortyRequests")
	public ModelAndView gethighPriortyRequests(){
		List<Request> reqsList = rService.getHighPriortyRequests();
		return new ModelAndView("s-manageRequests" , "reqsList", reqsList);
	}
	
	@RequestMapping("/assignedRequests")
	public ModelAndView getassignedRequests (){
		List<Request> reqsList = rService.getAssignedRequests();
		return new ModelAndView("s-requestsListWithTech" , "reqsList", reqsList);
	}
	
	@RequestMapping("/closedRequests")
	public ModelAndView getclosedRequests (){
		List<Request> reqsList = rService.getClosedRequests();
		return new ModelAndView("s-requestsListWithTech" , "reqsList", reqsList);
	}
	
	@RequestMapping("/allRequests")
	public ModelAndView getAllRequests (){
		List<Request> reqsList = rService.getRequests();
		return new ModelAndView("s-manageRequests" , "reqsList", reqsList);
	}
	
	@RequestMapping(value ="/requestdetails/{id}")
	public String manageRequestForm (@PathVariable("id") int id, Model model){
		Request request = rService.getRequest(id);
		User user = sService.findUser(request.getEmp_id());
		model.addAttribute("req", request);
		model.addAttribute("emp" , user);
		return "s-requestDetails";
	}
	
	@RequestMapping(value ="/requestdetails/assignRequest/{id}")
	public String ManageRqeuest(@PathVariable("id") int id, Model model){
		Request request = rService.getRequest(id);
		List<User> usersList = sService.getUsers("Information technology");
		model.addAttribute("req", request);
		model.addAttribute("usersList",usersList);
		return "s-assignRequest";
	}
	
	@RequestMapping("/requestdtails/deleteRequest/{id}")
	public ModelAndView deleteRequest (@PathVariable("id") int id, Model model){
//		Request request = rService.getRequest(id);
		rService.deleteRequest(id);
		return new ModelAndView("s-manageRequests" , "msg", "Request has been deleted!");
	}
	
	
	@RequestMapping("/requestdetails/assignRequest/assgin/{tech_id}/{req_id}")
	public String confrimAssign(@PathVariable("tech_id") int tech_id, @PathVariable("req_id") int req_id, Model model){
		rService.assignRequest(req_id, tech_id);
		User user = rService.findUser(tech_id);
		emailService.notfiyEmail
		(user.getEmail(),"New Request Assigned", "Request ID#:" +req_id+ " has been assigned to you. Please check website");
		model.addAttribute("msg","Request has been assigned!");
		return "redirect:/supervisor/manageRequests";
	}
	
	
	@RequestMapping("/requestFullDetails/{id}")
	public String requestAllDeatiles(@PathVariable("id") int id , Model model){
		Request request = rService.getRequest(id);
		User emp = sService.findUser(request.getEmp_id());
		User tech = sService.findUser(request.getTech_id());
		model.addAttribute("req", request);
		model.addAttribute("emp" , emp);
		model.addAttribute("tech" , tech);
		return "s-requestdetailsWithT";
	}
	
	@RequestMapping("/requestFullDetails/deleteRequest/{id}")
	public ModelAndView deleteFullRequest (@PathVariable("id") int id, Model model){
//		Request request = rService.getRequest(id);
		rService.deleteRequest(id);
		return new ModelAndView("s-manageRequests" , "msg", "Request has been deleted!");
	}
	
	@RequestMapping("/requestFullDetails/techReport/{id}")
	public String techReport(@PathVariable ("id") int id , Model model){
		Request request = rService.getRequest(id);
		ReqSol reqSol = rService.CheckRequestSoltion(id);
		
		if (reqSol == null){
			model.addAttribute("msg" , "Request still in process!");
			return "s-manageRequests";
		}
		
		model.addAttribute("reqSol", reqSol);
		model.addAttribute("tech", rService.findUser(request.getTech_id()));
		return "s-techReport";
	}
	
	
}
