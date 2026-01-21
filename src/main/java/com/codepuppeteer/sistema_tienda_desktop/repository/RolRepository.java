package com.codepuppeteer.sistema_tienda_desktop.repository;

import com.codepuppeteer.sistema_tienda_desktop.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreRol(String nombreRol);

    List<Rol> findByActivoTrue();

    boolean existsByNombreRol(String nombreRol);

    boolean existsByNombreRolAndIdNot(String nombreRol, Integer id);

    @Query("SELECT r FROM Rol r WHERE LOWER(r.nombreRol) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Rol> searchByNombre(@Param("search") String search);
}