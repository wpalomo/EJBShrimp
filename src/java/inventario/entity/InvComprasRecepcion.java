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
@Table(name = "inv_compras_recepcion", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvComprasRecepcion.findAll", query = "SELECT i FROM InvComprasRecepcion i"),
    @NamedQuery(name = "InvComprasRecepcion.findByRecepEmpresa", query = "SELECT i FROM InvComprasRecepcion i WHERE i.invComprasRecepcionPK.recepEmpresa = :recepEmpresa"),
    @NamedQuery(name = "InvComprasRecepcion.findByRecepPeriodo", query = "SELECT i FROM InvComprasRecepcion i WHERE i.invComprasRecepcionPK.recepPeriodo = :recepPeriodo"),
    @NamedQuery(name = "InvComprasRecepcion.findByRecepMotivo", query = "SELECT i FROM InvComprasRecepcion i WHERE i.invComprasRecepcionPK.recepMotivo = :recepMotivo"),
    @NamedQuery(name = "InvComprasRecepcion.findByRecepNumero", query = "SELECT i FROM InvComprasRecepcion i WHERE i.invComprasRecepcionPK.recepNumero = :recepNumero"),
    @NamedQuery(name = "InvComprasRecepcion.findByRecepFecha", query = "SELECT i FROM InvComprasRecepcion i WHERE i.recepFecha = :recepFecha"),
    @NamedQuery(name = "InvComprasRecepcion.findByUsrEmpresa", query = "SELECT i FROM InvComprasRecepcion i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvComprasRecepcion.findByUsrCodigo", query = "SELECT i FROM InvComprasRecepcion i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvComprasRecepcion.findByUsrFechaInserta", query = "SELECT i FROM InvComprasRecepcion i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvComprasRecepcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvComprasRecepcionPK invComprasRecepcionPK;
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
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private InvCompras invCompras;

    public InvComprasRecepcion() {
    }

    public InvComprasRecepcion(InvComprasRecepcionPK invComprasRecepcionPK) {
        this.invComprasRecepcionPK = invComprasRecepcionPK;
    }

    public InvComprasRecepcion(InvComprasRecepcionPK invComprasRecepcionPK, Date recepFecha, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invComprasRecepcionPK = invComprasRecepcionPK;
        this.recepFecha = recepFecha;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvComprasRecepcion(String recepEmpresa, String recepPeriodo, String recepMotivo, String recepNumero) {
        this.invComprasRecepcionPK = new InvComprasRecepcionPK(recepEmpresa, recepPeriodo, recepMotivo, recepNumero);
    }

    public InvComprasRecepcionPK getInvComprasRecepcionPK() {
        return invComprasRecepcionPK;
    }

    public void setInvComprasRecepcionPK(InvComprasRecepcionPK invComprasRecepcionPK) {
        this.invComprasRecepcionPK = invComprasRecepcionPK;
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

    public InvCompras getInvCompras() {
        return invCompras;
    }

    public void setInvCompras(InvCompras invCompras) {
        this.invCompras = invCompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invComprasRecepcionPK != null ? invComprasRecepcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasRecepcion)) {
            return false;
        }
        InvComprasRecepcion other = (InvComprasRecepcion) object;
        if ((this.invComprasRecepcionPK == null && other.invComprasRecepcionPK != null) || (this.invComprasRecepcionPK != null && !this.invComprasRecepcionPK.equals(other.invComprasRecepcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasRecepcion[ invComprasRecepcionPK=" + invComprasRecepcionPK + " ]";
    }
    
}
