package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectListController {

    ProjectRepository projectRepository;

    public ProjectListController (ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping("projectlist")
    public String projectList(Model model){
        model.addAttribute("projectList", projectRepository.findAll());
        return "projectlist";
    }

}
