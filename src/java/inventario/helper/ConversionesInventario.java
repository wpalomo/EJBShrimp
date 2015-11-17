/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.helper;

import inventario.TO.InvListaConsultaTransferenciaTO;
import inventario.TO.InvListaConsultaVentaTO;
import inventario.entity.InvProveedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jack
 */
public class ConversionesInventario {

    public static inventario.entity.InvProductoCategoria convertirInvProductoCategoria_InvProductoCategoria(inventario.entity.InvProductoCategoria invProductoCategoriaOrigen) {
        inventario.entity.InvProductoCategoria invProductoCategoria = new inventario.entity.InvProductoCategoria();
        invProductoCategoria.setInvProductoCategoriaPK(new inventario.entity.InvProductoCategoriaPK(invProductoCategoriaOrigen.getInvProductoCategoriaPK().getCatEmpresa(), invProductoCategoriaOrigen.getInvProductoCategoriaPK().getCatCodigo()));
        invProductoCategoria.setCatActiva(invProductoCategoriaOrigen.getCatActiva());
        invProductoCategoria.setCatDetalle(invProductoCategoriaOrigen.getCatDetalle());
        invProductoCategoria.setCatPrecioFijo(invProductoCategoriaOrigen.getCatPrecioFijo());

        invProductoCategoria.setUsrEmpresa(invProductoCategoriaOrigen.getUsrEmpresa());
        invProductoCategoria.setUsrCodigo(invProductoCategoriaOrigen.getUsrCodigo());
        invProductoCategoria.setUsrFechaInserta(invProductoCategoriaOrigen.getUsrFechaInserta());
        return invProductoCategoria;
    }

    public static java.util.List<inventario.TO.InvProductoCategoriaTO> convertirInvProductoCategoria_InvProductoCategoriaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = false;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = false;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new inventario.TO.InvProductoCategoriaTO(null, dato1, dato2, dato3, dato4, null, dato5, null, null, null));
        }
        return lista;
    }

    public static inventario.entity.InvProductoCategoria convertirInvProductoCategoriaTO_InvProductoCategoria(inventario.TO.InvProductoCategoriaTO invProductoCategoriaTO) {
        inventario.entity.InvProductoCategoria invProductoCategoria = new inventario.entity.InvProductoCategoria();
        invProductoCategoria.setInvProductoCategoriaPK(
                new inventario.entity.InvProductoCategoriaPK(
                invProductoCategoriaTO.getCatEmpresa(),
                invProductoCategoriaTO.getCatCodigo()));
        invProductoCategoria.setCtaEmpresa(invProductoCategoriaTO.getCatEmpresa());
        invProductoCategoria.setCtaCodigo(invProductoCategoriaTO.getCtaCodigo());
        invProductoCategoria.setCatDetalle(invProductoCategoriaTO.getCatDetalle());
        invProductoCategoria.setCatPrecioFijo(invProductoCategoriaTO.isCatPrecioFijo());
        invProductoCategoria.setCatActiva(invProductoCategoriaTO.isCatActiva());
        invProductoCategoria.setUsrEmpresa(invProductoCategoriaTO.getUsrEmpresa());
        invProductoCategoria.setUsrCodigo(invProductoCategoriaTO.getUsrCodigo());
        invProductoCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoCategoriaTO.getUsrFechaInserta()));
        return invProductoCategoria;
    }

    public static java.util.List<inventario.TO.InvProductoMedidaTO> convertirInvProductoMedida_InvProductoMedidaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String medCodigo;
            try {
                medCodigo = array[0].toString();
            } catch (Exception e) {
                medCodigo = null;
            }
            String medDetalle;
            try {
                medDetalle = array[1].toString();
            } catch (Exception e) {
                medDetalle = null;
            }
            BigDecimal medConversionLibras;
            try {
                medConversionLibras = new BigDecimal(array[2].toString());
            } catch (Exception e) {
                medConversionLibras = null;
            }
            BigDecimal medConversionKilos;
            try {
                medConversionKilos = new BigDecimal(array[3].toString());
            } catch (Exception e) {
                medConversionKilos = null;
            }
            lista.add(new inventario.TO.InvProductoMedidaTO(null, medCodigo, medDetalle, medConversionLibras, medConversionKilos, null, null, null));
        }
        return lista;
    }

    public static inventario.entity.InvProductoMedida convertirInvProductoMedidaTO_InvProductoMedida(inventario.TO.InvProductoMedidaTO invProductoMedidaTO) {
        inventario.entity.InvProductoMedida invProductoMedida = new inventario.entity.InvProductoMedida();
        invProductoMedida.setInvProductoMedidaPK(
                new inventario.entity.InvProductoMedidaPK(
                invProductoMedidaTO.getMedEmpresa(),
                invProductoMedidaTO.getMedCodigo()));
        invProductoMedida.setMedDetalle(invProductoMedidaTO.getMedDetalle());
        invProductoMedida.setMedConversionLibras(invProductoMedidaTO.getMedConvLibras());
        invProductoMedida.setMedConversionKilos(invProductoMedidaTO.getMedConvKilos());
        invProductoMedida.setUsrEmpresa(invProductoMedidaTO.getUsrEmpresa());
        invProductoMedida.setUsrCodigo(invProductoMedidaTO.getUsrCodigo());
        invProductoMedida.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoMedidaTO.getUsrFechaInserta()));
        return invProductoMedida;
    }

    public static inventario.entity.InvProductoPresentacionUnidades convertirInvProductoPresentacionUnidadesTO_InvProductoPresentacionUnidades(inventario.TO.InvProductoPresentacionUnidadesTO invProductoPresentacionUnidadesTO) {
        inventario.entity.InvProductoPresentacionUnidades invProductoPresentacionUnidades = new inventario.entity.InvProductoPresentacionUnidades();
        invProductoPresentacionUnidades.setInvProductoPresentacionUnidadesPK(
                new inventario.entity.InvProductoPresentacionUnidadesPK(
                invProductoPresentacionUnidadesTO.getPresuEmpresa(),
                invProductoPresentacionUnidadesTO.getPresuCodigo()));
        invProductoPresentacionUnidades.setPresuDetalle(invProductoPresentacionUnidadesTO.getPresuDetalle());
        invProductoPresentacionUnidades.setPresuAbreviado(invProductoPresentacionUnidadesTO.getPresuAbreviado());
        invProductoPresentacionUnidades.setUsrEmpresa(invProductoPresentacionUnidadesTO.getUsrEmpresa());
        invProductoPresentacionUnidades.setUsrCodigo(invProductoPresentacionUnidadesTO.getUsrCodigo());
        invProductoPresentacionUnidades.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoPresentacionUnidadesTO.getUsrFechaInserta()));
        return invProductoPresentacionUnidades;
    }

    public static inventario.entity.InvProductoMarca convertirInvProductoMarcaTO_InvProductoMarca(inventario.TO.InvProductoMarcaTO invProductoMarcaTO) {
        inventario.entity.InvProductoMarca invProductoMarca = new inventario.entity.InvProductoMarca();
        invProductoMarca.setInvProductoMarcaPK(
                new inventario.entity.InvProductoMarcaPK(
                invProductoMarcaTO.getMarEmpresa(),
                invProductoMarcaTO.getMarCodigo()));
        invProductoMarca.setMarDetalle(invProductoMarcaTO.getMarDetalle());
        invProductoMarca.setMarAbreviado(invProductoMarcaTO.getMarAbreviado());
        invProductoMarca.setUsrEmpresa(invProductoMarcaTO.getUsrEmpresa());
        invProductoMarca.setUsrCodigo(invProductoMarcaTO.getUsrCodigo());
        invProductoMarca.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoMarcaTO.getUsrFechaInserta()));
        return invProductoMarca;
    }

    public static inventario.entity.InvVendedor convertirInvVendedorTO_InvVendedor(inventario.TO.InvVendedorTO invVendedorTO) {
        inventario.entity.InvVendedor invVendedor = new inventario.entity.InvVendedor();
        invVendedor.setInvVendedorPK(
                new inventario.entity.InvVendedorPK(
                invVendedorTO.getVendEmpresa(),
                invVendedorTO.getVendCodigo()));
        invVendedor.setVendNombre(invVendedorTO.getVendNombre());
        invVendedor.setUsrCodigo(invVendedorTO.getUsrCodigo());
        invVendedor.setUsrEmpresa(invVendedorTO.getUsrEmpresa());
        invVendedor.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invVendedorTO.getUsrFechaInserta()));
        return invVendedor;
    }

    public static inventario.entity.InvProductoPresentacionCajas convertirInvProductoPresentacionCajasTO_InvProductoPresentacionCajas(inventario.TO.InvProductoPresentacionCajasTO invProductoPresentacionCajasTO) {
        inventario.entity.InvProductoPresentacionCajas invProductoPresentacionCajas = new inventario.entity.InvProductoPresentacionCajas();
        invProductoPresentacionCajas.setInvProductoPresentacionCajasPK(
                new inventario.entity.InvProductoPresentacionCajasPK(
                invProductoPresentacionCajasTO.getPrescEmpresa(),
                invProductoPresentacionCajasTO.getPrescCodigo()));
        invProductoPresentacionCajas.setPrescDetalle(invProductoPresentacionCajasTO.getPrescDetalle());
        invProductoPresentacionCajas.setPrescAbreviado(invProductoPresentacionCajasTO.getPrescAbreviado());
        invProductoPresentacionCajas.setUsrEmpresa(invProductoPresentacionCajasTO.getUsrEmpresa());
        invProductoPresentacionCajas.setUsrCodigo(invProductoPresentacionCajasTO.getUsrCodigo());
        invProductoPresentacionCajas.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoPresentacionCajasTO.getUsrFechaInserta()));
        return invProductoPresentacionCajas;
    }

    public static inventario.entity.InvProductoTipo convertirInvProductoTipoTO_InvProductoTipo(inventario.TO.InvProductoTipoTO invProductoTipoTO) {
        inventario.entity.InvProductoTipo invProductoTipo = new inventario.entity.InvProductoTipo();
        invProductoTipo.setInvProductoTipoPK(
                new inventario.entity.InvProductoTipoPK(
                invProductoTipoTO.getTipEmpresa(),
                invProductoTipoTO.getTipCodigo()));
        invProductoTipo.setTipDetalle(invProductoTipoTO.getTipDetalle());
        invProductoTipo.setTipTipo(invProductoTipoTO.getTipTipo());
        invProductoTipo.setTipActivo(invProductoTipoTO.getTipActivo());
        invProductoTipo.setUsrEmpresa(invProductoTipoTO.getUsrEmpresa());
        invProductoTipo.setUsrCodigo(invProductoTipoTO.getUsrCodigo());
        invProductoTipo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoTipoTO.getUsrFechaInserta()));
        return invProductoTipo;
    }

    public static inventario.entity.InvProducto convertirInvProductoTO_InvProducto(inventario.TO.InvProductoTO invProductoTO) {

        inventario.entity.InvProducto invProducto = new inventario.entity.InvProducto();
        invProducto.setInvProductoPK(new inventario.entity.InvProductoPK(
                invProductoTO.getProEmpresa(),
                invProductoTO.getProCodigoPrincipal()));
        invProducto.setProCodigoAlterno(invProductoTO.getProCodigoAlterno());
        invProducto.setProCodigoBarra(invProductoTO.getProCodigoBarra());
        invProducto.setProCodigoBarra2(invProductoTO.getProCodigoBarra2());
        invProducto.setProCodigoBarra3(invProductoTO.getProCodigoBarra3());
        invProducto.setProCodigoBarra4(invProductoTO.getProCodigoBarra4());
        invProducto.setProCodigoBarra5(invProductoTO.getProCodigoBarra5());//8
        invProducto.setProEmpaque(invProductoTO.getProEmpaque());
        invProducto.setProNombre(invProductoTO.getProNombre());

        invProducto.setProDetalle(invProductoTO.getProDetalle());
        invProducto.setProCantidad1(invProductoTO.getProCantidad1());
        invProducto.setProCantidad2(invProductoTO.getProCantidad2());
        invProducto.setProCantidad3(invProductoTO.getProCantidad3());
        invProducto.setProCantidad4(invProductoTO.getProCantidad4());
        invProducto.setProCantidad5(invProductoTO.getProCantidad5());
        invProducto.setProPrecio1(invProductoTO.getProPrecio1());
        invProducto.setProPrecio2(invProductoTO.getProPrecio2());
        invProducto.setProPrecio3(invProductoTO.getProPrecio3());
        invProducto.setProPrecio4(invProductoTO.getProPrecio4());

        invProducto.setProPrecio5(invProductoTO.getProPrecio5());
        invProducto.setProDescuento1(invProductoTO.getProDescuento1());
        invProducto.setProDescuento2(invProductoTO.getProDescuento2());
        invProducto.setProDescuento3(invProductoTO.getProDescuento3());
        invProducto.setProDescuento4(invProductoTO.getProDescuento4());
        invProducto.setProDescuento5(invProductoTO.getProDescuento5());
        invProducto.setProMargenUtilidad1(invProductoTO.getProMargenUtilidad1());
        invProducto.setProMargenUtilidad2(invProductoTO.getProMargenUtilidad2());
        invProducto.setProMargenUtilidad3(invProductoTO.getProMargenUtilidad3());
        invProducto.setProMargenUtilidad4(invProductoTO.getProMargenUtilidad4());

        invProducto.setProMargenUtilidad5(invProductoTO.getProMargenUtilidad5());
        invProducto.setProMinimo(invProductoTO.getProMinimo());
        invProducto.setProMaximo(invProductoTO.getProMaximo());
        invProducto.setProIva(invProductoTO.getProIva());
        invProducto.setProCreditoTributario(invProductoTO.getProCreditoTributario());
        invProducto.setProStockNegativo(invProductoTO.getProStockNegativo());
        invProducto.setProInactivo(invProductoTO.getProInactivo());
        invProducto.setProCuentaEmpresa(invProductoTO.getProEmpresa());
        invProducto.setProCuentaInventario(invProductoTO.getProCuentaInventario());
        invProducto.setProCuentaGasto(invProductoTO.getProCuentaGasto());

        invProducto.setProCuentaVenta(invProductoTO.getProCuentaVenta());
        invProducto.setProCuentaTransferenciaIpp(invProductoTO.getProCuentaTransferenciaIpp());

        /*
         *
         * cat_empresa character(7) NOT NULL, cat_codigo character(10) NOT NULL,
         * mar_empresa character(7) NOT NULL, mar_codigo character(7) NOT NULL,
         * presu_empresa character(7) NOT NULL, presu_codigo character(7) NOT
         * NULL, presc_empresa character(7) NOT NULL, presc_codigo character(7)
         * NOT NULL, tip_empresa character(7) NOT NULL, tip_codigo character(25)
         * NOT NULL, med_empresa character(7) NOT NULL, med_codigo character(7)
         * NOT NULL,
         *
         */


        invProducto.setConCodigo(invProductoTO.getConCodigo());
        invProducto.setSusCodigo(invProductoTO.getSusCodigo());
        //invProducto.setProFactorConversion(invProductoTO.getProFactorConversion());
        invProducto.setProFactorCajaSacoBulto(invProductoTO.getProFactorCajabulto());
        invProducto.setUsrEmpresa(invProductoTO.getUsrEmpresa());
        invProducto.setUsrCodigo(invProductoTO.getUsrInsertaProducto());
        invProducto.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProductoTO.getUsrFechaInsertaProducto()));
        return invProducto;
    }

    public static inventario.entity.InvProducto convertirInvProducto_InvProducto(inventario.entity.InvProducto invProductoOrigen) {

        inventario.entity.InvProducto invProducto = new inventario.entity.InvProducto();
        invProducto.setInvProductoPK(new inventario.entity.InvProductoPK(invProductoOrigen.getInvProductoPK().getProEmpresa(), invProductoOrigen.getInvProductoPK().getProCodigoPrincipal()));
        invProducto.setProCodigoAlterno(invProductoOrigen.getProCodigoAlterno());
        invProducto.setProCodigoBarra(invProductoOrigen.getProCodigoBarra());
        invProducto.setProCodigoBarra2(invProductoOrigen.getProCodigoBarra2());
        invProducto.setProCodigoBarra3(invProductoOrigen.getProCodigoBarra3());
        invProducto.setProCodigoBarra4(invProductoOrigen.getProCodigoBarra4());
        invProducto.setProCodigoBarra5(invProductoOrigen.getProCodigoBarra5());


        invProducto.setProEmpaque(invProductoOrigen.getProEmpaque());
        invProducto.setProNombre(invProductoOrigen.getProNombre());
        invProducto.setProDetalle(invProductoOrigen.getProDetalle());
        invProducto.setProCantidad1(invProductoOrigen.getProCantidad1());
        invProducto.setProCantidad2(invProductoOrigen.getProCantidad2());
        invProducto.setProCantidad3(invProductoOrigen.getProCantidad3());
        invProducto.setProCantidad4(invProductoOrigen.getProCantidad4());
        invProducto.setProCantidad5(invProductoOrigen.getProCantidad5());
        invProducto.setProFactorCajaSacoBulto(invProductoOrigen.getProFactorCajaSacoBulto());
        invProducto.setProPrecio1(invProductoOrigen.getProPrecio1());
        invProducto.setProPrecio2(invProductoOrigen.getProPrecio2());
        invProducto.setProPrecio3(invProductoOrigen.getProPrecio3());
        invProducto.setProPrecio4(invProductoOrigen.getProPrecio4());
        invProducto.setProPrecio5(invProductoOrigen.getProPrecio5());
        invProducto.setProDescuento1(invProductoOrigen.getProDescuento1());
        invProducto.setProDescuento2(invProductoOrigen.getProDescuento2());
        invProducto.setProDescuento3(invProductoOrigen.getProDescuento3());
        invProducto.setProDescuento4(invProductoOrigen.getProDescuento4());
        invProducto.setProDescuento5(invProductoOrigen.getProDescuento5());
        invProducto.setProMargenUtilidad1(invProductoOrigen.getProMargenUtilidad1());
        invProducto.setProMargenUtilidad2(invProductoOrigen.getProMargenUtilidad2());
        invProducto.setProMargenUtilidad3(invProductoOrigen.getProMargenUtilidad3());
        invProducto.setProMargenUtilidad4(invProductoOrigen.getProMargenUtilidad4());
        invProducto.setProMargenUtilidad5(invProductoOrigen.getProMargenUtilidad5());

        invProducto.setProMinimo(invProductoOrigen.getProMinimo());
        invProducto.setProMaximo(invProductoOrigen.getProMaximo());
        invProducto.setProIva(invProductoOrigen.getProIva());
        invProducto.setProCreditoTributario(invProductoOrigen.getProCreditoTributario());
        invProducto.setProStockNegativo(invProductoOrigen.getProStockNegativo());
        invProducto.setProInactivo(invProductoOrigen.getProInactivo());

        invProducto.setProCuentaEmpresa(invProductoOrigen.getProCuentaEmpresa());
        invProducto.setProCuentaInventario(invProductoOrigen.getProCuentaInventario());
        invProducto.setProCuentaGasto(invProductoOrigen.getProCuentaGasto());
        invProducto.setProCuentaVenta(invProductoOrigen.getProCuentaVenta());
        invProducto.setProCuentaTransferenciaIpp(invProductoOrigen.getProCuentaTransferenciaIpp());
        //
        invProducto.setInvProductoCategoria(invProductoOrigen.getInvProductoCategoria());
        invProducto.setInvProductoPresentacionUnidades(invProductoOrigen.getInvProductoPresentacionUnidades());
        invProducto.setInvProductoPresentacionCajas(invProductoOrigen.getInvProductoPresentacionCajas());
        invProducto.setInvProductoTipo(invProductoOrigen.getInvProductoTipo());
        invProducto.setInvProductoMedida(invProductoOrigen.getInvProductoMedida());
        invProducto.setInvProductoMarca(invProductoOrigen.getInvProductoMarca());
        invProducto.setSusCodigo(invProductoOrigen.getSusCodigo());
        invProducto.setConCodigo(invProductoOrigen.getConCodigo());
        //  invProducto.setInvProductoMedida2(invProductoOrigen.getInvProductoMedida2());
        // invProducto.setProFactorConversion(invProductoOrigen.getProFactorConversion());

        invProducto.setUsrEmpresa(invProductoOrigen.getUsrEmpresa());
        invProducto.setUsrCodigo(invProductoOrigen.getUsrCodigo());
        invProducto.setUsrFechaInserta(invProductoOrigen.getUsrFechaInserta());
        return invProducto;
    }

    public static inventario.TO.InvProductoDAOTO convertirInvProducto_InvProductoDAOTO(inventario.entity.InvProducto invProducto) {
        inventario.TO.InvProductoDAOTO invProductoDAOTO = null;

        if (invProducto != null) {
            invProductoDAOTO = new inventario.TO.InvProductoDAOTO();
            invProductoDAOTO.setProEmpresa(invProducto.getInvProductoPK().getProEmpresa());
            invProductoDAOTO.setProCodigoPrincipal(invProducto.getInvProductoPK().getProCodigoPrincipal());
            invProductoDAOTO.setProCodigoAlterno(invProducto.getProCodigoAlterno());
            invProductoDAOTO.setProCodigoBarra(invProducto.getProCodigoBarra());
            invProductoDAOTO.setProCodigoBarra2(invProducto.getProCodigoBarra2());
            invProductoDAOTO.setProCodigoBarra3(invProducto.getProCodigoBarra3());
            invProductoDAOTO.setProCodigoBarra4(invProducto.getProCodigoBarra4());
            invProductoDAOTO.setProCodigoBarra5(invProducto.getProCodigoBarra5());

            invProductoDAOTO.setProNombre(invProducto.getProNombre());
            invProductoDAOTO.setProDetalle(invProducto.getProDetalle());

            invProductoDAOTO.setProCantidad1(invProducto.getProCantidad1());
            invProductoDAOTO.setProCantidad2(invProducto.getProCantidad2());
            invProductoDAOTO.setProCantidad3(invProducto.getProCantidad3());
            invProductoDAOTO.setProCantidad4(invProducto.getProCantidad4());
            invProductoDAOTO.setProCantidad5(invProducto.getProCantidad5());
            invProductoDAOTO.setProPrecio1(invProducto.getProPrecio1());
            invProductoDAOTO.setProPrecio2(invProducto.getProPrecio2());
            invProductoDAOTO.setProPrecio3(invProducto.getProPrecio3());
            invProductoDAOTO.setProPrecio4(invProducto.getProPrecio4());
            invProductoDAOTO.setProPrecio5(invProducto.getProPrecio5());
            invProductoDAOTO.setProDescuento1(invProducto.getProDescuento1());
            invProductoDAOTO.setProDescuento2(invProducto.getProDescuento2());
            invProductoDAOTO.setProDescuento3(invProducto.getProDescuento3());
            invProductoDAOTO.setProDescuento4(invProducto.getProDescuento4());
            invProductoDAOTO.setProDescuento5(invProducto.getProDescuento5());
            invProductoDAOTO.setProMargenUtilidad1(invProducto.getProMargenUtilidad1());
            invProductoDAOTO.setProMargenUtilidad2(invProducto.getProMargenUtilidad2());
            invProductoDAOTO.setProMargenUtilidad3(invProducto.getProMargenUtilidad3());
            invProductoDAOTO.setProMargenUtilidad4(invProducto.getProMargenUtilidad4());
            invProductoDAOTO.setProMargenUtilidad5(invProducto.getProMargenUtilidad5());

            invProductoDAOTO.setProMinimo(invProducto.getProMinimo());
            invProductoDAOTO.setProMaximo(invProducto.getProMaximo());
            invProductoDAOTO.setProIva(invProducto.getProIva());
            invProductoDAOTO.setProCreditoTributario(invProducto.getProCreditoTributario());
            invProductoDAOTO.setProStockNegativo(invProducto.getProStockNegativo());
            invProductoDAOTO.setProInactivo(invProducto.getProInactivo());

            invProductoDAOTO.setProCuentaInventario(invProducto.getProCuentaInventario());
            invProductoDAOTO.setProCuentaGasto(invProducto.getProCuentaGasto());
            invProductoDAOTO.setProCuentaVenta(invProducto.getProCuentaVenta());
            invProductoDAOTO.setProCuentaTransferenciaIpp(invProducto.getProCuentaTransferenciaIpp());
            //categoria
            invProductoDAOTO.setCatCodigo(invProducto.getInvProductoCategoria().getInvProductoCategoriaPK().getCatCodigo());
            invProductoDAOTO.setCatDetalle(invProducto.getInvProductoCategoria().getCatDetalle());
            invProductoDAOTO.setCatPrecioFijo(invProducto.getInvProductoCategoria().getCatPrecioFijo());
            invProductoDAOTO.setCatActiva(invProducto.getInvProductoCategoria().getCatActiva());
            //marca
            invProductoDAOTO.setMarCodigo(invProducto.getInvProductoMarca().getInvProductoMarcaPK().getMarCodigo());
            invProductoDAOTO.setMarDetalle(invProducto.getInvProductoMarca().getMarDetalle());
            invProductoDAOTO.setMarAbreviado(invProducto.getInvProductoMarca().getMarAbreviado());
            //presentacion unidad
            invProductoDAOTO.setPresuCodigo(invProducto.getInvProductoPresentacionUnidades().getInvProductoPresentacionUnidadesPK().getPresuCodigo());
            invProductoDAOTO.setPresuDetalle(invProducto.getInvProductoPresentacionUnidades().getPresuDetalle());
            invProductoDAOTO.setPresuAbreviado(invProducto.getInvProductoPresentacionUnidades().getPresuAbreviado());
            //presentacion caja
            invProductoDAOTO.setPrescCodigo(invProducto.getInvProductoPresentacionCajas().getInvProductoPresentacionCajasPK().getPrescCodigo());
            invProductoDAOTO.setPrescDetalle(invProducto.getInvProductoPresentacionCajas().getPrescDetalle());
            invProductoDAOTO.setPrescAbreviado(invProducto.getInvProductoPresentacionCajas().getPrescAbreviado());
            //tipo producto
            invProductoDAOTO.setTipCodigo(invProducto.getInvProductoTipo().getInvProductoTipoPK().getTipCodigo());
            invProductoDAOTO.setTipTipo(invProducto.getInvProductoTipo().getTipTipo());
            invProductoDAOTO.setTipDetalle(invProducto.getInvProductoTipo().getTipDetalle());
            invProductoDAOTO.setTipActivo(invProducto.getInvProductoTipo().getTipActivo());
            //medida
            invProductoDAOTO.setMedCodigo(invProducto.getInvProductoMedida().getInvProductoMedidaPK().getMedCodigo());
            invProductoDAOTO.setMedDetalle(invProducto.getInvProductoMedida().getMedDetalle());
            //
            invProductoDAOTO.setUsrEmpresa(invProducto.getUsrEmpresa());
            invProductoDAOTO.setUsrCodigo(invProducto.getUsrCodigo());
            invProductoDAOTO.setUsrFechaInserta(validaciones.Validacion.fecha(invProducto.getUsrFechaInserta(), "yyyy-MM-dd"));
            // CANTIDADCAJA, EMPAQUE, PRESENTACIONUNIDAD, PRESENTACIONCAJA
            invProductoDAOTO.setProFactorCajaSacoBulto(invProducto.getProFactorCajaSacoBulto());
            invProductoDAOTO.setProEmpaque(invProducto.getProEmpaque());
            // codigo sustento y conecpto
            invProductoDAOTO.setConCodigo(invProducto.getConCodigo());
            invProductoDAOTO.setSusCodigo(invProducto.getSusCodigo());
        }
        return invProductoDAOTO;
    }

    public static java.util.List<inventario.TO.InvClienteCategoriaTO> convertirInvClienteCategoria_InvClienteCategoriaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Short dato3;
            try {
                dato3 = new Short(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            /*
             * String dato4; try { dato4 = array[3].toString(); } catch
             * (Exception e) { dato4 = null; } String dato5; try { dato5 =
             * array[4].toString(); } catch (Exception e) { dato5 = null; }
             */

            lista.add(new inventario.TO.InvClienteCategoriaTO(null, dato1, dato2, dato3, null, null, null));
        }
        return lista;
    }

    public static inventario.entity.InvClienteCategoria convertirInvClienteCategoriaTO_InvClienteCategoria(inventario.TO.InvClienteCategoriaTO invClienteCategoriaTO) {
        inventario.entity.InvClienteCategoria invClienteCategoria = new inventario.entity.InvClienteCategoria();
        invClienteCategoria.setInvClienteCategoriaPK(
                new inventario.entity.InvClienteCategoriaPK(
                invClienteCategoriaTO.getCcEmpresa(),
                invClienteCategoriaTO.getCcCodigo()));
        invClienteCategoria.setCcDetalle(invClienteCategoriaTO.getCcDetalle());
        invClienteCategoria.setCcNivel(invClienteCategoriaTO.getCcNivel());
        //invClienteCategoria.setCtaAntipos(invClienteCategoriaTO.getCtaAntipos());
        //invClienteCategoria.setCtaCobros(invClienteCategoriaTO.getCtaCobros());
        invClienteCategoria.setUsrEmpresa(invClienteCategoriaTO.getUsrEmpresa());
        invClienteCategoria.setUsrCodigo(invClienteCategoriaTO.getUsrCodigo());
        invClienteCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invClienteCategoriaTO.getUsrFechaInserta()));
        return invClienteCategoria;
    }

    public static inventario.entity.InvCliente convertirInvClienteTO_InvCliente(inventario.TO.InvClienteTO invClienteTO) {
        inventario.entity.InvCliente invCliente = new inventario.entity.InvCliente();
        invCliente.setInvClientePK(new inventario.entity.InvClientePK(invClienteTO.getEmpCodigo(), invClienteTO.getCliCodigo()));
        invCliente.setCliIdEmpresa(invClienteTO.getEmpCodigo());
        invCliente.setCliIdTipo(invClienteTO.getCliTipoId());
        invCliente.setCliIdNumero(invClienteTO.getCliId());
        invCliente.setCliNombre(invClienteTO.getCliNombre());
        invCliente.setCliRazonSocial(invClienteTO.getCliRazonSocial());
        invCliente.setCliProvincia(invClienteTO.getCliProvincia());
        invCliente.setCliCiudad(invClienteTO.getCliCiudad());
        invCliente.setCliParroquia(invClienteTO.getCliParroquia());
        invCliente.setCliZona(invClienteTO.getCliZona());
        invCliente.setCliDireccion(invClienteTO.getCliDireccion());
        invCliente.setCliTelefono(invClienteTO.getCliTelefono());
        invCliente.setCliCelular(invClienteTO.getCliCelular());
        invCliente.setCliEmail(invClienteTO.getCliEmail());
        invCliente.setCliPrecio(invClienteTO.getCliPrecio());
        invCliente.setCliDiasCredito(invClienteTO.getCliDiasCredito());
        invCliente.setCliCupoCredito(invClienteTO.getCliCupoCredito());
        invCliente.setCliObservaciones(invClienteTO.getCliObservaciones());
        invCliente.setCliRelacionado(invClienteTO.getCliRelacionado());
//        invCliente.setCliConContable(invClienteTO.getCliConContable());
        invCliente.setCliInactivo(invClienteTO.getCliInactivo());
        invCliente.setCliSecuencia(invClienteTO.getCliSecuencia());
        invCliente.setUsrEmpresa(invClienteTO.getEmpCodigo());
        invCliente.setUsrCodigo(invClienteTO.getUsrInsertaCliente());

        invCliente.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invClienteTO.getUsrFechaInsertaCliente()));
        return invCliente;
    }

    public static java.util.List<inventario.TO.InvProveedorCategoriaTO> convertirInvProveedorCategoria_InvProveedorCategoriaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray(); //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvProveedorCategoriaTO(null, dato1, dato2, dato3, null, null, null));
        }
        return lista;
    }

    public static inventario.entity.InvProveedorCategoria convertirInvProveedorCategoriaTO_InvProveedorCategoria(inventario.TO.InvProveedorCategoriaTO invProveedorCategoriaTO) {
        inventario.entity.InvProveedorCategoria invProveedorCategoria = new inventario.entity.InvProveedorCategoria();
        invProveedorCategoria.setInvProveedorCategoriaPK(
                new inventario.entity.InvProveedorCategoriaPK(
                invProveedorCategoriaTO.getPcEmpresa(),
                invProveedorCategoriaTO.getPcCodigo()));
        invProveedorCategoria.setPcDetalle(invProveedorCategoriaTO.getPcDetalle());
        invProveedorCategoria.setPcAplicaRetencionIva(invProveedorCategoriaTO.getPcAplicaRetencionIva());
        //invProveedorCategoria.setCtaAntipos(invProveedorCategoriaTO.getCtaAntipos());
        //invProveedorCategoria.setCtaAntiposActivosFijos(invProveedorCategoriaTO.getCtaAntiposActivosFijos());
        //invProveedorCategoria.setCtaPagos(invProveedorCategoriaTO.getCtaPagos());
        //invProveedorCategoria.setCtaPagosActivosFijos(invProveedorCategoriaTO.getCtaPagosActivosFijos());
        invProveedorCategoria.setUsrEmpresa(invProveedorCategoriaTO.getUsrEmpresa());
        invProveedorCategoria.setUsrCodigo(invProveedorCategoriaTO.getUsrCodigo());
        invProveedorCategoria.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProveedorCategoriaTO.getUsrFechaInserta()));
        return invProveedorCategoria;
    }

    public static inventario.entity.InvProveedor convertirInvProveedorTO_InvProveedor(inventario.TO.InvProveedorTO invProveedorTO) {
        inventario.entity.InvProveedor invProveedor = new inventario.entity.InvProveedor();
        invProveedor.setInvProveedorPK(new inventario.entity.InvProveedorPK(invProveedorTO.getEmpCodigo(), invProveedorTO.getProvCodigo()));
        invProveedor.setProvIdEmpresa(invProveedorTO.getEmpCodigo());
        invProveedor.setProvIdTipo(invProveedorTO.getProvTipoId());
        invProveedor.setProvIdNumero(invProveedorTO.getProvId());
        invProveedor.setProvNombre(invProveedorTO.getProvNombre());
        invProveedor.setProvRazonSocial(invProveedorTO.getProvRazonSocial());
        invProveedor.setProvProvincia(invProveedorTO.getProvProvincia());
        invProveedor.setProvCiudad(invProveedorTO.getProvCiudad());
        invProveedor.setProvParroquia(invProveedorTO.getProvParroquia());
        invProveedor.setProvZona(invProveedorTO.getProvZona());
        invProveedor.setProvDireccion(invProveedorTO.getProvDireccion());
        invProveedor.setProvTelefono(invProveedorTO.getProvTelefono());
        invProveedor.setProvCelular(invProveedorTO.getProvCelular());
        invProveedor.setProvEmail(invProveedorTO.getProvEmail());
        invProveedor.setProvObservaciones(invProveedorTO.getProvObservaciones());
        invProveedor.setProvRelacionado(invProveedorTO.getProvRelacionado());
        invProveedor.setProvInactivo(invProveedorTO.getProvInactivo());
        invProveedor.setProvSecuencia(invProveedorTO.getProvSecuencia());



        invProveedor.setUsrEmpresa(invProveedorTO.getEmpCodigo());
        invProveedor.setUsrCodigo(invProveedorTO.getUsrInsertaProveedor());
        invProveedor.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProveedorTO.getUsrFechaInsertaProveedor()));
        return invProveedor;
    }

    public static inventario.entity.InvBodega convertirInvBodegaTO_InvBodega(inventario.TO.InvBodegaTO invBodegaTO) {
        inventario.entity.InvBodega invBodega = new inventario.entity.InvBodega();
        invBodega.setInvBodegaPK(new inventario.entity.InvBodegaPK(invBodegaTO.getEmpCodigo(), invBodegaTO.getBodCodigo()));
        invBodega.setBodNombre(invBodegaTO.getBodNombre());
        invBodega.setBodInactiva(invBodegaTO.getBodInactiva());
        invBodega.setSecEmpresa(invBodegaTO.getSecEmpresa());
        invBodega.setSecCodigo(invBodegaTO.getSecCodigo());
        invBodega.setDetEmpresa(invBodegaTO.getDetEmpresa());
        invBodega.setDetUsuario(invBodegaTO.getDetUsuario());
        invBodega.setUsrEmpresa(invBodegaTO.getUsrEmpresa());
        invBodega.setUsrCodigo(invBodegaTO.getUsrInsertaBodega());
        invBodega.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invBodegaTO.getUsrFechaInsertaBodega()));

        return invBodega;
    }

    public static inventario.entity.InvCompras convertirInvComprasTO_InvCompras(inventario.TO.InvComprasTO invComprasTO) {
        inventario.entity.InvCompras invCompras = new inventario.entity.InvCompras();
        invCompras.setInvComprasPK(new inventario.entity.InvComprasPK(
                invComprasTO.getEmpCodigo(),
                invComprasTO.getCompPeriodo(),
                invComprasTO.getCompMotivo(),
                invComprasTO.getCompNumero()));
        invCompras.setCompNumeroAlterno(invComprasTO.getCompNumeroAlterno());
        invCompras.setCompDocumentoEmpresa(invComprasTO.getEmpCodigo());
        invCompras.setCompDocumentoProveedor(invComprasTO.getProvCodigo());
        invCompras.setCompDocumentoTipo(invComprasTO.getCompDocumentoTipo());
        invCompras.setCompDocumentoNumero(invComprasTO.getCompDocumentoNumero());
//        invCompras.setProvCodigo(invComprasTO.getProvCodigo());
        invCompras.setCompFecha(validaciones.Validacion.fecha(invComprasTO.getCompFecha(), "yyyy-MM-dd"));
        invCompras.setCompFechaVencimiento(validaciones.Validacion.fecha(invComprasTO.getCompFechaVencimiento(), "yyyy-MM-dd"));
        invCompras.setCompIvaVigente(invComprasTO.getCompIvaVigente());
        invCompras.setCompObservaciones(invComprasTO.getCompObservaciones());
        invCompras.setCompElectronica(invComprasTO.getCompElectronica());
        invCompras.setCompActivoFijo(invComprasTO.getCompActivoFijo());
        invCompras.setCompImportacion(invComprasTO.getCompImportacion());
        invCompras.setCompPendiente(invComprasTO.getCompPendiente());

        invCompras.setCompRevisado(invComprasTO.getCompRevisado());
        invCompras.setCompAnulado(invComprasTO.getCompAnulado());
        invCompras.setCompFormaPago(invComprasTO.getCompFormaPago());
        invCompras.setCompDocumentoFormaPago(invComprasTO.getCompDocumentoFormaPago());

        invCompras.setCompBase0(invComprasTO.getCompBase0());
        invCompras.setCompBaseImponible(invComprasTO.getCompBaseImponible());
        invCompras.setCompBaseNoObjeto(invComprasTO.getCompBaseNoObjeto());
        invCompras.setCompBaseExenta(invComprasTO.getCompBaseExenta());

        invCompras.setCompMontoIva(invComprasTO.getCompMontoIva());
        invCompras.setCompOtrosImpuestos(invComprasTO.getCompOtrosImpuestos());
        invCompras.setCompTotal(invComprasTO.getCompTotal());
        invCompras.setCompValorRetenido(invComprasTO.getCompValorRetenido());
        invCompras.setCompRetencionAsumida(invComprasTO.isCompRetencionAsumida());
        invCompras.setCompSaldo(invComprasTO.getCompSaldo());

        //invCompras.setInvProveedor(new InvProveedor(invComprasTO.getProvEmpresa(),invComprasTO.getProvCodigo()));
        // invCompras.setInvBodega(new inventario.entity.InvBodega(invComprasTO.getBodEmpresa(), invComprasTO.getEmpCodigo()));

        invCompras.setSecEmpresa(invComprasTO.getEmpCodigo());
        invCompras.setSecCodigo(invComprasTO.getSecCodigo());

        invCompras.setCtaEmpresa(invComprasTO.getCtaEmpresa());
        invCompras.setCtaCodigo(invComprasTO.getCtaCodigo());

        invCompras.setConEmpresa(invComprasTO.getEmpCodigo());
        invCompras.setConPeriodo(invComprasTO.getContPeriodo());
        invCompras.setConTipo(invComprasTO.getContTipo());
        invCompras.setConNumero(invComprasTO.getContNumero());

        invCompras.setEmpCodigo(invComprasTO.getEmpCodigo());
        invCompras.setUsrCodigo(invComprasTO.getUsrInsertaCompra());
        invCompras.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invComprasTO.getUsrFechaInsertaCompra()));
        return invCompras;
    }

    public static inventario.entity.InvVentas convertirInvVentasTO_InvVentas(inventario.TO.InvVentasTO invVentasTO) {
        inventario.entity.InvVentas invVentas = new inventario.entity.InvVentas();

        invVentas.setInvVentasPK(new inventario.entity.InvVentasPK(
                invVentasTO.getVtaEmpresa(),
                invVentasTO.getVtaPeriodo(),
                invVentasTO.getVtaMotivo(),
                invVentasTO.getVtaNumero()));
        invVentas.setVtaNumeroAlterno(invVentasTO.getVtaNumeroAlterno());
        invVentas.setVtaDocumentoEmpresa(invVentasTO.getUsrEmpresa());
        invVentas.setVtaDocumentoTipo(invVentasTO.getVtaDocumentoTipo());
        invVentas.setVtaDocumentoNumero(invVentasTO.getVtaDocumentoNumero());
        invVentas.setVtaFecha(validaciones.Validacion.fecha(invVentasTO.getVtaFecha(), "yyyy-MM-dd"));
        invVentas.setVtaFechaVencimiento(validaciones.Validacion.fecha(invVentasTO.getVtaFechaVencimiento(), "yyyy-MM-dd"));
        invVentas.setVtaIvaVigente(invVentasTO.getVtaIvaVigente());
        invVentas.setVtaObservaciones(invVentasTO.getVtaObservaciones());
        invVentas.setVtaInformacionAdicional(invVentasTO.getVtaInformacionAdicional());
        invVentas.setVtaPendiente(invVentasTO.getVtaPendiente());
        invVentas.setVtaRevisado(invVentasTO.getVtaRevisado());
        invVentas.setVtaAnulado(invVentasTO.getVtaAnulado());
        invVentas.setVtaFormaPago(invVentasTO.getVtaFormaPago());
        invVentas.setVtaBase0(invVentasTO.getVtaBase0());
        invVentas.setVtaBaseImponible(invVentasTO.getVtaBaseImponible());
        invVentas.setVtaBaseNoObjeto(invVentasTO.getVtaBaseNoObjeto());
        invVentas.setVtaBaseExenta(invVentasTO.getVtaBaseExenta());
        invVentas.setVtaDescuentoBase0(invVentasTO.getVtaDescuentoBase0());
        invVentas.setVtaDescuentoBaseImponible(invVentasTO.getVtaDescuentoBaseImponible());
        invVentas.setVtaDescuentoBaseNoObjeto(invVentasTO.getVtaDescuentoBaseNoObjeto());
        invVentas.setVtaDescuentoBaseExenta(invVentasTO.getVtaDescuentoBaseExenta());
        invVentas.setVtaSubtotalBase0(invVentasTO.getVtaSubtotalBase0());
        invVentas.setVtaSubtotalBaseImponible(invVentasTO.getVtaSubtotalBaseImponible());
        invVentas.setVtaSubtotalBaseNoObjeto(invVentasTO.getVtaSubtotalBaseNoObjeto());
        invVentas.setVtaSubtotalBaseExenta(invVentasTO.getVtaSubtotalBaseExenta());
        invVentas.setVtaMontoiva(invVentasTO.getVtaMontoIva());
        invVentas.setVtaTotal(invVentasTO.getVtaTotal());
        invVentas.setVtaPagado(invVentasTO.getVtaPagado());
        invVentas.setInvCliente(new inventario.entity.InvCliente(invVentasTO.getCliEmpresa(), invVentasTO.getCliCodigo()));
//        invVentas.setInvBodega(new inventario.entity.InvBodega(invVentasTO.getBodEmpresa(), invVentasTO.getBodCodigo()));
        invVentas.setBodCodigo(invVentasTO.getBodCodigo());
        invVentas.setBodEmpresa(invVentasTO.getBodEmpresa());

        invVentas.setSecEmpresa(invVentasTO.getVtaEmpresa());
        invVentas.setSecCodigo(invVentasTO.getSecCodigo());
        invVentas.setCtaEmpresa(invVentasTO.getCtaEmpresa());
        invVentas.setCtaCodigo(invVentasTO.getCtaCodigo());
        invVentas.setConEmpresa(invVentasTO.getConEmpresa());
        invVentas.setConPeriodo(invVentasTO.getConPeriodo());
        invVentas.setConTipo(invVentasTO.getConTipo());
        invVentas.setConNumero(invVentasTO.getConNumero());
        invVentas.setEmpCodigo(invVentasTO.getUsrEmpresa());
        invVentas.setUsrCodigo(invVentasTO.getUsrCodigo());
        invVentas.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invVentasTO.getUsrFechaInserta()));
        return invVentas;
    }

    public static inventario.entity.InvProformas convertirInvProformasTO_InvProformas(inventario.TO.InvProformasTO invProformasTO) {
        inventario.entity.InvProformas invProformas = new inventario.entity.InvProformas();
        invProformas.setInvProformasPK(new inventario.entity.InvProformasPK(invProformasTO.getProfEmpresa(), invProformasTO.getProfPeriodo(),
                invProformasTO.getProfMotivo(), invProformasTO.getProfNumero()));
//        invCompras.setProvCodigo(invComprasTO.getProvCodigo());
        invProformas.setProfFecha(validaciones.Validacion.fecha(invProformasTO.getProfFecha(), "yyyy-MM-dd"));
        invProformas.setProfIvaVigente(invProformasTO.getProfIvaVigente());
        invProformas.setProfObservaciones(invProformasTO.getProfObservaciones());
        invProformas.setProfPendiente(invProformasTO.getProfPendiente());
        invProformas.setProfAnulado(invProformasTO.getProfAnulado());

        invProformas.setProfBase0(invProformasTO.getProfBase0());
        invProformas.setProfBaseimponible(invProformasTO.getProfBaseImponible());

        invProformas.setProfDescuentoBase0(invProformasTO.getProfDescuentoBase0());
        invProformas.setProfDescuentoBaseimponible(invProformasTO.getProfDescuentoBaseImponible());
        invProformas.setProfDescuentoGeneralBase0(invProformasTO.getProfDescuentoGeneralBase0());
        invProformas.setProfDescuentoGeneralBaseimponible(invProformasTO.getProfDescuentoGeneralBaseImponible());
        invProformas.setProfDescuentoIva(invProformasTO.getProfDescuentoIva());
        invProformas.setProfSubtotalBase0(invProformasTO.getProfSubtotalBase0());
        invProformas.setProfSubtotalBaseimponible(invProformasTO.getProfSubtotalBaseImponible());

        invProformas.setProfMontoiva(invProformasTO.getProfMontoIva());
        invProformas.setProfTotal(invProformasTO.getProfTotal());

//
//        invProformas.setCon2Empresa(invProformasTO.getCon2Empresa());
//        invProformas.setCon2Periodo(invProformasTO.getCon2Periodo());
//        invProformas.setCon2Tipo(invProformasTO.getCon1Tipo());
//        invProformas.setCon2Numero(invProformasTO.getCon1Numero());

        invProformas.setUsrEmpresa(invProformasTO.getUsrEmpresa());
        invProformas.setUsrCodigo(invProformasTO.getUsrCodigo());
        invProformas.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProformasTO.getUsrFechaInserta()));
        return invProformas;
    }

    public static inventario.entity.InvCompras convertirInvCompras_InvCompras(inventario.entity.InvCompras invCompras) {
        inventario.entity.InvCompras invComprasAux = new inventario.entity.InvCompras();
        invComprasAux.setCompAnulado(invCompras.getCompAnulado());
        invComprasAux.setCompBase0(invCompras.getCompBase0());
        invComprasAux.setCompBaseNoObjeto(invCompras.getCompBaseNoObjeto());
        invComprasAux.setCompBaseExenta(invCompras.getCompBaseExenta());
        invComprasAux.setCompBaseImponible(invCompras.getCompBaseImponible());
        invComprasAux.setInvBodega(invCompras.getInvBodega());
        invComprasAux.setCtaCodigo(invCompras.getCtaCodigo());
        invComprasAux.setCtaEmpresa(invCompras.getCtaEmpresa());
        invComprasAux.setCompDocumentoEmpresa(invCompras.getInvProveedor().getInvProveedorPK().getProvEmpresa());
        invComprasAux.setCompDocumentoProveedor(invCompras.getInvProveedor().getInvProveedorPK().getProvCodigo());
        invComprasAux.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago());
        invComprasAux.setCompDocumentoNumero(invCompras.getCompDocumentoNumero());
        invComprasAux.setCompDocumentoTipo(invCompras.getCompDocumentoTipo());
        invComprasAux.setCompFecha(invCompras.getCompFecha());
        invComprasAux.setCompFechaVencimiento(invCompras.getCompFechaVencimiento());
        invComprasAux.setCompFormaPago(invCompras.getCompFormaPago());
        invComprasAux.setCompIvaVigente(invCompras.getCompIvaVigente());
        invComprasAux.setCompMontoIva(invCompras.getCompMontoIva());
        invComprasAux.setCompNumeroAlterno(invCompras.getCompNumeroAlterno());
        invComprasAux.setCompObservaciones(invCompras.getCompObservaciones());
        invComprasAux.setCompElectronica(invCompras.getCompElectronica());
        invComprasAux.setCompActivoFijo(invCompras.getCompActivoFijo());
        invComprasAux.setCompImportacion(invCompras.getCompImportacion());
        invComprasAux.setCompPendiente(invCompras.getCompPendiente());
        invComprasAux.setCompRetencionAsumida(invCompras.getCompRetencionAsumida());
        invComprasAux.setCompRevisado(invCompras.getCompRevisado());
        invComprasAux.setCompSaldo(invCompras.getCompSaldo());
        invComprasAux.setCompOtrosImpuestos(invCompras.getCompOtrosImpuestos());
        invComprasAux.setCompTotal(invCompras.getCompTotal());
        invComprasAux.setCompValorRetenido(invCompras.getCompValorRetenido());
        invComprasAux.setConEmpresa(invCompras.getConEmpresa());
        invComprasAux.setConPeriodo(invCompras.getConPeriodo());
        invComprasAux.setConTipo(invCompras.getConTipo());
        invComprasAux.setConNumero(invCompras.getConNumero());
        invComprasAux.setInvComprasPK(invCompras.getInvComprasPK());
        invComprasAux.setInvProveedor(invCompras.getInvProveedor());
        invComprasAux.setSecEmpresa(invCompras.getSecEmpresa());
        invComprasAux.setSecCodigo(invCompras.getSecCodigo());
        invComprasAux.setEmpCodigo(invCompras.getEmpCodigo());
        invComprasAux.setUsrCodigo(invCompras.getUsrCodigo());
        invComprasAux.setUsrFechaInserta(invCompras.getUsrFechaInserta());
        return invComprasAux;
    }

    public static inventario.entity.InvVentas convertirInvVentas_InvVentas(inventario.entity.InvVentas invVentas) {
        inventario.entity.InvVentas invVentasAux = new inventario.entity.InvVentas();
        invVentasAux.setConEmpresa(invVentas.getConEmpresa());
        invVentasAux.setConNumero(invVentas.getConNumero());
        invVentasAux.setConPeriodo(invVentas.getConPeriodo());
        invVentasAux.setConTipo(invVentas.getConTipo());
        invVentasAux.setInvCliente(invVentas.getInvCliente());
        invVentasAux.setInvVentasPK(invVentas.getInvVentasPK());
        invVentasAux.setSecCodigo(invVentas.getSecCodigo());
        invVentasAux.setSecEmpresa(invVentas.getSecEmpresa());
        invVentasAux.setUsrCodigo(invVentas.getUsrCodigo());
        invVentasAux.setEmpCodigo(invVentas.getEmpCodigo());
        invVentasAux.setUsrFechaInserta(invVentas.getUsrFechaInserta());
        invVentasAux.setVtaAnulado(invVentas.getVtaAnulado());

        invVentasAux.setVtaBase0(invVentas.getVtaBase0());
        invVentasAux.setVtaBaseExenta(invVentas.getVtaBaseExenta());
        invVentasAux.setVtaBaseNoObjeto(invVentas.getVtaBaseNoObjeto());
        invVentasAux.setVtaBaseImponible(invVentas.getVtaBaseImponible());

        invVentasAux.setVtaDescuentoBase0(invVentas.getVtaDescuentoBase0());
        invVentasAux.setVtaDescuentoBaseImponible(invVentas.getVtaDescuentoBaseImponible());
        invVentasAux.setVtaDescuentoBaseExenta(invVentas.getVtaDescuentoBaseExenta());
        invVentasAux.setVtaDescuentoBaseNoObjeto(invVentas.getVtaDescuentoBaseNoObjeto());

        invVentasAux.setVtaSubtotalBase0(invVentas.getVtaSubtotalBase0());
        invVentasAux.setVtaSubtotalBaseImponible(invVentas.getVtaSubtotalBaseImponible());
        invVentasAux.setVtaSubtotalBaseExenta(invVentas.getVtaSubtotalBaseExenta());
        invVentasAux.setVtaSubtotalBaseNoObjeto(invVentas.getVtaSubtotalBaseNoObjeto());

//        invVentasAux.setInvBodega(invVentas.getInvBodega());
        invVentasAux.setBodCodigo(invVentas.getBodCodigo());
        invVentasAux.setBodEmpresa(invVentas.getBodEmpresa());
        invVentasAux.setSecEmpresa(invVentas.getSecEmpresa());
        invVentasAux.setSecCodigo(invVentas.getSecCodigo());

        invVentasAux.setCtaEmpresa(invVentas.getCtaEmpresa());
        invVentasAux.setCtaCodigo(invVentas.getCtaCodigo());


        invVentasAux.setVtaDocumentoEmpresa(invVentas.getEmpCodigo());
        invVentasAux.setVtaDocumentoNumero(invVentas.getVtaDocumentoNumero());
        invVentasAux.setVtaDocumentoTipo(invVentas.getVtaDocumentoTipo());
        invVentasAux.setVtaFecha(invVentas.getVtaFecha());
        invVentasAux.setVtaFechaVencimiento(invVentas.getVtaFechaVencimiento());
        invVentasAux.setVtaFormaPago(invVentas.getVtaFormaPago());
        invVentasAux.setVtaIvaVigente(invVentas.getVtaIvaVigente());
        invVentasAux.setVtaMontoiva(invVentas.getVtaMontoiva());
        invVentasAux.setVtaNumeroAlterno(invVentas.getVtaNumeroAlterno());
        invVentasAux.setVtaObservaciones(invVentas.getVtaObservaciones());
        invVentasAux.setVtaPendiente(invVentas.getVtaPendiente());
        invVentasAux.setVtaRevisado(invVentas.getVtaRevisado());
        invVentasAux.setVtaTotal(invVentas.getVtaTotal());
        invVentasAux.setVtaPagado(invVentas.getVtaPagado());
        return invVentasAux;
    }

    public static inventario.entity.InvComprasDetalle convertirInvCompraDetalle_InvCompraDetalle(inventario.entity.InvComprasDetalle invCompraDetalle) {
        inventario.entity.InvComprasDetalle invComprasDetalle = new inventario.entity.InvComprasDetalle();
        invComprasDetalle.setDetSecuencial(invCompraDetalle.getDetSecuencial());
        invComprasDetalle.setDetOrden(invCompraDetalle.getDetOrden());
        invComprasDetalle.setDetPendiente(invCompraDetalle.getDetPendiente());
        invComprasDetalle.setDetConfirmado(invCompraDetalle.getDetConfirmado());
        invComprasDetalle.setDetCantidad(invCompraDetalle.getDetCantidad());
        invComprasDetalle.setDetPrecio(invCompraDetalle.getDetPrecio());
        invComprasDetalle.setDetPorcentajeDescuento(invCompraDetalle.getDetPorcentajeDescuento());

        invComprasDetalle.setDetOtrosImpuestos(invCompraDetalle.getDetOtrosImpuestos());
        invComprasDetalle.setDetValorPromedio(invCompraDetalle.getDetValorPromedio());
        invComprasDetalle.setDetValorUltimaCompra(invCompraDetalle.getDetValorUltimaCompra());
        invComprasDetalle.setDetSaldo(invCompraDetalle.getDetSaldo());
        invComprasDetalle.setSecEmpresa(invCompraDetalle.getSecEmpresa());
        invComprasDetalle.setSecCodigo(invCompraDetalle.getSecCodigo());
        invComprasDetalle.setPisEmpresa(invCompraDetalle.getPisEmpresa());
        invComprasDetalle.setPisSector(invCompraDetalle.getPisSector());
        invComprasDetalle.setPisNumero(invCompraDetalle.getPisNumero());
        invComprasDetalle.setInvBodega(invCompraDetalle.getInvBodega());
        invComprasDetalle.setInvCompras(invCompraDetalle.getInvCompras());
        invComprasDetalle.setInvProducto(invCompraDetalle.getInvProducto());
        return invComprasDetalle;
    }

    public static inventario.entity.InvVentasDetalle convertirInvVentaDetalle_InvVentaDetalle(inventario.entity.InvVentasDetalle invVentaDetalle) {
        inventario.entity.InvVentasDetalle invVentasDetalle = new inventario.entity.InvVentasDetalle();
        invVentasDetalle.setDetSecuencial(invVentaDetalle.getDetSecuencial());
        invVentasDetalle.setDetOrden(invVentaDetalle.getDetOrden());
        invVentasDetalle.setDetPendiente(invVentaDetalle.getDetPendiente());
        invVentasDetalle.setDetPorcentajeDescuento(invVentaDetalle.getDetPorcentajeDescuento());
        invVentasDetalle.setDetCantidad(invVentaDetalle.getDetCantidad());
        invVentasDetalle.setDetPrecio(invVentaDetalle.getDetPrecio());

//        invVentasDetalle.setDetValorPromedio(invVentasDetalle.getDetValorPromedio());
//        invVentasDetalle.setDetValorUltimaCompra(invVentasDetalle.getDetValorUltimaCompra());
        invVentasDetalle.setDetPorcentajeRecargo(invVentaDetalle.getDetPorcentajeRecargo());
        invVentasDetalle.setSecEmpresa(invVentaDetalle.getSecEmpresa());
        invVentasDetalle.setSecCodigo(invVentaDetalle.getSecCodigo());
        invVentasDetalle.setPisEmpresa(invVentaDetalle.getPisEmpresa());
        invVentasDetalle.setPisSector(invVentaDetalle.getPisSector());
        invVentasDetalle.setPisNumero(invVentaDetalle.getPisNumero());
        invVentasDetalle.setInvBodega(invVentaDetalle.getInvBodega());
        invVentasDetalle.setInvVentas(invVentaDetalle.getInvVentas());
        invVentasDetalle.setInvProducto(invVentaDetalle.getInvProducto());
        return invVentasDetalle;
    }

    public static inventario.entity.InvProformasDetalle convertirInvProformaDetalle_InvProformaDetalle(inventario.entity.InvProformasDetalle invProformaDetalle) {
        inventario.entity.InvProformasDetalle invProformasDetalle = new inventario.entity.InvProformasDetalle();
        invProformasDetalle.setDetSecuencial(invProformaDetalle.getDetSecuencial());
        invProformasDetalle.setDetOrden(invProformaDetalle.getDetOrden());
        invProformasDetalle.setDetPorcentajeDescuento(invProformaDetalle.getDetPorcentajeDescuento());
        invProformasDetalle.setDetCantidad(invProformaDetalle.getDetCantidad());
        invProformasDetalle.setDetPrecio(invProformaDetalle.getDetPrecio());

//        invVentasDetalle.setDetValorPromedio(invVentasDetalle.getDetValorPromedio());
//        invVentasDetalle.setDetValorUltimaCompra(invVentasDetalle.getDetValorUltimaCompra());

        invProformasDetalle.setInvProducto(invProformaDetalle.getInvProducto());
        return invProformasDetalle;
    }

    public static inventario.entity.InvConsumosDetalle convertirInvConsumoDetalle_InvConsumoDetalle(inventario.entity.InvConsumosDetalle invConsumoDetalle) {
        inventario.entity.InvConsumosDetalle invConsumosDetalle = new inventario.entity.InvConsumosDetalle();
        invConsumosDetalle.setDetSecuencial(invConsumoDetalle.getDetSecuencial());
        invConsumosDetalle.setDetOrden(invConsumoDetalle.getDetOrden());
        invConsumosDetalle.setDetCantidad(invConsumoDetalle.getDetCantidad());

//        invConsumosDetalle.setDetValorPromedio(invConsumosDetalle.getDetValorPromedio());
//        invConsumosDetalle.setDetValorUltimaCompra(invConsumosDetalle.getDetValorUltimaCompra());

        invConsumosDetalle.setSecEmpresa(invConsumoDetalle.getSecEmpresa());
        invConsumosDetalle.setSecCodigo(invConsumoDetalle.getSecCodigo());
        invConsumosDetalle.setPisEmpresa(invConsumoDetalle.getPisEmpresa());
        invConsumosDetalle.setPisSector(invConsumoDetalle.getPisSector());
        invConsumosDetalle.setPisNumero(invConsumoDetalle.getPisNumero());
        invConsumosDetalle.setInvBodega(invConsumoDetalle.getInvBodega());
        invConsumosDetalle.setInvConsumos(invConsumoDetalle.getInvConsumos());
        invConsumosDetalle.setInvProducto(invConsumoDetalle.getInvProducto());
        return invConsumosDetalle;
    }

    public static inventario.entity.InvTransferenciasDetalle convertirInvTransferenciasDetalle_InvTransferenciasDetalle(inventario.entity.InvTransferenciasDetalle invTransferenciaDetalle) {
        inventario.entity.InvTransferenciasDetalle invTransferenciasDetalle = new inventario.entity.InvTransferenciasDetalle();
        invTransferenciasDetalle.setDetSecuencial(invTransferenciaDetalle.getDetSecuencial());
        invTransferenciasDetalle.setDetOrden(invTransferenciaDetalle.getDetOrden());
        invTransferenciasDetalle.setDetCantidad(invTransferenciaDetalle.getDetCantidad());

//        invTransferenciasDetalle.setDetValorPromedio(invTransferenciasDetalle.getDetValorPromedio());
//        invTransferenciasDetalle.setDetValorUltimaCompra(invTransferenciasDetalle.getDetValorUltimaCompra());

        invTransferenciasDetalle.setInvBodega(invTransferenciaDetalle.getInvBodega());
        invTransferenciasDetalle.setInvBodega1(invTransferenciaDetalle.getInvBodega1());
        invTransferenciasDetalle.setSecOrigenEmpresa(invTransferenciaDetalle.getSecOrigenEmpresa());
        invTransferenciasDetalle.setSecOrigenCodigo(invTransferenciaDetalle.getSecOrigenCodigo());
        invTransferenciasDetalle.setSecDestinoEmpresa(invTransferenciaDetalle.getSecDestinoEmpresa());
        invTransferenciasDetalle.setSecDestinoCodigo(invTransferenciaDetalle.getSecDestinoCodigo());
        invTransferenciasDetalle.setInvTransferencias(invTransferenciaDetalle.getInvTransferencias());
        invTransferenciasDetalle.setInvProducto(invTransferenciaDetalle.getInvProducto());
        return invTransferenciasDetalle;
    }

    public static inventario.entity.InvComprasDetalle convertirInvComprasDetalleTO_InvComprasDetalle(
            inventario.TO.InvComprasDetalleTO invComprasDetalleTO) {
        inventario.entity.InvComprasDetalle invComprasDetalle = new inventario.entity.InvComprasDetalle();
        invComprasDetalle.setDetSecuencial(invComprasDetalleTO.getDetSecuencia());
        invComprasDetalle.setDetOrden(invComprasDetalleTO.getDetOrden());
        invComprasDetalle.setDetPendiente(invComprasDetalleTO.getDetPendiente());
        invComprasDetalle.setDetConfirmado(invComprasDetalleTO.getDetConfirnado());

//        invComprasDetalle.setDetFecha(validaciones.Validacion.fecha(invComprasDetalleTO.getDetFecha()));
        invComprasDetalle.setDetCantidad(invComprasDetalleTO.getDetCantidad());
        invComprasDetalle.setDetPrecio(invComprasDetalleTO.getDetPrecio());
//        invComprasDetalle.setDetValorPromedio(new java.math.BigDecimal("0.00"));
//        invComprasDetalle.setDetValorUltimaCompra(new java.math.BigDecimal("0.00"));
        invComprasDetalle.setDetValorUltimaCompra(invComprasDetalleTO.getDetValorUltimaCompra());
        invComprasDetalle.setDetValorPromedio(invComprasDetalleTO.getDetValorPromedio());
        invComprasDetalle.setDetOtrosImpuestos(invComprasDetalleTO.getDetOtrosImpuestos());

        invComprasDetalle.setDetPorcentajeDescuento(invComprasDetalleTO.getDetPorcentajeDescuento());
        //invComprasDetalle.setInvBodega(new inventario.entity.InvBodega(invComprasDetalleTO.getBodEmpresa(), invComprasDetalleTO.getBodCodigo()));


//        invComprasDetalle.setBodEmpresa(invComprasDetalleTO.getEmpCodigo());
//        invComprasDetalle.setBodCodigo(invComprasDetalleTO.getBodCodigo());
        invComprasDetalle.setSecEmpresa(invComprasDetalleTO.getSecEmpresa());
        invComprasDetalle.setSecCodigo(invComprasDetalleTO.getSecCodigo());
        invComprasDetalle.setPisEmpresa(invComprasDetalleTO.getPisEmpresa());
        invComprasDetalle.setPisSector(invComprasDetalleTO.getPisSector());
        invComprasDetalle.setPisNumero(invComprasDetalleTO.getPisNumero());
        return invComprasDetalle;
    }

    public static inventario.entity.InvVentasDetalle convertirInvVentasDetalleTO_InvVentasDetalle(
            inventario.TO.InvVentasDetalleTO invVentasDetalleTO) {

        inventario.entity.InvVentasDetalle invVentasDetalle = new inventario.entity.InvVentasDetalle();
        invVentasDetalle.setDetSecuencial(invVentasDetalleTO.getDetSecuencia());
        invVentasDetalle.setDetOrden(invVentasDetalleTO.getDetOrden());
        invVentasDetalle.setDetPendiente(invVentasDetalleTO.getDetPendiente());
        invVentasDetalle.setDetCantidad(invVentasDetalleTO.getDetCantidad());
        invVentasDetalle.setDetPrecio(invVentasDetalleTO.getDetPrecio());
        invVentasDetalle.setDetPorcentajeRecargo(invVentasDetalleTO.getDetPorcentajeRecargo());
        invVentasDetalle.setDetPorcentajeDescuento(invVentasDetalleTO.getDetPorcentajeDescuento());
        invVentasDetalle.setDetValorPromedio(invVentasDetalleTO.getDetValorPromedio());

        invVentasDetalle.setDetValorUltimaCompra(invVentasDetalleTO.getDetValorUltimaCompra());

        invVentasDetalle.setDetSaldo(invVentasDetalleTO.getDetSaldo());
        //invVentasDetalle.setInvBodega(new inventario.entity.InvBodega(invVentasDetalleTO.getBodEmpresa(), invVentasDetalleTO.getBodCodigo()));
        invVentasDetalle.setProNombre(invVentasDetalleTO.getProNombre());
        //invVentasDetalle.setInvProducto(new inventario.entity.InvProducto(invVentasDetalleTO.getProEmpresa(), invVentasDetalleTO.getProCodigoPrincipal()));
        //invVentasDetalle.setProCreditoTributario(invVentasDetalleTO.getProCreditoTributario());
        invVentasDetalle.setSecEmpresa(invVentasDetalleTO.getSecEmpresa());
        invVentasDetalle.setSecCodigo(invVentasDetalleTO.getSecCodigo());

        invVentasDetalle.setPisEmpresa(invVentasDetalleTO.getPisEmpresa());
        invVentasDetalle.setPisSector(invVentasDetalleTO.getPisSector());
        invVentasDetalle.setPisNumero(invVentasDetalleTO.getPisNumero());

//        invVentasDetalle.setInvVentas(new inventario.entity.InvVentas(
//                invVentasDetalleTO.getVtaEmpresa(),
//                invVentasDetalleTO.getVtaPeriodo(),
//                invVentasDetalleTO.getVtaMotivo(),
//                invVentasDetalleTO.getVtaNumero()));

        return invVentasDetalle;
    }

    public static inventario.entity.InvProformasDetalle convertirInvProformasDetalleTO_InvProformasDetalle(
            inventario.TO.InvProformasDetalleTO invProformasDetalleTO) {
        inventario.entity.InvProformasDetalle invProformasDetalle = new inventario.entity.InvProformasDetalle();
        invProformasDetalle.setDetSecuencial(invProformasDetalleTO.getDetSecuencia());
        invProformasDetalle.setDetOrden(invProformasDetalleTO.getDetOrden());
        invProformasDetalle.setDetCantidad(invProformasDetalleTO.getDetCantidad());
        invProformasDetalle.setDetPrecio(invProformasDetalleTO.getDetPrecio());

//        invVentasDetalle.setDetValorPromedio(new java.math.BigDecimal("0.00"));
//        invVentasDetalle.setDetValorUltimaCompra(new java.math.BigDecimal("0.00"));

        invProformasDetalle.setDetPorcentajeDescuento(invProformasDetalleTO.getDetPorcentajeDescuento());
//        invVentasDetalle.setBodEmpresa(invVentasDetalleTO.getBodEmpresa());
        invProformasDetalle.setProNombre(invProformasDetalleTO.getProNombre());
        return invProformasDetalle;
    }

    public static java.util.List<inventario.TO.InvListaProductosTO> convertirListaInvProducto_ListaInvProductoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)

            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String lpsp_codigo_principal;
            try {
                lpsp_codigo_principal = array[0].toString();
            } catch (Exception e) {
                lpsp_codigo_principal = null;
            }
            String lpsp_codigo_barra;
            try {
                lpsp_codigo_barra = array[1].toString();
            } catch (Exception e) {
                lpsp_codigo_barra = null;
            }
            String lpsp_codigo_barra2;
            try {
                lpsp_codigo_barra2 = array[2].toString();
            } catch (Exception e) {
                lpsp_codigo_barra2 = null;
            }
            String lpsp_codigo_barra3;
            try {
                lpsp_codigo_barra3 = array[3].toString();
            } catch (Exception e) {
                lpsp_codigo_barra3 = null;
            }
            String lpsp_codigo_barra4;
            try {
                lpsp_codigo_barra4 = array[4].toString();
            } catch (Exception e) {
                lpsp_codigo_barra4 = null;
            }
            String lpsp_codigo_barra5;
            try {
                lpsp_codigo_barra5 = array[5].toString();
            } catch (Exception e) {
                lpsp_codigo_barra5 = null;
            }
            String lpsp_nombre;
            try {
                lpsp_nombre = array[6].toString();
            } catch (Exception e) {
                lpsp_nombre = null;
            }
            String lpsp_categoria;
            try {
                lpsp_categoria = array[7].toString();
            } catch (Exception e) {
                lpsp_categoria = null;
            }
            String lpsp_empaque;
            try {
                lpsp_empaque = array[8].toString();
            } catch (Exception e) {
                lpsp_empaque = null;
            }
            java.math.BigDecimal lpsp_saldo;
            try {
                lpsp_saldo = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                lpsp_saldo = null;
            }
            java.math.BigDecimal lpsp_costo;
            try {
                lpsp_costo = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                lpsp_costo = null;
            }
            String lpsp_medida;
            try {
                lpsp_medida = array[11].toString();
            } catch (Exception e) {
                lpsp_medida = null;
            }
            /*
             *
             *
             * + "lpsp_precio3 * lpsp_cantidad3 lpsp_precio_caja, " + "lpsp_iva
             * "
             */
            java.math.BigDecimal lpsp_precio1;
            try {
                lpsp_precio1 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                lpsp_precio1 = null;
            }
            java.math.BigDecimal lpsp_precio2;
            try {
                lpsp_precio2 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                lpsp_precio2 = null;
            }
            java.math.BigDecimal lpsp_precio3;
            try {
                lpsp_precio3 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                lpsp_precio3 = null;
            }
            java.math.BigDecimal lpsp_precio4;
            try {
                lpsp_precio4 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                lpsp_precio4 = null;
            }
            java.math.BigDecimal lpsp_precio5;
            try {
                lpsp_precio5 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                lpsp_precio5 = null;
            }
            java.math.BigDecimal lpsp_precio_caja;
            try {
                lpsp_precio_caja = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                lpsp_precio_caja = null;
            }
            String lpsp_iva;
            try {
                lpsp_iva = array[18].toString();
            } catch (Exception e) {
                lpsp_iva = null;
            }

            lista.add(
                    new inventario.TO.InvListaProductosTO(
                    lpsp_codigo_principal, lpsp_codigo_barra, lpsp_codigo_barra2, lpsp_codigo_barra3, lpsp_codigo_barra4, lpsp_codigo_barra5, lpsp_nombre, lpsp_categoria,
                    lpsp_empaque, lpsp_saldo, lpsp_costo, lpsp_medida, lpsp_precio1, lpsp_precio2, lpsp_precio3,
                    lpsp_precio4, lpsp_precio5, lpsp_precio_caja, lpsp_iva));
        }
        return lista;
    }

    /////MODIFICAR PARA CLIENTES EN LA TABLA
    public static java.util.List<inventario.TO.InvListaClienteTO> convertirListaInvCliente_ListaInvClienteTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            lista.add(new inventario.TO.InvListaClienteTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaProveedoresTO> convertirListaInvProveedores_ListaInvProveedoresTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            lista.add(new inventario.TO.InvListaProveedoresTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaBodegasTO> convertirListaInvBodegas_ListaInvBodegasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            /*
             * + ", " + "bod_nombre, " + "sis_usuario.usr_apellido ||'
             * '||sis_usuario.usr_nombre bod_responsable, " + "bod_inactiva, " +
             * "sec_codigo "
             */
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String bod_codigo;
            try {
                bod_codigo = array[0].toString();
            } catch (Exception e) {
                bod_codigo = null;
            }
            String bod_nombre;
            try {
                bod_nombre = array[1].toString();
            } catch (Exception e) {
                bod_nombre = null;
            }
            String bod_responsable;
            try {
                bod_responsable = array[2].toString();
            } catch (Exception e) {
                bod_responsable = null;
            }
            Boolean bod_inactiva;
            try {
                bod_inactiva = Boolean.parseBoolean(array[3].toString());
            } catch (Exception e) {
                bod_inactiva = null;
            }

            String sec_codigo;
            try {
                sec_codigo = array[4].toString();
            } catch (Exception e) {
                sec_codigo = null;
            }
            lista.add(new inventario.TO.InvListaBodegasTO(bod_codigo, bod_nombre, bod_responsable, bod_inactiva, sec_codigo));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvCategoriaComboProductoTO> convertirListaCategoriaCombo_ListaCategoriaComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvCategoriaComboProductoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoMarcaComboListadoTO> convertirListaComboMarca_ListaComboMarcaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvProductoMarcaComboListadoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoPresentacionUnidadesComboListadoTO> convertirListaComboPresentacionUnidad_ListaComboPresentacionUnidadTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvProductoPresentacionUnidadesComboListadoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoPresentacionCajasComboListadoTO> convertirListaComboPresentacionCaja_ListaComboPresentacionCajaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvProductoPresentacionCajasComboListadoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvCompraMotivoComboTO> convertirListaCompraMotivoCombo_ListaCompraMotivoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String cm_codigo;
            try {
                cm_codigo = array[0].toString();
            } catch (Exception e) {
                cm_codigo = null;
            }
            String cm_detalle;
            try {
                cm_detalle = array[1].toString();
            } catch (Exception e) {
                cm_detalle = null;
            }
            String tip_codigo;
            try {
                tip_codigo = array[2].toString();
            } catch (Exception e) {
                tip_codigo = null;
            }
            String cm_forma_contabilizar;
            try {
                cm_forma_contabilizar = array[3].toString();
            } catch (Exception e) {
                cm_forma_contabilizar = null;
            }
            String cm_forma_imprimir;
            try {
                cm_forma_imprimir = array[4].toString();
            } catch (Exception e) {
                cm_forma_imprimir = null;
            }

            lista.add(new inventario.TO.InvCompraMotivoComboTO(cm_codigo, cm_detalle, tip_codigo, cm_forma_contabilizar, cm_forma_imprimir));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvVentaMotivoComboTO> convertirListaVentaMotivoCombo_ListaVentaMotivoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            /*
             * vm_codigo, vm_detalle, tip_codigo, vm_forma_contabilizar,
             * vm_forma_imprimir
             */
            String vm_codigo;
            try {
                vm_codigo = array[0].toString();
            } catch (Exception e) {
                vm_codigo = null;
            }
            String vm_detalle;
            try {
                vm_detalle = array[1].toString();
            } catch (Exception e) {
                vm_detalle = null;
            }
            String tip_codigo;
            try {
                tip_codigo = array[2].toString();
            } catch (Exception e) {
                tip_codigo = null;
            }
            String vm_forma_contabilizar;
            try {
                vm_forma_contabilizar = array[3].toString();
            } catch (Exception e) {
                vm_forma_contabilizar = null;
            }
            String vm_forma_imprimir;
            try {
                vm_forma_imprimir = array[4].toString();
            } catch (Exception e) {
                vm_forma_imprimir = null;
            }
            lista.add(new inventario.TO.InvVentaMotivoComboTO(vm_codigo, vm_detalle, tip_codigo, vm_forma_contabilizar, vm_forma_imprimir));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProformaMotivoComboTO> convertirListaProformaMotivoCombo_ListaProformaMotivoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            lista.add(new inventario.TO.InvProformaMotivoComboTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvCategoriaProveedorComboTO> convertirListaCategoriaProveedorCombo_ListaCategoriaProveedorComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            lista.add(new inventario.TO.InvCategoriaProveedorComboTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvCategoriaClienteComboTO> convertirListaCategoriaClienteCombo_ListaCategoriaClienteComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            lista.add(new inventario.TO.InvCategoriaClienteComboTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvBodegaTO> convertirListaBodega_ListaCategoriaBodegaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String bod_codigo;
            try {
                bod_codigo = array[0].toString();
            } catch (Exception e) {
                bod_codigo = null;
            }
            String bod_nombre;
            try {
                bod_nombre = array[1].toString();
            } catch (Exception e) {
                bod_nombre = null;
            }
            String sec_codigo;
            try {
                sec_codigo = array[3].toString();
            } catch (Exception e) {
                sec_codigo = null;
            }
            inventario.TO.InvBodegaTO invBodegaTO = new inventario.TO.InvBodegaTO();
            invBodegaTO.setBodCodigo(bod_codigo);
            invBodegaTO.setBodNombre(bod_nombre);
            invBodegaTO.setSecCodigo(sec_codigo);
            lista.add(invBodegaTO);
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoTO> convertirListaProducto_ListaProductoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String pro_empresa;
            try {
                pro_empresa = array[0].toString();
            } catch (Exception e) {
                pro_empresa = null;
            }
            String pro_codigo_principal;
            try {
                pro_codigo_principal = array[1].toString();
            } catch (Exception e) {
                pro_codigo_principal = null;
            }
            String pro_codigo_alterno;
            try {
                pro_codigo_alterno = array[2].toString();
            } catch (Exception e) {
                pro_codigo_alterno = null;
            }
            String pro_codigo_barra;
            try {
                pro_codigo_barra = array[3].toString();
            } catch (Exception e) {
                pro_codigo_barra = null;
            }
            String pro_codigo_barra2;
            try {
                pro_codigo_barra2 = array[4].toString();
            } catch (Exception e) {
                pro_codigo_barra2 = null;
            }
            String pro_codigo_barra3;
            try {
                pro_codigo_barra3 = array[5].toString();
            } catch (Exception e) {
                pro_codigo_barra3 = null;
            }

            String pro_codigo_barra4;
            try {
                pro_codigo_barra4 = array[6].toString();
            } catch (Exception e) {
                pro_codigo_barra4 = null;
            }
            String pro_codigo_barra5;
            try {
                pro_codigo_barra5 = array[7].toString();
            } catch (Exception e) {
                pro_codigo_barra5 = null;
            }

            String pro_empaque;
            try {
                pro_empaque = array[8].toString();
            } catch (Exception e) {
                pro_empaque = null;
            }
            String pro_nombre;
            try {
                pro_nombre = array[9].toString();
            } catch (Exception e) {
                pro_nombre = null;
            }
            String pro_detalle;
            try {
                pro_detalle = array[10].toString();
            } catch (Exception e) {
                pro_detalle = null;
            }

            java.math.BigDecimal pro_cantidad1;
            try {
                pro_cantidad1 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                pro_cantidad1 = null;
            }
            java.math.BigDecimal pro_cantidad2;
            try {
                pro_cantidad2 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                pro_cantidad2 = null;
            }
            java.math.BigDecimal pro_cantidad3;
            try {
                pro_cantidad3 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                pro_cantidad3 = null;
            }
            java.math.BigDecimal pro_cantidad4;
            try {
                pro_cantidad4 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                pro_cantidad4 = null;
            }
            java.math.BigDecimal pro_cantidad5;
            try {
                pro_cantidad5 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                pro_cantidad5 = null;
            }
            java.math.BigDecimal pro_precio1;
            try {
                pro_precio1 = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                pro_precio1 = null;
            }
            java.math.BigDecimal pro_precio2;
            try {
                pro_precio2 = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                pro_precio2 = null;
            }
            java.math.BigDecimal pro_precio3;
            try {
                pro_precio3 = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                pro_precio3 = null;
            }
            java.math.BigDecimal pro_precio4;
            try {
                pro_precio4 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                pro_precio4 = null;
            }
            java.math.BigDecimal pro_precio5;
            try {
                pro_precio5 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                pro_precio5 = null;
            }
            java.math.BigDecimal pro_descuento1;
            try {
                pro_descuento1 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                pro_descuento1 = null;
            }
            java.math.BigDecimal pro_descuento2;
            try {
                pro_descuento2 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                pro_descuento2 = null;
            }
            java.math.BigDecimal pro_descuento3;
            try {
                pro_descuento3 = new java.math.BigDecimal(array[23].toString());
            } catch (Exception e) {
                pro_descuento3 = null;
            }
            java.math.BigDecimal pro_descuento4;
            try {
                pro_descuento4 = new java.math.BigDecimal(array[24].toString());
            } catch (Exception e) {
                pro_descuento4 = null;
            }
            java.math.BigDecimal pro_descuento5;
            try {
                pro_descuento5 = new java.math.BigDecimal(array[25].toString());
            } catch (Exception e) {
                pro_descuento5 = null;
            }
            java.math.BigDecimal pro_margen_utilidad1;
            try {
                pro_margen_utilidad1 = new java.math.BigDecimal(array[26].toString());
            } catch (Exception e) {
                pro_margen_utilidad1 = null;
            }
            java.math.BigDecimal pro_margen_utilidad2;
            try {
                pro_margen_utilidad2 = new java.math.BigDecimal(array[27].toString());
            } catch (Exception e) {
                pro_margen_utilidad2 = null;
            }
            java.math.BigDecimal pro_margen_utilidad3;
            try {
                pro_margen_utilidad3 = new java.math.BigDecimal(array[28].toString());
            } catch (Exception e) {
                pro_margen_utilidad3 = null;
            }
            java.math.BigDecimal pro_margen_utilidad4;
            try {
                pro_margen_utilidad4 = new java.math.BigDecimal(array[29].toString());
            } catch (Exception e) {
                pro_margen_utilidad4 = null;
            }
            java.math.BigDecimal pro_margen_utilidad5;
            try {
                pro_margen_utilidad5 = new java.math.BigDecimal(array[30].toString());
            } catch (Exception e) {
                pro_margen_utilidad5 = null;
            }

            Integer pro_minimo;
            try {
                pro_minimo = new Integer(array[31].toString());
            } catch (Exception e) {
                pro_minimo = null;
            }
            Integer pro_maximo;
            try {
                pro_maximo = new Integer(array[32].toString());
            } catch (Exception e) {
                pro_maximo = null;
            }

            String pro_iva;
            try {
                pro_iva = array[33].toString();
            } catch (Exception e) {
                pro_iva = null;
            }

            Boolean pro_credito_tributario;
            try {
                pro_credito_tributario = Boolean.valueOf(array[34].toString());
            } catch (Exception e) {
                pro_credito_tributario = null;
            }
            Boolean pro_stock_negativo;
            try {
                pro_stock_negativo = Boolean.valueOf(array[35].toString());
            } catch (Exception e) {
                pro_stock_negativo = null;
            }
            Boolean pro_inactivo;
            try {
                pro_inactivo = Boolean.valueOf(array[36].toString());
            } catch (Exception e) {
                pro_inactivo = null;
            }

            String pro_cuenta_inventario;
            try {
                pro_cuenta_inventario = array[37].toString();
            } catch (Exception e) {
                pro_cuenta_inventario = null;
            }
            String pro_cuenta_gasto;
            try {
                pro_cuenta_gasto = array[38].toString();
            } catch (Exception e) {
                pro_cuenta_gasto = null;
            }
            String pro_cuenta_venta;
            try {
                pro_cuenta_venta = array[39].toString();
            } catch (Exception e) {
                pro_cuenta_venta = null;
            }
            String pro_cuenta_transferencia_ipp;
            try {
                pro_cuenta_transferencia_ipp = array[40].toString();
            } catch (Exception e) {
                pro_cuenta_transferencia_ipp = null;
            }
            String cat_empresa;
            try {
                cat_empresa = array[41].toString();
            } catch (Exception e) {
                cat_empresa = null;
            }
            String cat_codigo;
            try {
                cat_codigo = array[42].toString();
            } catch (Exception e) {
                cat_codigo = null;
            }
            String mar_empresa;
            try {
                mar_empresa = array[43].toString();
            } catch (Exception e) {
                mar_empresa = null;
            }
            String mar_codigo;
            try {
                mar_codigo = array[44].toString();
            } catch (Exception e) {
                mar_codigo = null;
            }
            String presu_empresa;
            try {
                presu_empresa = array[45].toString();
            } catch (Exception e) {
                presu_empresa = null;
            }
            String presu_codigo;
            try {
                presu_codigo = array[46].toString();
            } catch (Exception e) {
                presu_codigo = null;
            }
            String presc_empresa;
            try {
                presc_empresa = array[47].toString();
            } catch (Exception e) {
                presc_empresa = null;
            }
            String presc_codigo;
            try {
                presc_codigo = array[48].toString();
            } catch (Exception e) {
                presc_codigo = null;
            }
            String tip_empresa;
            try {
                tip_empresa = array[49].toString();
            } catch (Exception e) {
                tip_empresa = null;
            }
            String tip_codigo;
            try {
                tip_codigo = array[50].toString();
            } catch (Exception e) {
                tip_codigo = null;
            }
            String med_empresa;
            try {
                med_empresa = array[51].toString();
            } catch (Exception e) {
                med_empresa = null;
            }
            String med_codigo;
            try {
                med_codigo = array[52].toString();
            } catch (Exception e) {
                med_codigo = null;
            }
            String usr_empresa;
            try {
                usr_empresa = array[53].toString();
            } catch (Exception e) {
                usr_empresa = null;
            }

            String usr_codigo;
            try {
                usr_codigo = array[54].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[55].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }
            Double bal_factor_libras;
            try {
                bal_factor_libras = new Double(array[56].toString());
            } catch (Exception e) {
                bal_factor_libras = null;
            }
            String con_codigo;
            try {
                con_codigo = array[57].toString();
            } catch (Exception e) {
                con_codigo = null;
            }
            String sus_codigo;
            try {
                sus_codigo = array[58].toString();
            } catch (Exception e) {
                sus_codigo = null;
            }
            java.math.BigDecimal pro_factor_caja_saco_bulto;
            try {
                pro_factor_caja_saco_bulto = new java.math.BigDecimal(array[59].toString());
            } catch (Exception e) {
                pro_factor_caja_saco_bulto = null;
            }
            lista.add(new inventario.TO.InvProductoTO(
                    pro_empresa, pro_codigo_principal, pro_codigo_alterno, pro_codigo_barra, pro_codigo_barra2, pro_codigo_barra3, pro_codigo_barra4, pro_codigo_barra5, pro_empaque,
                    pro_nombre, pro_detalle, pro_cantidad1, pro_cantidad2, pro_cantidad3, pro_cantidad4, pro_cantidad5, pro_precio1, pro_precio2, pro_precio3,
                    pro_precio4, pro_precio5, pro_descuento1, pro_descuento2, pro_descuento3, pro_descuento4, pro_descuento5, pro_margen_utilidad1, pro_margen_utilidad2, pro_margen_utilidad3,
                    pro_margen_utilidad4, pro_margen_utilidad5, pro_minimo, pro_maximo, pro_iva, pro_credito_tributario, pro_stock_negativo, pro_inactivo, pro_cuenta_inventario, pro_cuenta_gasto,
                    pro_cuenta_venta, pro_cuenta_transferencia_ipp, cat_empresa, cat_codigo, mar_empresa, mar_codigo, presu_empresa, presu_codigo, presc_empresa, presc_codigo,
                    tip_empresa, tip_codigo, med_empresa, med_codigo, usr_empresa, usr_codigo, usr_fecha_inserta, bal_factor_libras, con_codigo, sus_codigo, pro_factor_caja_saco_bulto));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvClienteTO> convertirListaCliente_ListaClienteTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String cli_empresa;
            try {
                cli_empresa = array[0].toString();
            } catch (Exception e) {
                cli_empresa = null;
            }
            String cli_codigo;
            try {
                cli_codigo = array[1].toString();
            } catch (Exception e) {
                cli_codigo = null;
            }
            Character cli_id_tipo;
            try {
                cli_id_tipo = array[3].toString().charAt(0);
            } catch (Exception e) {
                cli_id_tipo = null;
            }
            String cli_id_numero;
            try {
                cli_id_numero = array[4].toString();
            } catch (Exception e) {
                cli_id_numero = null;
            }
            String cli_nombre;
            try {
                cli_nombre = array[5].toString();
            } catch (Exception e) {
                cli_nombre = null;
            }
            String cli_razon_social;
            try {
                cli_razon_social = array[6].toString();
            } catch (Exception e) {
                cli_razon_social = null;
            }
            String cli_provincia;
            try {
                cli_provincia = array[7].toString();
            } catch (Exception e) {
                cli_provincia = null;
            }
            String cli_ciudad;
            try {
                cli_ciudad = array[8].toString();
            } catch (Exception e) {
                cli_ciudad = null;
            }
            String cli_parroquia;
            try {
                cli_parroquia = array[9].toString();
            } catch (Exception e) {
                cli_parroquia = null;
            }
            String cli_zona;
            try {
                cli_zona = array[10].toString();
            } catch (Exception e) {
                cli_zona = null;
            }
            String cli_direccion;
            try {
                cli_direccion = array[11].toString();
            } catch (Exception e) {
                cli_direccion = null;
            }
            String cli_telefono;
            try {
                cli_telefono = array[12].toString();
            } catch (Exception e) {
                cli_telefono = null;
            }
            String cli_celular;
            try {
                cli_celular = array[13].toString();
            } catch (Exception e) {
                cli_celular = null;
            }
            String cli_email;
            try {
                cli_email = array[14].toString();
            } catch (Exception e) {
                cli_email = null;
            }
            Short cli_precio;
            try {
                cli_precio = new Short(array[15].toString());
            } catch (Exception e) {
                cli_precio = null;
            }
            Short cli_dias_credito;
            try {
                cli_dias_credito = new Short(array[16].toString());
            } catch (Exception e) {
                cli_dias_credito = null;
            }
            java.math.BigDecimal cli_cupo_credito;
            try {
                cli_cupo_credito = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                cli_cupo_credito = null;
            }
            String cli_observaciones;
            try {
                cli_observaciones = array[18].toString();
            } catch (Exception e) {
                cli_observaciones = null;
            }
            Boolean cli_relacionado;
            try {
                cli_relacionado = Boolean.valueOf(array[19].toString());
            } catch (Exception e) {
                cli_relacionado = null;
            }
            Boolean cli_inactivo;
            try {
                cli_inactivo = Boolean.valueOf(array[20].toString());
            } catch (Exception e) {
                cli_inactivo = null;
            }
            Integer cli_secuencia;
            try {
                cli_secuencia = new Integer(array[21].toString());
            } catch (Exception e) {
                cli_secuencia = null;
            }
            //-------------
            String vend_empresa;
            try {
                vend_empresa = array[22].toString();
            } catch (Exception e) {
                vend_empresa = null;
            }
            String vend_codigo;
            try {
                vend_codigo = array[23].toString();
            } catch (Exception e) {
                vend_codigo = null;
            }
            String cc_codigo;
            try {
                cc_codigo = array[25].toString();
            } catch (Exception e) {
                cc_codigo = null;
            }
            String usr_codigo;
            try {
                usr_codigo = array[27].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[28].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }
            lista.add(new inventario.TO.InvClienteTO(
                    cli_empresa,
                    cli_codigo,
                    cli_id_tipo,
                    cli_id_numero,
                    cli_nombre,
                    cli_razon_social,
                    cli_provincia,
                    cli_ciudad,
                    cli_parroquia,
                    cli_zona,
                    cli_direccion,
                    cli_telefono,
                    cli_celular,
                    cli_email,
                    cli_precio,
                    cli_dias_credito,
                    cli_cupo_credito,
                    cli_observaciones,
                    cli_relacionado,
                    cli_inactivo,
                    cli_secuencia,
                    vend_empresa,
                    vend_codigo,
                    cc_codigo,
                    usr_codigo,
                    usr_fecha_inserta));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProveedorTO> convertirListaProveedor_ListaProveedorTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String prov_empresa;
            try {
                prov_empresa = array[0].toString();
            } catch (Exception e) {
                prov_empresa = null;
            }
            String prov_codigo;
            try {
                prov_codigo = array[1].toString();
            } catch (Exception e) {
                prov_codigo = null;
            }
            Character prov_id_tipo;
            try {
                prov_id_tipo = array[3].toString().charAt(0);
            } catch (Exception e) {
                prov_id_tipo = null;
            }
            String prov_id_numero;
            try {
                prov_id_numero = array[4].toString();
            } catch (Exception e) {
                prov_id_numero = null;
            }
            String prov_nombre;
            try {
                prov_nombre = array[5].toString();
            } catch (Exception e) {
                prov_nombre = "";
            }
            String prov_razon_social;
            try {
                prov_razon_social = array[6].toString();
            } catch (Exception e) {
                prov_razon_social = null;
            }
            String prov_provincia;
            try {
                prov_provincia = array[7].toString();
            } catch (Exception e) {
                prov_provincia = null;
            }
            String prov_ciudad;
            try {
                prov_ciudad = array[8].toString();
            } catch (Exception e) {
                prov_ciudad = null;
            }
            String prov_parroquia;
            try {
                prov_parroquia = array[9].toString();
            } catch (Exception e) {
                prov_parroquia = null;
            }
            String prov_zona;
            try {
                prov_zona = array[10].toString();
            } catch (Exception e) {
                prov_zona = null;
            }
            String prov_direccion;
            try {
                prov_direccion = array[11].toString();
            } catch (Exception e) {
                prov_direccion = "";
            }
            String prov_telefono;
            try {
                prov_telefono = array[12].toString();
            } catch (Exception e) {
                prov_telefono = null;
            }
            String prov_celular;
            try {
                prov_celular = array[13].toString();
            } catch (Exception e) {
                prov_celular = null;
            }
            String prov_email;
            try {
                prov_email = array[14].toString();
            } catch (Exception e) {
                prov_email = null;
            }
            String prov_observaciones;
            try {
                prov_observaciones = array[15].toString();
            } catch (Exception e) {
                prov_observaciones = null;
            }

            Boolean prov_relacionado;
            try {
                prov_relacionado = Boolean.valueOf(array[16].toString());
            } catch (Exception e) {
                prov_relacionado = null;
            }
            Boolean prov_inactivo;
            try {
                prov_inactivo = Boolean.valueOf(array[17].toString());
            } catch (Exception e) {
                prov_inactivo = null;
            }
            Integer prov_secuencia;
            try {
                prov_secuencia = new Integer(array[18].toString());
            } catch (Exception e) {
                prov_secuencia = null;
            }

            String pc_codigo;
            try {
                pc_codigo = array[20].toString();
            } catch (Exception e) {
                pc_codigo = null;
            }
            String usr_codigo;
            try {
                usr_codigo = array[22].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[23].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }
            lista.add(new inventario.TO.InvProveedorTO(
                    prov_empresa,
                    prov_codigo,
                    prov_id_tipo,
                    prov_id_numero,
                    prov_nombre,
                    prov_razon_social,
                    prov_provincia,
                    prov_ciudad,
                    prov_parroquia,
                    prov_zona,
                    prov_direccion,
                    prov_telefono,
                    prov_celular,
                    prov_email,
                    prov_observaciones,
                    prov_relacionado,
                    prov_inactivo,
                    prov_secuencia,
                    pc_codigo,
                    usr_codigo,
                    usr_fecha_inserta));
        }
        return lista;
    }

    public static inventario.TO.InvProveedorTO convertirProveedor_ProveedorTO(java.util.List datos) {
        inventario.TO.InvProveedorTO invProveedorTO = null;
        if (datos.isEmpty()) {
            invProveedorTO = null;
        } else {
            for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
                Object obj = i$.next();
                Object[] array = ((java.util.List) obj).toArray();
                String prov_empresa;
                try {
                    prov_empresa = array[0].toString();
                } catch (Exception e) {
                    prov_empresa = null;
                }
                String prov_codigo;
                try {
                    prov_codigo = array[1].toString();
                } catch (Exception e) {
                    prov_codigo = null;
                }
                Character prov_id_tipo;
                try {
                    prov_id_tipo = array[3].toString().charAt(0);
                } catch (Exception e) {
                    prov_id_tipo = null;
                }
                String prov_id_numero;
                try {
                    prov_id_numero = array[4].toString();
                } catch (Exception e) {
                    prov_id_numero = null;
                }
                String prov_nombre;
                try {
                    prov_nombre = array[5].toString();
                } catch (Exception e) {
                    prov_nombre = "";
                }
                String prov_razon_social;
                try {
                    prov_razon_social = array[6].toString();
                } catch (Exception e) {
                    prov_razon_social = null;
                }
                String prov_provincia;
                try {
                    prov_provincia = array[7].toString();
                } catch (Exception e) {
                    prov_provincia = null;
                }
                String prov_ciudad;
                try {
                    prov_ciudad = array[8].toString();
                } catch (Exception e) {
                    prov_ciudad = null;
                }
                String prov_parroquia;
                try {
                    prov_parroquia = array[9].toString();
                } catch (Exception e) {
                    prov_parroquia = null;
                }
                String prov_zona;
                try {
                    prov_zona = array[10].toString();
                } catch (Exception e) {
                    prov_zona = null;
                }
                String prov_direccion;
                try {
                    prov_direccion = array[11].toString();
                } catch (Exception e) {
                    prov_direccion = "";
                }
                String prov_telefono;
                try {
                    prov_telefono = array[12].toString();
                } catch (Exception e) {
                    prov_telefono = null;
                }
                String prov_celular;
                try {
                    prov_celular = array[13].toString();
                } catch (Exception e) {
                    prov_celular = null;
                }
                String prov_email;
                try {
                    prov_email = array[14].toString();
                } catch (Exception e) {
                    prov_email = null;
                }
                String prov_observaciones;
                try {
                    prov_observaciones = array[15].toString();
                } catch (Exception e) {
                    prov_observaciones = null;
                }
                Boolean prov_relacionado;
                try {
                    prov_relacionado = Boolean.valueOf(array[16].toString());
                } catch (Exception e) {
                    prov_relacionado = null;
                }
                Boolean prov_inactivo;
                try {
                    prov_inactivo = Boolean.valueOf(array[17].toString());
                } catch (Exception e) {
                    prov_inactivo = null;
                }
                Integer prov_secuencia;
                try {
                    prov_secuencia = new Integer(array[18].toString());
                } catch (Exception e) {
                    prov_secuencia = null;
                }
                String pc_codigo;
                try {
                    pc_codigo = array[20].toString();
                } catch (Exception e) {
                    pc_codigo = null;
                }
                String usr_codigo;
                try {
                    usr_codigo = array[22].toString();
                } catch (Exception e) {
                    usr_codigo = null;
                }
                String usr_fecha_inserta;
                try {
                    usr_fecha_inserta = array[23].toString();
                } catch (Exception e) {
                    usr_fecha_inserta = null;
                }
                invProveedorTO = new inventario.TO.InvProveedorTO(
                        prov_empresa,
                        prov_codigo,
                        prov_id_tipo,
                        prov_id_numero,
                        prov_nombre,
                        prov_razon_social,
                        prov_provincia,
                        prov_ciudad,
                        prov_parroquia,
                        prov_zona,
                        prov_direccion,
                        prov_telefono,
                        prov_celular,
                        prov_email,
                        prov_observaciones,
                        prov_relacionado,
                        prov_inactivo,
                        prov_secuencia,
                        pc_codigo,
                        usr_codigo,
                        usr_fecha_inserta);
            }
        }
        return invProveedorTO;
    }

    public static java.util.List<inventario.TO.InvComboFormaPagoTO> convertirInvComboFormaPago_InvComboFormaPagoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.parseBoolean(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new inventario.TO.InvComboFormaPagoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static inventario.TO.InvCompraCabeceraTO convertirInvCompraCabecera_InvCompraCabeceraTO(java.util.List datos) {
        inventario.TO.InvCompraCabeceraTO invCompraCabeceraTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)


            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String comp_numero_alterno;
            try {
                comp_numero_alterno = array[0].toString();
            } catch (Exception e) {
                comp_numero_alterno = null;
            }
            String comp_documento_tipo;
            try {
                comp_documento_tipo = array[1].toString();
            } catch (Exception e) {
                comp_documento_tipo = null;
            }
            String comp_documento_numero;
            try {
                comp_documento_numero = array[2].toString();
            } catch (Exception e) {
                comp_documento_numero = null;
            }
            String comp_fecha;
            try {
                comp_fecha = array[3].toString();
            } catch (Exception e) {
                comp_fecha = null;
            }
            String comp_fecha_vencimiento;
            try {
                comp_fecha_vencimiento = array[4].toString();
            } catch (Exception e) {
                comp_fecha_vencimiento = null;
            }
            java.math.BigDecimal comp_iva_vigente;
            try {
                comp_iva_vigente = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                comp_iva_vigente = java.math.BigDecimal.ZERO;
            }
            String comp_observaciones;
            try {
                comp_observaciones = array[6].toString();
            } catch (Exception e) {
                comp_observaciones = null;
            }
            Boolean comp_electronica;
            try {
                comp_electronica = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                comp_electronica = null;
            }
            Boolean comp_pendiente;
            try {
                comp_pendiente = Boolean.parseBoolean(array[8].toString());
            } catch (Exception e) {
                comp_pendiente = null;
            }
            Boolean comp_revisado;
            try {
                comp_revisado = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                comp_revisado = null;
            }
            Boolean comp_anulado;
            try {
                comp_anulado = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                comp_anulado = null;
            }
            String comp_forma_pago;
            try {
                comp_forma_pago = array[11].toString();
            } catch (Exception e) {
                comp_forma_pago = null;
            }
            java.math.BigDecimal comp_base0;
            try {
                comp_base0 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                comp_base0 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_base_imponible;
            try {
                comp_base_imponible = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                comp_base_imponible = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_base_no_objeto;
            try {
                comp_base_no_objeto = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                comp_base_no_objeto = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_base_exenta;
            try {
                comp_base_exenta = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                comp_base_exenta = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_monto_iva;
            try {
                comp_monto_iva = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                comp_monto_iva = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_total;
            try {
                comp_total = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                comp_total = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_valor_retenido;
            try {
                comp_valor_retenido = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                comp_valor_retenido = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal comp_saldo;
            try {
                comp_saldo = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                comp_saldo = java.math.BigDecimal.ZERO;
            }
            String prov_codigo;
            try {
                prov_codigo = array[20].toString();
            } catch (Exception e) {
                prov_codigo = null;
            }
            String sec_codigo;
            try {
                sec_codigo = array[21].toString();
            } catch (Exception e) {
                sec_codigo = null;
            }
            String con_periodo;
            try {
                con_periodo = array[22].toString();
            } catch (Exception e) {
                con_periodo = null;
            }
            String con_tipo;
            try {
                con_tipo = array[23].toString();
            } catch (Exception e) {
                con_tipo = null;
            }
            String con_numero;
            try {
                con_numero = array[24].toString();
            } catch (Exception e) {
                con_numero = null;
            }
            String usr_codigo;
            try {
                usr_codigo = array[25].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[26].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }
            boolean comp_retencion_asumida;
            try {
                comp_retencion_asumida = Boolean.parseBoolean(array[27].toString());
            } catch (Exception e) {
                comp_retencion_asumida = false;
            }
            String comp_documento_forma_pago;
            try {
                comp_documento_forma_pago = array[28].toString();
            } catch (Exception e) {
                comp_documento_forma_pago = null;
            }
            String anu_comentario;
            try {
                anu_comentario = array[29].toString();
            } catch (Exception e) {
                anu_comentario = null;
            }
            Boolean comp_activo_fijo;
            try {
                comp_activo_fijo = Boolean.parseBoolean(array[30].toString());
            } catch (Exception e) {
                comp_activo_fijo = null;
            }
            Boolean comp_importacion;
            try {
                comp_importacion = Boolean.parseBoolean(array[31].toString());
            } catch (Exception e) {
                comp_importacion = null;
            }
            java.math.BigDecimal comp_otros_impuestos;
            try {
                comp_otros_impuestos = new java.math.BigDecimal(array[32].toString());
            } catch (Exception e) {
                comp_otros_impuestos = java.math.BigDecimal.ZERO;
            }


            if (datos.isEmpty()) {
                invCompraCabeceraTO = null;
            } else {
                invCompraCabeceraTO = new inventario.TO.InvCompraCabeceraTO();
                invCompraCabeceraTO.setCompNumeroAlterno(comp_numero_alterno);
                invCompraCabeceraTO.setCompDocumentoTipo(comp_documento_tipo);
                invCompraCabeceraTO.setCompDocumentoNumero(comp_documento_numero);
                invCompraCabeceraTO.setCompfecha(comp_fecha);
                invCompraCabeceraTO.setCompFechaVencimiento(comp_fecha_vencimiento);
                invCompraCabeceraTO.setCompIvaVigente(comp_iva_vigente);
                invCompraCabeceraTO.setCompObservaciones(comp_observaciones);
                invCompraCabeceraTO.setCompElectronica(comp_electronica);
                invCompraCabeceraTO.setCompActivoFijo(comp_activo_fijo);
                invCompraCabeceraTO.setCompImportacion(comp_importacion);
                invCompraCabeceraTO.setCompPendiente(comp_pendiente);
                invCompraCabeceraTO.setCompRevisado(comp_revisado);
                invCompraCabeceraTO.setCompAnulado(comp_anulado);
                invCompraCabeceraTO.setCompFormaPago(comp_forma_pago);
                invCompraCabeceraTO.setCompBase0(comp_base0);
                invCompraCabeceraTO.setCompBaseimponible(comp_base_imponible);
                invCompraCabeceraTO.setCompBaseExenta(comp_base_exenta);
                invCompraCabeceraTO.setCompBaseNoObjeto(comp_base_no_objeto);
                invCompraCabeceraTO.setCompMontoiva(comp_monto_iva);
                invCompraCabeceraTO.setCompOtrosImpuestos(comp_otros_impuestos);
                invCompraCabeceraTO.setCompTotal(comp_total);
                invCompraCabeceraTO.setCompValorretenido(comp_valor_retenido);
                invCompraCabeceraTO.setCompSaldo(comp_saldo);
                invCompraCabeceraTO.setProvCodigo(prov_codigo);
                invCompraCabeceraTO.setSecCodigo(sec_codigo);
                invCompraCabeceraTO.setConPeriodo(con_periodo);
                invCompraCabeceraTO.setConTipo(con_tipo);
                invCompraCabeceraTO.setConNumero(con_numero);
                invCompraCabeceraTO.setUsuarioInserto(usr_codigo);
                invCompraCabeceraTO.setFechaUsuarioInserto(usr_fecha_inserta);
                invCompraCabeceraTO.setRetencionAsumida(comp_retencion_asumida);
                invCompraCabeceraTO.setDocumentoFormaPago(comp_documento_forma_pago);
                invCompraCabeceraTO.setComentarioAnulado(anu_comentario);
            }
//            new inventario.TO.InvCompraCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18);
        }
        return invCompraCabeceraTO;
    }

    public static inventario.TO.InvVentaCabeceraTO convertirInvVentaCabecera_InvVentaCabeceraTO(java.util.List datos) {
        inventario.TO.InvVentaCabeceraTO invVentaCabeceraTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            /*
             * + ", " + ", " + ", " + "SUBSTRING(::TEXT, 1, 10)," +
             * "SUBSTRING(::TEXT, 1, 10), " + ", " + ", " + ", " + ", " + ", " +
             * ", " + ", " + ", " + ", " + ", " + ", " + ", " + ", " + ", " + ",
             * " + ", " + ", " + ", " + ", " + ", " + ", " + ", " + ", "
             *
             */
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String vta_numero_alterno;
            try {
                vta_numero_alterno = array[0].toString();
            } catch (Exception e) {
                vta_numero_alterno = null;
            }
            String vta_documento_tipo;
            try {
                vta_documento_tipo = array[1].toString();
            } catch (Exception e) {
                vta_documento_tipo = null;
            }
            String vta_documento_numero;
            try {
                vta_documento_numero = array[2].toString();
            } catch (Exception e) {
                vta_documento_numero = null;
            }
            String vta_fecha;
            try {
                vta_fecha = array[3].toString();
            } catch (Exception e) {
                vta_fecha = null;
            }
            String vta_fecha_vencimiento;
            try {
                vta_fecha_vencimiento = array[4].toString();
            } catch (Exception e) {
                vta_fecha_vencimiento = null;
            }
            java.math.BigDecimal vta_iva_vigente;
            try {
                vta_iva_vigente = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                vta_iva_vigente = java.math.BigDecimal.ZERO;
            }
            String vta_observaciones;
            try {
                vta_observaciones = array[6].toString();
            } catch (Exception e) {
                vta_observaciones = null;
            }
            String vta_informacion_adicional;
            try {
                vta_informacion_adicional = array[7].toString();
            } catch (Exception e) {
                vta_informacion_adicional = null;
            }
            Boolean vta_pendiente;
            try {
                vta_pendiente = Boolean.parseBoolean(array[8].toString());
            } catch (Exception e) {
                vta_pendiente = null;
            }
            Boolean vta_revisado;
            try {
                vta_revisado = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                vta_revisado = null;
            }
            Boolean vta_anulado;
            try {
                vta_anulado = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                vta_anulado = null;
            }
            String vta_forma_pago;
            try {
                vta_forma_pago = array[11].toString();
            } catch (Exception e) {
                vta_forma_pago = null;
            }
            java.math.BigDecimal vta_base0;
            try {
                vta_base0 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                vta_base0 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_base_imponible;
            try {
                vta_base_imponible = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                vta_base_imponible = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_montoiva;
            try {
                vta_montoiva = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                vta_montoiva = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_descuento_base0;
            try {
                vta_descuento_base0 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                vta_descuento_base0 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_descuento_base_imponible;
            try {
                vta_descuento_base_imponible = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                vta_descuento_base_imponible = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_descuento_base_no_objeto;
            try {
                vta_descuento_base_no_objeto = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                vta_descuento_base_no_objeto = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_descuento_base_exenta;
            try {
                vta_descuento_base_exenta = new java.math.BigDecimal(array[18].toString());
            } catch (Exception e) {
                vta_descuento_base_exenta = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_subtotal_base0;
            try {
                vta_subtotal_base0 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                vta_subtotal_base0 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_subtotal_base_imponible;
            try {
                vta_subtotal_base_imponible = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                vta_subtotal_base_imponible = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_subtotal_base_no_objeto;
            try {
                vta_subtotal_base_no_objeto = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                vta_subtotal_base_no_objeto = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal vta_subtotal_base_exenta;
            try {
                vta_subtotal_base_exenta = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                vta_subtotal_base_exenta = java.math.BigDecimal.ZERO;
            }
            String cli_codigo;
            try {
                cli_codigo = array[23].toString();
            } catch (Exception e) {
                cli_codigo = null;
            }
            String sec_codigo;
            try {
                sec_codigo = array[24].toString();
            } catch (Exception e) {
                sec_codigo = null;
            }
            String con_periodo;
            try {
                con_periodo = array[25].toString();
            } catch (Exception e) {
                con_periodo = null;
            }
            String con_tipo;
            try {
                con_tipo = array[26].toString();
            } catch (Exception e) {
                con_tipo = null;
            }
            String con_numero;
            try {
                con_numero = array[27].toString();
            } catch (Exception e) {
                con_numero = null;
            }

            String usr_codigo;
            try {
                usr_codigo = array[28].toString();
            } catch (Exception e) {
                usr_codigo = null;
            }
            String usr_fecha_inserta;
            try {
                usr_fecha_inserta = array[29].toString();
            } catch (Exception e) {
                usr_fecha_inserta = null;
            }
            String com_documento_tipo;
            try {
                com_documento_tipo = array[30].toString();
            } catch (Exception e) {
                com_documento_tipo = null;
            }
            String com_documento_numero;
            try {
                com_documento_numero = array[31].toString();
            } catch (Exception e) {
                com_documento_numero = null;
            }

            java.math.BigDecimal vta_pagado;
            try {
                vta_pagado = new java.math.BigDecimal(array[32].toString());
            } catch (Exception e) {
                vta_pagado = java.math.BigDecimal.ZERO;
            }

            if (datos.isEmpty()) {
                invVentaCabeceraTO = null;
            } else {
                invVentaCabeceraTO = new inventario.TO.InvVentaCabeceraTO();
                invVentaCabeceraTO.setVtaNumeroAlterno(vta_numero_alterno);
                invVentaCabeceraTO.setVtaDocumentoTipo(vta_documento_tipo);
                invVentaCabeceraTO.setVtaDocumentoNumero(vta_documento_numero);
                invVentaCabeceraTO.setVtaFecha(vta_fecha);
                invVentaCabeceraTO.setVtaFechaVencimiento(vta_fecha_vencimiento);
                invVentaCabeceraTO.setVtaIvaVigente(vta_iva_vigente);
                invVentaCabeceraTO.setVtaObservaciones(vta_observaciones);
                invVentaCabeceraTO.setVtaInformacionAdicional(vta_informacion_adicional);
                invVentaCabeceraTO.setVtaPendiente(vta_pendiente);
                invVentaCabeceraTO.setVtaRevisado(vta_revisado);
                invVentaCabeceraTO.setVtaAnulado(vta_anulado);
                invVentaCabeceraTO.setVtaFormaPago(vta_forma_pago);
                invVentaCabeceraTO.setVtaBase0(vta_base0);
                invVentaCabeceraTO.setVtaBaseImponible(vta_base_imponible);
                invVentaCabeceraTO.setVtaMontoiva(vta_montoiva);
                invVentaCabeceraTO.setVtaDescuentoBase0(vta_descuento_base0);
                invVentaCabeceraTO.setVtaDescuentoBaseImponible(vta_descuento_base_imponible);
                invVentaCabeceraTO.setVtaDescuentoBaseNoObjeto(vta_descuento_base_no_objeto);
                invVentaCabeceraTO.setVtaDescuentoBaseExenta(vta_descuento_base_exenta);
                invVentaCabeceraTO.setVtaSubtotalBase0(vta_subtotal_base0);
                invVentaCabeceraTO.setVtaSubtotalBaseImponible(vta_subtotal_base_imponible);
                invVentaCabeceraTO.setVtaSubtotalBaseNoObjeto(vta_subtotal_base_no_objeto);
                invVentaCabeceraTO.setVtaTotal(vta_subtotal_base_exenta);
                invVentaCabeceraTO.setCliCodigo(cli_codigo);
                invVentaCabeceraTO.setSecCodigo(sec_codigo);
                invVentaCabeceraTO.setConPeriodo(con_periodo);
                invVentaCabeceraTO.setConTipo(con_tipo);
                invVentaCabeceraTO.setConNumero(con_numero);
                invVentaCabeceraTO.setUsuarioInserto(usr_codigo);
                invVentaCabeceraTO.setFechaUsuarioInserto(usr_fecha_inserta);
                invVentaCabeceraTO.setComDocumentoTipo(com_documento_tipo);
                invVentaCabeceraTO.setComDocumentoNumero(com_documento_numero);
                invVentaCabeceraTO.setVtaPagado(vta_pagado);
            }
        }
        return invVentaCabeceraTO;
    }
    /*
     * public static inventario.entity.InvVentas convertirInvVentas_InvVentas
     * (inventario.entity.InvVentas invVentas){ inventario.entity.InvVentas
     * invVentasAux = new inventario.entity.InvVentas(); return invVentasAux; }
     */

    public static inventario.TO.InvConsultaVentasFacturasPorNumeroTO convertirIInvConsultaVentasFacturasPorNumero_InvConsultaVentasFacturasPorNumeroTO(java.util.List datos) {
        inventario.TO.InvConsultaVentasFacturasPorNumeroTO consultaVentasFacturasPorNumeroTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            if (datos.isEmpty()) {

                consultaVentasFacturasPorNumeroTO = null;
            } else {
                //String empresa, String perCodigo, String motCodigo, String compNumero
                consultaVentasFacturasPorNumeroTO = new inventario.TO.InvConsultaVentasFacturasPorNumeroTO();
                consultaVentasFacturasPorNumeroTO.setVtaEmpresa(dato1);
                consultaVentasFacturasPorNumeroTO.setVtaPeriodo(dato2);
                consultaVentasFacturasPorNumeroTO.setVtaMotivo(dato3);
                consultaVentasFacturasPorNumeroTO.setVtaNumero(dato4);


            }
        }
        return consultaVentasFacturasPorNumeroTO;
    }

    public static inventario.TO.InvProformaCabeceraTO convertirInvProformaCabecera_InvProformaCabeceraTO(java.util.List datos) {
        inventario.TO.InvProformaCabeceraTO invProformaCabeceraTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {//fecha
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            java.math.BigDecimal dato2;
            try {//iva vigente
                dato2 = new java.math.BigDecimal(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {//observaciones
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            Boolean dato4;
            try {//pendiente
                dato4 = Boolean.parseBoolean(array[3].toString());;
            } catch (Exception e) {
                dato4 = null;
            }
            Boolean dato5;
            try {//anulado
                dato5 = Boolean.parseBoolean(array[4].toString());;
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {//base0
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato7;
            try {//base imponible
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {//descuento base0
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {//descuento base imponible
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {//descuento general base 0
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            java.math.BigDecimal dato11;
            try {//descuento general base imponible
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            java.math.BigDecimal dato12;
            try {//descuento iva
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato13;
            try {//subtotal base 0
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato14;
            try {//sub total base imponible
                dato14 = new java.math.BigDecimal(array[13].toString());
            } catch (Exception e) {
                dato14 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato15;
            try {//monto iva
                dato15 = new java.math.BigDecimal(array[14].toString());
            } catch (Exception e) {
                dato15 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato16;
            try {//total
                dato16 = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                dato16 = java.math.BigDecimal.ZERO;
            }
            String dato17;
            try {//cli empresa
                dato17 = array[16].toString();
            } catch (Exception e) {
                dato17 = null;
            }
            String dato18;
            try {//cli codigo
                dato18 = array[17].toString();
            } catch (Exception e) {
                dato18 = null;
            }
            String dato19;
            try {//usr  empresa
                dato19 = array[18].toString();
            } catch (Exception e) {
                dato19 = null;
            }
            String dato20;
            try {//usr codigo
                dato20 = array[19].toString();
            } catch (Exception e) {
                dato20 = null;
            }
            String dato21;
            try {//fecha
                dato21 = array[20].toString();
            } catch (Exception e) {
                dato21 = null;
            }
            if (datos.isEmpty()) {
                invProformaCabeceraTO = null;
            } else {
                invProformaCabeceraTO = new inventario.TO.InvProformaCabeceraTO();
                invProformaCabeceraTO.setProfFecha(dato1);
                invProformaCabeceraTO.setProfIvaVigente(dato2);
                invProformaCabeceraTO.setProfObservaciones(dato3);
                invProformaCabeceraTO.setProfPendiente(dato4);
                invProformaCabeceraTO.setProfAnulado(dato5);
                invProformaCabeceraTO.setProfBase0(dato6);
                invProformaCabeceraTO.setProfBaseimponible(dato7);
                invProformaCabeceraTO.setProfDescuentoBase0(dato8);
                invProformaCabeceraTO.setProfBaseimponible(dato9);
                invProformaCabeceraTO.setProfDescuentoGeneralBase0(dato10);
                invProformaCabeceraTO.setProfDescuentoGeneralBaseImponible(dato11);
                invProformaCabeceraTO.setProfDescuentoIva(dato12);
                invProformaCabeceraTO.setProfSubtotalBase0(dato13);
                invProformaCabeceraTO.setProfSubtotalBaseImponible(dato14);
                invProformaCabeceraTO.setProfMontoiva(dato15);
                invProformaCabeceraTO.setProfTotal(dato16);
                invProformaCabeceraTO.setCliEmpresa(dato17);
                invProformaCabeceraTO.setCliCodigo(dato18);
                invProformaCabeceraTO.setUserEmpresa(dato19);
                invProformaCabeceraTO.setUsuarioInserto(dato20);
                invProformaCabeceraTO.setFechaUsuarioInserto(dato21);
            }
//            new inventario.TO.InvCompraCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18);
        }
        return invProformaCabeceraTO;
    }

    public static java.util.List<inventario.TO.InvListaDetalleComprasTO> convertirInvListaDetalle_InvListaDetalleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            /*
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             *
             */
            Integer cd_secuencial;
            try {
                cd_secuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                cd_secuencial = null;
            }
            String cd_bodega_codigo;
            try {
                cd_bodega_codigo = array[1].toString();
            } catch (Exception e) {
                cd_bodega_codigo = null;
            }
            Boolean cd_pendiente;
            try {
                cd_pendiente = Boolean.parseBoolean(array[2].toString());
            } catch (Exception e) {
                cd_pendiente = null;
            }
            String cd_producto_codigo;
            try {
                cd_producto_codigo = array[3].toString();
            } catch (Exception e) {
                cd_producto_codigo = null;
            }
            String cd_producto_nombre;
            try {
                cd_producto_nombre = array[4].toString();
            } catch (Exception e) {
                cd_producto_nombre = null;
            }
            java.math.BigDecimal cd_cantidad;
            try {
                cd_cantidad = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                cd_cantidad = java.math.BigDecimal.ZERO;
            }
            String cd_medida;
            try {
                cd_medida = array[6].toString();
            } catch (Exception e) {
                cd_medida = null;
            }
            java.math.BigDecimal cd_precio;
            try {
                cd_precio = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                cd_precio = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal cd_parcial;
            try {
                cd_parcial = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                cd_parcial = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal cd_descuebto_procentaje;
            try {
                cd_descuebto_procentaje = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                cd_descuebto_procentaje = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal cd_descuento_valor;
            try {
                cd_descuento_valor = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                cd_descuento_valor = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal cd_subtotal;
            try {
                cd_subtotal = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                cd_subtotal = java.math.BigDecimal.ZERO;
            }
            String cd_sector;
            try {
                cd_sector = array[12].toString();
            } catch (Exception e) {
                cd_sector = null;
            }
            String cd_piscina;
            try {
                cd_piscina = array[13].toString();
            } catch (Exception e) {
                cd_piscina = null;
            }
            String cd_iva;
            try {
                cd_iva = array[14].toString();
            } catch (Exception e) {
                cd_iva = null;
            }
            java.math.BigDecimal cd_valor_ultima_compra;
            try {
                cd_valor_ultima_compra = new java.math.BigDecimal(array[15].toString());
            } catch (Exception e) {
                cd_valor_ultima_compra = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_cantidad_caja;
            try {
                lvd_cantidad_caja = new java.math.BigDecimal(array[16].toString());
            } catch (Exception e) {
                lvd_cantidad_caja = java.math.BigDecimal.ZERO;
            }
            String lvd_empaque;
            try {
                lvd_empaque = array[17].toString();
            } catch (Exception e) {
                lvd_empaque = null;
            }
            String lvd_presentacion_unidad;
            try {
                lvd_presentacion_unidad = array[18].toString();
            } catch (Exception e) {
                lvd_presentacion_unidad = null;
            }
            String lvd_presentacion_Caja;
            try {
                lvd_presentacion_Caja = array[19].toString();
            } catch (Exception e) {
                lvd_presentacion_Caja = null;
            }

            lista.add(new inventario.TO.InvListaDetalleComprasTO(
                    cd_secuencial,
                    cd_bodega_codigo,
                    cd_pendiente,
                    cd_producto_codigo,
                    cd_producto_nombre,
                    cd_cantidad,
                    cd_medida,
                    cd_precio,
                    cd_parcial,
                    cd_descuebto_procentaje,
                    cd_descuento_valor,
                    cd_subtotal,
                    cd_sector,
                    cd_piscina,
                    cd_iva,
                    cd_valor_ultima_compra,
                    lvd_cantidad_caja,
                    lvd_empaque,
                    lvd_presentacion_unidad,
                    lvd_presentacion_Caja));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaDetalleVentasTO> convertirInvListaVentasDetalle_InvListaVentasDetalleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            Integer lvd_secuencial;
            try {
                lvd_secuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                lvd_secuencial = null;
            }
            String lvd_bodega;
            try {
                lvd_bodega = array[1].toString();
            } catch (Exception e) {
                lvd_bodega = null;
            }
            Boolean lvd_pendiente;
            try {
                lvd_pendiente = Boolean.parseBoolean(array[2].toString());
            } catch (Exception e) {
                lvd_pendiente = null;
            }
            String lvd_producto_codigo;
            try {
                lvd_producto_codigo = array[3].toString();
            } catch (Exception e) {
                lvd_producto_codigo = null;
            }
            String lvd_producto_nombre;
            try {
                lvd_producto_nombre = array[4].toString();
            } catch (Exception e) {
                lvd_producto_nombre = null;
            }
            java.math.BigDecimal lvd_cantidad;
            try {
                lvd_cantidad = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                lvd_cantidad = java.math.BigDecimal.ZERO;
            }
            String lvd_medida;
            try {
                lvd_medida = array[6].toString();
            } catch (Exception e) {
                lvd_medida = null;
            }
            java.math.BigDecimal lvd_precio;
            try {
                lvd_precio = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                lvd_precio = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_parcial;
            try {
                lvd_parcial = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                lvd_parcial = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_recargo_porcentaje;
            try {
                lvd_recargo_porcentaje = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                lvd_recargo_porcentaje = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_descuento_porcentaje;
            try {
                lvd_descuento_porcentaje = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                lvd_descuento_porcentaje = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_iva_cobrado;
            try {
                lvd_iva_cobrado = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                lvd_iva_cobrado = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lvd_total;
            try {
                lvd_total = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                lvd_total = java.math.BigDecimal.ZERO;
            }
            String lvd_sector;
            try {
                lvd_sector = array[13].toString();
            } catch (Exception e) {
                lvd_sector = null;
            }
            String lvd_piscina;
            try {
                lvd_piscina = array[14].toString();
            } catch (Exception e) {
                lvd_piscina = null;
            }
            String lvd_graba_iva;
            try {
                lvd_graba_iva = array[15].toString();
            } catch (Exception e) {
                lvd_graba_iva = null;
            }
            Boolean lvd_modificar_precio;
            try {
                lvd_modificar_precio = Boolean.parseBoolean(array[16].toString());
            } catch (Exception e) {
                lvd_modificar_precio = null;
            }
            java.math.BigDecimal lvd_cantidad_caja;
            try {
                lvd_cantidad_caja = new java.math.BigDecimal(array[17].toString());
            } catch (Exception e) {
                lvd_cantidad_caja = java.math.BigDecimal.ZERO;
            }
            String lvd_empaque;
            try {
                lvd_empaque = array[18].toString();
            } catch (Exception e) {
                lvd_empaque = null;
            }
            String lvd_presentacion_unidad;
            try {
                lvd_presentacion_unidad = array[19].toString();
            } catch (Exception e) {
                lvd_presentacion_unidad = null;
            }
            String lvd_presentacion_caja;
            try {
                lvd_presentacion_caja = array[20].toString();
            } catch (Exception e) {
                lvd_presentacion_caja = null;
            }
            String lvd_producto_tipo;
            try {
                lvd_producto_tipo = array[21].toString();
            } catch (Exception e) {
                lvd_producto_tipo = null;
            }
            lista.add(new inventario.TO.InvListaDetalleVentasTO(
                    lvd_secuencial,
                    lvd_bodega,
                    lvd_pendiente,
                    lvd_producto_codigo,
                    lvd_producto_nombre,
                    lvd_cantidad,
                    lvd_medida,
                    lvd_precio,
                    lvd_parcial,
                    lvd_recargo_porcentaje,
                    lvd_descuento_porcentaje,
                    lvd_iva_cobrado,
                    lvd_total,
                    lvd_sector,
                    lvd_piscina,
                    lvd_graba_iva,
                    lvd_modificar_precio,
                    lvd_cantidad_caja,
                    lvd_empaque,
                    lvd_presentacion_unidad,
                    lvd_presentacion_caja,
                    lvd_producto_tipo));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaDetalleProformasTO> convertirInvListaProformasDetalle_InvListaProformasDetalleTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer lpdSecuencial;
            try {
                lpdSecuencial = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                lpdSecuencial = null;
            }
            String lpdProductoCodigo;
            try {
                lpdProductoCodigo = array[1].toString();
            } catch (Exception e) {
                lpdProductoCodigo = null;
            }
            String lpdProductoNombre;
            try {
                lpdProductoNombre = array[2].toString();
            } catch (Exception e) {
                lpdProductoNombre = null;
            }
            java.math.BigDecimal lpdCantidad;
            try {
                lpdCantidad = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                lpdCantidad = java.math.BigDecimal.ZERO;
            }
            String lpdMedida;
            try {
                lpdMedida = array[4].toString();
            } catch (Exception e) {
                lpdMedida = null;
            }
            java.math.BigDecimal lpdPrecio;
            try {
                lpdPrecio = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                lpdPrecio = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lpdParcial;
            try {
                lpdParcial = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                lpdParcial = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lpdDescuentoPorcentaje;
            try {
                lpdDescuentoPorcentaje = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                lpdDescuentoPorcentaje = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lpdDescuentoValor;
            try {
                lpdDescuentoValor = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                lpdDescuentoValor = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal lpdSubtotal;
            try {
                lpdSubtotal = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                lpdSubtotal = java.math.BigDecimal.ZERO;
            }
            Boolean lpdIva;
            try {
                lpdIva = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                lpdIva = null;
            }

            Boolean lpdModificarPrecio;
            try {
                lpdModificarPrecio = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                lpdModificarPrecio = null;
            }

            java.math.BigDecimal lpdCantidadCaja;
            try {
                lpdCantidadCaja = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                lpdCantidadCaja = java.math.BigDecimal.ZERO;
            }

            String lvdEmpaque;
            try {
                lvdEmpaque = array[13].toString();
            } catch (Exception e) {
                lvdEmpaque = null;
            }

            String lvdLvdPresentacionUnidad;
            try {
                lvdLvdPresentacionUnidad = array[14].toString();
            } catch (Exception e) {
                lvdLvdPresentacionUnidad = null;
            }
            String lvdPresentacionCaja;
            try {
                lvdPresentacionCaja = array[15].toString();
            } catch (Exception e) {
                lvdPresentacionCaja = null;
            }
            String lvdProductoTipo;
            try {
                lvdProductoTipo = array[16].toString();
            } catch (Exception e) {
                lvdProductoTipo = null;
            }

            lista.add(new inventario.TO.InvListaDetalleProformasTO(
                    lpdSecuencial,
                    lpdProductoCodigo,
                    lpdProductoNombre,
                    lpdCantidad,
                    lpdMedida,
                    lpdPrecio,
                    lpdParcial,
                    lpdDescuentoPorcentaje,
                    lpdDescuentoValor,
                    lpdSubtotal,
                    lpdIva,
                    lpdModificarPrecio,
                    lpdCantidadCaja,
                    lvdEmpaque,
                    lvdLvdPresentacionUnidad,
                    lvdPresentacionCaja,
                    lvdProductoTipo));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaDetalleConsumoTO> convertirInvListaDetalleConsumo_InvListaDetalleConsumoTO(java.util.List datos) {
        /*
         * java.util.List lista = new java.util.ArrayList(1);//interface que
         * extiende de array list, recibe parametros de dimencion for
         * (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase
         * iteracion(no todo se puede iterar, solo listas) Object obj =
         * i$.next(); Object[] array = ((java.util.List) obj).toArray(); Integer
         * dato1; try { dato1 = Integer.parseInt(array[0].toString()); } catch
         * (Exception e) { dato1 = null; } String dato2; try { dato2 =
         * array[1].toString(); } catch (Exception e) { dato2 = null; } String
         * dato3; try { dato3 = array[2].toString(); } catch (Exception e) {
         * dato3 = null; } String dato4; try { dato4 = array[3].toString(); }
         * catch (Exception e) { dato4 = null; } java.math.BigDecimal dato5; try
         * { dato5 = new java.math.BigDecimal(array[4].toString()); } catch
         * (Exception e) { dato5 = new java.math.BigDecimal("0.00"); } String
         * dato6; try { dato6 = array[5].toString(); } catch (Exception e) {
         * dato6 = null; } String dato7; try { dato7 = array[6].toString(); }
         * catch (Exception e) { dato7 = null; } String dato8; try { dato8 =
         * array[7].toString(); } catch (Exception e) { dato8 = null; } String
         * dato9; try { dato9 = array[8].toString(); } catch (Exception e) {
         * dato9 = null; } java.math.BigDecimal dato10; try { dato10 = new
         * java.math.BigDecimal(array[9].toString()); } catch (Exception e) {
         * dato10 = new java.math.BigDecimal("0.00"); } java.math.BigDecimal
         * cantidad2; if(!dato5.equals(java.math.BigDecimal.ZERO) &&
         * !dato10.equals(java.math.BigDecimal.ONE)){ cantidad2 =
         * dato5.divide(dato10.setScale(2, BigDecimal.ROUND_HALF_DOWN),0,
         * BigDecimal.ROUND_DOWN); dato5 =
         * dato5.subtract(cantidad2.multiply(dato10)); }else{ cantidad2 = new
         * java.math.BigDecimal("0.00"); } lista.add(new
         * inventario.TO.InvListaDetalleConsumoTO(dato1, dato2, dato3, dato4,
         * dato5, dato6, dato7, dato8,cantidad2,dato9, dato10)); } return lista;
         */
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = new java.math.BigDecimal("0.00");
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new inventario.TO.InvListaDetalleConsumoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static List<inventario.TO.InvListaConsultaCompraTO> convertirInvListaConsultaCompra_InvListaConsultaCompraTO(java.util.List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((List) obj).toArray();
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            String dato5 = obtenerDatoString(array[4]);
            BigDecimal dato6 = new BigDecimal(obtenerDatoString(array[5]));
            BigDecimal dato7 = new BigDecimal(obtenerDatoString(array[6]));
            BigDecimal dato8 = new BigDecimal(obtenerDatoString(array[7]));
            BigDecimal dato9 = new BigDecimal(obtenerDatoString(array[8]));
            String dato10 = obtenerDatoString(array[9]);
            String dato11 = obtenerDatoString(array[10]);
            String dato12 = obtenerDatoString(array[11]);
            String dato13 = obtenerDatoString(array[12]);
            lista.add(new inventario.TO.InvListaConsultaCompraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13));
        }
        return lista;
    }

    private static String obtenerDatoString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<InvListaConsultaVentaTO> convertirInvListaConsultaVenta_InvListaConsultaVentaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((List) obj).toArray();
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            String dato5 = obtenerDatoString(array[4]);
            BigDecimal dato6 = new BigDecimal(obtenerDatoString(array[5]));
            BigDecimal dato7 = new BigDecimal(obtenerDatoString(array[6]));
            BigDecimal dato8 = new BigDecimal(obtenerDatoString(array[7]));
            BigDecimal dato9 = new BigDecimal(obtenerDatoString(array[8]));
            String dato10 = obtenerDatoString(array[9]);
            String dato11 = obtenerDatoString(array[10]);;
            String dato12 = obtenerDatoString(array[11]);
            String dato13 = obtenerDatoString(array[12]);
            lista.add(new InvListaConsultaVentaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaConsultaProformaTO> convertirInvListaConsultaVProforma_InvListaConsultaProformaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = "";
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = java.math.BigDecimal.ZERO;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = java.math.BigDecimal.ZERO;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            lista.add(new inventario.TO.InvListaConsultaProformaTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13));
        }
        return lista;
    }

    public static List<inventario.TO.InvListaConsultaConsumosTO> convertirInvListaConsultaConsumos_InvListaConsultaConsumosTO(java.util.List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((List) obj).toArray();
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            lista.add(new inventario.TO.InvListaConsultaConsumosTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvConsumosImportarExportarTO> convertirListaInvConsumosImportarExportar_ListaInvConsumosImportarExportarTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            Boolean dato8;
            try {
                dato8 = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            Boolean dato9;
            try {
                dato9 = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            Boolean dato10;
            try {
                dato10 = Boolean.valueOf(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            String dato15;
            try {
                dato15 = array[14].toString();
            } catch (Exception e) {
                dato15 = null;
            }
            String dato16;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            String dato17;
            try {
                dato17 = array[16].toString();
            } catch (Exception e) {
                dato17 = null;
            }

            Integer dato18;
            try {
                dato18 = new Integer(array[17].toString());
            } catch (Exception e) {
                dato18 = null;
            }
            Integer dato19;
            try {
                dato19 = new Integer(array[18].toString());
            } catch (Exception e) {
                dato19 = null;
            }
            java.math.BigDecimal dato20;
            try {
                dato20 = new java.math.BigDecimal(array[19].toString());
            } catch (Exception e) {
                dato20 = null;
            }
            java.math.BigDecimal dato21;
            try {
                dato21 = new java.math.BigDecimal(array[20].toString());
            } catch (Exception e) {
                dato21 = null;
            }
            java.math.BigDecimal dato22;
            try {
                dato22 = new java.math.BigDecimal(array[21].toString());
            } catch (Exception e) {
                dato22 = null;
            }
            java.math.BigDecimal dato23;
            try {
                dato23 = new java.math.BigDecimal(array[22].toString());
            } catch (Exception e) {
                dato23 = null;
            }
            String dato24;
            try {
                dato24 = array[23].toString();
            } catch (Exception e) {
                dato24 = null;
            }
            String dato25;
            try {
                dato25 = array[24].toString();
            } catch (Exception e) {
                dato25 = null;
            }
            String dato26;
            try {
                dato26 = array[25].toString();
            } catch (Exception e) {
                dato26 = null;
            }
            String dato27;
            try {
                dato27 = array[26].toString();
            } catch (Exception e) {
                dato27 = null;
            }
            String dato28;
            try {
                dato28 = array[27].toString();
            } catch (Exception e) {
                dato28 = null;
            }
            String dato29;
            try {
                dato29 = array[28].toString();
            } catch (Exception e) {
                dato29 = null;
            }
            String dato30;
            try {
                dato30 = array[29].toString();
            } catch (Exception e) {
                dato30 = null;
            }
            String dato31;
            try {
                dato31 = array[30].toString();
            } catch (Exception e) {
                dato31 = null;
            }
            String dato32;
            try {
                dato32 = array[31].toString();
            } catch (Exception e) {
                dato32 = null;
            }


            lista.add(new inventario.TO.InvConsumosImportarExportarTO(dato1,
                    dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9,
                    dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17,
                    dato18, dato19, dato20, dato21, dato22, dato23, dato24, dato25,
                    dato26, dato27, dato28, dato29, dato30, dato31, dato32));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvConsumosMotivoComboTO> convertirListaConsumosMotivoCombo_ListaConsumosMotivoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            lista.add(new inventario.TO.InvConsumosMotivoComboTO(dato1, dato2));
        }
        return lista;
    }

    public static inventario.entity.InvConsumos convertirInvConsumosTO_InvConsumos(inventario.TO.InvConsumosTO invConsumosTO) {
        inventario.entity.InvConsumos invConsumos = new inventario.entity.InvConsumos();
        invConsumos.setInvConsumosPK(new inventario.entity.InvConsumosPK(invConsumosTO.getConsEmpresa(), invConsumosTO.getConsPeriodo(),
                invConsumosTO.getConsMotivo(), invConsumosTO.getConsNumero()));
        invConsumos.setConsReferencia(invConsumosTO.getConsReferencia());
//        invCompras.setCompFecha(validaciones.Validacion.fecha(invComprasTO.getCompFecha()));
        invConsumos.setConsFecha(validaciones.Validacion.fecha(invConsumosTO.getConsFecha(), "yyyy-MM-dd"));
        invConsumos.setConsObservaciones(invConsumosTO.getConsObservaciones());
        invConsumos.setConsPendiente(invConsumosTO.getConsPendiente());
        invConsumos.setConsRevisado(invConsumosTO.getConsRevisado());
        invConsumos.setConsAnulado(invConsumosTO.getConsAnulado());
        invConsumos.setUsrEmpresa(invConsumosTO.getConsEmpresa());
        invConsumos.setUsrCodigo(invConsumosTO.getUsrCodigo());
        invConsumos.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invConsumosTO.getUsrFechaInserta()));
        return invConsumos;
    }

    public static inventario.TO.InvConsumosTO convertirInvConsumosCabecera_InvConsumosCabeceraTO(inventario.entity.InvConsumos invConsumos) {
        inventario.TO.InvConsumosTO invConsumosTO = new inventario.TO.InvConsumosTO();
        invConsumosTO.setConsEmpresa(invConsumos.getInvConsumosPK().getConsEmpresa());
        invConsumosTO.setConsPeriodo(invConsumos.getInvConsumosPK().getConsPeriodo());
        invConsumosTO.setConsMotivo(invConsumos.getInvConsumosPK().getConsMotivo());
        invConsumosTO.setConsNumero(invConsumos.getInvConsumosPK().getConsNumero());

        invConsumosTO.setConsReferencia(invConsumos.getConsReferencia());

        invConsumosTO.setConsFecha(validaciones.Validacion.fecha(invConsumos.getConsFecha(), "yyyy-MM-dd"));
        invConsumosTO.setConsObservaciones(invConsumos.getConsObservaciones());
        invConsumosTO.setConsPendiente(invConsumos.getConsPendiente());
        invConsumosTO.setConsRevisado(invConsumos.getConsRevisado());
        invConsumosTO.setConsAnulado(invConsumos.getConsAnulado());
        invConsumosTO.setUsrCodigo(invConsumos.getUsrCodigo());
        invConsumosTO.setUsrFechaInserta(validaciones.Validacion.fecha(invConsumos.getUsrFechaInserta(), "yyyy-MM-dd HH:mm:ss"));
        return invConsumosTO;
    }
    /*
     * private String cliNombre;// private String cliCedula;// private String
     * venEmpresa; private String venPeriodo; private String venMotivo; private
     * String venNumero; private Boolean vtaPendiente;// private Boolean
     * vtaRevisado;// private Boolean vtaAnulado;// //-------private Boolean
     * venContabilizado;//
     *
     * private String vtaDocumentoNumero;// private String vtaFecha;// private
     * String vtaFechaVencimiento;
     *
     * private java.math.BigDecimal venBase0;// private java.math.BigDecimal
     * venBaseImponible;// //****private java.math.BigDecimal
     * venBaseNoObjetoIva;// private java.math.BigDecimal venMontoIva;//
     * //private java.math.BigDecimal venValorRetenidoIva;// private
     * java.math.BigDecimal venValorRetenidoRenta;//
     *
     *
     *
     *
     * ************************************
     *
     * private java.math.BigDecimal vtaPagado; //---private String
     * venRetencionNumero;// //---private String venRetencionAutorizacion;//
     * //---private String venRetencionFechaEmision;//
     *
     *
     * private String usrEmpresa;// private String usrCodigo;// private String
     * usrFechaInserta;
     */

    public static inventario.TO.InvVentaRetencionesTO convertirInvVentaRetenciones_InvVentaRetencionesTO(inventario.entity.InvVentas invVentas) {
        inventario.TO.InvVentaRetencionesTO invVentaRetencionesTO = new inventario.TO.InvVentaRetencionesTO();
        invVentaRetencionesTO.setCliCodigo(invVentas.getInvCliente().getInvClientePK().getCliCodigo());
        invVentaRetencionesTO.setCliNombre(invVentas.getInvCliente().getCliNombre());
        invVentaRetencionesTO.setCliCedula(invVentas.getInvCliente().getCliIdNumero());
        invVentaRetencionesTO.setCliDireccion(invVentas.getInvCliente().getCliDireccion());
        invVentaRetencionesTO.setCliTelefono(invVentas.getInvCliente().getCliTelefono());

        invVentaRetencionesTO.setVenEmpresa(invVentas.getInvVentasPK().getVtaEmpresa());
        invVentaRetencionesTO.setVenPeriodo(invVentas.getInvVentasPK().getVtaPeriodo());
        invVentaRetencionesTO.setVenMotivo(invVentas.getInvVentasPK().getVtaMotivo());
        invVentaRetencionesTO.setVenNumero(invVentas.getInvVentasPK().getVtaNumero());
        invVentaRetencionesTO.setVtaPendiente(invVentas.getVtaPendiente());
        invVentaRetencionesTO.setVtaRevisado(invVentas.getVtaRevisado());
        invVentaRetencionesTO.setVtaAnulado(invVentas.getVtaAnulado());
        //invVentaRetencionesTO.setVenContabilizado(invVent);
        invVentaRetencionesTO.setVtaDocumentoNumero(invVentas.getVtaDocumentoNumero());
        invVentaRetencionesTO.setVtaFecha(validaciones.Validacion.fecha(invVentas.getVtaFecha(), "yyyy-MM-dd"));
        invVentaRetencionesTO.setVtaFechaVencimiento(validaciones.Validacion.fecha(invVentas.getVtaFechaVencimiento(), "yyyy-MM-dd"));
        invVentaRetencionesTO.setVenBase0(invVentas.getVtaBase0());
        invVentaRetencionesTO.setVenBaseImponible(invVentas.getVtaBaseImponible());
        
//        invVentaRetencionesTO.setVenRecargo0(invVentas.getvt);
//        invVentaRetencionesTO.setVenRecargoBaseImponible(BaseImponible(invVentas.getVtaBaseImponible());
        //invVentaRetencionesTO.setVenBaseNoObjetoIva(invVentas.getVtaBaseimponible());
        invVentaRetencionesTO.setVenMontoIva(invVentas.getVtaMontoiva());
        //invVentaRetencionesTO.setVenValorRetenidoIva(invVentas.getVtaMontoiva());
        //invVentaRetencionesTO.setVenValorRetenidoRenta(invVentas.getVtaMontoiva());








        return invVentaRetencionesTO;

    }

    public static inventario.entity.InvConsumosDetalle convertirInvConsumosDetalleTO_InvConsumosDetalle(
            inventario.TO.InvConsumosDetalleTO invConsumosDetalleTO) {
        inventario.entity.InvConsumosDetalle invConsumosDetalle = new inventario.entity.InvConsumosDetalle();
        invConsumosDetalle.setDetSecuencial(invConsumosDetalleTO.getDetSecuencial());
        invConsumosDetalle.setDetOrden(invConsumosDetalleTO.getDetOrden());
        invConsumosDetalle.setDetCantidad(invConsumosDetalleTO.getDetCantidad());

//        invConsumosDetalle.setDetValorPromedio(new java.math.BigDecimal("0.00"));
//        invConsumosDetalle.setDetValorUltimaCompra(new java.math.BigDecimal("0.00"));


//        invConsumosDetalle.setBodEmpresa(invConsumosDetalleTO.getBodEmpresa());
//        invConsumosDetalle.setBodCodigo(invConsumosDetalleTO.getBodCodigo());
        invConsumosDetalle.setSecEmpresa(invConsumosDetalleTO.getSecEmpresa());
        invConsumosDetalle.setSecCodigo(invConsumosDetalleTO.getSecCodigo());
        invConsumosDetalle.setPisEmpresa(invConsumosDetalleTO.getPisEmpresa());
        invConsumosDetalle.setPisSector(invConsumosDetalleTO.getPisSector());
        invConsumosDetalle.setPisNumero(invConsumosDetalleTO.getPisNumero());
        return invConsumosDetalle;
    }

    public static java.util.List<inventario.TO.InvMedidaComboTO> convertirListaMedida_ListaMedidaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String codigo;
            try {
                codigo = array[0].toString();
            } catch (Exception e) {
                codigo = null;
            }
            String detalle;
            try {
                detalle = array[1].toString();
            } catch (Exception e) {
                detalle = null;
            }
            String convLibras;
            try {
                convLibras = array[2].toString();
            } catch (Exception e) {
                convLibras = null;
            }

            lista.add(new inventario.TO.InvMedidaComboTO(codigo, detalle, convLibras));
        }
        return lista;
    }

    public static inventario.entity.InvConsumosMotivo convertirInvConsumosMotivoTO_InvConsumosMotivo(
            inventario.TO.InvConsumosMotivoTO invConsumosMotivoTO) {
        inventario.entity.InvConsumosMotivo invConsumosMotivo = new inventario.entity.InvConsumosMotivo();
        invConsumosMotivo.setInvConsumosMotivoPK(new inventario.entity.InvConsumosMotivoPK(
                invConsumosMotivoTO.getUsrEmpresa(),
                invConsumosMotivoTO.getCmCodigo()));
        invConsumosMotivo.setCmDetalle(invConsumosMotivoTO.getCmDetalle());
        invConsumosMotivo.setCmFormaContabilizar(invConsumosMotivoTO.getCmFormaContabilizar());
        invConsumosMotivo.setCmInactivo(invConsumosMotivoTO.getCmInactivo());
        invConsumosMotivo.setUsrEmpresa(invConsumosMotivoTO.getUsrEmpresa());
        invConsumosMotivo.setUsrCodigo(invConsumosMotivoTO.getUsrCodigo());
        invConsumosMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invConsumosMotivoTO.getUsrFechaInserta()));
        return invConsumosMotivo;
    }

    public static inventario.TO.InvConsumosMotivoTO convertirInvConsumosMotivo_InvConsumosMotivoTO(
            inventario.entity.InvConsumosMotivo invConsumosMotivo) {
        inventario.TO.InvConsumosMotivoTO invConsumosMotivoTO = new inventario.TO.InvConsumosMotivoTO();
        invConsumosMotivoTO.setUsrEmpresa(invConsumosMotivo.getInvConsumosMotivoPK().getCmEmpresa());
        invConsumosMotivoTO.setCmCodigo(invConsumosMotivo.getInvConsumosMotivoPK().getCmCodigo());
        invConsumosMotivoTO.setCmDetalle(invConsumosMotivo.getCmDetalle());
        invConsumosMotivoTO.setCmFormaContabilizar(invConsumosMotivo.getCmFormaContabilizar());
        invConsumosMotivoTO.setCmInactivo(invConsumosMotivo.getCmInactivo());
        invConsumosMotivoTO.setUsrCodigo(invConsumosMotivo.getUsrCodigo());
        invConsumosMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invConsumosMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invConsumosMotivoTO;
    }

    public static java.util.List<inventario.TO.InvListaConsumosMotivoTO> convertirInvListaConsumosMotivoTO_InvListaConsumosMotivo(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.parseBoolean(array[1].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[1].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            lista.add(new inventario.TO.InvListaConsumosMotivoTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    // <editor-fold defaultstate="collapsed" desc="COMPRASPAGOSFORMA">
    public static inventario.entity.InvComprasFormaPago convertirInvComprasFormaPagoTO_InvComprasFormaPago(inventario.TO.InvComprasFormaPagoTO invComprasFormaPagoTO) throws Exception {
        inventario.entity.InvComprasFormaPago invComprasFormaPago = new inventario.entity.InvComprasFormaPago();
        invComprasFormaPago.setFpSecuencial(invComprasFormaPagoTO.getFpSecuencial());
        invComprasFormaPago.setFpDetalle(invComprasFormaPagoTO.getFpDetalle());
        invComprasFormaPago.setFpInactivo(invComprasFormaPagoTO.getFpInactivo());
        invComprasFormaPago.setSecEmpresa(invComprasFormaPagoTO.getUsrEmpresa());
        invComprasFormaPago.setSecCodigo(invComprasFormaPagoTO.getSecCodigo());
        invComprasFormaPago.setCtaEmpresa(invComprasFormaPagoTO.getUsrEmpresa());
        invComprasFormaPago.setCtaCodigo(invComprasFormaPagoTO.getCtaCodigo());
        invComprasFormaPago.setUsrEmpresa(invComprasFormaPagoTO.getUsrEmpresa());
        invComprasFormaPago.setUsrCodigo(invComprasFormaPagoTO.getUsrCodigo());
        invComprasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invComprasFormaPagoTO.getUsrFechaInserta()));
        return invComprasFormaPago;
    }

    public static java.util.List<inventario.TO.InvListaComprasFormaPagoTO> convertirInvListaComprasFormaPago_InvListaComprasFormaPagoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer dato1;
            try {
                dato1 = Integer.valueOf(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new inventario.TO.InvListaComprasFormaPagoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTASPAGOSFORMA">
    public static inventario.entity.InvVentasFormaPago convertirInvVentasFormaPagoTO_InvVentasFormaPago(inventario.TO.InvVentasFormaPagoTO invVentasFormaPagoTO) throws Exception {
        inventario.entity.InvVentasFormaPago invVentasFormaPago = new inventario.entity.InvVentasFormaPago();
        invVentasFormaPago.setFpSecuencial(invVentasFormaPagoTO.getFpSecuencial());
        invVentasFormaPago.setFpDetalle(invVentasFormaPagoTO.getFpDetalle());
        invVentasFormaPago.setFpInactivo(invVentasFormaPagoTO.getFpInactivo());
        invVentasFormaPago.setSecEmpresa(invVentasFormaPagoTO.getUsrEmpresa());
        invVentasFormaPago.setSecCodigo(invVentasFormaPagoTO.getSecCodigo());
        invVentasFormaPago.setCtaEmpresa(invVentasFormaPagoTO.getUsrEmpresa());
        invVentasFormaPago.setCtaCodigo(invVentasFormaPagoTO.getCtaCodigo());
        invVentasFormaPago.setUsrEmpresa(invVentasFormaPagoTO.getUsrEmpresa());
        invVentasFormaPago.setUsrCodigo(invVentasFormaPagoTO.getUsrCodigo());
        invVentasFormaPago.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invVentasFormaPagoTO.getUsrFechaInserta()));
        return invVentasFormaPago;
    }

    public static java.util.List<inventario.TO.InvListaVentasFormaPagoTO> convertirInvListaVentasFormaPago_InvListaVentasFormaPagoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer dato1;
            try {
                dato1 = Integer.valueOf(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.valueOf(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new inventario.TO.InvListaVentasFormaPagoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }// </editor-fold>

    public static inventario.entity.InvComprasMotivo convertirInvComprasMotivoTO_InvComprasMotivo(inventario.TO.InvComprasMotivoTO invComprasMotivoTO) {
        inventario.entity.InvComprasMotivo invComprasMotivo = new inventario.entity.InvComprasMotivo();
        invComprasMotivo.setInvComprasMotivoPK(new inventario.entity.InvComprasMotivoPK(invComprasMotivoTO.getCmEmpresa(), invComprasMotivoTO.getCmCodigo()));
        invComprasMotivo.setCmDetalle(invComprasMotivoTO.getCmDetalle());
        invComprasMotivo.setCmFormaContabilizar(invComprasMotivoTO.getCmFormaContabilizar());
        invComprasMotivo.setCmFormaImprimir(invComprasMotivoTO.getCmFormaImprimir());
        invComprasMotivo.setCmAjustesDeInventario(invComprasMotivoTO.getCmAjustesDeInventario());
        invComprasMotivo.setCmInactivo(invComprasMotivoTO.getCmInactivo());
        invComprasMotivo.setTipEmpresa(invComprasMotivoTO.getCmEmpresa());
        invComprasMotivo.setTipCodigo(invComprasMotivoTO.getTipCodigo());
        invComprasMotivo.setUsrEmpresa(invComprasMotivoTO.getCmEmpresa());
        invComprasMotivo.setUsrCodigo(invComprasMotivoTO.getUsrCodigo());
        invComprasMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invComprasMotivoTO.getUsrFechaInserta()));
        return invComprasMotivo;
    }

    public static inventario.TO.InvComprasMotivoTO convertirInvComprasMotivo_InvComprasMotivoTO(inventario.entity.InvComprasMotivo invComprasMotivo) {
        inventario.TO.InvComprasMotivoTO invComprasMotivoTO = new inventario.TO.InvComprasMotivoTO();
        invComprasMotivoTO.setCmEmpresa(invComprasMotivo.getInvComprasMotivoPK().getCmEmpresa());
        invComprasMotivoTO.setCmCodigo(invComprasMotivo.getInvComprasMotivoPK().getCmCodigo());
        invComprasMotivoTO.setCmDetalle(invComprasMotivo.getCmDetalle());
        invComprasMotivoTO.setCmFormaContabilizar(invComprasMotivo.getCmFormaContabilizar());
        invComprasMotivoTO.setCmFormaImprimir(invComprasMotivo.getCmFormaImprimir());
        invComprasMotivoTO.setCmAjustesDeInventario(invComprasMotivo.getCmAjustesDeInventario());
        invComprasMotivoTO.setCmInactivo(invComprasMotivo.getCmInactivo());
        invComprasMotivoTO.setTipCodigo(invComprasMotivo.getTipCodigo());
        invComprasMotivoTO.setUsrCodigo(invComprasMotivo.getUsrCodigo());
        invComprasMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invComprasMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invComprasMotivoTO;
    }

    public static java.util.List<inventario.TO.InvCompraMotivoTablaTO> convertirListaInvComprasMotivo_ListaInvComprasMotivoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvCompraMotivoTablaTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static inventario.entity.InvVentasMotivo convertirInvVentasMotivoTO_InvVentasMotivo(inventario.TO.InvVentaMotivoTO invVentasMotivoTO) {
        inventario.entity.InvVentasMotivo invVentasMotivo = new inventario.entity.InvVentasMotivo();
        invVentasMotivo.setInvVentasMotivoPK(new inventario.entity.InvVentasMotivoPK(invVentasMotivoTO.getVmEmpresa(), invVentasMotivoTO.getVmCodigo()));
        invVentasMotivo.setVmDetalle(invVentasMotivoTO.getVmDetalle());
        invVentasMotivo.setVmInactivo(invVentasMotivoTO.getVmInactivo());
        invVentasMotivo.setTipEmpresa(invVentasMotivoTO.getVmEmpresa());
        invVentasMotivo.setTipCodigo(invVentasMotivoTO.getTipCodigo());
        invVentasMotivo.setVmFormaContabilizar(invVentasMotivoTO.getVmFormaContabilizar());
        invVentasMotivo.setVmFormaImprimir(invVentasMotivoTO.getVmFormaImprimir());
        invVentasMotivo.setUsrEmpresa(invVentasMotivoTO.getVmEmpresa());
        invVentasMotivo.setUsrCodigo(invVentasMotivoTO.getUsrCodigo());
        invVentasMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invVentasMotivoTO.getUsrFechaInserta()));
        return invVentasMotivo;
    }

    public static inventario.entity.InvProformasMotivo convertirInvProformasMotivoTO_InvProformasMotivo(inventario.TO.InvProformaMotivoTO invProformaMotivoTO) {
        inventario.entity.InvProformasMotivo invProformasMotivo = new inventario.entity.InvProformasMotivo();
        invProformasMotivo.setInvProformasMotivoPK(new inventario.entity.InvProformasMotivoPK(invProformaMotivoTO.getpmEmpresa(), invProformaMotivoTO.getpmCodigo()));
        invProformasMotivo.setPmDetalle(invProformaMotivoTO.getpmDetalle());
        invProformasMotivo.setPmInactivo(invProformaMotivoTO.getpmInactivo());
        invProformasMotivo.setUsrEmpresa(invProformaMotivoTO.getpmEmpresa());
        invProformasMotivo.setUsrCodigo(invProformaMotivoTO.getUsrCodigo());
        invProformasMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invProformaMotivoTO.getUsrFechaInserta()));
        return invProformasMotivo;
    }

    public static inventario.TO.InvVentaMotivoTO convertirInvVentasMotivo_InvVentasMotivoTO(inventario.entity.InvVentasMotivo invVentasMotivo) {
        inventario.TO.InvVentaMotivoTO invVentaMotivoTO = new inventario.TO.InvVentaMotivoTO();
        invVentaMotivoTO.setVmEmpresa(invVentasMotivo.getInvVentasMotivoPK().getVmEmpresa());
        invVentaMotivoTO.setVmCodigo(invVentasMotivo.getInvVentasMotivoPK().getVmCodigo());
        invVentaMotivoTO.setVmDetalle(invVentasMotivo.getVmDetalle());
        invVentaMotivoTO.setVmFormaContabilizar(invVentasMotivo.getVmFormaContabilizar());
        invVentaMotivoTO.setVmFormaImprimir(invVentasMotivo.getVmFormaImprimir());
        invVentaMotivoTO.setVmDetalle(invVentasMotivo.getVmDetalle());
        invVentaMotivoTO.setVmInactivo(invVentasMotivo.getVmInactivo());
        invVentaMotivoTO.setTipCodigo(invVentasMotivo.getTipCodigo());
        invVentaMotivoTO.setUsrCodigo(invVentasMotivo.getUsrCodigo());
        invVentaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invVentasMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invVentaMotivoTO;
    }

    public static inventario.TO.InvProformaMotivoTO convertirInvProformaMotivo_InvProformaMotivoTO(inventario.entity.InvProformasMotivo invProformasMotivo) {
        inventario.TO.InvProformaMotivoTO invProformaMotivoTO = new inventario.TO.InvProformaMotivoTO();
        invProformaMotivoTO.setpmEmpresa(invProformasMotivo.getInvProformasMotivoPK().getPmEmpresa());
        invProformaMotivoTO.setpmCodigo(invProformasMotivo.getInvProformasMotivoPK().getPmCodigo());
        invProformaMotivoTO.setpmDetalle(invProformasMotivo.getPmDetalle());
        invProformaMotivoTO.setpmInactivo(invProformasMotivo.getPmInactivo());
        invProformaMotivoTO.setUsrCodigo(invProformasMotivo.getUsrCodigo());
        invProformaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invProformasMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invProformaMotivoTO;
    }

    public static java.util.List<inventario.TO.InvVentaMotivoTablaTO> convertirListaInvVentasMotivo_ListaInvVentasMotivoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvVentaMotivoTablaTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProformaMotivoTablaTO> convertirListaInvProformaMotivo_ListaInvProformasMotivoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvProformaMotivoTablaTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvNumeracionCompraTO> convertirListaInvNumeracionCompra_ListaInvNumeracionCompraTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new inventario.TO.InvNumeracionCompraTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvNumeracionVentaTO> convertirListaInvNumeracionVenta_ListaInvNumeracionVentaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new inventario.TO.InvNumeracionVentaTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvNumeracionConsumoTO> convertirListaInvNumeracionConsumo_ListaInvNumeracionConsumoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new inventario.TO.InvNumeracionConsumoTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvComboBodegaTO> convertirInvComboBodega_InvComboBodegaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new inventario.TO.InvComboBodegaTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvKardexTO> convertirListaInvKardex_ListaInvKardexTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            java.math.BigDecimal dato3;
            try {
                dato3 = new java.math.BigDecimal(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            lista.add(new inventario.TO.InvKardexTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12,
                    dato13, dato14));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.SaldoBodegaTO> convertirListaSaldoBodega_ListaSaldoBodegaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new inventario.TO.SaldoBodegaTO(dato1, dato2, dato3, dato4,
                    dato5, dato6, dato7));
        }
        return lista;
    }

    public static inventario.TO.InvComprasRecepcionTO convertirInvComprasRecepcion_InvComprasRecepcionTO(java.util.List datos) {
        inventario.TO.InvComprasRecepcionTO invComprasRecepcionTO = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }

            if (datos.isEmpty()) {
                invComprasRecepcionTO = null;
            } else {
                invComprasRecepcionTO = new inventario.TO.InvComprasRecepcionTO();
                invComprasRecepcionTO.setRecepEmpresa(dato1);
                invComprasRecepcionTO.setRecepPeriodo(dato2);
                invComprasRecepcionTO.setRecepMotivo(dato3);
                invComprasRecepcionTO.setRecepNumero(dato4);
                invComprasRecepcionTO.setRecepFecha(dato5);
                invComprasRecepcionTO.setCompEmpresa(dato6);
                invComprasRecepcionTO.setCompPeriodo(dato7);
                invComprasRecepcionTO.setCompMotivo(dato8);
                invComprasRecepcionTO.setCompNumero(dato9);
                invComprasRecepcionTO.setUsrEmpresa(dato10);
                invComprasRecepcionTO.setUsrCodigo(dato11);
                invComprasRecepcionTO.setUsrFechaInserta(dato12);
            }
//            new inventario.TO.InvCompraCabeceraTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17, dato18);
        }
        return invComprasRecepcionTO;
    }

    public static inventario.entity.InvComprasRecepcion convertirInvComprasRecepcion_InvComprasRecepcionTO(inventario.TO.InvComprasRecepcionTO invComprasRecepcionTO) {
        inventario.entity.InvComprasRecepcion invComprasRecepcion = new inventario.entity.InvComprasRecepcion();
        invComprasRecepcion.setInvComprasRecepcionPK(new inventario.entity.InvComprasRecepcionPK(invComprasRecepcionTO.getRecepEmpresa(), invComprasRecepcionTO.getRecepPeriodo(), invComprasRecepcionTO.getRecepMotivo(), invComprasRecepcionTO.getRecepNumero()));
        invComprasRecepcion.setRecepFecha(validaciones.Validacion.fecha(invComprasRecepcionTO.getRecepFecha(), "yyyy-MM-dd"));
        invComprasRecepcion.setUsrEmpresa(invComprasRecepcionTO.getUsrEmpresa());
        invComprasRecepcion.setUsrCodigo(invComprasRecepcionTO.getUsrCodigo());
        invComprasRecepcion.setUsrFechaInserta(validaciones.Validacion.fecha(invComprasRecepcionTO.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invComprasRecepcion;
    }

    public static java.util.List<inventario.TO.InvProductosConErrorTO> convertirInvListaProductosConError_InvListaProductosConErrorTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String err_bodega;
            try {
                err_bodega = array[0].toString();
            } catch (Exception e) {
                err_bodega = null;
            }
            String err_producto_codigo;
            try {
                err_producto_codigo = array[1].toString();
            } catch (Exception e) {
                err_producto_codigo = null;
            }
            String err_producto_nombre;
            try {
                err_producto_nombre = array[2].toString();
            } catch (Exception e) {
                err_producto_nombre = null;
            }
            Integer err_cantidad;
            try {
                err_cantidad = Integer.parseInt(array[3].toString());
            } catch (Exception e) {
                err_cantidad = null;
            }
            String err_desde;
            try {
                err_desde = array[4].toString();
            } catch (Exception e) {
                err_desde = null;
            }
            String err_hasta;
            try {
                err_hasta = array[5].toString();
            } catch (Exception e) {
                err_hasta = null;
            }
            lista.add(new inventario.TO.InvProductosConErrorTO(
                    err_bodega,
                    err_producto_codigo,
                    err_producto_nombre,
                    err_cantidad,
                    err_desde,
                    err_hasta));
        }
        return lista;
    }

    public static inventario.TO.InvTransferenciasTO convertirInvTransferenciasCabecera_InvTransferenciasCabeceraTO(inventario.entity.InvTransferencias invTransferencias) {
        inventario.TO.InvTransferenciasTO invTransferenciasTO = new inventario.TO.InvTransferenciasTO();
        invTransferenciasTO.setTransEmpresa(invTransferencias.getInvTransferenciasPK().getTransEmpresa());
        invTransferenciasTO.setTransPeriodo(invTransferencias.getInvTransferenciasPK().getTransPeriodo());
        invTransferenciasTO.setTransMotivo(invTransferencias.getInvTransferenciasPK().getTransMotivo());
        invTransferenciasTO.setTransNumero(invTransferencias.getInvTransferenciasPK().getTransNumero());

        invTransferenciasTO.setTransFecha(validaciones.Validacion.fecha(invTransferencias.getTransFecha(), "yyyy-MM-dd"));
        invTransferenciasTO.setTransObservaciones(invTransferencias.getTransObservaciones());
        invTransferenciasTO.setTransPendiente(invTransferencias.getTransPendiente());
        invTransferenciasTO.setTransRevisado(invTransferencias.getTransRevisado());
        invTransferenciasTO.setTransAnulado(invTransferencias.getTransAnulado());
        invTransferenciasTO.setUsrCodigo(invTransferencias.getUsrCodigo());
        invTransferenciasTO.setUsrFechaInserta(validaciones.Validacion.fecha(invTransferencias.getUsrFechaInserta(), "yyyy-MM-dd hh:mm:ss"));
        return invTransferenciasTO;
    }

    public static java.util.List<inventario.TO.InvListaDetalleTransferenciaTO> convertirInvListaDetalleTransferencia_InvListaDetalleTransferenciaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Integer dato1;
            try {
                dato1 = Integer.parseInt(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            lista.add(new inventario.TO.InvListaDetalleTransferenciaTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13));
        }
        return lista;
    }

    public static List<InvListaConsultaTransferenciaTO> convertirInvListaConsultaTransferencia_InvListaConsultaTransferenciaTO(java.util.List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1 = obtenerDatoString(array[0]);
            String dato2 = obtenerDatoString(array[1]);
            String dato3 = obtenerDatoString(array[2]);
            String dato4 = obtenerDatoString(array[3]);
            lista.add(new InvListaConsultaTransferenciaTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvTransferenciaMotivoComboTO> convertirListaTransferenciaMotivoCombo_ListaTransferenciaMotivoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            lista.add(new inventario.TO.InvTransferenciaMotivoComboTO(dato1, dato2));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaTransferenciaMotivoTO> convertirInvListaTransferenciaMotivoTO_InvListaTransferenciaMotivo(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.parseBoolean(array[1].toString());
            } catch (Exception e) {
                dato3 = null;
            }

            lista.add(new inventario.TO.InvListaTransferenciaMotivoTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static inventario.TO.InvTransferenciaMotivoTO convertirInvTransferenciaMotivo_InvTransferenciaMotivoTO(
            inventario.entity.InvTransferenciasMotivo invTransferenciasMotivo) {
        inventario.TO.InvTransferenciaMotivoTO invTransferenciaMotivoTO = new inventario.TO.InvTransferenciaMotivoTO();
        invTransferenciaMotivoTO.setUsrEmpresa(invTransferenciasMotivo.getInvTransferenciasMotivoPK().getTmEmpresa());
        invTransferenciaMotivoTO.setTmCodigo(invTransferenciasMotivo.getInvTransferenciasMotivoPK().getTmCodigo());
        invTransferenciaMotivoTO.setTmDetalle(invTransferenciasMotivo.getTmDetalle());
        invTransferenciaMotivoTO.setTmInactivo(invTransferenciasMotivo.getTmInactivo());
        invTransferenciaMotivoTO.setUsrCodigo(invTransferenciasMotivo.getUsrCodigo());
        invTransferenciaMotivoTO.setUsrFechaInserta(validaciones.Validacion.fecha(invTransferenciasMotivo.getUsrFechaInserta(), "yyyy-MM-dd"));
        return invTransferenciaMotivoTO;
    }

    public static java.util.List<inventario.TO.InvNumeracionTransferenciaTO> convertirListaInvNumeracionTransferencia_ListaInvNumeracionTransferenciaTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new inventario.TO.InvNumeracionTransferenciaTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static inventario.entity.InvTransferencias convertirInvTransferenciasTO_InvTransferencias(inventario.TO.InvTransferenciasTO invTransferenciasTO) {
        inventario.entity.InvTransferencias invTransferencias = new inventario.entity.InvTransferencias();
        invTransferencias.setInvTransferenciasPK(new inventario.entity.InvTransferenciasPK(invTransferenciasTO.getTransEmpresa(), invTransferenciasTO.getTransPeriodo(),
                invTransferenciasTO.getTransMotivo(), invTransferenciasTO.getTransNumero()));
//        invCompras.setCompFecha(validaciones.Validacion.fecha(invComprasTO.getCompFecha()));
        invTransferencias.setTransFecha(validaciones.Validacion.fecha(invTransferenciasTO.getTransFecha(), "yyyy-MM-dd"));
        invTransferencias.setTransObservaciones(invTransferenciasTO.getTransObservaciones());
        invTransferencias.setTransPendiente(invTransferenciasTO.getTransPendiente());
        invTransferencias.setTransRevisado(invTransferenciasTO.getTransRevisado());
        invTransferencias.setTransAnulado(invTransferenciasTO.getTransAnulado());
//        invTransferencias.setConEmpresa(invTransferenciasTO.getConEmpresa());
//        invTransferencias.setConPeriodo(invTransferenciasTO.getConPeriodo());
//        invTransferencias.setConTipo(invTransferenciasTO.getConTipo());
//        invTransferencias.setConNumero(invTransferenciasTO.getConNumero());
        invTransferencias.setUsrEmpresa(invTransferenciasTO.getTransEmpresa());
        invTransferencias.setUsrCodigo(invTransferenciasTO.getUsrCodigo());
        invTransferencias.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invTransferenciasTO.getUsrFechaInserta()));
        return invTransferencias;
    }

    public static inventario.entity.InvTransferenciasDetalle convertirInvTransferenciasDetalleTO_InvTransferenciasDetalle(
            inventario.TO.InvTransferenciasDetalleTO invTransferenciasDetalleTO) {
        inventario.entity.InvTransferenciasDetalle invTransferenciasDetalle = new inventario.entity.InvTransferenciasDetalle();
        invTransferenciasDetalle.setDetSecuencial(invTransferenciasDetalleTO.getDetSecuencial());
        invTransferenciasDetalle.setDetOrden(invTransferenciasDetalleTO.getDetOrden());
        invTransferenciasDetalle.setDetCantidad(invTransferenciasDetalleTO.getDetCantidad());

//        invTransferenciasDetalle.setDetValorPromedio(new java.math.BigDecimal("0.00"));
//        invTransferenciasDetalle.setDetValorUltimaCompra(new java.math.BigDecimal("0.00"));

        invTransferenciasDetalle.setSecDestinoEmpresa(invTransferenciasDetalleTO.getSecDestinoEmpresa());
        invTransferenciasDetalle.setSecDestinoCodigo(invTransferenciasDetalleTO.getSecDestinoCodigo());
        invTransferenciasDetalle.setSecOrigenEmpresa(invTransferenciasDetalleTO.getSecOrigenEmpresa());
        invTransferenciasDetalle.setSecOrigenCodigo(invTransferenciasDetalleTO.getSecOrigenCodigo());
        return invTransferenciasDetalle;
    }

    public static inventario.entity.InvNumeracionVarios convertirInvNumeracionVarios_InvNumeracionVarios(inventario.entity.InvNumeracionVarios invNumeracionVariosAux) {
        inventario.entity.InvNumeracionVarios invNumeracionVarios = new inventario.entity.InvNumeracionVarios();
        if (invNumeracionVariosAux != null) {
            invNumeracionVarios.setNumEmpresa(invNumeracionVariosAux.getNumEmpresa());
            invNumeracionVarios.setNumClientes(invNumeracionVariosAux.getNumClientes());
            invNumeracionVarios.setNumProductos(invNumeracionVariosAux.getNumProductos());
            invNumeracionVarios.setNumProveedores(invNumeracionVariosAux.getNumProveedores());
            invNumeracionVarios.setEmpCodigo(invNumeracionVariosAux.getEmpCodigo());
        } else {
            invNumeracionVarios = null;
        }

        return invNumeracionVarios;
    }

    public static inventario.entity.InvTransferenciasMotivo convertirInvTransferenciasMotivoTO_InvTransferenciasMotivo(
            inventario.TO.InvTransferenciaMotivoTO invTransferenciaMotivoTO) {
        inventario.entity.InvTransferenciasMotivo invTransferenciasMotivo = new inventario.entity.InvTransferenciasMotivo();
        invTransferenciasMotivo.setInvTransferenciasMotivoPK(new inventario.entity.InvTransferenciasMotivoPK(
                invTransferenciaMotivoTO.getUsrEmpresa(),
                invTransferenciaMotivoTO.getTmCodigo()));
        invTransferenciasMotivo.setTmDetalle(invTransferenciaMotivoTO.getTmDetalle());
        invTransferenciasMotivo.setTmInactivo(invTransferenciaMotivoTO.getTmInactivo());
        invTransferenciasMotivo.setUsrEmpresa(invTransferenciaMotivoTO.getUsrEmpresa());
        invTransferenciasMotivo.setUsrCodigo(invTransferenciaMotivoTO.getUsrCodigo());
        invTransferenciasMotivo.setUsrFechaInserta(validaciones.Validacion.fechaString_Date(invTransferenciaMotivoTO.getUsrFechaInserta()));
        return invTransferenciasMotivo;
    }

    public static java.util.List<inventario.TO.InvListaProductosCambiarPrecioTO> convertirListaInvProductoCambiarPrecio_ListaInvProductoCambiarPrecioTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1 = array[0] == null ? null : array[0].toString();
            String dato2 = array[1] == null ? null : array[1].toString();
            String dato3 = array[2] == null ? null : array[2].toString();
            java.math.BigDecimal dato4 = array[3] == null ? null : new java.math.BigDecimal(array[3].toString());
            java.math.BigDecimal dato5 = array[4] == null ? null : new java.math.BigDecimal(array[4].toString());
            String dato6 = array[5] == null ? null : array[5].toString();
            java.math.BigDecimal dato7 = array[6] == null ? null : new java.math.BigDecimal(array[6].toString());
            java.math.BigDecimal dato8 = array[7] == null ? null : new java.math.BigDecimal(array[7].toString());
            java.math.BigDecimal dato9 = array[8] == null ? null : new java.math.BigDecimal(array[8].toString());
            java.math.BigDecimal dato10 = array[9] == null ? null : new java.math.BigDecimal(array[9].toString());
            java.math.BigDecimal dato11 = array[10] == null ? null : new java.math.BigDecimal(array[10].toString());
            java.math.BigDecimal dato12 = array[11] == null ? null : new java.math.BigDecimal(array[11].toString());
            java.math.BigDecimal dato13 = array[12] == null ? null : new java.math.BigDecimal(array[12].toString());
            java.math.BigDecimal dato14 = array[13] == null ? null : new java.math.BigDecimal(array[13].toString());
            java.math.BigDecimal dato15 = array[14] == null ? null : new java.math.BigDecimal(array[14].toString());
            java.math.BigDecimal dato16 = array[15] == null ? null : new java.math.BigDecimal(array[15].toString());
            String dato17 = array[16] == null ? null : array[16].toString();
            lista.add(new inventario.TO.InvListaProductosCambiarPrecioTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7,
                    dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListaProductosCambiarPrecioCantidadTO> convertirListaInvProductoCambiarPrecioCantidad_ListaInvProductoCambiarPrecioCantidadTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1 = array[0] == null ? null : array[0].toString();
            String dato2 = array[1] == null ? null : array[1].toString();
            String dato3 = array[2] == null ? null : array[2].toString();
            java.math.BigDecimal dato4 = array[3] == null ? null : new java.math.BigDecimal(array[3].toString());
            java.math.BigDecimal dato5 = array[4] == null ? null : new java.math.BigDecimal(array[4].toString());
            String dato6 = array[5] == null ? null : array[5].toString();
            java.math.BigDecimal dato7 = array[6] == null ? null : new java.math.BigDecimal(array[6].toString());
            java.math.BigDecimal dato8 = array[7] == null ? null : new java.math.BigDecimal(array[7] == null ? null : array[7].toString());
            java.math.BigDecimal dato9 = array[8] == null ? null : new java.math.BigDecimal(array[8] == null ? null : array[8].toString());
            java.math.BigDecimal dato10 = array[9] == null ? null : new java.math.BigDecimal(array[9] == null ? null : array[9].toString());
            java.math.BigDecimal dato11 = array[10] == null ? null : new java.math.BigDecimal(array[10] == null ? null : array[10].toString());
            java.math.BigDecimal dato12 = array[11] == null ? null : new java.math.BigDecimal(array[11] == null ? null : array[11].toString());
            java.math.BigDecimal dato13 = array[12] == null ? null : new java.math.BigDecimal(array[12] == null ? null : array[12].toString());
            java.math.BigDecimal dato14 = array[13] == null ? null : new java.math.BigDecimal(array[13] == null ? null : array[13].toString());
            java.math.BigDecimal dato15 = array[14] == null ? null : new java.math.BigDecimal(array[14] == null ? null : array[14].toString());
            java.math.BigDecimal dato16 = array[15] == null ? null : new java.math.BigDecimal(array[15] == null ? null : array[15].toString());
            String dato17 = array[16] == null ? null : array[16].toString();

            lista.add(new inventario.TO.InvListaProductosCambiarPrecioCantidadTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10, dato11, dato12, dato13, dato14, dato15, dato16, dato17));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoSincronizarTO> convertirInvProductoSincronizar_InvProductoSincronizarTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new inventario.TO.InvProductoSincronizarTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvCategoriaSincronizarTO> convertirInvCategoriaSincronizar_InvCategoriaSincronizarTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new inventario.TO.InvCategoriaSincronizarTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static inventario.entity.InvProductoSaldos convertirInvProductoSaldosConsultaStock_InvProductoSaldosStock(java.util.List datos) {
        inventario.entity.InvProductoSaldos invProductoSaldos = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            java.math.BigDecimal dato1;
            try {
                dato1 = new java.math.BigDecimal(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }

            if (datos.isEmpty()) {
                invProductoSaldos = null;
            } else {
                invProductoSaldos = new inventario.entity.InvProductoSaldos();
                invProductoSaldos.setStkSaldoFinal(dato1);
            }
        }
        return invProductoSaldos;
    }

    public static inventario.TO.InvEstadoCCCVT convertirInvEstadoCCVTConsulta_InvEstadoCCVT(java.util.List datos) {
        inventario.TO.InvEstadoCCCVT invEstadoCCVT = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            Boolean dato1;
            try {
                dato1 = Boolean.parseBoolean(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            Boolean dato2;
            try {
                dato2 = Boolean.parseBoolean(array[1].toString());
            } catch (Exception e) {
                dato2 = null;
            }
            Boolean dato3;
            try {
                dato3 = Boolean.parseBoolean(array[2].toString());
            } catch (Exception e) {
                dato3 = null;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.parseBoolean(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }

            if (datos.isEmpty()) {
                invEstadoCCVT = null;
            } else {
                invEstadoCCVT = new inventario.TO.InvEstadoCCCVT(dato1, dato2, dato3, dato4);
            }
        }
        return invEstadoCCVT;
    }

    public static java.util.List<inventario.TO.InvListadoPagosTO> convertirInvListadoPagos_InvListadoPagosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new inventario.TO.InvListadoPagosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvListadoCobrosTO> convertirInvListadoCobros_InvListadoCobrosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            lista.add(new inventario.TO.InvListadoCobrosTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunComprasTO> convertirInvFunCompras_InvFunComprasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            Boolean dato11;
            try {
                dato11 = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Boolean dato12;
            try {
                dato12 = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            lista.add(new inventario.TO.InvFunComprasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunVentasTO> convertirInvFunVentas_InvFunVentasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            Boolean dato11;
            try {
                dato11 = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            Boolean dato12;
            try {
                dato12 = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            lista.add(new inventario.TO.InvFunVentasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunComprasConsolidandoProductosTO> convertirInvFunComprasConsolidandoProductos_InvFunComprasConsolidandoProductosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new inventario.TO.InvFunComprasConsolidandoProductosTO(
                    dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunConsumosConsolidandoProductosTO> convertirInvFunConsumosConsolidandoProductos_InvFunConsumosConsolidandoProductosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new inventario.TO.InvFunConsumosConsolidandoProductosTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunVentasConsolidandoProductosTO> convertirInvFunVentasConsolidandoProductos_InvFunVentasConsolidandoProductosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new inventario.TO.InvFunVentasConsolidandoProductosTO(
                    dato1, dato2, dato3, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunVentasVsCostoTO> convertirInvFunVentasVsCosto_InvFunVentasVsCostoTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new inventario.TO.InvFunVentasVsCostoTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunListadoProductosTO> convertirInvFunListadoProductos_InvFunListadoProductosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            java.math.BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            java.math.BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            java.math.BigDecimal dato13;
            try {
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            Integer dato14;
            try {
                dato14 = new Integer(array[13].toString());
            } catch (Exception e) {
                dato14 = null;
            }
            Integer dato15;
            try {
                dato15 = new Integer(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            String dato16;
            try {
                dato16 = array[15].toString();
            } catch (Exception e) {
                dato16 = null;
            }
            String dato17;
            try {
                dato17 = array[16].toString();
            } catch (Exception e) {
                dato17 = null;
            }
            String dato18;
            try {
                dato18 = array[17].toString();
            } catch (Exception e) {
                dato18 = null;
            }
            String dato19;
            try {
                dato19 = array[18].toString();
            } catch (Exception e) {
                dato19 = null;
            }
            String dato20;
            try {
                dato20 = array[19].toString();
            } catch (Exception e) {
                dato20 = null;
            }
            String dato21;
            try {
                dato21 = array[20].toString();
            } catch (Exception e) {
                dato21 = null;
            }
            String dato22;
            try {
                dato22 = array[21].toString();
            } catch (Exception e) {
                dato22 = null;
            }
//            Boolean dato23;
            String dato23;
            try {
//                dato23 = Boolean.valueOf(array[22].toString());
                    dato23 = array[22].toString();
            } catch (Exception e) {
                dato23 = null;
            }
            Boolean dato24;
            try {
                dato24 = Boolean.valueOf(array[23].toString());
            } catch (Exception e) {
                dato24 = null;
            }
            Boolean dato25;
            try {
                dato25 = Boolean.valueOf(array[24].toString());
            } catch (Exception e) {
                dato25 = null;
            }
            Boolean dato26;
            try {
                dato26 = Boolean.valueOf(array[25].toString());
            } catch (Exception e) {
                dato26 = null;
            }
            lista.add(new inventario.TO.InvFunListadoProductosTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13, dato14, dato15,
                    dato16, dato17, dato18, dato19, dato20, dato21, dato22,
                    dato23, dato24, dato25, dato26));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunListadoClientesTO> convertirInvFunListadoClientes_InvFunListadoClientesTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            Character dato2;
            try {
                dato2 = array[1].toString().charAt(0);
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            Boolean dato15;
            try {
                dato15 = Boolean.valueOf(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            lista.add(new inventario.TO.InvFunListadoClientesTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13, dato14, dato15));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunListadoProveedoresTO> convertirInvFunListadoProveedores_InvFunListadoProveedoresTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            Character dato2;
            try {
                dato2 = array[1].toString().charAt(0);
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            String dato12;
            try {
                dato12 = array[11].toString();
            } catch (Exception e) {
                dato12 = null;
            }
            String dato13;
            try {
                dato13 = array[12].toString();
            } catch (Exception e) {
                dato13 = null;
            }
            String dato14;
            try {
                dato14 = array[13].toString();
            } catch (Exception e) {
                dato14 = null;
            }
            Boolean dato15;
            try {
                dato15 = Boolean.valueOf(array[14].toString());
            } catch (Exception e) {
                dato15 = null;
            }
            lista.add(new inventario.TO.InvFunListadoProveedoresTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11, dato12, dato13, dato14, dato15));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvSecuenciaComprobanteTO> convertirInvSecuenciaComprobante_InvSecuenciaComprobanteTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new inventario.TO.InvSecuenciaComprobanteTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvProductoTipoComboTO> convertirInvProductoTipoCombo_InvProductoTipoComboTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.parseBoolean(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new inventario.TO.InvProductoTipoComboTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static inventario.entity.InvVentasComplemento convertirInvVentasComplemento_InvVentasComplemento(java.util.List datos) {
        inventario.entity.InvVentasComplemento invVentasComplemento = null;
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[4].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[5].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            if (datos.isEmpty()) {
                invVentasComplemento = null;
            } else {
                invVentasComplemento = new inventario.entity.InvVentasComplemento();
                invVentasComplemento.setComDocumentoTipo(dato1);
                invVentasComplemento.setComDocumentoNumero(dato2);
            }
        }
        return invVentasComplemento;
    }

    public static java.util.List<inventario.TO.SaldoBodegaComprobacionTO> convertirInvFunSaldoBodegaComprobacion_InvFunSaldoBodegaComprobacionTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            java.math.BigDecimal dato4;
            try {
                dato4 = new java.math.BigDecimal(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            java.math.BigDecimal dato9;
            try {
                dato9 = new java.math.BigDecimal(array[8].toString());
            } catch (Exception e) {
                dato9 = null;
            }
            java.math.BigDecimal dato10;
            try {
                dato10 = new java.math.BigDecimal(array[9].toString());
            } catch (Exception e) {
                dato10 = null;
            }
            java.math.BigDecimal dato11;
            try {
                dato11 = new java.math.BigDecimal(array[10].toString());
            } catch (Exception e) {
                dato11 = null;
            }
            java.math.BigDecimal dato12;
            try {
                dato12 = new java.math.BigDecimal(array[11].toString());
            } catch (Exception e) {
                dato12 = null;
            }
            java.math.BigDecimal dato13;
            try {
                dato13 = new java.math.BigDecimal(array[12].toString());
            } catch (Exception e) {
                dato13 = null;
            }
            lista.add(new inventario.TO.SaldoBodegaComprobacionTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9,
                    dato10, dato11, dato12, dato13));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunConsumosTO> convertirInvFunConsumos_InvFunConsumosTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            Boolean dato5;
            try {
                dato5 = Boolean.parseBoolean(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            Boolean dato6;
            try {
                dato6 = Boolean.parseBoolean(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            lista.add(new inventario.TO.InvFunConsumosTO(
                    dato1, dato2, dato4, dato5, dato6));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvVendedorComboListadoTO> convertirInvListaVendedor_invListaVendedorTOs(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();

            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            /*
             * String dato4; try { dato4 = array[3].toString(); } catch
             * (Exception e) { dato4 = null; } String dato5; try { dato5 =
             * array[4].toString(); } catch (Exception e) { dato5 = null; }
             */
            lista.add(new inventario.TO.InvVendedorComboListadoTO(
                    dato1, dato2, dato3));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunListaProductosImpresionPlacasTO> convertirInvFunListaProductosImpresionPlacas_InvFunListaProductosImpresionPlacasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new inventario.TO.InvFunListaProductosImpresionPlacasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> convertirInvFunListaProductosSaldosGeneral_InvFunListaProductosSaldosGeneralTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion

        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;// private String lpspCodigoPrincipal;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;// private String lpspNombre;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;// private String lpspBodega;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;// private String lpspSaldo;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }

            Boolean dato5;//private Boolean lpspIva;
            try {
                dato5 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato5 = false;
            }
            lista.add(new inventario.TO.InvFunListaProductosSaldosGeneralTO(
                    dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static java.util.List<inventario.TO.InvFunUltimasComprasTO> convertirInvFunUltimasCompras_InvFunUltimasComprasTO(java.util.List datos) {
        java.util.List lista = new java.util.ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (java.util.Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            java.math.BigDecimal dato5;
            try {
                dato5 = new java.math.BigDecimal(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            java.math.BigDecimal dato6;
            try {
                dato6 = new java.math.BigDecimal(array[5].toString());
            } catch (Exception e) {
                dato6 = null;
            }
            java.math.BigDecimal dato7;
            try {
                dato7 = new java.math.BigDecimal(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            java.math.BigDecimal dato8;
            try {
                dato8 = new java.math.BigDecimal(array[7].toString());
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            String dato11;
            try {
                dato11 = array[10].toString();
            } catch (Exception e) {
                dato11 = null;
            }
            lista.add(new inventario.TO.InvFunUltimasComprasTO(
                    dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8,
                    dato9, dato10, dato11));
        }
        return lista;
    }

    public static inventario.TO.InvComprasTO convertirInvCompras_InvComprasTO(inventario.entity.InvCompras invCompras) {
        if (invCompras != null) {

            inventario.TO.InvComprasTO invComprasTO = new inventario.TO.InvComprasTO();

            invComprasTO.setEmpCodigo(invCompras.getInvComprasPK().getCompEmpresa());
            invComprasTO.setContPeriodo(invCompras.getInvComprasPK().getCompPeriodo());
            invComprasTO.setCompMotivo(invCompras.getInvComprasPK().getCompMotivo());
            invComprasTO.setCompNumero(invCompras.getInvComprasPK().getCompNumero());
            invComprasTO.setCompNumeroAlterno(invCompras.getCompNumeroAlterno());
            invComprasTO.setCompDocumentoNumero(invCompras.getCompDocumentoNumero());
            invComprasTO.setCompFecha(invCompras.getCompFecha() != null ? validaciones.Validacion.fecha(invCompras.getCompFecha(), "dd-MM-yyyy") : null);
//            invComprasTO.setCompFecha(invCompras.getCompFecha().toString());
            invComprasTO.setCompFechaVencimiento(invCompras.getCompFechaVencimiento().toString());

            invComprasTO.setCompIvaVigente(invCompras.getCompIvaVigente());
            invComprasTO.setCompObservaciones(invCompras.getCompObservaciones());
            invComprasTO.setCompElectronica(invCompras.getCompElectronica());
            invComprasTO.setCompActivoFijo(invCompras.getCompActivoFijo());
            invComprasTO.setCompPendiente(invCompras.getCompPendiente());
            invComprasTO.setCompRevisado(invCompras.getCompRevisado());
            invComprasTO.setCompAnulado(invCompras.getCompAnulado());
            invComprasTO.setCompFormaPago(invCompras.getCompFormaPago());
            invComprasTO.setCompDocumentoFormaPago(invCompras.getCompDocumentoFormaPago());

            invComprasTO.setCompBase0(invCompras.getCompBase0());
            invComprasTO.setCompBaseImponible(invCompras.getCompBaseImponible());
            invComprasTO.setCompMontoIva(invCompras.getCompMontoIva());
            invComprasTO.setCompOtrosImpuestos(invCompras.getCompOtrosImpuestos());
            invComprasTO.setCompTotal(invCompras.getCompTotal());
            invComprasTO.setCompValorRetenido(invCompras.getCompValorRetenido());
            invComprasTO.setCompRetencionAsumida(invCompras.getCompRetencionAsumida());
            invComprasTO.setCompSaldo(invCompras.getCompSaldo());
            invComprasTO.setProvCodigo(invCompras.getInvProveedor().getInvProveedorPK().getProvCodigo());
            invComprasTO.setContTipo(invCompras.getConTipo());
            invComprasTO.setContNumero(invCompras.getConNumero());

            invComprasTO.setUsrInsertaCompra(invCompras.getUsrCodigo());
            invComprasTO.setUsrFechaInsertaCompra(validaciones.Validacion.fecha(invCompras.getUsrFechaInserta(), "dd-MM-yyyy HH:mm:ss.SS"));
            invComprasTO.setCompPeriodo(invCompras.getConPeriodo());

            return invComprasTO;
        } else {
            return null;
        }


    }
}
