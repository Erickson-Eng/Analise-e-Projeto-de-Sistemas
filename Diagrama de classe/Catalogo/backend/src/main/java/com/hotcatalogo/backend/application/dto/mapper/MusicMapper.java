package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.MusicApi;
import com.hotcatalogo.backend.application.dto.request.MusicRequest;
import com.hotcatalogo.backend.application.dto.response.MusicResponse;
import com.hotcatalogo.backend.domain.entity.Music;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AlbumMapper.class})
public interface MusicMapper {

    @Mappings({
            @Mapping(target = "album.id", source = "albumId")
    })
    Music musicRequestToEntity(MusicRequest musicRequest);

    Music musicApiToEntity(MusicApi musicApi);

    MusicResponse musicEntityToResponse(Music music);
}
