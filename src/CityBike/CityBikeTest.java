package CityBike;

import org.junit.Assume;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Assumptions.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        for(int i=0; i<1000; i++) {
            assertTrue(validColor(Bike.getColor()));
            assertNotNull(Bike.getColor());
            assertTrue(Bike.getColor() instanceof String);
        }
    }

    boolean validColor(String test){
        switch (test){
            case "red":;
            case "blue":;
            case "yellow":;
            case "white":;
            case "black": return true;
            default: return false;
        }
    }

    @org.junit.jupiter.api.Test
    void buyBikes() {
        HashMap<Integer,Bike> test = new HashMap<Integer,Bike>();
        Bike.buyBikes(test, 5);
        Assumptions.assumeTrue(test.size()==5,{

        });
    }

    @org.junit.jupiter.api.Test
    void setState() {
    }

    @org.junit.jupiter.api.Test
    void getState() {
    }

    @org.junit.jupiter.api.Test
    void getBikeID() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}