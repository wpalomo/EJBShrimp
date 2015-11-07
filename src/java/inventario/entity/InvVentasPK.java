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
public class InvVentasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "vta_empresa")
    private String vtaEmpresa;
    @Basic(optional = false)
    @Column(name = "vta_periodo")
    private String vtaPeriodo;
    @Basic(optional = false)
    @Column(name = "vta_motivo")
    private String vtaMotivo;
    @Basic(optional = false)
    @Column(name = "vta_numero")
    private String vtaNumero;

    public InvVentasPK() {
    }

    public InvVentasPK(String vtaEmpresa, String vtaPeriodo, String vtaMotivo, String vtaNumero) {
        this.vtaEmpresa = vtaEmpresa;
        this.vtaPeriodo = vtaPeriodo;
        this.vtaMotivo = vtaMotivo;
        this.vtaNumero = vtaNumero;
    }

    public String getVtaEmpresa() {
        return vtaEmpresa;
    }

    public void setVtaEmpresa(String vtaEmpresa) {
        this.vtaEmpresa = vtaEmpresa;
    }

    public String getVtaPeriodo() {
        return vtaPeriodo;
    }

    public void setVtaPeriodo(String vtaPeriodo) {
        this.vtaPeriodo = vtaPeriodo;
    }

    public String getVtaMotivo() {
        return vtaMotivo;
    }

    public void setVtaMotivo(String vtaMotivo) {
        this.vtaMotivo = vtaMotivo;
    }

    public String getVtaNumero() {
        return vtaNumero;
    }

    public void setVtaNumero(String vtaNumero) {
        this.vtaNumero = vtaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtaEmpresa != null ? vtaEmpresa.hashCode() : 0);
        hash += (vtaPeriodo != null ? vtaPeriodo.hashCode() : 0);
        hash += (vtaMotivo != null ? vtaMotivo.hashCode() : 0);
        hash += (vtaNumero != null ? vtaNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasPK)) {
            return false;
        }
        InvVentasPK other = (InvVentasPK) object;
        if ((this.vtaEmpresa == null && other.vtaEmpresa != null) || (this.vtaEmpresa != null && !this.vtaEmpresa.equals(other.vtaEmpresa))) {
            return false;
        }
        if ((this.vtaPeriodo == null && other.vtaPeriodo != null) || (this.vtaPeriodo != null && !this.vtaPeriodo.equals(other.vtaPeriodo))) {
            return false;
        }
        if ((this.vtaMotivo == null && other.vtaMotivo != null) || (this.vtaMotivo != null && !this.vtaMotivo.equals(other.vtaMotivo))) {
            return false;
        }
        if ((this.vtaNumero == null && other.vtaNumero != null) || (this.vtaNumero != null && !this.vtaNumero.equals(other.vtaNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasPK[ vtaEmpresa=" + vtaEmpresa + ", vtaPeriodo=" + vtaPeriodo + ", vtaMotivo=" + vtaMotivo + ", vtaNumero=" + vtaNumero + " ]";
    }
    
}
