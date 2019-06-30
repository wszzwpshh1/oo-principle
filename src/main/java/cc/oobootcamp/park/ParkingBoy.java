package cc.oobootcamp.park;

import java.util.List;

public class ParkingBoy {
    private List<CarPark> carParks;

    public ParkingBoy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    public String park(Car car) {
        for (CarPark carPark : carParks) {
            if (carPark.isAvailable()) {
                return carPark.park(car);
            }
        }
        return "All car parks are full";
    }

    public String pick(String parkingTicket) {
        for (CarPark carPark : carParks) {
            String pickResult = carPark.pick(parkingTicket);
            if (!pickResult.equals("Could not find your car")) {
                return pickResult;
            }
        }
        return "Could not find your car in all parks";
    }
}
