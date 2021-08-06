package com.wipro.rp.skillmng.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.rp.skillmng.data.BandRepository;
import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.RoleRepository;
import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.security.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	private UserRepository userRepo;
	private EmployeeRepository employeeRepo;
	private PasswordEncoder passwordEnconder;
	private RoleRepository roleRepo;
	private BandRepository bandRepo;
	
	public RegistrationController(
			UserRepository userRepo, 
			EmployeeRepository employeeRepo, 
			RoleRepository roletRepo,
			BandRepository bandRepo,
			PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.employeeRepo = employeeRepo;
		this.roleRepo = roletRepo;
		this.bandRepo = bandRepo;
		this.passwordEnconder = passwordEncoder;
	}
	
	@GetMapping
	public String registerForm(Model model) {
		loadSelects(model);
		model.addAttribute("registerForm", new RegistrationForm());
		return "register";
	}

	private void loadSelects(Model model) {
		model.addAttribute("roleList", roleRepo.findAll());
		model.addAttribute("bandList", bandRepo.findAll());
	}
	
	@PostMapping
	public String processRegistration(Model model, RegistrationForm form) {
		User user = null;
		user = this.userRepo.findUserByUsername(form.getUserId());
		if(user != null) {
			loadSelects(model);
			model.addAttribute("registerForm", form);
			model.addAttribute("error", "1");
			return "register";
		}
		user = this.userRepo.<User>save(form.toUser(this.passwordEnconder));
		this.employeeRepo.<Employee>save(form.toEmployee(user));
		return "redirect:/login?success=1";		
	}
}
