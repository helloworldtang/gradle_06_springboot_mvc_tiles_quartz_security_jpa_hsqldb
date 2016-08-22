package ihundan.wukonglin.synthesize.security.dataStore;


import ihundan.wukonglin.synthesize.security.model.SecurityUser;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SecurityUserRepository extends JpaRepository<SecurityUser, Serializable>{
	SecurityUser findUserByUsername(String username);
}
