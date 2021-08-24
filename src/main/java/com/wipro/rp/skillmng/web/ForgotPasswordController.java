package com.wipro.rp.skillmng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.security.SecurityConfig;

@Controller
@SessionAttributes("employee")
public class ForgotPasswordController {
	
	private final EmployeeRepository employeeRepo;
	
	public ForgotPasswordController(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "forgotpassword";
	}
	
	@PostMapping("/forgotpassword/validateUser")
	public String validateUser(
			@RequestParam(name = "userId") String userId,
			@RequestParam(name = "petname") String petName,
			Model model) {
		if(!userId.equals("") && !petName.equals(""))
		{
			Employee employee = this.employeeRepo.findByUserUsernameAndPetName(userId, petName);
			if(this.employeeRepo.findByUserUsernameAndPetName(userId, petName) != null) {
				model.addAttribute("employee", employee);
				return "redirect:/forgotpassword?validated=1";
			}			
		}
		return "redirect:/forgotpassword?validateError=1";
	}
	
	@PostMapping("/forgotpassword/resetUser")
	public String validateUser(
			@RequestParam(name = "password") String password,
			Model model,
			@Autowired SecurityConfig security) {
		Employee employee = (Employee) model.getAttribute("employee");
		if(employee != null)
		{
//			employee.getUser().setPassword(security.encoder().encode(password));
			this.employeeRepo.save(employee);	
			return "redirect:/login?success=2";
		}
		return "redirect:/forgotpassword?validateError=1";
	}
}