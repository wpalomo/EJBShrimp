/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.business;

import banco.TO.*;
import banco.reporte.ReporteConciliacionCabecera;
import contabilidad.entity.ConDetalle;
import java.util.List;
import javax.ejb.Local;
import net.sf.jasperreports.engine.JasperPrint;
import sistema.TO.SisInfoTO;
import sistema.TO.SisUsuarioEmpresaTO;

/**
 *
 * @author jack
 */
@Local()
public interface OperacionesBancoBusinessLocal1 {

    java.util.List<banco.TO.ListaBanBancoTO> getListaBanBancoTO(
            String empresa) throws Exception;

    java.util.List<banco.TO.ListaBanCajaTO> getListaBanCajaTO(
            String empresa) throws Exception;

    java.util.List<banco.TO.ListaBanCuentaTO> getListaBanCuentaTO(
            String empresa) throws Exception;

    java.util.List<banco.TO.BanListaChequesNoImpresosTO> getListaChequesNoImpresosTO(
            String empresa,
            String cuentaBancaria) throws Exception;

    boolean insertarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    boolean insertarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean insertarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String insertarBanChequeTO(
            BanChequeTO banChequeTO,
            String usrInserta,
            String numeroCheque,
            String empresa,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarFechaBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String fecha,
            String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String modificarNumeroBanChequeTO(
            String empresa,
            String cuenta,
            String numero,
            String numeroNuevo,
            String usuario,
            SisInfoTO sisInfoTO) throws Exception;

    boolean modificarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    boolean modificarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean eliminarBanBancoTO(
            banco.TO.BanBancoTO banBancoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    boolean eliminarBanCajaTO(
            BanCajaTO banCajaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean eliminarBanCuentaTO(
            BanCuentaTO banCuentaTO,
            String codigoBanco,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    banco.TO.ConsultaDatosBancoCuentaTO getConsultaDatosBancoCuentaTO(
            String empresa,
            String cuenta) throws Exception;

    boolean isExisteChequeAimprimir(
            String empresa,
            String cuentaContable,
            String numeroCheque,
            Long detSecuencia) throws Exception;

    public boolean isExisteCheque(
            String empresa,
            String cuentaContable,
            String numeroCheque) throws Exception;

    java.lang.String getBanConciliacionFechaHasta(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<banco.TO.BanComboBancoTO> getBanComboBancoTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.lang.Boolean conciliacionHasta(
            java.lang.String empresa,
            java.lang.String hasta,
            String cuenta) throws java.lang.Exception;

    boolean conciliacionPendiente(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionTO> getBanListaConciliacionTO(
            java.lang.String empresa,
            java.lang.String buscar) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaDebitoTO(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String codigo,
            java.lang.String hasta) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaCreditoTO(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String codigo,
            java.lang.String hasta) throws java.lang.Exception;

    java.math.BigDecimal getBanValorSaldoSistema(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String hasta) throws java.lang.Exception;

    java.lang.String accionBanConciliacionTO(
            banco.TO.BanConciliacionTO banConciliacionTO,
            java.util.List<banco.TO.BanChequeTO> banChequeTOs,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaChequeTO> getBanListaChequeTO(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.lang.String desde,
            java.lang.String hasta,
            java.lang.String tipo) throws java.lang.Exception;

    java.util.List<banco.TO.BanComboCuentaTO> getBanComboCuentaTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<banco.TO.BanFunChequesNoEntregadosTO> getBanFunChequesNoEntregadosTO(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<java.lang.String> insertarBanFunChequesNoEntregados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoEntregadosTO> banFunChequesNoEntregadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<banco.TO.BanFunChequesNoRevisadosTO> getBanFunChequesNoRevisadosTO(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<java.lang.String> insertarBanFunChequesNoRevisados(
            java.lang.String empresa,
            java.lang.String cuenta,
            java.util.List<banco.TO.BanFunChequesNoRevisadosTO> banFunChequesNoRevisadosTOs,
            java.lang.String usuario,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.util.List<java.lang.String> getBanCuentasContablesBancos(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<banco.TO.BanChequePreavisadoTO> getBanFunChequesPreavisados(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception;

    int getConteoChequesPreavisados(
            java.lang.String empresa,
            java.lang.String cuenta) throws java.lang.Exception;

    java.lang.String insertarPreaviso(
            banco.TO.BanPreavisosTO banPreavisosTO,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.String eliminarBanPreaviso(
            java.lang.String empresa,
            java.lang.String usuario,
            java.lang.String cuenta,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    String cambioDeCheque(
            String cuenta,
            String cuentaActual,
            String chequeAnterior,
            String chequeNuevo,
            String empresa,
            String usuario,
            String observaciones,
            String fecha,
            String con_tipo_cod,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    banco.entity.BanCheque buscarBanCheque(
            java.lang.Long secuencial) throws java.lang.Exception;

    JasperPrint generarReporteConciliacion(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, int estado, ReporteConciliacionCabecera conciliacionCabecera,
            List<BanListaConciliacionBancariaTO> listConciliacionCredito, List<BanListaConciliacionBancariaTO> listConciliacionDebito) throws Exception;

    JasperPrint generarReporteListadoChequeEmisionVencimientoCobrarNumero(SisUsuarioEmpresaTO sisUsuarioEmpresaTO, String cuenta, String desde, String hasta, String tipo,
            List<BanListaChequeTO> listBanListaChequeTO) throws Exception;

    JasperPrint generarReporteCheque(SisUsuarioEmpresaTO sisUsuarioEmpresaTO,
            BanChequeTO banChequeTO, String valorLetra1, String valorLetra2,
            String nombreReporteCheque, ConDetalle conDetalle, String cuentaCodigo) throws java.lang.Exception;
}
