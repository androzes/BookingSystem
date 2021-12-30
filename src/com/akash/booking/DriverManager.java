package com.akash.booking;

public interface DriverManager {

    public void addDriver(Driver d) throws Exception;

    public Driver getAvailableDriver();

    public void releaseDriver(String id) throws Exception;
}
