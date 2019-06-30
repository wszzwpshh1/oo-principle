package cc.oobootcamp.park;

import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTests {

    private static final int TEST_CAR_PARK_SIZE = 5;
    private static final int TEST_CAR_PARK_BIGGER_SIZE = 6;

    @Test
    public void should_park_in_park_with_most_lots_and_get_ticket_when_parking_given_some_parking_lots_available() {
        CarPark firstCarPark = new CarPark(TEST_CAR_PARK_SIZE);
        CarPark secondCarPark = new CarPark(TEST_CAR_PARK_BIGGER_SIZE);

        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(firstCarPark, secondCarPark));

        String parkingNumber = "parkingNumber";
        Car car = new Car(parkingNumber);

        assertThat(secondCarPark.getAvailableLots()).isEqualTo(TEST_CAR_PARK_BIGGER_SIZE);
        String parkingResult = parkingBoy.park(car);

        assertThat(parkingResult).isEqualTo("Ticket of car " + parkingNumber);
        assertThat(secondCarPark.getAvailableLots()).isEqualTo(TEST_CAR_PARK_BIGGER_SIZE - 1);
    }

    @Test
    public void should_park_the_first_car_park_with_most_available_lots_when_park_a_car_given_there_are_some_car_parks_with_same_size() {
        CarPark firstCarPark = new CarPark(TEST_CAR_PARK_SIZE);
        CarPark secondCarPark = new CarPark(TEST_CAR_PARK_BIGGER_SIZE);

        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(firstCarPark, secondCarPark));

        String parkingNumber = "parkingNumber";
        Car car = new Car(parkingNumber);
        parkingBoy.park(car);

        assertThat(firstCarPark.getAvailableLots()).isEqualTo(5);
        parkingBoy.park(new Car("second car number"));

        assertThat(firstCarPark.getAvailableLots()).isEqualTo(4);
    }

    @Test
    public void should_get_car_filled_message_when_parking_given_all_car_parking_is_filled() {
        SmartParkingBoy parkingBoy = buildAllFilledCarParks();
        Car car = new Car("car number 123");

        String parkingResult = parkingBoy.park(car);

        assertEquals(parkingResult, "All car parks are full");
    }


    @Test
    public void should_get_car_matches_to_ticket_when_picking_up_given_holding_a_valid_parking_ticket() {
        SmartParkingBoy parkingBoy = buildSmartParkingBoyWithTwoEmptyCarParks();
        String parkingCarNumber = "car number";
        Car car = new Car(parkingCarNumber);
        String parkingTicket = parkingBoy.park(car);

        String pickResult = parkingBoy.pick(parkingCarNumber);

        assertEquals(pickResult, "Pick up car " + parkingCarNumber);
    }

    @Test
    public void should_get_a_cannot_pick_message_when_pick_up_a_car_given_a_ticket_does_not_match_to_any_car_in_all_car_parks() {
        SmartParkingBoy parkingBoy = buildAllFilledCarParks();
        String carNumber = "not exist car number";

        String pickResult = parkingBoy.pick(carNumber);

        assertEquals("Could not find your car in all parks", pickResult);
    }

    @Test
    public void should_park_the_car_when_pick_a_car_first_and_park_another_given_all_parks_are_filled() {
        String parkingNumber = "another car number";
        SmartParkingBoy parkingBoy = buildAllFilledCarParks();
        parkingBoy.pick("car number 0");

        String parkingResult = parkingBoy.park(new Car(parkingNumber));

        assertEquals(parkingResult, "Ticket of car " + parkingNumber);
    }

    private SmartParkingBoy buildSmartParkingBoyWithTwoEmptyCarParks() {
        CarPark firstCarPark = new CarPark(TEST_CAR_PARK_SIZE);
        CarPark secondCarPark = new CarPark(TEST_CAR_PARK_SIZE);

        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(firstCarPark, secondCarPark));
        return parkingBoy;
    }

    private SmartParkingBoy buildAllFilledCarParks() {
        SmartParkingBoy parkingBoy = buildSmartParkingBoyWithTwoEmptyCarParks();
        IntStream.range(0, TEST_CAR_PARK_SIZE * 2).forEach(i -> parkingBoy.park(new Car("car number " + i)));
        return parkingBoy;
    }

}
