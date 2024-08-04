package com.adeprogramming.universalpetcare.Factory;

import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;

public interface UserFactory {
    public User createrUser(RegistrationRequest registrationRequest);
}
