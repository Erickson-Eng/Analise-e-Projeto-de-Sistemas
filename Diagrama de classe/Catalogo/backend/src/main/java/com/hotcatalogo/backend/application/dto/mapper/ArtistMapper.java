package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.ArtistApi;
import com.hotcatalogo.backend.application.dto.request.ArtistRequest;
import com.hotcatalogo.backend.application.dto.response.ArtistResponse;
import com.hotcatalogo.backend.domain.entity.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist artistRequestToEntity(ArtistRequest artistRequest);

    Artist artistApiToEntity(ArtistApi artistApi);

    ArtistResponse artistEntityToResponse(Artist artist);
}
