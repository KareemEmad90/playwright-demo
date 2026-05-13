package utils;
import java.sql.*;
public class VehicleQueries {

    // =========================
    // SELECT SINGLE VALUE
    // =========================
    public static String getTrafficId(String query, String column) {

        try {
            Statement stmt = DBConnections.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return rs.getString(column);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // =========================
    // SELECT MULTIPLE ROWS (example simple print)
    // =========================
    public static void printResults(String query, String column) {

        try {
            Statement stmt = DBConnections.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(column));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // =========================
    // UPDATE QUERY
    // =========================
    public static int updateQuery(String query) {

        try {
            Statement stmt = DBConnections.getConnection().createStatement();
            return stmt.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // =========================
    // INSERT QUERY
    // =========================
    public static int insertQuery(String query) {

        try {
            Statement stmt = DBConnections.getConnection().createStatement();
            return stmt.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


