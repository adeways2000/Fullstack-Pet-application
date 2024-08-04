package com.adeprogramming.universalpetcare.service.user;

import com.adeprogramming.universalpetcare.dto.UserDto;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.request.UserUpdateRequest;

import java.util.List;

public interface IUserService {
    User add(RegistrationRequest request);

    User update (Long userId, UserUpdateRequest request);

    Object findById(Long userId);

    void delete(Long userId);

    List<UserDto> getAllUsers();
}
