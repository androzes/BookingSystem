package com.akash.booking;

import com.sun.tools.corba.se.idl.InvalidArgument;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    // Driver management system
    // Booking Management
    // A driver can be assigned to a single booking at a time
    // A single booking cannot be assigned to be multiple drivers


    // Driver
    // DriverStatus (available, unavailable)

    // Booking
    // BookingStatus (accepted, intransit, completed)
    // DriverManager -> pool of our available drivers,
    //  1. registering a driver,
    //  2. assignment of drivers,
    //  3. complete a booking

    // DriverToBooking Mapping
    // Pool of available and busy drivers
    // History of driver bookings and total distance

    public static void main(String[] args) {
        // write your code here
        System.out.println(args[0] + " " + args[1]);

        while (true) {
            try {
                Scanner sc = new Scanner(new InputStreamReader(System.in));
                args = sc.nextLine().split(" ");

                if (args.length < 2) throw new IllegalArgumentException();

                String command = args[0];
                String arg1 = args[1];

                switch (command) {
                    case "register_driver":
                        SimpleDriverManager sdm = SimpleDriverManager.getInstance();
                        Driver driver = new Driver(arg1);
                        sdm.addDriver(driver);
                        System.out.println("Driver " + arg1 + " registered");
                        break;
                    case "dispatch_driver_for_a_booking":
                        SimpleBookingManager sbm = SimpleBookingManager.getInstance();
                        String bookingId = sbm.addBooking(Integer.parseInt(arg1));
                        Booking bk = sbm.getBookingFromId(bookingId);
                        System.out.println("Driver " + bk.driverId + " is assigned to booking " + bookingId + " with " + bk.distance + " km distance");
                        break;
                    case "complete_booking":
                        SimpleBookingManager sbmI = SimpleBookingManager.getInstance();
                        sbmI.completeBooking(arg1);
                        Booking booking = sbmI.getBookingFromId(arg1);
                        System.out.println("Driver " + booking.driverId + " is released to allocation pool");
                        break;
                    default:
                        System.out.println("Invalid command");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }
        }


    }
}
