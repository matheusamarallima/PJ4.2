package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.ProjectDataForm;
import com.wipro.rp.skillmng.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectCreationController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectCreationController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projectdata")
    public String projectCreation(Model model){
        model.addAttribute("projectDataForm", new ProjectDataForm());
        return "projectcreation";
    }

    @PostMapping("/projectdata")
    public String projectCreationSave(Model model, ProjectDataForm projectDataForm, Project project ){


        if(projectService.createProject(projectDataForm.DTOtoEntity(projectDataForm))){
            model.addAttribute("success", "Project successfully added");

        }
        Project project1 = projectRepository.findByProjectName(projectDataForm.getProjectName()).get();

        model.addAttribute("employeeList", project1.getEmployeeList());
        return "projectcreation";
    }

}
