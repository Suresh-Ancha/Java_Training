package session3Oops;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class RentalService implements RentalCostCalculator {

	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Rental> rentals = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();

	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void removeVehicle(Vehicle vehicle) {

		vehicles.remove(vehicle);
	}

	// Display available vehicles
	public List<Vehicle> getAvailableVehicles() {
		List<Vehicle> availableVehicles = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.isAvailable()) {
				availableVehicles.add(vehicle);
			}
		}
		return availableVehicles;
	}

	// Rent a vehicle
	public Rental rentVehicle(Customer customer, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
		if (vehicle.isAvailable()) {
			Rental rental = new Rental(vehicle, customer, startTime, endTime);
			if (!customers.contains(customer))
				customers.add(customer);
			rentals.add(rental);
			System.out.println("Generated rentalId :" + rental.getId());
			vehicle.setAvailable(false);
			return rental;
		} else {
			return null;
		}
	}

	@Override
	public BigDecimal calculateRentalCost(Rental rental) {
		Duration duration = Duration.between(rental.getStartTime(), rental.getEndTime());
		long days = duration.toDays();
		BigDecimal hourlyRate = BigDecimal.valueOf(rental.getRentedVehicle().getRentalPricePerday());
		return hourlyRate.multiply(BigDecimal.valueOf(days));
	}

	// Return a rented vehicle
	public boolean returnVehicle(Rental rental) {
		if (rentals.contains(rental)) {
			rentals.remove(rental);
			rental.getRentedVehicle().setAvailable(true);
			return true;
		} else {
			return false;
		}
	}
	
	public Customer addCustomer(Customer customer) {
		if (!customers.contains(customer)) {
			customers.add(customer);
			return customer;
		}
		return null;
	}
	
	public List<Customer> getAllCustomers() {
		return customers;
	}
	
	public Customer getCustomerByName(String name) {

		for (Customer customer : customers) {
			customer.getFirstName().equalsIgnoreCase(name);
			return customer;
		}
		return null;

	}
	
	public Vehicle getVehicleByLicensePlate(String licensePlate) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getLicensePlate().equals(licensePlate)) {
				return vehicle;
			}
		}
		return null;
	}
	
	public Rental getRentalById(String rentalId) {
		for (Rental rental : rentals) {
			if (rental.getId().equals(rentalId)) {
				return rental;
			}
		}
		return null;
	}
	
	public List<Rental> getAllRentals() {

		return rentals;

	}
}