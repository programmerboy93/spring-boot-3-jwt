package snail.springboot3jwt.film;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "films")
public class Film extends BaseEntity {

    private String title;

    private LocalDate datePublished;

    @ManyToMany(mappedBy = "films", fetch = EAGER)
    @JoinTable(name = "roles_films",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "actor_id", nullable = false)
    )
    private Set<Film> actors = new HashSet<>();

    @ManyToMany(mappedBy = "filmGenres", fetch = EAGER)
    @JoinTable(name = "films_film_genres",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "film_genres_id", nullable = false)
    )
    private Set<FilmGenre> filmGenres = new HashSet<>();

    @ManyToMany(mappedBy = "country", fetch = EAGER)
    @JoinTable(name = "films_countries",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "country_id", nullable = false)
    )
    private Country country;

    @OneToMany(mappedBy = "films", fetch = EAGER)
    @JoinTable(name = "films_director",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "director_id", nullable = false)
    )
    private Director director;

    private LocalTime duration;

    private String description;

    //avg rating
    private Double popularity;

    private LocalDate dataAdded;

    //how many people gave void on the film
    private Long numberOfRatings;

}
