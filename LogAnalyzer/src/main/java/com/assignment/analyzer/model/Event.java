package com.assignment.analyzer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;

@Entity
public class Event {
	
	@Id
    private String id;
    private long duration;
    private boolean alert;
    private String host;
    private String type;
    
    public Event() {
    	
	}
    
	public Event(String id, long duration, boolean alert, String host,String type) {
		super();
		this.id = id;
		this.duration = duration;
		this.alert = alert;
		this.host = host;
		this.type = type;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", duration=" + duration + ", alert=" + alert + ", type=" + type + ", host=" + host
				+ "]";
	}
}
