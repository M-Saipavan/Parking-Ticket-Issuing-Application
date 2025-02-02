package com.ParkingLot;
import java.util.*;

import com.Customer.*;

public class ParkingLot {
	String parkingLotId;
	List<List<Slot>> slots ;
	int totalNoSlots;
	
	public ParkingLot(String parkingLotId,int nfloors,int noOfSlotsPerFlr){
		this.parkingLotId= parkingLotId;
		this.slots=new ArrayList<>();
		this.totalNoSlots=0;
		for(int i=0;i<nfloors;i++) {
			List<Slot> fs = new ArrayList<>();
			for(int j=0;j<noOfSlotsPerFlr;j++) {
				Slot s = null;
				if(j==0) { 
					s = new Slot("Truck");
				}
				else if(j<=2) {
					s = new Slot("Bike");
				}
				else {
					s= new Slot("Car");
				}
				fs.add(s);
				totalNoSlots++;
			}
			slots.add(fs);
		}
	}
	
	private String generateTicketId(int flr,int slotNo) {
		return parkingLotId+"_"+flr+"_"+slotNo;
	}
	
	public String parkVehicle(String type,String regNo,String Color){
		Vehicle vehicle = new Vehicle(type,regNo,Color);
		for(int i=0;i<this.slots.size();i++) {
			for(int j=0;j<this.slots.get(i).size();j++) {
				Slot slot = slots.get(i).get(j);
				if(slot.type.equalsIgnoreCase(type) && slot.vehicle == null ) {
					slot.vehicle=vehicle;
					slot.ticketId=generateTicketId(i+1,j+1);
					System.out.println("Vehicle Parked - Your Ticket Id : "+slot.ticketId);
					return slot.ticketId;
				}
				
			}
		}
		System.out.println("No slot available for the given("+type+") vehicle type");
		return null;
	}
	
	public void unPark(String ticketId) {
		try {
		String[] str = ticketId.split("_");
		int floor = Integer.valueOf(str[1])-1;
		int slotNo = Integer.valueOf(str[2])-1;
		for(int i=0;i<this.slots.size();i++) {
			for(int j=0;j<this.slots.get(i).size();j++) {
				if(i==floor && j==slotNo) {
					Slot s = this.slots.get(i).get(j);
					s.vehicle=null;
					s.ticketId=null;
					System.out.println("Unparked vehicle at floor-"+(i+1)+", slot no "+(j+1));
				}
			}
		}
		}
		catch(Exception e){
			System.out.println("Invalid ticketId , try again ");
		}
	}
	
	public int getNoOfOpenSlots(String type) {
		int count = 0;
		for(int i=0;i<this.slots.size();i++) {
			for(int j=0;j<this.slots.get(i).size();j++) {
				if(slots.get(i).get(j).type.equalsIgnoreCase(type)&&slots.get(i).get(j).ticketId==null){
					count++;
				}
			}
		}
		return count;
	}
	
	public void displayOpenSlots(String type){
		System.out.println("Open slots for "+type+" are :");
		for(int i=0;i<this.slots.size();i++) {
			for(int j=0;j<this.slots.get(i).size();j++) {
				if(slots.get(i).get(j).type.equalsIgnoreCase(type)&&slots.get(i).get(j).ticketId==null){
					System.out.println("Floor - "+i+", "+"Slot : "+j);
				}
			}
		}
	}
	
	public void displayOccupiedSlots(String type) {
		System.out.println("Occupied slots for "+type+" are :");
		int count = 0;
		for(int i=0;i<this.slots.size();i++) {
			for(int j=0;j<this.slots.get(i).size();j++) {
				if(slots.get(i).get(j).type.equalsIgnoreCase(type)&&slots.get(i).get(j).vehicle!=null){
					count++;
					System.out.println("Floor - "+i+", "+"Slot : "+j);
				}
			}
		}
		if(count==0) System.out.print("0");
	}
}
