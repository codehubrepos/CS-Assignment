package com.assignment.analyzer.model;

public class LoggerLine {
    private long timestamp;
    private String id;
    private String state;
    private String host;
    private String type;
    
	public LoggerLine(long timestamp, String id, String state, String host, String type) {
		super();
		this.timestamp = timestamp;
		this.id = id;
		this.state = state;
		this.host = host;
		this.type = type;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ServerLog [timestamp=" + timestamp + ", id=" + id + ", state=" + state + ", host=" + host + ", type="
				+ type + "]";
	}
}
