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
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    private String descricao;

    private LocalDate release;

    private Integer like;

    private Integer dislike;

//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @ManyToMany
    @JoinTable(name = "disc-members",
    joinColumns = @JoinColumn(name = "disc_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> members;

    @OneToMany(mappedBy = "disc")
    private List<Music> musics;

    @OneToOne(mappedBy = "disc")
    private Band band;
}
