package com.wipro.rp.skillmng.service;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.data.UserRepository;
import com.wipro.rp.skillmng.domain.Employee;
import com.wipro.rp.skillmng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    public boolean createEmployee(Employee employee) {
        if (findEmployeeByName(employee.getName()) == null) {
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee findEmployeeByName(String name) {
        Optional<Employee> employee = employeeRepository.findByName(name);
        return employee.orElse(null);//retorna ou o projeto ou ele retorna nulo
        //caso ela coloque algo q n exista, ele trata para não quebrar o código
    }


    public Employee findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);//retorna ou o projeto ou ele retorna nulo
        //caso ela coloque algo q n exista, ele trata para não quebrar o código
    }

    public boolean editEmployee(Employee employee) {
        if(findEmployeeByName(employee.getName()) != null){
            employeeRepository.save(employee);
            return true;

        }
        return false;
    }

}
