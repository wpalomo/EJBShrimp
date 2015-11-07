/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class PrdSectorTO implements Serializable{
    private String secEmpresa;
    private String secCodigo;
    private String secNombre;
    private String secLatitud;
    private String secLongitud;
    private Boolean secActivo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInsertaSector;

    public PrdSectorTO() {
    }

    public PrdSectorTO(String secEmpresa, String secCodigo, String secNombre, String secLatitud, String secLongitud, Boolean secActivo, String usrEmpresa, String usrCodigo, String usrFechaInsertaSector) {
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.secNombre = secNombre;
        this.secLatitud = secLatitud;
        this.secLongitud = secLongitud;
        this.secActivo = secActivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInsertaSector = usrFechaInsertaSector;
    }

    public Boolean getSecActivo() {
        return secActivo;
    }

    public void setSecActivo(Boolean secActivo) {
        this.secActivo = secActivo;
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

    public String getSecLatitud() {
        return secLatitud;
    }

    public void setSecLatitud(String secLatitud) {
        this.secLatitud = secLatitud;
    }

    public String getSecLongitud() {
        return secLongitud;
    }

    public void setSecLongitud(String secLongitud) {
        this.secLongitud = secLongitud;
    }

    public String getSecNombre() {
        return secNombre;
    }

    public void setSecNombre(String secNombre) {
        this.secNombre = secNombre;
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

    public String getUsrFechaInsertaSector() {
        return usrFechaInsertaSector;
    }

    public void setUsrFechaInsertaSector(String usrFechaInsertaSector) {
        this.usrFechaInsertaSector = usrFechaInsertaSector;
    }
}