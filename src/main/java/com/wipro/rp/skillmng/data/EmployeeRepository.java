package com.wipro.rp.skillmng.data;

import java.util.List;
import java.util.Optional;

import com.wipro.rp.skillmng.domain.Project;
import com.wipro.rp.skillmng.domain.User;
import com.wipro.rp.skillmng.service.EditForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.rp.skillmng.domain.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeRepository
	extends CrudRepository<Employee, Long>{
	List<Employee> findAllByOrderByName();
	Employee findByUserUsernameAndPetName(String username, String petName);
    Optional<Employee> findByName(String name);
    Employee findEmployeeById(Long id);
    Employee findEmployeeByName(String name);

    Employee findByUserUsername(User user);

    List<Employee> findAllByProjectId(Long id);

    @Query("select e from Employee e where e.user.username = ?1")
    Employee findEmployeeByUserUsername(String username);

}
