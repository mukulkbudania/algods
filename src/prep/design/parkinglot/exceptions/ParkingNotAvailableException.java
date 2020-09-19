package prep.design.parkinglot.exceptions;

public class ParkingNotAvailableException extends RuntimeException {
    public ParkingNotAvailableException(final String message) {
        super(message);
    }
}
