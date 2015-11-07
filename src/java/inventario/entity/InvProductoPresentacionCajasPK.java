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
public class InvProductoPresentacionCajasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "presc_empresa")
    private String prescEmpresa;
    @Basic(optional = false)
    @Column(name = "presc_codigo")
    private String prescCodigo;

    public InvProductoPresentacionCajasPK() {
    }

    public InvProductoPresentacionCajasPK(String prescEmpresa, String prescCodigo) {
        this.prescEmpresa = prescEmpresa;
        this.prescCodigo = prescCodigo;
    }

    public String getPrescEmpresa() {
        return prescEmpresa;
    }

    public void setPrescEmpresa(String prescEmpresa) {
        this.prescEmpresa = prescEmpresa;
    }

    public String getPrescCodigo() {
        return prescCodigo;
    }

    public void setPrescCodigo(String prescCodigo) {
        this.prescCodigo = prescCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescEmpresa != null ? prescEmpresa.hashCode() : 0);
        hash += (prescCodigo != null ? prescCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoPresentacionCajasPK)) {
            return false;
        }
        InvProductoPresentacionCajasPK other = (InvProductoPresentacionCajasPK) object;
        if ((this.prescEmpresa == null && other.prescEmpresa != null) || (this.prescEmpresa != null && !this.prescEmpresa.equals(other.prescEmpresa))) {
            return false;
        }
        if ((this.prescCodigo == null && other.prescCodigo != null) || (this.prescCodigo != null && !this.prescCodigo.equals(other.prescCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoPresentacionCajasPK[ prescEmpresa=" + prescEmpresa + ", prescCodigo=" + prescCodigo + " ]";
    }
    
}
