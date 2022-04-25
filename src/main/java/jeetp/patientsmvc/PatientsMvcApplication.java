package jeetp.patientsmvc;

import jeetp.patientsmvc.entities.Patient;
import jeetp.patientsmvc.repositories.PatientRepository;
import jeetp.patientsmvc.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Hassan",new Date(), false, 112));
			patientRepository.save(new Patient(null,"Hatim",new Date(), true, 164));
			patientRepository.save(new Patient(null,"Hafid",new Date(), false, 150));
			patientRepository.save(new Patient(null,"Aymane",new Date(), true, 110));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}
	//@Bean
	CommandLineRunner saveUsers(SecurityService securityService){
		return args-> {
		securityService.saveNewUser("hatim","1234","1234");
		securityService.saveNewUser("hafid","1234","1234");
		securityService.saveNewUser("ilyass","1234","1234");

		securityService.saveNewRole("USER","");
		securityService.saveNewRole("ADMIN","");

		securityService.addRoleToUser("hatim","USER");
		securityService.addRoleToUser("hatim","ADMIN");
		securityService.addRoleToUser("hafid","USER");
		securityService.addRoleToUser("ilyass","USER");
		};
	}

}
