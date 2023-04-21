package com.app.adventurehub.trip.service;

import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.persistence.SeasonRepository;
import com.app.adventurehub.trip.domain.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeasonServiceImpl implements SeasonService {
    @Autowired
    private final SeasonRepository seasonRepository;

    private static String[] DEFAULT_SEASON = {"SUMMER", "WINTER", "FALL", "SPRING"};


    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

}
