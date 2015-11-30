/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_producto_tipo", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoTipo.findAll", query = "SELECT i FROM InvProductoTipo i"),
    @NamedQuery(name = "InvProductoTipo.findByTipEmpresa", query = "SELECT i FROM InvProductoTipo i WHERE i.invProductoTipoPK.tipEmpresa = :tipEmpresa"),
    @NamedQuery(name = "InvProductoTipo.findByTipCodigo", query = "SELECT i FROM InvProductoTipo i WHERE i.invProductoTipoPK.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "InvProductoTipo.findByTipDetalle", query = "SELECT i FROM InvProductoTipo i WHERE i.tipDetalle = :tipDetalle"),
    @NamedQuery(name = "InvProductoTipo.findByTipTipo", query = "SELECT i FROM InvProductoTipo i WHERE i.tipTipo = :tipTipo"),
    @NamedQuery(name = "InvProductoTipo.findByTipActivo", query = "SELECT i FROM InvProductoTipo i WHERE i.tipActivo = :tipActivo"),
    @NamedQuery(name = "InvProductoTipo.findByUsrEmpresa", query = "SELECT i FROM InvProductoTipo i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoTipo.findByUsrCodigo", query = "SELECT i FROM InvProductoTipo i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoTipo.findByUsrFechaInserta", query = "SELECT i FROM InvProductoTipo i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoTipoPK invProductoTipoPK;
    @Basic(optional = false)
    @Column(name = "tip_detalle")
    private String tipDetalle;
    @Basic(optional = false)
    @Column(name = "tip_tipo")
    private String tipTipo;
    @Basic(optional = false)
    @Column(name = "tip_activo")
    private boolean tipActivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoTipo")
    private List<InvProductoTipoDetalleCuentas> invProductoTipoDetalleCuentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoTipo")
    private List<InvProducto> invProductoList;

    public InvProductoTipo() {
    }

    public InvProductoTipo(InvProductoTipoPK invProductoTipoPK) {
        this.invProductoTipoPK = invProductoTipoPK;
    }

    public InvProductoTipo(InvProductoTipoPK invProductoTipoPK, String tipDetalle, String tipTipo, boolean tipActivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoTipoPK = invProductoTipoPK;
        this.tipDetalle = tipDetalle;
        this.tipTipo = tipTipo;
        this.tipActivo = tipActivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoTipo(String tipEmpresa, String tipCodigo) {
        this.invProductoTipoPK = new InvProductoTipoPK(tipEmpresa, tipCodigo);
    }

    public InvProductoTipoPK getInvProductoTipoPK() {
        return invProductoTipoPK;
    }

    public void setInvProductoTipoPK(InvProductoTipoPK invProductoTipoPK) {
        this.invProductoTipoPK = invProductoTipoPK;
    }

    public String getTipDetalle() {
        return tipDetalle;
    }

    public void setTipDetalle(String tipDetalle) {
        this.tipDetalle = tipDetalle;
    }

    public String getTipTipo() {
        return tipTipo;
    }

    public void setTipTipo(String tipTipo) {
        this.tipTipo = tipTipo;
    }

    public boolean getTipActivo() {
        return tipActivo;
    }

    public void setTipActivo(boolean tipActivo) {
        this.tipActivo = tipActivo;
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

    public List<InvProductoTipoDetalleCuentas> getInvProductoTipoDetalleCuentasList() {
        return invProductoTipoDetalleCuentasList;
    }

    public void setInvProductoTipoDetalleCuentasList(List<InvProductoTipoDetalleCuentas> invProductoTipoDetalleCuentasList) {
        this.invProductoTipoDetalleCuentasList = invProductoTipoDetalleCuentasList;
    }

    public List<InvProducto> getInvProductoList() {
        return invProductoList;
    }

    public void setInvProductoList(List<InvProducto> invProductoList) {
        this.invProductoList = invProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProductoTipoPK != null ? invProductoTipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoTipo)) {
            return false;
        }
        InvProductoTipo other = (InvProductoTipo) object;
        if ((this.invProductoTipoPK == null && other.invProductoTipoPK != null) || (this.invProductoTipoPK != null && !this.invProductoTipoPK.equals(other.invProductoTipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoTipo[ invProductoTipoPK=" + invProductoTipoPK + " ]";
    }
    
}
