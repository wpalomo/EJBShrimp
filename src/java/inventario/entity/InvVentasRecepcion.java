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
@Table(name = "inv_ventas_recepcion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasRecepcion.findAll", query = "SELECT i FROM InvVentasRecepcion i"),
    @NamedQuery(name = "InvVentasRecepcion.findByRecepEmpresa", query = "SELECT i FROM InvVentasRecepcion i WHERE i.invVentasRecepcionPK.recepEmpresa = :recepEmpresa"),
    @NamedQuery(name = "InvVentasRecepcion.findByRecepPeriodo", query = "SELECT i FROM InvVentasRecepcion i WHERE i.invVentasRecepcionPK.recepPeriodo = :recepPeriodo"),
    @NamedQuery(name = "InvVentasRecepcion.findByRecepMotivo", query = "SELECT i FROM InvVentasRecepcion i WHERE i.invVentasRecepcionPK.recepMotivo = :recepMotivo"),
    @NamedQuery(name = "InvVentasRecepcion.findByRecepNumero", query = "SELECT i FROM InvVentasRecepcion i WHERE i.invVentasRecepcionPK.recepNumero = :recepNumero"),
    @NamedQuery(name = "InvVentasRecepcion.findByRecepFecha", query = "SELECT i FROM InvVentasRecepcion i WHERE i.recepFecha = :recepFecha"),
    @NamedQuery(name = "InvVentasRecepcion.findByUsrEmpresa", query = "SELECT i FROM InvVentasRecepcion i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvVentasRecepcion.findByUsrCodigo", query = "SELECT i FROM InvVentasRecepcion i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvVentasRecepcion.findByUsrFechaInserta", query = "SELECT i FROM InvVentasRecepcion i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvVentasRecepcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasRecepcionPK invVentasRecepcionPK;
    @Basic(optional = false)
    @Column(name = "recep_fecha")
    @Temporal(TemporalType.DATE)
    private Date recepFecha;
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
    @JoinColumns({
        @JoinColumn(name = "vta_empresa", referencedColumnName = "vta_empresa"),
        @JoinColumn(name = "vta_periodo", referencedColumnName = "vta_periodo"),
        @JoinColumn(name = "vta_motivo", referencedColumnName = "vta_motivo"),
        @JoinColumn(name = "vta_numero", referencedColumnName = "vta_numero")})
    @ManyToOne(optional = false)
    private InvVentas invVentas;

    public InvVentasRecepcion() {
    }

    public InvVentasRecepcion(InvVentasRecepcionPK invVentasRecepcionPK) {
        this.invVentasRecepcionPK = invVentasRecepcionPK;
    }

    public InvVentasRecepcion(InvVentasRecepcionPK invVentasRecepcionPK, Date recepFecha, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invVentasRecepcionPK = invVentasRecepcionPK;
        this.recepFecha = recepFecha;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvVentasRecepcion(String recepEmpresa, String recepPeriodo, String recepMotivo, String recepNumero) {
        this.invVentasRecepcionPK = new InvVentasRecepcionPK(recepEmpresa, recepPeriodo, recepMotivo, recepNumero);
    }

    public InvVentasRecepcionPK getInvVentasRecepcionPK() {
        return invVentasRecepcionPK;
    }

    public void setInvVentasRecepcionPK(InvVentasRecepcionPK invVentasRecepcionPK) {
        this.invVentasRecepcionPK = invVentasRecepcionPK;
    }

    public Date getRecepFecha() {
        return recepFecha;
    }

    public void setRecepFecha(Date recepFecha) {
        this.recepFecha = recepFecha;
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

    public InvVentas getInvVentas() {
        return invVentas;
    }

    public void setInvVentas(InvVentas invVentas) {
        this.invVentas = invVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invVentasRecepcionPK != null ? invVentasRecepcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasRecepcion)) {
            return false;
        }
        InvVentasRecepcion other = (InvVentasRecepcion) object;
        if ((this.invVentasRecepcionPK == null && other.invVentasRecepcionPK != null) || (this.invVentasRecepcionPK != null && !this.invVentasRecepcionPK.equals(other.invVentasRecepcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasRecepcion[ invVentasRecepcionPK=" + invVentasRecepcionPK + " ]";
    }
    
}
