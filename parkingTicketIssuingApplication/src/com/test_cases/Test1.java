package com.test_cases;


import com.ParkingLot.*;
//import com.Customer.*;


public class Test1 {
	public static void main(String[] args) {
		
		ParkingLot p1 = new ParkingLot("PR123",4,6);
		System.out.println("No of open slots for car : "+p1.getNoOfOpenSlots("car"));
		
		String t1 = p1.parkVehicle("car", "AP03CE8590" , "Blue");
		String t2 = p1.parkVehicle("car","AP03BP8576","Black");
		p1.displayOccupiedSlots("car");
		System.out.println(t1);
		p1.unPark(t2);
		p1.displayOccupiedSlots("car");
	}
}
