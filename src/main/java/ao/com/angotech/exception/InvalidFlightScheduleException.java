package ao.com.angotech.exception;

public class InvalidFlightScheduleException extends RuntimeException {

    public InvalidFlightScheduleException(String msg) {
        super(msg);
    }
}
