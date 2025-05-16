package org.xcelore.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotBlank(message = "City is mandatory")
    @Size(max = 20, message = "City must not exceed 20 characters")
    private String city;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotBlank(message = "Symptom is mandatory")
    @Pattern(regexp = "Arthritis|Headache|Ear pain|Skin rash|Chest pain", message = "Symptom must be Arthritis, Headache, Ear pain, Skin rash, or Chest pain")
    private String symptom;
}