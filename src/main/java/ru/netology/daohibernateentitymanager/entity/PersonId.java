package ru.netology.daohibernateentitymanager.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
