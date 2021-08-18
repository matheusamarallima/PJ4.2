package com.wipro.rp.skillmng.web;

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

@Controller
public class ProjectListController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectListController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("projectlist")
    public String projectList(Model model){
        model.addAttribute("projectList", projectService.projectList());
        return "projectlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") Long id, Model model){
        Project project = projectRepository.findByProjectId(id);
        if(project.getEmployeeList() != null){
            model.addAttribute("employeeList", projectRepository.findByProjectId(id).getEmployeeList());
            return "redirect:/projectlist";
        }
        projectRepository.delete(projectRepository.findByProjectId(project.getId()));
        return "redirect:/projectlist";
    }

    @GetMapping("/editpr/{id}")
    public String editProject(@PathVariable("id") Long id, Model model){
        model.addAttribute("id", id);
        return "redirect:/editproject/{id}";
    }

    @GetMapping("editproject/{id}")
    public String processEdit(Model model,
                              @PathVariable("id") Long id) {
        Project project = projectRepository.findByProjectId(id);
        model.addAttribute("project", project);
        model.addAttribute("projectDataForm", new ProjectDataForm());

        return "editproject";
    }

//    @PostMapping("/editproject/{project}")
//    public String saveEditProject(Model model,
//                                  ProjectDataForm projectDataForm,
//                                  @PathVariable("id") Long id){
//
//        projectRepository.save(projectDataForm.DTOtoEntity(projectDataForm));
//        model.addAttribute("success", "User created test");
//        return "redirect:/employeelist";
//
//
//
//    }

}
