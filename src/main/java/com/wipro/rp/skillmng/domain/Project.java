package com.wipro.rp.skillmng.domain;

import javax.persistence.Id;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectId;
    private String projectName;
    private String projectStartDate;
    private String projectEndDate;
    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(String projectId, String projectName, String projectStartDate, String projectEndDate, List<Employee> employeeList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.employeeList = employeeList;
    }

    public Project(String projectId, String projectName, String projectStartDate, String projectEndDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(projectId, project.projectId) && Objects.equals(projectName, project.projectName) && Objects.equals(projectStartDate, project.projectStartDate) && Objects.equals(projectEndDate, project.projectEndDate) && Objects.equals(employeeList, project.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, projectName, projectStartDate, projectEndDate, employeeList);
    }
}
