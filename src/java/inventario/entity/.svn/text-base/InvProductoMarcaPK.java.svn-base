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
public class InvProductoMarcaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "mar_empresa")
    private String marEmpresa;
    @Basic(optional = false)
    @Column(name = "mar_codigo")
    private String marCodigo;

    public InvProductoMarcaPK() {
    }

    public InvProductoMarcaPK(String marEmpresa, String marCodigo) {
        this.marEmpresa = marEmpresa;
        this.marCodigo = marCodigo;
    }

    public String getMarEmpresa() {
        return marEmpresa;
    }

    public void setMarEmpresa(String marEmpresa) {
        this.marEmpresa = marEmpresa;
    }

    public String getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(String marCodigo) {
        this.marCodigo = marCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marEmpresa != null ? marEmpresa.hashCode() : 0);
        hash += (marCodigo != null ? marCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoMarcaPK)) {
            return false;
        }
        InvProductoMarcaPK other = (InvProductoMarcaPK) object;
        if ((this.marEmpresa == null && other.marEmpresa != null) || (this.marEmpresa != null && !this.marEmpresa.equals(other.marEmpresa))) {
            return false;
        }
        if ((this.marCodigo == null && other.marCodigo != null) || (this.marCodigo != null && !this.marCodigo.equals(other.marCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoMarcaPK[ marEmpresa=" + marEmpresa + ", marCodigo=" + marCodigo + " ]";
    }
    
}
