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
@Table(name = "inv_compras_motivo_anulacion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvComprasMotivoAnulacion.findAll", query = "SELECT i FROM InvComprasMotivoAnulacion i"),
    @NamedQuery(name = "InvComprasMotivoAnulacion.findByAnuEmpresa", query = "SELECT i FROM InvComprasMotivoAnulacion i WHERE i.invComprasMotivoAnulacionPK.anuEmpresa = :anuEmpresa"),
    @NamedQuery(name = "InvComprasMotivoAnulacion.findByAnuPeriodo", query = "SELECT i FROM InvComprasMotivoAnulacion i WHERE i.invComprasMotivoAnulacionPK.anuPeriodo = :anuPeriodo"),
    @NamedQuery(name = "InvComprasMotivoAnulacion.findByAnuMotivo", query = "SELECT i FROM InvComprasMotivoAnulacion i WHERE i.invComprasMotivoAnulacionPK.anuMotivo = :anuMotivo"),
    @NamedQuery(name = "InvComprasMotivoAnulacion.findByAnuNumero", query = "SELECT i FROM InvComprasMotivoAnulacion i WHERE i.invComprasMotivoAnulacionPK.anuNumero = :anuNumero"),
    @NamedQuery(name = "InvComprasMotivoAnulacion.findByAnuComentario", query = "SELECT i FROM InvComprasMotivoAnulacion i WHERE i.anuComentario = :anuComentario")})
public class InvComprasMotivoAnulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvComprasMotivoAnulacionPK invComprasMotivoAnulacionPK;
    @Basic(optional = false)
    @Column(name = "anu_comentario")
    private String anuComentario;
    @JoinColumns({
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private InvCompras invCompras;

    public InvComprasMotivoAnulacion() {
    }

    public InvComprasMotivoAnulacion(InvComprasMotivoAnulacionPK invComprasMotivoAnulacionPK) {
        this.invComprasMotivoAnulacionPK = invComprasMotivoAnulacionPK;
    }

    public InvComprasMotivoAnulacion(InvComprasMotivoAnulacionPK invComprasMotivoAnulacionPK, String anuComentario) {
        this.invComprasMotivoAnulacionPK = invComprasMotivoAnulacionPK;
        this.anuComentario = anuComentario;
    }

    public InvComprasMotivoAnulacion(String anuEmpresa, String anuPeriodo, String anuMotivo, String anuNumero) {
        this.invComprasMotivoAnulacionPK = new InvComprasMotivoAnulacionPK(anuEmpresa, anuPeriodo, anuMotivo, anuNumero);
    }

    public InvComprasMotivoAnulacionPK getInvComprasMotivoAnulacionPK() {
        return invComprasMotivoAnulacionPK;
    }

    public void setInvComprasMotivoAnulacionPK(InvComprasMotivoAnulacionPK invComprasMotivoAnulacionPK) {
        this.invComprasMotivoAnulacionPK = invComprasMotivoAnulacionPK;
    }

    public String getAnuComentario() {
        return anuComentario;
    }

    public void setAnuComentario(String anuComentario) {
        this.anuComentario = anuComentario;
    }

    public InvCompras getInvCompras() {
        return invCompras;
    }

    public void setInvCompras(InvCompras invCompras) {
        this.invCompras = invCompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invComprasMotivoAnulacionPK != null ? invComprasMotivoAnulacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasMotivoAnulacion)) {
            return false;
        }
        InvComprasMotivoAnulacion other = (InvComprasMotivoAnulacion) object;
        if ((this.invComprasMotivoAnulacionPK == null && other.invComprasMotivoAnulacionPK != null) || (this.invComprasMotivoAnulacionPK != null && !this.invComprasMotivoAnulacionPK.equals(other.invComprasMotivoAnulacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasMotivoAnulacion[ invComprasMotivoAnulacionPK=" + invComprasMotivoAnulacionPK + " ]";
    }
    
}
