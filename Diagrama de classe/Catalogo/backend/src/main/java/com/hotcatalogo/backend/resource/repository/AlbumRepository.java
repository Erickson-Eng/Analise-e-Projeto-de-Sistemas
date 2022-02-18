package com.hotcatalogo.backend.resource.repository;

import com.hotcatalogo.backend.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}