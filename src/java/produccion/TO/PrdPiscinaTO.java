/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class PrdPiscinaTO implements Serializable{
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;
    private String pisNombre;
    private BigDecimal pisHectareaje;
    private Boolean pisActiva;
    private String secEmpresa;
    private String secCodigo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInsertaPiscina;

    public PrdPiscinaTO() {
    }

    public PrdPiscinaTO(String pisEmpresa, String pisSector, String pisNumero, String pisNombre, BigDecimal pisHectareaje, Boolean pisActiva, String secEmpresa, String secCodigo, String usrEmpresa, String usrCodigo, String usrFechaInsertaPiscina) {
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.pisNombre = pisNombre;
        this.pisHectareaje = pisHectareaje;
        this.pisActiva = pisActiva;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInsertaPiscina = usrFechaInsertaPiscina;
    }

    public Boolean getPisActiva() {
        return pisActiva;
    }

    public void setPisActiva(Boolean pisActiva) {
        this.pisActiva = pisActiva;
    }

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
    }

    public BigDecimal getPisHectareaje() {
        return pisHectareaje;
    }

    public void setPisHectareaje(BigDecimal pisHectareaje) {
        this.pisHectareaje = pisHectareaje;
    }

    public String getPisNombre() {
        return pisNombre;
    }

    public void setPisNombre(String pisNombre) {
        this.pisNombre = pisNombre;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
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

    public String getUsrFechaInsertaPiscina() {
        return usrFechaInsertaPiscina;
    }

    public void setUsrFechaInsertaPiscina(String usrFechaInsertaPiscina) {
        this.usrFechaInsertaPiscina = usrFechaInsertaPiscina;
    }
}
