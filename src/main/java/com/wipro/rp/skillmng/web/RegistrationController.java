package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.service.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private ProjectRepository projectRepo;

	EmployeeService employeeService;

	@Autowired
	public RegistrationController(ProjectRepository projectRepo, EmployeeService employeeService) {
		this.projectRepo = projectRepo;
		this.employeeService = employeeService;
	}


	@GetMapping
	public String registerForm(Model model) {
//		loadSelects(model);
		model.addAttribute("projectList", projectRepo.findAll());
		model.addAttribute("registerForm", new RegistrationForm());
		return "register";
	}

	@PostMapping
	public String processRegistration(Model model, Employee employee, @ModelAttribute RegistrationForm form) {

		Project project = projectRepo.findByProjectName(employee.getProject().getProjectName()).get();
		employee.setProject(project);
		if(employeeService.createEmployee(form.DTOtoEntity(employee))){
			model.addAttribute("success", "User created test");

		}

		return "login";
	}
}
