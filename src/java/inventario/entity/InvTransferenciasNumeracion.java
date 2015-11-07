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
@Table(name = "inv_transferencias_numeracion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvTransferenciasNumeracion.findAll", query = "SELECT i FROM InvTransferenciasNumeracion i"),
    @NamedQuery(name = "InvTransferenciasNumeracion.findByNumEmpresa", query = "SELECT i FROM InvTransferenciasNumeracion i WHERE i.invTransferenciasNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvTransferenciasNumeracion.findByNumPeriodo", query = "SELECT i FROM InvTransferenciasNumeracion i WHERE i.invTransferenciasNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "InvTransferenciasNumeracion.findByNumMotivo", query = "SELECT i FROM InvTransferenciasNumeracion i WHERE i.invTransferenciasNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "InvTransferenciasNumeracion.findByNumSecuencia", query = "SELECT i FROM InvTransferenciasNumeracion i WHERE i.numSecuencia = :numSecuencia")})
public class InvTransferenciasNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvTransferenciasNumeracionPK invTransferenciasNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public InvTransferenciasNumeracion() {
    }

    public InvTransferenciasNumeracion(InvTransferenciasNumeracionPK invTransferenciasNumeracionPK) {
        this.invTransferenciasNumeracionPK = invTransferenciasNumeracionPK;
    }

    public InvTransferenciasNumeracion(InvTransferenciasNumeracionPK invTransferenciasNumeracionPK, String numSecuencia) {
        this.invTransferenciasNumeracionPK = invTransferenciasNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public InvTransferenciasNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.invTransferenciasNumeracionPK = new InvTransferenciasNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public InvTransferenciasNumeracionPK getInvTransferenciasNumeracionPK() {
        return invTransferenciasNumeracionPK;
    }

    public void setInvTransferenciasNumeracionPK(InvTransferenciasNumeracionPK invTransferenciasNumeracionPK) {
        this.invTransferenciasNumeracionPK = invTransferenciasNumeracionPK;
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
        hash += (invTransferenciasNumeracionPK != null ? invTransferenciasNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransferenciasNumeracion)) {
            return false;
        }
        InvTransferenciasNumeracion other = (InvTransferenciasNumeracion) object;
        if ((this.invTransferenciasNumeracionPK == null && other.invTransferenciasNumeracionPK != null) || (this.invTransferenciasNumeracionPK != null && !this.invTransferenciasNumeracionPK.equals(other.invTransferenciasNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferenciasNumeracion[ invTransferenciasNumeracionPK=" + invTransferenciasNumeracionPK + " ]";
    }
    
}
