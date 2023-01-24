package hu.lechnerkozpont.ambruspal.vehicle.interactor;


import hu.lechnerkozpont.ambruspal.vehicle.exception.InvalidJsonException;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleResponseInterface;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleRequestInterface;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.data.VehicleDataAccessInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleInteractor implements VehicleRequestInterface {
    VehicleDataAccessInterface vehicleDataAccessGateway;
    VehicleResponseInterface vehicleDisplay;
    Vehicle vehicle;

    public void setVehicleDisplay(VehicleResponseInterface vehiclePresenter) {
        this.vehicleDisplay = vehiclePresenter;
    }

    public void setVehicleDataAccessGateway(VehicleDataAccessInterface vehicleDataAccessGateway) {
        this.vehicleDataAccessGateway = vehicleDataAccessGateway;
    }

    @Override
    public void findVehicleByRegistrationNumber(String id) {
        vehicle = vehicleDataAccessGateway.getVehicleByRegistrationNumber(id);
    }

    @Override
    public void saveVehicle(String json) {
        if (json != null) {
            JSONObject jsonObjectVehicle = this.getJsonObjectVehicleFromJsonString(json);
            String responseFromDataAccessGateway = vehicleDataAccessGateway.saveVehicle(jsonObjectVehicle);

            if (responseFromDataAccessGateway == "Successfully Saved") vehicleDisplay.displaySuccessfullSave(responseFromDataAccessGateway);
            if (responseFromDataAccessGateway == "Save failed!") vehicleDisplay.displayError(responseFromDataAccessGateway);
        } else {
            System.out.println("Error: Json string is null!");
        }
    }

    private JSONObject getJsonObjectVehicleFromJsonString(String jsonVehicle) {
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(jsonVehicle);
        } catch (JSONException exc) {
            throw new InvalidJsonException();
        }

        return jsonObject;
    }
}
