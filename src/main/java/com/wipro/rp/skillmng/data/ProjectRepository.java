package com.wipro.rp.skillmng.data;

import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.Project;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();

    Optional<Project> findByProjectName(String projectName);


//    Project findProjectById(Long id);


}
