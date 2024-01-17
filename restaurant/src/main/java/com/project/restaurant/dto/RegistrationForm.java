package com.project.restaurant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
        @NotBlank(message = "Name is required")
        private String name;

        @NotBlank(message = "Last name is required")
        private String lastname;

        @NotBlank(message = "Email is required")
        @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}", message = "Invalid email format")
        private String email;

        private String password;

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
        private String phoneNumber;
}
