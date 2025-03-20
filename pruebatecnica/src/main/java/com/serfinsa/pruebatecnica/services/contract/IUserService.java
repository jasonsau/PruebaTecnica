package com.serfinsa.pruebatecnica.services.contract;

import org.springframework.security.core.Authentication;

import com.serfinsa.pruebatecnica.domain.dto.UserRegisterDto;
import com.serfinsa.pruebatecnica.entity.User;

public interface IUserService {

    User findByEmail(String email);
    User registerUser(UserRegisterDto userRegisterDto);
    Authentication login(String username, String password);
    String generateToken(Authentication authentication);
    String generateRefreshToken(Authentication authentication);
}
