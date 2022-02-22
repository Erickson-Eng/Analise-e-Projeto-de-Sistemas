package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {

    Optional<List<Music>> findAllByTitle(String title);

    Optional<List<Music>> findAllByAlbum_ArtistName(String artist);
}