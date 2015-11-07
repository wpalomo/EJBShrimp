/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_liquidacion_detalle", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacionDetalle.findAll", query = "SELECT p FROM PrdLiquidacionDetalle p"),
    @NamedQuery(name = "PrdLiquidacionDetalle.findByDetSecuencial", query = "SELECT p FROM PrdLiquidacionDetalle p WHERE p.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "PrdLiquidacionDetalle.findByDetOrden", query = "SELECT p FROM PrdLiquidacionDetalle p WHERE p.detOrden = :detOrden"),
    @NamedQuery(name = "PrdLiquidacionDetalle.findByDetLibras", query = "SELECT p FROM PrdLiquidacionDetalle p WHERE p.detLibras = :detLibras"),
    @NamedQuery(name = "PrdLiquidacionDetalle.findByDetPrecio", query = "SELECT p FROM PrdLiquidacionDetalle p WHERE p.detPrecio = :detPrecio")})
public class PrdLiquidacionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencial")
    private Integer detSecuencial;
    @Basic(optional = false)
    @Column(name = "det_orden")
    private int detOrden;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "det_libras")
    private BigDecimal detLibras;
    @Basic(optional = false)
    @Column(name = "det_precio")
    private BigDecimal detPrecio;
    @JoinColumns({
        @JoinColumn(name = "talla_empresa", referencedColumnName = "talla_empresa"),
        @JoinColumn(name = "talla_codigo", referencedColumnName = "talla_codigo")})
    @ManyToOne(optional = false)
    private PrdLiquidacionTalla prdLiquidacionTalla;
    @JoinColumns({
        @JoinColumn(name = "prod_empresa", referencedColumnName = "prod_empresa"),
        @JoinColumn(name = "prod_codigo", referencedColumnName = "prod_codigo")})
    @ManyToOne(optional = false)
    private PrdLiquidacionProducto prdLiquidacionProducto;
    @JoinColumns({
        @JoinColumn(name = "liq_empresa", referencedColumnName = "liq_empresa"),
        @JoinColumn(name = "liq_motivo", referencedColumnName = "liq_motivo"),
        @JoinColumn(name = "liq_numero", referencedColumnName = "liq_numero")})
    @ManyToOne(optional = false)
    private PrdLiquidacion prdLiquidacion;

    public PrdLiquidacionDetalle() {
    }

    public PrdLiquidacionDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public PrdLiquidacionDetalle(Integer detSecuencial, int detOrden, BigDecimal detLibras, BigDecimal detPrecio) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detLibras = detLibras;
        this.detPrecio = detPrecio;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public int getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(int detOrden) {
        this.detOrden = detOrden;
    }

    public BigDecimal getDetLibras() {
        return detLibras;
    }

    public void setDetLibras(BigDecimal detLibras) {
        this.detLibras = detLibras;
    }

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public PrdLiquidacionTalla getPrdLiquidacionTalla() {
        return prdLiquidacionTalla;
    }

    public void setPrdLiquidacionTalla(PrdLiquidacionTalla prdLiquidacionTalla) {
        this.prdLiquidacionTalla = prdLiquidacionTalla;
    }

    public PrdLiquidacionProducto getPrdLiquidacionProducto() {
        return prdLiquidacionProducto;
    }

    public void setPrdLiquidacionProducto(PrdLiquidacionProducto prdLiquidacionProducto) {
        this.prdLiquidacionProducto = prdLiquidacionProducto;
    }

    public PrdLiquidacion getPrdLiquidacion() {
        return prdLiquidacion;
    }

    public void setPrdLiquidacion(PrdLiquidacion prdLiquidacion) {
        this.prdLiquidacion = prdLiquidacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detSecuencial != null ? detSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionDetalle)) {
            return false;
        }
        PrdLiquidacionDetalle other = (PrdLiquidacionDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
