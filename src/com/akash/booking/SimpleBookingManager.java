package com.akash.booking;

import java.util.HashMap;
import java.util.Map;


public class SimpleBookingManager implements BookingManager {

    Map<String, Booking> bookings;
    SimpleDriverManager driverManager;

    private static SimpleBookingManager instance;


    public SimpleBookingManager() {
        bookings = new HashMap<>();
        driverManager = SimpleDriverManager.getInstance();
    }

    public static SimpleBookingManager getInstance() {
        if (instance == null) {
            instance = new SimpleBookingManager();
        }
        return instance;
    }


    // return booking id
    public String addBooking(int distance) throws Exception{
        // assign driver to booking
        Driver driver = driverManager.getAvailableDriver();

        if(driver == null) {
            throw new Exception("Sorry, driver is not available");
        }

        // generate booking id
        Booking bk = new Booking(generateBookingId(), distance);

        bk.assignDriver(driver.id);
        bk.setStatus(BookingStatus.IN_TRANSIT);

        // add to map
        bookings.put(bk.id, bk);

        return bk.id;
    }

    private String generateBookingId() {
        int id = bookings.size() + 1;
        return "booking-" + id;
    }

    public void completeBooking(String id) throws Exception{
        if (!bookings.containsKey(id)) {
            throw new Exception("Booking " + id + " is invalid");
        }

        Booking bk = bookings.get(id);

        // check for booking which is already completed
        if (bk.isRequestCompleted()) {
            throw new Exception("Booking " + id + " is already complete");
        }

        bk.setStatus(BookingStatus.COMPLETED);
        driverManager.releaseDriver(bk.driverId);
    }

    public Booking getBookingFromId(String id) {
        return bookings.get(id);
    }
}
