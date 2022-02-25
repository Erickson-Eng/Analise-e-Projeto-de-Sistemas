package com.hotcatalogo.backend.domain.service;

import com.hotcatalogo.backend.application.dto.api.ParticipantApi;
import com.hotcatalogo.backend.application.dto.request.ParticipantRequest;
import com.hotcatalogo.backend.application.dto.response.ParticipantResponse;
import com.hotcatalogo.backend.application.dto.response.ParticipantTableResponse;

public interface IParticipantService {

    ParticipantResponse save (ParticipantRequest participantRequest);

    ParticipantResponse update(Long id, ParticipantApi participantApi);

    ParticipantResponse delete(Long id);

    ParticipantTableResponse listAllParticipantByMusic(Long id);
}
