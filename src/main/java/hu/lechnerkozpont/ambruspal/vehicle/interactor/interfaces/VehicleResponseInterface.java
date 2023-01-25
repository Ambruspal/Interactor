package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import org.json.JSONObject;

public interface VehicleResponseInterface {
    void viewVehicleByRegistrationNumber(String json);

    void displaySave(JSONObject jsonObject);
}
