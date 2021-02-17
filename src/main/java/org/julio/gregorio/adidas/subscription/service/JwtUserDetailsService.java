package org.julio.gregorio.adidas.subscription.service;

import java.util.ArrayList;
import java.util.Optional;

import org.julio.gregorio.adidas.subscription.error.BadRequestException;
import org.julio.gregorio.adidas.subscription.service.model.User;
import org.julio.gregorio.adidas.subscription.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByName(username);

		if (!user.isPresent()) {
			throw new BadRequestException("User not found with username: " + username);
		}

		return new org.springframework.security.core.userdetails.User(user.get().getName(), user.get().getPassword(),
				new ArrayList<>());
	}

}