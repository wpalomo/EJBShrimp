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
public class InvComprasRecepcionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "recep_empresa")
    private String recepEmpresa;
    @Basic(optional = false)
    @Column(name = "recep_periodo")
    private String recepPeriodo;
    @Basic(optional = false)
    @Column(name = "recep_motivo")
    private String recepMotivo;
    @Basic(optional = false)
    @Column(name = "recep_numero")
    private String recepNumero;

    public InvComprasRecepcionPK() {
    }

    public InvComprasRecepcionPK(String recepEmpresa, String recepPeriodo, String recepMotivo, String recepNumero) {
        this.recepEmpresa = recepEmpresa;
        this.recepPeriodo = recepPeriodo;
        this.recepMotivo = recepMotivo;
        this.recepNumero = recepNumero;
    }

    public String getRecepEmpresa() {
        return recepEmpresa;
    }

    public void setRecepEmpresa(String recepEmpresa) {
        this.recepEmpresa = recepEmpresa;
    }

    public String getRecepPeriodo() {
        return recepPeriodo;
    }

    public void setRecepPeriodo(String recepPeriodo) {
        this.recepPeriodo = recepPeriodo;
    }

    public String getRecepMotivo() {
        return recepMotivo;
    }

    public void setRecepMotivo(String recepMotivo) {
        this.recepMotivo = recepMotivo;
    }

    public String getRecepNumero() {
        return recepNumero;
    }

    public void setRecepNumero(String recepNumero) {
        this.recepNumero = recepNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recepEmpresa != null ? recepEmpresa.hashCode() : 0);
        hash += (recepPeriodo != null ? recepPeriodo.hashCode() : 0);
        hash += (recepMotivo != null ? recepMotivo.hashCode() : 0);
        hash += (recepNumero != null ? recepNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasRecepcionPK)) {
            return false;
        }
        InvComprasRecepcionPK other = (InvComprasRecepcionPK) object;
        if ((this.recepEmpresa == null && other.recepEmpresa != null) || (this.recepEmpresa != null && !this.recepEmpresa.equals(other.recepEmpresa))) {
            return false;
        }
        if ((this.recepPeriodo == null && other.recepPeriodo != null) || (this.recepPeriodo != null && !this.recepPeriodo.equals(other.recepPeriodo))) {
            return false;
        }
        if ((this.recepMotivo == null && other.recepMotivo != null) || (this.recepMotivo != null && !this.recepMotivo.equals(other.recepMotivo))) {
            return false;
        }
        if ((this.recepNumero == null && other.recepNumero != null) || (this.recepNumero != null && !this.recepNumero.equals(other.recepNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasRecepcionPK[ recepEmpresa=" + recepEmpresa + ", recepPeriodo=" + recepPeriodo + ", recepMotivo=" + recepMotivo + ", recepNumero=" + recepNumero + " ]";
    }
    
}
