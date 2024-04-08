package com.example.cabbooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cabbooking.exceptions.VehicleAlreadyPresent;
import com.example.cabbooking.models.Driver;
import com.example.cabbooking.repository.DriverRepository;

@Service
public class DriverServices {
	
	@Autowired
	private DriverRepository driverRepository;
	
	
	public DriverServices(DriverRepository driverRepository) {
		super();
		this.driverRepository = driverRepository;
	}
	
	public boolean add_Driver (Driver driver) throws VehicleAlreadyPresent {
		if (driverRepository.checkVehicleDetails(driver.getVehicleDetails()))
			throw new VehicleAlreadyPresent("Vehicle already registered in the databse");
		else
			return driverRepository.add_Driver_Repository(driver);
	}
	

}
