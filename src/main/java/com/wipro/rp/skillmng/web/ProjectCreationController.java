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

    private ProjectService projectService;

    @Autowired
    public ProjectCreationController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projectdata")
    public String projectCreation(Model model){
        model.addAttribute("projectDataForm", new ProjectDataForm());
        return "projectcreation";
    }

    @PostMapping("/projectdata")
    public String projectCreationSave(Model model, ProjectDataForm projectDataForm, Project project ){


//        if (projectRepository.findByProjectName(project1.getProjectName()) != null){
//            model.addAttribute("errorProject", projectRepository.findByProjectName(project1.getProjectName()));
//            return "projectcreation";
//        }
        if(projectService.createProject(projectDataForm.DTOtoEntity(projectDataForm))){
            model.addAttribute("success", "Project successfully added");

        }
        model.addAttribute("employeeList", projectService.findProjectByName(projectDataForm.getProjectName()).getEmployeeList());
        return "projectcreation";
    }

}
