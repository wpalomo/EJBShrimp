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
public class InvListaProductosSaldosPreciosTO implements java.io.Serializable{
    private String lpspCodigoPrincipal;
    private String lpspCodigoBarra;
    private String lpspNombre;
    private String lpspCategoria;
    private java.math.BigDecimal lpspSaldo;
    private String lpspMedida;
    private java.math.BigDecimal lpspPrecio1;
    private java.math.BigDecimal lpspPrecio2;
    private java.math.BigDecimal lpspPrecio3;
    private java.math.BigDecimal lpspPrecio4;
    private java.math.BigDecimal lpspPrecio5;
    private boolean lpspIva;

    public InvListaProductosSaldosPreciosTO() {
    }

    public InvListaProductosSaldosPreciosTO(String lpspCodigoPrincipal, String lpspCodigoBarra, String lpspNombre, String lpspCategoria, BigDecimal lpspSaldo, String lpspMedida, BigDecimal lpspPrecio1, BigDecimal lpspPrecio2, BigDecimal lpspPrecio3, BigDecimal lpspPrecio4, BigDecimal lpspPrecio5, boolean lpspIva) {
        this.lpspCodigoPrincipal = lpspCodigoPrincipal;
        this.lpspCodigoBarra = lpspCodigoBarra;
        this.lpspNombre = lpspNombre;
        this.lpspCategoria = lpspCategoria;
        this.lpspSaldo = lpspSaldo;
        this.lpspMedida = lpspMedida;
        this.lpspPrecio1 = lpspPrecio1;
        this.lpspPrecio2 = lpspPrecio2;
        this.lpspPrecio3 = lpspPrecio3;
        this.lpspPrecio4 = lpspPrecio4;
        this.lpspPrecio5 = lpspPrecio5;
        this.lpspIva = lpspIva;
    }

    public String getLpspCategoria() {
        return lpspCategoria;
    }

    public void setLpspCategoria(String lpspCategoria) {
        this.lpspCategoria = lpspCategoria;
    }

    public String getLpspCodigoBarra() {
        return lpspCodigoBarra;
    }

    public void setLpspCodigoBarra(String lpspCodigoBarra) {
        this.lpspCodigoBarra = lpspCodigoBarra;
    }

    public String getLpspCodigoPrincipal() {
        return lpspCodigoPrincipal;
    }

    public void setLpspCodigoPrincipal(String lpspCodigoPrincipal) {
        this.lpspCodigoPrincipal = lpspCodigoPrincipal;
    }

    public boolean isLpspIva() {
        return lpspIva;
    }

    public void setLpspIva(boolean lpspIva) {
        this.lpspIva = lpspIva;
    }

    public String getLpspMedida() {
        return lpspMedida;
    }

    public void setLpspMedida(String lpspMedida) {
        this.lpspMedida = lpspMedida;
    }

    public String getLpspNombre() {
        return lpspNombre;
    }

    public void setLpspNombre(String lpspNombre) {
        this.lpspNombre = lpspNombre;
    }

    public BigDecimal getLpspPrecio1() {
        return lpspPrecio1;
    }

    public void setLpspPrecio1(BigDecimal lpspPrecio1) {
        this.lpspPrecio1 = lpspPrecio1;
    }

    public BigDecimal getLpspPrecio2() {
        return lpspPrecio2;
    }

    public void setLpspPrecio2(BigDecimal lpspPrecio2) {
        this.lpspPrecio2 = lpspPrecio2;
    }

    public BigDecimal getLpspPrecio3() {
        return lpspPrecio3;
    }

    public void setLpspPrecio3(BigDecimal lpspPrecio3) {
        this.lpspPrecio3 = lpspPrecio3;
    }

    public BigDecimal getLpspPrecio4() {
        return lpspPrecio4;
    }

    public void setLpspPrecio4(BigDecimal lpspPrecio4) {
        this.lpspPrecio4 = lpspPrecio4;
    }

    public BigDecimal getLpspPrecio5() {
        return lpspPrecio5;
    }

    public void setLpspPrecio5(BigDecimal lpspPrecio5) {
        this.lpspPrecio5 = lpspPrecio5;
    }

    public BigDecimal getLpspSaldo() {
        return lpspSaldo;
    }

    public void setLpspSaldo(BigDecimal lpspSaldo) {
        this.lpspSaldo = lpspSaldo;
    }

}
