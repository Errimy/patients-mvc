package jeetp.patientsmvc;

import jeetp.patientsmvc.entities.Patient;
import jeetp.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Hassan",new Date(), false, 12));
			patientRepository.save(new Patient(null,"Hatim",new Date(), true, 64));
			patientRepository.save(new Patient(null,"Hafid",new Date(), false, 50));
			patientRepository.save(new Patient(null,"Aymane",new Date(), true, 10));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}

}
