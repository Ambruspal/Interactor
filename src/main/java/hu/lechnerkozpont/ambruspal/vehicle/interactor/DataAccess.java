package hu.lechnerkozpont.ambruspal.vehicle.interactor;

public interface DataAccess {
    void saveVehicle(Vehicle newVehicle);

    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
