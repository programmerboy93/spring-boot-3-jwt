package snail.springboot3jwt.film;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "actors")
public class Actor extends BaseEntity {

    private String firstname;

    private String lastname;

    private LocalDate birthDate;

    private String cityOfBirth;

    @ManyToMany(mappedBy = "actors", fetch = EAGER)
    private Set<Film> films = new HashSet<>();
}
