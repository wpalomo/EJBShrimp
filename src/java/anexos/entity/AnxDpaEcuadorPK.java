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
public class AnxDpaEcuadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codigo_provincia")
    private String codigoProvincia;
    @Basic(optional = false)
    @Column(name = "codigo_canton")
    private String codigoCanton;
    @Basic(optional = false)
    @Column(name = "codigo_parroquia")
    private String codigoParroquia;

    public AnxDpaEcuadorPK() {
    }

    public AnxDpaEcuadorPK(String codigoProvincia, String codigoCanton, String codigoParroquia) {
        this.codigoProvincia = codigoProvincia;
        this.codigoCanton = codigoCanton;
        this.codigoParroquia = codigoParroquia;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(String codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public String getCodigoParroquia() {
        return codigoParroquia;
    }

    public void setCodigoParroquia(String codigoParroquia) {
        this.codigoParroquia = codigoParroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProvincia != null ? codigoProvincia.hashCode() : 0);
        hash += (codigoCanton != null ? codigoCanton.hashCode() : 0);
        hash += (codigoParroquia != null ? codigoParroquia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxDpaEcuadorPK)) {
            return false;
        }
        AnxDpaEcuadorPK other = (AnxDpaEcuadorPK) object;
        if ((this.codigoProvincia == null && other.codigoProvincia != null) || (this.codigoProvincia != null && !this.codigoProvincia.equals(other.codigoProvincia))) {
            return false;
        }
        if ((this.codigoCanton == null && other.codigoCanton != null) || (this.codigoCanton != null && !this.codigoCanton.equals(other.codigoCanton))) {
            return false;
        }
        if ((this.codigoParroquia == null && other.codigoParroquia != null) || (this.codigoParroquia != null && !this.codigoParroquia.equals(other.codigoParroquia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxDpaEcuadorPK[ codigoProvincia=" + codigoProvincia + ", codigoCanton=" + codigoCanton + ", codigoParroquia=" + codigoParroquia + " ]";
    }
    
}
