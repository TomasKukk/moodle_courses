package com.example.moodle_courses;

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

	public static void main(String[] args) {
		SpringApplication.run(MoodleCoursesApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo (MongoRepo mrepo, UserRepo urepo) {
		return (args) -> {
			mrepo.deleteAll();
			urepo.deleteAll();
			mrepo.save(new MoodleCourse("Palvelinohjelmointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=18295"));
			mrepo.save(new MoodleCourse("Matikka", 
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=23488"));
			mrepo.save(new MoodleCourse("Innovointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=22782"));
			mrepo.save(new MoodleCourse("Yrityksen toiminnot",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=22107"));
			mrepo.save(new MoodleCourse("Java-Ohjelmointi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=21311"));
			mrepo.save(new MoodleCourse("Opon kurssi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=11493"));
			mrepo.save(new MoodleCourse(
					"Opon kurssi",
					"https://hhmoodle.haaga-helia.fi/course/view.php?id=11493"));
			List<MoodleCourse> courses = mrepo.findAll();
			for (MoodleCourse c: courses) {
				System.out.println(c.id);
			}
			User user1 = new User("admin", "$2a$04$6igRFe7Ej12wI8qCH6nwVuzBSZP3Usbp1LpSihpHEJ/IOmvn6wCwO", "ADMIN");
			User user2 = new User("user", "$2a$04$CTwjU69SNSNRxUOc477ZXuqjKryyh8XRnWX6GsEYJMjxgEQKyoX6m", "USER");
			urepo.save(user1);
			urepo.save(user2);
			List<User> users = urepo.findAll();
			for (User c: users) {
				System.out.println(c.toString());
			}
		};
	}
}

