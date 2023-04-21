package com.app.adventurehub.trip.service;

import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import com.app.adventurehub.trip.domain.persistence.SeasonRepository;
import com.app.adventurehub.trip.domain.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class SeasonServiceImpl implements SeasonService {
    @Autowired
    private final SeasonRepository seasonRepository;

    private static String[] DEFAULT_SEASON = {"SUMMER", "WINTER", "FALL", "SPRING"};


    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_SEASON)
                .forEach(name -> {
                    Seasons seasonName = Seasons.valueOf(name);
                    if(!seasonRepository.existsByName(seasonName)) {
                        seasonRepository.save((new Season()).withName(seasonName));
                    }
                });
    }

    @Override
    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

}
