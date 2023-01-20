package hu.lechnerkozpont.ambruspal.vehicle.interactor;

public class Vehicle {
    String registrationNumber;
    String make;
    String model;
    int numberOfSeats;
    String vehicleType;

    public Vehicle(String registrationNumber, String make, String model, int numberOfSeats, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }


}