package com.codepuppeteer.sistema_tienda_desktop.service;

import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolRequest;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolResponse;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolSimpleResponse;

import java.util.List;

public interface RolService {

    List<RolResponse> findAll();

    List<RolSimpleResponse> findAllActive();

    RolResponse findById(Integer id);

    RolResponse findByNombre(String nombreRol);

    RolResponse create(RolRequest rolRequest);

    RolResponse update(Integer id, RolRequest rolRequest);

    void delete(Integer id);

    void toggleActivo(Integer id);

    List<RolResponse> searchByNombre(String search);

    boolean existsByNombre(String nombreRol);
}