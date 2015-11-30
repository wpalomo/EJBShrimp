/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_ventas_numeracion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasNumeracion.findAll", query = "SELECT i FROM InvVentasNumeracion i"),
    @NamedQuery(name = "InvVentasNumeracion.findByNumEmpresa", query = "SELECT i FROM InvVentasNumeracion i WHERE i.invVentasNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvVentasNumeracion.findByNumPeriodo", query = "SELECT i FROM InvVentasNumeracion i WHERE i.invVentasNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "InvVentasNumeracion.findByNumMotivo", query = "SELECT i FROM InvVentasNumeracion i WHERE i.invVentasNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "InvVentasNumeracion.findByNumSecuencia", query = "SELECT i FROM InvVentasNumeracion i WHERE i.numSecuencia = :numSecuencia")})
public class InvVentasNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasNumeracionPK invVentasNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public InvVentasNumeracion() {
    }

    public InvVentasNumeracion(InvVentasNumeracionPK invVentasNumeracionPK) {
        this.invVentasNumeracionPK = invVentasNumeracionPK;
    }

    public InvVentasNumeracion(InvVentasNumeracionPK invVentasNumeracionPK, String numSecuencia) {
        this.invVentasNumeracionPK = invVentasNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public InvVentasNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.invVentasNumeracionPK = new InvVentasNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public InvVentasNumeracionPK getInvVentasNumeracionPK() {
        return invVentasNumeracionPK;
    }

    public void setInvVentasNumeracionPK(InvVentasNumeracionPK invVentasNumeracionPK) {
        this.invVentasNumeracionPK = invVentasNumeracionPK;
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
        hash += (invVentasNumeracionPK != null ? invVentasNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasNumeracion)) {
            return false;
        }
        InvVentasNumeracion other = (InvVentasNumeracion) object;
        if ((this.invVentasNumeracionPK == null && other.invVentasNumeracionPK != null) || (this.invVentasNumeracionPK != null && !this.invVentasNumeracionPK.equals(other.invVentasNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasNumeracion[ invVentasNumeracionPK=" + invVentasNumeracionPK + " ]";
    }
    
}
