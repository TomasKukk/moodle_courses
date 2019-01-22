package com.example.moodle_courses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.moodle_courses.web.MainController;

@RunWith(SpringRunner.class)
//@WebMvcTest(MainController.class)
public class WebLayerTest {
//	@Autowired
//	private MockMvc mock;
	
	@Test
	public void testTesting() {
		int i = 20;
		assertThat(i).isEqualTo(20);
	}
}
