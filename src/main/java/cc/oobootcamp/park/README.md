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

