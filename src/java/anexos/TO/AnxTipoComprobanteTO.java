/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxTipoComprobanteTO implements java.io.Serializable{
    private String tcCodigo;
    private String tcDescripcion;
    private String tcTransaccion;
    private String tcSustento;
    private String tcAbreviatura;

    public AnxTipoComprobanteTO() {
    }

    public AnxTipoComprobanteTO(String tcCodigo, String tcDescripcion, String tcTransaccion, String tcSustento, String tcAbreviatura) {
        this.tcCodigo = tcCodigo;
        this.tcDescripcion = tcDescripcion;
        this.tcTransaccion = tcTransaccion;
        this.tcSustento = tcSustento;
        this.tcAbreviatura = tcAbreviatura;
    }

    public String getTcAbreviatura() {
        return tcAbreviatura;
    }

    public void setTcAbreviatura(String tcAbreviatura) {
        this.tcAbreviatura = tcAbreviatura;
    }

    public String getTcCodigo() {
        return tcCodigo;
    }

    public void setTcCodigo(String tcCodigo) {
        this.tcCodigo = tcCodigo;
    }

    public String getTcDescripcion() {
        return tcDescripcion;
    }

    public void setTcDescripcion(String tcDescripcion) {
        this.tcDescripcion = tcDescripcion;
    }

    public String getTcSustento() {
        return tcSustento;
    }

    public void setTcSustento(String tcSustento) {
        this.tcSustento = tcSustento;
    }

    public String getTcTransaccion() {
        return tcTransaccion;
    }

    public void setTcTransaccion(String tcTransaccion) {
        this.tcTransaccion = tcTransaccion;
    }
}
