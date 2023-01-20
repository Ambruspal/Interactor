package hu.lechnerkozpont.ambruspal.vehicle.interactor;

public interface DataAccessInterface {
    void saveVehicle(Vehicle newVehicle);

    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
