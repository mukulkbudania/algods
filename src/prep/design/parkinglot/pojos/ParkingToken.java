package prep.design.parkinglot.pojos;

import java.time.ZonedDateTime;
import java.util.Optional;

public class ParkingToken {
    private ZonedDateTime entryTimeStamp;
    private String vehicleId;
    private ParkingSpot parkingSpot;

    public void setEntryTimeStamp(final ZonedDateTime entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public ZonedDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setVehicleId(final String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setParkingSpot(final ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Optional<ParkingSpot> getParkingSpot() {
        //return parkingSpot;
        return null;
    }
}
