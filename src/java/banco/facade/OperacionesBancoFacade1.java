/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.facade;

import banco.TO.*;
import banco.reporte.ReporteConciliacionCabecera;
import contabilidad.entity.ConDetalle;
import java.util.List;
import javax.ejb.Stateless;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesBancoFacade1 implements OperacionesBancoFacadeRemote1 {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    banco.business.OperacionesBancoBusinessLocal1 operacionesBancoBusinessLocal;

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA OBETENER LISTA DE BANCOS, CAJAS Y CUENTAS">
    @Override
    public java.util.List<banco.TO.ListaBanBancoTO> getListaBanBancoTO(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getListaBanBancoTO(empresa);
    }
    
    @Override
    public java.util.List<banco.TO.ListaBanChequesNumeracionTO> getListaChequesNumeracionTO(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getListaChequesNumeracionTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.ListaBanCajaTO> getListaBanCajaTO(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getListaBanCajaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.ListaBanCuentaTO> getListaBanCuentaTO(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getListaBanCuentaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanListaChequesNoImpresosTO> getListaChequesNoImpresosTO(
            String empresa,
            String cuentaBancaria) throws Exception {
        return operacionesBancoBusinessLocal.getListaChequesNoImpresosTO(empresa, cuentaBancaria);
    }

    @Override
    public banco.TO.ConsultaDatosBancoCuentaTO getConsultaDatosBancoCuentaTO(
            String empresa,
            String cuenta) throws Exception {
        return operacionesBancoBusinessLocal.getConsultaDatosBancoCuentaTO(empresa, cuenta);
    }

    @Override
    public boolean isExisteChequeAimprimir(
            String empresa,
            String cuentaContable,
            String numeroCheque,
            Long detSecuencia) throws Exception {
        return operacionesBancoBusinessLocal.isExisteChequeAimprimir(empresa, cuentaContable, numeroCheque, detSecuencia);
    }

    public boolean isExisteCheque(
            String empresa,
            String cuentaContable,
            String numeroCheque) throws Exception {
        return operacionesBancoBusinessLocal.isExisteCheque(empresa, cuentaContable, numeroCheque);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA INSERTAR BANCOS, CAJAS Y CUENTAS">
    @Override
    public boolean insertarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarBanBancoTO(banBancoTO, sisInfoTO);
    }
    
    @Override
    public boolean insertarBanChequeNumeracionTO(
            banco.TO.BanChequesNumeracionTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarBanChequeNumeracionTO(banBancoTO, sisInfoTO);
    }

    @Override
    public boolean insertarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarBanCajaTO(banCajaTO, sisInfoTO);
    }

    @Override
    public boolean insertarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarBanCuentaTO(banCuentaTO, codigoBanco, sisInfoTO);
    }

    @Override
    public String insertarBanChequeTO(
            BanChequeTO banChequeTO,
            String usrInserta,
            String numeroCheque,
            String empresa,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarBanChequeTO(banChequeTO, usrInserta, numeroCheque, empresa, sisInfoTO);
    }

    @Override
    public String modificarFechaBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String fecha,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.modificarFechaBanChequeTO(empresa, cuenta, numero, fecha, usuario, sisInfoTO);
    }

    @Override
    public String modificarNumeroBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String numeroNuevo,
            String usuario,
            SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.modificarNumeroBanChequeTO(empresa, cuenta, numero, numeroNuevo, usuario, sisInfoTO);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA MODIFICAR BANCOS, CAJAS Y CUENTAS">

    @Override
    public boolean modificarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.modificarBanBancoTO(banBancoTO, sisInfoTO);
    }

    @Override
    public boolean modificarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.modificarBanCajaTO(banCajaTO, sisInfoTO);
    }

    @Override
    public boolean modificarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.modificarBanCuentaTO(banCuentaTO, codigoBanco, sisInfoTO);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA ELIMINAR BANCOS, CAJAS Y CUENTAS">

    @Override
    public boolean eliminarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.eliminarBanBancoTO(banBancoTO, sisInfoTO);
    }

    @Override
    public boolean eliminarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.eliminarBanCajaTO(banCajaTO, sisInfoTO);
    }

    @Override
    public boolean eliminarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.eliminarBanCuentaTO(banCuentaTO, codigoBanco, sisInfoTO);
    }
    // </editor-fold>

    @Override
    public java.lang.String getBanConciliacionFechaHasta(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.getBanConciliacionFechaHasta(empresa, cuenta);
    }

    @Override
    public java.util.List<banco.TO.BanComboBancoTO> getBanComboBancoTO(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getBanComboBancoTO(empresa);
    }

    @Override
    public java.lang.Boolean conciliacionHasta(
            java.lang.String empresa,
            java.lang.String hasta,
            String cuenta) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.conciliacionHasta(empresa, hasta, cuenta);
    }

    @Override
    public boolean conciliacionPendiente(
            java.lang.String empresa) throws Exception {
        return operacionesBancoBusinessLocal.conciliacionPendiente(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionTO> getBanListaConciliacionTO(
            java.lang.String empresa,
            java.lang.String buscar) throws Exception {
        return operacionesBancoBusinessLocal.getBanListaConciliacionTO(empresa, buscar);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaDebitoTO(
            String empresa,
            String cuenta,
            String codigo,
            String hasta) throws Exception {
        return operacionesBancoBusinessLocal.getBanListaConciliacionBancariaDebitoTO(empresa, cuenta, codigo, hasta);
    }

    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaCreditoTO(
            String empresa,
            String cuenta,
            String codigo,
            String hasta) throws Exception {
        return operacionesBancoBusinessLocal.getBanListaConciliacionBancariaCreditoTO(empresa, cuenta, codigo, hasta);
    }

    @Override
    public java.math.BigDecimal getBanValorSaldoSistema(
            String empresa,
            String cuenta,
            String hasta) throws Exception {
        return operacionesBancoBusinessLocal.getBanValorSaldoSistema(empresa, cuenta, hasta);
    }

    @Override
    public String accionBanConciliacionTO(
            banco.TO.BanConciliacionTO banConciliacionTO,
            java.util.List<banco.TO.BanChequeTO> banChequeTOs,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.accionBanConciliacionTO(banConciliacionTO, banChequeTOs, accion, sisInfoTO);
    }

    @Override
    public java.util.List<banco.TO.BanListaChequeTO> getBanListaChequeTO(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String tipo) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.getBanListaChequeTO(empresa, cuenta, desde, hasta, tipo);
    }

    @Override
    public java.util.List<banco.TO.BanComboCuentaTO> getBanComboCuentaTO(
            java.lang.String empresa) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.getBanComboCuentaTO(empresa);
    }

    @Override
    public java.util.List<banco.TO.BanFunChequesNoEntregadosTO> getBanFunChequesNoEntregadosTO(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.getBanFunChequesNoEntregadosTO(empresa, cuenta);
    }

    @Override
    public java.util.List<java.lang.String> insertarBanFunChequesNoEntregados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoEntregadosTO> banFunChequesNoEntregadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.insertarBanFunChequesNoEntregados(empresa, cuenta, banFunChequesNoEntregadosTOs, usuario, sisInfoTO);
    }

    @Override
    public java.util.List<banco.TO.BanFunChequesNoRevisadosTO> getBanFunChequesNoRevisadosTO(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.getBanFunChequesNoRevisadosTO(empresa, cuenta);
    }

    @Override
    public java.util.List<java.lang.String> insertarBanFunChequesNoRevisados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoRevisadosTO> banFunChequesNoRevisadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.insertarBanFunChequesNoRevisados(empresa, cuenta, banFunChequesNoRevisadosTOs, usuario, sisInfoTO);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cuentas Contables en BANCOS
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<String> getBanCuentasContablesBancos(
            String empresa) throws Exception {
        return operacionesBancoBusinessLocal.getBanCuentasContablesBancos(empresa);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cheques Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanChequePreavisadoTO> getBanFunChequesPreavisados(
            String empresa,
            String cuenta) throws Exception {
        return operacionesBancoBusinessLocal.getBanFunChequesPreavisados(empresa, cuenta);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return numero de registros de la tabla
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public int getConteoChequesPreavisados(
            String empresa,
            java.lang.String cuenta) throws Exception {
        return operacionesBancoBusinessLocal.getConteoChequesPreavisados(empresa, cuenta);
    }

    /**
     * @autor jack krauser Metodo para ingresar informacion con respecto a
     * archivo de preaviso
     *
     * @param banPreavisosTO objeto con la informacion de preaviso
     * @param cantidaDePreavisos numero de preavisos que se generan
     * @return Mensaje con el estado de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String insertarPreaviso(
            banco.TO.BanPreavisosTO banPreavisosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.insertarPreaviso(banPreavisosTO, sisInfoTO);
    }

    /**
     * @autor jack krauser Metodo para eliminar informacion con respecto a
     * archivo de preaviso
     *
     * @param empresa
     * @param usuario
     * @param cuenta cuenta contable
     * @return Mensaje con el estado de la transaccion
     * @throws Exception Cualquier error inesperado
     */
    public java.lang.String eliminarBanPreaviso(
            java.lang.String empresa,
            java.lang.String usuario,
            java.lang.String cuenta,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception {
        return operacionesBancoBusinessLocal.eliminarBanPreaviso(empresa, usuario, cuenta, sisInfoTO);
    }

    public String cambioDeCheque(
            String cuenta,
            String cuentaActual,
            String chequeAnterior,
            String chequeNuevo,
            String empresa,
            String usuario,
            String observaciones,
            String fecha,
            String con_tipo_cod,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesBancoBusinessLocal.cambioDeCheque(cuenta, cuentaActual, chequeAnterior, chequeNuevo, empresa, usuario, observaciones, fecha, con_tipo_cod, sisInfoTO);
    }

    @Override
    public banco.entity.BanCheque buscarBanCheque(Long secuencial) throws Exception {
        return operacionesBancoBusinessLocal.buscarBanCheque(secuencial);
    }

    @Override
    public JasperPrint generarReporteConciliacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, int estado, ReporteConciliacionCabecera conciliacionCabecera,
            List<BanListaConciliacionBancariaTO> listConciliacionCredito, List<BanListaConciliacionBancariaTO> listConciliacionDebito) throws Exception {
        return operacionesBancoBusinessLocal.generarReporteConciliacion(sisUsuarioEmpresaTO, estado, conciliacionCabecera,
                listConciliacionCredito, listConciliacionDebito);
    }

    @Override
    public JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
            List<BanListaChequeTO> listBanListaChequeTO) throws Exception {
        return operacionesBancoBusinessLocal.generarReporteListadoChequeEmisionVencimientoCobrarNumero(sisUsuarioEmpresaTO, cuenta, desde, hasta, tipo, listBanListaChequeTO);
    }

    @Override
    public JasperPrint generarReporteCheque(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            BanChequeTO banChequeTO, String valorLetra1, String valorLetra2,
            String nombreReporteCheque, ConDetalle conDetalle,
            String cuentaCodigo) throws Exception {
        return operacionesBancoBusinessLocal.generarReporteCheque(
                sisUsuarioEmpresaTO, banChequeTO, valorLetra1,
                valorLetra2, nombreReporteCheque, conDetalle, cuentaCodigo);
    }
}
