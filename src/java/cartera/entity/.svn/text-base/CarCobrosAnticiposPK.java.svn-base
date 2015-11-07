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
public class CarCobrosAnticiposPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ant_empresa")
    private String antEmpresa;
    @Basic(optional = false)
    @Column(name = "ant_periodo")
    private String antPeriodo;
    @Basic(optional = false)
    @Column(name = "ant_tipo")
    private String antTipo;
    @Basic(optional = false)
    @Column(name = "ant_numero")
    private String antNumero;

    public CarCobrosAnticiposPK() {
    }

    public CarCobrosAnticiposPK(String antEmpresa, String antPeriodo, String antTipo, String antNumero) {
        this.antEmpresa = antEmpresa;
        this.antPeriodo = antPeriodo;
        this.antTipo = antTipo;
        this.antNumero = antNumero;
    }

    public String getAntEmpresa() {
        return antEmpresa;
    }

    public void setAntEmpresa(String antEmpresa) {
        this.antEmpresa = antEmpresa;
    }

    public String getAntPeriodo() {
        return antPeriodo;
    }

    public void setAntPeriodo(String antPeriodo) {
        this.antPeriodo = antPeriodo;
    }

    public String getAntTipo() {
        return antTipo;
    }

    public void setAntTipo(String antTipo) {
        this.antTipo = antTipo;
    }

    public String getAntNumero() {
        return antNumero;
    }

    public void setAntNumero(String antNumero) {
        this.antNumero = antNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antEmpresa != null ? antEmpresa.hashCode() : 0);
        hash += (antPeriodo != null ? antPeriodo.hashCode() : 0);
        hash += (antTipo != null ? antTipo.hashCode() : 0);
        hash += (antNumero != null ? antNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarCobrosAnticiposPK)) {
            return false;
        }
        CarCobrosAnticiposPK other = (CarCobrosAnticiposPK) object;
        if ((this.antEmpresa == null && other.antEmpresa != null) || (this.antEmpresa != null && !this.antEmpresa.equals(other.antEmpresa))) {
            return false;
        }
        if ((this.antPeriodo == null && other.antPeriodo != null) || (this.antPeriodo != null && !this.antPeriodo.equals(other.antPeriodo))) {
            return false;
        }
        if ((this.antTipo == null && other.antTipo != null) || (this.antTipo != null && !this.antTipo.equals(other.antTipo))) {
            return false;
        }
        if ((this.antNumero == null && other.antNumero != null) || (this.antNumero != null && !this.antNumero.equals(other.antNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarCobrosAnticiposPK[ antEmpresa=" + antEmpresa + ", antPeriodo=" + antPeriodo + ", antTipo=" + antTipo + ", antNumero=" + antNumero + " ]";
    }
    
}
