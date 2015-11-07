/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_transferencias_motivo", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvTransferenciasMotivo.findAll", query = "SELECT i FROM InvTransferenciasMotivo i"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByTmEmpresa", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.invTransferenciasMotivoPK.tmEmpresa = :tmEmpresa"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByTmCodigo", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.invTransferenciasMotivoPK.tmCodigo = :tmCodigo"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByTmDetalle", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.tmDetalle = :tmDetalle"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByTmInactivo", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.tmInactivo = :tmInactivo"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByUsrEmpresa", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByUsrCodigo", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvTransferenciasMotivo.findByUsrFechaInserta", query = "SELECT i FROM InvTransferenciasMotivo i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvTransferenciasMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvTransferenciasMotivoPK invTransferenciasMotivoPK;
    @Basic(optional = false)
    @Column(name = "tm_detalle")
    private String tmDetalle;
    @Basic(optional = false)
    @Column(name = "tm_inactivo")
    private boolean tmInactivo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;

    public InvTransferenciasMotivo() {
    }

    public InvTransferenciasMotivo(InvTransferenciasMotivoPK invTransferenciasMotivoPK) {
        this.invTransferenciasMotivoPK = invTransferenciasMotivoPK;
    }

    public InvTransferenciasMotivo(InvTransferenciasMotivoPK invTransferenciasMotivoPK, String tmDetalle, boolean tmInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invTransferenciasMotivoPK = invTransferenciasMotivoPK;
        this.tmDetalle = tmDetalle;
        this.tmInactivo = tmInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvTransferenciasMotivo(String tmEmpresa, String tmCodigo) {
        this.invTransferenciasMotivoPK = new InvTransferenciasMotivoPK(tmEmpresa, tmCodigo);
    }

    public InvTransferenciasMotivoPK getInvTransferenciasMotivoPK() {
        return invTransferenciasMotivoPK;
    }

    public void setInvTransferenciasMotivoPK(InvTransferenciasMotivoPK invTransferenciasMotivoPK) {
        this.invTransferenciasMotivoPK = invTransferenciasMotivoPK;
    }

    public String getTmDetalle() {
        return tmDetalle;
    }

    public void setTmDetalle(String tmDetalle) {
        this.tmDetalle = tmDetalle;
    }

    public boolean getTmInactivo() {
        return tmInactivo;
    }

    public void setTmInactivo(boolean tmInactivo) {
        this.tmInactivo = tmInactivo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invTransferenciasMotivoPK != null ? invTransferenciasMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransferenciasMotivo)) {
            return false;
        }
        InvTransferenciasMotivo other = (InvTransferenciasMotivo) object;
        if ((this.invTransferenciasMotivoPK == null && other.invTransferenciasMotivoPK != null) || (this.invTransferenciasMotivoPK != null && !this.invTransferenciasMotivoPK.equals(other.invTransferenciasMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferenciasMotivo[ invTransferenciasMotivoPK=" + invTransferenciasMotivoPK + " ]";
    }
    
}
