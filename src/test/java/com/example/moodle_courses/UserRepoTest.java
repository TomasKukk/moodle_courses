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
	@Autowired
	private UserRepo repo;
	
	@Before
	public void doBefore() {
		User user = new User("admin", "password", "ADMIN");
		User userTwo = new User("user", "pass", "USER");
		repo.save(user);
		repo.save(userTwo);
	}
	
	@Test
	public void findUserByUsernameShouldReturnUser() throws Exception {
		User user = repo.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(user.getUsername()).isEqualTo("admin");
	}
	
	@Test
	public void createNewCourse() {
		assertThat(repo.findAll()).isNotEmpty();
	}
	
	@Test
	public void deleteAllCourses() {
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}
	

}
