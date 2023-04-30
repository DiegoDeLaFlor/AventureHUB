package com.app.adventurehub.trip.domain.persistence;

import com.app.adventurehub.trip.domain.model.entity.Season;
import com.app.adventurehub.trip.domain.model.enumeration.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{
    Optional<Season> findByName(Seasons name);

    boolean existsByName(Seasons name);

}
