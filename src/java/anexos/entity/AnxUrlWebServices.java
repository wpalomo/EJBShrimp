/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_url_web_services", schema = "anexo")
@NamedQueries({
    @NamedQuery(name = "AnxUrlWebServices.findAll", query = "SELECT a FROM AnxUrlWebServices a"),
    @NamedQuery(name = "AnxUrlWebServices.findByUrlSecuencial", query = "SELECT a FROM AnxUrlWebServices a WHERE a.urlSecuencial = :urlSecuencial"),
    @NamedQuery(name = "AnxUrlWebServices.findByUrlAmbienteProduccion", query = "SELECT a FROM AnxUrlWebServices a WHERE a.urlAmbienteProduccion = :urlAmbienteProduccion"),
    @NamedQuery(name = "AnxUrlWebServices.findByUrlAmbientePruebas", query = "SELECT a FROM AnxUrlWebServices a WHERE a.urlAmbientePruebas = :urlAmbientePruebas")})
public class AnxUrlWebServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "url_secuencial")
    private Integer urlSecuencial;
    @Column(name = "url_ambiente_produccion")
    private String urlAmbienteProduccion;
    @Column(name = "url_ambiente_pruebas")
    private String urlAmbientePruebas;

    public AnxUrlWebServices() {
    }

    public AnxUrlWebServices(Integer urlSecuencial) {
        this.urlSecuencial = urlSecuencial;
    }

    public Integer getUrlSecuencial() {
        return urlSecuencial;
    }

    public void setUrlSecuencial(Integer urlSecuencial) {
        this.urlSecuencial = urlSecuencial;
    }

    public String getUrlAmbienteProduccion() {
        return urlAmbienteProduccion;
    }

    public void setUrlAmbienteProduccion(String urlAmbienteProduccion) {
        this.urlAmbienteProduccion = urlAmbienteProduccion;
    }

    public String getUrlAmbientePruebas() {
        return urlAmbientePruebas;
    }

    public void setUrlAmbientePruebas(String urlAmbientePruebas) {
        this.urlAmbientePruebas = urlAmbientePruebas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urlSecuencial != null ? urlSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxUrlWebServices)) {
            return false;
        }
        AnxUrlWebServices other = (AnxUrlWebServices) object;
        if ((this.urlSecuencial == null && other.urlSecuencial != null) || (this.urlSecuencial != null && !this.urlSecuencial.equals(other.urlSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxUrlWebServices[ urlSecuencial=" + urlSecuencial + " ]";
    }
    
}
