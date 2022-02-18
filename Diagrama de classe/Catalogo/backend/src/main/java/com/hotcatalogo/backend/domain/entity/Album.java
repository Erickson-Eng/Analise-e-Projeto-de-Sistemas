package com.hotcatalogo.backend.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "album")
public class Album implements Serializable {
    private static final long serialVersionUID = 3240900943275799387L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private LocalDate releaseDate;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "album", orphanRemoval = true)
    private List<Music> musics;

}