package com.ParkingLot;

import java.util.Scanner;

//import com.Customer.*;

public class Control {
	
	
	public static void main(String[] args) {
		//System.out.println("------------Main MENU-----------");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Create new Parking Lot\n2.Exit\n");
		int input = sc.nextInt();
		if(input==1) {
			System.out.println("Enter your Parking Lot Id: ");
			String parkingLotId = sc.next();
			System.out.println("Enter no of floors is present");
			int nfloors = sc.nextInt();
			System.out.println("Enter no of slots are present at each floor");
			int slotNos = sc.nextInt();
			ParkingLot p1 = new ParkingLot(parkingLotId,nfloors,slotNos);
			boolean loop = true; 
			while(loop) {
			System.out.println("\n-------------MENU------------\n1.Park"
					+ "\n2.Unpark"
					+ "\n3.Parking Lot details"
					+ "\n4.Get no of available slots for a vehicle type"
					+ "\n5.Display available slot details for a vehicle type"
					+ "\n6.Display Occupied slots details"
					+ "\n7.Return to Main Menu\n");
			int i = sc.nextInt();
			switch(i) {
			case 1:{
				System.out.println("Enter the vehicle Details");
				System.out.println("Enter vehicle type: ");
				String t = sc.next();
				System.out.println("Enter vehicle Registration Number: ");
				String r = sc.next();
				System.out.println("Enter vehicle Color: ");
				String c = sc.next();
				p1.parkVehicle(t,r,c);
				break;
			}
			case 2:{
				System.out.println("Enter the ticket ID: ");
				String ticketId = sc.next();
				p1.unPark(ticketId);
				break;
			}
			case 3:{
				System.out.println("\nYour Parking lot ID is : "+p1.parkingLotId+"\nTotal No. Of slots : "+p1.totalNoSlots);
				break;
			}
			case 4:{
				System.out.println("Enter Vehicle type: ");
				String type = sc.next();
				System.out.println("No. of available slots for "+type+" : "+p1.getNoOfOpenSlots(type));
				break;
			}
			case 5:{
				System.out.println("Enter Vehicle type: ");
				String type = sc.next();
				p1.displayOpenSlots(type);
				break;
			}
			case 6:{
				System.out.println("Enter Vehicle type: ");
				String type = sc.next();
				p1.displayOccupiedSlots(type);
				break;
			}
			case 7:{
				loop=false;
				System.out.println("Exited Application");
				break;
			}
			}
			}
		}
		else if(input==2) {
			System.out.println("Thanks for Using our parking application ");
			System.exit(0);
		}
		else {
			System.out.println("Invalid Input");
		}
		sc.close();
	}
}
