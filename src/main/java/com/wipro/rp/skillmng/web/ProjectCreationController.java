package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.servicwe.ProjectDataForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectCreationController {

    private ProjectRepository projectRepository;


    public ProjectCreationController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projectdata")
    public String projectCreation(Model model){
        model.addAttribute("projectDataForm", new ProjectDataForm());
        return "projectcreation";
    }

    @PostMapping("/projectdata")
    public String projectCreationSave(Model model, ProjectDataForm projectDataForm, Project project ){
        Project project1 = new Project();
        project1.setProjectId(projectDataForm.getProjectId());
        project1.setProjectName(projectDataForm.getProjectName());
        project1.setProjectStartDate(projectDataForm.getProjectStartDate());
        project1.setProjectEndDate(projectDataForm.getProjectEndDate());

        if (projectRepository.findByProjectName(project1.getProjectName()) != null){
            model.addAttribute("errorProject", projectRepository.findByProjectName(project1.getProjectName()));
            return "projectcreation";
        }
        project1 = projectRepository.save(project1);
        model.addAttribute("success", "Project successfully added");
        System.out.println(project1.getProjectName() + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return "projectcreation";
    }

}
