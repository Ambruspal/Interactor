package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.data;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import org.json.JSONObject;

public interface VehicleDataAccessInterface {
    String saveVehicle(JSONObject jsonObjectVehicle);

    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
