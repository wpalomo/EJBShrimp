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
@Table(name = "inv_consumos_numeracion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvConsumosNumeracion.findAll", query = "SELECT i FROM InvConsumosNumeracion i"),
    @NamedQuery(name = "InvConsumosNumeracion.findByNumEmpresa", query = "SELECT i FROM InvConsumosNumeracion i WHERE i.invConsumosNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvConsumosNumeracion.findByNumPeriodo", query = "SELECT i FROM InvConsumosNumeracion i WHERE i.invConsumosNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "InvConsumosNumeracion.findByNumMotivo", query = "SELECT i FROM InvConsumosNumeracion i WHERE i.invConsumosNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "InvConsumosNumeracion.findByNumSecuencia", query = "SELECT i FROM InvConsumosNumeracion i WHERE i.numSecuencia = :numSecuencia")})
public class InvConsumosNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvConsumosNumeracionPK invConsumosNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public InvConsumosNumeracion() {
    }

    public InvConsumosNumeracion(InvConsumosNumeracionPK invConsumosNumeracionPK) {
        this.invConsumosNumeracionPK = invConsumosNumeracionPK;
    }

    public InvConsumosNumeracion(InvConsumosNumeracionPK invConsumosNumeracionPK, String numSecuencia) {
        this.invConsumosNumeracionPK = invConsumosNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public InvConsumosNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.invConsumosNumeracionPK = new InvConsumosNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public InvConsumosNumeracionPK getInvConsumosNumeracionPK() {
        return invConsumosNumeracionPK;
    }

    public void setInvConsumosNumeracionPK(InvConsumosNumeracionPK invConsumosNumeracionPK) {
        this.invConsumosNumeracionPK = invConsumosNumeracionPK;
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
        hash += (invConsumosNumeracionPK != null ? invConsumosNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvConsumosNumeracion)) {
            return false;
        }
        InvConsumosNumeracion other = (InvConsumosNumeracion) object;
        if ((this.invConsumosNumeracionPK == null && other.invConsumosNumeracionPK != null) || (this.invConsumosNumeracionPK != null && !this.invConsumosNumeracionPK.equals(other.invConsumosNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvConsumosNumeracion[ invConsumosNumeracionPK=" + invConsumosNumeracionPK + " ]";
    }
    
}
