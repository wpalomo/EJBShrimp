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
public class InvVendedorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "vend_empresa")
    private String vendEmpresa;
    @Basic(optional = false)
    @Column(name = "vend_codigo")
    private String vendCodigo;

    public InvVendedorPK() {
    }

    public InvVendedorPK(String vendEmpresa, String vendCodigo) {
        this.vendEmpresa = vendEmpresa;
        this.vendCodigo = vendCodigo;
    }

    public String getVendEmpresa() {
        return vendEmpresa;
    }

    public void setVendEmpresa(String vendEmpresa) {
        this.vendEmpresa = vendEmpresa;
    }

    public String getVendCodigo() {
        return vendCodigo;
    }

    public void setVendCodigo(String vendCodigo) {
        this.vendCodigo = vendCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendEmpresa != null ? vendEmpresa.hashCode() : 0);
        hash += (vendCodigo != null ? vendCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVendedorPK)) {
            return false;
        }
        InvVendedorPK other = (InvVendedorPK) object;
        if ((this.vendEmpresa == null && other.vendEmpresa != null) || (this.vendEmpresa != null && !this.vendEmpresa.equals(other.vendEmpresa))) {
            return false;
        }
        if ((this.vendCodigo == null && other.vendCodigo != null) || (this.vendCodigo != null && !this.vendCodigo.equals(other.vendCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVendedorPK[ vendEmpresa=" + vendEmpresa + ", vendCodigo=" + vendCodigo + " ]";
    }
    
}
