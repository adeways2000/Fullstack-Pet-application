package com.adeprogramming.universalpetcare.repository;

import com.adeprogramming.universalpetcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
