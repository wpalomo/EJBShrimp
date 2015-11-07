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
public class PrdLiquidacionProductoTO implements Serializable{
    private String prodEmpresa;
    private String prodCodigo;
    private String prodDetalle;
    private String prodTipo;
    private char prodClase;
    private Boolean prodInactivo;    
    private String usrCodigo;
    private String usrFechaInserta;

    public PrdLiquidacionProductoTO() {
    }

    public PrdLiquidacionProductoTO(String prdEmpresa, String prdCodigo, String prdDetalle, String prdTipo, char prodClase, Boolean prdInactivo, String usrCodigo, String usrFechaInserta) {
        this.prodEmpresa = prdEmpresa;
        this.prodCodigo = prdCodigo;
        this.prodDetalle = prdDetalle;
        this.prodTipo = prdTipo;
        this.prodClase = prodClase;
        this.prodInactivo = prdInactivo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
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

    public String getProdEmpresa() {
        return prodEmpresa;
    }

    public void setProdEmpresa(String prdEmpresa) {
        this.prodEmpresa = prdEmpresa;
    }

    public Boolean getProdInactivo() {
        return prodInactivo;
    }

    public void setProdInactivo(Boolean prdInactivo) {
        this.prodInactivo = prdInactivo;
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

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    
}
