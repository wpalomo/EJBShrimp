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
public class PrdSectorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;

    public PrdSectorPK() {
    }

    public PrdSectorPK(String secEmpresa, String secCodigo) {
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secEmpresa != null ? secEmpresa.hashCode() : 0);
        hash += (secCodigo != null ? secCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdSectorPK)) {
            return false;
        }
        PrdSectorPK other = (PrdSectorPK) object;
        if ((this.secEmpresa == null && other.secEmpresa != null) || (this.secEmpresa != null && !this.secEmpresa.equals(other.secEmpresa))) {
            return false;
        }
        if ((this.secCodigo == null && other.secCodigo != null) || (this.secCodigo != null && !this.secCodigo.equals(other.secCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdSectorPK[ secEmpresa=" + secEmpresa + ", secCodigo=" + secCodigo + " ]";
    }
    
}
