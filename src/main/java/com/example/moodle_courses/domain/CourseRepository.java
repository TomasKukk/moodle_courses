package com.example.moodle_courses.domain;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<MoodleCourse, Long> {
	
}
