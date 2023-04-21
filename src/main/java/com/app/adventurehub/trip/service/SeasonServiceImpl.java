package com.app.adventurehub.trip.service;

import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.persistence.SeasonRepository;
import com.app.adventurehub.trip.domain.service.SeasonService;

import java.util.List;

public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    @Override
    public Season create(Season season) {
        return seasonRepository.save(season);
    }
}
