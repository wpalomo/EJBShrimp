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
public class RhXiiiSueldoPeriodoTO implements Serializable{
    private String xiiiDescripcion;
    private String xiiiDesde;
    private String xiiiHasta;
    private String xiiiFechaMaximaPago;
    private Integer periodoSecuencial;
    public RhXiiiSueldoPeriodoTO() {
    }

    public RhXiiiSueldoPeriodoTO(String xiiiDescripcion, String xiiiDesde, String xiiiHasta, String xiiiFechaMaximaPago, Integer periodoSecuencial) {
        this.xiiiDescripcion = xiiiDescripcion;
        this.xiiiDesde = xiiiDesde;
        this.xiiiHasta = xiiiHasta;
        this.xiiiFechaMaximaPago = xiiiFechaMaximaPago;
        this.periodoSecuencial = periodoSecuencial;
    }

    public Integer getPeriodoSecuencial() {
        return periodoSecuencial;
    }

    public void setPeriodoSecuencial(Integer periodoSecuencial) {
        this.periodoSecuencial = periodoSecuencial;
    }

    public String getXiiiDescripcion() {
        return xiiiDescripcion;
    }

    public void setXiiiDescripcion(String xiiiDescripcion) {
        this.xiiiDescripcion = xiiiDescripcion;
    }

    public String getXiiiDesde() {
        return xiiiDesde;
    }

    public void setXiiiDesde(String xiiiDesde) {
        this.xiiiDesde = xiiiDesde;
    }

    public String getXiiiFechaMaximaPago() {
        return xiiiFechaMaximaPago;
    }

    public void setXiiiFechaMaximaPago(String xiiiFechaMaximaPago) {
        this.xiiiFechaMaximaPago = xiiiFechaMaximaPago;
    }

    public String getXiiiHasta() {
        return xiiiHasta;
    }

    public void setXiiiHasta(String xiiiHasta) {
        this.xiiiHasta = xiiiHasta;
    }

    @Override
    public String toString(){
        return this.xiiiDescripcion;
    }

}
