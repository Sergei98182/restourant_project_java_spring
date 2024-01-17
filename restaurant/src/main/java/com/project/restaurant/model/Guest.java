package com.project.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "guests")
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phoneNumber;
    public Guest(String name, String lastname, String phoneNumber, String password, String email) {
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
    }
}
