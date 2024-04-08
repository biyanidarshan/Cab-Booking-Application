package com.example.cabbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cabbooking.exceptions.NoVehicleAvailable;
import com.example.cabbooking.exceptions.VehicleAlreadyPresent;
import com.example.cabbooking.models.Driver;
import com.example.cabbooking.models.User;
import com.example.cabbooking.repository.DriverRepository;
import com.example.cabbooking.services.DriverServices;
import com.example.cabbooking.services.RideServices;

@SpringBootApplication
public class CabBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
		
		User abhishek = new User();
		abhishek.setUserName("Abhishek");
		abhishek.setUserGender('M');
		abhishek.setAge(23);
		
		User rahul = new User();
		rahul.setUserName("Rahul");
		rahul.setUserGender('M');
		rahul.setAge(29);
		
		User nandini = new User();
		nandini.setUserName("Abhishek");
		nandini.setUserGender('F');
		nandini.setAge(22);
	
	
		Driver driver1 = new Driver("Driver1", 'M', 22, "Swift, KA-01-12345", 10, 1, true);
		Driver driver2 = new Driver("Driver2", 'M', 29, "Swift, KA-01-12346", 11, 10, true);
		Driver driver3 = new Driver("Driver3", 'M', 24, "Swift, KA-01-12347", 5, 3, true);
		
		DriverRepository driverrepository = new DriverRepository();
		
		DriverServices driverservices = new DriverServices(driverrepository);
		try 
		{
			driverservices.add_Driver(driver1);
			driverservices.add_Driver(driver2);
			driverservices.add_Driver(driver3);
			
		}
		catch (VehicleAlreadyPresent e)
		{
			System.out.println(e);
		}
		
		RideServices rideservice = new RideServices(driverrepository);
		
		try {
			rideservice.find_Ride("Abhishek", 0, 0, 20, 1);
		} catch (NoVehicleAvailable e) {
			System.out.println(e);
		}
		try {
			rideservice.find_Ride("Rahul", 10, 0, 15, 3);
		} catch (NoVehicleAvailable e) {
			System.out.println(e);
		}
		
		rideservice.choose_Ride("Rahul", "Driver1");
		
		try {
			rideservice.find_Ride("Nandini", 15, 6, 20, 4);
		} catch (NoVehicleAvailable e) {
			System.out.println(e);
		}
		
		
	}
}
