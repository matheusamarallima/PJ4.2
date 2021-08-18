package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.rp.skillmng.domain.User;




@Controller
public class LoginController {

	private EmployeeRepository employeeRepo;
	private EmployeeService employeeService;
	private ProjectRepository projectRepository;

	@Autowired
	public LoginController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository) {
		this.employeeRepo = employeeRepo;
		this.employeeService = employeeService;
		this.projectRepository = projectRepository;
	}


	@GetMapping("/login")
	public String login(
			Model model,
			@RequestParam(required=false) String success) {
		if(success != null) {
			String message = null;
			if(success.equals("1")) {
				message = "User successfully registered. Login to continue";
			} else if(success.equals("2")) {
				message = "Password successfully changed";
			}
			model.addAttribute("successMessage", message);
		}
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String relativeHome(@AuthenticationPrincipal User user) {
		if(user != null) {
			String roles = user.getAuthorities().toString();
			if(roles.contains("ROLE_EMPLOYEE")) {
				return "redirect:/home";
			} else if(roles.contains("ROLE_ADMIN")){
				return "redirect:/home";
			}
		}
		return "redirect:/login";
	}



}