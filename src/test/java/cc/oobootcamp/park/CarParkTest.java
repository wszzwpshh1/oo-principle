package cc.oobootcamp.park;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarParkTest {
    private CarPark carPark;

    private String prefillFirstCarPlate = "c1_plate";
    private String prefillSecondCarPlate = "c2_plate";
    private String prefillThirdCarPlate = "c3_plate";
    private String prefillForthCarPlate = "c4_plate";

    @Before
    public void setUp() {
        carPark = new CarPark(4);
    }

    @Test
    public void should_get_ticket_with_parking_number_when_parking_car_given_car_park_has_parking_lots_available() {
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

        fillCarPark();
        String fullMessage = carPark.park(extraCar);
        assertThat(fullMessage).isEqualTo("The car park is full");
    }

    @Test
    public void should_get_correct_car_when_pick_up_car_given_holding_a_valid_parking_ticket() {
        fillCarPark();

        String pickMessage = carPark.pick(prefillFirstCarPlate);
        assertThat(pickMessage).isEqualTo("Pick up car " + prefillFirstCarPlate);
    }

    @Test
    public void should_get_could_not_get_car_message_when_pick_up_car_given_holding_an_invalid_ticket() {
        fillCarPark();

        String pickMessage = carPark.pick("plate does not exist");
        assertThat(pickMessage).isEqualTo("Could not find your car");
    }

    private void fillCarPark() {
        carPark.park(new Car(prefillFirstCarPlate));
        carPark.park(new Car(prefillSecondCarPlate));
        carPark.park(new Car(prefillThirdCarPlate));
        carPark.park(new Car(prefillForthCarPlate));
    }
}
