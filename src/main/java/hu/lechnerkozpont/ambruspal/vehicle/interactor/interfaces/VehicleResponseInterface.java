package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;

public interface VehicleResponseInterface {
    void viewVehicleByRegistrationNumber(String json);

    void displaySuccessfullSave(String response);

    void displayError(String response);
}
