package com.hotcatalogo.backend.domain.service.mysql;

import com.hotcatalogo.backend.application.dto.api.AlbumApi;
import com.hotcatalogo.backend.application.dto.mapper.AlbumMapper;
import com.hotcatalogo.backend.application.dto.request.AlbumRequest;
import com.hotcatalogo.backend.application.dto.response.AlbumResponse;
import com.hotcatalogo.backend.application.dto.response.AlbumTableResponse;
import com.hotcatalogo.backend.domain.entity.Album;
import com.hotcatalogo.backend.domain.exception.ObjectNotFoundException;
import com.hotcatalogo.backend.domain.service.IAlbumService;
import com.hotcatalogo.backend.resource.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlbumServiceMySQL implements IAlbumService {

    private AlbumRepository albumRepository;
    private AlbumMapper albumMapper;

    @Override
    public AlbumResponse save(AlbumRequest albumRequest) {
        try{
            Album album = albumMapper.albumRequestToEntity(albumRequest);
            albumRepository.save(album);
            return albumMapper.albumEntityToResponse(album);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Unable to save album");
        }
    }

    @Override
    public AlbumResponse update(AlbumApi albumApi) {
        Album albumEntity = verifyIfExist(albumApi.getId());
        updateData(albumEntity, albumApi);
        return albumMapper.albumEntityToResponse(albumEntity);
    }

    @Override
    public AlbumResponse getAlbum(Long id) {
        Album albumEntity =  verifyIfExist(id);
        return albumMapper.albumEntityToResponse(albumEntity);
    }

    @Override
    public AlbumTableResponse getAlbumsByArtistName(String artistName) {
        List<Album> albumList = verifyIfExistAlbumForArtist(artistName);
        AlbumTableResponse albumTableResponse = new AlbumTableResponse();
        albumTableResponse.setAlbumResponses(albumList
                .stream()
                .map(albumMapper::albumEntityToResponse)
                .collect(Collectors.toList()));
        return albumTableResponse;
    }

    @Override
    public AlbumResponse delete(Long id) {
        Album albumEntity = verifyIfExist(id);
        albumRepository.delete(albumEntity);
        return albumMapper.albumEntityToResponse(albumEntity);
    }


    protected Album verifyIfExist(Long albumId){
        return albumRepository.findById(albumId)
                .orElseThrow(ObjectNotFoundException::new);
    }

    protected List<Album> verifyIfExistAlbumForArtist(String artistName){
        return albumRepository.findAllByArtist_Name(artistName)
                .orElseThrow(ObjectNotFoundException::new);
    }

    private void updateData(Album albumEntity, AlbumApi albumApi) {
        albumEntity.setTitle(albumApi.getTitle());
    }
}
