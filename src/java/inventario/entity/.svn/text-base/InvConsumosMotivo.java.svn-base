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
@Table(name = "inv_consumos_motivo", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvConsumosMotivo.findAll", query = "SELECT i FROM InvConsumosMotivo i"),
    @NamedQuery(name = "InvConsumosMotivo.findByCmEmpresa", query = "SELECT i FROM InvConsumosMotivo i WHERE i.invConsumosMotivoPK.cmEmpresa = :cmEmpresa"),
    @NamedQuery(name = "InvConsumosMotivo.findByCmCodigo", query = "SELECT i FROM InvConsumosMotivo i WHERE i.invConsumosMotivoPK.cmCodigo = :cmCodigo"),
    @NamedQuery(name = "InvConsumosMotivo.findByCmDetalle", query = "SELECT i FROM InvConsumosMotivo i WHERE i.cmDetalle = :cmDetalle"),
    @NamedQuery(name = "InvConsumosMotivo.findByCmFormaContabilizar", query = "SELECT i FROM InvConsumosMotivo i WHERE i.cmFormaContabilizar = :cmFormaContabilizar"),
    @NamedQuery(name = "InvConsumosMotivo.findByCmInactivo", query = "SELECT i FROM InvConsumosMotivo i WHERE i.cmInactivo = :cmInactivo"),
    @NamedQuery(name = "InvConsumosMotivo.findByUsrEmpresa", query = "SELECT i FROM InvConsumosMotivo i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvConsumosMotivo.findByUsrCodigo", query = "SELECT i FROM InvConsumosMotivo i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvConsumosMotivo.findByUsrFechaInserta", query = "SELECT i FROM InvConsumosMotivo i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvConsumosMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvConsumosMotivoPK invConsumosMotivoPK;
    @Basic(optional = false)
    @Column(name = "cm_detalle")
    private String cmDetalle;
    @Basic(optional = false)
    @Column(name = "cm_forma_contabilizar")
    private String cmFormaContabilizar;
    @Basic(optional = false)
    @Column(name = "cm_inactivo")
    private boolean cmInactivo;
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

    public InvConsumosMotivo() {
    }

    public InvConsumosMotivo(InvConsumosMotivoPK invConsumosMotivoPK) {
        this.invConsumosMotivoPK = invConsumosMotivoPK;
    }

    public InvConsumosMotivo(InvConsumosMotivoPK invConsumosMotivoPK, String cmDetalle, String cmFormaContabilizar, boolean cmInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invConsumosMotivoPK = invConsumosMotivoPK;
        this.cmDetalle = cmDetalle;
        this.cmFormaContabilizar = cmFormaContabilizar;
        this.cmInactivo = cmInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvConsumosMotivo(String cmEmpresa, String cmCodigo) {
        this.invConsumosMotivoPK = new InvConsumosMotivoPK(cmEmpresa, cmCodigo);
    }

    public InvConsumosMotivoPK getInvConsumosMotivoPK() {
        return invConsumosMotivoPK;
    }

    public void setInvConsumosMotivoPK(InvConsumosMotivoPK invConsumosMotivoPK) {
        this.invConsumosMotivoPK = invConsumosMotivoPK;
    }

    public String getCmDetalle() {
        return cmDetalle;
    }

    public void setCmDetalle(String cmDetalle) {
        this.cmDetalle = cmDetalle;
    }

    public String getCmFormaContabilizar() {
        return cmFormaContabilizar;
    }

    public void setCmFormaContabilizar(String cmFormaContabilizar) {
        this.cmFormaContabilizar = cmFormaContabilizar;
    }

    public boolean getCmInactivo() {
        return cmInactivo;
    }

    public void setCmInactivo(boolean cmInactivo) {
        this.cmInactivo = cmInactivo;
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
        hash += (invConsumosMotivoPK != null ? invConsumosMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvConsumosMotivo)) {
            return false;
        }
        InvConsumosMotivo other = (InvConsumosMotivo) object;
        if ((this.invConsumosMotivoPK == null && other.invConsumosMotivoPK != null) || (this.invConsumosMotivoPK != null && !this.invConsumosMotivoPK.equals(other.invConsumosMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvConsumosMotivo[ invConsumosMotivoPK=" + invConsumosMotivoPK + " ]";
    }
    
}
