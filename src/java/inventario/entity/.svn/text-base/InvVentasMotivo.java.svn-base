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
@Table(name = "inv_ventas_motivo", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasMotivo.findAll", query = "SELECT i FROM InvVentasMotivo i"),
    @NamedQuery(name = "InvVentasMotivo.findByVmEmpresa", query = "SELECT i FROM InvVentasMotivo i WHERE i.invVentasMotivoPK.vmEmpresa = :vmEmpresa"),
    @NamedQuery(name = "InvVentasMotivo.findByVmCodigo", query = "SELECT i FROM InvVentasMotivo i WHERE i.invVentasMotivoPK.vmCodigo = :vmCodigo"),
    @NamedQuery(name = "InvVentasMotivo.findByVmDetalle", query = "SELECT i FROM InvVentasMotivo i WHERE i.vmDetalle = :vmDetalle"),
    @NamedQuery(name = "InvVentasMotivo.findByVmFormaContabilizar", query = "SELECT i FROM InvVentasMotivo i WHERE i.vmFormaContabilizar = :vmFormaContabilizar"),
    @NamedQuery(name = "InvVentasMotivo.findByVmFormaImprimir", query = "SELECT i FROM InvVentasMotivo i WHERE i.vmFormaImprimir = :vmFormaImprimir"),
    @NamedQuery(name = "InvVentasMotivo.findByVmInactivo", query = "SELECT i FROM InvVentasMotivo i WHERE i.vmInactivo = :vmInactivo"),
    @NamedQuery(name = "InvVentasMotivo.findByTipEmpresa", query = "SELECT i FROM InvVentasMotivo i WHERE i.tipEmpresa = :tipEmpresa"),
    @NamedQuery(name = "InvVentasMotivo.findByTipCodigo", query = "SELECT i FROM InvVentasMotivo i WHERE i.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "InvVentasMotivo.findByUsrEmpresa", query = "SELECT i FROM InvVentasMotivo i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvVentasMotivo.findByUsrCodigo", query = "SELECT i FROM InvVentasMotivo i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvVentasMotivo.findByUsrFechaInserta", query = "SELECT i FROM InvVentasMotivo i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvVentasMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasMotivoPK invVentasMotivoPK;
    @Basic(optional = false)
    @Column(name = "vm_detalle")
    private String vmDetalle;
    @Basic(optional = false)
    @Column(name = "vm_forma_contabilizar")
    private String vmFormaContabilizar;
    @Basic(optional = false)
    @Column(name = "vm_forma_imprimir")
    private String vmFormaImprimir;
    @Basic(optional = false)
    @Column(name = "vm_inactivo")
    private boolean vmInactivo;
    @Basic(optional = false)
    @Column(name = "tip_empresa")
    private String tipEmpresa;
    @Basic(optional = false)
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

    public InvVentasMotivo() {
    }

    public InvVentasMotivo(InvVentasMotivoPK invVentasMotivoPK) {
        this.invVentasMotivoPK = invVentasMotivoPK;
    }

    public InvVentasMotivo(InvVentasMotivoPK invVentasMotivoPK, String vmDetalle, String vmFormaContabilizar, String vmFormaImprimir, boolean vmInactivo, String tipEmpresa, String tipCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invVentasMotivoPK = invVentasMotivoPK;
        this.vmDetalle = vmDetalle;
        this.vmFormaContabilizar = vmFormaContabilizar;
        this.vmFormaImprimir = vmFormaImprimir;
        this.vmInactivo = vmInactivo;
        this.tipEmpresa = tipEmpresa;
        this.tipCodigo = tipCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvVentasMotivo(String vmEmpresa, String vmCodigo) {
        this.invVentasMotivoPK = new InvVentasMotivoPK(vmEmpresa, vmCodigo);
    }

    public InvVentasMotivoPK getInvVentasMotivoPK() {
        return invVentasMotivoPK;
    }

    public void setInvVentasMotivoPK(InvVentasMotivoPK invVentasMotivoPK) {
        this.invVentasMotivoPK = invVentasMotivoPK;
    }

    public String getVmDetalle() {
        return vmDetalle;
    }

    public void setVmDetalle(String vmDetalle) {
        this.vmDetalle = vmDetalle;
    }

    public String getVmFormaContabilizar() {
        return vmFormaContabilizar;
    }

    public void setVmFormaContabilizar(String vmFormaContabilizar) {
        this.vmFormaContabilizar = vmFormaContabilizar;
    }

    public String getVmFormaImprimir() {
        return vmFormaImprimir;
    }

    public void setVmFormaImprimir(String vmFormaImprimir) {
        this.vmFormaImprimir = vmFormaImprimir;
    }

    public boolean getVmInactivo() {
        return vmInactivo;
    }

    public void setVmInactivo(boolean vmInactivo) {
        this.vmInactivo = vmInactivo;
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
        hash += (invVentasMotivoPK != null ? invVentasMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasMotivo)) {
            return false;
        }
        InvVentasMotivo other = (InvVentasMotivo) object;
        if ((this.invVentasMotivoPK == null && other.invVentasMotivoPK != null) || (this.invVentasMotivoPK != null && !this.invVentasMotivoPK.equals(other.invVentasMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasMotivo[ invVentasMotivoPK=" + invVentasMotivoPK + " ]";
    }
    
}
