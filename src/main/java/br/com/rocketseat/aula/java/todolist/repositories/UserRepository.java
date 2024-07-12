package br.com.rocketseat.aula.java.todolist.repositories;

import br.com.rocketseat.aula.java.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
}
