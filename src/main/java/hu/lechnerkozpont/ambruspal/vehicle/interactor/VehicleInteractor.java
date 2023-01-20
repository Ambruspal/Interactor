package hu.lechnerkozpont.ambruspal.vehicle.interactor;


public class VehicleInteractor implements VehicleRequestInterface {
    DataAccessInterface dataAccessInterface;
    VehicleDisplayInterface vehicleDisplayInterface;

    public VehicleDisplayInterface getVehicleDisplayInterface() {
        return vehicleDisplayInterface;
    }

    public void setVehicleDisplayInterface(VehicleDisplayInterface vehicleDisplayInterface) {
        this.vehicleDisplayInterface = vehicleDisplayInterface;
    }

    public DataAccessInterface getDataAccessInterface() {
        return dataAccessInterface;
    }

    public void setDataAccessInterface(DataAccessInterface dataAccessInterface) {
        this.dataAccessInterface = dataAccessInterface;
    }


    @Override
    public void findVehicleByRegistrationNumber(String id) {
        Vehicle vehicle = dataAccessInterface.getVehicleByRegistrationNumber(id);
        vehicleDisplayInterface.view(vehicle);
    }
}