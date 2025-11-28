package com.mycompany.diagramacodigo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author LENOVO
 */
@Entity
public class Rol {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String tipo;
    @Basic
    private String isActivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(String isActivo) {
        this.isActivo = isActivo;
    }

}