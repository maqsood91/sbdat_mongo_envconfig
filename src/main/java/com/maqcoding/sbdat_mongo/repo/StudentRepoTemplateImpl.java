package com.maqcoding.sbdat_mongo.repo;


import java.util.Iterator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.maqcoding.sbdat_mongo.model.Student;
import com.mongodb.client.MongoCursor;

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


	@Override
	public void getStudentWithMongoTemplateQuery() {
		// TODO Auto-generated method stub
		
		System.out.println("inside getStudentWithMongoTemplateQuery");
		
		 String [] searchAttr= new String[]  {"city"};
		 String [] searchParam = new String[] {"muz"};
		
         org.bson.Document qqry =new org.bson.Document();		  
        
         for(int i=0; i < searchAttr.length;i++) {
        	  qqry.append(searchAttr[i],searchParam[i]);
        	  System.out.println("q--"+qqry.toJson());
         }
         System.out.println("q-1-"+qqry.toJson());
         System.out.println("2--"+template.getCollectionNames());
         System.out.println("2--"+template.getCollection("student").countDocuments());
         System.out.println("2--"+template.getDb().toString());
         MongoCursor<Document> itr= template.getCollection("student").find(qqry).iterator();
			
			while(itr.hasNext()) {
				System.out.println("iter--"+itr.next().toString());
			}
             
		
		
            
		
	}


	@Override
	public void updatestudentWithMongoTemplateQuery() {
		// TODO Auto-generated method stub
		System.out.println("inside updatestudentWithMongoTemplateQuery");
		
		 String [] searchAttr= new String[]  {"city"};
		 String [] searchParam = new String[] {"London"};
		
        org.bson.Document searchqqry =new org.bson.Document();		  
       
        for(int i=0; i < searchAttr.length;i++) {
        	searchqqry.append(searchAttr[i],searchParam[i]);
       	  System.out.println("q--"+searchqqry.toJson());
        }
        System.out.println("q-1-"+searchqqry.toJson());
        System.out.println("2--"+template.getCollectionNames());
        System.out.println("2--"+template.getCollection("student").countDocuments());
        System.out.println("2--"+template.getDb().toString());
        
        //update 

		 String [] updateAttr= new String[]  {"college"};
		 String [] paramParam = new String[] {"oxford"};
		 org.bson.Document updateqqry =new org.bson.Document();
		 
		 for(int i=0; i < updateAttr.length;i++) {
			  updateqqry.append(updateAttr[i],paramParam[i]);
	       	  System.out.println("q--"+updateqqry.toJson());
	        }
		 
		 org.bson.Document updateDoc =new org.bson.Document("$set",updateqqry);
		System.out.println("rs"+template.getCollection("student").updateOne(searchqqry, updateDoc));
        
        
            
	}

}
