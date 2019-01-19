package com.example.moodle_courses.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moodle_courses.domain.CourseRepository;
import com.example.moodle_courses.domain.MoodleCourse;

@Controller
public class MainController {
	// Asettaa setterit ja getterit automaattisesti
	@Autowired
	private CourseRepository repo;
	
	// Kurssien lisäämiselle
	@RequestMapping("/addcourse")
	public String showAllCourses (Model model) {
		model.addAttribute("moodlecourse", new MoodleCourse());
		return "addcourse";
	}
	// Get pyyntö kaikkien kurssien näyttämiseen
	@GetMapping("/index")
	public String showCourses (Model model) {
		model.addAttribute("courses", repo.findAll());
		return ("/index");
	}
	// Tämä hoitaa POST pyynnön joka lisää uuden kurssin
	@PostMapping("/index")
	public String addNewCourse (MoodleCourse course) {
		repo.save(course);
		return ("redirect:/index");
	}
	//Käydyn kurssin poistaminen
	@GetMapping("/delete/{id}")
	public String deleteCourse (@PathVariable("id")Long courseId,
			Model model) {
		repo.deleteById(courseId);
		return ("redirect:/index");
	}
	
	//Kurssin nimen tai linkin editoimiseen
	@RequestMapping("/edit/{id}")
	public String editCourse (@PathVariable("id")Long courseId,
			Model model) {
		model.addAttribute("moodlecourse", repo.findById(courseId));
		return ("edit");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
