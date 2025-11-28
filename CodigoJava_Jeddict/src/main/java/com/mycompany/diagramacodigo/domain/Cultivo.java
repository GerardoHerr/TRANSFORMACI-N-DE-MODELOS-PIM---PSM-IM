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
public class Cultivo {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String nombreCultivo;
    @Basic
    private String tipoCultivo;
    @Basic
    private String familia;
    @Basic
    private String semilla;
    @OneToMany
    private List<ConfiguacionUmbral> configuacionUmbrals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCultivo() {
        return nombreCultivo;
    }

    public void setNombreCultivo(String nombreCultivo) {
        this.nombreCultivo = nombreCultivo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public List<ConfiguacionUmbral> getConfiguacionUmbrals() {
        if (configuacionUmbrals == null) {
            configuacionUmbrals = new ArrayList<>();
        }
        return configuacionUmbrals;
    }

    public void setConfiguacionUmbrals(List<ConfiguacionUmbral> configuacionUmbrals) {
        this.configuacionUmbrals = configuacionUmbrals;
    }

    public void addConfiguacionUmbral(ConfiguacionUmbral configuacionUmbral) {
        getConfiguacionUmbrals().add(configuacionUmbral);
    }

    public void removeConfiguacionUmbral(ConfiguacionUmbral configuacionUmbral) {
        getConfiguacionUmbrals().remove(configuacionUmbral);
    }

}