/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.DAO;

import cartera.TO.CarCuentasPorPagarCobrarSaldoAnticiposTO;
import cartera.TO.CarFunPagosPruebaTO;
import cartera.TO.CarListaPagosCobrosDetalleAnticipoTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesCarDAOLocal {

    Boolean buscarSector(String empresa, String codSector) throws Exception;

    Boolean buscarCuentasContables(String empresa, String ctaContable) throws Exception;

    cartera.entity.CarPagos buscarCarPagos(String empresa, String periodo, String tipo, String numero) throws java.lang.Exception;

    cartera.entity.CarPagosAnticipos buscarCarPagosAnticipos(String empresa, String periodo, String tipo, String numero) throws java.lang.Exception;

    cartera.entity.CarPagosForma buscarCarPagosForma(java.lang.Integer fpSecuencial) throws java.lang.Exception;

    java.lang.Boolean buscarCarPagosForma(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;

    java.lang.String buscarCtaFormaPago(java.lang.String empresa, java.lang.Integer secuencial) throws java.lang.Exception;

    cartera.TO.CarListaPagosProveedorTO getPagosConsultaProveedor(java.lang.String empresa, java.lang.String periodo, String tipo, java.lang.String numero) throws java.lang.Exception;

    cartera.TO.CarListaPagosProveedorTO getPagosConsultaProveedorAnticipo(java.lang.String empresa, java.lang.String periodo, String tipo, java.lang.String numero) throws java.lang.Exception;

    Boolean getCarReversarPago(String empresa, String periodo, String numero) throws Exception;

    Boolean getCarReversarPagoAnticipos(String empresa, String periodo, String numero) throws Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getPagosConsultaDetalleCompras(java.lang.String empresa, java.lang.String periodo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCarListaPagosTO(java.lang.String empresa, java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosDetalleFormaTO> getPagosConsultaDetalleForma(java.lang.String empresa, java.lang.String periodo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunPagosTO> getCarFunPagosTO(java.lang.String empresa, String sector, java.lang.String desde, java.lang.String hasta, java.lang.String proveedor) throws java.lang.Exception;

    java.util.List<CarFunPagosPruebaTO> getCarFunPagosPruebaTO(String empresa, String desde, String hasta, String proveedor) throws Exception;

    java.util.List<cartera.TO.CarFunPagosDetalleTO> getCarFunPagosDetalleTO(java.lang.String empresa, String sector, java.lang.String desde, java.lang.String hasta, java.lang.String proveedor, java.lang.String formaPago) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunPagosSaldoAnticipoTO> getCarFunPagosSaldoAnticipoTO(java.lang.String empresa, java.lang.String proveedor) throws java.lang.Exception;

    cartera.entity.CarCobros buscarCarCobros(String empresa, String periodo, String tipo, String numero) throws java.lang.Exception;

    cartera.entity.CarCobrosAnticipos buscarCarCobrosAnticipos(String empresa, String periodo, String tipo, String numero) throws java.lang.Exception;

    cartera.entity.CarCobrosForma buscarCarCobrosForma(java.lang.Integer fpSecuencial) throws java.lang.Exception;

    java.lang.Boolean buscarCarCobrosForma(java.lang.String ctaContable, java.lang.String empresa) throws java.lang.Exception;

    java.lang.String buscarCtaFormaCobro(java.lang.String empresa, java.lang.Integer secuencial) throws java.lang.Exception;

    cartera.TO.CarListaCobrosClienteTO getCobrosConsultaCliente(java.lang.String empresa, java.lang.String periodo, String tipo, java.lang.String numero) throws java.lang.Exception;

    cartera.TO.CarListaCobrosClienteTO getCobrosConsultaClienteAnticipo(java.lang.String empresa, java.lang.String periodo, String tipo, java.lang.String numero) throws java.lang.Exception;

    Boolean getCarReversarCobro(String empresa, String periodo, String numero) throws Exception;

    Boolean getCarReversarCobroAnticipos(String empresa, String periodo, String numero) throws Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCobrosConsultaDetalleVentas(java.lang.String empresa, java.lang.String periodo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCarListaCobrosTO(String empresa, String cliente) throws Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosDetalleFormaTO> getCobrosConsultaDetalleForma(java.lang.String empresa, java.lang.String periodo, java.lang.String numero, boolean hayPostfechados) throws java.lang.Exception;
    
    java.util.List<cartera.TO.CarListaPagosCobrosDetalleAnticipoTO> getCobrosConsultaDetalleAnticipo(String empresa, String periodo, String numero  ) throws Exception ;

    java.util.List<cartera.TO.CarFunCobrosTO> getCarFunCobrosTO(java.lang.String empresa, 
            String sector,
            java.lang.String desde, java.lang.String hasta, java.lang.String cliente) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunCobrosDetalleTO> getCarFunCobrosDetalleTO(java.lang.String empresa, 
            String sector,
            java.lang.String desde, java.lang.String hasta, java.lang.String cliente, java.lang.String formaPago) throws java.lang.Exception;

    java.util.List<cartera.TO.CarFunCobrosSaldoAnticipoTO> getCarFunCobrosSaldoAnticipoTO(java.lang.String empresa, java.lang.String cliente) throws java.lang.Exception;

    java.util.List<cartera.TO.CarComboPagosCobrosFormaTO> getCarComboPagosCobrosForma(java.lang.String empresa, char accion) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosFormaTO> getCarListaPagosCobrosForma(java.lang.String empresa, char accion) throws java.lang.Exception;

    java.util.List<cartera.TO.CarListaMayorAuxiliarClienteProveedorTO> getCarListaMayorAuxiliarClienteProveedorTO(
            java.lang.String empresa, String sector, java.lang.String proveedor, java.lang.String desde, java.lang.String hasta, char accion) throws java.lang.Exception;

    cartera.TO.CarPagosCobrosAnticipoTO getCarPagosCobrosAnticipoTO(String empresa, String periodo, String tipo, String numero, char accion) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorPagarDetalladoTO(String empresa, String sector, 
            String proveedor,
            String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorPagarGeneralTO(String empresa, String sector, String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorPagarAnticiposTO(String empresa, String sector, String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorCobrarAnticiposTO(String empresa, String sector, String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorCobrarDetalladoTO(String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta,
            boolean ichfa) throws Exception;

    java.util.List<cartera.TO.CarFunCuentasPorCobrarListadoVentasTO> getCarFunCuentasPorCobrarListadoVentasTO(String empresa, String sector, String cliente, String desde, String hasta) throws Exception;

    java.util.List<cartera.TO.CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(String empresa, String sector, String proveedor, String desde, String hasta) throws Exception;

    java.util.List<cartera.TO.CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorCobrarGeneralTO(String empresa, String sector, String hasta) throws Exception;

    java.util.List<cartera.TO.CarListaPagosCobrosTO> getCarListaCobrosVentasTO(java.lang.String empresa, java.lang.String cliente) throws java.lang.Exception;

    java.math.BigDecimal getValoresPendientesPorCancelar(java.lang.String empresa, java.lang.String cliente) throws java.lang.Exception;

    cartera.entity.CarCobrosAnticipos getCarCobrosAnticipos(java.lang.String empresa, java.lang.String periodo, java.lang.String tipo, java.lang.String numero) throws java.lang.Exception;

    java.util.List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorPagarSaldoAnticiposTO(String empresa, String sector,  String proveedorCodigo,String hasta) throws Exception;

    java.util.List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorCobrarSaldoAnticiposTO(String empresa, String sector, String clienteCodigo, String hasta) throws Exception;

    public List<CarListaPagosCobrosDetalleAnticipoTO> getPagosConsultaDetalleAnticipo(String empresa, String periodo, String numero)throws Exception;
}
