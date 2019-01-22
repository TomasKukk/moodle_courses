package com.example.moodle_courses.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

//mongo collection users joka tallentaa column kentät db:hen
@Document(collection="users")
public class User {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	private String id;
	
	

	@Column(name="username", nullable = false, unique=true)
	private String username;
	
	@Column(name="password",nullable = false, updatable = false)
	private String passwordHash;
	
	@Column(name="role", nullable = false)
	private String role;	
	public List<MoodleCourse> getCourses() {
		return courses;
	}
	@Column(name="courses", nullable=false, updatable=true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<MoodleCourse> courses;
	public void setCourses(List<MoodleCourse> courses) {
		this.courses = courses;
	}
	public User() {
	}

	public User(String username, String passwordHash, String role) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}