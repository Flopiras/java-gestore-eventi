package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

	private String title;
	private LocalDate date;
	private int seatsCapacity;
	private int reservedSeats;

	public Event(String title, LocalDate date, int seatsCapacity) throws Exception {

		reservedSeats = 0;

		setTitle(title);
		setDate(date);
		setSeatsCapacity(seatsCapacity);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) throws Exception {

		// control
		if (eventIsExpired(date))
			throw new Exception("La data è già passata");

		this.date = date;
	}

	public int getSeatsCapacity() {
		return seatsCapacity;
	}

	private void setSeatsCapacity(int seatsCapacity) throws Exception {
		
		//control
		if(seatsCapacity <= 0)
			throw new Exception("I posti totali non possono essere meno di 1");
			
		this.seatsCapacity = seatsCapacity;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	// METHODS
	public String getFormatDate(LocalDate date) {

		//LocalDate localDate = LocalDate.parse(date);
        return date.format(DateTimeFormatter.ofPattern("dd/LLLL/yyyy"));
			
	}
	
	public boolean eventIsExpired(LocalDate date) {
		
		LocalDate today = LocalDate.now();
		
		return today.isAfter(date) ? true : false;
		
	}
	
	public void prenota() throws Exception {
		
		if (eventIsExpired(date) || seatsCapacity < reservedSeats)
			throw new Exception("Impossibile prenotare i posti");
		
		reservedSeats += 1;	
	}
	
	public void disdici() throws Exception {
		if (eventIsExpired(date) || reservedSeats <= 0)
			throw new Exception("Non ci sono prenotazioni da disdire");
		
		reservedSeats -= 1;
	}
	
	public int getAvaiableSeats() {
		
		return (seatsCapacity - reservedSeats);
	}
	
	//overrides
	@Override
	public String toString() {
		
		
		return getFormatDate(date) + " - " + getTitle();
	}

}
