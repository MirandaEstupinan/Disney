package com.alkemy.Disney.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Setter(AccessLevel.NONE)
    private long id;

    private String image;
    private String title;
    private LocalDate creationDate;

    private TypeMovieSerie typeMovieSerie;

    private Integer qualification;

    @OneToMany(mappedBy="movieSerie", orphanRemoval = true, fetch=FetchType.EAGER)
    private Set<MoSeCharacter> moSeCharacters  = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;

    public MovieSerie(String image, String title, LocalDate creationDate, Integer qualification, Gender gender, TypeMovieSerie typeMovieSerie) {
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.gender = gender;
        this.typeMovieSerie = typeMovieSerie;
    }
}
