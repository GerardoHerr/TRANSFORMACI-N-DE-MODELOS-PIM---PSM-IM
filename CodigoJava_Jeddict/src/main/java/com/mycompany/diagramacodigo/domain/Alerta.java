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
public class Alerta {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String tipoAlerta;
    @Basic
    private String descripcion;
    @Basic
    private String fechaGeneracion;
    @Basic
    private String estado;
    @OneToOne
    private Accion accion;
    @OneToOne
    private Recomenacion recomenacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public Recomenacion getRecomenacion() {
        return recomenacion;
    }

    public void setRecomenacion(Recomenacion recomenacion) {
        this.recomenacion = recomenacion;
    }

}