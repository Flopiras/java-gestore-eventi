package org.java;

public class Event {

	private String title;
	private String date;
	private int seatsCapacity;
	private int reservedSeats;
	
	public Event(String title, String date, int seatsCapacity) {
		
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

	public void setDate(String date) {
		this.date = date;
	}

	public int getSeatsCapacity() {
		return seatsCapacity;
	}

	public void setSeatsCapacity(int seatsCapacity) {
		this.seatsCapacity = seatsCapacity;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	
	
}
