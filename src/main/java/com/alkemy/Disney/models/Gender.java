package com.alkemy.Disney.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String image;

    @OneToMany(mappedBy="gender", fetch=FetchType.EAGER)
    private Set<MovieSerie> movieSeries  = new HashSet<>();

    public Gender(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
