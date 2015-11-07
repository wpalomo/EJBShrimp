/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class AnxProvinciasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "provincia_codigo")
    private String provinciaCodigo;
    @Basic(optional = false)
    @Column(name = "canton_codigo")
    private String cantonCodigo;

    public AnxProvinciasPK() {
    }

    public AnxProvinciasPK(String provinciaCodigo, String cantonCodigo) {
        this.provinciaCodigo = provinciaCodigo;
        this.cantonCodigo = cantonCodigo;
    }

    public String getProvinciaCodigo() {
        return provinciaCodigo;
    }

    public void setProvinciaCodigo(String provinciaCodigo) {
        this.provinciaCodigo = provinciaCodigo;
    }

    public String getCantonCodigo() {
        return cantonCodigo;
    }

    public void setCantonCodigo(String cantonCodigo) {
        this.cantonCodigo = cantonCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaCodigo != null ? provinciaCodigo.hashCode() : 0);
        hash += (cantonCodigo != null ? cantonCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxProvinciasPK)) {
            return false;
        }
        AnxProvinciasPK other = (AnxProvinciasPK) object;
        if ((this.provinciaCodigo == null && other.provinciaCodigo != null) || (this.provinciaCodigo != null && !this.provinciaCodigo.equals(other.provinciaCodigo))) {
            return false;
        }
        if ((this.cantonCodigo == null && other.cantonCodigo != null) || (this.cantonCodigo != null && !this.cantonCodigo.equals(other.cantonCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxProvinciasPK[ provinciaCodigo=" + provinciaCodigo + ", cantonCodigo=" + cantonCodigo + " ]";
    }
    
}
