package com.kondawle.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kondawle.dao.EmployeeDao;
import com.kondawle.model.Employee;
import com.kondawle.model.EmployeeJsonResponse;

@Controller
public class TestController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/empreg")
	public String empreg(Model model) {
		model.addAttribute("employee", new Employee());
		List<Employee> employees = employeeDao.view();
		model.addAttribute("elist", employees);
		return "employeeregistration";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Employee employee) {
		System.out.println("Employeed Details Saved!!");
		employeeDao.add(employee);
		return new ModelAndView("redirect:/empreg");
	}
	
	@RequestMapping(value = "/delete/{Id}", method = RequestMethod.GET)
	public ModelAndView deleteData(@PathVariable("Id") Integer id, Model model) {
		employeeDao.delete(id);
		return new ModelAndView("redirect:/empreg");
	}

}
