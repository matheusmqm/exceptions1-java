package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		
		System.out.println("check-in: ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.println("check-out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("ERRO: a data de checkout tem que ser depois da de checkin");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
		
			System.out.println();
			System.out.println("atualize sua reserva");
			System.out.println("check-in: ");
			checkIn = sdf.parse(sc.next());
			
			System.out.println("check-out: ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println(error);
				
			}
			else {
				System.out.println("Reservation: " + reservation);
			}

		}
		
		sc.close();
	}

}
