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
@Table(name = "inv_producto_categoria", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoCategoria.findAll", query = "SELECT i FROM InvProductoCategoria i"),
    @NamedQuery(name = "InvProductoCategoria.findByCatEmpresa", query = "SELECT i FROM InvProductoCategoria i WHERE i.invProductoCategoriaPK.catEmpresa = :catEmpresa"),
    @NamedQuery(name = "InvProductoCategoria.findByCatCodigo", query = "SELECT i FROM InvProductoCategoria i WHERE i.invProductoCategoriaPK.catCodigo = :catCodigo"),
    @NamedQuery(name = "InvProductoCategoria.findByCatDetalle", query = "SELECT i FROM InvProductoCategoria i WHERE i.catDetalle = :catDetalle"),
    @NamedQuery(name = "InvProductoCategoria.findByCatPrecioFijo", query = "SELECT i FROM InvProductoCategoria i WHERE i.catPrecioFijo = :catPrecioFijo"),
    @NamedQuery(name = "InvProductoCategoria.findByCatActiva", query = "SELECT i FROM InvProductoCategoria i WHERE i.catActiva = :catActiva"),
    @NamedQuery(name = "InvProductoCategoria.findByCtaEmpresa", query = "SELECT i FROM InvProductoCategoria i WHERE i.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "InvProductoCategoria.findByCtaCodigo", query = "SELECT i FROM InvProductoCategoria i WHERE i.ctaCodigo = :ctaCodigo"),
    @NamedQuery(name = "InvProductoCategoria.findByUsrEmpresa", query = "SELECT i FROM InvProductoCategoria i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoCategoria.findByUsrCodigo", query = "SELECT i FROM InvProductoCategoria i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoCategoria.findByUsrFechaInserta", query = "SELECT i FROM InvProductoCategoria i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoCategoriaPK invProductoCategoriaPK;
    @Basic(optional = false)
    @Column(name = "cat_detalle")
    private String catDetalle;
    @Column(name = "cat_precio_fijo")
    private Boolean catPrecioFijo;
    @Column(name = "cat_activa")
    private Boolean catActiva;
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Column(name = "cta_codigo")
    private String ctaCodigo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoCategoria")
    private List<InvProducto> invProductoList;

    public InvProductoCategoria() {
    }

    public InvProductoCategoria(InvProductoCategoriaPK invProductoCategoriaPK) {
        this.invProductoCategoriaPK = invProductoCategoriaPK;
    }

    public InvProductoCategoria(InvProductoCategoriaPK invProductoCategoriaPK, String catDetalle, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoCategoriaPK = invProductoCategoriaPK;
        this.catDetalle = catDetalle;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoCategoria(String catEmpresa, String catCodigo) {
        this.invProductoCategoriaPK = new InvProductoCategoriaPK(catEmpresa, catCodigo);
    }

    public InvProductoCategoriaPK getInvProductoCategoriaPK() {
        return invProductoCategoriaPK;
    }

    public void setInvProductoCategoriaPK(InvProductoCategoriaPK invProductoCategoriaPK) {
        this.invProductoCategoriaPK = invProductoCategoriaPK;
    }

    public String getCatDetalle() {
        return catDetalle;
    }

    public void setCatDetalle(String catDetalle) {
        this.catDetalle = catDetalle;
    }

    public Boolean getCatPrecioFijo() {
        return catPrecioFijo;
    }

    public void setCatPrecioFijo(Boolean catPrecioFijo) {
        this.catPrecioFijo = catPrecioFijo;
    }

    public Boolean getCatActiva() {
        return catActiva;
    }

    public void setCatActiva(Boolean catActiva) {
        this.catActiva = catActiva;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaCodigo() {
        return ctaCodigo;
    }

    public void setCtaCodigo(String ctaCodigo) {
        this.ctaCodigo = ctaCodigo;
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
        hash += (invProductoCategoriaPK != null ? invProductoCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoCategoria)) {
            return false;
        }
        InvProductoCategoria other = (InvProductoCategoria) object;
        if ((this.invProductoCategoriaPK == null && other.invProductoCategoriaPK != null) || (this.invProductoCategoriaPK != null && !this.invProductoCategoriaPK.equals(other.invProductoCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoCategoria[ invProductoCategoriaPK=" + invProductoCategoriaPK + " ]";
    }
    
}
