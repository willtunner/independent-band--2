package com.greecode.IndependentBand.repositories;

import com.greecode.IndependentBand.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmailRepository extends JpaRepository<Email, Long> {
}
