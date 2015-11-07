/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_error", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisError.findAll", query = "SELECT s FROM SisError s"),
    @NamedQuery(name = "SisError.findByErSecuencia", query = "SELECT s FROM SisError s WHERE s.erSecuencia = :erSecuencia"),
    @NamedQuery(name = "SisError.findByErSentencia", query = "SELECT s FROM SisError s WHERE s.erSentencia = :erSentencia"),
    @NamedQuery(name = "SisError.findByErClase", query = "SELECT s FROM SisError s WHERE s.erClase = :erClase"),
    @NamedQuery(name = "SisError.findByErArchivo", query = "SELECT s FROM SisError s WHERE s.erArchivo = :erArchivo"),
    @NamedQuery(name = "SisError.findByErLinea", query = "SELECT s FROM SisError s WHERE s.erLinea = :erLinea"),
    @NamedQuery(name = "SisError.findByErMetodo", query = "SELECT s FROM SisError s WHERE s.erMetodo = :erMetodo"),
    @NamedQuery(name = "SisError.findByErMac", query = "SELECT s FROM SisError s WHERE s.erMac = :erMac"),
    @NamedQuery(name = "SisError.findByErFecha", query = "SELECT s FROM SisError s WHERE s.erFecha = :erFecha")})
public class SisError implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "er_secuencia")
    private Integer erSecuencia;
    @Column(name = "er_sentencia")
    private String erSentencia;
    @Column(name = "er_clase")
    private String erClase;
    @Column(name = "er_archivo")
    private String erArchivo;
    @Column(name = "er_linea")
    private String erLinea;
    @Column(name = "er_metodo")
    private String erMetodo;
    @Basic(optional = false)
    @Column(name = "er_mac")
    private String erMac;
    @Basic(optional = false)
    @Column(name = "er_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erFecha;
    @JoinColumns({
        @JoinColumn(name = "det_empresa", referencedColumnName = "det_empresa"),
        @JoinColumn(name = "det_usuario", referencedColumnName = "det_usuario")})
    @ManyToOne(optional = false)
    private SisUsuarioDetalle sisUsuarioDetalle;

    public SisError() {
    }

    public SisError(Integer erSecuencia) {
        this.erSecuencia = erSecuencia;
    }

    public SisError(Integer erSecuencia, String erMac, Date erFecha) {
        this.erSecuencia = erSecuencia;
        this.erMac = erMac;
        this.erFecha = erFecha;
    }

    public Integer getErSecuencia() {
        return erSecuencia;
    }

    public void setErSecuencia(Integer erSecuencia) {
        this.erSecuencia = erSecuencia;
    }

    public String getErSentencia() {
        return erSentencia;
    }

    public void setErSentencia(String erSentencia) {
        this.erSentencia = erSentencia;
    }

    public String getErClase() {
        return erClase;
    }

    public void setErClase(String erClase) {
        this.erClase = erClase;
    }

    public String getErArchivo() {
        return erArchivo;
    }

    public void setErArchivo(String erArchivo) {
        this.erArchivo = erArchivo;
    }

    public String getErLinea() {
        return erLinea;
    }

    public void setErLinea(String erLinea) {
        this.erLinea = erLinea;
    }

    public String getErMetodo() {
        return erMetodo;
    }

    public void setErMetodo(String erMetodo) {
        this.erMetodo = erMetodo;
    }

    public String getErMac() {
        return erMac;
    }

    public void setErMac(String erMac) {
        this.erMac = erMac;
    }

    public Date getErFecha() {
        return erFecha;
    }

    public void setErFecha(Date erFecha) {
        this.erFecha = erFecha;
    }

    public SisUsuarioDetalle getSisUsuarioDetalle() {
        return sisUsuarioDetalle;
    }

    public void setSisUsuarioDetalle(SisUsuarioDetalle sisUsuarioDetalle) {
        this.sisUsuarioDetalle = sisUsuarioDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erSecuencia != null ? erSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisError)) {
            return false;
        }
        SisError other = (SisError) object;
        if ((this.erSecuencia == null && other.erSecuencia != null) || (this.erSecuencia != null && !this.erSecuencia.equals(other.erSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisError[ erSecuencia=" + erSecuencia + " ]";
    }
    
}
