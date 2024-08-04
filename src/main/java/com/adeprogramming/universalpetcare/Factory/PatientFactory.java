package com.adeprogramming.universalpetcare.Factory;

import com.adeprogramming.universalpetcare.model.Patient;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.repository.PatientRepository;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientFactory {

    private final PatientRepository patientRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createPatient(RegistrationRequest request) {
        Patient patient = new Patient();
        userAttributesMapper.setCommonAttributes(request,patient);
        return patientRepository.save(patient);
    }
}
