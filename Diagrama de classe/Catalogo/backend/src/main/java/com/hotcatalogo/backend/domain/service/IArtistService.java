package com.hotcatalogo.backend.domain.service;

import com.hotcatalogo.backend.application.dto.api.ArtistApi;
import com.hotcatalogo.backend.application.dto.request.ArtistRequest;
import com.hotcatalogo.backend.application.dto.response.ArtistResponse;

public interface IArtistService {

    ArtistResponse save(ArtistRequest artistRequest);

    ArtistResponse update(ArtistApi artistApi);

    ArtistResponse delete(Long id);

    ArtistResponse getArtist(Long id);
}
