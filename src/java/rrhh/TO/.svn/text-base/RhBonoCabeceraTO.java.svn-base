/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class RhBonoCabeceraTO implements Serializable{
    private String empCodigo;
    private String bonoFecha;
    private String conObservaciones;
    private Boolean reversar;
    private String usrInsertaBono;

    public RhBonoCabeceraTO() {
    }

    public RhBonoCabeceraTO(String empCodigo, String bonoFecha, String conObservaciones, Boolean reversar, String usrInsertaBono) {
        this.empCodigo = empCodigo;
        this.bonoFecha = bonoFecha;
        this.conObservaciones = conObservaciones;
        this.reversar = reversar;
        this.usrInsertaBono = usrInsertaBono;
    }

    public String getBonoFecha() {
        return bonoFecha;
    }

    public void setBonoFecha(String bonoFecha) {
        this.bonoFecha = bonoFecha;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public Boolean getReversar() {
        return reversar;
    }

    public void setReversar(Boolean reversar) {
        this.reversar = reversar;
    }

    public String getUsrInsertaBono() {
        return usrInsertaBono;
    }

    public void setUsrInsertaBono(String usrInsertaBono) {
        this.usrInsertaBono = usrInsertaBono;
    }

    public String getInformacion(){
        return "Empresa: "+empCodigo+
                "\nFecha Bono: "+bonoFecha+
                "\nObservacion: "+conObservaciones+
                "\nReversar: "+reversar+
                "\nUsuario: "+usrInsertaBono;
    }
}
