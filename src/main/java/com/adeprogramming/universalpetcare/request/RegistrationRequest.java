package com.adeprogramming.universalpetcare.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String password;
    private String userType;
    private String email;
    private boolean isEnabled;
    private String specialization;
}
