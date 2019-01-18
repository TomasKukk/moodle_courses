package com.example.moodle_courses.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moodle_courses.domain.CourseRepository;
import com.example.moodle_courses.domain.MoodleCourse;

@Controller
public class MainController {
	
	@Autowired
	private CourseRepository repo;
	
	@RequestMapping("/index")
	public String showAllCourses (Model model) {
		model.addAttribute(new MoodleCourse());
		return "index";
	}
}
