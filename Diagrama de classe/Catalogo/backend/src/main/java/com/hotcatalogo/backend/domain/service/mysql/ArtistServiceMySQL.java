package com.hotcatalogo.backend.domain.service.mysql;

import com.hotcatalogo.backend.application.dto.api.ArtistApi;
import com.hotcatalogo.backend.application.dto.mapper.ArtistMapper;
import com.hotcatalogo.backend.application.dto.request.ArtistRequest;
import com.hotcatalogo.backend.application.dto.response.ArtistResponse;
import com.hotcatalogo.backend.domain.entity.Artist;
import com.hotcatalogo.backend.domain.exception.ObjectNotFoundException;
import com.hotcatalogo.backend.domain.service.IArtistService;
import com.hotcatalogo.backend.resource.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ArtistServiceMySQL implements IArtistService {

    ArtistRepository artistRepository;
    ArtistMapper artistMapper;

    @Override
    public ArtistResponse save(ArtistRequest artistRequest) {
        Artist artistEntity = artistMapper.artistRequestToEntity(artistRequest);
        artistRepository.save(artistEntity);
        return artistMapper.artistEntityToResponse(artistEntity);
    }

    @Override
    public ArtistResponse update(Long id,ArtistApi artistApi) {
        Artist artistEntity = verifyIfExist(id);
        BeanUtils.copyProperties(artistApi, artistEntity, "id");
        return artistMapper.artistEntityToResponse(artistEntity);
    }

    @Override
    public ArtistResponse delete(Long id) {
        Artist artistEntity = verifyIfExist(id);
        artistRepository.delete(artistEntity);
        return artistMapper.artistEntityToResponse(artistEntity);
    }

    @Override
    public ArtistResponse getArtist(Long id) {
        Artist artistEntity = verifyIfExist(id);
        return artistMapper.artistEntityToResponse(artistEntity);
    }

    protected Artist verifyIfExist(Long id){
        return artistRepository.findById(id)
                .orElseThrow(ObjectNotFoundException::new);
    }

    protected List<Artist> verifyIfExist(String name){
        return artistRepository.findAllByName(name)
                .orElseThrow(ObjectNotFoundException::new);
    }
}
