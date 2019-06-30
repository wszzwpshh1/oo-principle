package cc.oobootcamp.park;

import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTests {

    private static final int TEST_CAR_PARK_SIZE = 5;

    @Test
    public void should_park_in_first_available_park_and_get_ticket_when_parking_given_some_parking_lots_available() {
        ParkingBoy parkingBoy = buildParkingBoyWithTwoEmptyCarParks();

        String parkingNumber = "parkingNumber";
        Car car = new Car(parkingNumber);

        String parkingResult = parkingBoy.park(car);

        assertThat(parkingResult).isEqualTo("Ticket of car " + parkingNumber);
    }

    @Test
    public void should_get_car_filled_message_when_parking_given_all_car_parking_is_filled() {
        ParkingBoy parkingBoy = buildAllFilledCarParks();
        Car car = new Car("car number 123");

        String parkingResult = parkingBoy.park(car);

        assertEquals(parkingResult, "All car parks are full");
    }


    @Test
    public void should_get_car_matches_to_ticket_when_picking_up_given_holding_a_valid_parking_ticket() {
        ParkingBoy parkingBoy = buildParkingBoyWithTwoEmptyCarParks();
        String parkingCarNumber = "car number";
        Car car = new Car(parkingCarNumber);
        String parkingTicket = parkingBoy.park(car);

        String pickResult = parkingBoy.pick(parkingCarNumber);

        assertEquals(pickResult, "Pick up car " + parkingCarNumber);
    }

    @Test
    public void should_get_a_cannot_pick_message_when_pick_up_a_car_given_a_ticket_does_not_match_to_any_car_in_all_car_parks() {
        ParkingBoy parkingBoy = buildAllFilledCarParks();
        String carNumber = "not exist car number";

        String pickResult = parkingBoy.pick(carNumber);

        assertEquals("Could not find your car in all parks", pickResult);
    }

    @Test
    public void should_park_the_car_when_pick_a_car_first_and_park_another_given_all_parks_are_filled() {
        String parkingNumber = "another car number";
        ParkingBoy parkingBoy = buildAllFilledCarParks();
        parkingBoy.pick("car number 0");

        String parkingResult = parkingBoy.park(new Car(parkingNumber));

        assertEquals(parkingResult, "Ticket of car " + parkingNumber);
    }

    private ParkingBoy buildParkingBoyWithTwoEmptyCarParks() {
        CarPark firstCarPark = new CarPark(TEST_CAR_PARK_SIZE);
        CarPark secondCarPark = new CarPark(TEST_CAR_PARK_SIZE);

        ParkingBoy parkingBoy = new ParkingBoy(asList(firstCarPark, secondCarPark));
        return parkingBoy;
    }

    private ParkingBoy buildAllFilledCarParks() {
        ParkingBoy parkingBoy = buildParkingBoyWithTwoEmptyCarParks();
        IntStream.range(0, TEST_CAR_PARK_SIZE * 2).forEach(i -> parkingBoy.park(new Car("car number " + i)));
        return parkingBoy;
    }

}
