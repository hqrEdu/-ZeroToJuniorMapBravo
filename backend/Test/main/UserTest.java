package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class UserTest {
    String testName = "Lamer";
    String testCity = "Paniska";
    String testZipCode = "00-949";
    String testCountry = "Poland";
    private final User testModel = new User(testName, testCity, testZipCode, testCountry);

    @Test
    public void testNick(){
        assertEquals(
                testName,
                testModel.getNickname());
    }

    @Test
    public void TestCity(){
        assertEquals(
                testCity,
                testModel.getCity());
    }

    @Test
    public void testCode(){
        assertEquals(
                testZipCode,
                testModel.getZipCode());
    }

    @Test
    public void testCountry(){
        assertEquals(
                testCountry,
                testModel.getCountry());
    }

}