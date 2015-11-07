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
@Table(name = "inv_ventas_motivo_anulacion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasMotivoAnulacion.findAll", query = "SELECT i FROM InvVentasMotivoAnulacion i"),
    @NamedQuery(name = "InvVentasMotivoAnulacion.findByAnuEmpresa", query = "SELECT i FROM InvVentasMotivoAnulacion i WHERE i.invVentasMotivoAnulacionPK.anuEmpresa = :anuEmpresa"),
    @NamedQuery(name = "InvVentasMotivoAnulacion.findByAnuPeriodo", query = "SELECT i FROM InvVentasMotivoAnulacion i WHERE i.invVentasMotivoAnulacionPK.anuPeriodo = :anuPeriodo"),
    @NamedQuery(name = "InvVentasMotivoAnulacion.findByAnuMotivo", query = "SELECT i FROM InvVentasMotivoAnulacion i WHERE i.invVentasMotivoAnulacionPK.anuMotivo = :anuMotivo"),
    @NamedQuery(name = "InvVentasMotivoAnulacion.findByAnuNumero", query = "SELECT i FROM InvVentasMotivoAnulacion i WHERE i.invVentasMotivoAnulacionPK.anuNumero = :anuNumero"),
    @NamedQuery(name = "InvVentasMotivoAnulacion.findByAnuComentario", query = "SELECT i FROM InvVentasMotivoAnulacion i WHERE i.anuComentario = :anuComentario")})
public class InvVentasMotivoAnulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasMotivoAnulacionPK invVentasMotivoAnulacionPK;
    @Basic(optional = false)
    @Column(name = "anu_comentario")
    private String anuComentario;
    @JoinColumns({
        @JoinColumn(name = "vta_empresa", referencedColumnName = "vta_empresa"),
        @JoinColumn(name = "vta_periodo", referencedColumnName = "vta_periodo"),
        @JoinColumn(name = "vta_motivo", referencedColumnName = "vta_motivo"),
        @JoinColumn(name = "vta_numero", referencedColumnName = "vta_numero")})
    @ManyToOne(optional = false)
    private InvVentas invVentas;

    public InvVentasMotivoAnulacion() {
    }

    public InvVentasMotivoAnulacion(InvVentasMotivoAnulacionPK invVentasMotivoAnulacionPK) {
        this.invVentasMotivoAnulacionPK = invVentasMotivoAnulacionPK;
    }

    public InvVentasMotivoAnulacion(InvVentasMotivoAnulacionPK invVentasMotivoAnulacionPK, String anuComentario) {
        this.invVentasMotivoAnulacionPK = invVentasMotivoAnulacionPK;
        this.anuComentario = anuComentario;
    }

    public InvVentasMotivoAnulacion(String anuEmpresa, String anuPeriodo, String anuMotivo, String anuNumero) {
        this.invVentasMotivoAnulacionPK = new InvVentasMotivoAnulacionPK(anuEmpresa, anuPeriodo, anuMotivo, anuNumero);
    }

    public InvVentasMotivoAnulacionPK getInvVentasMotivoAnulacionPK() {
        return invVentasMotivoAnulacionPK;
    }

    public void setInvVentasMotivoAnulacionPK(InvVentasMotivoAnulacionPK invVentasMotivoAnulacionPK) {
        this.invVentasMotivoAnulacionPK = invVentasMotivoAnulacionPK;
    }

    public String getAnuComentario() {
        return anuComentario;
    }

    public void setAnuComentario(String anuComentario) {
        this.anuComentario = anuComentario;
    }

    public InvVentas getInvVentas() {
        return invVentas;
    }

    public void setInvVentas(InvVentas invVentas) {
        this.invVentas = invVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invVentasMotivoAnulacionPK != null ? invVentasMotivoAnulacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasMotivoAnulacion)) {
            return false;
        }
        InvVentasMotivoAnulacion other = (InvVentasMotivoAnulacion) object;
        if ((this.invVentasMotivoAnulacionPK == null && other.invVentasMotivoAnulacionPK != null) || (this.invVentasMotivoAnulacionPK != null && !this.invVentasMotivoAnulacionPK.equals(other.invVentasMotivoAnulacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasMotivoAnulacion[ invVentasMotivoAnulacionPK=" + invVentasMotivoAnulacionPK + " ]";
    }
    
}
