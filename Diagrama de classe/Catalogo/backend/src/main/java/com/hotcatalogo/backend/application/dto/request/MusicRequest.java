package com.hotcatalogo.backend.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicRequest {

    @NotNull
    private String title;
    @NotNull
    private Integer duration;
}
