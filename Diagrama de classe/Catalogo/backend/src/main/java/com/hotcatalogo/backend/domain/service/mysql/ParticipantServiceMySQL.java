package com.hotcatalogo.backend.domain.service.mysql;

import com.hotcatalogo.backend.application.dto.api.ParticipantApi;
import com.hotcatalogo.backend.application.dto.mapper.ParticipantMapper;
import com.hotcatalogo.backend.application.dto.request.ParticipantRequest;
import com.hotcatalogo.backend.application.dto.response.ParticipantResponse;
import com.hotcatalogo.backend.application.dto.response.ParticipantTableResponse;
import com.hotcatalogo.backend.domain.entity.Participant;
import com.hotcatalogo.backend.domain.exception.ObjectNotFoundException;
import com.hotcatalogo.backend.domain.service.IParticipantService;
import com.hotcatalogo.backend.resource.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParticipantServiceMySQL implements IParticipantService {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;

    @Override
    public ParticipantResponse save(ParticipantRequest participantRequest) {
        Participant participantEntity = participantMapper.participantRequestToEntity(participantRequest);
        participantRepository.save(participantEntity);
        return participantMapper.participantEntityToResponse(participantEntity);
    }

    @Override
    public ParticipantResponse update(Long id, ParticipantApi participantApi) {
        Participant participantEntity = verifyIfExistOrElseThrow(id);
        BeanUtils.copyProperties(participantApi, participantEntity, "id");
        participantRepository.save(participantEntity);
        return participantMapper.participantEntityToResponse(participantEntity);
    }

    @Override
    public ParticipantResponse delete(Long id) {
        Participant participantEntity = verifyIfExistOrElseThrow(id);
        participantRepository.delete(participantEntity);
        return participantMapper.participantEntityToResponse(participantEntity);
    }

    @Override
    public ParticipantTableResponse listAllParticipantByMusic(Long id) {
        List<Participant> participantList = verifyIfExistParticipantForMusic(id);
        List<ParticipantResponse> participantResponses = participantList
                .stream()
                .map(participantMapper::participantEntityToResponse)
                .collect(Collectors.toList());
        return new ParticipantTableResponse(participantResponses);
    }

    private Participant verifyIfExistOrElseThrow(Long id){
        return participantRepository.findById(id)
                .orElseThrow(ObjectNotFoundException::new);
    }

    private List<Participant> verifyIfExistParticipantForMusic(Long musicId){
        return participantRepository.findAllByMusic_Id(musicId)
                .orElseThrow(ObjectNotFoundException::new);
    }
}
