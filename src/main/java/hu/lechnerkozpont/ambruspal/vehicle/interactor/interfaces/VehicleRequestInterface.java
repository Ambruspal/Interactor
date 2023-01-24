package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;

public interface VehicleRequestInterface {
    void findVehicleByRegistrationNumber(String json);

    void saveVehicle(String json);
}
