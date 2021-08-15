package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.EditForm;
import com.wipro.rp.skillmng.service.EmployeeService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.rp.skillmng.domain.User;


//@SessionAttributes({"loginForm"})
@Controller
public class LoginController {

//	private EmployeeRepository employeeRepo;
//	private EmployeeService employeeService;
//	private ProjectRepository projectRepository;
//
//	@Autowired
//	public LoginController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository) {
//		this.employeeRepo = employeeRepo;
//		this.employeeService = employeeService;
//		this.projectRepository = projectRepository;
//	}


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
				return "redirect:/employeesearch";
			} else if(roles.contains("ROLE_ADMIN")){
				return "redirect:/home";
			}
		}
		return "redirect:/login";
	}
//
//	@GetMapping("mydata/{id}")
//	public String processEdit(Model model,
//							  @SessionAttribute("id") Employee employee,
//							  EditForm editForm) {
//		employee = employeeRepo.findById(employee.getId()).get();
//		Project project = projectRepository.findByProjectName(employee.getProject().getProjectName()).get();
//
//
//		model.addAttribute("projectList", projectRepository.findAll());
//		model.addAttribute("employee", employee);
//		model.addAttribute("project", project);
//
//		return "mydata";
//	}
//
//	@PostMapping("/mydata/save")
//	public String saveEditEmployee(Model model, EditForm editForm,
//								   @SessionAttribute("id") Employee employee){
//		Employee employee1 = employeeRepo.findById(employee.getId()).get();
//		employeeRepo.delete(employeeService.findEmployeeById(employee.getId()));
//		model.addAttribute("employee", employee1);
//		employee1.setProject(employee.getProject());
//		employee1 = editForm.DTOtoEntity(employee1);
//		employeeRepo.save(employee1);
//		model.addAttribute("success", "Employee Edited");
//
//
//		return "mydata";
//	}


}