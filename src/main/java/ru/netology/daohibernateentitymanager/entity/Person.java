package ru.netology.daohibernateentitymanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(nullable = false, length = 100)
    private String name;

    @Id
    @Column(nullable = false, length = 100)
    private String surname;

    @Id
    @Column(nullable = false)
    private Integer age;

    @Column(length = 50,
            name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false,
            length = 120,
    name = "city_of_living")
    private String cityOfLiving;
}
