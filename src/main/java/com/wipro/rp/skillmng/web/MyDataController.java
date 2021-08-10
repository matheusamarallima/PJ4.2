package com.wipro.rp.skillmng.web;

import com.wipro.rp.skillmng.data.EmployeeRepository;
import com.wipro.rp.skillmng.service.MyDataForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyDataController {

    private EmployeeRepository employeeRepository;

    public MyDataController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/mydata")
    public String myData(Model model){
        model.addAttribute("myDataForm", new MyDataForm());
        return "mydata";
    }



}
