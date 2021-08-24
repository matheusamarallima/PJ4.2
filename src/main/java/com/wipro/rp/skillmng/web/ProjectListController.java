package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.ProjectDataForm;
import com.wipro.rp.skillmng.service.ProjectService;
import com.wipro.rp.skillmng.service.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectListController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ProjectListController(ProjectService projectService, ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;

    }

    @GetMapping("projectlist")
    public String projectList(Model model){
        model.addAttribute("projectList", projectService.projectList());
        return "projectlist";
    }

    @GetMapping("/deleteproject/{id}")
    public String deleteProject(@PathVariable("id") Long id, Model model){
        Optional<Project> project = projectRepository.findById(id);
        List<Employee> employeeList = employeeRepository.findAllByProjectId(id);

        if(project.isPresent()){
            if(!employeeList.isEmpty()) {
                model.addAttribute("employeeList", employeeRepository.findAllByProjectId(id));
                return "projectlist";
            }
            projectRepository.delete(project.get());
            return "redirect:/projectlist";
        }
        return "redirect:/projectlist";
    }

    @GetMapping("/editproject/{id}")
    public String processEdit(Model model,
                              @PathVariable("id") Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            model.addAttribute("project", project.get());
            model.addAttribute("projectDataForm", new ProjectDataForm());

            return "editproject";
        }
        return "projectlist";
    }

    @PostMapping("/editproject/{id}")
    public String saveEditProject(Model model,
                                  ProjectDataForm projectDataForm,
                                  @PathVariable("id") Long id){

        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            project.get().setProjectName(projectDataForm.getProjectName());
            project.get().setProjectStartDate(projectDataForm.getProjectStartDate());
            project.get().setProjectEndDate(projectDataForm.getProjectEndDate());
            projectRepository.save(project.get());
            return "redirect:/projectlist";
        }

        return "redirect:/projectlist";



    }

}
