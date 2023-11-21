package org.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	//open Scanner
    	Scanner in = new Scanner(System.in);
    	
    	try {
    		System.out.println("Nome evento: ");
    		String title = in.nextLine();
    		
    		System.out.println("Data evento (yyyy-mm-dd): ");
    		String date = in.nextLine();
    		
    		System.out.println("Numero di posti totale: ");
    		String strSeatcCapacity = in.nextLine();
    		int seatCapacity = Integer.valueOf(strSeatcCapacity);
    		
    		Event e = new Event(title, date, seatCapacity);
    		
    		System.out.println(e.toString());
    		
    	} catch (Exception e) {
    		System.out.println("ERRORE: " + e.getMessage());
    	}
    	
    	//close Scanner
    	in.close();
    }
}
