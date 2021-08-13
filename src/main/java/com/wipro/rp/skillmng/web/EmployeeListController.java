package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.EditForm;
import com.wipro.rp.skillmng.service.EmployeeService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.domain.Employee;

import java.util.List;

@Controller
@SessionAttributes({"id"})
public class EmployeeListController {
	
	private EmployeeRepository employeeRepo;
	private EmployeeService employeeService;
	private ProjectRepository projectRepository;

	@Autowired
	public EmployeeListController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository) {
		this.employeeRepo = employeeRepo;
		this.employeeService = employeeService;
		this.projectRepository = projectRepository;
	}

	@GetMapping("/employeelist")
	public String employeeList(Model model) {
		List<Employee> employees = employeeRepo.findAllByOrderByName();
		model.addAttribute("employeeList", employees);
		return "employeelist";
	}

	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") String id, Model model){
		employeeService.deleteEmployee(employeeService.findEmployeeByName(id));
		return "redirect:/employeelist";
	}

	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model){
		employeeService.editEmployee(employeeService.findEmployeeById(id));
		model.addAttribute("id", id);
		return "redirect:/employeedata/{id}";
	}

	@GetMapping("employeedata/{id}")
	public String processEdit(Model model,
							  @SessionAttribute("id") Employee employee,
							  EditForm editForm) {
		employee = employeeRepo.findById(employee.getId()).get();
		Project project = projectRepository.findByProjectName(employee.getProject().getProjectName()).get();


		model.addAttribute("projectList", projectRepository.findAll());
		model.addAttribute("employee", employee);
		model.addAttribute("project", project);

		return "employeedata";
	}

	@PostMapping("/employeedata/save")
	public String saveEditEmployee(Model model, EditForm editForm,
								   @SessionAttribute("id") Employee employee){
		Employee employee1 = employeeRepo.findById(employee.getId()).get();
		employeeRepo.delete(employeeService.findEmployeeById(employee.getId()));
		model.addAttribute("employee", employee1);
		employee1.setProject(employee.getProject());
		employee1 = editForm.DTOtoEntity(employee1);
		employeeRepo.save(employee1);
			model.addAttribute("success", "Employee Edited");


		return "employeedata";
	}
}