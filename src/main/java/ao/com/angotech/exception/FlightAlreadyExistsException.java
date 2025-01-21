package ao.com.angotech.exception;

public class FlightAlreadyExistsException extends RuntimeException {

    public FlightAlreadyExistsException(String msg) {
        super(msg);
    }
}
