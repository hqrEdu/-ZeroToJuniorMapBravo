package configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/mapa-bravo";
    private static final String user = "postgres";
    private static final String password = "pass123";

    public void connection() {
        Connection connection = createConnection();
        if(connection != null) {
            Statement statement = createStatement(connection);
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgresSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private Statement createStatement(Connection connection) {
        Statement statement = null;
        try{
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }
}