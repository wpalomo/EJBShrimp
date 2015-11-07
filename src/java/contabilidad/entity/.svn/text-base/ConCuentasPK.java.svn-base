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
public class ConCuentasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_codigo")
    private String ctaCodigo;

    public ConCuentasPK() {
    }

    public ConCuentasPK(String ctaEmpresa, String ctaCodigo) {
        this.ctaEmpresa = ctaEmpresa;
        this.ctaCodigo = ctaCodigo;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaEmpresa != null ? ctaEmpresa.hashCode() : 0);
        hash += (ctaCodigo != null ? ctaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentasPK)) {
            return false;
        }
        ConCuentasPK other = (ConCuentasPK) object;
        if ((this.ctaEmpresa == null && other.ctaEmpresa != null) || (this.ctaEmpresa != null && !this.ctaEmpresa.equals(other.ctaEmpresa))) {
            return false;
        }
        if ((this.ctaCodigo == null && other.ctaCodigo != null) || (this.ctaCodigo != null && !this.ctaCodigo.equals(other.ctaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentasPK[ ctaEmpresa=" + ctaEmpresa + ", ctaCodigo=" + ctaCodigo + " ]";
    }
    
}
