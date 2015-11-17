/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class SisUsuarioTO implements Serializable {

    private String usrEmpresa;
    private String usrCodigo;
    private String usrNick;
    private String usrNombre;
    private String usrApellido;
    private String usrPassword;
    private String usrCaduca;
    private Boolean usrActivo;
    private Boolean usrCambiarContrasenia;
    private String gruEmpresa;
    private String gruCodigo;
    private String usrInsertaUsuario;
    private String usrFechaInsertaUsuario;
    private String usrEmail;
    private String usrPasswordEmail;

    public SisUsuarioTO() {
    }

    public SisUsuarioTO(String usrEmpresa, String usrCodigo, String usrNick, String usrNombre, String usrApellido, String usrPassword, String usrCaduca, Boolean usrActivo, Boolean usrCambiarContrasenia, String gruEmpresa, String gruCodigo, String usrInsertaUsuario, String usrFechaInsertaUsuario, String usrEmail, String usrPasswordEmail) {
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrNick = usrNick;
        this.usrNombre = usrNombre;
        this.usrApellido = usrApellido;
        this.usrPassword = usrPassword;
        this.usrCaduca = usrCaduca;
        this.usrActivo = usrActivo;
        this.usrCambiarContrasenia = usrCambiarContrasenia;
        this.gruEmpresa = gruEmpresa;
        this.gruCodigo = gruCodigo;
        this.usrInsertaUsuario = usrInsertaUsuario;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
        this.usrEmail = usrEmail;
        this.usrPasswordEmail = usrPasswordEmail;
    }

    public String getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(String gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public String getGruEmpresa() {
        return gruEmpresa;
    }

    public void setGruEmpresa(String gruEmpresa) {
        this.gruEmpresa = gruEmpresa;
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

    public Boolean getUsrCambiarContrasenia() {
        return usrCambiarContrasenia;
    }

    public void setUsrCambiarContrasenia(Boolean usrCambiarContrasenia) {
        this.usrCambiarContrasenia = usrCambiarContrasenia;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(String usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public String getUsrInsertaUsuario() {
        return usrInsertaUsuario;
    }

    public void setUsrInsertaUsuario(String usrInsertaUsuario) {
        this.usrInsertaUsuario = usrInsertaUsuario;
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

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPasswordEmail() {
        return usrPasswordEmail;
    }

    public void setUsrPasswordEmail(String usrPasswordEmail) {
        this.usrPasswordEmail = usrPasswordEmail;
    }
}