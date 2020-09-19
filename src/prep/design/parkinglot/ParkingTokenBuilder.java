package prep.design.parkinglot;

import prep.design.parkinglot.pojos.ParkingRequest;
import prep.design.parkinglot.pojos.ParkingSpot;
import prep.design.parkinglot.pojos.ParkingToken;

public class ParkingTokenBuilder {

    public ParkingToken buildParkingToken(final ParkingRequest parkingRequest,
                                          final ParkingSpot parkingSpot) {
        final ParkingToken parkingToken = new ParkingToken();
        parkingToken.setEntryTimeStamp(parkingRequest.getEntryTimeStamp());
        parkingToken.setVehicleId(parkingRequest.getVehicleId());
        parkingToken.setParkingSpot(parkingSpot);
        return parkingToken;
    }
}
