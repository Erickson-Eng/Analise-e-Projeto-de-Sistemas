package com.hotcatalogo.backend.domain.service;

import com.hotcatalogo.backend.application.dto.api.ParticipantApi;
import com.hotcatalogo.backend.application.dto.request.ParticipantRequest;
import com.hotcatalogo.backend.application.dto.response.ParticipantResponse;

import java.util.List;

public interface IParticipantService {

    ParticipantResponse save (ParticipantRequest participantRequest);

    ParticipantResponse update(ParticipantApi participantApi);

    ParticipantResponse delete(Long id);

    List<ParticipantResponse> listAllParticipantByMusic(Long id);
}
