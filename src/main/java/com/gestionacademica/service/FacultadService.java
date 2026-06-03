package com.gestionacademica.service;

import com.gestionacademica.model.Facultad;
import java.util.List;
import org.springframework.lang.NonNull;

public interface FacultadService {

    @NonNull Facultad crearFacultad(@NonNull Facultad facultad);

    List<Facultad> obtenerTodasLasFacultades();

    @NonNull Facultad obtenerFacultadPorId(@NonNull Long id);

    @NonNull Facultad actualizarFacultad(@NonNull Long id, @NonNull Facultad facultad);

    void eliminarFacultad(@NonNull Long id);
}
