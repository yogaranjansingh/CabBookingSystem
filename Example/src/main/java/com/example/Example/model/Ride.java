package com.example.Example.model;

import lombok.Data;

@Data
public class Ride {

    Location start;
    Location end;
    int riderId;
    int driverId;
    TripStatus status;

    public Ride(Location loc, Location loc1, int id, int id1) {
        status = TripStatus.ONGOING;
    }

    public Ride()
    {
        super();
    }
}
