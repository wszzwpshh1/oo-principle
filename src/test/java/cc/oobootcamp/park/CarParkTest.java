package cc.oobootcamp.park;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarParkTest {
    private static final int CAR_PARK_SIZE = 5;

    @Before
    public void setUp() {}

    @Test
    public void should_get_ticket_with_parking_number_when_parking_car_given_car_park_has_parking_lots_available() {
        CarPark carPark = new CarPark(CAR_PARK_SIZE);
        String firstCarPlate = "c1_plate";
        String secondCarPlate = "c2_plate";
        Car firstCar = new Car(firstCarPlate);
        Car secondCar = new Car(secondCarPlate);

        String firstCarParkOutput = carPark.park(firstCar);
        String secondCarParkOutput = carPark.park(secondCar);

        assertThat(firstCarParkOutput).isEqualTo("Ticket of car " + firstCarPlate);
        assertThat(secondCarParkOutput).isEqualTo("Ticket of car " + secondCarPlate);
    }

    @Test
    public void should_get_car_park_full_message_when_parking_car_given_car_park_has__no_parking_lot_available() {
        String extraCarPlate = "one_more";
        Car extraCar = new Car(extraCarPlate);

        CarPark carPark = buildFilledCarPark(CAR_PARK_SIZE);
        String fullMessage = carPark.park(extraCar);
        assertThat(fullMessage).isEqualTo("The car park is full");
    }

    @Test
    public void should_get_correct_car_when_pick_up_car_given_holding_a_valid_parking_ticket() {
        String testCarPlate = "testCar1";
        CarPark carPark = buildFilledCarPark(CAR_PARK_SIZE);

        String pickMessage = carPark.pick(testCarPlate);
        assertThat(pickMessage).isEqualTo("Pick up car " + testCarPlate);
    }

    @Test
    public void should_get_could_not_get_car_message_when_pick_up_car_given_holding_an_invalid_ticket() {
        CarPark carPark = buildFilledCarPark(CAR_PARK_SIZE);

        String pickMessage = carPark.pick("plate does not exist");
        assertThat(pickMessage).isEqualTo("Could not find your car");
    }

    @Test
    public void should_get_could_not_get_car_message_when_pick_up_car_twice_given_holding_a_valid_ticket() {
        String testCarPlate = "testCar1";
        CarPark carPark = buildFilledCarPark(CAR_PARK_SIZE);

        carPark.pick(testCarPlate);
        String pickAgainMessage = carPark.pick(testCarPlate);

        assertThat(pickAgainMessage).isEqualTo("Could not find your car");
    }

    private CarPark buildFilledCarPark(int size) {
        CarPark carPark = new CarPark(size);
        IntStream.range(0, CAR_PARK_SIZE).forEach(i -> carPark.park(new Car("testCar" + i)));
        return carPark;
    }
}
