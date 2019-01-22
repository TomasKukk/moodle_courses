package com.example.moodle_courses.domain;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
// mongodb document courses joka tallentaa columnit db:hen
@Document(collection="courses")
public class MoodleCourse {
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private User user;
	
	@Id
	public String id;
	private String courseName;
	private String courseLink;
	public String getId() {
		return id;
	}
	public MoodleCourse() {}
	public MoodleCourse(String courseName, String courseLink) {
		this.courseName = courseName;
		this.courseLink = courseLink;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseLink() {
		return courseLink;
	}
	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}
	@Override
	public String toString() {
		return "MoodleCourse [id=" + id + ", courseName=" + courseName + ", courseLink=" + courseLink + "]";
	}
}
