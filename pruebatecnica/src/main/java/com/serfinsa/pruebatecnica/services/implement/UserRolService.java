package com.serfinsa.pruebatecnica.services.implement;

import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.entity.Rol;
import com.serfinsa.pruebatecnica.entity.User;
import com.serfinsa.pruebatecnica.entity.UserRol;
import com.serfinsa.pruebatecnica.repository.UserRolRepository;
import com.serfinsa.pruebatecnica.services.contract.IUserRolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRolService implements IUserRolService{

    private final UserRolRepository userRolRepository;

    @Override
    public UserRol save(User user, Rol rol) {
        UserRol userRol = new UserRol();
        userRol.setRol(rol);
        userRol.setUser(user);
        return userRolRepository.save(userRol);
    }
}
