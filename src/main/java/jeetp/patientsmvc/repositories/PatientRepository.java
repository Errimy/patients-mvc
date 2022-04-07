package jeetp.patientsmvc.repositories;

import jeetp.patientsmvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
