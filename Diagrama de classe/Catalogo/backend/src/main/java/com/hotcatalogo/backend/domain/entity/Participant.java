package com.hotcatalogo.backend.domain.entity;

import com.hotcatalogo.backend.domain.entity.enums.ParticipantType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "participant")
public class Participant implements Serializable {
    private static final long serialVersionUID = -4426251894300116253L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(cascade = {CascadeType.REFRESH})
    private Music music;
    @OneToOne(cascade = {CascadeType.REFRESH})
    private Artist artist;

    @Enumerated(EnumType.STRING)
    private ParticipantType participantType;

}