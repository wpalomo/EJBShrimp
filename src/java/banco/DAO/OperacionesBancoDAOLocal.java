/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesBancoDAOLocal {

    java.util.List<banco.TO.ListaBanBancoTO> getListaBanBancoTO(String empresa) throws Exception;

    java.util.List<banco.TO.ListaBanChequesNumeracionTO> getListaChequesNumeracionTO(String empresa) throws Exception;

    banco.entity.BanConciliacion buscarBanConciliacion(java.lang.String concEmpresa, java.lang.String concCuentaContable, java.lang.String concCodigo) throws java.lang.Exception;

    java.util.List<banco.TO.ListaBanCajaTO> getListaBanCajaTO(String empresa) throws Exception;

    java.util.List<banco.TO.ListaBanCuentaTO> getListaBanCuentaTO(String empresa) throws Exception;

    banco.entity.BanBanco buscarBanBanco(String empresa, String codigo) throws Exception;

    banco.entity.BanChequeNumeracion buscarBanChequeNumeracion(Integer secuencial) throws Exception;

    banco.entity.BanCaja buscarBanCaja(String empresa, String codigo) throws Exception;

    banco.entity.BanCuenta buscarBanCuenta(String empresa, String codigoCuentaContable) throws Exception;

    banco.entity.BanCheque buscarBanCheque(Long secuencial) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaChequesNoImpresosTO> getListaChequesNoImpresosTO(String empresa, String cuentaBancaria) throws Exception;

    banco.TO.ConsultaDatosBancoCuentaTO getConsultaDatosBancoCuentaTO(String empresa, String cuenta) throws Exception;

    boolean isExisteChequeAimprimir(String empresa, String cuentaContable, String numeroCheque, Long detSecuencia) throws Exception;

    public boolean isExisteCheque(
            String empresa,
            String cuentaContable,
            String numeroCheque) throws Exception;

    banco.TO.BanChequeTO buscarBanChequeTO(String empresa, String cuenta, String numero) throws Exception;

    boolean canDeleteCuenta(String empresa, String codigoContable) throws Exception;

    java.lang.String getBanConciliacionFechaHasta(java.lang.String empresa, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<banco.TO.BanComboBancoTO> getBanComboBancoTO(java.lang.String empresa) throws java.lang.Exception;

    java.lang.Boolean conciliacionHasta(java.lang.String empresa, java.lang.String hasta, String cuenta) throws java.lang.Exception;

    boolean conciliacionPendiente(java.lang.String empresa) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionTO> getBanListaConciliacionTO(java.lang.String empresa, java.lang.String buscar) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaDebitoTO(java.lang.String empresa, java.lang.String cuenta, java.lang.String codigo, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaCreditoTO(java.lang.String empresa, java.lang.String cuenta, java.lang.String codigo, java.lang.String hasta) throws java.lang.Exception;

    java.math.BigDecimal getBanValorSaldoSistema(java.lang.String empresa, java.lang.String cuenta, java.lang.String hasta) throws java.lang.Exception;

    java.util.List<banco.TO.BanListaChequeTO> getBanListaChequeTO(java.lang.String empresa, java.lang.String cuenta, java.lang.String desde, java.lang.String hasta, java.lang.String tipo) throws java.lang.Exception;

    java.util.List<banco.TO.BanComboCuentaTO> getBanComboCuentaTO(java.lang.String empresa) throws java.lang.Exception;

    java.util.List<banco.TO.BanFunChequesNoEntregadosTO> getBanFunChequesNoEntregadosTO(java.lang.String empresa, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<banco.TO.BanFunChequesNoRevisadosTO> getBanFunChequesNoRevisadosTO(java.lang.String empresa, java.lang.String cuenta) throws java.lang.Exception;

    java.util.List<java.lang.String> getBanCuentasContablesBancos(java.lang.String empresa) throws java.lang.Exception;
//5

    java.util.List<banco.TO.BanChequePreavisadoTO> getBanFunChequesPreavisados(java.lang.String empresa, java.lang.String cuenta, java.lang.String nombrebanco) throws java.lang.Exception;

    int getConteoChequesPreavisados(java.lang.String empresa, java.lang.String cuenta) throws java.lang.Exception;

    int getConteoChequesPreavisados(java.lang.String empresa, java.lang.String cuentaContable, java.lang.String nombreArchivo) throws java.lang.Exception;

    banco.entity.BanPreavisos getBanPreavisos(java.lang.String empresa, java.lang.String cuentaContable) throws java.lang.Exception;

    String getNombreBanco(java.lang.String empresa, java.lang.String cuentaContable) throws Exception;

    public Object getBanChequeSecuencial(String empresa, String cuenta) throws Exception;
}
