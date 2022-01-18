package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;

public class InvoiceGenerator {

	private static final double MIN_COST_PER_KM = 10;
	private static final int MIN_COST_PER_MINUTE = 1;
	private static final double MIN_CAB_FARE = 5;
	public static final double MINIMUM_COST_PER_KM_PREMIUM = 15;
	public static final double COST_PER_MINUTE_PREMIUM = 2;
	public static final double MINIMUM_FARE_PREMIUM = 20;
	

	public double totalFare(double distance, int time, String type) {
		
		if(type.equalsIgnoreCase("Normal")) {
			double totalFare = distance*MIN_COST_PER_KM + time*MIN_COST_PER_MINUTE;
			return Math.max(totalFare, MIN_CAB_FARE);
		}
		else if(type.equalsIgnoreCase("Premium")) {
			double totalFare = distance*MINIMUM_COST_PER_KM_PREMIUM + time*COST_PER_MINUTE_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		}
		else {
			System.out.println("Customer Type is Not Valid");
			return 0.0;
		}
	}
	
	public double calculateFare(Ride[] rides, String type) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.totalFare(ride.distance, ride.time, type);
		}
		return totalFare;
	}
	
	public InvoiceSummary calculateFareReturnObject(ArrayList<Ride> rides, String type) {
		
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare = totalFare + this.totalFare(ride.distance, ride.time, type);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
}
