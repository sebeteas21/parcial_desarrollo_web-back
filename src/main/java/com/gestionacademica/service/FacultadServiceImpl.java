package com.gestionacademica.service;

import com.gestionacademica.model.Facultad;
import com.gestionacademica.repository.FacultadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FacultadServiceImpl implements FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadServiceImpl(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    public Facultad crearFacultad(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    public List<Facultad> obtenerTodasLasFacultades() {
        return facultadRepository.findAll();
    }

    @Override
    public Facultad obtenerFacultadPorId(Long id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Facultad no encontrada con id: " + id));
    }

    @Override
    public Facultad actualizarFacultad(Long id, Facultad facultad) {
        return facultadRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(facultad.getNombre());
                    existing.setDecano(facultad.getDecano());
                    existing.setUbicacion(facultad.getUbicacion());
                    existing.setProgramas(facultad.getProgramas());
                    return facultadRepository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Facultad no encontrada con id: " + id));
    }

    @Override
    public void eliminarFacultad(Long id) {
        Facultad facultad = obtenerFacultadPorId(id);
        facultadRepository.delete(facultad);
    }
}
