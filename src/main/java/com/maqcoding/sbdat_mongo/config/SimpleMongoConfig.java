package com.maqcoding.sbdat_mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class SimpleMongoConfig {
	
	@Value("${host}")
	String host;
	
	@Value("${port}")
	String port;
	
	@Value("${database}")
	String database;
	@Value("${test}")
	String test;
 
    @Bean
    public MongoClient mongo() {
       System.out.println("mongodb://"+host+":"+port+"/"+database+"---test-"+test);
    	
    	// ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
    	ConnectionString connectionString = new ConnectionString("mongodb://"+host+":"+port+"/"+database);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                                                  .applyConnectionString(connectionString)
                                                  .build();
        
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
}
