package com.adeprogramming.universalpetcare.Factory;

import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.model.Veterinarian;
import com.adeprogramming.universalpetcare.repository.VeterinarianRepository;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinarianFactory {

    private final VeterinarianRepository veterinarianRepository;
    private final UserAttributesMapper userAttributesMapper;


    public User createVeterinarian(RegistrationRequest request) {

        Veterinarian veterinarian = new Veterinarian();
        userAttributesMapper.setCommonAttributes(request, veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());
        return  veterinarianRepository.save(veterinarian);

    }
}
