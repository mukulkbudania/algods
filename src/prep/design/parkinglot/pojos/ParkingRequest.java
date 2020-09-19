package prep.design.parkinglot.pojos;

import java.time.ZonedDateTime;

import prep.design.parkinglot.ParkingLot;

public class ParkingRequest {
    private ParkingLot parkingLot;
    private String vehicleId;
    private ZonedDateTime entryTimeStamp;

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void setParkingLot(final ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(final String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setEntryTimeStamp(final ZonedDateTime time) {
        this.entryTimeStamp = time;
    }

    public ZonedDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }
}
