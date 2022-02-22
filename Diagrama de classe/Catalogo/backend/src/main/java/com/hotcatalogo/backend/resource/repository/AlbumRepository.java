package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {


    Optional<List<Album>> findAllByArtist_Name(String artistName);

    Optional<List<Album>> findAllByTitle(String title);
}