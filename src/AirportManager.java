import java.sql.*;
import javax.swing.JOptionPane;

public class AirportManager {

    private Connection conn;

    public AirportManager() {
        conn = DBConnection.getConnection();
    }

    // FLIGHTS
    public void addFlight(String flightNo, String origin, String destination) {
        String sql = "INSERT INTO flights (flight_no, origin, destination) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, flightNo);
            pst.setString(2, origin);
            pst.setString(3, destination);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Flight added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listFlights() {
        String sql = "SELECT * FROM flights";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(", Flight No: ").append(rs.getString("flight_no"))
                  .append(", Origin: ").append(rs.getString("origin"))
                  .append(", Destination: ").append(rs.getString("destination"))
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PASSENGERS
    public void addPassenger(String name, String passport) {
        String sql = "INSERT INTO passengers (name, passport) VALUES (?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, passport);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Passenger added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listPassengers() {
        String sql = "SELECT * FROM passengers";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(", Name: ").append(rs.getString("name"))
                  .append(", Passport: ").append(rs.getString("passport"))
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
