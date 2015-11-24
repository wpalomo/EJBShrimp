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
@Table(name = "inv_consumos_motivo_anulacion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findAll", query = "SELECT i FROM InvConsumosMotivoAnulacion i"),
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findByAnuEmpresa", query = "SELECT i FROM InvConsumosMotivoAnulacion i WHERE i.invConsumosMotivoAnulacionPK.anuEmpresa = :anuEmpresa"),
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findByAnuPeriodo", query = "SELECT i FROM InvConsumosMotivoAnulacion i WHERE i.invConsumosMotivoAnulacionPK.anuPeriodo = :anuPeriodo"),
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findByAnuMotivo", query = "SELECT i FROM InvConsumosMotivoAnulacion i WHERE i.invConsumosMotivoAnulacionPK.anuMotivo = :anuMotivo"),
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findByAnuNumero", query = "SELECT i FROM InvConsumosMotivoAnulacion i WHERE i.invConsumosMotivoAnulacionPK.anuNumero = :anuNumero"),
    @NamedQuery(name = "InvConsumosMotivoAnulacion.findByAnuComentario", query = "SELECT i FROM InvConsumosMotivoAnulacion i WHERE i.anuComentario = :anuComentario")})
public class InvConsumosMotivoAnulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvConsumosMotivoAnulacionPK invConsumosMotivoAnulacionPK;
    @Basic(optional = false)
    @Column(name = "anu_comentario")
    private String anuComentario;
    @JoinColumns({
        @JoinColumn(name = "cons_empresa", referencedColumnName = "cons_empresa"),
        @JoinColumn(name = "cons_periodo", referencedColumnName = "cons_periodo"),
        @JoinColumn(name = "cons_motivo", referencedColumnName = "cons_motivo"),
        @JoinColumn(name = "cons_numero", referencedColumnName = "cons_numero")})
    @ManyToOne(optional = false)
    private InvConsumos invConsumos;

    public InvConsumosMotivoAnulacion() {
    }

    public InvConsumosMotivoAnulacion(InvConsumosMotivoAnulacionPK invConsumosMotivoAnulacionPK) {
        this.invConsumosMotivoAnulacionPK = invConsumosMotivoAnulacionPK;
    }

    public InvConsumosMotivoAnulacion(InvConsumosMotivoAnulacionPK invConsumosMotivoAnulacionPK, String anuComentario) {
        this.invConsumosMotivoAnulacionPK = invConsumosMotivoAnulacionPK;
        this.anuComentario = anuComentario;
    }

    public InvConsumosMotivoAnulacion(String anuEmpresa, String anuPeriodo, String anuMotivo, String anuNumero) {
        this.invConsumosMotivoAnulacionPK = new InvConsumosMotivoAnulacionPK(anuEmpresa, anuPeriodo, anuMotivo, anuNumero);
    }

    public InvConsumosMotivoAnulacionPK getInvConsumosMotivoAnulacionPK() {
        return invConsumosMotivoAnulacionPK;
    }

    public void setInvConsumosMotivoAnulacionPK(InvConsumosMotivoAnulacionPK invConsumosMotivoAnulacionPK) {
        this.invConsumosMotivoAnulacionPK = invConsumosMotivoAnulacionPK;
    }

    public String getAnuComentario() {
        return anuComentario;
    }

    public void setAnuComentario(String anuComentario) {
        this.anuComentario = anuComentario;
    }

    public InvConsumos getInvConsumos() {
        return invConsumos;
    }

    public void setInvConsumos(InvConsumos invConsumos) {
        this.invConsumos = invConsumos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invConsumosMotivoAnulacionPK != null ? invConsumosMotivoAnulacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvConsumosMotivoAnulacion)) {
            return false;
        }
        InvConsumosMotivoAnulacion other = (InvConsumosMotivoAnulacion) object;
        if ((this.invConsumosMotivoAnulacionPK == null && other.invConsumosMotivoAnulacionPK != null) || (this.invConsumosMotivoAnulacionPK != null && !this.invConsumosMotivoAnulacionPK.equals(other.invConsumosMotivoAnulacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvConsumosMotivoAnulacion[ invConsumosMotivoAnulacionPK=" + invConsumosMotivoAnulacionPK + " ]";
    }
    
}
