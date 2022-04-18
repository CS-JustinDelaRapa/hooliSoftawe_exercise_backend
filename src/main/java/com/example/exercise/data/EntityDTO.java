package com.example.exercise.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntityDTO {
    private Integer Id;
    private String username;
    private String description;
    private LocalDate targetDate;
}
