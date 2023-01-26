package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.data;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;

public interface VehicleDataAccessInterface {
    void saveVehicle(Vehicle newVehicle);

    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
