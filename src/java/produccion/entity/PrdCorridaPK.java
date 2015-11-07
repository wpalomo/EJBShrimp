/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class PrdCorridaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cor_empresa")
    private String corEmpresa;
    @Basic(optional = false)
    @Column(name = "cor_sector")
    private String corSector;
    @Basic(optional = false)
    @Column(name = "cor_piscina")
    private String corPiscina;
    @Basic(optional = false)
    @Column(name = "cor_numero")
    private String corNumero;

    public PrdCorridaPK() {
    }

    public PrdCorridaPK(String corEmpresa, String corSector, String corPiscina, String corNumero) {
        this.corEmpresa = corEmpresa;
        this.corSector = corSector;
        this.corPiscina = corPiscina;
        this.corNumero = corNumero;
    }

    public String getCorEmpresa() {
        return corEmpresa;
    }

    public void setCorEmpresa(String corEmpresa) {
        this.corEmpresa = corEmpresa;
    }

    public String getCorSector() {
        return corSector;
    }

    public void setCorSector(String corSector) {
        this.corSector = corSector;
    }

    public String getCorPiscina() {
        return corPiscina;
    }

    public void setCorPiscina(String corPiscina) {
        this.corPiscina = corPiscina;
    }

    public String getCorNumero() {
        return corNumero;
    }

    public void setCorNumero(String corNumero) {
        this.corNumero = corNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corEmpresa != null ? corEmpresa.hashCode() : 0);
        hash += (corSector != null ? corSector.hashCode() : 0);
        hash += (corPiscina != null ? corPiscina.hashCode() : 0);
        hash += (corNumero != null ? corNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdCorridaPK)) {
            return false;
        }
        PrdCorridaPK other = (PrdCorridaPK) object;
        if ((this.corEmpresa == null && other.corEmpresa != null) || (this.corEmpresa != null && !this.corEmpresa.equals(other.corEmpresa))) {
            return false;
        }
        if ((this.corSector == null && other.corSector != null) || (this.corSector != null && !this.corSector.equals(other.corSector))) {
            return false;
        }
        if ((this.corPiscina == null && other.corPiscina != null) || (this.corPiscina != null && !this.corPiscina.equals(other.corPiscina))) {
            return false;
        }
        if ((this.corNumero == null && other.corNumero != null) || (this.corNumero != null && !this.corNumero.equals(other.corNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdCorridaPK[ corEmpresa=" + corEmpresa + ", corSector=" + corSector + ", corPiscina=" + corPiscina + ", corNumero=" + corNumero + " ]";
    }
    
}
