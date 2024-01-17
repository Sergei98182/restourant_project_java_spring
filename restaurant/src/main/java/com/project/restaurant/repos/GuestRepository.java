package com.project.restaurant.repos;

import com.project.restaurant.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    List<Guest> findAll();
}
