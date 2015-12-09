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
public class PrdListaSectorTO implements Serializable{

    private String secCodigo;
    private String nomSector;
    private String secLatitud;
    private String secLongitud;
    private Boolean secActivo;

    public PrdListaSectorTO() {
    }

    public PrdListaSectorTO(String secCodigo, String nomSector, String secLatitud, String secLongitud, Boolean secActivo) {
        this.secCodigo = secCodigo;
        this.nomSector = nomSector;
        this.secLatitud = secLatitud;
        this.secLongitud = secLongitud;
        this.secActivo = secActivo;
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
        return nomSector;
    }

    public void setSecNombre(String nomSector) {
        this.nomSector = nomSector;
    }

    @Override
    public String toString(){
        return this.secCodigo + " " + this.nomSector;
    }

}