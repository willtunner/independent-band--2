package com.greecode.IndependentBand.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    private String description;

    private LocalDate release;

    private Integer like = 0;

    private Integer dislike = 0;

//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @ManyToMany
    @JoinTable(name = "disc-members",
    joinColumns = @JoinColumn(name = "disc_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> members;

    @OneToMany(mappedBy = "disc")
    private List<Music> musics;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "band_id")
    private Band band;
}
