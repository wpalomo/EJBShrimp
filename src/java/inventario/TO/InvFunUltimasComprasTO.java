/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author misayo
 */
public class InvFunUltimasComprasTO implements java.io.Serializable{
    private String compProveedorCodigo;
    private String compProveedorNombre;
    private String compFecha;
    private String compDocumentoNumero;
    private java.math.BigDecimal compCostoUnidad;
    private java.math.BigDecimal compCostoCaja;
    private java.math.BigDecimal compCantidadUnidades;
    private java.math.BigDecimal compCantidadCajas;
    private String compPeriodo;
    private String compMotivo;
    private String compNumero;

    public InvFunUltimasComprasTO() {
    }

    public InvFunUltimasComprasTO(String compProveedorCodigo, String compProveedorNombre, String compFecha, String compDocumentoNumero, BigDecimal compCostoUnidad, BigDecimal compCostoCaja, BigDecimal compCantidadUnidades, BigDecimal compCantidadCajas, String compPeriodo, String compMotivo, String compNumero) {
        this.compProveedorCodigo = compProveedorCodigo;
        this.compProveedorNombre = compProveedorNombre;
        this.compFecha = compFecha;
        this.compDocumentoNumero = compDocumentoNumero;
        this.compCostoUnidad = compCostoUnidad;
        this.compCostoCaja = compCostoCaja;
        this.compCantidadUnidades = compCantidadUnidades;
        this.compCantidadCajas = compCantidadCajas;
        this.compPeriodo = compPeriodo;
        this.compMotivo = compMotivo;
        this.compNumero = compNumero;
    }

    public BigDecimal getCompCantidadCajas() {
        return compCantidadCajas;
    }

    public void setCompCantidadCajas(BigDecimal compCantidadCajas) {
        this.compCantidadCajas = compCantidadCajas;
    }

    public BigDecimal getCompCantidadUnidades() {
        return compCantidadUnidades;
    }

    public void setCompCantidadUnidades(BigDecimal compCantidadUnidades) {
        this.compCantidadUnidades = compCantidadUnidades;
    }

    public BigDecimal getCompCostoCaja() {
        return compCostoCaja;
    }

    public void setCompCostoCaja(BigDecimal compCostoCaja) {
        this.compCostoCaja = compCostoCaja;
    }

    public BigDecimal getCompCostoUnidad() {
        return compCostoUnidad;
    }

    public void setCompCostoUnidad(BigDecimal compCostoUnidad) {
        this.compCostoUnidad = compCostoUnidad;
    }

    public String getCompDocumentoNumero() {
        return compDocumentoNumero;
    }

    public void setCompDocumentoNumero(String compDocumentoNumero) {
        this.compDocumentoNumero = compDocumentoNumero;
    }

    public String getCompFecha() {
        return compFecha;
    }

    public void setCompFecha(String compFecha) {
        this.compFecha = compFecha;
    }

    public String getCompMotivo() {
        return compMotivo;
    }

    public void setCompMotivo(String compMotivo) {
        this.compMotivo = compMotivo;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
    }

    public String getCompPeriodo() {
        return compPeriodo;
    }

    public void setCompPeriodo(String compPeriodo) {
        this.compPeriodo = compPeriodo;
    }

    public String getCompProveedorCodigo() {
        return compProveedorCodigo;
    }

    public void setCompProveedorCodigo(String compProveedorCodigo) {
        this.compProveedorCodigo = compProveedorCodigo;
    }

    public String getCompProveedorNombre() {
        return compProveedorNombre;
    }

    public void setCompProveedorNombre(String compProveedorNombre) {
        this.compProveedorNombre = compProveedorNombre;
    }
}
