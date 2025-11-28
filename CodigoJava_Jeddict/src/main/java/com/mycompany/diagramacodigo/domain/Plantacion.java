package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 */
@Entity
public class Plantacion {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String fechaRegistro;
    @Basic
    private String espacio;
    @OneToOne
    private ConfiguracionTomaDecision configuracionTomaDecision;
    @ManyToOne
    private Cultivo cultivo;
    @OneToMany
    private List<Sensor> sensors;
    @OneToMany
    private List<Alerta> alertas;

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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public ConfiguracionTomaDecision getConfiguracionTomaDecision() {
        return configuracionTomaDecision;
    }

    public void setConfiguracionTomaDecision(ConfiguracionTomaDecision configuracionTomaDecision) {
        this.configuracionTomaDecision = configuracionTomaDecision;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    public List<Sensor> getSensors() {
        if (sensors == null) {
            sensors = new ArrayList<>();
        }
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(Sensor sensor) {
        getSensors().add(sensor);
    }

    public void removeSensor(Sensor sensor) {
        getSensors().remove(sensor);
    }

    public List<Alerta> getAlertas() {
        if (alertas == null) {
            alertas = new ArrayList<>();
        }
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public void addAlerta(Alerta alerta) {
        getAlertas().add(alerta);
    }

    public void removeAlerta(Alerta alerta) {
        getAlertas().remove(alerta);
    }

}