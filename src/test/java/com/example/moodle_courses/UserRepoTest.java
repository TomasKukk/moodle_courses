package com.example.moodle_courses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.moodle_courses.domain.MoodleCourse;
import com.example.moodle_courses.domain.User;
import com.example.moodle_courses.domain.UserRepo;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepoTest {
	
	// getterit ja setterit
	@Autowired
	private UserRepo repo;
	
	// tehdään pari testikäyttäjää ennen testien ajoa
	@Before
	public void doBefore() {
		User user = new User("admin", "password", "ADMIN");
		User userTwo = new User("user", "pass", "USER");
		repo.save(user);
		repo.save(userTwo);
	}
	
	// testataan että uudet kurssit on luotu
	@Test
	public void createNewCourse() {
		assertThat(repo.findAll()).isNotEmpty();
	}
	 // Testataan, että käyttäjän haku käyttäjänimellä toimii halutusti	
	@Test
	public void findUserByUsernameShouldReturnUser() throws Exception {
		User user = repo.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(user.getUsername()).isEqualTo("admin");
	}
	
	// testataan että käyttäjien poistaminen tietokannasta toimii
	@Test
	public void deleteAllCourses() {
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}
	

}
