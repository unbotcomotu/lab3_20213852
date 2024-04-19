package org.example.lab3_20213852.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.example.lab3_20213852.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findAllByClinicaId(Integer clinicaId);
    List<Paciente> findAllByOftalmologoId(Integer oftalmologoId);

    @Query(value = "select * from paciente p where oftalmologo_id=?1 and p.fecha_cita>now()",nativeQuery = true)
    List<Paciente> pacientesNoAtendidosPorOftalmologo(Integer idOftalmologo);

    Paciente findPacienteById(Integer id);
    @Transactional
    @Modifying
    @Query(value = "update paciente set numero_habitacion=?1 where id=?2",nativeQuery = true)
    public void editarPaciente(Integer numero,Integer idPaciente);
}
