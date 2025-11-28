package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author LENOVO
 */
@Entity
public class ConfiguracionTomaDecision {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String tipoConfiguracion;
    @Basic
    private String criterioDecision;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoConfiguracion() {
        return tipoConfiguracion;
    }

    public void setTipoConfiguracion(String tipoConfiguracion) {
        this.tipoConfiguracion = tipoConfiguracion;
    }

    public String getCriterioDecision() {
        return criterioDecision;
    }

    public void setCriterioDecision(String criterioDecision) {
        this.criterioDecision = criterioDecision;
    }

}