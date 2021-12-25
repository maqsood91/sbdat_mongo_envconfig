package com.maqcoding.sbdat_mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@ToString
@Document("student")
public class Student {

        @Id
        private int id;
        private String name;
        
        private String city;
        private String college;
        
       
}