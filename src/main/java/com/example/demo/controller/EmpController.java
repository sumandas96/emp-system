package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView home() {
		
//		List<Employee> emp = service.getAllEmp();
//		m.addAttribute("emp",emp);
		List<Employee> emp = service.getAllEmp();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("emp",emp);
	    

	        return modelAndView;
		
//		 return new ModelAndView("index");
	}
	
	@GetMapping("/addemp")
	public String emp() {
		return "add_emp";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e = service.getID(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@GetMapping("/delete/{id}")
	public String empDelete(@PathVariable int id,HttpSession session) {
	
		service.deleteID(id);
		session.setAttribute("msg", "Data Deleted Sucessfully");
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String empReg(@ModelAttribute Employee e,HttpSession session) {
		
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Data Added Successfully..");
		
		return "redirect:/";
		
	}
	
	@PostMapping("/update")
	public String empUpdate(@ModelAttribute Employee e,HttpSession session) {
		
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Data Updated Successfully..");
		
		return "redirect:/";
		
	}

}
