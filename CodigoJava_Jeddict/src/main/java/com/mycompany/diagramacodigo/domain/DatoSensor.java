package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * @author LENOVO
 */
@Entity
public class DatoSensor {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String valor;
    @Basic
    private String fechaRegistro;
    @Basic
    private String hoiraRegistro;
    @OneToOne
    private VariableAmbiental variableAmbiental;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getHoiraRegistro() {
        return hoiraRegistro;
    }

    public void setHoiraRegistro(String hoiraRegistro) {
        this.hoiraRegistro = hoiraRegistro;
    }

    public VariableAmbiental getVariableAmbiental() {
        return variableAmbiental;
    }

    public void setVariableAmbiental(VariableAmbiental variableAmbiental) {
        this.variableAmbiental = variableAmbiental;
    }

}