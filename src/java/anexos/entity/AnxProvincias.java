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
@Table(name = "anx_provincias",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxProvincias.findAll", query = "SELECT a FROM AnxProvincias a"),
    @NamedQuery(name = "AnxProvincias.findByProvinciaCodigo", query = "SELECT a FROM AnxProvincias a WHERE a.anxProvinciasPK.provinciaCodigo = :provinciaCodigo"),
    @NamedQuery(name = "AnxProvincias.findByProvinciaNombre", query = "SELECT a FROM AnxProvincias a WHERE a.provinciaNombre = :provinciaNombre"),
    @NamedQuery(name = "AnxProvincias.findByCantonCodigo", query = "SELECT a FROM AnxProvincias a WHERE a.anxProvinciasPK.cantonCodigo = :cantonCodigo"),
    @NamedQuery(name = "AnxProvincias.findByCantonNombre", query = "SELECT a FROM AnxProvincias a WHERE a.cantonNombre = :cantonNombre")})
public class AnxProvincias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnxProvinciasPK anxProvinciasPK;
    @Basic(optional = false)
    @Column(name = "provincia_nombre")
    private String provinciaNombre;
    @Basic(optional = false)
    @Column(name = "canton_nombre")
    private String cantonNombre;

    public AnxProvincias() {
    }

    public AnxProvincias(AnxProvinciasPK anxProvinciasPK) {
        this.anxProvinciasPK = anxProvinciasPK;
    }

    public AnxProvincias(AnxProvinciasPK anxProvinciasPK, String provinciaNombre, String cantonNombre) {
        this.anxProvinciasPK = anxProvinciasPK;
        this.provinciaNombre = provinciaNombre;
        this.cantonNombre = cantonNombre;
    }

    public AnxProvincias(String provinciaCodigo, String cantonCodigo) {
        this.anxProvinciasPK = new AnxProvinciasPK(provinciaCodigo, cantonCodigo);
    }

    public AnxProvinciasPK getAnxProvinciasPK() {
        return anxProvinciasPK;
    }

    public void setAnxProvinciasPK(AnxProvinciasPK anxProvinciasPK) {
        this.anxProvinciasPK = anxProvinciasPK;
    }

    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

    public String getCantonNombre() {
        return cantonNombre;
    }

    public void setCantonNombre(String cantonNombre) {
        this.cantonNombre = cantonNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anxProvinciasPK != null ? anxProvinciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxProvincias)) {
            return false;
        }
        AnxProvincias other = (AnxProvincias) object;
        if ((this.anxProvinciasPK == null && other.anxProvinciasPK != null) || (this.anxProvinciasPK != null && !this.anxProvinciasPK.equals(other.anxProvinciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxProvincias[ anxProvinciasPK=" + anxProvinciasPK + " ]";
    }
    
}
