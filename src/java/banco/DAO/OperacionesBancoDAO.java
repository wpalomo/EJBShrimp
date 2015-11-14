/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import banco.TO.BanFunChequesNoEntregadosTO;
import banco.TO.BanFunChequesNoRevisadosTO;
import banco.entity.DAO.*;
import banco.helper.ConversionesBanco;
import javax.ejb.Stateless;
import validaciones.ConvertirListaObject;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesBancoDAO implements OperacionesBancoDAOLocal {

    @javax.ejb.EJB
    BanBancoFacadeLocal banBancoFacadeLocal;
    @javax.ejb.EJB
    BanConciliacionFacadeLocal banBanConciliacionFacadeLocal;
    @javax.ejb.EJB
    BanCajaFacadeLocal banCajaFacadeLocal;
    @javax.ejb.EJB
    BanCuentaFacadeLocal banCuentaFacadeLocal;
    @javax.ejb.EJB
    BanChequeFacadeLocal banChequeFacadeLocal;
    @javax.persistence.PersistenceContext(unitName = "EJBShrimpPU")
    javax.persistence.EntityManager em;

    @Override
    public banco.entity.BanBanco buscarBanBanco(String empresa, String codigo) throws Exception {
        return banBancoFacadeLocal.find(new banco.entity.BanBancoPK(empresa, codigo));
    }

    @Override
    public banco.entity.BanConciliacion buscarBanConciliacion(String concEmpresa, String concCuentaContable, String concCodigo) throws Exception {
        return banBanConciliacionFacadeLocal.find(new banco.entity.BanConciliacionPK(concEmpresa, concCuentaContable, concCodigo));
    }

    @Override
    public banco.entity.BanCaja buscarBanCaja(String empresa, String codigo) throws Exception {
        return banCajaFacadeLocal.find(new banco.entity.BanCajaPK(empresa, codigo));
    }

    @Override
    public banco.entity.BanCuenta buscarBanCuenta(String empresa, String codigoCuentaContable) throws Exception {
        return banCuentaFacadeLocal.find(new banco.entity.BanCuentaPK(empresa, codigoCuentaContable));
    }

    @Override
    public banco.entity.BanCheque buscarBanCheque(Long secuencial) throws Exception {
        return banChequeFacadeLocal.find(secuencial);
    }

    @Override
    public java.util.List<banco.TO.ListaBanBancoTO> getListaBanBancoTO(String empresa) throws Exception {
        return banco.helper.ConversionesBanco.convertirListaBanBanco_ListaBanBancoTO(
                em.createNativeQuery("SELECT ban_codigo, ban_nombre "
                + "FROM banco.ban_banco "
                + "WHERE (ban_empresa = '" + empresa + "') "
                + "ORDER BY ban_nombre").getResultList());
    }

    @Override
    public boolean isExisteChequeAimprimir(String empresa, String cuentaContable, String numeroCheque, Long detSecuencia) throws Exception {
        return Boolean.parseBoolean(ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM banco."
                + "fun_sw_cheque_repetido('" + empresa + "', '" + cuentaContable + "', '" + numeroCheque + "' , " + detSecuencia + ")").getResultList(), 0)[0].toString());
    }

    public boolean isExisteCheque(
            String empresa,
            String cuentaContable,
            String numeroCheque) throws Exception {
        numeroCheque = numeroCheque.compareToIgnoreCase("") == 0 ? null : numeroCheque;
        int i = Integer.parseInt(ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(det_secuencia) "
                + "FROM contabilidad.con_contable INNER JOIN contabilidad.con_detalle "
                + "ON con_contable.con_empresa = con_detalle.con_empresa AND "
                + "con_contable.con_periodo = con_detalle.con_periodo AND "
                + "con_contable.con_tipo    = con_detalle.con_tipo    AND "
                + "con_contable.con_numero  = con_detalle.con_numero "
                + "WHERE (cta_empresa='" + empresa + "' AND "
                + "cta_codigo='" + cuentaContable + "') AND "
                + "det_documento='" + numeroCheque + "' AND "
                + "det_debito_credito='C' AND "
                + "NOT con_contable.con_anulado").getResultList(), 0)[0].toString());
        return i == 0 ? false : true;
    }

    @Override
    public banco.TO.BanChequeTO buscarBanChequeTO(String empresa, String cuenta, String numero) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanCheque_BanChequeTO(
                em.createNativeQuery("SELECT * FROM banco.fun_cheque("
                + "'" + empresa + "',"
                + "'" + cuenta + "',"
                + "'" + numero + "')").getResultList());
    }

    @Override
    public java.util.List<banco.TO.ListaBanCajaTO> getListaBanCajaTO(String empresa) throws Exception {
        return banco.helper.ConversionesBanco.convertirListaBanCaja_ListaBanCajaTO(
                em.createNativeQuery("SELECT caja_codigo, caja_nombre, cta_cuenta_contable "
                + "FROM banco.ban_caja "
                + "WHERE (caja_empresa = '" + empresa + "')").getResultList());
    }

    @Override
    public java.util.List<banco.TO.ListaBanCuentaTO> getListaBanCuentaTO(String empresa) throws Exception {
        return banco.helper.ConversionesBanco.convertirListaBanCuenta_ListaBanCuentaTO(
                em.createNativeQuery("SELECT ban_codigo, cta_numero, cta_titular, cta_oficial, cta_formato_cheque, cta_cuenta_contable, cta_codigo_bancario, cta_prefijo_bancario "
                + "FROM banco.ban_cuenta WHERE (cta_empresa = '" + empresa + "')").getResultList());
//        return banco.helper.ConversionesBanco.convertirListaBanCuenta_ListaBanCuentaTO(
//                em.createNativeQuery("SELECT cta_secuencia, ban_codigo, cta_numero, cta_titular, "
//                + "cta_oficial, cta_formato_cheque, cta_cuenta "
//                + "FROM banco.ban_cuenta WHERE (emp_codigo = '" + empresa + "')").getResultList());
    }

    @Override
    public java.util.List<banco.TO.BanListaChequesNoImpresosTO> getListaChequesNoImpresosTO(String empresa, String cuentaBancaria) throws Exception {
        return banco.helper.ConversionesBanco.convertirListaChequesNoImpresos_ListaChequesNoImpresosTO(
                em.createNativeQuery("SELECT * FROM banco.fun_cheques_no_impresos('" + empresa + "', " + cuentaBancaria + ")").getResultList());

//        return banco.helper.ConversionesBanco.convertirListaChequesNoImpresos_ListaChequesNoImpresosTO(
//                em.createNativeQuery("SELECT con_contable.con_periodo, con_contable.con_tipo, con_contable.con_numero, "
//                + "SUBSTRING(con_contable.con_fecha::TEXT,1,10) con_fecha_emision, con_contable.con_concepto, "
//                + "con_detalle.det_secuencia, con_detalle.cta_codigo, con_detalle.det_documento, con_detalle.det_valor "
//                + "FROM contabilidad.con_contable INNER JOIN contabilidad.con_detalle "
//                + "ON con_contable.con_empresa || con_contable.con_periodo || con_contable.con_tipo || con_contable.con_numero = "
//                + "con_detalle.con_empresa || con_detalle.con_periodo || con_detalle.con_tipo || con_detalle.con_numero "
//                + "LEFT JOIN banco.ban_cheque ON con_detalle.det_secuencia = ban_cheque.det_secuencia "
//                + "WHERE con_detalle.cta_empresa = '" + empresa + "' AND con_detalle.cta_codigo IN "
//                + "(SELECT cta_cuenta_contable FROM banco.ban_cuenta WHERE cta_empresa = '" + empresa + "') AND "
//                + "con_detalle.det_debito_credito = 'C' AND (ban_cheque.chq_impreso IS NULL) AND "
//                + "NOT con_contable.con_anulado AND NOT con_contable.con_pendiente ORDER BY con_contable.con_fecha").getResultList());


//                em.createNativeQuery("SELECT con_contable.con_periodo, con_contable.con_tipo, con_contable.con_numero, "
//                + "SUBSTRING(con_contable.con_fecha::TEXT,1,10) con_fecha_emision, con_contable.con_concepto, "
//                + "con_detalle.det_secuencia, con_detalle.cta_codigo, con_detalle.det_documento, con_detalle.det_valor "
//                + "FROM contabilidad.con_contable INNER JOIN contabilidad.con_detalle ON con_contable.con_empresa || "
//                + "con_contable.con_periodo || con_contable.con_tipo || con_contable.con_numero = con_detalle.con_empresa "
//                + "|| con_detalle.con_periodo || con_detalle.con_tipo || con_detalle.con_numero LEFT JOIN banco.ban_cheque "
//                + "ON con_detalle.det_secuencia = ban_cheque.det_secuencia WHERE (con_contable.con_empresa = '" + empresa + "') "
//                + "AND con_detalle.cta_codigo = '110102001' AND con_detalle.det_debito_credito = 'C' AND (ban_cheque.chq_impreso IS NULL) "
//                + "ORDER BY con_contable.con_fecha;").getResultList());
//        return banco.helper.ConversionesBanco.convertirListaChequesNoImpresos_ListaChequesNoImpresosTO(
//                em.createNativeQuery("SELECT con_contable.per_codigo, con_contable.tip_codigo, con_contable.con_numero, "
//                + "SUBSTRING(con_contable.con_fecha::TEXT,1,10) con_fecha_emision, con_contable.con_concepto, "
//                + "con_detalle.det_secuencia, con_detalle.cta_codigo, con_detalle.det_documento, con_detalle.det_valor "
//                + "FROM contabilidad.con_contable INNER JOIN contabilidad.con_detalle ON con_contable.emp_codigo || "
//                + "con_contable.per_codigo || con_contable.tip_codigo || con_contable.con_numero = con_detalle.emp_codigo "
//                + "|| con_detalle.per_codigo || con_detalle.tip_codigo || con_detalle.con_numero LEFT JOIN banco.ban_cheque "
//                + "ON con_detalle.det_secuencia = ban_cheque.det_secuencia WHERE con_contable.emp_codigo = '" + empresa + "' "
//                + "AND con_detalle.cta_codigo = '110102001' AND con_detalle.det_debito_credito = 'C' AND (ban_cheque.chq_impreso IS NULL) "
//                + "ORDER BY con_contable.con_fecha;").getResultList());
    }

    @Override
    public banco.TO.ConsultaDatosBancoCuentaTO getConsultaDatosBancoCuentaTO(String empresa, String cuenta) throws Exception {
        String ctaNumero = "";
        String ctaTitular = "";
        String banNombre = "";

        Object[] arrayBD;
        banco.TO.ConsultaDatosBancoCuentaTO consultaDatosBancoCuentaTO = null;
        try {
            arrayBD = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT ban_cuenta.cta_numero, "
                    + "ban_cuenta.cta_titular, ban_banco.ban_nombre, cta_formato_cheque "
                    + "FROM banco.ban_banco INNER JOIN banco.ban_cuenta "
                    + "ON ban_banco.ban_empresa || ban_banco.ban_codigo = "
                    + "ban_cuenta.ban_empresa || ban_cuenta.ban_codigo "
                    + "WHERE (ban_cuenta.cta_empresa = '" + empresa + "') AND ban_cuenta.cta_cuenta_contable "
                    + "= '" + cuenta + "'").getResultList(), 0);

            //        if (listaAusar != null || !listaAusar.isEmpty()){
            //            listaBD = listaAusar.get(0);
            //        }
            //        banco.TO.ConsultaDatosBancoCuentaTO consultaDatosBancoCuentaTO = null;
            consultaDatosBancoCuentaTO = new banco.TO.ConsultaDatosBancoCuentaTO(arrayBD.length > 0 ? arrayBD[0].toString() : "",
                    arrayBD.length > 0 ? arrayBD[1].toString() : "", arrayBD.length > 0 ? arrayBD[2].toString() : "",
                    arrayBD.length > 0 ? arrayBD[3].toString() : "");

//            consultaDatosBancoCuentaTO.setCtaNumero(listaBD.size() > 0 ? listaBD.get(0).toString() : "");
//            consultaDatosBancoCuentaTO.setCtaTitular(listaBD.size() > 0 ? listaBD.get(1).toString() : "");
//            consultaDatosBancoCuentaTO.setBanNombre(listaBD.size() > 0 ? listaBD.get(2).toString() : "");
        } catch (Exception e) {
            consultaDatosBancoCuentaTO = new banco.TO.ConsultaDatosBancoCuentaTO("", "", "", "");
        }
        return consultaDatosBancoCuentaTO;
    }

    @Override
    public boolean canDeleteCuenta(String empresa, String codigoContable) throws Exception {
        boolean encontrado = false;

        int numeroDeRegistros = Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT count(*) "
                + "FROM contabilidad.con_detalle "
                + "INNER JOIN banco.ban_cheque "
                + "ON con_detalle.det_secuencia = ban_cheque.det_secuencia "
                + "WHERE cta_empresa = ('" + empresa + "') "
                + "AND cta_codigo = ('" + codigoContable + "');").getResultList(), 0)[0].toString());
        if (numeroDeRegistros >= 1) {
            encontrado = true;
        }

        return encontrado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS BANCO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de BanComboBancoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanComboBancoTO> getBanComboBancoTO(String empresa) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanComboBanco_BanComboBancoTO(
                em.createNativeQuery("SELECT ban_nombre, cta_numero, cta_titular, cta_cuenta_contable, cta_codigo_bancario, cta_prefijo_bancario "
                + "FROM banco.ban_cuenta INNER JOIN banco.ban_banco "
                + "ON ban_cuenta.ban_empresa = ban_banco.ban_empresa AND "
                + "ban_cuenta.ban_codigo = ban_banco.ban_codigo "
                + "WHERE (ban_cuenta.ban_empresa = '" + empresa + "');").getResultList());
    }

    /**
     * @autor Misayo
     *
     * @param empresa
     * @param hasta
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean conciliacionHasta(String empresa, String hasta, String cuenta) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT COALESCE ('" + hasta + "' > MAX(conc_hasta), TRUE) "
                + "FROM banco.ban_conciliacion "
                + "WHERE (conc_empresa = '" + empresa + "') "
                + "AND (conc_cuenta_contable = '" + cuenta + "');").getResultList(), 0)[0].toString());
    }

    /**
     * @autor Misayo
     *
     * @param empresa
     * @return true conciliacionPendiente, false conciliacionNoPendiente
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean conciliacionPendiente(String empresa) throws Exception {
        int conteo = Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM banco.ban_conciliacion "
                + "WHERE (conc_empresa = '" + empresa + "') "
                + "AND (conc_pendiente);").getResultList(), 0)[0].toString());
        if (conteo == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param buscar
     * @param interno
     * @return lista de banListaConciliacionTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanListaConciliacionTO> getBanListaConciliacionTO(String empresa, String buscar) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanListaConciliacion_BanListaConciliacionTO(em.createNativeQuery("SELECT conc_cuenta_contable, cta_detalle, "
                + "conc_codigo, conc_hasta, conc_saldo_estado_cuenta, "
                + "conc_cheques_girados_y_no_cobrados, "
                + "conc_depositos_en_transito, conc_pendiente "
                + "FROM banco.ban_conciliacion "
                + "INNER JOIN contabilidad.con_cuentas "
                + "ON ban_conciliacion.cta_empresa = con_cuentas.cta_empresa "
                + "AND ban_conciliacion.cta_cuenta_contable = con_cuentas.cta_codigo "
                + "WHERE (conc_empresa = '" + empresa + "') AND "
                + "(conc_cuenta_contable || conc_codigo || conc_hasta || "
                + "conc_hasta || conc_codigo || conc_cuenta_contable "
                + "LIKE TRANSLATE(' ' || '" + buscar + "' || ' ', ' ', '%')) "
                + "ORDER BY 1, 4 DESC;").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @return fecha Hasta de la ultima conciliación
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String getBanConciliacionFechaHasta(String empresa, String cuenta) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT MAX(conc_hasta) "
                    + "FROM banco.ban_conciliacion "
                    + "WHERE (conc_empresa = '" + empresa + "') AND "
                    + "(conc_cuenta_contable = '" + cuenta + "');").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @param codigo
     * @param hasta
     * @return lista de BanComboBancoTO por Debito
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaDebitoTO(String empresa, String cuenta, String codigo, String hasta) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanListaConciliacionBancaria_BanListaConciliacionBancariaTO(
                em.createNativeQuery("SELECT cb_contable, cb_secuencial, cb_fecha, cb_documento, "
                + "cb_valor, cb_conciliado, cb_concepto, cb_observaciones, cb_dc "
                + "FROM banco.fun_conciliacion_bancaria("
                + "'" + empresa + "', "
                + "'" + cuenta + "', "
                + "'" + codigo + "', "
                + "'" + hasta + "') "
                + "WHERE (cb_dc = 'C');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @param codigo
     * @param hasta
     * @return lista de BanComboBancoTO por Credito
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanListaConciliacionBancariaTO> getBanListaConciliacionBancariaCreditoTO(String empresa, String cuenta, String codigo, String hasta) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanListaConciliacionBancaria_BanListaConciliacionBancariaTO(
                em.createNativeQuery("SELECT cb_contable, cb_secuencial, cb_fecha, cb_documento, "
                + "cb_valor, cb_conciliado, cb_concepto, cb_observaciones, cb_dc "
                + "FROM banco.fun_conciliacion_bancaria("
                + "'" + empresa + "', "
                + "'" + cuenta + "', "
                + "'" + codigo + "', "
                + "'" + hasta + "') "
                + "WHERE (cb_dc = 'D');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @param hasta
     * @return valorSaldoSistema
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.math.BigDecimal getBanValorSaldoSistema(String empresa, String cuenta, String hasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        try {
            return new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(""
                    + "SELECT * FROM contabilidad.fun_saldo_cuenta("
                    + "'" + empresa + "', "
                    + "'" + cuenta + "', "
                    + "'" + hasta + "');").getResultList(), 0)[0].toString());
        } catch (Exception e) {            
            return new java.math.BigDecimal("0.00");
        }
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @param desde
     * @param hasta
     * @param tipo
     * @return banListaChequeTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanListaChequeTO> getBanListaChequeTO(String empresa, String cuenta, String desde, String hasta, String tipo) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanListaCheque_BanListaChequeTO(
                em.createNativeQuery("SELECT * FROM banco.fun_cheques("
                + "'" + empresa + "', "
                + "'" + cuenta + "', "
                + "'" + desde + "', "
                + "'" + hasta + "', "
                + "'" + tipo + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return banComboCuentaTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanComboCuentaTO> getBanComboCuentaTO(String empresa) throws Exception {
        return banco.helper.ConversionesBanco.convertirBanComboCuentaTO_BanComboCuentaTO(
                em.createNativeQuery("SELECT cta_cuenta_contable, cta_numero || ' | ' || ban_nombre cta_cuenta_bancaria "
                + "FROM banco.ban_cuenta INNER JOIN banco.ban_banco ON "
                + "ban_cuenta.ban_empresa = ban_banco.ban_empresa AND "
                + "ban_cuenta.ban_codigo = ban_banco.ban_codigo "
                + "WHERE ban_cuenta.ban_empresa='" + empresa + "';").getResultList());
    }

    // </editor-fold>
    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @return lista de BanFunChequesNoEntregadosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<BanFunChequesNoEntregadosTO> getBanFunChequesNoEntregadosTO(String empresa, String cuenta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        cuenta = cuenta == null ? cuenta : "'" + cuenta + "'";
        return ConversionesBanco.convertirBanFunChequesNoEntregados_BanFunChequesNoEntregadosTO(em.createNativeQuery("SELECT * FROM banco.fun_cheques_no_entregados("
                + empresa + ", "
                + cuenta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param cuenta
     * @return lista de BanFunChequesNoRevisadosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<BanFunChequesNoRevisadosTO> getBanFunChequesNoRevisadosTO(String empresa, String cuenta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        cuenta = cuenta == null ? cuenta : "'" + cuenta + "'";
        return ConversionesBanco.convertirBanFunChequesNoRevisados_BanFunChequesNoRevisadosTO(em.createNativeQuery("SELECT * FROM banco.fun_cheques_no_revisados("
                + empresa + ", "
                + cuenta + ");").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cuentas Contables en BANCOS
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<String> getBanCuentasContablesBancos(String empresa) throws Exception {
        return ConversionesBanco.convertirCuentasContablesConsulta_CuentasContablesString(em.createNativeQuery("SELECT cta_cuenta_contable FROM banco.ban_cuenta WHERE cta_empresa = '" + empresa + "'").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Cheques Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<banco.TO.BanChequePreavisadoTO> getBanFunChequesPreavisados(String empresa, String cuenta, String nombrebanco) throws Exception {
        if (nombrebanco.lastIndexOf("BOLIVARIANO") >= 0) {
            return ConversionesBanco.convertirChequePreavisado_ChequePreavisadoTO(em.createNativeQuery("SELECT * FROM banco.fun_cheques_preavisados('" + empresa + "', '" + cuenta + "')").getResultList());
        } else {
            if (nombrebanco.lastIndexOf("INTERNACIONAL") >= 0) {
                return ConversionesBanco.convertirChequePreavisado_ChequePreavisadoTO(em.createNativeQuery("SELECT ''::text,''::text,''::text,''::text,''::text,chq_beneficiario_tipo_id,''::text,''::text,''::text,"
                        + "''::text,chq_cuenta_numero,chq_cheque_numero,''::text,chq_cheque_valor,''::text,''::text,''::text,''::text,chq_fecha_revision"
                        + " FROM banco.fun_cheques_preavisados_internacional('" + empresa + "', '" + cuenta + "')").getResultList());
            } else {
                return ConversionesBanco.convertirChequePreavisado_ChequePreavisadoTO(em.createNativeQuery("SELECT * FROM banco.fun_cheques_preavisados('" + empresa + "', '" + cuenta + "') WHERE false").getResultList());
            }
        }
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return numero de registros de la tabla
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public int getConteoChequesPreavisados(String empresa, String cuenta) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM banco.ban_preavisos "
                + "WHERE pre_empresa = '" + empresa + "' AND pre_cuenta_contable='" + cuenta + "'").getResultList(), 0)[0].toString());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @param cuentaContable
     * @param nombreArchivo
     * @return numero de registros de la tabla
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public int getConteoChequesPreavisados(String empresa, String cuentaContable, String nombreArchivo) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) FROM banco.ban_preavisos "
                + "WHERE pre_empresa = '" + empresa + "' AND pre_cuenta_contable = '" + cuentaContable + "' AND "
                + "pre_nombre_archivo_generado = '" + nombreArchivo + "'").getResultList(), 0)[0].toString());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @param cuentaContable
     * @param nombreArchivo
     * @return numero de registros de la tabla
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public banco.entity.BanPreavisos getBanPreavisos(String empresa, String cuentaContable) throws Exception {
        return ConversionesBanco.convertirBanPreavisosTO_BanPreavisos(
                em.createNativeQuery("SELECT pre_empresa, pre_cuenta_contable, "
                + "pre_nombre_archivo_generado, pre_fecha_revision_ultimo_cheque, "
                + "usr_empresa, usr_codigo, usr_fecha_inserta "
                + "FROM banco.ban_preavisos "
                + "WHERE pre_empresa = '" + empresa + "' "
                + "AND pre_cuenta_contable = '" + cuentaContable + "' "
                + "ORDER BY usr_fecha_inserta DESC LIMIT 1;").getResultList());
    }

    /**
     * @autor Nelson Benavides
     *
     * @param empresa
     * @param cuentaContable
     * @return nombre de banco a partir de la cuenta
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String getNombreBanco(String empresa, String cuentaContable) throws Exception {

        String nombreBanco = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT ban_nombre "
                + "FROM banco.ban_cuenta INNER JOIN banco.ban_banco "
                + "ON ban_cuenta.ban_empresa = ban_banco.ban_empresa AND "
                + "ban_cuenta.ban_codigo = ban_banco.ban_codigo "
                + "WHERE cta_empresa='" + empresa + "' AND "
                + "cta_cuenta_contable='" + cuentaContable + "';").getResultList(), 0);

        if (array != null) {
            nombreBanco = array[0].toString().trim();
        } else {
            nombreBanco = "";
        }
        return nombreBanco;

    }
}
