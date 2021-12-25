package com.maqcoding.sbdat_mongo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maqcoding.sbdat_mongo.model.Student;
import com.maqcoding.sbdat_mongo.repo.StudentRepo;

@RestController
@RequestMapping("/studenttemplate") 
public class StudentMongoTemplateController {
	
	
	@Autowired
	StudentRepo studentRepo;

	
	@GetMapping("/list")
	public ResponseEntity<?> getAllStudent() {
		 List<Student> students= this.studentRepo.findAll();
		 
		 for(Student student1 : students) {
			 System.out.println("student--"+student1.getName());
		 } 
		 //students.forEach(student -> {});
		return ResponseEntity.ok( this.studentRepo.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable final int id ) {
		return ResponseEntity.ok(this.studentRepo.findById(id));
		
	}
	
	@GetMapping("/query")
	public void getStudent1( ) {
		this.studentRepo.getStudentWithMongoTemplateQuery();
		
	}
	
	@GetMapping("/updquery")
	public void getStudent2( ) {
		this.studentRepo.updatestudentWithMongoTemplateQuery();
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
		return ResponseEntity.ok(this.studentRepo.save(student));
		
	}
	
	@PostMapping("/updatetemplate/{id}")
	public void updateStudent(@PathVariable final int id) {
		 this.studentRepo.updateStudent(id, "London");
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable final int id) {
        this.studentRepo.deleteById(id);		
	}
}
