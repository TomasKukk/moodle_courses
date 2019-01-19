package com.example.moodle_courses.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends CrudRepository<MoodleCourse, Long> {
	List<MoodleCourse> findByCourseName(@Param("name") String name);
}
