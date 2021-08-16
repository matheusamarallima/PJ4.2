package com.wipro.rp.skillmng.web;


import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.EditForm;
import com.wipro.rp.skillmng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.security.Principal;
import java.util.Optional;


@Controller
public class MyDataController {

    private EmployeeRepository employeeRepo;
    private EmployeeService employeeService;
    private ProjectRepository projectRepository;

    @Autowired
    public MyDataController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository) {
        this.employeeRepo = employeeRepo;
        this.employeeService = employeeService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("mydata")
    public String currentUserName(Model model, EditForm editForm, Principal principal, Employee employee, Project project) {

        employee = employeeRepo.findByName(principal.getName()).get();
        System.out.println(employee);

        model.addAttribute("projectList", projectRepository.findAll());
        model.addAttribute("employee", employee);
        return "mydata";
    }

    @PostMapping("/mydata/save")
    public String saveEditEmployee(Model model, @ModelAttribute EditForm editForm,
                                  Principal principal){

        Employee employee = employeeRepo.findByUserUsername(editForm.getUser());
        employeeRepo.save(employee);


//        employee1.setProject(principal.getName());
//        employee1 = editForm.DTOtoEntity(employee1);

        model.addAttribute("success", "Employee Edited");


        return "home";
    }



//    public String processEdit(Model model,EditForm editForm) {
//        editForm
//        employee = employeeRepo.findById(employee.getId()).get();
//        Project project = projectRepository.findByProjectName(employee.getProject().getProjectName()).get();
//
//
//        model.addAttribute("projectList", projectRepository.findAll());
//        model.addAttribute("employee", employee);
//        model.addAttribute("project", project);
//
//        return "mydata";
//    }
}
