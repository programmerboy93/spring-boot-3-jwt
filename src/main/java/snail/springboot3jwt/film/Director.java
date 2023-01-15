package snail.springboot3jwt.film;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "directors")
public class Director extends BaseEntity{

    private String firstname;

    private String lastname;

    @OneToMany
    @JoinColumn(name = "director_id")
    private Set<Film> films =  new HashSet<>();
}
