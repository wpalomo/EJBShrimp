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
@Table(name = "inv_compras_numeracion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvComprasNumeracion.findAll", query = "SELECT i FROM InvComprasNumeracion i"),
    @NamedQuery(name = "InvComprasNumeracion.findByNumEmpresa", query = "SELECT i FROM InvComprasNumeracion i WHERE i.invComprasNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvComprasNumeracion.findByNumPeriodo", query = "SELECT i FROM InvComprasNumeracion i WHERE i.invComprasNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "InvComprasNumeracion.findByNumMotivo", query = "SELECT i FROM InvComprasNumeracion i WHERE i.invComprasNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "InvComprasNumeracion.findByNumSecuencia", query = "SELECT i FROM InvComprasNumeracion i WHERE i.numSecuencia = :numSecuencia")})
public class InvComprasNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvComprasNumeracionPK invComprasNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public InvComprasNumeracion() {
    }

    public InvComprasNumeracion(InvComprasNumeracionPK invComprasNumeracionPK) {
        this.invComprasNumeracionPK = invComprasNumeracionPK;
    }

    public InvComprasNumeracion(InvComprasNumeracionPK invComprasNumeracionPK, String numSecuencia) {
        this.invComprasNumeracionPK = invComprasNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public InvComprasNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.invComprasNumeracionPK = new InvComprasNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public InvComprasNumeracionPK getInvComprasNumeracionPK() {
        return invComprasNumeracionPK;
    }

    public void setInvComprasNumeracionPK(InvComprasNumeracionPK invComprasNumeracionPK) {
        this.invComprasNumeracionPK = invComprasNumeracionPK;
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
        hash += (invComprasNumeracionPK != null ? invComprasNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasNumeracion)) {
            return false;
        }
        InvComprasNumeracion other = (InvComprasNumeracion) object;
        if ((this.invComprasNumeracionPK == null && other.invComprasNumeracionPK != null) || (this.invComprasNumeracionPK != null && !this.invComprasNumeracionPK.equals(other.invComprasNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasNumeracion[ invComprasNumeracionPK=" + invComprasNumeracionPK + " ]";
    }
    
}
