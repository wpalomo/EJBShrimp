/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_usuario", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisUsuario.findAll", query = "SELECT s FROM SisUsuario s"),
    @NamedQuery(name = "SisUsuario.findByUsrCodigo", query = "SELECT s FROM SisUsuario s WHERE s.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "SisUsuario.findByUsrNick", query = "SELECT s FROM SisUsuario s WHERE s.usrNick = :usrNick"),
    @NamedQuery(name = "SisUsuario.findByUsrNombre", query = "SELECT s FROM SisUsuario s WHERE s.usrNombre = :usrNombre"),
    @NamedQuery(name = "SisUsuario.findByUsrApellido", query = "SELECT s FROM SisUsuario s WHERE s.usrApellido = :usrApellido"),
    @NamedQuery(name = "SisUsuario.findByUsrPassword", query = "SELECT s FROM SisUsuario s WHERE s.usrPassword = :usrPassword"),
    @NamedQuery(name = "SisUsuario.findByUsrCaduca", query = "SELECT s FROM SisUsuario s WHERE s.usrCaduca = :usrCaduca"),
    @NamedQuery(name = "SisUsuario.findByUsrActivo", query = "SELECT s FROM SisUsuario s WHERE s.usrActivo = :usrActivo"),
    @NamedQuery(name = "SisUsuario.findByUsrCambiarContrasenia", query = "SELECT s FROM SisUsuario s WHERE s.usrCambiarContrasenia = :usrCambiarContrasenia"),
    @NamedQuery(name = "SisUsuario.findByUsrCodigoInserta", query = "SELECT s FROM SisUsuario s WHERE s.usrCodigoInserta = :usrCodigoInserta"),
    @NamedQuery(name = "SisUsuario.findByUsrFechaInsertaUsuario", query = "SELECT s FROM SisUsuario s WHERE s.usrFechaInsertaUsuario = :usrFechaInsertaUsuario")})
public class SisUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_nick")
    private String usrNick;
    @Column(name = "usr_nombre")
    private String usrNombre;
    @Column(name = "usr_apellido")
    private String usrApellido;
    @Basic(optional = false)
    @Column(name = "usr_password")
    private String usrPassword;
    @Column(name = "usr_caduca")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrCaduca;
    @Basic(optional = false)
    @Column(name = "usr_activo")
    private boolean usrActivo;
    @Basic(optional = false)
    @Column(name = "usr_cambiar_contrasenia")
    private boolean usrCambiarContrasenia;
    @Column(name = "usr_email_usuario")
    private String usrEmail;
    @Column(name = "usr_email_password")
    private String usrPasswordEmail;
    @Column(name = "usr_codigo_inserta")
    private String usrCodigoInserta;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaUsuario;

    public SisUsuario() {
    }

    public SisUsuario(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public SisUsuario(String usrCodigo, String usrNick, String usrPassword, boolean usrActivo, boolean usrCambiarContrasenia, Date usrFechaInsertaUsuario, String usrEmail, String usrPasswordEmail) {
        this.usrCodigo = usrCodigo;
        this.usrNick = usrNick;
        this.usrPassword = usrPassword;
        this.usrActivo = usrActivo;
        this.usrCambiarContrasenia = usrCambiarContrasenia;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
        this.usrEmail = usrEmail;
        this.usrPasswordEmail = usrPasswordEmail;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrNick() {
        return usrNick;
    }

    public void setUsrNick(String usrNick) {
        this.usrNick = usrNick;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Date getUsrCaduca() {
        return usrCaduca;
    }

    public void setUsrCaduca(Date usrCaduca) {
        this.usrCaduca = usrCaduca;
    }

    public boolean getUsrActivo() {
        return usrActivo;
    }

    public void setUsrActivo(boolean usrActivo) {
        this.usrActivo = usrActivo;
    }

    public boolean getUsrCambiarContrasenia() {
        return usrCambiarContrasenia;
    }

    public void setUsrCambiarContrasenia(boolean usrCambiarContrasenia) {
        this.usrCambiarContrasenia = usrCambiarContrasenia;
    }

    public String getUsrCodigoInserta() {
        return usrCodigoInserta;
    }

    public void setUsrCodigoInserta(String usrCodigoInserta) {
        this.usrCodigoInserta = usrCodigoInserta;
    }

    public Date getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(Date usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrPasswordEmail(String usrPasswordEmail) {
        this.usrPasswordEmail = usrPasswordEmail;
    }

    public String getUsrPasswordEmail() {
        return usrPasswordEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrCodigo != null ? usrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisUsuario)) {
            return false;
        }
        SisUsuario other = (SisUsuario) object;
        if ((this.usrCodigo == null && other.usrCodigo != null) || (this.usrCodigo != null && !this.usrCodigo.equals(other.usrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisUsuario[ usrCodigo=" + usrCodigo + " ]";
    }
}
