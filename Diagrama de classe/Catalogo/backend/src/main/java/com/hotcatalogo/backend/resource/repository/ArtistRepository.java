package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}