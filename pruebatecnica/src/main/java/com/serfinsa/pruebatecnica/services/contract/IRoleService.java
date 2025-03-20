package com.serfinsa.pruebatecnica.services.contract;

import java.util.List;

import com.serfinsa.pruebatecnica.entity.Rol;

public interface IRoleService {

    List<Rol> findRolesByUserId(Integer id);

    Rol findByName(String name);

}
