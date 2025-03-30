package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		try {
			System.out.println("Room number: ");
			int number = sc.nextInt();
	
			System.out.println("check-in: ");
			Date checkIn = sdf.parse(sc.next());
	
			System.out.println("check-out: ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("reservation: " + reservation);
	
			System.out.println();
			System.out.println("atualize sua reserva");
			System.out.println("check-in: ");
			checkIn = sdf.parse(sc.next());
	
			System.out.println("check-out: ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
	
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e){
			System.out.println("tipo de data invalido");
		}
		catch(DomainException e) {
			System.out.println("ERRO NA RESERVA: " + e.getMessage());
		}
		
		sc.close();
	}

}
