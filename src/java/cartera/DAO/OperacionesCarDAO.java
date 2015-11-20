/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.DAO;

import cartera.TO.*;
import cartera.entity.CarCobros;
import cartera.entity.CarCobrosAnticipos;
import cartera.entity.CarCobrosAnticiposPK;
import cartera.entity.CarCobrosForma;
import cartera.entity.CarCobrosPK;
import cartera.entity.CarPagos;
import cartera.entity.CarPagosAnticipos;
import cartera.entity.CarPagosAnticiposPK;
import cartera.entity.CarPagosForma;
import cartera.entity.CarPagosPK;
import cartera.entity.DAO.CarCobrosFacadeLocal;
import cartera.entity.DAO.CarCobrosFormaFacadeLocal;
import cartera.entity.DAO.CarPagosFacadeLocal;
import cartera.entity.DAO.CarPagosFormaFacadeLocal;
import cartera.helper.ConversionesCar;
import contabilidad.helper.ConversionesContabilidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesCarDAO implements OperacionesCarDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EJBShrimpPU")
    EntityManager em;
    @EJB
    CarPagosFacadeLocal carPagosFacadeLocal;
    @EJB
    CarCobrosFacadeLocal carCobrosFacadeLocal;
    @EJB
    CarPagosFormaFacadeLocal carPagosFormaFacadeLocal;
    @EJB
    CarCobrosFormaFacadeLocal carCobrosFormaFacadeLocal;
    @EJB
    cartera.entity.DAO.CarPagosAnticiposFacadeLocal carPagosAnticiposFacadeLocal;
    @EJB
    cartera.entity.DAO.CarCobrosAnticiposFacadeLocal carCobrosAnticiposFacadeLocal;

    // <editor-fold defaultstate="collapsed" debsc="BUSCAR ENTIDADES">
    @Override
    public CarPagos buscarCarPagos(String empresa, String periodo, String tipo, String numero) throws Exception {
        return carPagosFacadeLocal.find(new CarPagosPK(empresa, periodo, tipo, numero));
    }

    @Override
    public CarPagosAnticipos buscarCarPagosAnticipos(String empresa, String periodo, String tipo, String numero) throws Exception {
        return carPagosAnticiposFacadeLocal.find(new CarPagosAnticiposPK(empresa, periodo, tipo, numero));
    }

    @Override
    public CarCobros buscarCarCobros(String empresa, String periodo, String tipo, String numero) throws Exception {
        return carCobrosFacadeLocal.find(new CarCobrosPK(empresa, periodo, tipo, numero));
    }

    @Override
    public CarCobrosAnticipos buscarCarCobrosAnticipos(String empresa, String periodo, String tipo, String numero) throws Exception {
        return carCobrosAnticiposFacadeLocal.find(new CarCobrosAnticiposPK(empresa, periodo, tipo, numero));
    }

    @Override
    public CarPagosForma buscarCarPagosForma(Integer fpSecuencial) throws Exception {
        return carPagosFormaFacadeLocal.find(fpSecuencial);
    }

    @Override
    public CarCobrosForma buscarCarCobrosForma(Integer fpSecuencial) throws Exception {
        return carCobrosFormaFacadeLocal.find(fpSecuencial);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGOS">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosProveedorTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedor(String empresa, String periodo, String tipo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaPagosProveedor_CarListaPagosProveedorTO(em.createNativeQuery("SELECT inv_proveedor.prov_codigo, "
                + "inv_proveedor.prov_nombre, inv_proveedor.prov_id_numero, "
                + "inv_proveedor.prov_direccion, "
                + "con_contable.con_observaciones, con_contable.con_fecha "
                + "FROM cartera.car_pagos INNER JOIN inventario.inv_proveedor "
                + "ON car_pagos.prov_empresa = inv_proveedor.prov_empresa AND "
                + "car_pagos.prov_codigo = inv_proveedor.prov_codigo "
                + "INNER JOIN contabilidad.con_contable "
                + "ON car_pagos.pag_empresa = con_contable.con_empresa AND "
                + "car_pagos.pag_periodo = con_contable.con_periodo AND "
                + "car_pagos.pag_tipo = con_contable.con_tipo AND "
                + "car_pagos.pag_numero = con_contable.con_numero "
                + "WHERE car_pagos.pag_empresa = '" + empresa + "' AND "
                + "car_pagos.pag_periodo = '" + periodo + "' AND "
                + "car_pagos.pag_tipo = '" + tipo + "' AND "
                + "car_pagos.pag_numero = '" + numero + "';").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosProveedorTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public CarListaPagosProveedorTO getPagosConsultaProveedorAnticipo(String empresa, String periodo, String tipo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaPagosProveedor_CarListaPagosProveedorTO(em.createNativeQuery("SELECT inv_proveedor.prov_codigo, "
                + "inv_proveedor.prov_nombre, inv_proveedor.prov_id_numero, "
                + "inv_proveedor.prov_direccion, "
                + "con_contable.con_observaciones, con_contable.con_fecha "
                + "FROM cartera.car_pagos_anticipos INNER JOIN inventario.inv_proveedor "
                + "ON car_pagos_anticipos.prov_empresa = inv_proveedor.prov_empresa AND "
                + "car_pagos_anticipos.prov_codigo = inv_proveedor.prov_codigo "
                + "INNER JOIN contabilidad.con_contable "
                + "ON car_pagos_anticipos.ant_empresa = con_contable.con_empresa AND "
                + "car_pagos_anticipos.ant_periodo = con_contable.con_periodo AND "
                + "car_pagos_anticipos.ant_tipo = con_contable.con_tipo AND "
                + "car_pagos_anticipos.ant_numero = con_contable.con_numero "
                + "WHERE car_pagos_anticipos.ant_empresa = '" + empresa + "' AND "
                + "car_pagos_anticipos.ant_periodo = '" + periodo + "' AND "
                + "car_pagos_anticipos.ant_tipo = '" + tipo + "' AND "
                + "car_pagos_anticipos.ant_numero = '" + numero + "';").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return Boolean
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean getCarReversarPago(String empresa, String periodo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT pag_reversado "
                + "FROM cartera.car_pagos "
                + "WHERE car_pagos.pag_empresa = '" + empresa + "' "
                + "AND car_pagos.pag_periodo = '" + periodo + "' "
                + "AND car_pagos.pag_tipo = 'C-PAG' "
                + "AND car_pagos.pag_numero = '" + numero + "';").
                getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return Boolean
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean getCarReversarPagoAnticipos(String empresa, String periodo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT ant_reversado "
                + "FROM cartera.car_pagos_anticipos "
                + "WHERE car_pagos_anticipos.ant_empresa = '" + empresa + "' "
                + "AND car_pagos_anticipos.ant_periodo = '" + periodo + "' "
                + "AND (car_pagos_anticipos.ant_tipo = 'C-APRO' OR car_pagos_anticipos.ant_tipo = 'C-PAG') "
                + "AND car_pagos_anticipos.ant_numero = '" + numero + "';").
                getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosDetalleComprasTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosTO> getPagosConsultaDetalleCompras(String empresa, String periodo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobrosConsultaDetalle_CarListaPagosCobrosConsultaDetalleTO(em.createNativeQuery("SELECT car_pagos_detalle_compras.comp_periodo as periodo, "
                + "car_pagos_detalle_compras.comp_motivo as motivo, "
                + "car_pagos_detalle_compras.comp_numero as numero, "
                + "inv_compras.comp_numero_alterno as alterno, "
                + "inv_compras.comp_documento_numero as documento, "
                + "inv_compras.comp_fecha as fecha, "
                + "inv_compras.comp_fecha_vencimiento as vence, "
                + "inv_compras.comp_total - inv_compras.comp_valor_retenido as total, "
                + "det_valor as abono, NULL "
                + "FROM cartera.car_pagos INNER JOIN cartera.car_pagos_detalle_compras INNER JOIN inventario.inv_compras "
                + "ON car_pagos_detalle_compras.comp_empresa = inv_compras.comp_empresa AND "
                + "car_pagos_detalle_compras.comp_periodo = inv_compras.comp_periodo AND "
                + "car_pagos_detalle_compras.comp_motivo = inv_compras.comp_motivo AND "
                + "car_pagos_detalle_compras.comp_numero = inv_compras.comp_numero "
                + "ON car_pagos.pag_empresa = car_pagos_detalle_compras.pag_empresa AND "
                + "car_pagos.pag_periodo = car_pagos_detalle_compras.pag_periodo AND "
                + "car_pagos.pag_tipo = car_pagos_detalle_compras.pag_tipo AND "
                + "car_pagos.pag_numero = car_pagos_detalle_compras.pag_numero "
                + "WHERE car_pagos.pag_empresa = '" + empresa + "' AND "
                + "car_pagos.pag_periodo = '" + periodo + "' AND "
                + "car_pagos.pag_tipo = 'C-PAG' AND "
                + "car_pagos.pag_numero = '" + numero + "' "
                + "ORDER BY periodo, motivo, numero;").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosDetalleFormaTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getPagosConsultaDetalleForma(String empresa, String periodo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobrosDetalleForma_CarListaPagosCobrosDetalleFormaTO(em.createNativeQuery("SELECT car_pagos_forma.fp_detalle as forma, "
                + "car_pagos_detalle_forma.det_referencia as referencia, "
                + "car_pagos_detalle_forma.det_valor as valor, "
                + "car_pagos_detalle_forma.det_observaciones as observaciones "
                + "FROM cartera.car_pagos INNER JOIN cartera.car_pagos_detalle_forma INNER JOIN cartera.car_pagos_forma "
                + "ON car_pagos_detalle_forma.fp_secuencial = car_pagos_forma.fp_secuencial "
                + "ON car_pagos.pag_empresa = car_pagos_detalle_forma.pag_empresa AND "
                + "car_pagos.pag_periodo = car_pagos_detalle_forma.pag_periodo AND "
                + "car_pagos.pag_tipo = car_pagos_detalle_forma.pag_tipo AND "
                + "car_pagos.pag_numero = car_pagos_detalle_forma.pag_numero "
                + "WHERE car_pagos.pag_empresa = '" + empresa + "' AND "
                + "car_pagos.pag_periodo = '" + periodo + "' AND "
                + "car_pagos.pag_tipo = 'C-PAG' AND "
                + "car_pagos.pag_numero = '" + numero + "';").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param proveedor
     * @return lista de CarFunPagosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunPagosTO> getCarFunPagosTO(String empresa, String sector, String desde, String hasta, String proveedor) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarFunPagos_CarFunPagosTO(
                em.createNativeQuery("SELECT * FROM cartera.fun_Pagos('" + empresa + "', " 
//                + sector + "', "     //Cuando ya este lista la función, descomentar esta linea
                + desde + ", " + hasta + ", " +
                proveedor + ");").getResultList());
    }
    
    /////////////////////NNOOOOOOOOOOOOOOOOOOOOOO
//     public List<CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(String empresa, String sector, String proveedor, String desde, String hasta) throws Exception {
//        hasta = hasta == null ? hasta : "'" + hasta + "'";
//        desde = desde == null ? desde : "'" + desde + "'";
//        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
//        sector = sector == null ? sector : "'" + sector + "'";
//        return ConversionesCar.convertirCarFunCuentasPorPagarListadoCompras_CarFunCuentasPorPagarListadoComprasTO(
//    em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_pagar_listado_compras('" + empresa + "', "
//                + "" + sector + ", " + proveedor + ", " + desde + ", " + hasta + ")").getResultList());
//    }


    @Override
    public List<CarFunPagosPruebaTO> getCarFunPagosPruebaTO(String empresa, String desde, String hasta, String proveedor) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        return ConversionesCar.convertirCarFunPagosPrueba_CarFunPagosPruebaTO(em.createNativeQuery("SELECT * FROM cartera.fun_Pagos('" + empresa + "', " + desde + ", " + hasta + ", " + proveedor + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param proveedor
     * @return lista de CarFunPagosDetalleTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunPagosDetalleTO> getCarFunPagosDetalleTO(String empresa, String sector, String desde, 
    String hasta, String proveedor, String formaPago) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        formaPago = formaPago == null ? formaPago : "'" + formaPago + "'";
        return ConversionesCar.convertirCarFunPagosDetalle_CarFunPagosDetalleTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_pagos_detalle('"
                + empresa + "', "
                //+ sector + ", "    //Cuando ya este lista la función, descomentar esta linea
                + desde + ", "
                + hasta + ", "
                + proveedor + ", "
                + formaPago + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param proveedor
     * @return lista de CarFunPagosSaldoAnticipoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunPagosSaldoAnticipoTO> getCarFunPagosSaldoAnticipoTO(String empresa, String proveedor) throws Exception {
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        return ConversionesCar.convertirCarFunPagosSaldoAnticipo_CarFunPagosSaldoAnticipoTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_cuentas_por_pagar_saldo_anticipos('"
                + empresa + "', "
                + "null, "
                + proveedor + ", null);").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="COBROS">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaCobrosClienteTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public CarListaCobrosClienteTO getCobrosConsultaCliente(String empresa, String periodo, String tipo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaCobrosCliente_CarListaCobrosClienteTO(em.createNativeQuery("SELECT inv_cliente.cli_codigo, inv_cliente.cli_nombre, "
                + "inv_cliente.cli_id_numero, inv_cliente.cli_direccion, "
                + "con_contable.con_observaciones, con_contable.con_fecha "
                + "FROM cartera.car_cobros INNER JOIN inventario.inv_cliente "
                + "ON car_cobros.cli_empresa = inv_cliente.cli_empresa "
                + "AND car_cobros.cli_codigo = inv_cliente.cli_codigo "
                + "INNER JOIN contabilidad.con_contable "
                + "ON car_cobros.cob_empresa = con_contable.con_empresa "
                + "AND car_cobros.cob_periodo = con_contable.con_periodo "
                + "AND car_cobros.cob_tipo = con_contable.con_tipo "
                + "AND car_cobros.cob_numero = con_contable.con_numero "
                + "WHERE car_cobros.cob_empresa = '" + empresa + "' "
                + "AND car_cobros.cob_periodo = '" + periodo + "' "
                + "AND car_cobros.cob_tipo = '" + tipo + "' "
                + "AND car_cobros.cob_numero = '" + numero + "';").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaCobrosClienteTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public CarListaCobrosClienteTO getCobrosConsultaClienteAnticipo(String empresa, String periodo, String tipo, String numero) throws Exception {
        String sql = "SELECT inv_cliente.cli_codigo, "
                + "inv_cliente.cli_nombre, inv_cliente.cli_id_numero, "
                + "inv_cliente.cli_direccion, "
                + "con_contable.con_observaciones, con_contable.con_fecha "
                + "FROM cartera.car_cobros_anticipos INNER JOIN inventario.inv_cliente "
                + "ON car_cobros_anticipos.cli_empresa = inv_cliente.cli_empresa AND "
                + "car_cobros_anticipos.cli_codigo = inv_cliente.cli_codigo "
                + "INNER JOIN contabilidad.con_contable "
                + "ON car_cobros_anticipos.ant_empresa = con_contable.con_empresa AND "
                + "car_cobros_anticipos.ant_periodo = con_contable.con_periodo AND "
                + "car_cobros_anticipos.ant_tipo = con_contable.con_tipo AND "
                + "car_cobros_anticipos.ant_numero = con_contable.con_numero "
                + "WHERE car_cobros_anticipos.ant_empresa = '" + empresa + "' AND "
                + "car_cobros_anticipos.ant_periodo = '" + periodo + "' AND "
                + "car_cobros_anticipos.ant_tipo = '" + tipo + "' AND "
                + "car_cobros_anticipos.ant_numero = '" + numero + "';";        
        return ConversionesCar.convertirCarListaCobrosCliente_CarListaCobrosClienteTO(em.createNativeQuery(sql).
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return Boolean
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean getCarReversarCobro(String empresa, String periodo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT cob_reversado "
                + "FROM cartera.car_cobros "
                + "WHERE car_cobros.cob_empresa = '" + empresa + "' "
                + "AND car_cobros.cob_periodo = '" + periodo + "' "
                + "AND car_cobros.cob_tipo = 'C-COB' "
                + "AND car_cobros.cob_numero = '" + numero + "';").
                getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return Boolean
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean getCarReversarCobroAnticipos(String empresa, String periodo, String numero) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT ant_reversado "
                + "FROM cartera.car_cobros_anticipos "
                + "WHERE car_cobros_anticipos.ant_empresa = '" + empresa + "' "
                + "AND car_cobros_anticipos.ant_periodo = '" + periodo + "' "
                + "AND (car_cobros_anticipos.ant_tipo = 'C-ACLI' OR car_cobros_anticipos.ant_tipo = 'C-COB') "
                + "AND car_cobros_anticipos.ant_numero = '" + numero + "';").
                getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosDetalleComprasTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosTO> getCobrosConsultaDetalleVentas(String empresa, String periodo, String numero) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobrosConsultaDetalle_CarListaPagosCobrosConsultaDetalleTO(em.createNativeQuery("SELECT car_cobros_detalle_ventas.vta_periodo as periodo, "
                + "car_cobros_detalle_ventas.vta_motivo as motivo, "
                + "car_cobros_detalle_ventas.vta_numero as numero, "
                + "inv_ventas.vta_numero_alterno as alterno, "
                + "inv_ventas.vta_documento_numero as documento, "
                + "inv_ventas.vta_fecha as fecha, "
                + "inv_ventas.vta_fecha_vencimiento as vence, "
                + "inv_ventas.vta_total total, det_valor as abono, NULL "
                + "FROM cartera.car_cobros "
                + "INNER JOIN cartera.car_cobros_detalle_ventas "
                + "INNER JOIN inventario.inv_ventas "
                + "ON car_cobros_detalle_ventas.vta_empresa = inv_ventas.vta_empresa "
                + "AND car_cobros_detalle_ventas.vta_periodo = inv_ventas.vta_periodo "
                + "AND car_cobros_detalle_ventas.vta_motivo = inv_ventas.vta_motivo "
                + "AND car_cobros_detalle_ventas.vta_numero = inv_ventas.vta_numero "
                + "ON car_cobros.cob_empresa = car_cobros_detalle_ventas.cob_empresa "
                + "AND car_cobros.cob_periodo = car_cobros_detalle_ventas.cob_periodo "
                + "AND car_cobros.cob_tipo = car_cobros_detalle_ventas.cob_tipo "
                + "AND car_cobros.cob_numero = car_cobros_detalle_ventas.cob_numero "
                + "WHERE car_cobros.cob_empresa = '" + empresa + "' "
                + "AND car_cobros.cob_periodo = '" + periodo + "' "
                + "AND car_cobros.cob_tipo = 'C-COB' "
                + "AND car_cobros.cob_numero = '" + numero + "' "
                + "ORDER BY periodo, motivo, numero;").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return CarListaPagosCobrosDetalleFormaTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosDetalleFormaTO> getCobrosConsultaDetalleForma(String empresa, String periodo, String numero) throws Exception {
        String sql = "SELECT car_cobros_forma.fp_detalle as forma, "
                + "car_cobros_detalle_forma.det_referencia as referencia, "
                + "car_cobros_detalle_forma.det_valor as valor, "
                + "car_cobros_detalle_forma.det_observaciones as observaciones "
                + "FROM cartera.car_cobros "
                + "INNER JOIN cartera.car_cobros_detalle_forma "
                + "INNER JOIN cartera.car_cobros_forma "
                + "ON car_cobros_detalle_forma.fp_secuencial = car_cobros_forma.fp_secuencial "
                + "ON car_cobros.cob_empresa = car_cobros_detalle_forma.cob_empresa "
                + "AND car_cobros.cob_periodo = car_cobros_detalle_forma.cob_periodo "
                + "AND car_cobros.cob_tipo = car_cobros_detalle_forma.cob_tipo "
                + "AND car_cobros.cob_numero = car_cobros_detalle_forma.cob_numero "
                + "WHERE car_cobros.cob_empresa = '" + empresa + "' "
                + "AND car_cobros.cob_periodo = '" + periodo + "' "
                + "AND car_cobros.cob_tipo = 'C-COB' "
                + "AND car_cobros.cob_numero = '" + numero + "';";
        return ConversionesCar.convertirCarListaPagosCobrosDetalleForma_CarListaPagosCobrosDetalleFormaTO(em.createNativeQuery(sql).
                getResultList());
    }
    /**
     * @autor carlos
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return getCobrosConsultaDetalleAnticipo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosDetalleAnticipoTO> getCobrosConsultaDetalleAnticipo(String empresa, String periodo, String numero) throws Exception {
        String sql = "SELECT  ant_periodo, ant_tipo, ant_numero, con_contable.con_fecha,"
                + "car_cobros_detalle_anticipos.det_valor as valor "
                + "FROM  cartera.car_cobros "
                + "INNER JOIN cartera.car_cobros_detalle_anticipos "
                + "INNER JOIN contabilidad.con_contable "
                + "ON car_cobros_detalle_anticipos.ant_empresa = con_contable.con_empresa AND "
                + "car_cobros_detalle_anticipos.ant_periodo = con_contable.con_periodo AND "
                + "car_cobros_detalle_anticipos.ant_tipo = con_contable.con_tipo AND "
                + "car_cobros_detalle_anticipos.ant_numero = con_contable.con_numero "
                + "ON car_cobros.cob_empresa = car_cobros_detalle_anticipos.cob_empresa AND "
                + "car_cobros.cob_periodo = car_cobros_detalle_anticipos.cob_periodo AND "
                + "car_cobros.cob_tipo = car_cobros_detalle_anticipos.cob_tipo AND "
                + "car_cobros.cob_numero = car_cobros_detalle_anticipos.cob_numero "
                + "WHERE car_cobros.cob_empresa = '"+ empresa + "' "
                + "AND car_cobros.cob_periodo = '"+ periodo + "' "
                + "AND car_cobros.cob_tipo = 'C-COB' "
                + "AND car_cobros.cob_numero = '" + numero + "';";
        return ConversionesCar.convertirCarListaPagosCobrosDetalleAnticipo_CarListaPagosCobrosDetalleAnticipoTO(em.createNativeQuery(sql).
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param cliente
     * @return lista de CarFunCobrosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunCobrosTO> getCarFunCobrosTO(String empresa, 
    String sector,
    String desde, String hasta, String cliente) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarFunCobros_CarFunCobrosTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_cobros('" + empresa + "', " 
                //+ sector + ", "    //Descomentar esta linea cuando ya esta la lista la funcion correspondiente.
                + desde + ", "
                + hasta + ", " + cliente + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @param cliente
     * @return lista de CarFunCobrosDetalleTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunCobrosDetalleTO> getCarFunCobrosDetalleTO(String empresa, 
    String sector,    
    String desde, String hasta, String cliente, String formaPago) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        formaPago = formaPago == null ? formaPago : "'" + formaPago + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarFunCobrosDetalle_CarFunCobrosDetalleTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_cobros_detalle('"
                + empresa + "', "
//                + sector + ", "   //Descomentar esta linea cuando ya esta la lista la funcion correspondiente.
                + desde + ", "
                + hasta + ", "
                + cliente + ", "
                + formaPago + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cliente
     * @return lista de CarFunPagosSaldoAnticipoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunCobrosSaldoAnticipoTO> getCarFunCobrosSaldoAnticipoTO(String empresa, String cliente) throws Exception {
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        String sql = "SELECT * FROM cartera.fun_cuentas_por_cobrar_saldo_anticipos('"
                + empresa + "', "
                + null+", "
                + cliente + ", "
                + null+ ");";
        return ConversionesCar.convertirCarFunCobrosSaldoAnticipo_CarFunCobrosSaldoAnticipoTO(em.createNativeQuery(sql).getResultList());
    }
    // </editor-fold>

    /**
     * @autor misayo
     *
     * @param empresa
     * @param provCodigo
     * @return cuenta Forma Pago
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaFormaPago(String empresa, Integer secuencial) throws Exception {
        try {
            return validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery("SELECT cta_codigo "
                    + "FROM cartera.car_pagos_forma "
                    + "WHERE (usr_empresa = '" + empresa + "') AND "
                    + "(fp_secuencial = " + secuencial + ") AND "
                    + "(NOT fp_inactivo OR fp_inactivo IS NULL);").getResultList(), 0)[0].toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param provCodigo
     * @return cuenta Forma Pago
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaFormaCobro(String empresa, Integer secuencial) throws Exception {
        try {
            return validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery("SELECT cta_codigo "
                    + "FROM cartera.car_cobros_forma "
                    + "WHERE (usr_empresa = '" + empresa + "') AND "
                    + "(fp_secuencial = " + secuencial + ") AND "
                    + "(NOT fp_inactivo OR fp_inactivo IS NULL);").getResultList(), 0)[0].toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String proveedor
     * @return CarListaPagosCobrosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosTO> getCarListaPagosTO(String empresa, String proveedor) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobros_CarListaPagosCobrosTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_pagar('" + empresa + "', '" + proveedor + "');").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String cliente
     * @return CarListaPagosCobrosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosTO> getCarListaCobrosTO(String empresa, String cliente) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobros_CarListaPagosCobrosTO(
                em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_cobrar('" + empresa + "', '" + cliente + "');").
                getResultList());
    }

    @Override
    public Boolean buscarCuentasContables(String empresa, String ctaContable) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) "
                + "FROM contabilidad.con_cuentas "
                + "WHERE (cta_empresa = '" + empresa + "') "
                + "AND (cta_codigo = '" + ctaContable + "') "
                + "AND (cta_activo = TRUE);").getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    @Override
    public Boolean buscarSector(String empresa, String codSector) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) "
                + "FROM produccion.prd_sector "
                + "WHERE (sec_empresa = '" + empresa + "') "
                + "AND (sec_codigo = '" + codSector + "') "
                + "AND (sec_activo = TRUE);").getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    // <editor-fold defaultstate="collapsed" debsc="FORMA PAGO">
    @Override
    public Boolean buscarCarPagosForma(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) "
                + "FROM cartera.car_pagos_forma "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    @Override
    public Boolean buscarCarCobrosForma(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) "
                + "FROM cartera.car_cobros_forma "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de CarComboPagosForma
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarComboPagosCobrosFormaTO> getCarComboPagosCobrosForma(String empresa, char accion) throws Exception {
        if (accion == 'P') {
            return ConversionesCar.convertirCarComboPagosCobrosForma_CarComboPagosCobrosFormaTO(em.createNativeQuery("SELECT fp_secuencial, sec_codigo || ' | ' || fp_detalle fp_detalle, car_pagos_forma.cta_codigo, ban_cuenta.cta_empresa IS NOT NULL validar "
                    + "FROM cartera.car_pagos_forma LEFT JOIN banco.ban_cuenta "
                    + "ON car_pagos_forma.cta_empresa = ban_cuenta.cta_empresa AND "
                    + "car_pagos_forma.cta_codigo = ban_cuenta.cta_cuenta_contable WHERE car_pagos_forma.cta_empresa = '" + empresa + "' AND NOT fp_inactivo "
                    + "ORDER BY sec_codigo, fp_detalle").getResultList());
        } //            return ConversionesCar.convertirCarComboPagosCobrosForma_CarComboPagosCobrosFormaTO(em.
        //                    createNativeQuery("SELECT fp_secuencial, fp_detalle, sec_codigo "
        //                    + "FROM cartera.car_pagos_forma WHERE (usr_empresa = '"+empresa+"') AND "
        //                    + "(NOT fp_inactivo OR fp_inactivo IS NULL);").getResultList());
        else {
            return ConversionesCar.convertirCarComboPagosCobrosForma_CarComboPagosCobrosFormaTO(em.createNativeQuery("SELECT fp_secuencial, sec_codigo || ' | ' || fp_detalle fp_detalle FROM cartera.car_cobros_forma LEFT JOIN banco.ban_cuenta "
                    + "ON car_cobros_forma.cta_empresa = ban_cuenta.cta_empresa AND car_cobros_forma.cta_codigo = ban_cuenta.cta_cuenta_contable "
                    + "WHERE car_cobros_forma.cta_empresa = '" + empresa + "' AND NOT fp_inactivo ORDER BY sec_codigo, fp_detalle;").getResultList());
        }
//            return ConversionesCar.convertirCarComboPagosCobrosForma_CarComboPagosCobrosFormaTO(em.
//                    createNativeQuery("SELECT fp_secuencial, fp_detalle, sec_codigo "
//                    + "FROM cartera.car_cobros_forma WHERE (usr_empresa = '"+empresa+"') AND "
//                    + "(NOT fp_inactivo OR fp_inactivo IS NULL);").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de CarComboPagosForma
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosFormaTO> getCarListaPagosCobrosForma(String empresa, char accion) throws Exception {
        if (accion == 'P') {
            return ConversionesCar.convertirCarListaPagosCobrosForma_CarListaPagosCobrosFormaTO(em.createNativeQuery("SELECT fp_secuencial, cta_codigo, fp_detalle, sec_codigo, fp_inactivo "
                    + "FROM cartera.car_pagos_forma "
                    + "WHERE (usr_empresa = '" + empresa + "');").getResultList());
        } else {
            return ConversionesCar.convertirCarListaPagosCobrosForma_CarListaPagosCobrosFormaTO(em.createNativeQuery("SELECT fp_secuencial, cta_codigo, fp_detalle, sec_codigo, fp_inactivo "
                    + "FROM cartera.car_cobros_forma "
                    + "WHERE (usr_empresa = '" + empresa + "');").getResultList());
        }
    }
    // </editor-fold>

    /**
     * @autor misayo
     *
     * @param empresa
     * @param proveedor
     * @param desde
     * @param hasta
     * @return lista de CarListaMayorAuxiliarClienteProveedorTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaMayorAuxiliarClienteProveedorTO> getCarListaMayorAuxiliarClienteProveedorTO(String empresa, String sector, String codigo, String desde, String hasta, char accion) throws Exception {
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        if (accion == 'P') {
            return ConversionesCar.convertirCarListaMayorAuxiliarClienteProveedor_CarListaMayorAuxiliarClienteProveedorTO(em.createNativeQuery("SELECT * FROM cartera."
                    + "fun_mayor_auxiliar_proveedor('" + empresa + "', '" + codigo + "', "
                    + desde + ", " + hasta + ");").getResultList());
        } else {
            return ConversionesCar.convertirCarListaMayorAuxiliarClienteProveedor_CarListaMayorAuxiliarClienteProveedorTO(em.createNativeQuery("SELECT * FROM cartera."
                    + "fun_mayor_auxiliar_cliente('" + empresa + "', '" 
                    //+ sector + ", '"     //Cuando ya este lista la función, descomentar esta linea
                    + codigo + "', "
                    + desde + ", " + hasta + ");").getResultList());
        }
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @param accion
     * @return CarPagosCobrosAnticipoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public cartera.TO.CarPagosCobrosAnticipoTO getCarPagosCobrosAnticipoTO(String empresa, String periodo, String tipo, String numero, char accion) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        periodo = periodo == null ? periodo : "'" + periodo + "'";
        tipo = tipo == null ? tipo : "'" + tipo + "'";
        numero = numero == null ? numero : "'" + numero + "'";
        if (accion == 'P') {
            return ConversionesCar.convertirCarPagosCobrosAnticipo_CarPagosCobrosAnticipoTO(em.createNativeQuery("SELECT ant_valor, fp_secuencial, sec_codigo "
                    + "FROM cartera.car_pagos_anticipos "
                    + "WHERE ant_empresa = " + empresa + " AND "
                    + "ant_periodo = " + periodo + " AND "
                    + "ant_tipo = " + tipo + " AND "
                    + "ant_numero = " + numero + ";").getResultList());
        } else {
            return ConversionesCar.convertirCarPagosCobrosAnticipo_CarPagosCobrosAnticipoTO(em.createNativeQuery("SELECT ant_valor, fp_secuencial, sec_codigo "
                    + "FROM cartera.car_cobros_anticipos "
                    + "WHERE ant_empresa = " + empresa + " AND "
                    + "ant_periodo = " + periodo + " AND "
                    + "ant_tipo = " + tipo + " AND "
                    + "ant_numero = " + numero + ";").getResultList());
        }
    }

    /**
     * @autor jack
     *
     * @param empresa
     * @param sector
     * @param hasta
     * @return lista de CarCuentasPorPagarDetalladoTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorPagarDetalladoTO(String empresa, String sector, 
    String proveedor,
    String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarDetallado_CarCuentasPorPagarDetalladoTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_cuentas_por_pagar_detallado('" + empresa + "', " 
                + sector + ", " 
                + proveedor + ", " 
                + hasta + ")").getResultList());
    }

    /**
     * @autor jack
     *
     * @param empresa
     * @param sector
     * @param hasta
     * @return lista de CarCuentasPorPagarGeneralTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorPagarGeneralTO(String empresa, String sector, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarCobrarGeneral_CarCuentasPorPagarCobrarGeneralTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_pagar_general('" + empresa + "', " + sector + ", " + hasta + ")").getResultList());
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorPagarAnticiposTO(String empresa, String sector, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarAnticipos_CarCuentasPorPagarAnticiposTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_pagar_vs_anticipos('" + empresa + "', " + sector + ", " + hasta + ")").getResultList());
    }

    @Override
    public List<CarCuentasPorPagarCobrarAnticiposTO> getCarListaCuentasPorCobrarAnticiposTO(String empresa, String sector, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarAnticipos_CarCuentasPorPagarAnticiposTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_cobrar_vs_anticipos('" + empresa + "', " + sector + ", " + hasta + ")").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param hasta
     * @return lista de CarCuentasPorPagarDetalladoTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarCuentasPorPagarCobrarDetalladoTO> getCarListaCuentasPorCobrarDetalladoTO(String empresa,
            String sector,
            String cliente,
            String desde,
            String hasta,
            boolean ichfa) throws Exception {
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarDetallado_CarCuentasPorPagarDetalladoTO(em.createNativeQuery(
                "SELECT * FROM cartera.fun_cuentas_por_cobrar_detallado("
                + "'" + empresa + "', "
                + sector + ", "
                + cliente + ", " 
                + desde + ", "
                + hasta + ", "
                + ichfa + ")").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param desde
     * @param hasta
     * @return lista de CarCuentasPorPagarGeneralTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunCuentasPorCobrarListadoVentasTO> getCarFunCuentasPorCobrarListadoVentasTO(String empresa, String sector, String cliente, String desde, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        cliente = cliente == null ? cliente : "'" + cliente + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarFunCuentasPorCobrarListadoVentas_CarFunCuentasPorCobrarListadoVentasTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_cobrar_listado_ventas('" + empresa + "', "
                + "" + sector + ", " + cliente + ", " + desde + ", " + hasta + ")").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param desde
     * @param hasta
     * @return lista de CarCuentasPorPagarGeneralTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarFunCuentasPorPagarListadoComprasTO> getCarFunCuentasPorPagarListadoComprasTO(String empresa, String sector, String proveedor, String desde, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        proveedor = proveedor == null ? proveedor : "'" + proveedor + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarFunCuentasPorPagarListadoCompras_CarFunCuentasPorPagarListadoComprasTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_pagar_listado_compras('" + empresa + "', "
                + "" + sector + ", " + proveedor + ", " + desde + ", " + hasta + ")").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param hasta
     * @return lista de CarCuentasPorPagarGeneralTO's
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarCuentasPorPagarCobrarGeneralTO> getCarListaCuentasPorCobrarGeneralTO(String empresa, String sector, String hasta) throws Exception {
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesCar.convertirCarListaCuentasPorPagarCobrarGeneral_CarCuentasPorPagarCobrarGeneralTO(em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_cobrar_general('" + empresa + "', "
                + "" + sector + ", " + hasta + ")").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param String empresa
     * @param String cliente
     * @return CarListaPagosCobrosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<CarListaPagosCobrosTO> getCarListaCobrosVentasTO(String empresa, String cliente) throws Exception {
        return ConversionesCar.convertirCarListaPagosCobros_CarListaPagosCobrosTO(
                em.createNativeQuery("SELECT * FROM cartera.fun_cuentas_por_cobrar('" + empresa + "', '" + cliente + "');").
                getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param String empresa
     * @param String cliente
     * @return Los valores Pendientes Por Cancelar
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.math.BigDecimal getValoresPendientesPorCancelar(String empresa, String cliente) throws Exception {
        return new java.math.BigDecimal("0.00");
//        return new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(em.
//                createNativeQuery("SELECT SUM(cxcc_saldo) FROM cartera.fun_cuentas_por_cobrar('UT', '00004')").getResultList(), 0)[0].toString());
    }

    /**
     * @autor Jack Krauser
     *
     * @param String empresa
     * @param String cliente
     * @return Los cobros de anticipos consultar
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public cartera.entity.CarCobrosAnticipos getCarCobrosAnticipos(String empresa, String periodo, String tipo, String numero) throws Exception {
        return carCobrosAnticiposFacadeLocal.find(new cartera.entity.CarCobrosAnticiposPK(empresa, periodo, tipo, numero));
//        return new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(em.
//                createNativeQuery("SELECT SUM(cxcc_saldo) FROM cartera.fun_cuentas_por_cobrar('UT', '00004')").getResultList(), 0)[0].toString());
    }

    @Override
    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorPagarSaldoAnticiposTO(
            String empresa, 
            String sector, 
            String proveedorCodigo,
            String hasta) throws Exception {

        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        proveedorCodigo = proveedorCodigo == null ? proveedorCodigo : "'" + proveedorCodigo + "'";
        String sql = "SELECT * FROM cartera.fun_cuentas_por_pagar_saldo_anticipos('" + empresa + "', " + sector + ", " +proveedorCodigo+", "+ hasta + ")";
        return ConversionesContabilidad.convertirCuentasPorPagarCobrarSaldoAnticipos_CuentasPorCobrarSaldoAnticiposTO(
                em.createNativeQuery(sql).getResultList());

    }

    @Override
    public List<CarCuentasPorPagarCobrarSaldoAnticiposTO> getCarListaCuentasPorCobrarSaldoAnticiposTO(
            String empresa, 
            String sector, 
            String clienteCodigo,
            String hasta) throws Exception {

        hasta = hasta == null ? hasta : "'" + hasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        clienteCodigo = clienteCodigo == null ? clienteCodigo : "'" + clienteCodigo + "'";
        String sql = "SELECT * FROM cartera.fun_cuentas_por_cobrar_saldo_anticipos('" + empresa + "', " + sector + ", "+clienteCodigo +", "+ hasta + ")";
        return ConversionesContabilidad.convertirCuentasPorPagarCobrarSaldoAnticipos_CuentasPorCobrarSaldoAnticiposTO(em.createNativeQuery(sql).getResultList());

    }
}