package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Optional<List<Participant>> findAllByMusic_Id(Long musicId);
}