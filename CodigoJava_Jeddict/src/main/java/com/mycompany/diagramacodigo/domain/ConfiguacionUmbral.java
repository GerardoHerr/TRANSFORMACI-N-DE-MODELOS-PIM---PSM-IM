package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author LENOVO
 */
@Entity
public class ConfiguacionUmbral {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String valorMinimo;
    @Basic
    private String valorMaximo;
    @Basic
    private String fechaConfiguracion;
    @ManyToOne
    private VariableAmbiental variableAmbiental;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getFechaConfiguracion() {
        return fechaConfiguracion;
    }

    public void setFechaConfiguracion(String fechaConfiguracion) {
        this.fechaConfiguracion = fechaConfiguracion;
    }

    public VariableAmbiental getVariableAmbiental() {
        return variableAmbiental;
    }

    public void setVariableAmbiental(VariableAmbiental variableAmbiental) {
        this.variableAmbiental = variableAmbiental;
    }

}