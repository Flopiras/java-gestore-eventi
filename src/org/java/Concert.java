package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
	
	private LocalTime time;
	private BigDecimal price;

	public Concert(String title, LocalDate date, int seatsCapacity, LocalTime time, BigDecimal price) throws Exception {
		super(title, date, seatsCapacity);

		setTime(time);
		setPrice(price);
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	//methods
	public String getFormattedTime(LocalTime time) {
		
		return time.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public String getFormattedPrice(BigDecimal price) {
		
		return String.format("%,.2f €", price);
	}
	
	//overrides
	@Override
	public String toString() {
		
		return getFormatDate(getDate()) + " " 
				+ getFormattedTime(time) + " - "
				+ getTitle() + " - " + getFormattedPrice(price)
				;
	}
	

}
