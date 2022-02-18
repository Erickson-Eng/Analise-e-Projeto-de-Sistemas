package com.hotcatalogo.backend.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "music")
public class Music implements Serializable {
    private static final long serialVersionUID = -3976637989787597121L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer duration;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Album album;

}