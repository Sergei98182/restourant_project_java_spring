package com.project.restaurant.service;

import com.project.restaurant.model.Guest;
import com.project.restaurant.dto.RegistrationForm;
import com.project.restaurant.repos.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }
    public static Guest createGuestFromRegistrationForm(RegistrationForm form) {
        return new Guest(form.getName(), form.getLastname(), form.getPhoneNumber(), form.getPassword(), form.getEmail());
    }

}
