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
@Table(name = "inv_proformas_numeracion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProformasNumeracion.findAll", query = "SELECT i FROM InvProformasNumeracion i"),
    @NamedQuery(name = "InvProformasNumeracion.findByNumEmpresa", query = "SELECT i FROM InvProformasNumeracion i WHERE i.invProformasNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvProformasNumeracion.findByNumPeriodo", query = "SELECT i FROM InvProformasNumeracion i WHERE i.invProformasNumeracionPK.numPeriodo = :numPeriodo"),
    @NamedQuery(name = "InvProformasNumeracion.findByNumMotivo", query = "SELECT i FROM InvProformasNumeracion i WHERE i.invProformasNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "InvProformasNumeracion.findByNumSecuencia", query = "SELECT i FROM InvProformasNumeracion i WHERE i.numSecuencia = :numSecuencia")})
public class InvProformasNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProformasNumeracionPK invProformasNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public InvProformasNumeracion() {
    }

    public InvProformasNumeracion(InvProformasNumeracionPK invProformasNumeracionPK) {
        this.invProformasNumeracionPK = invProformasNumeracionPK;
    }

    public InvProformasNumeracion(InvProformasNumeracionPK invProformasNumeracionPK, String numSecuencia) {
        this.invProformasNumeracionPK = invProformasNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public InvProformasNumeracion(String numEmpresa, String numPeriodo, String numMotivo) {
        this.invProformasNumeracionPK = new InvProformasNumeracionPK(numEmpresa, numPeriodo, numMotivo);
    }

    public InvProformasNumeracionPK getInvProformasNumeracionPK() {
        return invProformasNumeracionPK;
    }

    public void setInvProformasNumeracionPK(InvProformasNumeracionPK invProformasNumeracionPK) {
        this.invProformasNumeracionPK = invProformasNumeracionPK;
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
        hash += (invProformasNumeracionPK != null ? invProformasNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProformasNumeracion)) {
            return false;
        }
        InvProformasNumeracion other = (InvProformasNumeracion) object;
        if ((this.invProformasNumeracionPK == null && other.invProformasNumeracionPK != null) || (this.invProformasNumeracionPK != null && !this.invProformasNumeracionPK.equals(other.invProformasNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProformasNumeracion[ invProformasNumeracionPK=" + invProformasNumeracionPK + " ]";
    }
    
}
