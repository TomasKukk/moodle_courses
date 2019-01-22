package com.example.moodle_courses.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.moodle_courses.domain.MongoRepo;
import com.example.moodle_courses.domain.MoodleCourse;

@Controller
public class MainController {
	// Asettaa setterit ja getterit automaattisesti
	@Autowired
	private MongoRepo repo;
	

	
	// Restful kaikki kurssi (json)
	@GetMapping("/courses")
	public @ResponseBody List<MoodleCourse> courseListRest() {
		System.out.print(repo.findAll());
		return (List<MoodleCourse>) repo.findAll();
	}
	// redirect to login page
	@RequestMapping("/login")
	public String goToLogin() {
		return ("login");
	}
	// Redirect to index when /login throws to /
//	@RequestMapping("/")
//	public String toIndex () {
//		return ("redirect:/index");
//	}
	
	// Etsitään kurssi nimellä restful (palauttaa json) onnistuu /api/moodleCourses/{id} avulla 
	
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
		return ("index");
	}
	// Tämä hoitaa POST pyynnön joka lisää uuden kurssin
	@PostMapping("/index")
	public String addNewCourse  (MoodleCourse course) {
		repo.save(course);
		return ("redirect:/index");
	}
//	//Käydyn kurssin poistaminen
	@GetMapping("/delete/{id}")
	public String deleteCourse (@PathVariable String id,
			Model model) {
		repo.deleteById(id);
		return ("redirect:/index");
	}
	
	//Kurssin nimen tai linkin editoimiseen
	@RequestMapping("/edit/{id}")
	public String editCourse (@PathVariable String id,
			Model model) {
		model.addAttribute("moodlecourse", repo.findById(id));
		return ("edit");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
