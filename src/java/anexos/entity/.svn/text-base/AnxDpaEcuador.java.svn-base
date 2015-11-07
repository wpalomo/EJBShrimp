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
@Table(name = "anx_dpa_ecuador",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxDpaEcuador.findAll", query = "SELECT a FROM AnxDpaEcuador a"),
    @NamedQuery(name = "AnxDpaEcuador.findByCodigoProvincia", query = "SELECT a FROM AnxDpaEcuador a WHERE a.anxDpaEcuadorPK.codigoProvincia = :codigoProvincia"),
    @NamedQuery(name = "AnxDpaEcuador.findByCodigoCanton", query = "SELECT a FROM AnxDpaEcuador a WHERE a.anxDpaEcuadorPK.codigoCanton = :codigoCanton"),
    @NamedQuery(name = "AnxDpaEcuador.findByCodigoParroquia", query = "SELECT a FROM AnxDpaEcuador a WHERE a.anxDpaEcuadorPK.codigoParroquia = :codigoParroquia"),
    @NamedQuery(name = "AnxDpaEcuador.findByNombreProvincia", query = "SELECT a FROM AnxDpaEcuador a WHERE a.nombreProvincia = :nombreProvincia"),
    @NamedQuery(name = "AnxDpaEcuador.findByNombreCanton", query = "SELECT a FROM AnxDpaEcuador a WHERE a.nombreCanton = :nombreCanton"),
    @NamedQuery(name = "AnxDpaEcuador.findByNombreParroquia", query = "SELECT a FROM AnxDpaEcuador a WHERE a.nombreParroquia = :nombreParroquia")})
public class AnxDpaEcuador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnxDpaEcuadorPK anxDpaEcuadorPK;
    @Basic(optional = false)
    @Column(name = "nombre_provincia")
    private String nombreProvincia;
    @Basic(optional = false)
    @Column(name = "nombre_canton")
    private String nombreCanton;
    @Basic(optional = false)
    @Column(name = "nombre_parroquia")
    private String nombreParroquia;

    public AnxDpaEcuador() {
    }

    public AnxDpaEcuador(AnxDpaEcuadorPK anxDpaEcuadorPK) {
        this.anxDpaEcuadorPK = anxDpaEcuadorPK;
    }

    public AnxDpaEcuador(AnxDpaEcuadorPK anxDpaEcuadorPK, String nombreProvincia, String nombreCanton, String nombreParroquia) {
        this.anxDpaEcuadorPK = anxDpaEcuadorPK;
        this.nombreProvincia = nombreProvincia;
        this.nombreCanton = nombreCanton;
        this.nombreParroquia = nombreParroquia;
    }

    public AnxDpaEcuador(String codigoProvincia, String codigoCanton, String codigoParroquia) {
        this.anxDpaEcuadorPK = new AnxDpaEcuadorPK(codigoProvincia, codigoCanton, codigoParroquia);
    }

    public AnxDpaEcuadorPK getAnxDpaEcuadorPK() {
        return anxDpaEcuadorPK;
    }

    public void setAnxDpaEcuadorPK(AnxDpaEcuadorPK anxDpaEcuadorPK) {
        this.anxDpaEcuadorPK = anxDpaEcuadorPK;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreCanton() {
        return nombreCanton;
    }

    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    public String getNombreParroquia() {
        return nombreParroquia;
    }

    public void setNombreParroquia(String nombreParroquia) {
        this.nombreParroquia = nombreParroquia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anxDpaEcuadorPK != null ? anxDpaEcuadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxDpaEcuador)) {
            return false;
        }
        AnxDpaEcuador other = (AnxDpaEcuador) object;
        if ((this.anxDpaEcuadorPK == null && other.anxDpaEcuadorPK != null) || (this.anxDpaEcuadorPK != null && !this.anxDpaEcuadorPK.equals(other.anxDpaEcuadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxDpaEcuador[ anxDpaEcuadorPK=" + anxDpaEcuadorPK + " ]";
    }
    
}
