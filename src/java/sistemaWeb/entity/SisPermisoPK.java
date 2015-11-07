/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class SisPermisoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "per_empresa")
    private String perEmpresa;
    @Basic(optional = false)
    @Column(name = "per_modulo")
    private String perModulo;
    @Basic(optional = false)
    @Column(name = "per_menu")
    private String perMenu;
    @Basic(optional = false)
    @Column(name = "per_item")
    private String perItem;

    public SisPermisoPK() {
    }

    public SisPermisoPK(String perEmpresa, String perModulo, String perMenu, String perItem) {
        this.perEmpresa = perEmpresa;
        this.perModulo = perModulo;
        this.perMenu = perMenu;
        this.perItem = perItem;
    }

    public String getPerEmpresa() {
        return perEmpresa;
    }

    public void setPerEmpresa(String perEmpresa) {
        this.perEmpresa = perEmpresa;
    }

    public String getPerModulo() {
        return perModulo;
    }

    public void setPerModulo(String perModulo) {
        this.perModulo = perModulo;
    }

    public String getPerMenu() {
        return perMenu;
    }

    public void setPerMenu(String perMenu) {
        this.perMenu = perMenu;
    }

    public String getPerItem() {
        return perItem;
    }

    public void setPerItem(String perItem) {
        this.perItem = perItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perEmpresa != null ? perEmpresa.hashCode() : 0);
        hash += (perModulo != null ? perModulo.hashCode() : 0);
        hash += (perMenu != null ? perMenu.hashCode() : 0);
        hash += (perItem != null ? perItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPermisoPK)) {
            return false;
        }
        SisPermisoPK other = (SisPermisoPK) object;
        if ((this.perEmpresa == null && other.perEmpresa != null) || (this.perEmpresa != null && !this.perEmpresa.equals(other.perEmpresa))) {
            return false;
        }
        if ((this.perModulo == null && other.perModulo != null) || (this.perModulo != null && !this.perModulo.equals(other.perModulo))) {
            return false;
        }
        if ((this.perMenu == null && other.perMenu != null) || (this.perMenu != null && !this.perMenu.equals(other.perMenu))) {
            return false;
        }
        if ((this.perItem == null && other.perItem != null) || (this.perItem != null && !this.perItem.equals(other.perItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisPermisoPK[ perEmpresa=" + perEmpresa + ", perModulo=" + perModulo + ", perMenu=" + perMenu + ", perItem=" + perItem + " ]";
    }
    
}
