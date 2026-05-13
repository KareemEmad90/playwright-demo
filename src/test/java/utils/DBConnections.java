package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnections {

    private static Connection connection;

    public static void connect() {
        try {
            String url = "jdbc:oracle:thin:@//xxx.xx.xxx.xxx:xxxx/trfdv";
            String user = "Traffic";
            String password = "xxxx";

            connection = DriverManager.getConnection(url, user, password);

            System.out.println("DB Connected");

        } catch (SQLException e) {
            throw new RuntimeException("DB Connection Failed: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


