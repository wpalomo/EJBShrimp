/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class InvListaProductosCambiarPrecioTO implements java.io.Serializable{
    private String proCodigoPrincipal;
    private String proNombre;
    private String proCategoria;
    private java.math.BigDecimal stockSaldo;
    private java.math.BigDecimal stockCosto;
    private String detalleMedida;
    private java.math.BigDecimal stockPrecio1;
    private java.math.BigDecimal stockDescuento1;
    private java.math.BigDecimal stockPrecio2;
    private java.math.BigDecimal stockDescuento2;
    private java.math.BigDecimal stockPrecio3;
    private java.math.BigDecimal stockDescuento3;
    private java.math.BigDecimal stockPrecio4;
    private java.math.BigDecimal stockDescuento4;
    private java.math.BigDecimal stockPrecio5;
    private java.math.BigDecimal stockDescuento5;
    private String stockGrabaIva;

    public InvListaProductosCambiarPrecioTO() {
    }

    public InvListaProductosCambiarPrecioTO(String proCodigoPrincipal, String proNombre, String proCategoria, BigDecimal stockSaldo, BigDecimal stockCosto, String detalleMedida, BigDecimal stockPrecio1, BigDecimal stockDescuento1, BigDecimal stockPrecio2, BigDecimal stockDescuento2, BigDecimal stockPrecio3, BigDecimal stockDescuento3, BigDecimal stockPrecio4, BigDecimal stockDescuento4, BigDecimal stockPrecio5, BigDecimal stockDescuento5, String stockGrabaIva) {
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.proNombre = proNombre;
        this.proCategoria = proCategoria;
        this.stockSaldo = stockSaldo;
        this.stockCosto = stockCosto;
        this.detalleMedida = detalleMedida;
        this.stockPrecio1 = stockPrecio1;
        this.stockDescuento1 = stockDescuento1;
        this.stockPrecio2 = stockPrecio2;
        this.stockDescuento2 = stockDescuento2;
        this.stockPrecio3 = stockPrecio3;
        this.stockDescuento3 = stockDescuento3;
        this.stockPrecio4 = stockPrecio4;
        this.stockDescuento4 = stockDescuento4;
        this.stockPrecio5 = stockPrecio5;
        this.stockDescuento5 = stockDescuento5;
        this.stockGrabaIva = stockGrabaIva;
    }

    public InvListaProductosCambiarPrecioTO(String proCodigoPrincipal, String proNombre, String proCategoria, BigDecimal stockSaldo, BigDecimal stockCosto, String detalleMedida, BigDecimal stockPrecio1, BigDecimal stockDescuento1, BigDecimal stockPrecio2, BigDecimal stockDescuento2, BigDecimal stockPrecio3, BigDecimal stockDescuento3, BigDecimal stockPrecio4, BigDecimal stockDescuento4, BigDecimal stockPrecio5, BigDecimal stockDescuento5) {
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.proNombre = proNombre;
        this.proCategoria = proCategoria;
        this.stockSaldo = stockSaldo;
        this.stockCosto = stockCosto;
        this.detalleMedida = detalleMedida;
        this.stockPrecio1 = stockPrecio1;
        this.stockDescuento1 = stockDescuento1;
        this.stockPrecio2 = stockPrecio2;
        this.stockDescuento2 = stockDescuento2;
        this.stockPrecio3 = stockPrecio3;
        this.stockDescuento3 = stockDescuento3;
        this.stockPrecio4 = stockPrecio4;
        this.stockDescuento4 = stockDescuento4;
        this.stockPrecio5 = stockPrecio5;
        this.stockDescuento5 = stockDescuento5;
    }
    
    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public BigDecimal getStockSaldo() {
        return stockSaldo;
    }

    public void setStockSaldo(BigDecimal stockSaldo) {
        this.stockSaldo = stockSaldo;
    }

    public BigDecimal getStockCosto() {
        return stockCosto;
    }

    public void setStockCosto(BigDecimal stockCosto) {
        this.stockCosto = stockCosto;
    }

    public String getDetalleMedida() {
        return detalleMedida;
    }

    public void setDetalleMedida(String detalleMedida) {
        this.detalleMedida = detalleMedida;
    }

    public BigDecimal getStockPrecio1() {
        return stockPrecio1;
    }

    public void setStockPrecio1(BigDecimal stockPrecio1) {
        this.stockPrecio1 = stockPrecio1;
    }

    public BigDecimal getStockDescuento1() {
        return stockDescuento1;
    }

    public void setStockDescuento1(BigDecimal stockDescuento1) {
        this.stockDescuento1 = stockDescuento1;
    }

    public BigDecimal getStockPrecio2() {
        return stockPrecio2;
    }

    public void setStockPrecio2(BigDecimal stockPrecio2) {
        this.stockPrecio2 = stockPrecio2;
    }

    public BigDecimal getStockDescuento2() {
        return stockDescuento2;
    }

    public void setStockDescuento2(BigDecimal stockDescuento2) {
        this.stockDescuento2 = stockDescuento2;
    }

    public BigDecimal getStockPrecio3() {
        return stockPrecio3;
    }

    public void setStockPrecio3(BigDecimal stockPrecio3) {
        this.stockPrecio3 = stockPrecio3;
    }

    public BigDecimal getStockDescuento3() {
        return stockDescuento3;
    }

    public void setStockDescuento3(BigDecimal stockDescuento3) {
        this.stockDescuento3 = stockDescuento3;
    }

    public BigDecimal getStockPrecio4() {
        return stockPrecio4;
    }

    public void setStockPrecio4(BigDecimal stockPrecio4) {
        this.stockPrecio4 = stockPrecio4;
    }

    public BigDecimal getStockDescuento4() {
        return stockDescuento4;
    }

    public void setStockDescuento4(BigDecimal stockDescuento4) {
        this.stockDescuento4 = stockDescuento4;
    }

    public BigDecimal getStockPrecio5() {
        return stockPrecio5;
    }

    public void setStockPrecio5(BigDecimal stockPrecio5) {
        this.stockPrecio5 = stockPrecio5;
    }

    public BigDecimal getStockDescuento5() {
        return stockDescuento5;
    }

    public void setStockDescuento5(BigDecimal stockDescuento5) {
        this.stockDescuento5 = stockDescuento5;
    }

    public String getStockGrabaIva() {
        return stockGrabaIva;
    }

    public void setStockGrabaIva(String stockGrabaIva) {
        this.stockGrabaIva = stockGrabaIva;
    }
}
