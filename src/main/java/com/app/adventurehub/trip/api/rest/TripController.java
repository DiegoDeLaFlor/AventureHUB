package com.app.adventurehub.trip.api.rest;

import com.app.adventurehub.trip.domain.model.entity.Trip;
import com.app.adventurehub.trip.domain.service.TripService;
import com.app.adventurehub.trip.mapping.TripMapper;
import com.app.adventurehub.trip.resource.CreateTripResource;
import com.app.adventurehub.trip.resource.TripResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TripController {
    private final TripService tripService;

    private final TripMapper mapper;

    public TripController(TripService tripService, TripMapper mapper) {
        this.tripService = tripService;
        this.mapper = mapper;
    }

    @GetMapping("trips")
    public List<TripResource> getAllTripById(){
        return mapper.toResourceList(tripService.GetAll());
    }

    @GetMapping("{trip}")
    public List<TripResource> getTripByPrice(@PathVariable int price){
        return mapper.toResourceList(tripService.getTripByPrice(price));
    }
    @PostMapping
    public ResponseEntity<TripResource> createTrip(@RequestBody CreateTripResource resource){
        return new ResponseEntity<>(mapper.toResource(tripService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
