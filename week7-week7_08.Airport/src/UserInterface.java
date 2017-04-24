import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W
 */
public class UserInterface {
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;
    private Scanner reader;

    public UserInterface(Scanner reader) {
        this.planes = new HashMap<String, Plane>();
        this.flights = new HashMap<String, Flight>();
        this.reader = reader;
    }


    public void airportService() {
        System.out.println("Airport panel\n"
                + "--------------------\n"
                + "\n");

        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Add airplane\n"
                    + "[2] Add flight\n"
                    + "[x] Exit\n"
                    + "> ");
            String command = reader.next();

            if (command.equals("x")) {
                System.out.println();
                break;
            } else if (command.equals("1")) {
                addPlane();
            } else if (command.equals("2")) {
                addFlight();
            }
        }
    }

    public void addPlane() {
        System.out.println("Give plane ID: ");
        String planeId = reader.next();
        System.out.println("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(reader.next());
        this.planes.put(planeId, new Plane(planeId, planeCapacity));
    }

    public void addFlight() {
        System.out.println("Give plane ID: ");
        String planeId = reader.next();
        Plane plane = planes.get(planeId);
        System.out.println("Give departure airport code: ");
        String departureCode = reader.next();
        System.out.println("Give destination airport code: ");
        String destinationCode = reader.next();
        Flight flight = new Flight(plane, departureCode, destinationCode);
        this.flights.put(planeId, flight);
    }

    public void flightService() {
        System.out.println("Flight service\n"
                + "------------\n"
                + "");

        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Print planes\n"
                    + "[2] Print flights\n"
                    + "[3] Print plane info\n"
                    + "[x] Quit\n"
                    + "> ");
            String command = reader.next();

            if (command.equals("x")) {
                System.out.println();
                break;
            } else if (command.equals("1")) {
                printPlanes();
            } else if (command.equals("2")) {
                printFlights();
            } else if (command.equals("3")) {
                planeInfo();
            }
        }
    }
    
    public void printPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Flight flight : flights.values()) {
            System.out.println(flight);
        }
    }

    public void planeInfo() {
        System.out.println("Give plane ID: ");
        String planeId = reader.next();
        Plane plane = planes.get(planeId);
        System.out.println(plane);
    }
}
