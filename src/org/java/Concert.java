package org.java;

import java.math.BigDecimal;

public class Concert extends Event {
	
	private String time;
	private String price;

	public Concert(String title, String date, int seatsCapacity, String time, String price) throws Exception {
		super(title, date, seatsCapacity);

		setTime(time);
		setPrice(price);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	

}
