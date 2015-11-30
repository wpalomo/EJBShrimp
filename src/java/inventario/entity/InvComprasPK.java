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
public class InvComprasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "comp_empresa")
    private String compEmpresa;
    @Basic(optional = false)
    @Column(name = "comp_periodo")
    private String compPeriodo;
    @Basic(optional = false)
    @Column(name = "comp_motivo")
    private String compMotivo;
    @Basic(optional = false)
    @Column(name = "comp_numero")
    private String compNumero;

    public InvComprasPK() {
    }

    public InvComprasPK(String compEmpresa, String compPeriodo, String compMotivo, String compNumero) {
        this.compEmpresa = compEmpresa;
        this.compPeriodo = compPeriodo;
        this.compMotivo = compMotivo;
        this.compNumero = compNumero;
    }

    public String getCompEmpresa() {
        return compEmpresa;
    }

    public void setCompEmpresa(String compEmpresa) {
        this.compEmpresa = compEmpresa;
    }

    public String getCompPeriodo() {
        return compPeriodo;
    }

    public void setCompPeriodo(String compPeriodo) {
        this.compPeriodo = compPeriodo;
    }

    public String getCompMotivo() {
        return compMotivo;
    }

    public void setCompMotivo(String compMotivo) {
        this.compMotivo = compMotivo;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compEmpresa != null ? compEmpresa.hashCode() : 0);
        hash += (compPeriodo != null ? compPeriodo.hashCode() : 0);
        hash += (compMotivo != null ? compMotivo.hashCode() : 0);
        hash += (compNumero != null ? compNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasPK)) {
            return false;
        }
        InvComprasPK other = (InvComprasPK) object;
        if ((this.compEmpresa == null && other.compEmpresa != null) || (this.compEmpresa != null && !this.compEmpresa.equals(other.compEmpresa))) {
            return false;
        }
        if ((this.compPeriodo == null && other.compPeriodo != null) || (this.compPeriodo != null && !this.compPeriodo.equals(other.compPeriodo))) {
            return false;
        }
        if ((this.compMotivo == null && other.compMotivo != null) || (this.compMotivo != null && !this.compMotivo.equals(other.compMotivo))) {
            return false;
        }
        if ((this.compNumero == null && other.compNumero != null) || (this.compNumero != null && !this.compNumero.equals(other.compNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasPK[ compEmpresa=" + compEmpresa + ", compPeriodo=" + compPeriodo + ", compMotivo=" + compMotivo + ", compNumero=" + compNumero + " ]";
    }
    
}
