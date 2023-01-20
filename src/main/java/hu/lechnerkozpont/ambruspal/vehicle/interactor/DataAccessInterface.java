package hu.lechnerkozpont.ambruspal.vehicle.interactor;

public interface DataAccessInterface {
    void saveVehicle(VehicleClass newVehicleClass);

    VehicleClass getVehicleByRegistrationNumber(String registrationNumber);
}
