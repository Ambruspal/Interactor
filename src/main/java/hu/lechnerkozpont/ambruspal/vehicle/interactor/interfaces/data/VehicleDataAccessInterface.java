package hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.data;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import org.json.JSONObject;

public interface VehicleDataAccessInterface {
    JSONObject saveVehicle(Vehicle newVehicle);

    String getVehicleByRegistrationNumber(Vehicle findVehicle);
}
