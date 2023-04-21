package com.app.adventurehub.trip.domain.service;


import com.app.adventurehub.trip.domain.model.entity.Season;

import java.util.List;

public interface SeasonService {
    List<Season> getAll();
    Season create(Season season);
}
