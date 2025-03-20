package com.serfinsa.pruebatecnica.services.contract;

import com.serfinsa.pruebatecnica.entity.Rol;
import com.serfinsa.pruebatecnica.entity.User;
import com.serfinsa.pruebatecnica.entity.UserRol;

public interface IUserRolService {
    UserRol save(User user, Rol rol);
}
