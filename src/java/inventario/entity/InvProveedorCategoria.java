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
@Table(name = "inv_proveedor_categoria", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProveedorCategoria.findAll", query = "SELECT i FROM InvProveedorCategoria i"),
    @NamedQuery(name = "InvProveedorCategoria.findByPcEmpresa", query = "SELECT i FROM InvProveedorCategoria i WHERE i.invProveedorCategoriaPK.pcEmpresa = :pcEmpresa"),
    @NamedQuery(name = "InvProveedorCategoria.findByPcCodigo", query = "SELECT i FROM InvProveedorCategoria i WHERE i.invProveedorCategoriaPK.pcCodigo = :pcCodigo"),
    @NamedQuery(name = "InvProveedorCategoria.findByPcDetalle", query = "SELECT i FROM InvProveedorCategoria i WHERE i.pcDetalle = :pcDetalle"),
    @NamedQuery(name = "InvProveedorCategoria.findByPcAplicaRetencionIva", query = "SELECT i FROM InvProveedorCategoria i WHERE i.pcAplicaRetencionIva = :pcAplicaRetencionIva"),
    @NamedQuery(name = "InvProveedorCategoria.findByUsrEmpresa", query = "SELECT i FROM InvProveedorCategoria i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProveedorCategoria.findByUsrCodigo", query = "SELECT i FROM InvProveedorCategoria i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProveedorCategoria.findByUsrFechaInserta", query = "SELECT i FROM InvProveedorCategoria i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProveedorCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProveedorCategoriaPK invProveedorCategoriaPK;
    @Basic(optional = false)
    @Column(name = "pc_detalle")
    private String pcDetalle;
    @Column(name = "pc_aplica_retencion_iva")
    private Boolean pcAplicaRetencionIva;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProveedorCategoria")
    private List<InvProveedor> invProveedorList;

    public InvProveedorCategoria() {
    }

    public InvProveedorCategoria(InvProveedorCategoriaPK invProveedorCategoriaPK) {
        this.invProveedorCategoriaPK = invProveedorCategoriaPK;
    }

    public InvProveedorCategoria(InvProveedorCategoriaPK invProveedorCategoriaPK, String pcDetalle) {
        this.invProveedorCategoriaPK = invProveedorCategoriaPK;
        this.pcDetalle = pcDetalle;
    }

    public InvProveedorCategoria(String pcEmpresa, String pcCodigo) {
        this.invProveedorCategoriaPK = new InvProveedorCategoriaPK(pcEmpresa, pcCodigo);
    }

    public InvProveedorCategoriaPK getInvProveedorCategoriaPK() {
        return invProveedorCategoriaPK;
    }

    public void setInvProveedorCategoriaPK(InvProveedorCategoriaPK invProveedorCategoriaPK) {
        this.invProveedorCategoriaPK = invProveedorCategoriaPK;
    }

    public String getPcDetalle() {
        return pcDetalle;
    }

    public void setPcDetalle(String pcDetalle) {
        this.pcDetalle = pcDetalle;
    }

    public Boolean getPcAplicaRetencionIva() {
        return pcAplicaRetencionIva;
    }

    public void setPcAplicaRetencionIva(Boolean pcAplicaRetencionIva) {
        this.pcAplicaRetencionIva = pcAplicaRetencionIva;
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

    public List<InvProveedor> getInvProveedorList() {
        return invProveedorList;
    }

    public void setInvProveedorList(List<InvProveedor> invProveedorList) {
        this.invProveedorList = invProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProveedorCategoriaPK != null ? invProveedorCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProveedorCategoria)) {
            return false;
        }
        InvProveedorCategoria other = (InvProveedorCategoria) object;
        if ((this.invProveedorCategoriaPK == null && other.invProveedorCategoriaPK != null) || (this.invProveedorCategoriaPK != null && !this.invProveedorCategoriaPK.equals(other.invProveedorCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProveedorCategoria[ invProveedorCategoriaPK=" + invProveedorCategoriaPK + " ]";
    }
    
}
