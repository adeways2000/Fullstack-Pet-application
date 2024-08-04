package com.adeprogramming.universalpetcare.repository;

import com.adeprogramming.universalpetcare.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
