package com.serfinsa.pruebatecnica.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.serfinsa.pruebatecnica.entity.Rol;
import com.serfinsa.pruebatecnica.repository.RolRepository;
import com.serfinsa.pruebatecnica.services.contract.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{

    private final RolRepository roleRepository;


    @Override
    public List<Rol> findRolesByUserId(Integer id) {
        return this.roleRepository.findByUserId(id);
    }

    public Rol findByName(String name) {
        return roleRepository.findByName(name.toUpperCase()).orElse(null);
    }
}
