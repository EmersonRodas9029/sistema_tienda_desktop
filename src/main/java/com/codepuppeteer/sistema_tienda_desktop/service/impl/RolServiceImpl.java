package com.codepuppeteer.sistema_tienda_desktop.service.impl;

import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolRequest;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolResponse;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolSimpleResponse;
import com.codepuppeteer.sistema_tienda_desktop.entity.Rol;
import com.codepuppeteer.sistema_tienda_desktop.exception.ResourceNotFoundException;
import com.codepuppeteer.sistema_tienda_desktop.exception.DuplicateResourceException;
import com.codepuppeteer.sistema_tienda_desktop.repository.RolRepository;
import com.codepuppeteer.sistema_tienda_desktop.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public List<RolResponse> findAll() {
        return rolRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<RolSimpleResponse> findAllActive() {
        return rolRepository.findByActivoTrue()
                .stream()
                .map(this::mapToSimpleResponse)
                .toList();
    }

    @Override
    public RolResponse findById(Integer id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + id));
        return mapToResponse(rol);
    }

    @Override
    public RolResponse findByNombre(String nombreRol) {
        Rol rol = rolRepository.findByNombreRol(nombreRol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado: " + nombreRol));
        return mapToResponse(rol);
    }

    @Override
    public RolResponse create(RolRequest rolRequest) {
        if (rolRepository.existsByNombreRol(rolRequest.nombreRol())) {
            throw new DuplicateResourceException("Ya existe un rol con el nombre: " + rolRequest.nombreRol());
        }

        Rol rol = new Rol();
        rol.setNombreRol(rolRequest.nombreRol());
        rol.setDescripcion(rolRequest.descripcion());
        rol.setActivo(rolRequest.activo() != null ? rolRequest.activo() : true);

        Rol savedRol = rolRepository.save(rol);
        return mapToResponse(savedRol);
    }

    @Override
    public RolResponse update(Integer id, RolRequest rolRequest) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + id));

        if (rolRepository.existsByNombreRolAndIdNot(rolRequest.nombreRol(), id)) {
            throw new DuplicateResourceException("Ya existe otro rol con el nombre: " + rolRequest.nombreRol());
        }

        rol.setNombreRol(rolRequest.nombreRol());
        rol.setDescripcion(rolRequest.descripcion());
        if (rolRequest.activo() != null) {
            rol.setActivo(rolRequest.activo());
        }

        Rol updatedRol = rolRepository.save(rol);
        return mapToResponse(updatedRol);
    }

    @Override
    public void delete(Integer id) {
        if (!rolRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rol no encontrado con ID: " + id);
        }
        rolRepository.deleteById(id);
    }

    @Override
    public void toggleActivo(Integer id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + id));

        rol.setActivo(!rol.getActivo());
        rolRepository.save(rol);
    }

    @Override
    public List<RolResponse> searchByNombre(String search) {
        return rolRepository.searchByNombre(search)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public boolean existsByNombre(String nombreRol) {
        return rolRepository.existsByNombreRol(nombreRol);
    }

    private RolResponse mapToResponse(Rol rol) {
        return new RolResponse(
                rol.getId(),
                rol.getNombreRol(),
                rol.getDescripcion(),
                rol.getActivo(),
                rol.getFechaCreacion(),
                rol.getFechaActualizacion()
        );
    }

    private RolSimpleResponse mapToSimpleResponse(Rol rol) {
        return new RolSimpleResponse(
                rol.getId(),
                rol.getNombreRol(),
                rol.getDescripcion()
        );
    }
}