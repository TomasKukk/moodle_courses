package com.example.moodle_courses.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// repository käyttäjille, extends mongorepo että saaddaan tallennettua db:hen
@Repository
public interface UserRepo extends MongoRepository<User, String> {
	User findByUsername(String username);
}
