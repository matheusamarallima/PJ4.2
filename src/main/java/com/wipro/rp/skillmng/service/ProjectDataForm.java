package com.wipro.rp.skillmng.service;

import com.wipro.rp.skillmng.domain.Project;

public class ProjectDataForm {

    private String projectId;
    private String projectName;
    private String projectStartDate;
    private String projectEndDate;

    public Project DTOtoEntity(ProjectDataForm projectDataForm){
        return new Project(projectDataForm.getProjectId(),
                projectDataForm.getProjectName(), projectDataForm.getProjectStartDate(),
                projectDataForm.getProjectEndDate());

    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }
}
