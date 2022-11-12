package com.greecode.IndependentBand.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String cellphone;

    private String gender;

    private LocalDateTime created = LocalDateTime.now();

    private Boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "user")
    private List<Email> emails;

    @ManyToMany(mappedBy = "musics")
    private List<Band> bands;

    @ManyToMany(mappedBy = "members")
    private List<Disc> discs;

    @ManyToMany(mappedBy = "musicsByMusic")
    private List<Music> musics;

    // Um usuário pode ter muitos seguidores - followers
    @OneToMany(mappedBy="to")
    private List<Followers> followers;

    // Um usuário pode seguir vários usuários - following
    @OneToMany(mappedBy="from")
    private List<Followers> following;

    @PrePersist
    public void prePersist() { setDeleted(false);}
}
