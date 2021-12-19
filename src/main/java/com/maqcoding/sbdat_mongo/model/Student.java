package com.maqcoding.sbdat_mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Document("student")
@Getter
@Setter
public class Student {

        @Id
        private int id;
        private String name;
        private String city;
        private String college;
        
       
}