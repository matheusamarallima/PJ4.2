package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.service.EmployeeService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.domain.Employee;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"id"})
public class EmployeeListController {

	private EmployeeRepository employeeRepo;
	private EmployeeService employeeService;
	private ProjectRepository projectRepository;
	private UserRepository userRepository;

	@Autowired
	public EmployeeListController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository) {
		this.employeeRepo = employeeRepo;
		this.employeeService = employeeService;
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
	}

	@GetMapping("/employeelist")
	public String employeeList(Model model) {
		List<Employee> employees = employeeRepo.findAllByOrderByName();
		model.addAttribute("employeeList", employees);
		return "employeelist";
	}

	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") String id, Model model) {
		employeeService.deleteEmployee(employeeService.findEmployeeByName(id));
		return "redirect:/employeelist";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model) {
		employeeService.editEmployee(employeeService.findEmployeeById(id));
		model.addAttribute("id", id);
		return "redirect:/employeedata/{id}";
	}

	@GetMapping("employeedata/{id}")
	public String processEdit(Model model,
							  @SessionAttribute("id") Long id) {

		model.addAttribute("projectList", projectRepository.findAll());
		model.addAttribute("employee", employeeRepo.findEmployeeById(id));
		model.addAttribute("project", projectRepository.findAll());
		model.addAttribute("registrationForm", new RegistrationForm());

		return "employeedata";
	}

	@PostMapping("/employeedata/{id}")
	public String saveEditEmployee(Model model, RegistrationForm form,
								   Employee employee,
								   @PathVariable("id") Long id) {

		Employee employee1 = employeeRepo.findEmployeeById(id);
		Optional<Employee> employee2 = Optional.ofNullable(employee1);

		Project project = projectRepository.findProjectByProjectName(form.getProject().getProjectName());
		employee1.setProject(project);

		employeeRepo.save(employee1);
		return "redirect:/employeelist";


	}

}











