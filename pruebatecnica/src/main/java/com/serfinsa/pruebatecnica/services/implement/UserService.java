package com.serfinsa.pruebatecnica.services.implement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.domain.dto.UserRegisterDto;
import com.serfinsa.pruebatecnica.entity.Rol;
import com.serfinsa.pruebatecnica.entity.User;
import com.serfinsa.pruebatecnica.repository.UserRepository;
import com.serfinsa.pruebatecnica.services.contract.IRoleService;
import com.serfinsa.pruebatecnica.services.contract.IUserRolService;
import com.serfinsa.pruebatecnica.services.contract.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    @Value("${jwt.duration}")
    Long duration;
    private final UserRepository userRepository;
    private final IRoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final IUserRolService iUserRolService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User registerUser(UserRegisterDto userRegisterDto){
        Rol rolDefault = roleService.findByName("USER");
        if(rolDefault == null) return null;

        String passwordEncode = passwordEncoder.encode(userRegisterDto.getPassword());
        User user = new User();
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncode);
        user.setName(userRegisterDto.getName());
        this.save(user);
        iUserRolService.save(user, rolDefault);
        return user;

    }

    public Authentication login(String username, String password) {
        Authentication auth = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        return this.authenticationManager.authenticate(auth);
    }

    public String generateToken(Authentication authentication) {
        return jwtService.createToken(authentication, duration, null);
    }

    public String generateRefreshToken(Authentication authentication) {
        return jwtService.createToken(authentication, duration * 24, "REFRESH_TOKEN");

    }
}
