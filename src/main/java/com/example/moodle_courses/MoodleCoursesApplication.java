package com.example.moodle_courses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.moodle_courses.domain.CourseRepository;
import com.example.moodle_courses.domain.MoodleCourse;

@SpringBootApplication
public class MoodleCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodleCoursesApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo (CourseRepository repo) {
		return (args) -> {
			repo.save(new MoodleCourse("Palvelinohjelmointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=18295"));
			repo.save(new MoodleCourse("Matikka", 
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=23488"));
		};
	}
}

