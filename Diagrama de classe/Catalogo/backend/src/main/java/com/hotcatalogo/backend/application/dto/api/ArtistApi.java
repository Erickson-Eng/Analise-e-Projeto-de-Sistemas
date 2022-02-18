package com.hotcatalogo.backend.application.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistApi {

    private Long id;
    private String name;
    private String nationality;
}
