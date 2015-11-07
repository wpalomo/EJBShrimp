/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_concepto",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxConcepto.findAll", query = "SELECT a FROM AnxConcepto a"),
    @NamedQuery(name = "AnxConcepto.findByConCodigo", query = "SELECT a FROM AnxConcepto a WHERE a.conCodigo = :conCodigo"),
    @NamedQuery(name = "AnxConcepto.findByConConcepto", query = "SELECT a FROM AnxConcepto a WHERE a.conConcepto = :conConcepto"),
    @NamedQuery(name = "AnxConcepto.findByConPorcentaje", query = "SELECT a FROM AnxConcepto a WHERE a.conPorcentaje = :conPorcentaje"),
    @NamedQuery(name = "AnxConcepto.findByConIngresaPorcentaje", query = "SELECT a FROM AnxConcepto a WHERE a.conIngresaPorcentaje = :conIngresaPorcentaje"),
    @NamedQuery(name = "AnxConcepto.findByConFechaInicio", query = "SELECT a FROM AnxConcepto a WHERE a.conFechaInicio = :conFechaInicio"),
    @NamedQuery(name = "AnxConcepto.findByConFechaFin", query = "SELECT a FROM AnxConcepto a WHERE a.conFechaFin = :conFechaFin")})
public class AnxConcepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_codigo")
    private String conCodigo;
    @Column(name = "con_concepto")
    private String conConcepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "con_porcentaje")
    private BigDecimal conPorcentaje;
    @Column(name = "con_ingresa_porcentaje")
    private Character conIngresaPorcentaje;
    @Column(name = "con_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date conFechaInicio;
    @Column(name = "con_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date conFechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conCodigo")
    private List<AnxCompraDividendo> anxCompraDividendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detConcepto")
    private List<AnxCompraDetalle> anxCompraDetalleList;

    public AnxConcepto() {
    }

    public AnxConcepto(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConConcepto() {
        return conConcepto;
    }

    public void setConConcepto(String conConcepto) {
        this.conConcepto = conConcepto;
    }

    public BigDecimal getConPorcentaje() {
        return conPorcentaje;
    }

    public void setConPorcentaje(BigDecimal conPorcentaje) {
        this.conPorcentaje = conPorcentaje;
    }

    public Character getConIngresaPorcentaje() {
        return conIngresaPorcentaje;
    }

    public void setConIngresaPorcentaje(Character conIngresaPorcentaje) {
        this.conIngresaPorcentaje = conIngresaPorcentaje;
    }

    public Date getConFechaInicio() {
        return conFechaInicio;
    }

    public void setConFechaInicio(Date conFechaInicio) {
        this.conFechaInicio = conFechaInicio;
    }

    public Date getConFechaFin() {
        return conFechaFin;
    }

    public void setConFechaFin(Date conFechaFin) {
        this.conFechaFin = conFechaFin;
    }

    public List<AnxCompraDividendo> getAnxCompraDividendoList() {
        return anxCompraDividendoList;
    }

    public void setAnxCompraDividendoList(List<AnxCompraDividendo> anxCompraDividendoList) {
        this.anxCompraDividendoList = anxCompraDividendoList;
    }

    public List<AnxCompraDetalle> getAnxCompraDetalleList() {
        return anxCompraDetalleList;
    }

    public void setAnxCompraDetalleList(List<AnxCompraDetalle> anxCompraDetalleList) {
        this.anxCompraDetalleList = anxCompraDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conCodigo != null ? conCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxConcepto)) {
            return false;
        }
        AnxConcepto other = (AnxConcepto) object;
        if ((this.conCodigo == null && other.conCodigo != null) || (this.conCodigo != null && !this.conCodigo.equals(other.conCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxConcepto[ conCodigo=" + conCodigo + " ]";
    }
    
}
