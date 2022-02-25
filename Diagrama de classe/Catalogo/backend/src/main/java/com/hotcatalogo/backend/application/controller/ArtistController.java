package com.hotcatalogo.backend.application.controller;

import com.hotcatalogo.backend.application.dto.api.ArtistApi;
import com.hotcatalogo.backend.application.dto.request.ArtistRequest;
import com.hotcatalogo.backend.application.dto.response.ArtistResponse;
import com.hotcatalogo.backend.domain.service.IArtistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/artist")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ArtistController {

    private IArtistService artistService;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistResponse findArtistById(@PathVariable Long id){
        return artistService.getArtist(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistResponse saveArtist(@RequestBody ArtistRequest artistRequest){
        return artistService.save(artistRequest);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistResponse deleteArtistById(@PathVariable Long id){
        return artistService.delete(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistResponse updateArtistInformationById(@PathVariable Long id,
                                                      @RequestBody ArtistApi artistApi){
        return artistService.update(id, artistApi);
    }
}
