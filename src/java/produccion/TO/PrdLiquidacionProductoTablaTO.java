/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.TO;

import java.io.Serializable;

/**
 *
 * @author javier tj
 */
public class PrdLiquidacionProductoTablaTO implements Serializable{
    private String prodCodigo;
    private String prodDetalle;
    private String prodTipo;
    private char prodClase;
    
    public PrdLiquidacionProductoTablaTO() {
    }

    public PrdLiquidacionProductoTablaTO(String prdCodigo, String prdDetalle, String prdTipo, char prodClase) {
        this.prodCodigo = prdCodigo;
        this.prodDetalle = prdDetalle;
        this.prodTipo = prdTipo;
        this.prodClase = prodClase;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prdCodigo) {
        this.prodCodigo = prdCodigo;
    }

    public String getProdDetalle() {
        return prodDetalle;
    }

    public void setProdDetalle(String prdDetalle) {
        this.prodDetalle = prdDetalle;
    }

    public String getProdTipo() {
        return prodTipo;
    }

    public void setProdTipo(String prdTipo) {
        this.prodTipo = prdTipo;
    }

    public char getProdClase() {
        return prodClase;
    }

    public void setProdClase(char prodClase) {
        this.prodClase = prodClase;
    }

        
}
