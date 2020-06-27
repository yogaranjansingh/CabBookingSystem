package com.example.Example.Controller;

import com.example.Example.model.Driver;
import com.example.Example.model.Location;
import com.example.Example.model.Rider;
import org.springframework.http.ResponseEntity;

public interface DriverController {

    ResponseEntity registerDriver(Driver driver);

    ResponseEntity updateCabLocation(Location location, int driverId);

    ResponseEntity updateDriverAvailability(int driverId, boolean available);
}
