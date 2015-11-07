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
public class InvComprasMotivoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cm_empresa")
    private String cmEmpresa;
    @Basic(optional = false)
    @Column(name = "cm_codigo")
    private String cmCodigo;

    public InvComprasMotivoPK() {
    }

    public InvComprasMotivoPK(String cmEmpresa, String cmCodigo) {
        this.cmEmpresa = cmEmpresa;
        this.cmCodigo = cmCodigo;
    }

    public String getCmEmpresa() {
        return cmEmpresa;
    }

    public void setCmEmpresa(String cmEmpresa) {
        this.cmEmpresa = cmEmpresa;
    }

    public String getCmCodigo() {
        return cmCodigo;
    }

    public void setCmCodigo(String cmCodigo) {
        this.cmCodigo = cmCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmEmpresa != null ? cmEmpresa.hashCode() : 0);
        hash += (cmCodigo != null ? cmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasMotivoPK)) {
            return false;
        }
        InvComprasMotivoPK other = (InvComprasMotivoPK) object;
        if ((this.cmEmpresa == null && other.cmEmpresa != null) || (this.cmEmpresa != null && !this.cmEmpresa.equals(other.cmEmpresa))) {
            return false;
        }
        if ((this.cmCodigo == null && other.cmCodigo != null) || (this.cmCodigo != null && !this.cmCodigo.equals(other.cmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasMotivoPK[ cmEmpresa=" + cmEmpresa + ", cmCodigo=" + cmCodigo + " ]";
    }
    
}
