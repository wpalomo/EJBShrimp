/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class ConTipoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tip_empresa")
    private String tipEmpresa;
    @Basic(optional = false)
    @Column(name = "tip_codigo")
    private String tipCodigo;

    public ConTipoPK() {
    }

    public ConTipoPK(String tipEmpresa, String tipCodigo) {
        this.tipEmpresa = tipEmpresa;
        this.tipCodigo = tipCodigo;
    }

    public String getTipEmpresa() {
        return tipEmpresa;
    }

    public void setTipEmpresa(String tipEmpresa) {
        this.tipEmpresa = tipEmpresa;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipEmpresa != null ? tipEmpresa.hashCode() : 0);
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConTipoPK)) {
            return false;
        }
        ConTipoPK other = (ConTipoPK) object;
        if ((this.tipEmpresa == null && other.tipEmpresa != null) || (this.tipEmpresa != null && !this.tipEmpresa.equals(other.tipEmpresa))) {
            return false;
        }
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConTipoPK[ tipEmpresa=" + tipEmpresa + ", tipCodigo=" + tipCodigo + " ]";
    }
    
}
