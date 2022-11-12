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
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer like = 0;

    private Integer dislike = 0;

    private String genre;

    private LocalDateTime created = LocalDateTime.now();

//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @ManyToMany
    @JoinTable(name = "users_band",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> musics;

    @OneToMany(mappedBy = "band")
    private List<Disc> discs;


}
