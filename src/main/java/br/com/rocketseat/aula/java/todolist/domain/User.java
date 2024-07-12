package br.com.rocketseat.aula.java.todolist.domain;

import br.com.rocketseat.aula.java.todolist.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String email;
    private String password;

    public User(UserDTO userData) {
        this.name = userData.name();
        this.email = userData.email();
        this.password = userData.password();
    }
}
