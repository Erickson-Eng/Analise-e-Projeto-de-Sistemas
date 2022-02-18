package com.hotcatalogo.backend.application.dto.mapper;

import com.hotcatalogo.backend.application.dto.api.ParticipantApi;
import com.hotcatalogo.backend.application.dto.request.ParticipantRequest;
import com.hotcatalogo.backend.application.dto.response.ParticipantResponse;
import com.hotcatalogo.backend.domain.entity.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "music.id", source = "musicId"),
            @Mapping(target = "artist.id", source = "artistId")
    })
    Participant participantRequestToEntity(ParticipantRequest participantRequest);

    @Mappings({
            @Mapping(target = "music.id", source = "musicId"),
            @Mapping(target = "artist.id", source = "artistId")
    })
    Participant participantApiToEntity(ParticipantApi participantApi);

    @Mappings({
            @Mapping(target = "musicId", source = "music.id"),
            @Mapping(target = "artistId", source = "artist.id")
    })
    ParticipantResponse participantEntityToResponse(Participant participant);
}
