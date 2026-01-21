package com.codepuppeteer.sistema_tienda_desktop.controller;

import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolRequest;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolResponse;
import com.codepuppeteer.sistema_tienda_desktop.dto.rol.RolSimpleResponse;
import com.codepuppeteer.sistema_tienda_desktop.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RolController {

    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolResponse>> getAllRoles() {
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<RolSimpleResponse>> getRolesActivos() {
        return ResponseEntity.ok(rolService.findAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> getRolById(@PathVariable Integer id) {
        return ResponseEntity.ok(rolService.findById(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<RolResponse> getRolByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(rolService.findByNombre(nombre));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<RolResponse>> searchRoles(@RequestParam String query) {
        return ResponseEntity.ok(rolService.searchByNombre(query));
    }

    @PostMapping
    public ResponseEntity<RolResponse> createRol(@Valid @RequestBody RolRequest rolRequest) {
        RolResponse createdRol = rolService.create(rolRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponse> updateRol(
            @PathVariable Integer id,
            @Valid @RequestBody RolRequest rolRequest) {
        return ResponseEntity.ok(rolService.update(id, rolRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/toggle-activo")
    public ResponseEntity<Void> toggleActivo(@PathVariable Integer id) {
        rolService.toggleActivo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/existe/{nombre}")
    public ResponseEntity<Boolean> existeRol(@PathVariable String nombre) {
        return ResponseEntity.ok(rolService.existsByNombre(nombre));
    }
}