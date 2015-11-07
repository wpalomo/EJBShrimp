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
@Table(name = "inv_producto_marca", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoMarca.findAll", query = "SELECT i FROM InvProductoMarca i"),
    @NamedQuery(name = "InvProductoMarca.findByMarEmpresa", query = "SELECT i FROM InvProductoMarca i WHERE i.invProductoMarcaPK.marEmpresa = :marEmpresa"),
    @NamedQuery(name = "InvProductoMarca.findByMarCodigo", query = "SELECT i FROM InvProductoMarca i WHERE i.invProductoMarcaPK.marCodigo = :marCodigo"),
    @NamedQuery(name = "InvProductoMarca.findByMarDetalle", query = "SELECT i FROM InvProductoMarca i WHERE i.marDetalle = :marDetalle"),
    @NamedQuery(name = "InvProductoMarca.findByMarAbreviado", query = "SELECT i FROM InvProductoMarca i WHERE i.marAbreviado = :marAbreviado"),
    @NamedQuery(name = "InvProductoMarca.findByUsrEmpresa", query = "SELECT i FROM InvProductoMarca i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoMarca.findByUsrCodigo", query = "SELECT i FROM InvProductoMarca i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoMarca.findByUsrFechaInserta", query = "SELECT i FROM InvProductoMarca i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoMarca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoMarcaPK invProductoMarcaPK;
    @Basic(optional = false)
    @Column(name = "mar_detalle")
    private String marDetalle;
    @Basic(optional = false)
    @Column(name = "mar_abreviado")
    private String marAbreviado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoMarca")
    private List<InvProducto> invProductoList;

    public InvProductoMarca() {
    }

    public InvProductoMarca(InvProductoMarcaPK invProductoMarcaPK) {
        this.invProductoMarcaPK = invProductoMarcaPK;
    }

    public InvProductoMarca(InvProductoMarcaPK invProductoMarcaPK, String marDetalle, String marAbreviado, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoMarcaPK = invProductoMarcaPK;
        this.marDetalle = marDetalle;
        this.marAbreviado = marAbreviado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoMarca(String marEmpresa, String marCodigo) {
        this.invProductoMarcaPK = new InvProductoMarcaPK(marEmpresa, marCodigo);
    }

    public InvProductoMarcaPK getInvProductoMarcaPK() {
        return invProductoMarcaPK;
    }

    public void setInvProductoMarcaPK(InvProductoMarcaPK invProductoMarcaPK) {
        this.invProductoMarcaPK = invProductoMarcaPK;
    }

    public String getMarDetalle() {
        return marDetalle;
    }

    public void setMarDetalle(String marDetalle) {
        this.marDetalle = marDetalle;
    }

    public String getMarAbreviado() {
        return marAbreviado;
    }

    public void setMarAbreviado(String marAbreviado) {
        this.marAbreviado = marAbreviado;
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

    public List<InvProducto> getInvProductoList() {
        return invProductoList;
    }

    public void setInvProductoList(List<InvProducto> invProductoList) {
        this.invProductoList = invProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProductoMarcaPK != null ? invProductoMarcaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoMarca)) {
            return false;
        }
        InvProductoMarca other = (InvProductoMarca) object;
        if ((this.invProductoMarcaPK == null && other.invProductoMarcaPK != null) || (this.invProductoMarcaPK != null && !this.invProductoMarcaPK.equals(other.invProductoMarcaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoMarca[ invProductoMarcaPK=" + invProductoMarcaPK + " ]";
    }
    
}
