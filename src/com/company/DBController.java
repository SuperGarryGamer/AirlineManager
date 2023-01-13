package com.company;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class DBController {
    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        try {
            // db parameters
            Connection conn = null;
            String url = "jdbc:sqlite:C:flights.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        try {
            Connection conn = DBController.connect();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from flights");

            while (rs.next()) {
                String flightID = rs.getString("flightID");
                String arrivalIATA = rs.getString("arrivalIATA");
                String departureIATA = rs.getString("departureIATA");
                String arrivalTime = rs.getString("arrivalTime");
                String departureTime = rs.getString("departureTime");
                String airline = rs.getString("airline");

                Flight f = new Flight(flightID,
                        arrivalIATA,
                        departureIATA,
                        LocalDate.parse(arrivalTime),
                        LocalDate.parse(departureTime),
                        airline);
                flights.add(f);
            }
            return flights;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return flights;
        }
    }

    public static boolean query(String sql) {
        Connection conn = DBController.connect();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
}