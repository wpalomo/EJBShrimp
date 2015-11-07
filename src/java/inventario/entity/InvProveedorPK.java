/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class InvProveedorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prov_empresa")
    private String provEmpresa;
    @Basic(optional = false)
    @Column(name = "prov_codigo")
    private String provCodigo;

    public InvProveedorPK() {
    }

    public InvProveedorPK(String provEmpresa, String provCodigo) {
        this.provEmpresa = provEmpresa;
        this.provCodigo = provCodigo;
    }

    public String getProvEmpresa() {
        return provEmpresa;
    }

    public void setProvEmpresa(String provEmpresa) {
        this.provEmpresa = provEmpresa;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provEmpresa != null ? provEmpresa.hashCode() : 0);
        hash += (provCodigo != null ? provCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProveedorPK)) {
            return false;
        }
        InvProveedorPK other = (InvProveedorPK) object;
        if ((this.provEmpresa == null && other.provEmpresa != null) || (this.provEmpresa != null && !this.provEmpresa.equals(other.provEmpresa))) {
            return false;
        }
        if ((this.provCodigo == null && other.provCodigo != null) || (this.provCodigo != null && !this.provCodigo.equals(other.provCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProveedorPK[ provEmpresa=" + provEmpresa + ", provCodigo=" + provCodigo + " ]";
    }
    
}
