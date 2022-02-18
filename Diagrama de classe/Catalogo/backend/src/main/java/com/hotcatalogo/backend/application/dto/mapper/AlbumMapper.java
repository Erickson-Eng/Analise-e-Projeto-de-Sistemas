package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.AlbumApi;
import com.hotcatalogo.backend.application.dto.request.AlbumRequest;
import com.hotcatalogo.backend.application.dto.response.AlbumResponse;
import com.hotcatalogo.backend.domain.entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    Album albumRequestToEntity(AlbumRequest albumRequest);

    Album albumApiToEntity(AlbumApi albumApi);

    AlbumResponse albumEntityToResponse(Album album);
}
