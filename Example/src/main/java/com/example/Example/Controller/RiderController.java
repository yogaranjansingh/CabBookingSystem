package com.example.Example.Controller;

import com.example.Example.model.Rider;
import org.springframework.http.ResponseEntity;

public interface RiderController {

    ResponseEntity registerRider(Rider rider);

}
