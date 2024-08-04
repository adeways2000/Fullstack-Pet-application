package com.adeprogramming.universalpetcare.dto;

import lombok.Data;

@Data
public class UserDto {
  
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String userType;
    private String email;
    private boolean isEnabled;
    private String specialization;
}
