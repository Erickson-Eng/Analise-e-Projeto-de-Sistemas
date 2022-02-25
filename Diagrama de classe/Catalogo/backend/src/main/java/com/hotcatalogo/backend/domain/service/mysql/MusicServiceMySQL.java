package com.hotcatalogo.backend.domain.service.mysql;

import com.hotcatalogo.backend.application.dto.api.MusicApi;
import com.hotcatalogo.backend.application.dto.mapper.MusicMapper;
import com.hotcatalogo.backend.application.dto.request.MusicRequest;
import com.hotcatalogo.backend.application.dto.response.MusicResponse;
import com.hotcatalogo.backend.application.dto.response.MusicTableResponse;
import com.hotcatalogo.backend.domain.entity.Music;
import com.hotcatalogo.backend.domain.exception.ObjectNotFoundException;
import com.hotcatalogo.backend.domain.service.IMusicService;
import com.hotcatalogo.backend.resource.repository.MusicRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MusicServiceMySQL implements IMusicService {

    MusicRepository musicRepository;
    MusicMapper musicMapper;

    @Override
    public MusicResponse save(MusicRequest musicRequest) {
        Music musicEntity = musicMapper.musicRequestToEntity(musicRequest);
        musicRepository.save(musicEntity);
        return musicMapper.musicEntityToResponse(musicEntity);
    }

    @Override
    public MusicResponse update(Long id, MusicApi musicApi) {
        Music music = getOneMusicByIdOrElseThrow(id);
        BeanUtils.copyProperties(musicApi, music,"id");
        musicRepository.save(music);
        return musicMapper.musicEntityToResponse(music);
    }

    @Override
    public MusicResponse delete(Long id) {
        Music music = getOneMusicByIdOrElseThrow(id);
        musicRepository.delete(music);
        return musicMapper.musicEntityToResponse(music);
    }

    @Override
    public MusicResponse getMusic(Long id) {
        Music music = getOneMusicByIdOrElseThrow(id);
        return musicMapper.musicEntityToResponse(music);
    }

    @Override
    public MusicTableResponse getAllMusicByAlbum(Long id) {
        MusicTableResponse tableResponse = new MusicTableResponse();
        List<MusicResponse> responses = verifyIfExistOrElseThrow(id)
                .stream().map(musicMapper::musicEntityToResponse)
                .collect(Collectors.toList());
        tableResponse.setMusicResponseList(responses);
        return tableResponse;
    }

    @Override
    public MusicTableResponse getAllMusicByTitle(String title) {
        MusicTableResponse musicTableResponse = new MusicTableResponse();
        List<MusicResponse> musicResponseList = verifyIfExistOrElseThrow(title)
                .stream()
                .map(musicMapper::musicEntityToResponse)
                .collect(Collectors.toList());
        musicTableResponse.setMusicResponseList(musicResponseList);
        return musicTableResponse;
    }

    private Music getOneMusicByIdOrElseThrow(Long id){
        return musicRepository.findById(id)
                .orElseThrow(ObjectNotFoundException::new);
    }

    private List<Music> verifyIfExistOrElseThrow(Long id){
        return musicRepository.findAllByAlbum_Id(id)
                .orElseThrow(ObjectNotFoundException::new);
    }

    private List<Music> verifyIfExistOrElseThrow(String title){
        return musicRepository.findAllByTitle(title)
                .orElseThrow(ObjectNotFoundException::new);
    }
}
