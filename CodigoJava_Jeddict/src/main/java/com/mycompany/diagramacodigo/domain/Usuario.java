package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String correo;
    @Basic
    private String clave;
    @ManyToOne
    private Rol rol;
    @OneToMany
    private List<Plantacion> plantacions;

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Plantacion> getPlantacions() {
        if (plantacions == null) {
            plantacions = new ArrayList<>();
        }
        return plantacions;
    }

    public void setPlantacions(List<Plantacion> plantacions) {
        this.plantacions = plantacions;
    }

    public void addPlantacion(Plantacion plantacion) {
        getPlantacions().add(plantacion);
    }

    public void removePlantacion(Plantacion plantacion) {
        getPlantacions().remove(plantacion);
    }

}