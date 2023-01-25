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
    public void findVehicleByRegistrationNumber(JSONObject jsonObject) {
        String id = null;
        try {
            id = jsonObject.getString("registrationNumber");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Vehicle findVehicle = new Vehicle();
        findVehicle.setRegistrationNumber(id);
        String response = vehicleDataAccessGateway.getVehicleByRegistrationNumber(findVehicle);
    }

    @Override
    public void saveVehicle(JSONObject jsonObject) {
        System.out.println("Interactor saveVehicle: " + jsonObject.toString());

        Vehicle newVehicle = new Vehicle();

        try {
            newVehicle.setRegistrationNumber(jsonObject.getString("registrationNumber"));
            newVehicle.setMake(jsonObject.getString("make"));
            newVehicle.setModel(jsonObject.getString("model"));
            newVehicle.setNumberOfSeats(jsonObject.getString("numberOfSeats"));
            newVehicle.setVehicleType(jsonObject.getString("vehicleType"));
        } catch (Exception e) {
            e.printStackTrace();
        }

            JSONObject responseFromDataAccessGateway = vehicleDataAccessGateway.saveVehicle(newVehicle);

        vehicleDisplay.displaySave(responseFromDataAccessGateway);

    }
}
