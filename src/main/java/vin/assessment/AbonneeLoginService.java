package vin.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vin.assessment.model.Abonnee;

@Service
public class AbonneeLoginService implements UserDetailsService {

	@Autowired
	private AbonneeRepos abonneeRepos;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Abonnee abonnee = abonneeRepos.findByEmail(email);
		if (abonnee == null) {
			throw new UsernameNotFoundException(email);
		}
		
		//normaliseer wachtwoord
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
		String hash = cryptPasswordEncoder.encode(abonnee.getWachtwoord());
//		UserDetails user = User.withUsername(abonnee.getEmail()).password(hash).authorities("USER")
//				.build();

		UserDetails user = User.withUsername(abonnee.getEmail()).password(abonnee.getWachtwoord()).authorities("USER")
				.build();
		return user;
	}
}
