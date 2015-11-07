/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author misayo
 */
public class InvFunListadoClientesTO implements java.io.Serializable{
    private String cliCodigo;
    private Character cliTipoId;
    private String cliId;
    private String cliNombre;
    private String cliRazonSocial;
    private String cliCategoria;
    private String cliProvincia;
    private String cliCiudad;
    private String cliZona;
    private String cliDireccion;
    private String cliTelefono;
    private String cliCelular;
    private String cliEmail;
    private String cliObservaciones;
    private Boolean cliInactivo;

    public InvFunListadoClientesTO() {
    }

    public InvFunListadoClientesTO(String cliCodigo, Character cliTipoId, String cliId, String cliNombre, String cliRazonSocial, String cliCategoria, String cliProvincia, String cliCiudad, String cliZona, String cliDireccion, String cliTelefono, String cliCelular, String cliEmail, String cliObservaciones, Boolean cliInactivo) {
        this.cliCodigo = cliCodigo;
        this.cliTipoId = cliTipoId;
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliRazonSocial = cliRazonSocial;
        this.cliCategoria = cliCategoria;
        this.cliProvincia = cliProvincia;
        this.cliCiudad = cliCiudad;
        this.cliZona = cliZona;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliCelular = cliCelular;
        this.cliEmail = cliEmail;
        this.cliObservaciones = cliObservaciones;
        this.cliInactivo = cliInactivo;
    }

    public String getCliCategoria() {
        return cliCategoria;
    }

    public void setCliCategoria(String cliCategoria) {
        this.cliCategoria = cliCategoria;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliId() {
        return cliId;
    }

    public void setCliId(String cliId) {
        this.cliId = cliId;
    }

    public Boolean getCliInactivo() {
        return cliInactivo;
    }

    public void setCliInactivo(Boolean cliInactivo) {
        this.cliInactivo = cliInactivo;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliObservaciones() {
        return cliObservaciones;
    }

    public void setCliObservaciones(String cliObservaciones) {
        this.cliObservaciones = cliObservaciones;
    }

    public String getCliProvincia() {
        return cliProvincia;
    }

    public void setCliProvincia(String cliProvincia) {
        this.cliProvincia = cliProvincia;
    }

    public String getCliRazonSocial() {
        return cliRazonSocial;
    }

    public void setCliRazonSocial(String cliRazonSocial) {
        this.cliRazonSocial = cliRazonSocial;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public Character getCliTipoId() {
        return cliTipoId;
    }

    public void setCliTipoId(Character cliTipoId) {
        this.cliTipoId = cliTipoId;
    }

    public String getCliZona() {
        return cliZona;
    }

    public void setCliZona(String cliZona) {
        this.cliZona = cliZona;
    }

}
