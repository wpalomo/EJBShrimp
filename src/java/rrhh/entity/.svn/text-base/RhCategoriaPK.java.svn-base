/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class RhCategoriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cat_empresa")
    private String catEmpresa;
    @Basic(optional = false)
    @Column(name = "cat_nombre")
    private String catNombre;

    public RhCategoriaPK() {
    }

    public RhCategoriaPK(String catEmpresa, String catNombre) {
        this.catEmpresa = catEmpresa;
        this.catNombre = catNombre;
    }

    public String getCatEmpresa() {
        return catEmpresa;
    }

    public void setCatEmpresa(String catEmpresa) {
        this.catEmpresa = catEmpresa;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catEmpresa != null ? catEmpresa.hashCode() : 0);
        hash += (catNombre != null ? catNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhCategoriaPK)) {
            return false;
        }
        RhCategoriaPK other = (RhCategoriaPK) object;
        if ((this.catEmpresa == null && other.catEmpresa != null) || (this.catEmpresa != null && !this.catEmpresa.equals(other.catEmpresa))) {
            return false;
        }
        if ((this.catNombre == null && other.catNombre != null) || (this.catNombre != null && !this.catNombre.equals(other.catNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhCategoriaPK[ catEmpresa=" + catEmpresa + ", catNombre=" + catNombre + " ]";
    }
}
