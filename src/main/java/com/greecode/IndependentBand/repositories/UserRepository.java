package com.greecode.IndependentBand.repositories;

import com.greecode.IndependentBand.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
