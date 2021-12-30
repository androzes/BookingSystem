package com.akash.booking;

public class Driver {
    String id;
    DriverStatus status;

    public Driver(String id) {
        this.id = id;
        status = DriverStatus.AVAILABLE;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public void setAvailable() {
        setStatus(DriverStatus.AVAILABLE);
    }

    public void setUnAvailable() {
        setStatus(DriverStatus.UNAVAILABLE);
    }

}
