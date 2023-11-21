package org.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Event {

	private String title;
	private String date;
	private int seatsCapacity;
	private int reservedSeats;

	public Event(String title, String date, int seatsCapacity) throws Exception {

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws Exception {

		LocalDate today = LocalDate.now();
		LocalDate eventDate = LocalDate.parse(date);
		
		// control
		if (eventIsExpired())
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
	public String getFormatDate(String inputDate) throws ParseException {

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Date date = inputDateFormat.parse(inputDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Locale locale = new Locale("it", "IT");
		DateFormat outputDateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

		String formattedDate = outputDateFormat.format(date);

		System.out.println(formattedDate);

		return formattedDate;
	}
	
	public boolean eventIsExpired() {
		
		LocalDate today = LocalDate.now();
		LocalDate eventDate = LocalDate.parse(date);
		
		return today.isAfter(eventDate) ? true : false;
		
	}
	
	public void prenota() throws Exception {
		
		if (eventIsExpired() || seatsCapacity < reservedSeats)
			throw new Exception("Impossibile prenotare i posti");
		
		reservedSeats += 1;	
	}
	
	public void disdici() throws Exception {
		if (eventIsExpired() || reservedSeats <= 0)
			throw new Exception("Non ci sono prenotazioni da disdire");
	}

}
