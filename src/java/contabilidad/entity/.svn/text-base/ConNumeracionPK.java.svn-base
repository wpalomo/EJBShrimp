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
public class ConNumeracionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "num_empresa")
    private String numEmpresa;
    @Basic(optional = false)
    @Column(name = "num_periodo")
    private String numPeriodo;
    @Basic(optional = false)
    @Column(name = "num_tipo")
    private String numTipo;

    public ConNumeracionPK() {
    }

    public ConNumeracionPK(String numEmpresa, String numPeriodo, String numTipo) {
        this.numEmpresa = numEmpresa;
        this.numPeriodo = numPeriodo;
        this.numTipo = numTipo;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumPeriodo() {
        return numPeriodo;
    }

    public void setNumPeriodo(String numPeriodo) {
        this.numPeriodo = numPeriodo;
    }

    public String getNumTipo() {
        return numTipo;
    }

    public void setNumTipo(String numTipo) {
        this.numTipo = numTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEmpresa != null ? numEmpresa.hashCode() : 0);
        hash += (numPeriodo != null ? numPeriodo.hashCode() : 0);
        hash += (numTipo != null ? numTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConNumeracionPK)) {
            return false;
        }
        ConNumeracionPK other = (ConNumeracionPK) object;
        if ((this.numEmpresa == null && other.numEmpresa != null) || (this.numEmpresa != null && !this.numEmpresa.equals(other.numEmpresa))) {
            return false;
        }
        if ((this.numPeriodo == null && other.numPeriodo != null) || (this.numPeriodo != null && !this.numPeriodo.equals(other.numPeriodo))) {
            return false;
        }
        if ((this.numTipo == null && other.numTipo != null) || (this.numTipo != null && !this.numTipo.equals(other.numTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConNumeracionPK[ numEmpresa=" + numEmpresa + ", numPeriodo=" + numPeriodo + ", numTipo=" + numTipo + " ]";
    }
    
}
