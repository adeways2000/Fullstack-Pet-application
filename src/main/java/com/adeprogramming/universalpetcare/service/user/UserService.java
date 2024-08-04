package com.adeprogramming.universalpetcare.service.user;

import com.adeprogramming.universalpetcare.Factory.UserFactory;
import com.adeprogramming.universalpetcare.dto.EntityConverter;
import com.adeprogramming.universalpetcare.dto.UserDto;
import com.adeprogramming.universalpetcare.exception.ResourceNotFoundException;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.repository.UserRepository;
import com.adeprogramming.universalpetcare.repository.VeterinarianRepository;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final VeterinarianRepository veterinarianRepository;



    @Override
    public User add(RegistrationRequest request) {
        return userFactory.createrUser(request);
    }

    @Override
    public User update (Long userId, UserUpdateRequest request) {
         User user = (User) findById(userId);
         user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setSpecialization(request.getSpecialization());

        return  userRepository.save(user);

    }

    @Override
    public Object findById(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void delete(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(userRepository::delete, () -> {
                    throw new ResourceNotFoundException("User not found");
                });
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(user -> entityConverter.mapEntityToDto(user, UserDto.class)).collect(Collectors.toList());

    }
}
