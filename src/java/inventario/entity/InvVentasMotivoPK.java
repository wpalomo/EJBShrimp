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
public class InvVentasMotivoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "vm_empresa")
    private String vmEmpresa;
    @Basic(optional = false)
    @Column(name = "vm_codigo")
    private String vmCodigo;

    public InvVentasMotivoPK() {
    }

    public InvVentasMotivoPK(String vmEmpresa, String vmCodigo) {
        this.vmEmpresa = vmEmpresa;
        this.vmCodigo = vmCodigo;
    }

    public String getVmEmpresa() {
        return vmEmpresa;
    }

    public void setVmEmpresa(String vmEmpresa) {
        this.vmEmpresa = vmEmpresa;
    }

    public String getVmCodigo() {
        return vmCodigo;
    }

    public void setVmCodigo(String vmCodigo) {
        this.vmCodigo = vmCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vmEmpresa != null ? vmEmpresa.hashCode() : 0);
        hash += (vmCodigo != null ? vmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasMotivoPK)) {
            return false;
        }
        InvVentasMotivoPK other = (InvVentasMotivoPK) object;
        if ((this.vmEmpresa == null && other.vmEmpresa != null) || (this.vmEmpresa != null && !this.vmEmpresa.equals(other.vmEmpresa))) {
            return false;
        }
        if ((this.vmCodigo == null && other.vmCodigo != null) || (this.vmCodigo != null && !this.vmCodigo.equals(other.vmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasMotivoPK[ vmEmpresa=" + vmEmpresa + ", vmCodigo=" + vmCodigo + " ]";
    }
    
}
