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

import java.security.Principal;


//@SessionAttributes({"username"})
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



//
//	@GetMapping("/mydata/{username}")
//	public String editEmployee(@PathVariable("username") String username, Model model){
//		employeeService.editEmployee();
//		model.addAttribute("username", username);
//		return "redirect:/employeedata/{username}";
//	}
//
//	@GetMapping("mydata/{username}")
//	public String processEdit(Model model,
//							  @SessionAttribute("username") Employee employee,
//							  EditForm editForm) {
//		employee = employeeService.findEmployeeByUsername();
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
//								   @SessionAttribute("username") Employee employee){
//		Employee employee1 = employeeRepo.findByUsername(employee.getUser().getUsername()).get();
//		employeeRepo.delete(employeeService.findEmployeeByUsername(employee.getUser().getUsername()));
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