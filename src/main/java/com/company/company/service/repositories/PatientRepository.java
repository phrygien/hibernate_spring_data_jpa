package com.company.company.service.repositories;

import com.company.company.service.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* spring data (pas besoin d'utiliser un EnityManager)
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
