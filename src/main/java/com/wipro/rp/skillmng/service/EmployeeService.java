package com.wipro.rp.skillmng.service;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean createEmployee(Employee employee){
        if(findEmployeeByName(employee.getName()) == null){
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }


    public Employee findEmployeeByName(String name){
        Optional<Employee> employee = employeeRepository.findByName(name);
        return employee.orElse(null);//retorna ou o projeto ou ele retorna nulo
        //caso ela coloque algo q n exista, ele trata para não quebrar o código
    }

}
