package com.wipro.rp.skillmng.web;


import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.security.SecurityConfig;
import com.wipro.rp.skillmng.service.EditForm;
import com.wipro.rp.skillmng.service.EmployeeService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.servlet.Registration;
import java.security.Principal;
import java.util.Optional;


@Controller
public class MyDataController {

    private EmployeeRepository employeeRepo;
    private EmployeeService employeeService;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    SecurityConfig securityConfig;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MyDataController(EmployeeRepository employeeRepo, EmployeeService employeeService, ProjectRepository projectRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepo;
        this.employeeService = employeeService;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("mydata")
    public String currentUserName(Model model, EditForm editForm, Principal principal, Employee employee, Project project) {

        User user = userRepository.findUserByUsername(principal.getName());
        Employee employee1 = employeeRepo.findEmployeeByUserUsername(principal.getName());




        model.addAttribute("projectList", projectRepository.findAll());
        model.addAttribute("employee", employee1);
        model.addAttribute("registrationForm", new RegistrationForm());

        return "mydata";
    }

    @PostMapping("/mydata/save")
    public String saveEditEmployee(ModelMap model, RegistrationForm form,
                                   Principal principal) {

        Employee employee = employeeRepo.findEmployeeByUserUsername(principal.getName());
        Project project = projectRepository.findProjectByProjectName(form.getProject().getProjectName());

        employee.setId(employee.getId());
        employee.getUser().setUsername(form.getUser().getUsername());
        employee.setName(form.getName());
        employee.setGender(form.getGender());
        employee.setAge(form.getAge());
        employee.setBand(form.getBand());
        employee.setJob(form.getJob());
        employee.setProject(project);
        employee.getUser().setRole("ROLE_EMPLOYEE");
        employeeRepo.save(employee);

        return "redirect:/login";
    }

}


