package com.akash.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDriverManager implements  DriverManager {
    Map<String, Driver> allDrivers;
    List<String> availableDrivers;

    static SimpleDriverManager instance;

    public SimpleDriverManager() {
        allDrivers = new HashMap<>();
        availableDrivers = new ArrayList<>();
    }

    public static SimpleDriverManager getInstance() {
        if (instance == null) {
            instance = new SimpleDriverManager();
        }
        return instance;
    }

    public void addDriver(Driver d) throws Exception {
        if (allDrivers.containsKey(d.id)) {
            throw new Exception("Driver: " + d.id + " already exists");
        }

        d.status = DriverStatus.AVAILABLE;
        allDrivers.put(d.id, d);
        availableDrivers.add(d.id);
    }

    public Driver getAvailableDriver() {
        if(availableDrivers.size() == 0)  {
            return null;
        }
        String id = availableDrivers.remove(0);
        allDrivers.get(id).setStatus(DriverStatus.UNAVAILABLE);
        return allDrivers.get(id);
    }

    public void releaseDriver(String id) throws Exception{
        if (!allDrivers.containsKey(id)) {
            throw new Exception("Driver with id: " + id + " not found");
        }
        Driver driver = allDrivers.get(id);
        availableDrivers.add(id);
        driver.setStatus(DriverStatus.AVAILABLE);
    }
}
