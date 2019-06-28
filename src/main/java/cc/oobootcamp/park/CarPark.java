package cc.oobootcamp.park;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private int size;
    private List<Car> parkList;

    public CarPark(int size) {
        this.size = size;
        parkList = new ArrayList();
    }

    public String park(Car car) {
        if (parkList.size() < size) {
            parkList.add(car);
            return "Ticket of car " + car.getPlate();
        }
        return "The car park is full";
    }

    public String pick(String pickCarPlate) {
        return parkList.stream()
                .filter(car -> car.getPlate() == pickCarPlate)
                .findFirst()
                .map(car -> "Pick up car " + car.getPlate())
                .orElse("Could not find your car");
    }
}
