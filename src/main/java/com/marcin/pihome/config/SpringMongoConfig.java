package com.marcin.pihome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "pihomedb";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("192.168.0.11");
	}
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
	return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}
}