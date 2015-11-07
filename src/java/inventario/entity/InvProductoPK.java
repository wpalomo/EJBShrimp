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
public class InvProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pro_empresa")
    private String proEmpresa;
    @Basic(optional = false)
    @Column(name = "pro_codigo_principal")
    private String proCodigoPrincipal;

    public InvProductoPK() {
    }

    public InvProductoPK(String proEmpresa, String proCodigoPrincipal) {
        this.proEmpresa = proEmpresa;
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public String getProEmpresa() {
        return proEmpresa;
    }

    public void setProEmpresa(String proEmpresa) {
        this.proEmpresa = proEmpresa;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proEmpresa != null ? proEmpresa.hashCode() : 0);
        hash += (proCodigoPrincipal != null ? proCodigoPrincipal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoPK)) {
            return false;
        }
        InvProductoPK other = (InvProductoPK) object;
        if ((this.proEmpresa == null && other.proEmpresa != null) || (this.proEmpresa != null && !this.proEmpresa.equals(other.proEmpresa))) {
            return false;
        }
        if ((this.proCodigoPrincipal == null && other.proCodigoPrincipal != null) || (this.proCodigoPrincipal != null && !this.proCodigoPrincipal.equals(other.proCodigoPrincipal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoPK[ proEmpresa=" + proEmpresa + ", proCodigoPrincipal=" + proCodigoPrincipal + " ]";
    }
    
}
