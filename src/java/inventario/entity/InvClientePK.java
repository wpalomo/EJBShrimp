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
public class InvClientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cli_empresa")
    private String cliEmpresa;
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private String cliCodigo;

    public InvClientePK() {
    }

    public InvClientePK(String cliEmpresa, String cliCodigo) {
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliEmpresa != null ? cliEmpresa.hashCode() : 0);
        hash += (cliCodigo != null ? cliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvClientePK)) {
            return false;
        }
        InvClientePK other = (InvClientePK) object;
        if ((this.cliEmpresa == null && other.cliEmpresa != null) || (this.cliEmpresa != null && !this.cliEmpresa.equals(other.cliEmpresa))) {
            return false;
        }
        if ((this.cliCodigo == null && other.cliCodigo != null) || (this.cliCodigo != null && !this.cliCodigo.equals(other.cliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvClientePK[ cliEmpresa=" + cliEmpresa + ", cliCodigo=" + cliCodigo + " ]";
    }
    
}
