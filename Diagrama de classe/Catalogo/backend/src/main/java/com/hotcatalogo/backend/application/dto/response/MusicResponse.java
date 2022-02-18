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
@JsonRootName("Music")
public class MusicResponse {

    private Long id;
    private String title;
    private Integer duration;
}
