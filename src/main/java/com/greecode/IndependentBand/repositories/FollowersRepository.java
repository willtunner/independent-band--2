package com.greecode.IndependentBand.repositories;

import com.greecode.IndependentBand.models.Followers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowersRepository extends JpaRepository<Followers, Long> {
}
