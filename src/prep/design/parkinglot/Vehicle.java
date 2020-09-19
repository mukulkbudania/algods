package prep.design.parkinglot;

import java.time.ZonedDateTime;

import prep.design.parkinglot.pojos.ParkingRequest;

public class Vehicle {

    private String registrationNumber;

    public String requestToken(final ParkingLot parkingLot) {
        final ParkingRequest parkingRequest = new ParkingRequest();
        parkingRequest.setVehicleId(this.registrationNumber);
        parkingRequest.setEntryTimeStamp(ZonedDateTime.now());
        parkingRequest.setParkingLot(parkingLot);
        final String parkingToken = parkingLot.getParkingToken(parkingRequest);
        return parkingToken;
    }

    public boolean enter(final ParkingLot parkingLot){
        return false;
    }
}
