package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
	InvoiceGenerator generator = null;
	@Before
	public void setUp() {
		generator = new InvoiceGenerator();
	}
	@Test
	public void whenDistanceAndTimeGiven_ShouldReturnTotalFare() {
		String type ="Normal";
		double distance=1;
		int time = 6;
		double fare = generator.totalFare(distance,time,type);
		assertEquals(16,fare,0.0);
	}
	@Test
	public void whenDistanceAndTimeGiven_WhenTotalFareLessThan5_ShouldReturnMinFare() {
		String type ="Normal";
		double distance=0.1;
		int time = 2;
		double fare = generator.totalFare(distance,time,type);
		assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnInvoice() {
		String type ="Premium";
		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(1.0, 1)};
		double totalFare = generator.calculateFare(rides,type);
		assertEquals(60, totalFare, 0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {

		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(2.0, 5));
		rides.add(new Ride(0.1, 1));
		int size = rides.size();
		assertEquals(2,size);
	}
	@Test
	public void givenUserId_ShouldReturnInvoiceSummary() {
		String userId = "User1";
		InvoiceService invoiceService = new InvoiceService();
		ArrayList<Ride> invoiceList = new ArrayList<>();
		invoiceList.add(new Ride(2.0, 5));
		invoiceList.add(new Ride(0.1, 1));
		invoiceService.addRide(userId, invoiceList);
		ArrayList<Ride> listOfRides = invoiceService.getRides(userId);
		int size = listOfRides.size();
		assertEquals(2,size);
	}
}
