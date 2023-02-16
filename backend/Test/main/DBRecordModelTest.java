package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class DBRecordModelTest {
    String testName = "Lamer";
    String testCity = "Paniska";
    String testZipCode = "00-949";
    String testCountry = "Poland";
    private final DBRecordModel testModel = new DBRecordModel(testName, testCity, testZipCode, testCountry);

    @Test
    public void testNick(){
        assertEquals(
                testName,
                testModel.getNickname());
    }

    @Test
    public void test2(){
        assertEquals(
                testCity,
                testModel.getCity());
    }

    @Test
    public void test3(){
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