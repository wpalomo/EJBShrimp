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
@Table(name = "inv_compras_motivo", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvComprasMotivo.findAll", query = "SELECT i FROM InvComprasMotivo i"),
    @NamedQuery(name = "InvComprasMotivo.findByCmEmpresa", query = "SELECT i FROM InvComprasMotivo i WHERE i.invComprasMotivoPK.cmEmpresa = :cmEmpresa"),
    @NamedQuery(name = "InvComprasMotivo.findByCmCodigo", query = "SELECT i FROM InvComprasMotivo i WHERE i.invComprasMotivoPK.cmCodigo = :cmCodigo"),
    @NamedQuery(name = "InvComprasMotivo.findByCmDetalle", query = "SELECT i FROM InvComprasMotivo i WHERE i.cmDetalle = :cmDetalle"),
    @NamedQuery(name = "InvComprasMotivo.findByCmFormaContabilizar", query = "SELECT i FROM InvComprasMotivo i WHERE i.cmFormaContabilizar = :cmFormaContabilizar"),
    @NamedQuery(name = "InvComprasMotivo.findByCmFormaImprimir", query = "SELECT i FROM InvComprasMotivo i WHERE i.cmFormaImprimir = :cmFormaImprimir"),
    @NamedQuery(name = "InvComprasMotivo.findByCmAjustesDeInventario", query = "SELECT i FROM InvComprasMotivo i WHERE i.cmAjustesDeInventario = :cmAjustesDeInventario"),
    @NamedQuery(name = "InvComprasMotivo.findByCmInactivo", query = "SELECT i FROM InvComprasMotivo i WHERE i.cmInactivo = :cmInactivo"),
    @NamedQuery(name = "InvComprasMotivo.findByTipEmpresa", query = "SELECT i FROM InvComprasMotivo i WHERE i.tipEmpresa = :tipEmpresa"),
    @NamedQuery(name = "InvComprasMotivo.findByTipCodigo", query = "SELECT i FROM InvComprasMotivo i WHERE i.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "InvComprasMotivo.findByUsrEmpresa", query = "SELECT i FROM InvComprasMotivo i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvComprasMotivo.findByUsrCodigo", query = "SELECT i FROM InvComprasMotivo i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvComprasMotivo.findByUsrFechaInserta", query = "SELECT i FROM InvComprasMotivo i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvComprasMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvComprasMotivoPK invComprasMotivoPK;
    @Basic(optional = false)
    @Column(name = "cm_detalle")
    private String cmDetalle;
    @Basic(optional = false)
    @Column(name = "cm_forma_contabilizar")
    private String cmFormaContabilizar;
    @Basic(optional = false)
    @Column(name = "cm_forma_imprimir")
    private String cmFormaImprimir;
    @Basic(optional = false)
    @Column(name = "cm_ajustes_de_inventario")
    private boolean cmAjustesDeInventario;
    @Basic(optional = false)
    @Column(name = "cm_inactivo")
    private boolean cmInactivo;
    @Column(name = "tip_empresa")
    private String tipEmpresa;
    @Column(name = "tip_codigo")
    private String tipCodigo;
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

    public InvComprasMotivo() {
    }

    public InvComprasMotivo(InvComprasMotivoPK invComprasMotivoPK) {
        this.invComprasMotivoPK = invComprasMotivoPK;
    }

    public InvComprasMotivo(InvComprasMotivoPK invComprasMotivoPK, String cmDetalle, String cmFormaContabilizar, String cmFormaImprimir, boolean cmAjustesDeInventario, boolean cmInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invComprasMotivoPK = invComprasMotivoPK;
        this.cmDetalle = cmDetalle;
        this.cmFormaContabilizar = cmFormaContabilizar;
        this.cmFormaImprimir = cmFormaImprimir;
        this.cmAjustesDeInventario = cmAjustesDeInventario;
        this.cmInactivo = cmInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvComprasMotivo(String cmEmpresa, String cmCodigo) {
        this.invComprasMotivoPK = new InvComprasMotivoPK(cmEmpresa, cmCodigo);
    }

    public InvComprasMotivoPK getInvComprasMotivoPK() {
        return invComprasMotivoPK;
    }

    public void setInvComprasMotivoPK(InvComprasMotivoPK invComprasMotivoPK) {
        this.invComprasMotivoPK = invComprasMotivoPK;
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

    public String getCmFormaImprimir() {
        return cmFormaImprimir;
    }

    public void setCmFormaImprimir(String cmFormaImprimir) {
        this.cmFormaImprimir = cmFormaImprimir;
    }

    public boolean getCmAjustesDeInventario() {
        return cmAjustesDeInventario;
    }

    public void setCmAjustesDeInventario(boolean cmAjustesDeInventario) {
        this.cmAjustesDeInventario = cmAjustesDeInventario;
    }

    public boolean getCmInactivo() {
        return cmInactivo;
    }

    public void setCmInactivo(boolean cmInactivo) {
        this.cmInactivo = cmInactivo;
    }

    public String getTipEmpresa() {
        return tipEmpresa;
    }

    public void setTipEmpresa(String tipEmpresa) {
        this.tipEmpresa = tipEmpresa;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
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
        hash += (invComprasMotivoPK != null ? invComprasMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasMotivo)) {
            return false;
        }
        InvComprasMotivo other = (InvComprasMotivo) object;
        if ((this.invComprasMotivoPK == null && other.invComprasMotivoPK != null) || (this.invComprasMotivoPK != null && !this.invComprasMotivoPK.equals(other.invComprasMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasMotivo[ invComprasMotivoPK=" + invComprasMotivoPK + " ]";
    }
    
}
