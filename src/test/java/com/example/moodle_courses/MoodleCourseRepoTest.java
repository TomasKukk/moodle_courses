package com.example.moodle_courses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.moodle_courses.domain.MongoRepo;
import com.example.moodle_courses.domain.MoodleCourse;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MoodleCourseRepoTest {
	
	// Getters and setters
	
	@Autowired
	private MongoRepo repo;
	
	// luodaan pari kurssia ennen testejen ajoa
	@Before
	public void doBefore() {
		MoodleCourse course = new MoodleCourse("name", "link");
		MoodleCourse courseTwo = new MoodleCourse("anotherCourse", "linktoMoodle");
		repo.save(course);
		repo.save(courseTwo);
	}
	
	// testataan että kurssien luominen onnistui
	@Test
	public void createNewMoodleCourse() {
		assertThat(repo.findAll()).isNotEmpty();
	}
	
	// testataan, että kurssin etsiminen nimellä palauttaa oikean kurssin
	@Test
	public void findCourseByNameShouldReturnCourse() {
		List<MoodleCourse> courses = repo.findByCourseName("name");
		assertThat(courses.get(0)).isNotNull();
		assertThat(courses.get(0).getCourseName()).isEqualTo("name");
	}
	
	// testataan reposta kurssien poistoa, että toimii
	@Test
	public void deleteAllCourses() {
		repo.deleteAll();
		assertThat(repo.findAll()).isEmpty();
	}
	
	
	
	
	
	
}
