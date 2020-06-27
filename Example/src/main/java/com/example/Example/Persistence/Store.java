package com.example.Example.Persistence;

import com.example.Example.model.Driver;
import com.example.Example.model.Location;
import com.example.Example.model.Ride;
import com.example.Example.model.Rider;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Store {

    ArrayList<Rider> riders = new ArrayList<Rider>();
    ArrayList<Driver> drivers = new ArrayList<Driver>();
    ArrayList<Ride> rides = new ArrayList<Ride>();
    double maximumDistance = 10.0;


    public List<Driver> getDriversInRiderRadius(Location location)
    {
        ArrayList<Driver> driversInRadius = new ArrayList<Driver>();
        for(Driver driver : drivers)
        {
            if(getDistance(location, driver.getLocation())<=10)
            {
                driversInRadius.add(driver);
            }
        }
        return driversInRadius;
    }

    public double getDistance(Location loc1, Location loc2)
    {
        double lat1 = loc1.getLat();
        double lat2 = loc2.getLat();
        double lng1 = loc1.getLng();
        double lng2 = loc2.getLng();
        double distance =  Math.sqrt( Math.pow(lat2-lat1 , 2) + Math.pow(lng2-lng1, 2) );
        return distance;
    }

    public Rider getRiderById(int id)
    {
        for(Rider rider : riders)
        {
            if(rider.getId()==id)
                return rider;
        }
        return null;
    }

    public Driver getDriverById(int id)
    {
        for(Driver driver : drivers)
        {
            if(driver.getId()==id)
                return driver;
        }
        return null;
    }

    public List<Ride> getRides(Rider rider) {
        ArrayList<Ride> rides = new ArrayList<Ride>();
        for(Ride ride : rides)
        {
            if(ride.getRiderId()==rider.getId())
            {
                rides.add(ride);
            }
        }
        return rides;
    }

    public Ride saveRide(Ride ride)
    {
        rides.add(ride);
        return ride;
    }



}
