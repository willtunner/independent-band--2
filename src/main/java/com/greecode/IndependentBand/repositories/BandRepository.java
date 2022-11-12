package com.greecode.IndependentBand.repositories;

import com.greecode.IndependentBand.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
