/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class InvClienteTO implements java.io.Serializable{
    private String empCodigo;
    private String cliCodigo;
    private Character cliTipoId;
    private String cliId;
    private String cliNombre;
    private String cliRazonSocial;
    private String cliProvincia;
    private String cliCiudad;
    private String cliParroquia;
    private String cliZona;
    private String cliDireccion;
    private String cliTelefono;
    private String cliCelular;
    private String cliEmail;
    private Short cliPrecio;
    private Short cliDiasCredito;
    private java.math.BigDecimal cliCupoCredito;
    private String cliObservaciones;
    private Boolean cliRelacionado;
    private Boolean cliInactivo;
    private Integer cliSecuencia;
    private String vendEmpresa;
    private String vendCodigo;
    private String cliCategoria;
    private String usrInsertaCliente;
    private String usrFechaInsertaCliente;
    
    public InvClienteTO() {
    }

    public InvClienteTO(String empCodigo, String cliCodigo, Character cliTipoId, String cliId, String cliNombre, String cliRazonSocial, String cliProvincia, String cliCiudad, String cliParroquia, String cliZona, String cliDireccion, String cliTelefono, String cliCelular, String cliEmail, Short cliPrecio, Short cliDiasCredito, BigDecimal cliCupoCredito, String cliObservaciones, Boolean cliRelacionado, Boolean cliInactivo, Integer cliSecuencia, String vendEmpresa, String vendCodigo, String cliCategoria, String usrInsertaCliente, String usrFechaInsertaCliente) {
        this.empCodigo = empCodigo;
        this.cliCodigo = cliCodigo;
        this.cliTipoId = cliTipoId;
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliRazonSocial = cliRazonSocial;
        this.cliProvincia = cliProvincia;
        this.cliCiudad = cliCiudad;
        this.cliParroquia = cliParroquia;
        this.cliZona = cliZona;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
        this.cliCelular = cliCelular;
        this.cliEmail = cliEmail;
        this.cliPrecio = cliPrecio;
        this.cliDiasCredito = cliDiasCredito;
        this.cliCupoCredito = cliCupoCredito;
        this.cliObservaciones = cliObservaciones;
        this.cliRelacionado = cliRelacionado;
        this.cliInactivo = cliInactivo;
        this.cliSecuencia = cliSecuencia;
        this.vendEmpresa = vendEmpresa;
        this.vendCodigo = vendCodigo;
        this.cliCategoria = cliCategoria;
        this.usrInsertaCliente = usrInsertaCliente;
        this.usrFechaInsertaCliente = usrFechaInsertaCliente;
    }

    public Boolean getCliRelacionado() {
        return cliRelacionado;
    }

    public void setCliRelacionado(Boolean cliRelacionado) {
        this.cliRelacionado = cliRelacionado;
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

    public BigDecimal getCliCupoCredito() {
        return cliCupoCredito;
    }

    public void setCliCupoCredito(BigDecimal cliCupoCredito) {
        this.cliCupoCredito = cliCupoCredito;
    }

    public Short getCliDiasCredito() {
        return cliDiasCredito;
    }

    public void setCliDiasCredito(Short cliDiasCredito) {
        this.cliDiasCredito = cliDiasCredito;
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

    public String getCliParroquia() {
        return cliParroquia;
    }

    public void setCliParroquia(String cliParroquia) {
        this.cliParroquia = cliParroquia;
    }

    public Short getCliPrecio() {
        return cliPrecio;
    }

    public void setCliPrecio(Short cliPrecio) {
        this.cliPrecio = cliPrecio;
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

    public Integer getCliSecuencia() {
        return cliSecuencia;
    }

    public void setCliSecuencia(Integer cliSecuencia) {
        this.cliSecuencia = cliSecuencia;
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

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getUsrFechaInsertaCliente() {
        return usrFechaInsertaCliente;
    }

    public void setUsrFechaInsertaCliente(String usrFechaInsertaCliente) {
        this.usrFechaInsertaCliente = usrFechaInsertaCliente;
    }

    public String getUsrInsertaCliente() {
        return usrInsertaCliente;
    }

    public void setUsrInsertaCliente(String usrInsertaCliente) {
        this.usrInsertaCliente = usrInsertaCliente;
    }

    public String getVendCodigo() {
        return vendCodigo;
    }

    public void setVendCodigo(String vendCodigo) {
        this.vendCodigo = vendCodigo;
    }

    public String getVendEmpresa() {
        return vendEmpresa;
    }

    public void setVendEmpresa(String vendEmpresa) {
        this.vendEmpresa = vendEmpresa;
    }

   
    @Override
    public String toString(){
        return this.empCodigo + " " + this.cliCodigo + " " + this.cliTipoId + " " +
                this.cliId + " " + this.cliNombre + " " + this.cliRazonSocial +
                " " + this.cliProvincia + " " + this.cliCiudad + " " + this.cliZona +
                " " + this.cliDireccion + " " + this.cliTelefono + " " + this.cliCelular +
                this.cliEmail + " " + this.cliPrecio + " " + this.cliDiasCredito +
                " " + this.cliCupoCredito + " " + this.cliObservaciones + " " +
                this.cliInactivo + " " + " " + this.cliSecuencia + " " +
                this.usrInsertaCliente + " " + this.usrFechaInsertaCliente;
    }
}
