package org.example.lab3_20213852.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.lab3_20213852.Entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica,Integer> {
}
