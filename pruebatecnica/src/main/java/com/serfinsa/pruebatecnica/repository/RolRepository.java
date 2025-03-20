package com.serfinsa.pruebatecnica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serfinsa.pruebatecnica.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    @Query("SELECT r FROM Rol r  LEFT JOIN UserRol ur on r = ur.rol WHERE ur.user.id = ?1")
    List<Rol> findByUserId(Integer id);

    Optional<Rol> findByName(String name);

}
