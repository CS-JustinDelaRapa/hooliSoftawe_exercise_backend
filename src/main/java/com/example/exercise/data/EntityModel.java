package com.example.exercise.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "todo")
public class EntityModel {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entity_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "description")
    private String description;

    @Column(name = "targetDate")
    private LocalDate targetDate;

    public EntityModel(String username, String description, LocalDate targetDate) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
    }
}
