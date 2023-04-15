import static org.junit.jupiter.api.Assertions.assertEquals;

import com.map.model.User;
import org.junit.jupiter.api.Test;


class UserTest {
    String testName = "Lamer";
    String testCity = "Paniska";
    String testZipCode = "00-949";
    String testCountry = "Poland";
    private final User testModel = new User(1, testName, testCity, testZipCode, testCountry, 1, 1);

    @Test
    void testNick(){
        assertEquals(
                testName,
                testModel.getNickname());
    }

    @Test
    void TestCity(){
        assertEquals(
                testCity,
                testModel.getCity());
    }

    @Test
    void testCode(){
        assertEquals(
                testZipCode,
                testModel.getZipCode());
    }

    @Test
    void testCountry(){
        assertEquals(
                testCountry,
                testModel.getCountry());
    }

}