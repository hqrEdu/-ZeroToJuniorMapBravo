import service.UserService;

public class MapBravoApp {

    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.addUser();

    }
}