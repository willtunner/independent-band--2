package com.greecode.IndependentBand.repositories;

import com.greecode.IndependentBand.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
