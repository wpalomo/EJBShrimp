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
public class InvProductoPresentacionUnidadesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "presu_empresa")
    private String presuEmpresa;
    @Basic(optional = false)
    @Column(name = "presu_codigo")
    private String presuCodigo;

    public InvProductoPresentacionUnidadesPK() {
    }

    public InvProductoPresentacionUnidadesPK(String presuEmpresa, String presuCodigo) {
        this.presuEmpresa = presuEmpresa;
        this.presuCodigo = presuCodigo;
    }

    public String getPresuEmpresa() {
        return presuEmpresa;
    }

    public void setPresuEmpresa(String presuEmpresa) {
        this.presuEmpresa = presuEmpresa;
    }

    public String getPresuCodigo() {
        return presuCodigo;
    }

    public void setPresuCodigo(String presuCodigo) {
        this.presuCodigo = presuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presuEmpresa != null ? presuEmpresa.hashCode() : 0);
        hash += (presuCodigo != null ? presuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoPresentacionUnidadesPK)) {
            return false;
        }
        InvProductoPresentacionUnidadesPK other = (InvProductoPresentacionUnidadesPK) object;
        if ((this.presuEmpresa == null && other.presuEmpresa != null) || (this.presuEmpresa != null && !this.presuEmpresa.equals(other.presuEmpresa))) {
            return false;
        }
        if ((this.presuCodigo == null && other.presuCodigo != null) || (this.presuCodigo != null && !this.presuCodigo.equals(other.presuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoPresentacionUnidadesPK[ presuEmpresa=" + presuEmpresa + ", presuCodigo=" + presuCodigo + " ]";
    }
    
}
