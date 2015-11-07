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
@Table(name = "anx_pais", schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxPais.findAll", query = "SELECT a FROM AnxPais a"),
    @NamedQuery(name = "AnxPais.findByPaisCodigo", query = "SELECT a FROM AnxPais a WHERE a.paisCodigo = :paisCodigo"),
    @NamedQuery(name = "AnxPais.findByPaisNombre", query = "SELECT a FROM AnxPais a WHERE a.paisNombre = :paisNombre")})
public class AnxPais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pais_codigo")
    private String paisCodigo;
    @Basic(optional = false)
    @Column(name = "pais_nombre")
    private String paisNombre;

    public AnxPais() {
    }

    public AnxPais(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public AnxPais(String paisCodigo, String paisNombre) {
        this.paisCodigo = paisCodigo;
        this.paisNombre = paisNombre;
    }

    public String getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisCodigo != null ? paisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxPais)) {
            return false;
        }
        AnxPais other = (AnxPais) object;
        if ((this.paisCodigo == null && other.paisCodigo != null) || (this.paisCodigo != null && !this.paisCodigo.equals(other.paisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxPais[ paisCodigo=" + paisCodigo + " ]";
    }
    
}
