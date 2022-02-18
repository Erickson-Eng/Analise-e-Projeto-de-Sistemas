package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}