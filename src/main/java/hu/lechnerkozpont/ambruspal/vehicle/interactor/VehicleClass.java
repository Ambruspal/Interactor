package hu.lechnerkozpont.ambruspal.vehicle.interactor;

public class VehicleClass {
    String registrationNumber;
    String make;
    String model;
    int numberOfSeats;
    String vehicleType;

    VehicleClass(VehicleClass vehicleData) {
        this.registrationNumber = vehicleData.registrationNumber;
        this.make = vehicleData.make;
        this.model = vehicleData.model;
        this.numberOfSeats = vehicleData.numberOfSeats;
        this.vehicleType = vehicleData.vehicleType;
    }
}
