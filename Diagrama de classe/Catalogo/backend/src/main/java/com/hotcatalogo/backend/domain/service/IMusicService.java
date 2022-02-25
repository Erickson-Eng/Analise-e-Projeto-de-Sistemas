package com.hotcatalogo.backend.domain.service;

import com.hotcatalogo.backend.application.dto.api.MusicApi;
import com.hotcatalogo.backend.application.dto.request.MusicRequest;
import com.hotcatalogo.backend.application.dto.response.MusicResponse;
import com.hotcatalogo.backend.application.dto.response.MusicTableResponse;

public interface IMusicService {

    MusicResponse save(MusicRequest musicRequest);

    MusicResponse update(Long id, MusicApi musicApi);

    MusicResponse delete(Long id);

    MusicResponse getMusic(Long id);

    MusicTableResponse getAllMusicByTitle(String title);

    MusicTableResponse getAllMusicByAlbum(Long id);
}
