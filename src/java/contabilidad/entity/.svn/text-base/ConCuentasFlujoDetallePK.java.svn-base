/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class ConCuentasFlujoDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "det_empresa")
    private String detEmpresa;
    @Basic(optional = false)
    @Column(name = "det_cuenta_contable")
    private String detCuentaContable;
    @Basic(optional = false)
    @Column(name = "det_debito_credito")
    private char detDebitoCredito;

    public ConCuentasFlujoDetallePK() {
    }

    public ConCuentasFlujoDetallePK(String detEmpresa, String detCuentaContable, char detDebitoCredito) {
        this.detEmpresa = detEmpresa;
        this.detCuentaContable = detCuentaContable;
        this.detDebitoCredito = detDebitoCredito;
    }

    public String getDetEmpresa() {
        return detEmpresa;
    }

    public void setDetEmpresa(String detEmpresa) {
        this.detEmpresa = detEmpresa;
    }

    public String getDetCuentaContable() {
        return detCuentaContable;
    }

    public void setDetCuentaContable(String detCuentaContable) {
        this.detCuentaContable = detCuentaContable;
    }

    public char getDetDebitoCredito() {
        return detDebitoCredito;
    }

    public void setDetDebitoCredito(char detDebitoCredito) {
        this.detDebitoCredito = detDebitoCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEmpresa != null ? detEmpresa.hashCode() : 0);
        hash += (detCuentaContable != null ? detCuentaContable.hashCode() : 0);
        hash += (int) detDebitoCredito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentasFlujoDetallePK)) {
            return false;
        }
        ConCuentasFlujoDetallePK other = (ConCuentasFlujoDetallePK) object;
        if ((this.detEmpresa == null && other.detEmpresa != null) || (this.detEmpresa != null && !this.detEmpresa.equals(other.detEmpresa))) {
            return false;
        }
        if ((this.detCuentaContable == null && other.detCuentaContable != null) || (this.detCuentaContable != null && !this.detCuentaContable.equals(other.detCuentaContable))) {
            return false;
        }
        if (this.detDebitoCredito != other.detDebitoCredito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentasFlujoDetallePK[ detEmpresa=" + detEmpresa + ", detCuentaContable=" + detCuentaContable + ", detDebitoCredito=" + detDebitoCredito + " ]";
    }
    
}
