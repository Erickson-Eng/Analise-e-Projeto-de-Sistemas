package com.hotcatalogo.backend.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("Album")
public class AlbumTableResponse {

    @JsonProperty("AlbumList")
    private List<AlbumResponse> albumResponses;
}
