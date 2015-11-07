/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class SisPeriodoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "per_empresa")
    private String perEmpresa;
    @Basic(optional = false)
    @Column(name = "per_codigo")
    private String perCodigo;

    public SisPeriodoPK() {
    }

    public SisPeriodoPK(String perEmpresa, String perCodigo) {
        this.perEmpresa = perEmpresa;
        this.perCodigo = perCodigo;
    }

    public String getPerEmpresa() {
        return perEmpresa;
    }

    public void setPerEmpresa(String perEmpresa) {
        this.perEmpresa = perEmpresa;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perEmpresa != null ? perEmpresa.hashCode() : 0);
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPeriodoPK)) {
            return false;
        }
        SisPeriodoPK other = (SisPeriodoPK) object;
        if ((this.perEmpresa == null && other.perEmpresa != null) || (this.perEmpresa != null && !this.perEmpresa.equals(other.perEmpresa))) {
            return false;
        }
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisPeriodoPK[ perEmpresa=" + perEmpresa + ", perCodigo=" + perCodigo + " ]";
    }
    
}
