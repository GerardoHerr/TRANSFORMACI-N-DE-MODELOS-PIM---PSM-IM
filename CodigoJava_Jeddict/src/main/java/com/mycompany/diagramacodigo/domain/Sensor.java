package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 */
@Entity
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String tipoSensor;
    @Basic
    private String estado;
    @Basic
    private String ubicacion;
    @OneToMany
    private List<DatoSensor> datoSensors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<DatoSensor> getDatoSensors() {
        if (datoSensors == null) {
            datoSensors = new ArrayList<>();
        }
        return datoSensors;
    }

    public void setDatoSensors(List<DatoSensor> datoSensors) {
        this.datoSensors = datoSensors;
    }

    public void addDatoSensor(DatoSensor datoSensor) {
        getDatoSensors().add(datoSensor);
    }

    public void removeDatoSensor(DatoSensor datoSensor) {
        getDatoSensors().remove(datoSensor);
    }

}