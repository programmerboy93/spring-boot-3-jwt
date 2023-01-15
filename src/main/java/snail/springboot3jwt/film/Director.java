package snail.springboot3jwt.film;

import jakarta.persistence.*;
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

    @ManyToOne
    private Set<Film> films =  new HashSet<>();
}
