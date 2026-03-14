package com.filip.eduplatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chapterId;

    private String title;

    private String description;

    private String classLevel;

    @OneToMany(mappedBy = "chapter")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "chapter")
    private List<Quiz> quizzes;
}
