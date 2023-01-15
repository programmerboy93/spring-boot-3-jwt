package snail.springboot3jwt.film;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Actor extends BaseEntity {

    private String firstname;

    private String lastname;

    private LocalDate birthDate;

    private String cityOfBirth;

    @ManyToMany(mappedBy = "actors", fetch = EAGER)
    @JoinTable(name = "films_actors",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false)})
    private Set<Film> films = new HashSet<>();
}
