package com.idp.web.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.web.test.controller.StudentController;
import com.idp.web.test.entity.Student;
import com.idp.web.test.service.StudentService;

@Controller
@RequestMapping("/users")
public class UserController {

//    @RequestMapping("/layoutvc")
//    public String getUserPartialPage() {
//    	System.out.println("layoutvc -------");
//        return "userspage/layout";
//    }
	private Logger logger = Logger.getLogger(StudentController.class);

	@Resource
	private StudentService studentService;
	
	
    @RequestMapping("/login")
    public String getUserPartialPage() {
    	System.out.println("login -------");
        return "login/login";
    }
    @RequestMapping("/home")
    public String getUserHomePage() {
    	System.out.println("home -------");
        return "homepage/homepage";
    }
    
    @RequestMapping("/list1")
    @ResponseBody
	public List<Student> list1(){
    	List<Student> students = studentService.findBySearch(null);
    	for(Student student : students){
    		System.out.println(student.getName()+"   "+student.getAge()+"  "+student.getPhone());
    	}
    	return students;
	}
    
	
    
	
}
