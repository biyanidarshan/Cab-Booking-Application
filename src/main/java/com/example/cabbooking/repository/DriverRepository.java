package com.example.cabbooking.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.cabbooking.models.Driver;

@Component
public class DriverRepository {
	
	private static ArrayList<Driver> driversList = new ArrayList<>();

	public ArrayList<Driver> getDriversList() {
		return driversList;
	}

	public void setDriversList(ArrayList<Driver> driversList) {
		DriverRepository.driversList = driversList;
	}

	public boolean checkVehicleDetails (String vehicleDetails)
    {
        for(Driver driver : driversList)
        {
            if(driver.getVehicleDetails().equals(vehicleDetails))
                return true;
        }
        return false;
    }
	
	public boolean add_Driver_Repository(Driver newDriver)
    {
        return driversList.add(newDriver);
    }
}
