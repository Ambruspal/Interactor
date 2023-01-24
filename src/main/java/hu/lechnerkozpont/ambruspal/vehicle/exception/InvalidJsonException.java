package hu.lechnerkozpont.ambruspal.vehicle.exception;

public class InvalidJsonException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Parse failed!";
    }
}
