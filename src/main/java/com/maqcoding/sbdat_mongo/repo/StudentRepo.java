package com.maqcoding.sbdat_mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maqcoding.sbdat_mongo.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>,StudentRepoTemplate{

	
}
