package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}