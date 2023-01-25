package hu.lechnerkozpont.ambruspal.vehicle.interactor;


import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleResponseInterface;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleRequestInterface;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.data.VehicleDataAccessInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleInteractor implements VehicleRequestInterface {
    VehicleDataAccessInterface vehicleDataAccessGateway;
    VehicleResponseInterface vehicleDisplay;

    public void setVehicleDisplay(VehicleResponseInterface vehiclePresenter) {
        this.vehicleDisplay = vehiclePresenter;
    }

    public void setVehicleDataAccessGateway(VehicleDataAccessInterface vehicleDataAccessGateway) {
        this.vehicleDataAccessGateway = vehicleDataAccessGateway;
    }

    @Override
    public void findVehicleByRegistrationNumber(String inputData) {
        String id = null;
        try {
            JSONObject jsonObject = new JSONObject(inputData);
            id = jsonObject.getString("registrationNumber");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Vehicle response = vehicleDataAccessGateway.getVehicleByRegistrationNumber(id);
        JSONObject jsonObjectVehicle = new JSONObject();

        try {
            jsonObjectVehicle.put("registrationNumber", response.getRegistrationNumber());
            jsonObjectVehicle.put("make", response.getMake());
            jsonObjectVehicle.put("model", response.getModel());
            jsonObjectVehicle.put("numberOfSeats", response.getNumberOfSeats());
            jsonObjectVehicle.put("vehicleType", response.getVehicleType());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        vehicleDisplay.viewVehicleByRegistrationNumber(jsonObjectVehicle.toString());
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
