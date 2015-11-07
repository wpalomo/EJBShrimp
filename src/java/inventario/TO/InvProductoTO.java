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
public class InvProductoTO implements java.io.Serializable{
 /*
  
              
                * 
      
            
             
  */
       
    private String proEmpresa;
    private String proCodigoPrincipal;
    private String proCodigoAlterno;
    private String proCodigoBarra;
    private String proCodigoBarra2;
    private String proCodigoBarra3;
    private String proCodigoBarra4;
    private String proCodigoBarra5;
    private String proEmpaque;
    private String proNombre;
       
    private String proDetalle;
    private java.math.BigDecimal proCantidad1;
    private java.math.BigDecimal proCantidad2;
    private java.math.BigDecimal proCantidad3;
    private java.math.BigDecimal proCantidad4;
    private java.math.BigDecimal proCantidad5;
    private java.math.BigDecimal proPrecio1;
    private java.math.BigDecimal proPrecio2;
    private java.math.BigDecimal proPrecio3;
    private java.math.BigDecimal proPrecio4;
     
    private java.math.BigDecimal proPrecio5;
    private java.math.BigDecimal proDescuento1;
    private java.math.BigDecimal proDescuento2;
    private java.math.BigDecimal proDescuento3;
    private java.math.BigDecimal proDescuento4;
    private java.math.BigDecimal proDescuento5;
    private java.math.BigDecimal proMargenUtilidad1;
    private java.math.BigDecimal proMargenUtilidad2;
    private java.math.BigDecimal proMargenUtilidad3;
    private java.math.BigDecimal proMargenUtilidad4;
        
    private java.math.BigDecimal proMargenUtilidad5;
    private Integer proMinimo;
    private Integer proMaximo;
    private String proIva;
    private Boolean proCreditoTributario;
    private Boolean proStockNegativo;
    private Boolean proInactivo;
    private String proCuentaInventario;
    private String proCuentaGasto;
    private String proCuentaVenta;

    private String proCuentaTransferenciaIpp;
    private String catEmpresa;
    private String catCodigo;
    private String marEmpresa;
    private String marCodigo;
    private String presUEmpresa;
    private String presUCodigo;
    private String presCEmpresa;
    private String presCCodigo;
    private String tipEmpresa;
    
    private String tipCodigo;
    private String medEmpresa;
    private String medCodigo;
    private String usrEmpresa;
    private String usrInsertaProducto;
    private String usrFechaInsertaProducto;
    private Double balFactorLibras;
    private String conCodigo;
    private String susCodigo;
    private java.math.BigDecimal proFactorCajabulto;
   
    
    
    
 
    //
    public InvProductoTO() {
    }

//    public InvProductoTO(String proCodigoPrincipal, BigDecimal proCantidad1, BigDecimal proCantidad2, BigDecimal proCantidad3, BigDecimal proCantidad4, BigDecimal proCantidad5, BigDecimal proMargenUtilidad1, BigDecimal proMargenUtilidad2, BigDecimal proMargenUtilidad3, BigDecimal proMargenUtilidad4, BigDecimal proMargenUtilidad5, String usrEmpresa, String usrInsertaProducto, String usrFechaInsertaProducto) {
//        this.proCodigoPrincipal = proCodigoPrincipal;
//        this.proCantidad1 = proCantidad1;
//        this.proCantidad2 = proCantidad2;
//        this.proCantidad3 = proCantidad3;
//        this.proCantidad4 = proCantidad4;
//        this.proCantidad5 = proCantidad5;
//        this.proMargenUtilidad1 = proMargenUtilidad1;
//        this.proMargenUtilidad2 = proMargenUtilidad2;
//        this.proMargenUtilidad3 = proMargenUtilidad3;
//        this.proMargenUtilidad4 = proMargenUtilidad4;
//        this.proMargenUtilidad5 = proMargenUtilidad5;
//        this.usrEmpresa = usrEmpresa;
//        this.usrInsertaProducto = usrInsertaProducto;
//        this.usrFechaInsertaProducto = usrFechaInsertaProducto;
//    }

    public InvProductoTO(String proEmpresa, String proCodigoPrincipal, String proCodigoAlterno, String proCodigoBarra, String proCodigoBarra2, String proCodigoBarra3, String proCodigoBarra4, String proCodigoBarra5, String proEmpaque, String proNombre, String proDetalle, BigDecimal proCantidad1, BigDecimal proCantidad2, BigDecimal proCantidad3, BigDecimal proCantidad4, BigDecimal proCantidad5, BigDecimal proPrecio1, BigDecimal proPrecio2, BigDecimal proPrecio3, BigDecimal proPrecio4, BigDecimal proPrecio5, BigDecimal proDescuento1, BigDecimal proDescuento2, BigDecimal proDescuento3, BigDecimal proDescuento4, BigDecimal proDescuento5, BigDecimal proMargenUtilidad1, BigDecimal proMargenUtilidad2, BigDecimal proMargenUtilidad3, BigDecimal proMargenUtilidad4, BigDecimal proMargenUtilidad5, Integer proMinimo, Integer proMaximo, String proIva, Boolean proCreditoTributario, Boolean proStockNegativo, Boolean proInactivo, String proCuentaInventario, String proCuentaGasto, String proCuentaVenta, String proCuentaTransferenciaIpp, String catEmpresa, String catCodigo, String marEmpresa, String marCodigo, String presUEmpresa, String presUCodigo, String presCEmpresa, String presCCodigo, String tipEmpresa, String tipCodigo, String medEmpresa, String medCodigo, String usrEmpresa, String usrInsertaProducto, String usrFechaInsertaProducto, Double balFactorLibras, String conCodigo, String susCodigo, BigDecimal proFactorCajabulto) {
        this.proEmpresa = proEmpresa;
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.proCodigoAlterno = proCodigoAlterno;
        this.proCodigoBarra = proCodigoBarra;
        this.proCodigoBarra2 = proCodigoBarra2;
        this.proCodigoBarra3 = proCodigoBarra3;
        this.proCodigoBarra4 = proCodigoBarra4;
        this.proCodigoBarra5 = proCodigoBarra5;
        this.proEmpaque = proEmpaque;
        this.proNombre = proNombre;
        this.proDetalle = proDetalle;
        this.proCantidad1 = proCantidad1;
        this.proCantidad2 = proCantidad2;
        this.proCantidad3 = proCantidad3;
        this.proCantidad4 = proCantidad4;
        this.proCantidad5 = proCantidad5;
        this.proPrecio1 = proPrecio1;
        this.proPrecio2 = proPrecio2;
        this.proPrecio3 = proPrecio3;
        this.proPrecio4 = proPrecio4;
        this.proPrecio5 = proPrecio5;
        this.proDescuento1 = proDescuento1;
        this.proDescuento2 = proDescuento2;
        this.proDescuento3 = proDescuento3;
        this.proDescuento4 = proDescuento4;
        this.proDescuento5 = proDescuento5;
        this.proMargenUtilidad1 = proMargenUtilidad1;
        this.proMargenUtilidad2 = proMargenUtilidad2;
        this.proMargenUtilidad3 = proMargenUtilidad3;
        this.proMargenUtilidad4 = proMargenUtilidad4;
        this.proMargenUtilidad5 = proMargenUtilidad5;
        this.proMinimo = proMinimo;
        this.proMaximo = proMaximo;
        this.proIva = proIva;
        this.proCreditoTributario = proCreditoTributario;
        this.proStockNegativo = proStockNegativo;
        this.proInactivo = proInactivo;
        this.proCuentaInventario = proCuentaInventario;
        this.proCuentaGasto = proCuentaGasto;
        this.proCuentaVenta = proCuentaVenta;
        this.proCuentaTransferenciaIpp = proCuentaTransferenciaIpp;
        this.catEmpresa = catEmpresa;
        this.catCodigo = catCodigo;
        this.marEmpresa = marEmpresa;
        this.marCodigo = marCodigo;
        this.presUEmpresa = presUEmpresa;
        this.presUCodigo = presUCodigo;
        this.presCEmpresa = presCEmpresa;
        this.presCCodigo = presCCodigo;
        this.tipEmpresa = tipEmpresa;
        this.tipCodigo = tipCodigo;
        this.medEmpresa = medEmpresa;
        this.medCodigo = medCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrInsertaProducto = usrInsertaProducto;
        this.usrFechaInsertaProducto = usrFechaInsertaProducto;
        this.balFactorLibras = balFactorLibras;
        this.conCodigo = conCodigo;
        this.susCodigo = susCodigo;
        this.proFactorCajabulto = proFactorCajabulto;
    }

    public Double getBalFactorLibras() {
        return balFactorLibras;
    }

    public void setBalFactorLibras(Double balFactorLibras) {
        this.balFactorLibras = balFactorLibras;
    }

    public String getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(String catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getCatEmpresa() {
        return catEmpresa;
    }

    public void setCatEmpresa(String catEmpresa) {
        this.catEmpresa = catEmpresa;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getMarCodigo() {
        return marCodigo;
    }

    public void setMarCodigo(String marCodigo) {
        this.marCodigo = marCodigo;
    }

    public String getMarEmpresa() {
        return marEmpresa;
    }

    public void setMarEmpresa(String marEmpresa) {
        this.marEmpresa = marEmpresa;
    }

    public String getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(String medCodigo) {
        this.medCodigo = medCodigo;
    }

    public String getMedEmpresa() {
        return medEmpresa;
    }

    public void setMedEmpresa(String medEmpresa) {
        this.medEmpresa = medEmpresa;
    }

    public String getPresCCodigo() {
        return presCCodigo;
    }

    public void setPresCCodigo(String presCCodigo) {
        this.presCCodigo = presCCodigo;
    }

    public String getPresCEmpresa() {
        return presCEmpresa;
    }

    public void setPresCEmpresa(String presCEmpresa) {
        this.presCEmpresa = presCEmpresa;
    }

    public String getPresUCodigo() {
        return presUCodigo;
    }

    public void setPresUCodigo(String presUCodigo) {
        this.presUCodigo = presUCodigo;
    }

    public String getPresUEmpresa() {
        return presUEmpresa;
    }

    public void setPresUEmpresa(String presUEmpresa) {
        this.presUEmpresa = presUEmpresa;
    }

    public BigDecimal getProCantidad1() {
        return proCantidad1;
    }

    public void setProCantidad1(BigDecimal proCantidad1) {
        this.proCantidad1 = proCantidad1;
    }

    public BigDecimal getProCantidad2() {
        return proCantidad2;
    }

    public void setProCantidad2(BigDecimal proCantidad2) {
        this.proCantidad2 = proCantidad2;
    }

    public BigDecimal getProCantidad3() {
        return proCantidad3;
    }

    public void setProCantidad3(BigDecimal proCantidad3) {
        this.proCantidad3 = proCantidad3;
    }

    public BigDecimal getProCantidad4() {
        return proCantidad4;
    }

    public void setProCantidad4(BigDecimal proCantidad4) {
        this.proCantidad4 = proCantidad4;
    }

    public BigDecimal getProCantidad5() {
        return proCantidad5;
    }

    public void setProCantidad5(BigDecimal proCantidad5) {
        this.proCantidad5 = proCantidad5;
    }

    public String getProCodigoAlterno() {
        return proCodigoAlterno;
    }

    public void setProCodigoAlterno(String proCodigoAlterno) {
        this.proCodigoAlterno = proCodigoAlterno;
    }

    public String getProCodigoBarra() {
        return proCodigoBarra;
    }

    public void setProCodigoBarra(String proCodigoBarra) {
        this.proCodigoBarra = proCodigoBarra;
    }

    public String getProCodigoBarra2() {
        return proCodigoBarra2;
    }

    public void setProCodigoBarra2(String proCodigoBarra2) {
        this.proCodigoBarra2 = proCodigoBarra2;
    }

    public String getProCodigoBarra3() {
        return proCodigoBarra3;
    }

    public void setProCodigoBarra3(String proCodigoBarra3) {
        this.proCodigoBarra3 = proCodigoBarra3;
    }

    public String getProCodigoBarra4() {
        return proCodigoBarra4;
    }

    public void setProCodigoBarra4(String proCodigoBarra4) {
        this.proCodigoBarra4 = proCodigoBarra4;
    }

    public String getProCodigoBarra5() {
        return proCodigoBarra5;
    }

    public void setProCodigoBarra5(String proCodigoBarra5) {
        this.proCodigoBarra5 = proCodigoBarra5;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public Boolean getProCreditoTributario() {
        return proCreditoTributario;
    }

    public void setProCreditoTributario(Boolean proCreditoTributario) {
        this.proCreditoTributario = proCreditoTributario;
    }

    public String getProCuentaGasto() {
        return proCuentaGasto;
    }

    public void setProCuentaGasto(String proCuentaGasto) {
        this.proCuentaGasto = proCuentaGasto;
    }

    public String getProCuentaInventario() {
        return proCuentaInventario;
    }

    public void setProCuentaInventario(String proCuentaInventario) {
        this.proCuentaInventario = proCuentaInventario;
    }

    public String getProCuentaTransferenciaIpp() {
        return proCuentaTransferenciaIpp;
    }

    public void setProCuentaTransferenciaIpp(String proCuentaTransferenciaIpp) {
        this.proCuentaTransferenciaIpp = proCuentaTransferenciaIpp;
    }

    public String getProCuentaVenta() {
        return proCuentaVenta;
    }

    public void setProCuentaVenta(String proCuentaVenta) {
        this.proCuentaVenta = proCuentaVenta;
    }

    public BigDecimal getProDescuento1() {
        return proDescuento1;
    }

    public void setProDescuento1(BigDecimal proDescuento1) {
        this.proDescuento1 = proDescuento1;
    }

    public BigDecimal getProDescuento2() {
        return proDescuento2;
    }

    public void setProDescuento2(BigDecimal proDescuento2) {
        this.proDescuento2 = proDescuento2;
    }

    public BigDecimal getProDescuento3() {
        return proDescuento3;
    }

    public void setProDescuento3(BigDecimal proDescuento3) {
        this.proDescuento3 = proDescuento3;
    }

    public BigDecimal getProDescuento4() {
        return proDescuento4;
    }

    public void setProDescuento4(BigDecimal proDescuento4) {
        this.proDescuento4 = proDescuento4;
    }

    public BigDecimal getProDescuento5() {
        return proDescuento5;
    }

    public void setProDescuento5(BigDecimal proDescuento5) {
        this.proDescuento5 = proDescuento5;
    }

    public String getProDetalle() {
        return proDetalle;
    }

    public void setProDetalle(String proDetalle) {
        this.proDetalle = proDetalle;
    }

    public String getProEmpaque() {
        return proEmpaque;
    }

    public void setProEmpaque(String proEmpaque) {
        this.proEmpaque = proEmpaque;
    }

    public String getProEmpresa() {
        return proEmpresa;
    }

    public void setProEmpresa(String proEmpresa) {
        this.proEmpresa = proEmpresa;
    }

    public BigDecimal getProFactorCajabulto() {
        return proFactorCajabulto;
    }

    public void setProFactorCajabulto(BigDecimal proFactorCajabulto) {
        this.proFactorCajabulto = proFactorCajabulto;
    }

    public Boolean getProInactivo() {
        return proInactivo;
    }

    public void setProInactivo(Boolean proInactivo) {
        this.proInactivo = proInactivo;
    }

    public String getProIva() {
        return proIva;
    }

    public void setProIva(String proIva) {
        this.proIva = proIva;
    }

    public BigDecimal getProMargenUtilidad1() {
        return proMargenUtilidad1;
    }

    public void setProMargenUtilidad1(BigDecimal proMargenUtilidad1) {
        this.proMargenUtilidad1 = proMargenUtilidad1;
    }

    public BigDecimal getProMargenUtilidad2() {
        return proMargenUtilidad2;
    }

    public void setProMargenUtilidad2(BigDecimal proMargenUtilidad2) {
        this.proMargenUtilidad2 = proMargenUtilidad2;
    }

    public BigDecimal getProMargenUtilidad3() {
        return proMargenUtilidad3;
    }

    public void setProMargenUtilidad3(BigDecimal proMargenUtilidad3) {
        this.proMargenUtilidad3 = proMargenUtilidad3;
    }

    public BigDecimal getProMargenUtilidad4() {
        return proMargenUtilidad4;
    }

    public void setProMargenUtilidad4(BigDecimal proMargenUtilidad4) {
        this.proMargenUtilidad4 = proMargenUtilidad4;
    }

    public BigDecimal getProMargenUtilidad5() {
        return proMargenUtilidad5;
    }

    public void setProMargenUtilidad5(BigDecimal proMargenUtilidad5) {
        this.proMargenUtilidad5 = proMargenUtilidad5;
    }

    public Integer getProMaximo() {
        return proMaximo;
    }

    public void setProMaximo(Integer proMaximo) {
        this.proMaximo = proMaximo;
    }

    public Integer getProMinimo() {
        return proMinimo;
    }

    public void setProMinimo(Integer proMinimo) {
        this.proMinimo = proMinimo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public BigDecimal getProPrecio1() {
        return proPrecio1;
    }

    public void setProPrecio1(BigDecimal proPrecio1) {
        this.proPrecio1 = proPrecio1;
    }

    public BigDecimal getProPrecio2() {
        return proPrecio2;
    }

    public void setProPrecio2(BigDecimal proPrecio2) {
        this.proPrecio2 = proPrecio2;
    }

    public BigDecimal getProPrecio3() {
        return proPrecio3;
    }

    public void setProPrecio3(BigDecimal proPrecio3) {
        this.proPrecio3 = proPrecio3;
    }

    public BigDecimal getProPrecio4() {
        return proPrecio4;
    }

    public void setProPrecio4(BigDecimal proPrecio4) {
        this.proPrecio4 = proPrecio4;
    }

    public BigDecimal getProPrecio5() {
        return proPrecio5;
    }

    public void setProPrecio5(BigDecimal proPrecio5) {
        this.proPrecio5 = proPrecio5;
    }

    public Boolean getProStockNegativo() {
        return proStockNegativo;
    }

    public void setProStockNegativo(Boolean proStockNegativo) {
        this.proStockNegativo = proStockNegativo;
    }

    public String getSusCodigo() {
        return susCodigo;
    }

    public void setSusCodigo(String susCodigo) {
        this.susCodigo = susCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipEmpresa() {
        return tipEmpresa;
    }

    public void setTipEmpresa(String tipEmpresa) {
        this.tipEmpresa = tipEmpresa;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInsertaProducto() {
        return usrFechaInsertaProducto;
    }

    public void setUsrFechaInsertaProducto(String usrFechaInsertaProducto) {
        this.usrFechaInsertaProducto = usrFechaInsertaProducto;
    }

    public String getUsrInsertaProducto() {
        return usrInsertaProducto;
    }

    public void setUsrInsertaProducto(String usrInsertaProducto) {
        this.usrInsertaProducto = usrInsertaProducto;
    }
}
