/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author javier tj
 */
public class PrdLiquidacionCabeceraTO implements Serializable{
    private String liqLote;
    private String liqFecha;
    private BigDecimal liqLibrasEnviadas;
    private BigDecimal liqLibrasRecibidas;
    private BigDecimal liqLibrasBasura;
    private BigDecimal liqLibrasRetiradas;
    private BigDecimal liqLibrasNetas;
    private BigDecimal liqLibrasEntero;
    private BigDecimal liqLibrasCola;
    private BigDecimal liqLibrasColaProcesadas;
    private BigDecimal liqAnimalesCosechados;
    private BigDecimal liqTotalMonto;
    private boolean liqPendiente;
    private boolean liqAnulado;
    private String cliEmpresa;
    private String cliCodigo;
    private String pisEmpresa;
    private String pisSector;
    private String pisNumero;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public PrdLiquidacionCabeceraTO() {
    }

    public PrdLiquidacionCabeceraTO(String liqLote, String liqFecha, BigDecimal liqLibrasEnviadas, BigDecimal liqLibrasRecibidas, BigDecimal liqLibrasBasura, BigDecimal liqLibrasRetiradas, BigDecimal liqLibrasNetas, BigDecimal liqLibrasEntero, BigDecimal liqLibrasCola, BigDecimal liqLibrasColaProcesadas, BigDecimal liqAnimalesCosechados, BigDecimal liqTotalMonto, boolean liqPendiente, boolean liqAnulado, String cliEmpresa, String cliCodigo, String pisEmpresa, String pisSector, String pisNumero, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.liqLote = liqLote;
        this.liqFecha = liqFecha;
        this.liqLibrasEnviadas = liqLibrasEnviadas;
        this.liqLibrasRecibidas = liqLibrasRecibidas;
        this.liqLibrasBasura = liqLibrasBasura;
        this.liqLibrasRetiradas = liqLibrasRetiradas;
        this.liqLibrasNetas = liqLibrasNetas;
        this.liqLibrasEntero = liqLibrasEntero;
        this.liqLibrasCola = liqLibrasCola;
        this.liqLibrasColaProcesadas = liqLibrasColaProcesadas;
        this.liqAnimalesCosechados = liqAnimalesCosechados;
        this.liqTotalMonto = liqTotalMonto;
        this.liqPendiente = liqPendiente;
        this.liqAnulado = liqAnulado;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.pisEmpresa = pisEmpresa;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
    }

    public BigDecimal getLiqAnimalesCosechados() {
        return liqAnimalesCosechados;
    }

    public void setLiqAnimalesCosechados(BigDecimal liqAnimalesCosechados) {
        this.liqAnimalesCosechados = liqAnimalesCosechados;
    }

    public boolean isLiqAnulado() {
        return liqAnulado;
    }

    public void setLiqAnulado(boolean liqAnulado) {
        this.liqAnulado = liqAnulado;
    }

    public String getLiqFecha() {
        return liqFecha;
    }

    public void setLiqFecha(String liqFecha) {
        this.liqFecha = liqFecha;
    }

    public BigDecimal getLiqLibrasBasura() {
        return liqLibrasBasura;
    }

    public void setLiqLibrasBasura(BigDecimal liqLibrasBasura) {
        this.liqLibrasBasura = liqLibrasBasura;
    }

    public BigDecimal getLiqLibrasCola() {
        return liqLibrasCola;
    }

    public void setLiqLibrasCola(BigDecimal liqLibrasCola) {
        this.liqLibrasCola = liqLibrasCola;
    }

    public BigDecimal getLiqLibrasColaProcesadas() {
        return liqLibrasColaProcesadas;
    }

    public void setLiqLibrasColaProcesadas(BigDecimal liqLibrasColaProcesadas) {
        this.liqLibrasColaProcesadas = liqLibrasColaProcesadas;
    }

    public BigDecimal getLiqLibrasEntero() {
        return liqLibrasEntero;
    }

    public void setLiqLibrasEntero(BigDecimal liqLibrasEntero) {
        this.liqLibrasEntero = liqLibrasEntero;
    }

    public BigDecimal getLiqLibrasEnviadas() {
        return liqLibrasEnviadas;
    }

    public void setLiqLibrasEnviadas(BigDecimal liqLibrasEnviadas) {
        this.liqLibrasEnviadas = liqLibrasEnviadas;
    }

    public BigDecimal getLiqLibrasNetas() {
        return liqLibrasNetas;
    }

    public void setLiqLibrasNetas(BigDecimal liqLibrasNetas) {
        this.liqLibrasNetas = liqLibrasNetas;
    }

    public BigDecimal getLiqLibrasRecibidas() {
        return liqLibrasRecibidas;
    }

    public void setLiqLibrasRecibidas(BigDecimal liqLibrasRecibidas) {
        this.liqLibrasRecibidas = liqLibrasRecibidas;
    }

    public BigDecimal getLiqLibrasRetiradas() {
        return liqLibrasRetiradas;
    }

    public void setLiqLibrasRetiradas(BigDecimal liqLibrasRetiradas) {
        this.liqLibrasRetiradas = liqLibrasRetiradas;
    }

    public String getLiqLote() {
        return liqLote;
    }

    public void setLiqLote(String liqLote) {
        this.liqLote = liqLote;
    }

    public boolean isLiqPendiente() {
        return liqPendiente;
    }

    public void setLiqPendiente(boolean liqPendiente) {
        this.liqPendiente = liqPendiente;
    }

    public BigDecimal getLiqTotalMonto() {
        return liqTotalMonto;
    }

    public void setLiqTotalMonto(BigDecimal liqTotalMonto) {
        this.liqTotalMonto = liqTotalMonto;
    }

    public String getPisEmpresa() {
        return pisEmpresa;
    }

    public void setPisEmpresa(String pisEmpresa) {
        this.pisEmpresa = pisEmpresa;
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

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
        
}
