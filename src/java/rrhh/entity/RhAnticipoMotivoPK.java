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
public class RhAnticipoMotivoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "mot_empresa")
    private String motEmpresa;
    @Basic(optional = false)
    @Column(name = "mot_detalle")
    private String motDetalle;

    public RhAnticipoMotivoPK() {
    }

    public RhAnticipoMotivoPK(String motEmpresa, String motDetalle) {
        this.motEmpresa = motEmpresa;
        this.motDetalle = motDetalle;
    }

    public String getMotEmpresa() {
        return motEmpresa;
    }

    public void setMotEmpresa(String motEmpresa) {
        this.motEmpresa = motEmpresa;
    }

    public String getMotDetalle() {
        return motDetalle;
    }

    public void setMotDetalle(String motDetalle) {
        this.motDetalle = motDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motEmpresa != null ? motEmpresa.hashCode() : 0);
        hash += (motDetalle != null ? motDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhAnticipoMotivoPK)) {
            return false;
        }
        RhAnticipoMotivoPK other = (RhAnticipoMotivoPK) object;
        if ((this.motEmpresa == null && other.motEmpresa != null) || (this.motEmpresa != null && !this.motEmpresa.equals(other.motEmpresa))) {
            return false;
        }
        if ((this.motDetalle == null && other.motDetalle != null) || (this.motDetalle != null && !this.motDetalle.equals(other.motDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhAnticipoMotivoPK[ motEmpresa=" + motEmpresa + ", motDetalle=" + motDetalle + " ]";
    }
}
