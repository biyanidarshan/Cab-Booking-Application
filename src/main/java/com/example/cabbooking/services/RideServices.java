package com.example.cabbooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.exceptions.NoVehicleAvailable;
import com.example.cabbooking.models.Driver;
import com.example.cabbooking.repository.DriverRepository;

@Service
public class RideServices {
	
	@Autowired
	private DriverRepository driverRepository;
	//private ArrayList<Driver> availableDriversList = new ArrayList<>();
	
	public RideServices(DriverRepository driverRepository) {
		super();
		this.driverRepository = driverRepository;
	}
	
	private double calculateUnits(int userXCoordinate, int userYCoordinate, int driverXCoordinate, int driverYCoordinate) {
		
		double xDistance = Math.pow(userXCoordinate - driverXCoordinate, 2);
		double yDistance = Math.pow(userYCoordinate - driverYCoordinate, 2);
		return  Math.sqrt(xDistance + yDistance);
		
	}
	
	public ArrayList<Driver> find_Ride (String userName, int sourceXCoordinate, int sourceYCoordinate, int destinationXCoordinate, int destinationYCoordinate) throws NoVehicleAvailable{
		 ArrayList<Driver> availableDriversList = new ArrayList<>();
		for (Driver driver : driverRepository.getDriversList()){	
			double driverDistance = calculateUnits(sourceXCoordinate, sourceYCoordinate, driver.getxCoordinate(), driver.getyCoordinate());
			if (driver.isAvailable() && driverDistance <= 5)
			{
				availableDriversList.add(driver);
			}
		}
		if(availableDriversList.size()==0) {
			throw new NoVehicleAvailable("No ride found");
		}
		else {
			printList(availableDriversList);
			return availableDriversList;
		}
		
	}
	
	private void printList(List<Driver> list)
	{	
		System.out.println("Following is the list of drivers availabel");
		for(Driver driver : list)
		{
			System.out.println(driver);
		}
	}
	
	public void choose_Ride (String username, String drivername)
	{	
		for (Driver driver : driverRepository.getDriversList())
			if(driver.getDriverName().equals(drivername)) {
				driver.setAvailable(false);
				System.out.println("Your ride is booked successfully");
				break;
			}
					
				
				
	}
}

