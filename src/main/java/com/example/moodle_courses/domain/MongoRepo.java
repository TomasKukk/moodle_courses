package com.example.moodle_courses.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// repository kursseille, extends mongorepo, että saadaan tallennettua db:hen
public interface MongoRepo extends MongoRepository<MoodleCourse, String> {
	public List<MoodleCourse> findByCourseName(String courseName);
}
