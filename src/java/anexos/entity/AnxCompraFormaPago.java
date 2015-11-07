/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_compra_forma_pago",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxCompraFormaPago.findAll", query = "SELECT a FROM AnxCompraFormaPago a"),
    @NamedQuery(name = "AnxCompraFormaPago.findByDetSecuencial", query = "SELECT a FROM AnxCompraFormaPago a WHERE a.detSecuencial = :detSecuencial")})
public class AnxCompraFormaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_secuencial")
    private Integer detSecuencial;
    @JoinColumn(name = "fp_codigo", referencedColumnName = "fp_codigo")
    @ManyToOne(optional = false)
    private AnxFormaPago fpCodigo;
    @JoinColumns({
        @JoinColumn(name = "comp_empresa", referencedColumnName = "comp_empresa"),
        @JoinColumn(name = "comp_periodo", referencedColumnName = "comp_periodo"),
        @JoinColumn(name = "comp_motivo", referencedColumnName = "comp_motivo"),
        @JoinColumn(name = "comp_numero", referencedColumnName = "comp_numero")})
    @ManyToOne(optional = false)
    private AnxCompra anxCompra;

    public AnxCompraFormaPago() {
    }

    public AnxCompraFormaPago(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public AnxFormaPago getFpCodigo() {
        return fpCodigo;
    }

    public void setFpCodigo(AnxFormaPago fpCodigo) {
        this.fpCodigo = fpCodigo;
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
        if (!(object instanceof AnxCompraFormaPago)) {
            return false;
        }
        AnxCompraFormaPago other = (AnxCompraFormaPago) object;
        if ((this.detSecuencial == null && other.detSecuencial != null) || (this.detSecuencial != null && !this.detSecuencial.equals(other.detSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxCompraFormaPago[ detSecuencial=" + detSecuencial + " ]";
    }
    
}
