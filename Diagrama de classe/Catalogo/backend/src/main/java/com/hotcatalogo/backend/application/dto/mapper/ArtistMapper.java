package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.ArtistApi;
import com.hotcatalogo.backend.application.dto.request.ArtistRequest;
import com.hotcatalogo.backend.application.dto.response.ArtistResponse;
import com.hotcatalogo.backend.domain.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    @Mappings({
            @Mapping(target = "artist.id", source = "artistId")
    })
    Artist artistRequestToEntity(ArtistRequest artistRequest);

    @Mappings({
            @Mapping(target = "artist.id", source = "artistId")
    })
    Artist artistApiToEntity(ArtistApi artistApi);

    ArtistResponse artistEntityToResponse(Artist artist);
}
