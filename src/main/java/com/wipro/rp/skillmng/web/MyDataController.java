package com.wipro.rp.skillmng.web;


import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.security.SecurityConfig;
import com.wipro.rp.skillmng.service.EditForm;
import com.wipro.rp.skillmng.service.EmployeeService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Registration;
import java.security.Principal;
import java.util.Optional;


@Controller
public class MyDataController {

    private EmployeeRepository employeeRepo;
    private EmployeeService employeeService;
    private ProjectRepository projectRepository;
    SecurityConfig securityConfig;

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
        model.addAttribute("registrationForm", new RegistrationForm());

        return "mydata";
    }

    @PostMapping("/mydata/save")
    public String saveEditEmployee(ModelMap model, RegistrationForm form,
                                   Principal principal,
                                   Employee employee){

        Employee employee1 = employeeRepo.findEmployeeByName(principal.getName());
        Project project = projectRepository.findProjectByProjectName(form.getProject().getProjectName());

        employee1.setId(employee1.getId());
        employee1.getUser().setUsername(form.getUser().getUsername());
        employee1.getUser().setPassword(form.getUser().getPassword());
        employee1.setName(form.getName());
        employee1.setGender(form.getGender());
        employee1.setAge(form.getAge());
        employee1.setBand(form.getBand());
        employee1.setJob(form.getJob());
        employee1.setProject(project);
        employee1.getUser().setRole("ROLE_EMPLOYEE");
        employeeRepo.save(employee1);
        return "redirect:/home";
        }



    }




