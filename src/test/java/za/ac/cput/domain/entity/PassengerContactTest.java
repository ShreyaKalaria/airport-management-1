package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerContactTest {


    @Test
    public void test() {


        PassengerContact passengerContact = new PassengerContact.Builder().setPassengerId("001")
                .setConId("776")
                .build();

        System.out.println(passengerContact);


        PassengerContact passengerContact2 = new PassengerContact.Builder().setPassengerId("")
                .setConId("776")
                .build();
        System.out.println(passengerContact2);
    }
}