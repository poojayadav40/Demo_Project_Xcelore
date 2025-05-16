package org.xcelore.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Doctor {
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

    @NotBlank(message = "Speciality is mandatory")
    @Pattern(regexp = "Orthopaedic|ENT|Dermatology|Cardiology", message = "Speciality must be Orthopaedic, ENT, Dermatology, or Cardiology")
    private String speciality;
}