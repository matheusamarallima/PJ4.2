package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id, Model model){

        projectRepository.delete(projectRepository.findByProjectName(id));
        return "redirect:/studentlist";
    }

//    @GetMapping("/edit/{id}")
//    public String editProject(@PathVariable("id") Long id, Model model){
//
//        projectRepository.delete(projectRepository.findById(id));
//        return "redirect:/studentlist";
//    }

}
