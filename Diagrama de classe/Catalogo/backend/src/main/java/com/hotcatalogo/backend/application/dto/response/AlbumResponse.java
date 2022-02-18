package com.hotcatalogo.backend.application.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Album")
public class AlbumResponse {
    private Long id;
    private String title;
    private String releaseDate;

    private Long artistId;
}
