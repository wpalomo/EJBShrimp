/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_producto_medida", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoMedida.findAll", query = "SELECT i FROM InvProductoMedida i"),
    @NamedQuery(name = "InvProductoMedida.findByMedEmpresa", query = "SELECT i FROM InvProductoMedida i WHERE i.invProductoMedidaPK.medEmpresa = :medEmpresa"),
    @NamedQuery(name = "InvProductoMedida.findByMedCodigo", query = "SELECT i FROM InvProductoMedida i WHERE i.invProductoMedidaPK.medCodigo = :medCodigo"),
    @NamedQuery(name = "InvProductoMedida.findByMedDetalle", query = "SELECT i FROM InvProductoMedida i WHERE i.medDetalle = :medDetalle"),
    @NamedQuery(name = "InvProductoMedida.findByMedConversionLibras", query = "SELECT i FROM InvProductoMedida i WHERE i.medConversionLibras = :medConversionLibras"),
    @NamedQuery(name = "InvProductoMedida.findByMedConversionKilos", query = "SELECT i FROM InvProductoMedida i WHERE i.medConversionKilos = :medConversionKilos"),
    @NamedQuery(name = "InvProductoMedida.findByUsrEmpresa", query = "SELECT i FROM InvProductoMedida i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoMedida.findByUsrCodigo", query = "SELECT i FROM InvProductoMedida i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoMedida.findByUsrFechaInserta", query = "SELECT i FROM InvProductoMedida i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoMedidaPK invProductoMedidaPK;
    @Basic(optional = false)
    @Column(name = "med_detalle")
    private String medDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "med_conversion_libras")
    private BigDecimal medConversionLibras;
    @Column(name = "med_conversion_kilos")
    private BigDecimal medConversionKilos;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoMedida")
    private List<InvProducto> invProductoList;

    public InvProductoMedida() {
    }

    public InvProductoMedida(InvProductoMedidaPK invProductoMedidaPK) {
        this.invProductoMedidaPK = invProductoMedidaPK;
    }

    public InvProductoMedida(InvProductoMedidaPK invProductoMedidaPK, String medDetalle, String usrEmpresa, String usrCodigo) {
        this.invProductoMedidaPK = invProductoMedidaPK;
        this.medDetalle = medDetalle;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
    }

    public InvProductoMedida(String medEmpresa, String medCodigo) {
        this.invProductoMedidaPK = new InvProductoMedidaPK(medEmpresa, medCodigo);
    }

    public InvProductoMedidaPK getInvProductoMedidaPK() {
        return invProductoMedidaPK;
    }

    public void setInvProductoMedidaPK(InvProductoMedidaPK invProductoMedidaPK) {
        this.invProductoMedidaPK = invProductoMedidaPK;
    }

    public String getMedDetalle() {
        return medDetalle;
    }

    public void setMedDetalle(String medDetalle) {
        this.medDetalle = medDetalle;
    }

    public BigDecimal getMedConversionLibras() {
        return medConversionLibras;
    }

    public void setMedConversionLibras(BigDecimal medConversionLibras) {
        this.medConversionLibras = medConversionLibras;
    }

    public BigDecimal getMedConversionKilos() {
        return medConversionKilos;
    }

    public void setMedConversionKilos(BigDecimal medConversionKilos) {
        this.medConversionKilos = medConversionKilos;
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
        hash += (invProductoMedidaPK != null ? invProductoMedidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoMedida)) {
            return false;
        }
        InvProductoMedida other = (InvProductoMedida) object;
        if ((this.invProductoMedidaPK == null && other.invProductoMedidaPK != null) || (this.invProductoMedidaPK != null && !this.invProductoMedidaPK.equals(other.invProductoMedidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoMedida[ invProductoMedidaPK=" + invProductoMedidaPK + " ]";
    }
    
}
