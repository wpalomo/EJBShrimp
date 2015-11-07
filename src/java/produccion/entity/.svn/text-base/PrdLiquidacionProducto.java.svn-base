/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_liquidacion_producto", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacionProducto.findAll", query = "SELECT p FROM PrdLiquidacionProducto p"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdEmpresa", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prdLiquidacionProductoPK.prodEmpresa = :prodEmpresa"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdCodigo", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prdLiquidacionProductoPK.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdDetalle", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prodDetalle = :prodDetalle"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdTipo", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prodTipo = :prodTipo"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdClase", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prodClase = :prodClase"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByProdInactivo", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.prodInactivo = :prodInactivo"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByUsrEmpresa", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByUsrCodigo", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdLiquidacionProducto.findByUsrFechaInserta", query = "SELECT p FROM PrdLiquidacionProducto p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdLiquidacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdLiquidacionProductoPK prdLiquidacionProductoPK;
    @Basic(optional = false)
    @Column(name = "prod_detalle")
    private String prodDetalle;
    @Basic(optional = false)
    @Column(name = "prod_tipo")
    private String prodTipo;
    @Basic(optional = false)
    @Column(name = "prod_clase")
    private char prodClase;
    @Basic(optional = false)
    @Column(name = "prod_inactivo")
    private boolean prodInactivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdLiquidacionProducto")
    private List<PrdLiquidacionDetalle> prdLiquidacionDetalleList;

    public PrdLiquidacionProducto() {
    }

    public PrdLiquidacionProducto(PrdLiquidacionProductoPK prdLiquidacionProductoPK) {
        this.prdLiquidacionProductoPK = prdLiquidacionProductoPK;
    }

    public PrdLiquidacionProducto(PrdLiquidacionProductoPK prdLiquidacionProductoPK, String prodDetalle, String prodTipo, char prodClase, boolean prodInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdLiquidacionProductoPK = prdLiquidacionProductoPK;
        this.prodDetalle = prodDetalle;
        this.prodTipo = prodTipo;
        this.prodClase = prodClase;
        this.prodInactivo = prodInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdLiquidacionProducto(String prodEmpresa, String prodCodigo) {
        this.prdLiquidacionProductoPK = new PrdLiquidacionProductoPK(prodEmpresa, prodCodigo);
    }

    public PrdLiquidacionProductoPK getPrdLiquidacionProductoPK() {
        return prdLiquidacionProductoPK;
    }

    public void setPrdLiquidacionProductoPK(PrdLiquidacionProductoPK prdLiquidacionProductoPK) {
        this.prdLiquidacionProductoPK = prdLiquidacionProductoPK;
    }

    public String getProdDetalle() {
        return prodDetalle;
    }

    public void setProdDetalle(String prodDetalle) {
        this.prodDetalle = prodDetalle;
    }

    public String getProdTipo() {
        return prodTipo;
    }

    public void setProdTipo(String prodTipo) {
        this.prodTipo = prodTipo;
    }

    public char getProdClase() {
        return prodClase;
    }

    public void setProdClase(char prodClase) {
        this.prodClase = prodClase;
    }

    public boolean getProdInactivo() {
        return prodInactivo;
    }

    public void setProdInactivo(boolean prodInactivo) {
        this.prodInactivo = prodInactivo;
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

    public List<PrdLiquidacionDetalle> getPrdLiquidacionDetalleList() {
        return prdLiquidacionDetalleList;
    }

    public void setPrdLiquidacionDetalleList(List<PrdLiquidacionDetalle> prdLiquidacionDetalleList) {
        this.prdLiquidacionDetalleList = prdLiquidacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdLiquidacionProductoPK != null ? prdLiquidacionProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionProducto)) {
            return false;
        }
        PrdLiquidacionProducto other = (PrdLiquidacionProducto) object;
        if ((this.prdLiquidacionProductoPK == null && other.prdLiquidacionProductoPK != null) || (this.prdLiquidacionProductoPK != null && !this.prdLiquidacionProductoPK.equals(other.prdLiquidacionProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionProducto[ prdLiquidacionProductoPK=" + prdLiquidacionProductoPK + " ]";
    }
    
}
