package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-In date (dd/MM/yyyy): ");
		Date checkIn =  sdf.parse(sc.next());
		System.out.println("Check-Out date (dd/MM/yyyy): ");
		Date checkOut =  sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out must be after check-in date.");
		}
		else {
			reservation reservation = new reservation(number, checkIn, checkOut);
			System.out.println("reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.println("Check-In date (dd/MM/yyyy): ");
			checkIn =  sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut =  sdf.parse(sc.next());
			
				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
					System.out.println("Error in reservation: " + error);
				}		
				else {
					System.out.println("reservation: "+ reservation);
				}
		}

		sc.close();
	}

}
