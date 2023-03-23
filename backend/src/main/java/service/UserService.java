package service;

import model.User;
import configuration.DatabaseConnection;

import java.sql.*;
//import java.sql.Statement;
import java.util.ArrayList;

public class UserService {

    private static final String QUERY = "INSERT INTO map.user VALUES (5, 'czopaek', 'Gdynia', 'Poland', '00-157')";

    public void addUser(String addUserQuery) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Statement statement = databaseConnection.connection();
            statement.execute(addUserQuery);
            statement.close();
            System.out.println("Model.User has been correctly added.");
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }
    }

    public ArrayList<User> getUsers() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String queryGetAll = "SELECT * FROM map.user ORDER BY id";
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = databaseConnection.connection();
            ResultSet resultSet = statement.executeQuery(queryGetAll);
            while (resultSet.next()) {
                String nickname = resultSet.getString(2);
                String city = resultSet.getString(3);
                String zipCode = resultSet.getString(4);
                String country = resultSet.getString(5);
                User user = new User(nickname, city, zipCode, country);
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("Błąd połączenia z bazą danych: " + e.getMessage());
        }
        return users;
    }
}