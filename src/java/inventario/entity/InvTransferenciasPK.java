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
public class InvTransferenciasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "trans_empresa")
    private String transEmpresa;
    @Basic(optional = false)
    @Column(name = "trans_periodo")
    private String transPeriodo;
    @Basic(optional = false)
    @Column(name = "trans_motivo")
    private String transMotivo;
    @Basic(optional = false)
    @Column(name = "trans_numero")
    private String transNumero;

    public InvTransferenciasPK() {
    }

    public InvTransferenciasPK(String transEmpresa, String transPeriodo, String transMotivo, String transNumero) {
        this.transEmpresa = transEmpresa;
        this.transPeriodo = transPeriodo;
        this.transMotivo = transMotivo;
        this.transNumero = transNumero;
    }

    public String getTransEmpresa() {
        return transEmpresa;
    }

    public void setTransEmpresa(String transEmpresa) {
        this.transEmpresa = transEmpresa;
    }

    public String getTransPeriodo() {
        return transPeriodo;
    }

    public void setTransPeriodo(String transPeriodo) {
        this.transPeriodo = transPeriodo;
    }

    public String getTransMotivo() {
        return transMotivo;
    }

    public void setTransMotivo(String transMotivo) {
        this.transMotivo = transMotivo;
    }

    public String getTransNumero() {
        return transNumero;
    }

    public void setTransNumero(String transNumero) {
        this.transNumero = transNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transEmpresa != null ? transEmpresa.hashCode() : 0);
        hash += (transPeriodo != null ? transPeriodo.hashCode() : 0);
        hash += (transMotivo != null ? transMotivo.hashCode() : 0);
        hash += (transNumero != null ? transNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransferenciasPK)) {
            return false;
        }
        InvTransferenciasPK other = (InvTransferenciasPK) object;
        if ((this.transEmpresa == null && other.transEmpresa != null) || (this.transEmpresa != null && !this.transEmpresa.equals(other.transEmpresa))) {
            return false;
        }
        if ((this.transPeriodo == null && other.transPeriodo != null) || (this.transPeriodo != null && !this.transPeriodo.equals(other.transPeriodo))) {
            return false;
        }
        if ((this.transMotivo == null && other.transMotivo != null) || (this.transMotivo != null && !this.transMotivo.equals(other.transMotivo))) {
            return false;
        }
        if ((this.transNumero == null && other.transNumero != null) || (this.transNumero != null && !this.transNumero.equals(other.transNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferenciasPK[ transEmpresa=" + transEmpresa + ", transPeriodo=" + transPeriodo + ", transMotivo=" + transMotivo + ", transNumero=" + transNumero + " ]";
    }
    
}
