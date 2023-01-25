package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import org.json.JSONObject;

public interface VehicleRequestInterface {
    void findVehicleByRegistrationNumber(String jsonObject);

    void saveVehicle(JSONObject jsonObject);
}
