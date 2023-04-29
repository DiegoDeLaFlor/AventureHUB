package com.app.adventurehub.trip.api.rest;

import com.app.adventurehub.trip.domain.service.SeasonService;

import com.app.adventurehub.trip.mapping.SeasonMapper;

import com.app.adventurehub.trip.resource.SeasonResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seasons")
public class SeasonController {

    private final SeasonService seasonService;

    private final SeasonMapper seasonMapper;

    public SeasonController(SeasonService seasonService, SeasonMapper seasonMapper) {
        this.seasonService = seasonService;
        this.seasonMapper = seasonMapper;
    }

    @GetMapping
    public List<SeasonResource> getAllSeason(){
        return seasonMapper.toResourceList(seasonService.getAll());
    }

}
