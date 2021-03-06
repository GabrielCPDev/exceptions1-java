package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-In date (dd/MM/yyyy): ");
			Date checkIn =  sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			Date checkOut =  sdf.parse(sc.next());
			
			
			reservation reservation = new reservation(number, checkIn, checkOut);
			System.out.println("reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.println("Check-In date (dd/MM/yyyy): ");
			checkIn =  sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut =  sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("reservation: "+ reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Erro in reservation"+ e.getLocalizedMessage());
		}

		sc.close();
	}

}
