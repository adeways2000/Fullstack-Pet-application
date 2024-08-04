package com.adeprogramming.universalpetcare.Factory;

import com.adeprogramming.universalpetcare.model.Admin;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.repository.AdminRepository;
import com.adeprogramming.universalpetcare.request.RegistrationRequest;
import com.adeprogramming.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFactory {

    private final AdminRepository adminRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createAdmin(RegistrationRequest request) {
        Admin admin = new Admin();
        userAttributesMapper.setCommonAttributes(request, admin);
        return adminRepository.save(admin);

    }
}
