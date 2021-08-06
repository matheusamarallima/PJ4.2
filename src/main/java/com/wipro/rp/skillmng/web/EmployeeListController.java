package com.wipro.rp.skillmng.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.domain.Employee;

@Controller
public class EmployeeListController {
	
	private EmployeeRepository employeeRepo;
	
	public EmployeeListController(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@GetMapping("/employeelist")
	public String employeeList(Model model) {
		Iterable<Employee> employees = employeeRepo.findAllByOrderByName();
		model.addAttribute("employeeList", employees);
		return "projectlist";
	}

	@PostMapping("/employeelist")
	public String deleteEmployee(
			Model model, 
			@RequestParam(name = "deleteUserId", required = true) String deleteUserId) {
		String deleteEmployeeId = deleteUserId;
		employeeRepo.deleteById(deleteEmployeeId);
		Iterable<Employee> employees = employeeRepo.findAllByOrderByName();
		model.addAttribute("employeeList", employees);
		return "projectlist";
	}
}