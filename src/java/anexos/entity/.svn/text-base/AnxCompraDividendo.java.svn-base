/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_compra_dividendo",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxCompraDividendo.findAll", query = "SELECT a FROM AnxCompraDividendo a"),
    @NamedQuery(name = "AnxCompraDividendo.findByDivSecuencial", query = "SELECT a FROM AnxCompraDividendo a WHERE a.divSecuencial = :divSecuencial"),
    @NamedQuery(name = "AnxCompraDividendo.findByDivFechaPago", query = "SELECT a FROM AnxCompraDividendo a WHERE a.divFechaPago = :divFechaPago"),
    @NamedQuery(name = "AnxCompraDividendo.findByDivIrAsociado", query = "SELECT a FROM AnxCompraDividendo a WHERE a.divIrAsociado = :divIrAsociado"),
    @NamedQuery(name = "AnxCompraDividendo.findByDivAnioUtilidades", query = "SELECT a FROM AnxCompraDividendo a WHERE a.divAnioUtilidades = :divAnioUtilidades")})
public class AnxCompraDividendo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "div_secuencial")
    private Integer divSecuencial;
    @Basic(optional = false)
    @Column(name = "div_fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date divFechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "div_ir_asociado")
    private BigDecimal divIrAsociado;
    @Basic(optional = false)
    @Column(name = "div_anio_utilidades")
    private String divAnioUtilidades;
    @JoinColumn(name = "con_codigo", referencedColumnName = "con_codigo")
    @ManyToOne(optional = false)
    private AnxConcepto conCodigo;
    @JoinColumns({
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private AnxCompra anxCompra;

    public AnxCompraDividendo() {
    }

    public AnxCompraDividendo(Integer divSecuencial) {
        this.divSecuencial = divSecuencial;
    }

    public AnxCompraDividendo(Integer divSecuencial, Date divFechaPago, BigDecimal divIrAsociado, String divAnioUtilidades) {
        this.divSecuencial = divSecuencial;
        this.divFechaPago = divFechaPago;
        this.divIrAsociado = divIrAsociado;
        this.divAnioUtilidades = divAnioUtilidades;
    }

    public Integer getDivSecuencial() {
        return divSecuencial;
    }

    public void setDivSecuencial(Integer divSecuencial) {
        this.divSecuencial = divSecuencial;
    }

    public Date getDivFechaPago() {
        return divFechaPago;
    }

    public void setDivFechaPago(Date divFechaPago) {
        this.divFechaPago = divFechaPago;
    }

    public BigDecimal getDivIrAsociado() {
        return divIrAsociado;
    }

    public void setDivIrAsociado(BigDecimal divIrAsociado) {
        this.divIrAsociado = divIrAsociado;
    }

    public String getDivAnioUtilidades() {
        return divAnioUtilidades;
    }

    public void setDivAnioUtilidades(String divAnioUtilidades) {
        this.divAnioUtilidades = divAnioUtilidades;
    }

    public AnxConcepto getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(AnxConcepto conCodigo) {
        this.conCodigo = conCodigo;
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
        hash += (divSecuencial != null ? divSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxCompraDividendo)) {
            return false;
        }
        AnxCompraDividendo other = (AnxCompraDividendo) object;
        if ((this.divSecuencial == null && other.divSecuencial != null) || (this.divSecuencial != null && !this.divSecuencial.equals(other.divSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxCompraDividendo[ divSecuencial=" + divSecuencial + " ]";
    }
    
}
