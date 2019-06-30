## Part 1

**GIVEN** the car park has parking lots available  
**WHEN** parking a car  
**THEN** get a ticket with parking number

---
**GIVEN** the car park has no parking lot available  
**WHEN** parking a car  
**THEN** cannot park the car and get a "car park full" message

---
**GIVEN** holding a valid parking ticket  
**WHEN** pick up the car with the ticket  
**THEN** get the correct car successfully

---
**GIVEN** holding an invalid parking ticket  
**WHEN** pick up the car with the ticket  
**THEN** cannot pick up any car, and get a "could not get car" message


## Part 2

**GIVEN** parking boy has multiple car parks, at least one of them has available lots  
**WHEN** park a car  
**THEN** park the car in the car park with most available lots, and return ticket

---
**GIVEN** parking boy has multiple car parks, some car parks have same number of available lots   
**WHEN** park a car  
**THEN** park the car in the first car park with most available lots, and return ticket

<!------->
<!--**GIVEN** parking boy has multiple car parks, first one filled and second one available  -->
<!--**WHEN** park a car  -->
<!--**THEN** park the car in second car park-->

---
**GIVEN** parking boy has multiple car parks, all are filled  
**WHEN** park a car  
**THEN** cannot park and get car park filled message

---
**GIVEN** holding a valid parking ticket  
**WHEN** pick up a car  
**THEN** get the car matches to the ticket from the correct car park

---
**GIVEN** holding a parking ticket does not match to any car in car parks  
**WHEN** pick up a car  
**THEN** cannot get the car and get a cannot pick message

---
**GIVEN** parking boy has multiple car parks, all are filled  
**WHEN** pick up a car first, and park another car  
**THEN** park the car and return ticket
