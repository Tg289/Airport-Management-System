import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AirportManager manager = new AirportManager();

        JFrame frame = new JFrame("Airport Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addFlightBtn = new JButton("Add Flight");
        addFlightBtn.setBounds(50, 50, 150, 30);
        addFlightBtn.addActionListener(e -> {
            String flightNo = JOptionPane.showInputDialog("Enter Flight Number:");
            String origin = JOptionPane.showInputDialog("Enter Origin:");
            String dest = JOptionPane.showInputDialog("Enter Destination:");
            manager.addFlight(flightNo, origin, dest);
        });

        JButton listFlightsBtn = new JButton("List Flights");
        listFlightsBtn.setBounds(250, 50, 150, 30);
        listFlightsBtn.addActionListener(e -> manager.listFlights());

        JButton addPassengerBtn = new JButton("Add Passenger");
        addPassengerBtn.setBounds(50, 120, 150, 30);
        addPassengerBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Passenger Name:");
            String passport = JOptionPane.showInputDialog("Enter Passport Number:");
            manager.addPassenger(name, passport);
        });

        JButton listPassengersBtn = new JButton("List Passengers");
        listPassengersBtn.setBounds(250, 120, 150, 30);
        listPassengersBtn.addActionListener(e -> manager.listPassengers());

        frame.add(addFlightBtn);
        frame.add(listFlightsBtn);
        frame.add(addPassengerBtn);
        frame.add(listPassengersBtn);

        frame.setVisible(true);
    }
}
