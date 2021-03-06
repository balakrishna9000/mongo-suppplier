package com.dxctraining.mongoexperiments.suppliersmgt;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SuppliersmgtApplication {

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	public static void main(String[] args) {
		SpringApplication.run(SuppliersmgtApplication.class, args);

	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient client){
		MongoTemplate template=new MongoTemplate(client,databaseName);
		return template;
	}

}
