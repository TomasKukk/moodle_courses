package com.example.moodle_courses.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoodleCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String courseName;
	private String courseLink;
	public long getId() {
		return id;
	}
	public MoodleCourse() {}
	public MoodleCourse(String courseName, String courseLink) {
		this.courseName = courseName;
		this.courseLink = courseLink;
	}
	public void setId(long id) {
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
