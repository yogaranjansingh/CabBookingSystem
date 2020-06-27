package com.example.Example.Controller;

import com.example.Example.Persistence.Store;
import com.example.Example.model.Driver;
import com.example.Example.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverControllerImpl implements DriverController {

    @Autowired
    private Store store;

    @Override
    @RequestMapping(value="/registerDriver", method= RequestMethod.POST)
    public ResponseEntity registerDriver(@RequestBody  Driver driver) {
        store.getDrivers().add(driver);
        System.out.println(store);
        return new ResponseEntity(store.toString(),HttpStatus.OK);
    }


    @Override
    @RequestMapping(value="/updateCabLocation", method= RequestMethod.POST)
    public ResponseEntity updateCabLocation(@RequestBody Location location, int driverId) {
        for(Driver driver : store.getDrivers())
        {
            if(driver.getId()==driverId)
            {
                driver.setLocation(location);
            }
        }
        return new ResponseEntity(store.toString(), HttpStatus.ACCEPTED);
    }

    @Override
    @RequestMapping(value="/updateDriverAvailability", method= RequestMethod.POST)
    public ResponseEntity updateDriverAvailability(int driverId, boolean available) {
        for(Driver driver : store.getDrivers())
        {
            if(driver.getId()==driverId)
            {
                driver.setAvailable(available);
            }
        }
        return new ResponseEntity(store.toString(), HttpStatus.ACCEPTED);
    }
}
