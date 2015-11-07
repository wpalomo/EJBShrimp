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
public class ConCuentasFlujoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "flu_empresa")
    private String fluEmpresa;
    @Basic(optional = false)
    @Column(name = "flu_codigo")
    private String fluCodigo;

    public ConCuentasFlujoPK() {
    }

    public ConCuentasFlujoPK(String fluEmpresa, String fluCodigo) {
        this.fluEmpresa = fluEmpresa;
        this.fluCodigo = fluCodigo;
    }

    public String getFluEmpresa() {
        return fluEmpresa;
    }

    public void setFluEmpresa(String fluEmpresa) {
        this.fluEmpresa = fluEmpresa;
    }

    public String getFluCodigo() {
        return fluCodigo;
    }

    public void setFluCodigo(String fluCodigo) {
        this.fluCodigo = fluCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fluEmpresa != null ? fluEmpresa.hashCode() : 0);
        hash += (fluCodigo != null ? fluCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentasFlujoPK)) {
            return false;
        }
        ConCuentasFlujoPK other = (ConCuentasFlujoPK) object;
        if ((this.fluEmpresa == null && other.fluEmpresa != null) || (this.fluEmpresa != null && !this.fluEmpresa.equals(other.fluEmpresa))) {
            return false;
        }
        if ((this.fluCodigo == null && other.fluCodigo != null) || (this.fluCodigo != null && !this.fluCodigo.equals(other.fluCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentasFlujoPK[ fluEmpresa=" + fluEmpresa + ", fluCodigo=" + fluCodigo + " ]";
    }
    
}
