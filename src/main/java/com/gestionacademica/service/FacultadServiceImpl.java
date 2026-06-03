package com.gestionacademica.service;

import com.gestionacademica.model.Facultad;
import com.gestionacademica.repository.FacultadRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class FacultadServiceImpl implements FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadServiceImpl(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    @Override
    public @NonNull Facultad crearFacultad(@NonNull Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    public List<Facultad> obtenerTodasLasFacultades() {
        return facultadRepository.findAll();
    }

    @Override
    public @NonNull Facultad obtenerFacultadPorId(@NonNull Long id) {
        return Objects.requireNonNull(facultadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Facultad no encontrada con id: " + id)));
    }

    @Override
    public @NonNull Facultad actualizarFacultad(@NonNull Long id, @NonNull Facultad facultad) {
        return Objects.requireNonNull(facultadRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(facultad.getNombre());
                    existing.setDecano(facultad.getDecano());
                    existing.setUbicacion(facultad.getUbicacion());
                    existing.setProgramas(facultad.getProgramas());
                    return facultadRepository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Facultad no encontrada con id: " + id)));
    }

    @Override
    public void eliminarFacultad(@NonNull Long id) {
        Facultad facultad = obtenerFacultadPorId(id);
        facultadRepository.delete(facultad);
    }
}
