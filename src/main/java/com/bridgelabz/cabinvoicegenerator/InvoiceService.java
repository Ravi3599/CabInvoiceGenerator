package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
	
	Map<String, ArrayList<Ride>> rideMap;
	
	public InvoiceService() {
		this.rideMap= new HashMap<>();
	}
	
	public void addRide(String customerId, ArrayList<Ride> rides) {
		if(customerId != null)
			rideMap.put(customerId, rides);
	}
	public ArrayList<Ride> getRides(String customerId){
		if(rideMap.containsKey(customerId))
			return rideMap.get(customerId);
		return null;
	}
}
