package com.adeprogramming.universalpetcare.repository;

import com.adeprogramming.universalpetcare.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository  extends JpaRepository<Veterinarian, Long> {
}
