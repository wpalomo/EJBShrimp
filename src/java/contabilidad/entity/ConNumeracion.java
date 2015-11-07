/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_numeracion", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConNumeracion.findAll", query = "SELECT c FROM ConNumeracion c"),
    @NamedQuery(name = "ConNumeracion.findByNumEmpresa", query = "SELECT c FROM ConNumeracion c WHERE c.conNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "ConNumeracion.findByNumPeriodo", query = "SELECT c FROM ConNumeracion c WHERE c.conNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "ConNumeracion.findByNumTipo", query = "SELECT c FROM ConNumeracion c WHERE c.conNumeracionPK.numTipo = :numTipo"),
    @NamedQuery(name = "ConNumeracion.findByNumSecuencia", query = "SELECT c FROM ConNumeracion c WHERE c.numSecuencia = :numSecuencia")})
public class ConNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConNumeracionPK conNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private int numSecuencia;

    public ConNumeracion() {
    }

    public ConNumeracion(ConNumeracionPK conNumeracionPK) {
        this.conNumeracionPK = conNumeracionPK;
    }

    public ConNumeracion(ConNumeracionPK conNumeracionPK, int numSecuencia) {
        this.conNumeracionPK = conNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public ConNumeracion(String numEmpresa, String numPeriodo, String numTipo) {
        this.conNumeracionPK = new ConNumeracionPK(numEmpresa, numPeriodo, numTipo);
    }

    public ConNumeracionPK getConNumeracionPK() {
        return conNumeracionPK;
    }

    public void setConNumeracionPK(ConNumeracionPK conNumeracionPK) {
        this.conNumeracionPK = conNumeracionPK;
    }

    public int getNumSecuencia() {
        return numSecuencia;
    }

    public void setNumSecuencia(int numSecuencia) {
        this.numSecuencia = numSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conNumeracionPK != null ? conNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConNumeracion)) {
            return false;
        }
        ConNumeracion other = (ConNumeracion) object;
        if ((this.conNumeracionPK == null && other.conNumeracionPK != null) || (this.conNumeracionPK != null && !this.conNumeracionPK.equals(other.conNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConNumeracion[ conNumeracionPK=" + conNumeracionPK + " ]";
    }
    
}
