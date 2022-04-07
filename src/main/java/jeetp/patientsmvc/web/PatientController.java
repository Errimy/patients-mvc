package jeetp.patientsmvc.web;

import jeetp.patientsmvc.repositories.PatientRepository;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
