package com.assignment.analyzer.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.analyzer.model.Event;
import com.assignment.analyzer.model.LoggerLine;
import com.assignment.analyzer.repository.EventRepository;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogParserService {

	private static final org.slf4j.Logger logger = 
			org.slf4j.LoggerFactory.getLogger(LogParserService.class);
	
	@Autowired
	private EventRepository eventRepository;
	
	
	private Event event;
	
	public void readLogs() {
		
	}
	
	public void parseServerLogs(String path) {
		logger.info("*****Inside parseServerLogOptimized method*****");
		
		Stream<String> lines;
		HashMap<String, LoggerLine> eventsMap = new HashMap<>();
		Gson gson = new Gson();
		try {
			lines = Files.lines(Paths.get(path));
			lines.forEach(line -> {
				
				LoggerLine log = gson.fromJson(line, LoggerLine.class);
	            String eventId = log.getId();
	            if (!eventsMap.containsKey(eventId)) {
	                eventsMap.put(eventId, log);
	            }
	            
	            else {
	            	LoggerLine previousLog = eventsMap.remove(eventId);
		            long duration = Math.abs(log.getTimestamp() - previousLog.getTimestamp());
		            boolean alert = false;
		            if (duration > 4) {
		                alert = true;
		            }
		            
		            if(alert) {
		            	String host = previousLog.getHost();
		                String type = previousLog.getType();
		                event = buildEvents(eventId,duration,alert,host,type);
		                eventRepository.save(event);
		            }
	            }
              
			});
			
		} catch (FileNotFoundException fe) {
			logger.error("Exception occured reading file %s " , fe);
        }
		
		catch (IOException ie) {
			logger.error("Exception occured reading file %s " , ie);
		}
	}
	
	public Event buildEvents(String eventId, long duration, boolean alert, String host,String type) {
		
		logger.info("*****Inside buildEvents method*****");
		event = new Event();
        event.setId(eventId);
        event.setDuration(duration);
        event.setAlert(alert);
        event.setHost(host);
        event.setType(type);
        return event;
	}
}
