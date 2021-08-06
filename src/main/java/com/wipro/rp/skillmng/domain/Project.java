package com.wipro.rp.skillmng.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Project {

    @Id
    private long Id;
    private String projectId;
    private String projectName;
    private String startDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee")
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(long id, String projectId, String projectName, String startDate, List<Employee> employeeList) {
        Id = id;
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.employeeList = employeeList;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        return Id == project.Id && Objects.equals(projectId, project.projectId) && Objects.equals(projectName, project.projectName) && Objects.equals(startDate, project.startDate) && Objects.equals(employeeList, project.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, projectId, projectName, startDate, employeeList);
    }

    @Override
    public String toString() {
        return "Project{" +
                "Id=" + Id +
                ", projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
