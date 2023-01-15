package snail.springboot3jwt.film;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "films")
public class Film extends BaseEntity{

    private String title;

    private LocalDate datePublished;

    @ManyToMany(mappedBy = "films")
    private Set<Film> actors = new HashSet<>();

    @ManyToMany(mappedBy = "filmGenres")
    private Set<FilmGenre> filmGenres = new HashSet<>();

    @ManyToMany(mappedBy = "country")
    private Country country;

    private LocalTime duration;

    private String description;

    //avg rating
    private Double popularity;

    private LocalDate dataAdded;

    //how many people give void on the film
    private Long numberOfRatings;


}
