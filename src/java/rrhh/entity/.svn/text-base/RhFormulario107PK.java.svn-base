/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class RhFormulario107PK implements Serializable {

    @Basic(optional = false)
    @Column(name = "f107_empresa")
    private String f107Empresa;
    @Basic(optional = false)
    @Column(name = "f107_anio")
    private String f107Anio;
    @Basic(optional = false)
    @Column(name = "f107_id")
    private String f107Id;

    public RhFormulario107PK() {
    }

    public RhFormulario107PK(String f107Empresa, String f107Anio, String f107Id) {
        this.f107Empresa = f107Empresa;
        this.f107Anio = f107Anio;
        this.f107Id = f107Id;
    }

    public String getF107Empresa() {
        return f107Empresa;
    }

    public void setF107Empresa(String f107Empresa) {
        this.f107Empresa = f107Empresa;
    }

    public String getF107Anio() {
        return f107Anio;
    }

    public void setF107Anio(String f107Anio) {
        this.f107Anio = f107Anio;
    }

    public String getF107Id() {
        return f107Id;
    }

    public void setF107Id(String f107Id) {
        this.f107Id = f107Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (f107Empresa != null ? f107Empresa.hashCode() : 0);
        hash += (f107Anio != null ? f107Anio.hashCode() : 0);
        hash += (f107Id != null ? f107Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFormulario107PK)) {
            return false;
        }
        RhFormulario107PK other = (RhFormulario107PK) object;
        if ((this.f107Empresa == null && other.f107Empresa != null) || (this.f107Empresa != null && !this.f107Empresa.equals(other.f107Empresa))) {
            return false;
        }
        if ((this.f107Anio == null && other.f107Anio != null) || (this.f107Anio != null && !this.f107Anio.equals(other.f107Anio))) {
            return false;
        }
        if ((this.f107Id == null && other.f107Id != null) || (this.f107Id != null && !this.f107Id.equals(other.f107Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhFormulario107PK[ f107Empresa=" + f107Empresa + ", f107Anio=" + f107Anio + ", f107Id=" + f107Id + " ]";
    }
}
