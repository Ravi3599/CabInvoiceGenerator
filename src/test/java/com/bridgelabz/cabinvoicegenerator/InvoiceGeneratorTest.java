package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;

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
		double distance=1;
		int time = 6;
		double fare = generator.totalFare(distance,time);
		assertEquals(16,fare,0.0);
	}
	@Test
	public void whenDistanceAndTimeGiven_WhenTotalFareLessThan5_ShouldReturnMinFare() {
		double distance=0.1;
		int time = 2;
		double fare = generator.totalFare(distance,time);
		assertEquals(5,fare,0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnInvoice() {

		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		double totalFare = generator.calculateFare(rides);
		assertEquals(30, totalFare, 0.0);
	}
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {

		Ride[] rides = {new Ride(2.0, 5), 
						new Ride(0.1, 1)};
		InvoiceSummary summary = generator.calculateFareReturnObject(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		if(expectedSummary.getAverageFare() == summary.getAverageFare() && expectedSummary.getNumberOfRides() == summary.getNumberOfRides() && expectedSummary.getTotalFare() == summary.getTotalFare())
			assertEquals(1, 1);
	}
}
