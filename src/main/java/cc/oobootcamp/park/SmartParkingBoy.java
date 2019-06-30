package cc.oobootcamp.park;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private List<CarPark> carParks;

    public SmartParkingBoy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    public String park(Car car) {
        CarPark carPark = null;
        try {
            carPark = getCarParkWithMostAvailableLots();
        } catch (NoAvailableCarParkException e) {
            return "All car parks are full";
        }
        return carPark.park(car);
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

    private CarPark getCarParkWithMostAvailableLots() throws NoAvailableCarParkException {
        return carParks.stream().max(Comparator.comparingInt(CarPark::getAvailableLots))
                .filter(carPark -> carPark.getAvailableLots() > 0)
                .orElseThrow(NoAvailableCarParkException::new);
    }
}
