/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author jack
 */
public class SisConsultaUsuarioGrupoTO implements Serializable {

    private String usrCodigo;
    private String usrNick;
    private String usrNombre;
    private String usrApellido;
    private String usrPassword;
    private String usrCaduca;
    private Boolean usrActivo;
    private Boolean usrCambiarContraseña;
    private String usrCodigoInserta;
    private String usrFechaInsertaUsuario;
    private String gruCodigo;
    private String usrEmail;
    private String usrPasswordEmail;

    public SisConsultaUsuarioGrupoTO() {
    }

    public SisConsultaUsuarioGrupoTO(String usrCodigo, String usrNick, String usrNombre, String usrApellido, String usrPassword, String usrCaduca, Boolean usrActivo, Boolean usrCambiarContraseña, String usrCodigoInserta, String usrFechaInsertaUsuario, String gruCodigo, String usrEmail, String usrPasswordEmail) {
        this.usrCodigo = usrCodigo;
        this.usrNick = usrNick;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrPassword = usrPassword;
        this.usrCaduca = usrCaduca;
        this.usrActivo = usrActivo;
        this.usrCambiarContraseña = usrCambiarContraseña;
        this.usrCodigoInserta = usrCodigoInserta;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
        this.gruCodigo = gruCodigo;
        this.usrEmail = usrEmail;
        this.usrPasswordEmail = usrPasswordEmail;
    }

    public Boolean getUsrActivo() {
        return usrActivo;
    }

    public void setUsrActivo(Boolean usrActivo) {
        this.usrActivo = usrActivo;
    }

    public String getUsrApellido() {
        return usrApellido;
    }

    public void setUsrApellido(String usrApellido) {
        this.usrApellido = usrApellido;
    }

    public String getUsrCaduca() {
        return usrCaduca;
    }

    public void setUsrCaduca(String usrCaduca) {
        this.usrCaduca = usrCaduca;
    }

    public Boolean getUsrCambiarContraseña() {
        return usrCambiarContraseña;
    }

    public void setUsrCambiarContraseña(Boolean usrCambiarContraseña) {
        this.usrCambiarContraseña = usrCambiarContraseña;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrCodigoInserta() {
        return usrCodigoInserta;
    }

    public void setUsrCodigoInserta(String usrCodigoInserta) {
        this.usrCodigoInserta = usrCodigoInserta;
    }

    public String getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(String usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
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

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(String gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public String setUsrEmail(String usrEmail) {
        return this.usrEmail = usrEmail;
    }

    public String getUsrPasswordEmail() {
        return usrPasswordEmail;
    }

    public String setUsrPasswordEmail(String usrPasswordEmail) {
        return this.usrPasswordEmail = usrPasswordEmail;
    }
}
