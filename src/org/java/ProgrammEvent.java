package org.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	// methods
	public void addEvent(Event e) {
		events.add(e);
	}

	public List<Event> getEventsOnDate(LocalDate date) {

		List<Event> eventsOnDate = new ArrayList<>();

		for (Event event : events) {

			if (event.getDate().equals(date)) {
				eventsOnDate.add(event);
			}

		}

		return eventsOnDate;
	}

	public void clearList() {
				
			events.clear();
	}
	
	public List<Event> getEventsSortedByDate(LocalDate date) {
		List<Event> filteredEvent = new ArrayList<>();
		for (Event e : getEvents()) 
			if (date.isEqual(e.getDate()))
				filteredEvent.add(e);
		
		return filteredEvent; 
    }

	
}
