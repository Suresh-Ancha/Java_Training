package session3Oops;

public abstract class Vehicle implements VehicleOperations {
	
	private String licensePlate;
    private String make;
    private String model;
    private boolean isAvailable;
    private int rentalPricePerday;
  
	public Vehicle(String licensePlate, String make, String model, int rentalPricePerday) {
		this.licensePlate = licensePlate;
		this.make = make;
		this.model = model;
		this.rentalPricePerday = rentalPricePerday;
		this.isAvailable = true;
	}
	
	public Vehicle(String make, String model) {
		this.licensePlate = "NULL";
		this.make = make;
		this.model = model;
		this.isAvailable = true;
	}
	
    public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getRentalPricePerday() {
		return rentalPricePerday;
	}
	public void setRentalPricePerday(int rentalPricePerday) {
		this.rentalPricePerday = rentalPricePerday;
	}

}
