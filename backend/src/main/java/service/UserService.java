package service;

import configuration.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    private static final String QUERY = "INSERT INTO map.user VALUES (4, 'cipaek', 'Warszawa', 'Poland', '00-000')";

    public void addUser() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Statement statement = databaseConnection.connection();
            statement.execute(QUERY);
            statement.close();
            System.out.println("User has been correctly added.");
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }
    }
}