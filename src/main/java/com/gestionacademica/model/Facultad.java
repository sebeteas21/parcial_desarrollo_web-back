package com.gestionacademica.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facultades")
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String decano;

    @NotBlank
    @Column(nullable = false)
    private String ubicacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaAcademico> programas = new ArrayList<>();

    public Facultad() {
    }

    public Facultad(String nombre, String decano, String ubicacion) {
        this.nombre = nombre;
        this.decano = decano;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ProgramaAcademico> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaAcademico> programas) {
        this.programas.clear();
        if (programas != null) {
            programas.forEach(this::addPrograma);
        }
    }

    public void addPrograma(ProgramaAcademico programa) {
        programa.setFacultad(this);
        this.programas.add(programa);
    }

    public void removePrograma(ProgramaAcademico programa) {
        this.programas.remove(programa);
        programa.setFacultad(null);
    }
}
