package ihundan.wukonglin.synthesize.security.service;

import ihundan.wukonglin.synthesize.security.dataStore.SecurityUserRepository;
import ihundan.wukonglin.synthesize.security.model.SecurityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityServiceUser implements UserDetailsService{
	@Autowired
	public SecurityUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		SecurityUser securityUser = userRepository.findUserByUsername(username);
		if( securityUser==null){
            throw new UsernameNotFoundException( "not found user by username" );
        }
		User user = new User(securityUser.getUsername(), securityUser.getPassword(), 
				AuthorityUtils.createAuthorityList(securityUser.getRoles().split(",")));
		return user;
	}

}
