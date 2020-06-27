package com.example.Example.Controller;

import com.example.Example.Persistence.Store;
import com.example.Example.model.Driver;
import com.example.Example.model.Location;
import com.example.Example.model.Ride;
import com.example.Example.model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RiderControllerImpl implements RiderController {


    @Autowired
    private Store store = new Store();

    @RequestMapping(value="/registerRider", method= RequestMethod.POST)
    public ResponseEntity registerRider(@RequestBody Rider rider) {
        store.getRiders().add(rider);
        System.out.println(store);
        return new ResponseEntity(store.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/getRiderHistory", method= RequestMethod.POST)
    public ResponseEntity getRiderHistory(@RequestBody int riderId) {
        Rider rider = store.getRiderById(riderId);
        List<Ride> ridesTaken =  store.getRides(rider);
        return new ResponseEntity(ridesTaken.toString(), HttpStatus.OK);
    }


    @RequestMapping(value="/bookCab", method= RequestMethod.POST)
    public ResponseEntity bookCab(@RequestBody Rider rider) {
        Location loc = rider.getLocation();
        List<Driver> driversCloseBy =  store.getDriversInRiderRadius(loc);
        Random random = new Random();
        int allocatedDriverIndex = random.nextInt(driversCloseBy.size());
        Driver allocatedDriver = null;
        if(allocatedDriverIndex<= driversCloseBy.size())
            allocatedDriver =  driversCloseBy.get(allocatedDriverIndex);
        store.saveRide(new Ride(loc, loc , rider.getId(), allocatedDriver.getId()));
        return new ResponseEntity(allocatedDriver.toString(), HttpStatus.OK);
    }





}
