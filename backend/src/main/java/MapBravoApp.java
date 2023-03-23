import service.User;
import service.UserService;

import java.util.ArrayList;

public class MapBravoApp {

    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.addUser("INSERT INTO map.user VALUES (1, 'człapek', 'Kraków', 'Poland', '34-522')");
        userService.addUser("INSERT INTO map.user VALUES (2, 'KomPost', 'Wrocław', 'Poland', '64-329')");
        userService.addUser("INSERT INTO map.user VALUES (3, 'DonLider', 'Łódź', 'Poland', '55-555')");
        userService.addUser("INSERT INTO map.user VALUES (4, 'Papinek', 'Warszawa', 'Poland', '00-954')");
        ArrayList<User> users =  userService.getUsers();
        for (User user : users) {
            System.out.println(user.getNickname() + " " + user.getCity() + " " + user.getZipCode() + " " + user.getCountry());
        }

    }
}