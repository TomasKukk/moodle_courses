package com.example.moodle_courses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.moodle_courses.web.MainController;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoodleCoursesApplicationTests {
	
	// bringing getters and setters
	@Autowired
	private MainController controller;
	
	// Lets test that controller exists in project and works
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}

