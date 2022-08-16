package ru.netology.daohibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "persons")
public class Person {
    @EmbeddedId
    private Profile profile;

    private String phoneNumber;

    @ManyToOne (optional = false)
    private City cityOfLiving;

    @Override
    public String toString() {
        return profile +
                ", телефон: " + phoneNumber +
                " " + cityOfLiving;
    }
}
