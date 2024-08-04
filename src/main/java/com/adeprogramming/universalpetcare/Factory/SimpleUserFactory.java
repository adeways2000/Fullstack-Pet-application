package com.adeprogramming.universalpetcare.Factory;

import com.adeprogramming.universalpetcare.exception.UserAlreadyExistsException;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.repository.UserRepository;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleUserFactory  implements  UserFactory{
    private final UserRepository userRepository;
    private final VeterinarianFactory veterinarianFactory;
    private final PatientFactory patientFactory;
    private final AdminFactory adminFactory;
    @Override
    public User createrUser(RegistrationRequest registrationRequest) {
        if(userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new UserAlreadyExistsException("Oops! " +registrationRequest.getEmail()+ "already exist!");
        }
        switch (registrationRequest.getUserType()){
            case "VET" -> {return veterinarianFactory.createVeterinarian(registrationRequest);
            }
            case "PATIENT" -> {return patientFactory.createPatient(registrationRequest);
            }
            case "ADMIN" -> { return adminFactory.createAdmin(registrationRequest);
            }
            default -> {

                return null;
            }
        }

    }

}
