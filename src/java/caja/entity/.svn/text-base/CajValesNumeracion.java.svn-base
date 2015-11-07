/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "caj_vales_numeracion", schema = "caja")
@NamedQueries({
    @NamedQuery(name = "CajValesNumeracion.findAll", query = "SELECT c FROM CajValesNumeracion c"),
    @NamedQuery(name = "CajValesNumeracion.findByNumEmpresa", query = "SELECT c FROM CajValesNumeracion c WHERE c.cajValesNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "CajValesNumeracion.findByNumPeriodo", query = "SELECT c FROM CajValesNumeracion c WHERE c.cajValesNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "CajValesNumeracion.findByNumMotivo", query = "SELECT c FROM CajValesNumeracion c WHERE c.cajValesNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "CajValesNumeracion.findByNumSecuencia", query = "SELECT c FROM CajValesNumeracion c WHERE c.numSecuencia = :numSecuencia")})
public class CajValesNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajValesNumeracionPK cajValesNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public CajValesNumeracion() {
    }

    public CajValesNumeracion(CajValesNumeracionPK cajValesNumeracionPK) {
        this.cajValesNumeracionPK = cajValesNumeracionPK;
    }

    public CajValesNumeracion(CajValesNumeracionPK cajValesNumeracionPK, String numSecuencia) {
        this.cajValesNumeracionPK = cajValesNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public CajValesNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.cajValesNumeracionPK = new CajValesNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public CajValesNumeracionPK getCajValesNumeracionPK() {
        return cajValesNumeracionPK;
    }

    public void setCajValesNumeracionPK(CajValesNumeracionPK cajValesNumeracionPK) {
        this.cajValesNumeracionPK = cajValesNumeracionPK;
    }

    public String getNumSecuencia() {
        return numSecuencia;
    }

    public void setNumSecuencia(String numSecuencia) {
        this.numSecuencia = numSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajValesNumeracionPK != null ? cajValesNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajValesNumeracion)) {
            return false;
        }
        CajValesNumeracion other = (CajValesNumeracion) object;
        if ((this.cajValesNumeracionPK == null && other.cajValesNumeracionPK != null) || (this.cajValesNumeracionPK != null && !this.cajValesNumeracionPK.equals(other.cajValesNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "caja.entity.CajValesNumeracion[ cajValesNumeracionPK=" + cajValesNumeracionPK + " ]";
    }
    
}
