package ru.dzhager3354.back;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "todos")
@Data
public class TodoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name="name")
    private String name;
    private String description;
    private Date deadline;
}
