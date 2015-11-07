/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_forma_pago", schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxFormaPago.findAll", query = "SELECT a FROM AnxFormaPago a"),
    @NamedQuery(name = "AnxFormaPago.findByFpCodigo", query = "SELECT a FROM AnxFormaPago a WHERE a.fpCodigo = :fpCodigo"),
    @NamedQuery(name = "AnxFormaPago.findByFpDetalle", query = "SELECT a FROM AnxFormaPago a WHERE a.fpDetalle = :fpDetalle")})
public class AnxFormaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fp_codigo")
    private String fpCodigo;
    @Basic(optional = false)
    @Column(name = "fp_detalle")
    private String fpDetalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fpCodigo")
    private List<AnxCompraFormaPago> anxCompraFormaPagoList;

    public AnxFormaPago() {
    }

    public AnxFormaPago(String fpCodigo) {
        this.fpCodigo = fpCodigo;
    }

    public AnxFormaPago(String fpCodigo, String fpDetalle) {
        this.fpCodigo = fpCodigo;
        this.fpDetalle = fpDetalle;
    }

    public String getFpCodigo() {
        return fpCodigo;
    }

    public void setFpCodigo(String fpCodigo) {
        this.fpCodigo = fpCodigo;
    }

    public String getFpDetalle() {
        return fpDetalle;
    }

    public void setFpDetalle(String fpDetalle) {
        this.fpDetalle = fpDetalle;
    }

    public List<AnxCompraFormaPago> getAnxCompraFormaPagoList() {
        return anxCompraFormaPagoList;
    }

    public void setAnxCompraFormaPagoList(List<AnxCompraFormaPago> anxCompraFormaPagoList) {
        this.anxCompraFormaPagoList = anxCompraFormaPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpCodigo != null ? fpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxFormaPago)) {
            return false;
        }
        AnxFormaPago other = (AnxFormaPago) object;
        if ((this.fpCodigo == null && other.fpCodigo != null) || (this.fpCodigo != null && !this.fpCodigo.equals(other.fpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxFormaPago[ fpCodigo=" + fpCodigo + " ]";
    }
    
}
