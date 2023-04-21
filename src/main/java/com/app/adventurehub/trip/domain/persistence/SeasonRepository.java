package com.app.adventurehub.trip.domain.persistence;

import com.app.adventurehub.trip.domain.model.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long>{

}
