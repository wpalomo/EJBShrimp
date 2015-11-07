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
public class RhListaDetalleAnticiposPrestamosTO implements Serializable{
    private String dapTipo;
    private String dapCategoria;
    private String dapFecha;
    private String dapId;
    private String dapNombres;
    private BigDecimal dapValor;
    private Boolean dapReverso;
    private String dapFormaPago;
    private String dapDocumento;
    private String dapContable;
    private Boolean dapAnulado;
    private String dapObservaciones;

    public RhListaDetalleAnticiposPrestamosTO() {
    }

    public RhListaDetalleAnticiposPrestamosTO(String dapTipo, String dapCategoria, String dapFecha, String dapId, String dapNombres, BigDecimal dapValor, Boolean dapReverso, String dapFormaPago, String dapDocumento, String dapContable, Boolean dapAnulado, String dapObservaciones) {
        this.dapTipo = dapTipo;
        this.dapCategoria = dapCategoria;
        this.dapFecha = dapFecha;
        this.dapId = dapId;
        this.dapNombres = dapNombres;
        this.dapValor = dapValor;
        this.dapReverso = dapReverso;
        this.dapFormaPago = dapFormaPago;
        this.dapDocumento = dapDocumento;
        this.dapContable = dapContable;
        this.dapAnulado = dapAnulado;
        this.dapObservaciones = dapObservaciones;
    }

    public Boolean getDapAnulado() {
        return dapAnulado;
    }

    public void setDapAnulado(Boolean dapAnulado) {
        this.dapAnulado = dapAnulado;
    }

    public String getDapCategoria() {
        return dapCategoria;
    }

    public void setDapCategoria(String dapCategoria) {
        this.dapCategoria = dapCategoria;
    }

    public String getDapContable() {
        return dapContable;
    }

    public void setDapContable(String dapContable) {
        this.dapContable = dapContable;
    }

    public String getDapDocumento() {
        return dapDocumento;
    }

    public void setDapDocumento(String dapDocumento) {
        this.dapDocumento = dapDocumento;
    }

    public String getDapFecha() {
        return dapFecha;
    }

    public void setDapFecha(String dapFecha) {
        this.dapFecha = dapFecha;
    }

    public String getDapFormaPago() {
        return dapFormaPago;
    }

    public void setDapFormaPago(String dapFormaPago) {
        this.dapFormaPago = dapFormaPago;
    }

    public String getDapId() {
        return dapId;
    }

    public void setDapId(String dapId) {
        this.dapId = dapId;
    }

    public String getDapNombres() {
        return dapNombres;
    }

    public void setDapNombres(String dapNombres) {
        this.dapNombres = dapNombres;
    }

    public String getDapObservaciones() {
        return dapObservaciones;
    }

    public void setDapObservaciones(String dapObservaciones) {
        this.dapObservaciones = dapObservaciones;
    }

    public Boolean getDapReverso() {
        return dapReverso;
    }

    public void setDapReverso(Boolean dapReverso) {
        this.dapReverso = dapReverso;
    }

    public String getDapTipo() {
        return dapTipo;
    }

    public void setDapTipo(String dapTipo) {
        this.dapTipo = dapTipo;
    }

    public BigDecimal getDapValor() {
        return dapValor;
    }

    public void setDapValor(BigDecimal dapValor) {
        this.dapValor = dapValor;
    }
}