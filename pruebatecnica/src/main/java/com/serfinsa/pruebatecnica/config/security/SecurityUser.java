package com.serfinsa.pruebatecnica.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.serfinsa.pruebatecnica.entity.Rol;
import com.serfinsa.pruebatecnica.entity.User;
import com.serfinsa.pruebatecnica.services.contract.IRoleService;

public class SecurityUser implements UserDetails{

    private User user;
    private final IRoleService roleService;

    public SecurityUser(User user, IRoleService roleService) {
        this.user = user;
        this.roleService = roleService;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        try{
            List<Rol> roles = roleService.findRolesByUserId(this.user.getId());
            if(roles.isEmpty()) {
                return null;
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(Rol rol : roles) {
                authorities.add(new SimpleGrantedAuthority(rol.getName().toUpperCase()));
            }
            return authorities;
        } catch(Exception e){
            return Collections.emptyList();
        }
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

}
