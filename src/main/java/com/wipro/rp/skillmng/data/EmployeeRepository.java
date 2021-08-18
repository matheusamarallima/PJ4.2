package com.wipro.rp.skillmng.data;

import java.util.List;
import java.util.Optional;

import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.service.EditForm;
import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeRepository 
	extends CrudRepository<Employee, Long>{
	public List<Employee> findAllByOrderByName();
	public Employee findByUserUsernameAndPetName(String username, String petName);
    Optional<Employee> findByName(String name);
    Employee findEmployeeById(Long id);

    Employee findByUserUsername(User user);
}
//    @GetMapping("employeedata/{id}")
//    public String processEdit(Model model,
//                              @PathVariable Long id,
//                              EditForm editForm){
//
//        model.addAttribute("projectList", projectRepository.findAll());
//        model.addAttribute("employee", employeeRepo.findEmployeeById(id));
//        model.addAttribute("project", projectRepository.findAll());
//
//        return "employeedata";
//    }

//	@Transactional
//	@PostMapping("/employeedata/{id}")
//	public String saveEditEmployee(Model model, EditForm editForm,
//								   @PathVariable Long id){
//		Employee employee1 = employeeRepo.findEmployeeById(id);
////		employeeRepo.delete(employeeService.findEmployeeById(employee.getId()));
////		model.addAttribute("employee", employee1);
//		employee1.setProject(editForm.getProject());
////		employee1 = editForm.DTOtoEntity(employee1);
//		employeeRepo.save(employee1);
//
//		model.addAttribute("success", "Employee Edited");
//
//
//		return "employeedata";
//	}