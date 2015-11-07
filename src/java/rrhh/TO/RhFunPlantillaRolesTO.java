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
public class RhFunPlantillaRolesTO implements Serializable{

    private String prId;
    private String prNombres;
    private String prCargo;
    private java.math.BigDecimal prSueldoReal;
    private String prUltimoSueldo;
    private String prFormaPago;
    private Boolean prAfiliado;
    private Boolean prRetencion;
    private Boolean prFondoReserva;
    private String prFechaAfiliacionIess;
    private String prPrimerIngreso;
    private String prPrimeraSalida;
    private String prUltimoIngreso;
    private String prUltimaSalida;
    private java.math.BigDecimal prPorPagar;
    private java.math.BigDecimal prAnticipos;
    private java.math.BigDecimal prPrestamos;
    private java.math.BigDecimal prBonos;
    private java.math.BigDecimal prBonosNd;
    private java.math.BigDecimal prViaticos;

    public RhFunPlantillaRolesTO() {
    }

    public RhFunPlantillaRolesTO(String prId, String prNombres, String prCargo, BigDecimal prSueldoReal, String prUltimoSueldo, String prFormaPago, Boolean prAfiliado, Boolean prRetencion, Boolean prFondoReserva, String prFechaAfiliacionIess, String prPrimerIngreso, String prPrimeraSalida, String prUltimoIngreso, String prUltimaSalida, BigDecimal prPorPagar, BigDecimal prAnticipos, BigDecimal prPrestamos, BigDecimal prBonos, BigDecimal prBonosNd, BigDecimal prViaticos) {
        this.prId = prId;
        this.prNombres = prNombres;
        this.prCargo = prCargo;
        this.prSueldoReal = prSueldoReal;
        this.prUltimoSueldo = prUltimoSueldo;
        this.prFormaPago = prFormaPago;
        this.prAfiliado = prAfiliado;
        this.prRetencion = prRetencion;
        this.prFondoReserva = prFondoReserva;
        this.prFechaAfiliacionIess = prFechaAfiliacionIess;
        this.prPrimerIngreso = prPrimerIngreso;
        this.prPrimeraSalida = prPrimeraSalida;
        this.prUltimoIngreso = prUltimoIngreso;
        this.prUltimaSalida = prUltimaSalida;
        this.prPorPagar = prPorPagar;
        this.prAnticipos = prAnticipos;
        this.prPrestamos = prPrestamos;
        this.prBonos = prBonos;
        this.prBonosNd = prBonosNd;
        this.prViaticos = prViaticos;
    }

    public Boolean getPrAfiliado() {
        return prAfiliado;
    }

    public void setPrAfiliado(Boolean prAfiliado) {
        this.prAfiliado = prAfiliado;
    }

    public BigDecimal getPrAnticipos() {
        return prAnticipos;
    }

    public void setPrAnticipos(BigDecimal prAnticipos) {
        this.prAnticipos = prAnticipos;
    }

    public BigDecimal getPrBonos() {
        return prBonos;
    }

    public void setPrBonos(BigDecimal prBonos) {
        this.prBonos = prBonos;
    }

    public BigDecimal getPrBonosNd() {
        return prBonosNd;
    }

    public void setPrBonosNd(BigDecimal prBonosNd) {
        this.prBonosNd = prBonosNd;
    }

    public String getPrCargo() {
        return prCargo;
    }

    public void setPrCargo(String prCargo) {
        this.prCargo = prCargo;
    }

    public String getPrFechaAfiliacionIess() {
        return prFechaAfiliacionIess;
    }

    public void setPrFechaAfiliacionIess(String prFechaAfiliacionIess) {
        this.prFechaAfiliacionIess = prFechaAfiliacionIess;
    }

    public Boolean getPrFondoReserva() {
        return prFondoReserva;
    }

    public void setPrFondoReserva(Boolean prFondoReserva) {
        this.prFondoReserva = prFondoReserva;
    }

    public String getPrFormaPago() {
        return prFormaPago;
    }

    public void setPrFormaPago(String prFormaPago) {
        this.prFormaPago = prFormaPago;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public String getPrNombres() {
        return prNombres;
    }

    public void setPrNombres(String prNombres) {
        this.prNombres = prNombres;
    }

    public BigDecimal getPrPorPagar() {
        return prPorPagar;
    }

    public void setPrPorPagar(BigDecimal prPorPagar) {
        this.prPorPagar = prPorPagar;
    }

    public BigDecimal getPrPrestamos() {
        return prPrestamos;
    }

    public void setPrPrestamos(BigDecimal prPrestamos) {
        this.prPrestamos = prPrestamos;
    }

    public String getPrPrimerIngreso() {
        return prPrimerIngreso;
    }

    public void setPrPrimerIngreso(String prPrimerIngreso) {
        this.prPrimerIngreso = prPrimerIngreso;
    }

    public String getPrPrimeraSalida() {
        return prPrimeraSalida;
    }

    public void setPrPrimeraSalida(String prPrimeraSalida) {
        this.prPrimeraSalida = prPrimeraSalida;
    }

    public Boolean getPrRetencion() {
        return prRetencion;
    }

    public void setPrRetencion(Boolean prRetencion) {
        this.prRetencion = prRetencion;
    }

    public BigDecimal getPrSueldoReal() {
        return prSueldoReal;
    }

    public void setPrSueldoReal(BigDecimal prSueldoReal) {
        this.prSueldoReal = prSueldoReal;
    }

    public String getPrUltimaSalida() {
        return prUltimaSalida;
    }

    public void setPrUltimaSalida(String prUltimaSalida) {
        this.prUltimaSalida = prUltimaSalida;
    }

    public String getPrUltimoIngreso() {
        return prUltimoIngreso;
    }

    public void setPrUltimoIngreso(String prUltimoIngreso) {
        this.prUltimoIngreso = prUltimoIngreso;
    }

    public String getPrUltimoSueldo() {
        return prUltimoSueldo;
    }

    public void setPrUltimoSueldo(String prUltimoSueldo) {
        this.prUltimoSueldo = prUltimoSueldo;
    }

    public BigDecimal getPrViaticos() {
        return prViaticos;
    }

    public void setPrViaticos(BigDecimal prViaticos) {
        this.prViaticos = prViaticos;
    }

}
