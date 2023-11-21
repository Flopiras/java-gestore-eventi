package org.java;

import java.util.ArrayList;
import java.util.List;

public class ProgrammEvent {

	private String title;
	private List<Event> events;
	
	public ProgrammEvent(String title) {
		
		events = new ArrayList<>();
		setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	//methods
	
}
