package br.com.rocketseat.aula.java.todolist.repositories;

import br.com.rocketseat.aula.java.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
