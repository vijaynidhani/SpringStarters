package com.nidhani.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nidhani.model.Student;
import com.nidhani.model.StudentLogin;
import com.nidhani.service.StudentService;
import com.nidhani.user.UserSession; 


@Controller
@SessionAttributes("student")
public class StudentController {
	
	Logger log=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	UserSession userSession;
		
	@Autowired
	private StudentService studentService;
		
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();		
		model.addAttribute("student", student);		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "signup";
		} else if(studentService.findByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			studentService.save(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {			
		StudentLogin studentLogin = new StudentLogin();		
		model.addAttribute("studentLogin", studentLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "login";
		} else {
			boolean found = studentService.findByLogin(studentLogin.getUserName(), studentLogin.getPassword());
			if (found) {		
				model.addAttribute("name", studentLogin.getUserName());
				// TODO Create user session bean and add it to the session. 
				userSession.setName(studentLogin.getUserName());
				log.info("User "+studentLogin.getUserName()+" login time : "+userSession.getLoginTime());
				return "success";
			} else {				
				return "failure";
			}
		}		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		// TODO Remove User session bean and add it to the session.
	    session.invalidate();
		return "login";
	}
	
}
