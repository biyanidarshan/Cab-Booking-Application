package com.example.cabbooking.models;

public class Driver {
	
	private String driverName; 
    private char driverGender;
    private int driverAge;
    private String vehicleDetails;
    private int xCoordinate;
    private int yCoordinate;
    private boolean available;
    
	public Driver(String driverName, char driverGender, int driverAge, String vehicleDetails, int xCoordinate,
			int yCoordinate, boolean available) {
		super();
		this.driverName = driverName;
		this.driverGender = driverGender;
		this.driverAge = driverAge;
		this.vehicleDetails = vehicleDetails;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.available = available;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public char getDriverGender() {
		return driverGender;
	}
	public void setDriverGender(char driverGender) {
		this.driverGender = driverGender;
	}
	public int getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}
	public String getVehicleDetails() {
		return vehicleDetails;
	}
	
	
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
    
	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", driverGender=" + driverGender + ", driverAge=" + driverAge
				+ ", vehicleDetails=" + vehicleDetails + "]";}

}
