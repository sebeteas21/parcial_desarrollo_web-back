package com.gestionacademica.service;

import com.gestionacademica.model.Facultad;
import java.util.List;

public interface FacultadService {

    Facultad crearFacultad(Facultad facultad);

    List<Facultad> obtenerTodasLasFacultades();

    Facultad obtenerFacultadPorId(Long id);

    Facultad actualizarFacultad(Long id, Facultad facultad);

    void eliminarFacultad(Long id);
}
