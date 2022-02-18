package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.AlbumApi;
import com.hotcatalogo.backend.application.dto.request.AlbumRequest;
import com.hotcatalogo.backend.application.dto.response.AlbumResponse;
import com.hotcatalogo.backend.domain.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ArtistMapper.class})
public interface AlbumMapper {

    Album albumRequestToEntity(AlbumRequest albumRequest);

    @Mappings({
            @Mapping(target = "artist.id", source = "artistId")
    })
    Album albumApiToEntity(AlbumApi albumApi);

    @Mappings({
            @Mapping(target = "artistResponse", source = "artist")
    })
    AlbumResponse albumEntityToResponse(Album album);
}
