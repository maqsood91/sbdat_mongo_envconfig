package com.maqcoding.sbdat_mongo.rest;

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
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentRepo studentRepo;
	
	

	
	@GetMapping("/list")
	public ResponseEntity<?> getAllStudent() {
		return ResponseEntity.ok(this.studentRepo.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable final int id ) {
		return ResponseEntity.ok(this.studentRepo.findById(id));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
		return ResponseEntity.ok(this.studentRepo.save(student));
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable final int id) {
        this.studentRepo.deleteById(id);		
	}
	
	
	
}
