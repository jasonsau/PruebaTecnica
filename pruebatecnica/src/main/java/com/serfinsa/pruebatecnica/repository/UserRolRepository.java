package com.serfinsa.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serfinsa.pruebatecnica.entity.UserRol;


@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Integer> {

}
