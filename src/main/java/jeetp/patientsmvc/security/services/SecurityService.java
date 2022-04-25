package jeetp.patientsmvc.security.services;

import jeetp.patientsmvc.security.entities.AppRole;
import jeetp.patientsmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);

}
