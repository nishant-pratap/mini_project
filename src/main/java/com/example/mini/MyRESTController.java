package com.example.mini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class MyRESTController {

//    @RequestMapping(value = "/")
//  
//  public String hello() {
//    return "index.html";
//  }
    
	@Autowired
	private EmployeeRepository repository;
	
	
	
    @RequestMapping("/api/create")
    
    public String create(Employee e) {
    	System.out.println(e.getName());
    		
    		repository.save(e);
    		return e.getAge();
    }


}