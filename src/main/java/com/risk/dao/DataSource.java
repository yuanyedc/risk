package com.risk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.DB;

@Component
public class DataSource {

	private final MongoDbFactory mongo;

	@Autowired
	public DataSource(MongoDbFactory mongo) {
		this.mongo = mongo;
	}
	
	public void connectDB(){
		DB db = mongo.getDb();
	}
}
