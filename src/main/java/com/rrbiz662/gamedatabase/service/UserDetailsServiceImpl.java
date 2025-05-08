package com.rrbiz662.gamedatabase.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rrbiz662.gamedatabase.domain.AppUser;
import com.rrbiz662.gamedatabase.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final AppUserRepository userRepository;

	public UserDetailsServiceImpl(AppUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		
		// Check if user exists
		if(user.isPresent()) {
			AppUser currentUser = user.get();
			
			// Build user
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		}
		else {
			throw new UsernameNotFoundException("User not found.");
		}
		
		// return built user
		return builder.build();
	}
}
