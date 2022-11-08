package com.greecode.IndependentBand.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameMusic;

    private String duration;

    private String lyrics;

    private String description;

    private LocalDateTime created = LocalDateTime.now();

    private LocalDate releaseDate;

    private Integer like;

    private Integer dislike;

//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "disc_id")
    private Disc disc;

    @ManyToMany
    @JoinTable(name = "users_by_music",
            joinColumns = @JoinColumn(name = "music_id"),
            inverseJoinColumns = @JoinColumn(name = "user_music_id"))
    private List<User> musicsByMusic;
}
