package ru.netology.daohibernate.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Profile implements Serializable {
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "Пользователь: " +
                name + " " +
                surname +
                ", возраст:  " +
                age;
    }
}
