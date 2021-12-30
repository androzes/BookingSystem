package com.akash.booking;

public interface BookingManager {

    // return booking id
    public String addBooking(int distance) throws Exception;

    public void completeBooking(String id) throws Exception;
}
