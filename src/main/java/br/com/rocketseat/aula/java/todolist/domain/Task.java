package br.com.rocketseat.aula.java.todolist.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Column(length = 50)
    private String title;

    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
