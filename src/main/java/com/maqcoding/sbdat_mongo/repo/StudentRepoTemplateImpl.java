package com.maqcoding.sbdat_mongo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.maqcoding.sbdat_mongo.model.Student;

@Component
public class StudentRepoTemplateImpl implements StudentRepoTemplate {

	@Autowired
	MongoTemplate template;
	
	
	@Override
	public void updateStudent(int id, String city) {
		// TODO Auto-generated method stub
		System.out.println("inside updateStudent ");
		Query query= new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("city", city);
		template.updateFirst(query, update, Student.class);
		

	}

}
