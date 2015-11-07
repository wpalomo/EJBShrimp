/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jack
 */
@Embeddable
public class BanCuentaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_cuenta_contable")
    private String ctaCuentaContable;

    public BanCuentaPK() {
    }

    public BanCuentaPK(String ctaEmpresa, String ctaCuentaContable) {
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCuentaContable = ctaCuentaContable;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCuentaContable() {
        return ctaCuentaContable;
    }

    public void setCtaCuentaContable(String ctaCuentaContable) {
        this.ctaCuentaContable = ctaCuentaContable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaEmpresa != null ? ctaEmpresa.hashCode() : 0);
        hash += (ctaCuentaContable != null ? ctaCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanCuentaPK)) {
            return false;
        }
        BanCuentaPK other = (BanCuentaPK) object;
        if ((this.ctaEmpresa == null && other.ctaEmpresa != null) || (this.ctaEmpresa != null && !this.ctaEmpresa.equals(other.ctaEmpresa))) {
            return false;
        }
        if ((this.ctaCuentaContable == null && other.ctaCuentaContable != null) || (this.ctaCuentaContable != null && !this.ctaCuentaContable.equals(other.ctaCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanCuentaPK[ ctaEmpresa=" + ctaEmpresa + ", ctaCuentaContable=" + ctaCuentaContable + " ]";
    }
    
}
