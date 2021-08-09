package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.security.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	private UserRepository userRepo;
	private EmployeeRepository employeeRepo;
	private ProjectRepository projectRepo;
	private PasswordEncoder passwordEnconder;
	
	public RegistrationController(
			UserRepository userRepo, 
			EmployeeRepository employeeRepo,
			ProjectRepository projectRepo,
			PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.employeeRepo = employeeRepo;
		this.passwordEnconder = passwordEncoder;
	}
	
	@GetMapping
	public String registerForm(Model model) {
//		loadSelects(model);
//		model.addAttribute("projectList", projectRepo.findAll());
		model.addAttribute("registerForm", new RegistrationForm());
		return "register";
	}

//	private void loadSelects(Model model) {
//		model.addAttribute("roleList", roleRepo.findAll());
//		model.addAttribute("bandList", bandRepo.findAll());
//	}
	
	@PostMapping
	public String processRegistration(Model model, RegistrationForm form) {
		User user = null;
		user = this.userRepo.findUserByUsername(form.getUserId());
		if(user != null) {
//			loadSelects(model);
			model.addAttribute("registerForm", form);
			model.addAttribute("error", "1");
			return "register";
		}
		User user1 = new User();
		Employee employee1 = new Employee();
		user1.setUsername(form.getUserId());
		user1.setPassword(passwordEnconder.encode(form.getPassword()));
		user1.setRole("EMPLOYEE");
		employee1.setUser(user1);
		employee1.setName(form.getName());
		employee1.setAge(form.getAge());
		employee1.setPetName(form.getPetName());
		employee1.setGender(form.getGender());
		employee1.setJob(form.getJob());
		employee1.setBand(form.getBand());
		user1 = userRepo.save(user1);
		employee1 = employeeRepo.save(employee1);
		return "redirect:/login?success=1";		
	}
}
