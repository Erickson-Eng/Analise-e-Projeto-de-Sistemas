package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<List<Artist>> findAllByNationality(String nationality);

    Optional<List<Artist>> findAllByName(String name);
}