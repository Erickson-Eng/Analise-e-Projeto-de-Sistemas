package com.hotcatalogo.backend.application.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumApi {

    private Long id;
    private String title;
    private String releaseDate;
    private Long artistId;
}
