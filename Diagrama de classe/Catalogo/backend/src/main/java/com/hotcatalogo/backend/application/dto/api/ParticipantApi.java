package com.hotcatalogo.backend.application.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantApi {
    private Long id;
    private Long musicId;
    private Long artistId;
    private String participantType;
}
