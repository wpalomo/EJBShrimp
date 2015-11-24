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
public class InvProductoCategoriaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cat_empresa")
    private String catEmpresa;
    @Basic(optional = false)
    @Column(name = "cat_codigo")
    private String catCodigo;

    public InvProductoCategoriaPK() {
    }

    public InvProductoCategoriaPK(String catEmpresa, String catCodigo) {
        this.catEmpresa = catEmpresa;
        this.catCodigo = catCodigo;
    }

    public String getCatEmpresa() {
        return catEmpresa;
    }

    public void setCatEmpresa(String catEmpresa) {
        this.catEmpresa = catEmpresa;
    }

    public String getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(String catCodigo) {
        this.catCodigo = catCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catEmpresa != null ? catEmpresa.hashCode() : 0);
        hash += (catCodigo != null ? catCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoCategoriaPK)) {
            return false;
        }
        InvProductoCategoriaPK other = (InvProductoCategoriaPK) object;
        if ((this.catEmpresa == null && other.catEmpresa != null) || (this.catEmpresa != null && !this.catEmpresa.equals(other.catEmpresa))) {
            return false;
        }
        if ((this.catCodigo == null && other.catCodigo != null) || (this.catCodigo != null && !this.catCodigo.equals(other.catCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoCategoriaPK[ catEmpresa=" + catEmpresa + ", catCodigo=" + catCodigo + " ]";
    }
    
}
