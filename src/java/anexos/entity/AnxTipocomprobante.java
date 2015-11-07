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
@Table(name = "anx_tipocomprobante",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxTipocomprobante.findAll", query = "SELECT a FROM AnxTipocomprobante a"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcCodigo", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcCodigo = :tcCodigo"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcDescripcion", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcDescripcion = :tcDescripcion"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcTransaccion", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcTransaccion = :tcTransaccion"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcSustento", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcSustento = :tcSustento"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcAbreviatura", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcAbreviatura = :tcAbreviatura"),
    @NamedQuery(name = "AnxTipocomprobante.findByTcReporte", query = "SELECT a FROM AnxTipocomprobante a WHERE a.tcReporte = :tcReporte")})
public class AnxTipocomprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tc_codigo")
    private String tcCodigo;
    @Column(name = "tc_descripcion")
    private String tcDescripcion;
    @Column(name = "tc_transaccion")
    private String tcTransaccion;
    @Column(name = "tc_sustento")
    private String tcSustento;
    @Column(name = "tc_abreviatura")
    private String tcAbreviatura;
    @Column(name = "tc_reporte")
    private String tcReporte;
    @OneToMany(mappedBy = "tcCodigo")
    private List<AnxAnulados> anxAnuladosList;

    public AnxTipocomprobante() {
    }

    public AnxTipocomprobante(String tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    public String getTcCodigo() {
        return tcCodigo;
    }

    public void setTcCodigo(String tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    public String getTcDescripcion() {
        return tcDescripcion;
    }

    public void setTcDescripcion(String tcDescripcion) {
        this.tcDescripcion = tcDescripcion;
    }

    public String getTcTransaccion() {
        return tcTransaccion;
    }

    public void setTcTransaccion(String tcTransaccion) {
        this.tcTransaccion = tcTransaccion;
    }

    public String getTcSustento() {
        return tcSustento;
    }

    public void setTcSustento(String tcSustento) {
        this.tcSustento = tcSustento;
    }

    public String getTcAbreviatura() {
        return tcAbreviatura;
    }

    public void setTcAbreviatura(String tcAbreviatura) {
        this.tcAbreviatura = tcAbreviatura;
    }

    public String getTcReporte() {
        return tcReporte;
    }

    public void setTcReporte(String tcReporte) {
        this.tcReporte = tcReporte;
    }

    public List<AnxAnulados> getAnxAnuladosList() {
        return anxAnuladosList;
    }

    public void setAnxAnuladosList(List<AnxAnulados> anxAnuladosList) {
        this.anxAnuladosList = anxAnuladosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcCodigo != null ? tcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxTipocomprobante)) {
            return false;
        }
        AnxTipocomprobante other = (AnxTipocomprobante) object;
        if ((this.tcCodigo == null && other.tcCodigo != null) || (this.tcCodigo != null && !this.tcCodigo.equals(other.tcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxTipocomprobante[ tcCodigo=" + tcCodigo + " ]";
    }
    
}
