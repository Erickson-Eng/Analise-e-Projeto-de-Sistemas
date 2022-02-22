package com.hotcatalogo.backend.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Album")
public class AlbumTableResponse {

    @JsonProperty("AlbumList")
    private List<AlbumResponse> albumResponses;
}
