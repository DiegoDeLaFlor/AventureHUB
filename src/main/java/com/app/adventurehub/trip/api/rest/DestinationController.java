package com.app.adventurehub.trip.api.rest;

import com.app.adventurehub.trip.domain.service.DestinationService;
import com.app.adventurehub.trip.mapping.DestinationMapper;
import com.app.adventurehub.trip.resource.DestinationResource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/desatination")
public class DestinationController {

    private final DestinationService destinationService;
    private final DestinationMapper destinationMapper;

    public DestinationController(DestinationService destinationService, DestinationMapper destinationMapper) {
        this.destinationService = destinationService;
        this.destinationMapper = destinationMapper;
    }

    @GetMapping
    @Operation(summary = "Get All Destinations", tags = {"Destinations"} )
    public List<DestinationResource> getAllDestinations(){
        return destinationMapper.toResourceList(destinationService.getAll());
    }

    @PostMapping
    @Operation(summary = "Create Destination", tags = {"Destinations"})
    public ResponseEntity<DestinationResource> createDestiantion(@RequestBody DestinationResource resource){
        return new ResponseEntity<>(destinationMapper.toResource(destinationService.create(destinationMapper.toModel(resource))), HttpStatus.CREATED);
    }
}
