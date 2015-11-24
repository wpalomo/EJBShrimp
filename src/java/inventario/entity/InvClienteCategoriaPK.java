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
public class InvClienteCategoriaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cc_empresa")
    private String ccEmpresa;
    @Basic(optional = false)
    @Column(name = "cc_codigo")
    private String ccCodigo;

    public InvClienteCategoriaPK() {
    }

    public InvClienteCategoriaPK(String ccEmpresa, String ccCodigo) {
        this.ccEmpresa = ccEmpresa;
        this.ccCodigo = ccCodigo;
    }

    public String getCcEmpresa() {
        return ccEmpresa;
    }

    public void setCcEmpresa(String ccEmpresa) {
        this.ccEmpresa = ccEmpresa;
    }

    public String getCcCodigo() {
        return ccCodigo;
    }

    public void setCcCodigo(String ccCodigo) {
        this.ccCodigo = ccCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccEmpresa != null ? ccEmpresa.hashCode() : 0);
        hash += (ccCodigo != null ? ccCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvClienteCategoriaPK)) {
            return false;
        }
        InvClienteCategoriaPK other = (InvClienteCategoriaPK) object;
        if ((this.ccEmpresa == null && other.ccEmpresa != null) || (this.ccEmpresa != null && !this.ccEmpresa.equals(other.ccEmpresa))) {
            return false;
        }
        if ((this.ccCodigo == null && other.ccCodigo != null) || (this.ccCodigo != null && !this.ccCodigo.equals(other.ccCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvClienteCategoriaPK[ ccEmpresa=" + ccEmpresa + ", ccCodigo=" + ccCodigo + " ]";
    }
    
}
