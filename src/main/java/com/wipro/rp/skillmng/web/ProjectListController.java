package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectListController {

    private final ProjectService projectService;

    @Autowired
    public ProjectListController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("projectlist")
    public String projectList(Model model){
        model.addAttribute("projectList", projectService.projectList());
        return "projectlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id, Model model){
        projectService.deleteProject(projectService.findProjectByName(id));
        return "redirect:/projectlist";
    }

//    @GetMapping("/edit/{id}")
//    public String editProject(@PathVariable("id") Long id, Model model){
//
//        projectRepository.delete(projectRepository.findById(id));
//        return "redirect:/studentlist";
//    }

}
