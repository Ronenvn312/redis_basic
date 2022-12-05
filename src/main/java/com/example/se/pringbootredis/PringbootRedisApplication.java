package com.example.se.pringbootredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class PringbootRedisApplication {
	private static final Logger LOG = LoggerFactory.getLogger(PringbootRedisApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PringbootRedisApplication.class, args);
		LOG.info("Springboot redis application is started successfully.");
	}

}
