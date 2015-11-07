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
public class ConContableMotivoAnulacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "anu_empresa")
    private String anuEmpresa;
    @Basic(optional = false)
    @Column(name = "anu_periodo")
    private String anuPeriodo;
    @Basic(optional = false)
    @Column(name = "anu_tipo")
    private String anuTipo;
    @Basic(optional = false)
    @Column(name = "anu_numero")
    private String anuNumero;

    public ConContableMotivoAnulacionPK() {
    }

    public ConContableMotivoAnulacionPK(String anuEmpresa, String anuPeriodo, String anuTipo, String anuNumero) {
        this.anuEmpresa = anuEmpresa;
        this.anuPeriodo = anuPeriodo;
        this.anuTipo = anuTipo;
        this.anuNumero = anuNumero;
    }

    public String getAnuEmpresa() {
        return anuEmpresa;
    }

    public void setAnuEmpresa(String anuEmpresa) {
        this.anuEmpresa = anuEmpresa;
    }

    public String getAnuPeriodo() {
        return anuPeriodo;
    }

    public void setAnuPeriodo(String anuPeriodo) {
        this.anuPeriodo = anuPeriodo;
    }

    public String getAnuTipo() {
        return anuTipo;
    }

    public void setAnuTipo(String anuTipo) {
        this.anuTipo = anuTipo;
    }

    public String getAnuNumero() {
        return anuNumero;
    }

    public void setAnuNumero(String anuNumero) {
        this.anuNumero = anuNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anuEmpresa != null ? anuEmpresa.hashCode() : 0);
        hash += (anuPeriodo != null ? anuPeriodo.hashCode() : 0);
        hash += (anuTipo != null ? anuTipo.hashCode() : 0);
        hash += (anuNumero != null ? anuNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConContableMotivoAnulacionPK)) {
            return false;
        }
        ConContableMotivoAnulacionPK other = (ConContableMotivoAnulacionPK) object;
        if ((this.anuEmpresa == null && other.anuEmpresa != null) || (this.anuEmpresa != null && !this.anuEmpresa.equals(other.anuEmpresa))) {
            return false;
        }
        if ((this.anuPeriodo == null && other.anuPeriodo != null) || (this.anuPeriodo != null && !this.anuPeriodo.equals(other.anuPeriodo))) {
            return false;
        }
        if ((this.anuTipo == null && other.anuTipo != null) || (this.anuTipo != null && !this.anuTipo.equals(other.anuTipo))) {
            return false;
        }
        if ((this.anuNumero == null && other.anuNumero != null) || (this.anuNumero != null && !this.anuNumero.equals(other.anuNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConContableMotivoAnulacionPK[ anuEmpresa=" + anuEmpresa + ", anuPeriodo=" + anuPeriodo + ", anuTipo=" + anuTipo + ", anuNumero=" + anuNumero + " ]";
    }
    
}
