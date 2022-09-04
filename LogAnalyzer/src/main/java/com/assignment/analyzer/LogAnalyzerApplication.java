package com.assignment.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.analyzer.service.LogParserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LogAnalyzerApplication implements CommandLineRunner{

	
	
	@Autowired
	private LogParserService logParserService;
	
	private static final org.slf4j.Logger log = 
			org.slf4j.LoggerFactory.getLogger(LogAnalyzerApplication.class);
	
	
	public static void main(String[] args) {
		log.info("*****Starting LogAnalyzerApplication*****");
		SpringApplication logEventApp = new SpringApplication(LogAnalyzerApplication.class);
		logEventApp.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args ==null || args.length !=1) {
			log.error("*****Input file for logger analysis not provided*****");
			throw new IllegalArgumentException("Invalid Argument, Atleast one aargument expected.");
		}
		
		log.info("*****Starting Parsing the Server Logs*****");
		logParserService.parseServerLogs(args[0]);
	}

}
