package com.example.moodle_courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.moodle_courses.domain.MongoRepo;
import com.example.moodle_courses.domain.MoodleCourse;
import com.example.moodle_courses.domain.User;
import com.example.moodle_courses.domain.UserRepo;

@SpringBootApplication
public class MoodleCoursesApplication {

	private List<MoodleCourse> kurssit;

	public MoodleCoursesApplication(List<MoodleCourse> kurssit) {
		this.kurssit = new ArrayList<>();
	}
	public static void main(String[] args) {
		SpringApplication.run(MoodleCoursesApplication.class, args);
	}
	// tehdään kurssit ja käyttäjät ohjelman alkaessa
	@Bean
	public CommandLineRunner demo (MongoRepo mrepo, UserRepo urepo) {
		return (args) -> {
			mrepo.deleteAll();
			urepo.deleteAll();
			kurssit.add(new MoodleCourse("Palvelinohjelmointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=18295"));
			kurssit.add(new MoodleCourse("Matikka", 
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=23488"));
			kurssit.add(new MoodleCourse("Innovointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=22782"));
			kurssit.add(new MoodleCourse("Yrityksen toiminnot",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=22107"));
			kurssit.add(new MoodleCourse("Java-Ohjelmointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=21311"));
			kurssit.add(new MoodleCourse("Opon kurssi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=11493"));
			mrepo.saveAll(kurssit);
			User user1 = new User("admin", "$2a$04$6igRFe7Ej12wI8qCH6nwVuzBSZP3Usbp1LpSihpHEJ/IOmvn6wCwO", "ADMIN");
			User user2 = new User("user", "$2a$04$CTwjU69SNSNRxUOc477ZXuqjKryyh8XRnWX6GsEYJMjxgEQKyoX6m", "USER");
			
			user1.setCourses(kurssit);
			urepo.save(user1);
			urepo.save(user2);
			List<User> users = urepo.findAll();
			// debuggaamista varten tulostetaan käyttäjät
			for (User u: users) {
				System.out.println(u.toString());
			}

		};
	}
}

