package com.hotcatalogo.backend.domain.service;

import com.hotcatalogo.backend.application.dto.api.AlbumApi;
import com.hotcatalogo.backend.application.dto.request.AlbumRequest;
import com.hotcatalogo.backend.application.dto.response.AlbumResponse;
import com.hotcatalogo.backend.application.dto.response.AlbumTableResponse;

public interface IAlbumService {

    AlbumResponse save(AlbumRequest albumRequest);

    AlbumResponse update(AlbumApi albumApi);

    AlbumResponse getAlbum(Long id);

    AlbumTableResponse getAlbumsByArtistName(String artistName);

    AlbumResponse delete(Long id);


}
