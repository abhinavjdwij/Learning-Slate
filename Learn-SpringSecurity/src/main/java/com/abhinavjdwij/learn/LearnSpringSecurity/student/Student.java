package com.abhinavjdwij.learn.LearnSpringSecurity.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final Integer studentId;
    private final String studentName;
}
