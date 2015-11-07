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
@Table(name = "inv_transferencias_motivo_anulacion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findAll", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i"),
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findByAnuEmpresa", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i WHERE i.invTransferenciasMotivoAnulacionPK.anuEmpresa = :anuEmpresa"),
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findByAnuPeriodo", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i WHERE i.invTransferenciasMotivoAnulacionPK.anuPeriodo = :anuPeriodo"),
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findByAnuMotivo", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i WHERE i.invTransferenciasMotivoAnulacionPK.anuMotivo = :anuMotivo"),
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findByAnuNumero", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i WHERE i.invTransferenciasMotivoAnulacionPK.anuNumero = :anuNumero"),
    @NamedQuery(name = "InvTransferenciasMotivoAnulacion.findByAnuComentario", query = "SELECT i FROM InvTransferenciasMotivoAnulacion i WHERE i.anuComentario = :anuComentario")})
public class InvTransferenciasMotivoAnulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvTransferenciasMotivoAnulacionPK invTransferenciasMotivoAnulacionPK;
    @Basic(optional = false)
    @Column(name = "anu_comentario")
    private String anuComentario;
    @JoinColumns({
        @JoinColumn(name = "trans_empresa", referencedColumnName = "trans_empresa"),
        @JoinColumn(name = "trans_periodo", referencedColumnName = "trans_periodo"),
        @JoinColumn(name = "trans_motivo", referencedColumnName = "trans_motivo"),
        @JoinColumn(name = "trans_numero", referencedColumnName = "trans_numero")})
    @ManyToOne(optional = false)
    private InvTransferencias invTransferencias;

    public InvTransferenciasMotivoAnulacion() {
    }

    public InvTransferenciasMotivoAnulacion(InvTransferenciasMotivoAnulacionPK invTransferenciasMotivoAnulacionPK) {
        this.invTransferenciasMotivoAnulacionPK = invTransferenciasMotivoAnulacionPK;
    }

    public InvTransferenciasMotivoAnulacion(InvTransferenciasMotivoAnulacionPK invTransferenciasMotivoAnulacionPK, String anuComentario) {
        this.invTransferenciasMotivoAnulacionPK = invTransferenciasMotivoAnulacionPK;
        this.anuComentario = anuComentario;
    }

    public InvTransferenciasMotivoAnulacion(String anuEmpresa, String anuPeriodo, String anuMotivo, String anuNumero) {
        this.invTransferenciasMotivoAnulacionPK = new InvTransferenciasMotivoAnulacionPK(anuEmpresa, anuPeriodo, anuMotivo, anuNumero);
    }

    public InvTransferenciasMotivoAnulacionPK getInvTransferenciasMotivoAnulacionPK() {
        return invTransferenciasMotivoAnulacionPK;
    }

    public void setInvTransferenciasMotivoAnulacionPK(InvTransferenciasMotivoAnulacionPK invTransferenciasMotivoAnulacionPK) {
        this.invTransferenciasMotivoAnulacionPK = invTransferenciasMotivoAnulacionPK;
    }

    public String getAnuComentario() {
        return anuComentario;
    }

    public void setAnuComentario(String anuComentario) {
        this.anuComentario = anuComentario;
    }

    public InvTransferencias getInvTransferencias() {
        return invTransferencias;
    }

    public void setInvTransferencias(InvTransferencias invTransferencias) {
        this.invTransferencias = invTransferencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invTransferenciasMotivoAnulacionPK != null ? invTransferenciasMotivoAnulacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransferenciasMotivoAnulacion)) {
            return false;
        }
        InvTransferenciasMotivoAnulacion other = (InvTransferenciasMotivoAnulacion) object;
        if ((this.invTransferenciasMotivoAnulacionPK == null && other.invTransferenciasMotivoAnulacionPK != null) || (this.invTransferenciasMotivoAnulacionPK != null && !this.invTransferenciasMotivoAnulacionPK.equals(other.invTransferenciasMotivoAnulacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferenciasMotivoAnulacion[ invTransferenciasMotivoAnulacionPK=" + invTransferenciasMotivoAnulacionPK + " ]";
    }
    
}
