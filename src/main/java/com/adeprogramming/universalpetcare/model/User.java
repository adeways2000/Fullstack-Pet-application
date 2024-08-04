package com.adeprogramming.universalpetcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    @Column (name = "mobile")
    private String phoneNumber;
    private String password;
    private String userType;
    private String email;
    private boolean isEnabled;
    @Transient
    private String specialization;

    @Transient
    List<Appointment> appointments;


}
