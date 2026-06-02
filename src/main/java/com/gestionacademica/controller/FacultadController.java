package com.gestionacademica.controller;

import com.gestionacademica.model.Facultad;
import com.gestionacademica.service.FacultadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facultades")
@CrossOrigin
public class FacultadController {

    private final FacultadService facultadService;

    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @PostMapping
    public ResponseEntity<Facultad> crearFacultad(@Valid @RequestBody Facultad facultad) {
        Facultad creada = facultadService.crearFacultad(facultad);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Facultad>> listarFacultades() {
        return ResponseEntity.ok(facultadService.obtenerTodasLasFacultades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> obtenerFacultadPorId(@PathVariable Long id) {
        return ResponseEntity.ok(facultadService.obtenerFacultadPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> actualizarFacultad(@PathVariable Long id, @Valid @RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.actualizarFacultad(id, facultad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFacultad(@PathVariable Long id) {
        facultadService.eliminarFacultad(id);
        return ResponseEntity.noContent().build();
    }
}
