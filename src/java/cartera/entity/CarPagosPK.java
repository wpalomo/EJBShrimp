/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer2
 */
@Embeddable
public class CarPagosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pag_empresa")
    private String pagEmpresa;
    @Basic(optional = false)
    @Column(name = "pag_periodo")
    private String pagPeriodo;
    @Basic(optional = false)
    @Column(name = "pag_tipo")
    private String pagTipo;
    @Basic(optional = false)
    @Column(name = "pag_numero")
    private String pagNumero;

    public CarPagosPK() {
    }

    public CarPagosPK(String pagEmpresa, String pagPeriodo, String pagTipo, String pagNumero) {
        this.pagEmpresa = pagEmpresa;
        this.pagPeriodo = pagPeriodo;
        this.pagTipo = pagTipo;
        this.pagNumero = pagNumero;
    }

    public String getPagEmpresa() {
        return pagEmpresa;
    }

    public void setPagEmpresa(String pagEmpresa) {
        this.pagEmpresa = pagEmpresa;
    }

    public String getPagPeriodo() {
        return pagPeriodo;
    }

    public void setPagPeriodo(String pagPeriodo) {
        this.pagPeriodo = pagPeriodo;
    }

    public String getPagTipo() {
        return pagTipo;
    }

    public void setPagTipo(String pagTipo) {
        this.pagTipo = pagTipo;
    }

    public String getPagNumero() {
        return pagNumero;
    }

    public void setPagNumero(String pagNumero) {
        this.pagNumero = pagNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagEmpresa != null ? pagEmpresa.hashCode() : 0);
        hash += (pagPeriodo != null ? pagPeriodo.hashCode() : 0);
        hash += (pagTipo != null ? pagTipo.hashCode() : 0);
        hash += (pagNumero != null ? pagNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarPagosPK)) {
            return false;
        }
        CarPagosPK other = (CarPagosPK) object;
        if ((this.pagEmpresa == null && other.pagEmpresa != null) || (this.pagEmpresa != null && !this.pagEmpresa.equals(other.pagEmpresa))) {
            return false;
        }
        if ((this.pagPeriodo == null && other.pagPeriodo != null) || (this.pagPeriodo != null && !this.pagPeriodo.equals(other.pagPeriodo))) {
            return false;
        }
        if ((this.pagTipo == null && other.pagTipo != null) || (this.pagTipo != null && !this.pagTipo.equals(other.pagTipo))) {
            return false;
        }
        if ((this.pagNumero == null && other.pagNumero != null) || (this.pagNumero != null && !this.pagNumero.equals(other.pagNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarPagosPK[ pagEmpresa=" + pagEmpresa + ", pagPeriodo=" + pagPeriodo + ", pagTipo=" + pagTipo + ", pagNumero=" + pagNumero + " ]";
    }
    
}
