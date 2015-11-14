/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.TO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author paca94
 */
public class SisEmpresaTO implements Serializable {

    private String empCodigo;
    private String empRuc;
    private String empNombre;
    private String empRazonSocial;
    private String empDireccion;
    private String empCiudad;
    private String empTelefono;
    private String empFax;
    private String empEmail;
    private String empClave;
    private byte[] empLogo;
    private String emResolucionContribuyenteEspecial;
    private Boolean emObligadoLlevarContabilidad;
    private String empGerente;
    private Character empTipoIdGerente;
    private String empIdGerente;
    private String empContador;
    private String empRucContador;
    private Boolean empActiva;
    private String usrInsertaUsuario;
    private Date usrFechaInsertaUsuario;
    //empresa parametros
    private String parActividad;
    private String parEscogerPrecioPor;
    private String parFinanciero;
    private String parFinancieroId;
    private short parColumnasEstadosFinancieros;
    private String parCodigoDinardap;

    public SisEmpresaTO() {
    }

    public SisEmpresaTO(String empCodigo, String empRuc, String empNombre, String empRazonSocial, String empDireccion, 
            String empCiudad, String empTelefono, String empFax, String empEmail, String empClave, byte[] empLogo, String emResolucionContribuyenteEspecial, Boolean emObligadoLlevarContabilidad, String empGerente, Character empTipoIdGerente, String empIdGerente, String empContador, String empRucContador, Boolean empActiva, String usrInsertaUsuario, Date usrFechaInsertaUsuario, String parActividad, String parEscogerPrecioPor, String parFinanciero, String parFinancieroId, short parColumnasEstadosFinancieros, String parCodigoDinardap) {
        this.empCodigo = empCodigo;
        this.empRuc = empRuc;
        this.empNombre = empNombre;
        this.empRazonSocial = empRazonSocial;
        this.empDireccion = empDireccion;
        this.empCiudad = empCiudad;
        this.empTelefono = empTelefono;
        this.empFax = empFax;
        this.empEmail = empEmail;
        this.empClave = empClave;
        this.empLogo = empLogo;
        this.emResolucionContribuyenteEspecial = emResolucionContribuyenteEspecial;
        this.emObligadoLlevarContabilidad = emObligadoLlevarContabilidad;
        this.empGerente = empGerente;
        this.empTipoIdGerente = empTipoIdGerente;
        this.empIdGerente = empIdGerente;
        this.empContador = empContador;
        this.empRucContador = empRucContador;
        this.empActiva = empActiva;
        this.usrInsertaUsuario = usrInsertaUsuario;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
        this.parActividad = parActividad;
        this.parEscogerPrecioPor = parEscogerPrecioPor;
        this.parFinanciero = parFinanciero;
        this.parFinancieroId = parFinancieroId;
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
        this.parCodigoDinardap = parCodigoDinardap;
    }

    public String getParCodigoDinardap() {
        return parCodigoDinardap;
    }

    public void setParCodigoDinardap(String parCodigoDinardap) {
        this.parCodigoDinardap = parCodigoDinardap;
    }

    public short getParColumnasEstadosFinancieros() {
        return parColumnasEstadosFinancieros;
    }

    public void setParColumnasEstadosFinancieros(short parColumnasEstadosFinancieros) {
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
    }

    public String getParFinanciero() {
        return parFinanciero;
    }

    public void setParFinanciero(String parFinanciero) {
        this.parFinanciero = parFinanciero;
    }

    public String getParFinancieroId() {
        return parFinancieroId;
    }

    public void setParFinancieroId(String parFinancieroId) {
        this.parFinancieroId = parFinancieroId;
    }

    public Boolean getEmObligadoLlevarContabilidad() {
        return emObligadoLlevarContabilidad;
    }

    public void setEmObligadoLlevarContabilidad(Boolean emObligadoLlevarContabilidad) {
        this.emObligadoLlevarContabilidad = emObligadoLlevarContabilidad;
    }

    public String getEmResolucionContribuyenteEspecial() {
        return emResolucionContribuyenteEspecial;
    }

    public void setEmResolucionContribuyenteEspecial(String emResolucionContribuyenteEspecial) {
        this.emResolucionContribuyenteEspecial = emResolucionContribuyenteEspecial;
    }

    public Boolean getEmpActiva() {
        return empActiva;
    }

    public void setEmpActiva(Boolean empActiva) {
        this.empActiva = empActiva;
    }

    public String getEmpCiudad() {
        return empCiudad;
    }

    public void setEmpCiudad(String empCiudad) {
        this.empCiudad = empCiudad;
    }

    public String getEmpClave() {
        return empClave;
    }

    public void setEmpClave(String empClave) {
        this.empClave = empClave;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpContador() {
        return empContador;
    }

    public void setEmpContador(String empContador) {
        this.empContador = empContador;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpFax() {
        return empFax;
    }

    public void setEmpFax(String empFax) {
        this.empFax = empFax;
    }

    public String getEmpGerente() {
        return empGerente;
    }

    public void setEmpGerente(String empGerente) {
        this.empGerente = empGerente;
    }

    public String getEmpIdGerente() {
        return empIdGerente;
    }

    public void setEmpIdGerente(String empIdGerente) {
        this.empIdGerente = empIdGerente;
    }

    public byte[] getEmpLogo() {
        return empLogo;
    }

    public void setEmpLogo(byte[] empLogo) {
        this.empLogo = empLogo;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpRazonSocial() {
        return empRazonSocial;
    }

    public void setEmpRazonSocial(String empRazonSocial) {
        this.empRazonSocial = empRazonSocial;
    }

    public String getEmpRuc() {
        return empRuc;
    }

    public void setEmpRuc(String empRuc) {
        this.empRuc = empRuc;
    }

    public String getEmpRucContador() {
        return empRucContador;
    }

    public void setEmpRucContador(String empRucContador) {
        this.empRucContador = empRucContador;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public Character getEmpTipoIdGerente() {
        return empTipoIdGerente;
    }

    public void setEmpTipoIdGerente(Character empTipoIdGerente) {
        this.empTipoIdGerente = empTipoIdGerente;
    }

    public String getParActividad() {
        return parActividad;
    }

    public void setParActividad(String parActividad) {
        this.parActividad = parActividad;
    }

    public String getParEscogerPrecioPor() {
        return parEscogerPrecioPor;
    }

    public void setParEscogerPrecioPor(String parEscogerPrecioPor) {
        this.parEscogerPrecioPor = parEscogerPrecioPor;
    }

    public Date getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(Date usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public String getUsrInsertaUsuario() {
        return usrInsertaUsuario;
    }

    public void setUsrInsertaUsuario(String usrInsertaUsuario) {
        this.usrInsertaUsuario = usrInsertaUsuario;
    }

    @Override
    public String toString() {
        return this.empNombre;
    }
}
