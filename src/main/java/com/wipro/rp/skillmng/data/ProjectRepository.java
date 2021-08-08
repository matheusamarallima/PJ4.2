package com.wipro.rp.skillmng.data;

import com.wipro.rp.skillmng.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

    public List<Project> findAll();
}
