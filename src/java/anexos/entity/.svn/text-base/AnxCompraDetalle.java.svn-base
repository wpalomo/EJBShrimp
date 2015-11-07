/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_compra_detalle", schema = "anexo")
@NamedQueries({
    @NamedQuery(name = "AnxCompraDetalle.findAll", query = "SELECT a FROM AnxCompraDetalle a"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetSecuencial", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detSecuencial = :detSecuencial"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetBase0", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detBase0 = :detBase0"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetBaseimponible", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detBaseimponible = :detBaseimponible"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetBasenoobjetoiva", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detBasenoobjetoiva = :detBasenoobjetoiva"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetPorcentaje", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detPorcentaje = :detPorcentaje"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetValorretenido", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detValorretenido = :detValorretenido"),
    @NamedQuery(name = "AnxCompraDetalle.findByDetOrden", query = "SELECT a FROM AnxCompraDetalle a WHERE a.detOrden = :detOrden")})
public class AnxCompraDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencial")
    private Integer detSecuencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "det_base0")
    private BigDecimal detBase0;
    @Basic(optional = false)
    @Column(name = "det_baseimponible")
    private BigDecimal detBaseimponible;
    @Basic(optional = false)
    @Column(name = "det_basenoobjetoiva")
    private BigDecimal detBasenoobjetoiva;
    @Basic(optional = false)
    @Column(name = "det_porcentaje")
    private BigDecimal detPorcentaje;
    @Basic(optional = false)
    @Column(name = "det_valorretenido")
    private BigDecimal detValorretenido;
    @Basic(optional = false)
    @Column(name = "det_orden")
    private int detOrden;
    @JoinColumn(name = "det_concepto", referencedColumnName = "con_codigo")
    @ManyToOne(optional = false)
    private AnxConcepto detConcepto;
    @JoinColumns({
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private AnxCompra anxCompra;

    public AnxCompraDetalle() {
    }

    public AnxCompraDetalle(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public AnxCompraDetalle(Integer detSecuencial, BigDecimal detBase0, BigDecimal detBaseimponible, BigDecimal detBasenoobjetoiva, BigDecimal detPorcentaje, BigDecimal detValorretenido, int detOrden) {
        this.detSecuencial = detSecuencial;
        this.detBase0 = detBase0;
        this.detBaseimponible = detBaseimponible;
        this.detBasenoobjetoiva = detBasenoobjetoiva;
        this.detPorcentaje = detPorcentaje;
        this.detValorretenido = detValorretenido;
        this.detOrden = detOrden;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public BigDecimal getDetBase0() {
        return detBase0;
    }

    public void setDetBase0(BigDecimal detBase0) {
        this.detBase0 = detBase0;
    }

    public BigDecimal getDetBaseimponible() {
        return detBaseimponible;
    }

    public void setDetBaseimponible(BigDecimal detBaseimponible) {
        this.detBaseimponible = detBaseimponible;
    }

    public BigDecimal getDetBasenoobjetoiva() {
        return detBasenoobjetoiva;
    }

    public void setDetBasenoobjetoiva(BigDecimal detBasenoobjetoiva) {
        this.detBasenoobjetoiva = detBasenoobjetoiva;
    }

    public BigDecimal getDetPorcentaje() {
        return detPorcentaje;
    }

    public void setDetPorcentaje(BigDecimal detPorcentaje) {
        this.detPorcentaje = detPorcentaje;
    }

    public BigDecimal getDetValorretenido() {
        return detValorretenido;
    }

    public void setDetValorretenido(BigDecimal detValorretenido) {
        this.detValorretenido = detValorretenido;
    }

    public int getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(int detOrden) {
        this.detOrden = detOrden;
    }

    public AnxConcepto getDetConcepto() {
        return detConcepto;
    }

    public void setDetConcepto(AnxConcepto detConcepto) {
        this.detConcepto = detConcepto;
    }

    public AnxCompra getAnxCompra() {
        return anxCompra;
    }

    public void setAnxCompra(AnxCompra anxCompra) {
        this.anxCompra = anxCompra;
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
        if (!(object instanceof AnxCompraDetalle)) {
            return false;
        }
        AnxCompraDetalle other = (AnxCompraDetalle) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxCompraDetalle[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
