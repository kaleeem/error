package com.example.Myssql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Myssql.Model.Student;
import com.example.Myssql.Repository.Repo;

@Controller
public class Scontroller {
@Autowired

Repo repo;

@RequestMapping("index")
public String index() {
	return "index.jsp";
	}
@RequestMapping("add")
public String add(Student stu) {
	repo.save(stu);
	return "success.jsp";
	}
@RequestMapping("success")
public String success() {
	return "index.jsp";
}
@RequestMapping("display")
public ModelAndView display(@RequestParam int id) {
	ModelAndView mv=new ModelAndView("display.jsp");
	Student stu = repo.findById(id).orElse(new Student());
	mv.addObject(stu);
	return mv;
}
@RequestMapping("delete")
public ModelAndView delete(@RequestParam int id) {
	ModelAndView mv=new ModelAndView("delete.jsp");
	Student stu = repo.findById(id).orElse(new Student());
	repo.deleteById(id);
	mv.addObject(stu);
	return mv;
}
@RequestMapping("update")
public ModelAndView update(Student stu) {
	ModelAndView mv=new ModelAndView("update.jsp");
	stu = repo.findById(stu.getId()).orElse(new Student());
	mv.addObject(stu);
	return mv;
}

















}
