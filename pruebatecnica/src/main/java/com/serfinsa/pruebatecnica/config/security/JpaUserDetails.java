package com.serfinsa.pruebatecnica.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.repository.UserRepository;
import com.serfinsa.pruebatecnica.services.contract.IRoleService;

@Service
public class JpaUserDetails implements UserDetailsService{

    private final UserRepository userRepository;
    private final IRoleService roleService;

    public JpaUserDetails(UserRepository userRepository, IRoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecurityUser(
            userRepository.findByEmail(username), roleService
        );
    }
}
