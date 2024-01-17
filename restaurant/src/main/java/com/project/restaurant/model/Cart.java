package com.project.restaurant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Carts")
@SessionScope
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String phone;
    private Date date = new Date();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Dish> dishes = new HashSet<>();
}

