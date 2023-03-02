import configuration.DatabaseConnection;

public class MapBravoApp {

    public static void main(String[] args) {

        DatabaseConnection connection = new DatabaseConnection();
        connection.connection();
    }
}