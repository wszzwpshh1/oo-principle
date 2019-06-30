package cc.oobootcamp.park;

import java.util.*;

public class CarPark {
    private int size;
    private Map<String, Car> parkMap;

    public CarPark(int size) {
        this.size = size;
        parkMap = new HashMap<>();
    }

    public String park(Car car) {
        if (parkMap.size() < size) {
            parkMap.put(car.getPlate(), car);
            return "Ticket of car " + car.getPlate();
        }
        return "The car park is full";
    }

    public String pick(String pickCarPlate) {
        if (parkMap.containsKey(pickCarPlate)) {
            return "Pick up car " + parkMap.remove(pickCarPlate).getPlate();
        }
        return "Could not find your car";
    }

    public boolean isAvailable() {
        return this.parkMap.size() < this.size;
    }

    int getAvailableLots() {
        return size - parkMap.size();
    }
}
