package org.java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		// open Scanner
		Scanner in = new Scanner(System.in);

		Event event = null;

		try {
			System.out.println("Nome evento: ");
			String title = in.nextLine().trim();

			System.out.println("Data evento (yyyy-mm-dd): ");
			String date = in.nextLine().trim();

			System.out.println("Numero di posti totale: ");
			String strSeatcCapacity = in.nextLine().trim();
			int seatCapacity = Integer.valueOf(strSeatcCapacity);

			event = new Event(title, date, seatCapacity);

			System.out.println("\n-------------------------------\n" + "Evento: " + event.getTitle() + "\n" + "Data: "
					+ event.getFormatDate(date) + "\n" + "Posti prenotati: " + event.getReservedSeats() + "\n"
					+ "Posti disponibili" + event.getAvaiableSeats() + "\n-------------------------------\n");

		} catch (Exception e) {
			System.out.println("ERRORE: " + e.getMessage());
		}
		
		//reserve
		System.out.println("Vuoi effettuare una prenotazione?");
		String userInput = in.nextLine();

		if (userInput.equals("si")) {
			
			try {

				System.out.println("Quanti posti vuoi prenotare?");
				userInput = in.nextLine();
				int reserveSeats = Integer.valueOf(userInput);

				for (int x = 0; x < reserveSeats; x++) {

					event.prenota();
				}

			} catch (Exception e) {
				System.out.println("ERRORE: " + e.getMessage());
			}
		}
			
			System.out.println( "\n--------------------------------\n"
					+ "Posti prenotati: " + event.getReservedSeats() + "\n"
					+ "Posti disponibili: " + event.getAvaiableSeats() + "\n-------------------------------\n"
					);

		//cancel
		System.out.println("Vuoi effettuare una disdetta?");
		userInput = in.nextLine();

		if (userInput.equals("no"))
			in.close();
		else {

			try {

				System.out.println("Quanti posti vuoi disdire?");
				userInput = in.nextLine();
				int cancelSeats = Integer.valueOf(userInput);

				for (int x = 0; x < cancelSeats; x++) {

					event.disdici();
				}

			} catch (Exception e) {
				System.out.println("ERRORE: " + e.getMessage());
			}
			
			System.out.println( "\n--------------------------------\n"
					+ "Posti prenotati: " + event.getReservedSeats() + "\n"
					+ "Posti disponibili: " + event.getAvaiableSeats() + "\n-------------------------------\n"
					);

			// close Scanner
			in.close();
		}
	}

}
