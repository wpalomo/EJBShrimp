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
public class PrdListaDetalleLiquidacionTO implements Serializable{
    private Integer detSecuencial;
    private Integer detOrden;
    private BigDecimal detLibras;
    private String prodCodigo;
    private char prodClase;
    private String tallaCodigo;
    private BigDecimal detPrecio;
    private BigDecimal detParcial;

    public PrdListaDetalleLiquidacionTO() {
    }

    public PrdListaDetalleLiquidacionTO(Integer detSecuencial, 
            Integer detOrden,
            BigDecimal detLibras, 
            String prodCodigo, 
            char prodClase, 
            String tallaCodigo, 
            BigDecimal detPrecio, 
            BigDecimal detParcial) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detLibras = detLibras;
        this.prodCodigo = prodCodigo;
        this.prodClase = prodClase;
        this.tallaCodigo=tallaCodigo;
        this.detPrecio = detPrecio;
        this.detParcial = detParcial;
    }

    public BigDecimal getDetLibras() {
        return detLibras;
    }

    public void setDetLibras(BigDecimal detLibras) {
        this.detLibras = detLibras;
    }

    public BigDecimal getDetParcial() {
        return detParcial;
    }

    public void setDetParcial(BigDecimal detParcial) {
        this.detParcial = detParcial;
    }

    public BigDecimal getDetPrecio() {
        return detPrecio;
    }

    public void setDetPrecio(BigDecimal detPrecio) {
        this.detPrecio = detPrecio;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public char getProdClase() {
        return prodClase;
    }

    public void setProdClase(char prodClase) {
        this.prodClase = prodClase;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getTallaCodigo() {
        return tallaCodigo;
    }

    public void setTallaCodigo(String tallaCodigo) {
        this.tallaCodigo = tallaCodigo;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }
    
    
}
