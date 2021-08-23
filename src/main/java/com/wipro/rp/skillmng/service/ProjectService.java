package com.wipro.rp.skillmng.service;

import com.wipro.rp.skillmng.data.ProjectRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean createProject(Project project){
        if(findProjectByName(project.getProjectName()) == null){
            projectRepository.save(project);
            return true;

        }
        return false;
    }

    public void deleteProject(Project project){
        projectRepository.delete(project);
    }

    public List<Project> projectList(){
        return projectRepository.findAll();
    }

    public Project findProjectByName(String projectName){
        Optional<Project> project = projectRepository.findByProjectName(projectName);
        return project.orElse(null); //retorna ou o projeto ou ele retorna nulo
        //caso ela coloque algo q n exista, ele trata para não quebrar o código
    }

    public boolean editProject(Project project) {
        if(findProjectByName(project.getProjectName()) != null){
            projectRepository.save(project);
            return true;

        }
        return false;
    }

    }





