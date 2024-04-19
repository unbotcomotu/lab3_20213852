package org.example.lab3_20213852.Repository;

import org.example.lab3_20213852.Entity.Oftalmologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OftalmologoRepository extends JpaRepository<Oftalmologo,Integer> {
    List<Oftalmologo> findAllByClinicaId(Integer clinicaId);

}
