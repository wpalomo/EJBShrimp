package produccion.TO;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrdListaConsultaLiquidacionTO implements Serializable{
    private String liqMotivo;
    private String liqNumero;
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
    private String liqPendiente;
    private String liqAnulado;
    private String cliCodigo;
    private String cliNombre;
    private String pisSector;
    private String pisNumero;

    public PrdListaConsultaLiquidacionTO() {
    }

    public PrdListaConsultaLiquidacionTO(
            String liqMotivo, 
            String liqNumero, 
            String liqLote, 
            String liqFecha, 
            BigDecimal liqLibrasEnviadas, 
            BigDecimal liqLibrasRecibidas, 
            BigDecimal liqLibrasBasura, 
            BigDecimal liqLibrasRetiradas, 
            BigDecimal liqLibrasNetas, 
            BigDecimal liqLibrasEntero, 
            BigDecimal liqLibrasCola, 
            BigDecimal liqLibrasColaProcesadas, 
            BigDecimal liqAnimalesCosechados, 
            BigDecimal liqTotalMonto, 
            String liqPendiente, 
            String liqAnulado, 
            String cliCodigo, 
            String cliNombre, 
            String pisSector, 
            String pisNumero) {
        this.liqMotivo = liqMotivo;
        this.liqNumero = liqNumero;
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
        this.cliCodigo = cliCodigo;
        this.cliNombre = cliNombre;
        this.pisSector = pisSector;
        this.pisNumero = pisNumero;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public BigDecimal getLiqAnimalesCosechados() {
        return liqAnimalesCosechados;
    }

    public void setLiqAnimalesCosechados(BigDecimal liqAnimalesCosechados) {
        this.liqAnimalesCosechados = liqAnimalesCosechados;
    }

    public String getLiqAnulado() {
        return liqAnulado;
    }

    public void setLiqAnulado(String liqAnulado) {
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

    public String getLiqMotivo() {
        return liqMotivo;
    }

    public void setLiqMotivo(String liqMotivo) {
        this.liqMotivo = liqMotivo;
    }

    public String getLiqNumero() {
        return liqNumero;
    }

    public void setLiqNumero(String liqNumero) {
        this.liqNumero = liqNumero;
    }

    public String getLiqPendiente() {
        return liqPendiente;
    }

    public void setLiqPendiente(String liqPendiente) {
        this.liqPendiente = liqPendiente;
    }

    public BigDecimal getLiqTotalMonto() {
        return liqTotalMonto;
    }

    public void setLiqTotalMonto(BigDecimal liqTotalMonto) {
        this.liqTotalMonto = liqTotalMonto;
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
    
}
