package snail.springboot3jwt.film;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "film_genres")
public class FilmGenre extends BaseEntity {

    private String filmGenre;

    @ManyToMany
    private Set<Film> films = new HashSet<>();
}
