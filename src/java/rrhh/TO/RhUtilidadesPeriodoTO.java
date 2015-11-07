/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhUtilidadesPeriodoTO implements Serializable{
    private String utiEmpresa;
    private String utiDescripcion;
    private String utiDesde;
    private String utiHasta;
    private String utiFechaMaximaPago;
    private Integer utiTotalDias;
    private Integer utiTotalCargas;
    private BigDecimal utiTotalPagar;
    private String usrEmpresa;
    private String UsrCodigo;

    public RhUtilidadesPeriodoTO() {
    }

    public RhUtilidadesPeriodoTO(String utiEmpresa, String utiDescripcion, String utiDesde, String utiHasta, String utiFechaMaximaPago, Integer utiTotalDias, Integer utiTotalCargas, BigDecimal utiTotalPagar, String usrEmpresa, String UsrCodigo) {
        this.utiEmpresa = utiEmpresa;
        this.utiDescripcion = utiDescripcion;
        this.utiDesde = utiDesde;
        this.utiHasta = utiHasta;
        this.utiFechaMaximaPago = utiFechaMaximaPago;
        this.utiTotalDias = utiTotalDias;
        this.utiTotalCargas = utiTotalCargas;
        this.utiTotalPagar = utiTotalPagar;
        this.usrEmpresa = usrEmpresa;
        this.UsrCodigo = UsrCodigo;
    }

    public RhUtilidadesPeriodoTO(String utiDescripcion, String utiDesde, String utiHasta, String utiFechaMaximaPago, Integer utiTotalDias, Integer utiTotalCargas, BigDecimal utiTotalPagar) {
        this.utiDescripcion = utiDescripcion;
        this.utiDesde = utiDesde;
        this.utiHasta = utiHasta;
        this.utiFechaMaximaPago = utiFechaMaximaPago;
        this.utiTotalDias = utiTotalDias;
        this.utiTotalCargas = utiTotalCargas;
        this.utiTotalPagar = utiTotalPagar;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUtiEmpresa() {
        return utiEmpresa;
    }

    public void setUtiEmpresa(String utiEmpresa) {
        this.utiEmpresa = utiEmpresa;
    }

    public String getUsrCodigo() {
        return UsrCodigo;
    }

    public void setUsrCodigo(String UsrCodigo) {
        this.UsrCodigo = UsrCodigo;
    }

    public String getUtiDescripcion() {
        return utiDescripcion;
    }

    public void setUtiDescripcion(String utiDescripcion) {
        this.utiDescripcion = utiDescripcion;
    }

    public String getUtiDesde() {
        return utiDesde;
    }

    public void setUtiDesde(String utiDesde) {
        this.utiDesde = utiDesde;
    }

    public String getUtiHasta() {
        return utiHasta;
    }

    public void setUtiHasta(String utiHasta) {
        this.utiHasta = utiHasta;
    }

    public String getUtiFechaMaximaPago() {
        return utiFechaMaximaPago;
    }

    public void setUtiFechaMaximaPago(String utiFechaMaximaPago) {
        this.utiFechaMaximaPago = utiFechaMaximaPago;
    }

    public Integer getUtiTotalDias() {
        return utiTotalDias;
    }

    public void setUtiTotalDias(Integer utiTotalDias) {
        this.utiTotalDias = utiTotalDias;
    }

    public Integer getUtiTotalCargas() {
        return utiTotalCargas;
    }

    public void setUtiTotalCargas(Integer utiTotalCargas) {
        this.utiTotalCargas = utiTotalCargas;
    }

    public BigDecimal getUtiTotalPagar() {
        return utiTotalPagar;
    }

    public void setUtiTotalPagar(BigDecimal utiTotalPagar) {
        this.utiTotalPagar = utiTotalPagar;
    }

    

    @Override
    public String toString(){
        return this.utiDescripcion;
    }

}
