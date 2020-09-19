package prep.design.parkinglot;

import java.util.Optional;

import prep.design.parkinglot.pojos.ParkingRequest;
import prep.design.parkinglot.pojos.ParkingSpot;
import prep.design.parkinglot.pojos.ParkingToken;

public class ParkingLot {
    private static final String NOT_AVAILABLE_STRING = "Parking is already full";
    private ParkingTokenBuilder parkingTokenBuilder;

    public String getParkingToken(final ParkingRequest parkingRequest) {
        //Checks for availability.
        final Optional<ParkingSpot> parkingSpot = getEmptySpot();

        if (!parkingSpot.isPresent())
            return NOT_AVAILABLE_STRING;

        final ParkingToken parkingToken = parkingTokenBuilder.buildParkingToken(parkingRequest, parkingSpot.get());
        return parkingToken.toString();

    }

    public Optional<ParkingSpot> getEmptySpot() {
        return null;
    }
}
