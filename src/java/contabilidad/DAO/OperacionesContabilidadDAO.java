/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.DAO;

import cartera.TO.CarCuentasPorPagarCobrarAnticiposTO;
import cartera.TO.CarCuentasPorPagarCobrarSaldoAnticiposTO;
import cartera.helper.ConversionesCar;
import contabilidad.TO.ConCuentasFlujoTO;
import contabilidad.TO.ConCuentasTO;
import contabilidad.TO.ConEstructuraTO;
import contabilidad.TO.ConTipoTO;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConContablePK;
import contabilidad.entity.ConCuentas;
import contabilidad.entity.ConCuentasPK;
import contabilidad.entity.ConDetalle;
import contabilidad.entity.ConTipo;
import contabilidad.entity.ConTipoPK;
import contabilidad.entity.DAO.ConContableFacadeLocal;
import contabilidad.entity.DAO.ConCuentasFacadeLocal;
import contabilidad.entity.DAO.ConDetalleFacadeLocal;
import contabilidad.entity.DAO.ConNumeracionFacadeLocal;
import contabilidad.entity.DAO.ConTipoFacadeLocal;
import contabilidad.helper.ConversionesContabilidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.helper.ConversionesRRHH;
import validaciones.Validacion;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesContabilidadDAO implements OperacionesContabilidadDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EJBShrimpPU")
    EntityManager em;
    @EJB
    ConTipoFacadeLocal conTipoFacadeLocal;
    @EJB
    ConNumeracionFacadeLocal conNumeracionFacadeLocal;
    @EJB
    ConCuentasFacadeLocal conCuentasFacadeLocal;
    @EJB
    contabilidad.entity.DAO.ConCuentasFlujoDetalleFacadeLocal conCuentasFlujoDetalleFacadeLocal;
    @EJB
    ConContableFacadeLocal conContableFacadeLocal;
    @EJB
    ConDetalleFacadeLocal conDetalleFacadeLocal;
    @EJB
    contabilidad.entity.DAO.ConCuentasFlujoFacadeLocal conCuentasFlujoFacadeLocal;

    // <editor-fold defaultstate="collapsed" desc="BUSCAR ENTIDADES">
    @Override
    public ConTipo buscarTipo(String empCodigo, String tipCodigo) throws Exception {
        return conTipoFacadeLocal.find(new ConTipoPK(empCodigo, tipCodigo));
    }

    @Override
    public ConCuentas buscarCuentas(String empCodigo, String codCuenta) throws Exception {
        return conCuentasFacadeLocal.find(new ConCuentasPK(empCodigo, codCuenta));
    }

    @Override
    public contabilidad.entity.ConCuentasFlujoDetalle buscarCuentasFlujoDetalle(String codEmpresa, String codCuenta, char detCreditoDebito) throws Exception {
        return conCuentasFlujoDetalleFacadeLocal.find(new contabilidad.entity.ConCuentasFlujoDetallePK(codEmpresa, codCuenta, detCreditoDebito));
    }

    @Override
    public ConContable buscarContable(String codEmpresa, String perCodigo, String tipCodigo, String conNumero) throws Exception {
        return conContableFacadeLocal.find(new ConContablePK(codEmpresa, perCodigo, tipCodigo, conNumero));
    }

    @Override
    public ConDetalle buscarDetalleContable(Long codDetalle) throws Exception {
        return conDetalleFacadeLocal.find(codDetalle.intValue());
    }

    /**
     * @autor misayo
     *
     * @param empCodigo Codigo empresa
     * @param tipCodigo Tipo de comprobante
     * @return true si encuentra, false si no lo encuentra
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Boolean buscarTipoContable(String empCodigo, String tipCodigo) throws Exception {
        return (Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) FROM contabilidad.con_tipo "
                + "WHERE tip_empresa = ('" + empCodigo + "') AND tip_codigo = ('" + tipCodigo + "')").
                getResultList(), 0)[0].toString()) == 0) ? false : true;
    }

    @Override
    public String buscarContableTrasferencia(String empCodigo, String contipo, String concepto, String fecha, String conSector) throws Exception {
        String retorno = "";
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT con_numero FROM contabilidad.con_contable "
                + "WHERE con_empresa = ('" + empCodigo + "') AND "
                + "con_tipo = ('" + contipo + "') AND "
                + "con_concepto = ('" + concepto + "') AND "
                + "con_observaciones = ('SECTOR: ' || '" + conSector + "') AND "
                + "con_fecha = ( " + (fecha == null ? fecha : "'" + fecha + "'") + " ) "
                + "order by 1 limit 1").getResultList(), 0);//AND con_anulado = FALSE 
        //'SECTOR: ' ||
        if (array != null) {
            retorno = array[0].toString().trim();
        } else {
            retorno = "";
        }
        return retorno;
    }

    @Override
    public List<contabilidad.TO.ConContableTO> listaContableTrasferenciaPorPeriodoFecha(
            String empCodigo,
            String contipo,
            String concepto,
            String fechaDesde,
            String fechaHasta,
            String conSector) throws Exception {
        return ConversionesContabilidad.convertirListaConContable_ListaConContableTO(em.createNativeQuery("SELECT * FROM contabilidad.con_contable "
                + "WHERE con_empresa = ('" + empCodigo + "') AND con_tipo = ('" + contipo + "') "
                + "AND con_concepto = ('" + concepto + "')"
                + "AND con_observaciones = ('SECTOR: ' || '" + conSector + "') "
                + " AND con_fecha >=  ( " + (fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'") + " ) "
                + "AND con_fecha <=  ( " + (fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'") + " ) "
                + "order by 1").getResultList());
    }

    @Override
    public java.util.List<contabilidad.TO.InvListaConsultaConsumosTO> getListaInvConsultaConsumosPendientes(
            String empCodigo, String fechaDesde, String fechaHasta) throws Exception {
        return contabilidad.helper.ConversionesContabilidad.convertirInvListaConsultaConsumosPendientes_InvListaConsultaConsumosTO(em.createNativeQuery("SELECT cons_periodo, cons_motivo, cons_numero, cons_fecha FROM inventario.inv_consumos "
                + "WHERE cons_empresa= ('" + empCodigo + "') "
                + "AND cons_fecha >=  ( " + (fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'") + " ) "
                + "AND cons_fecha <=  ( " + (fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'") + " ) "
                + "AND cons_pendiente "
                + "ORDER BY 1,2,3").
                getResultList());

    }

    @Override
    public int buscarConteoNumeracionEliminarTipo(String empCodigo, String tipCodigo) throws Exception {
        return Integer.parseInt(em.createNativeQuery("SELECT COUNT(*) FROM contabilidad."
                + "con_contable WHERE con_empresa = ('" + empCodigo + "') AND con_tipo = ('" + tipCodigo + "')").getResultList().get(0).toString());
//        return Integer.parseInt(((List) em.createNativeQuery("SELECT COUNT(*) FROM"
//                + " contabilidad.con_numeracion WHERE tip_empresa = ('" + empCodigo +
//                "') AND tip_codigo = ('" + tipCodigo + "')").getResultList().get(0)).get(0).toString());
    }

    @Override
    public int buscarConteoDetalleEliminarCuenta(String empCodigo, String cuentaCodigo) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*) FROM"
                + " contabilidad.con_detalle WHERE cta_empresa = ('" + empCodigo
                + "') AND cta_codigo = ('" + cuentaCodigo + "')").getResultList(), 0)[0].toString());
    }

    @Override
    public int buscarConteoUltimaNumeracion(String empCodigo, String perCodigo, String tipCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery("SELECT num_secuencia "
                    + "FROM contabilidad.con_numeracion WHERE num_empresa = ('"
                    + empCodigo + "') AND num_tipo = ('" + tipCodigo + "') "
                    + "AND num_periodo = ('" + perCodigo + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }

    }
    // </editor-fold>

    @Override
    public List<ConTipoTO> getListaConTipoTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConTipo_ListaConTipoTO(em.createNativeQuery("SELECT * FROM contabilidad.con_tipo WHERE "
                + "tip_empresa = ('" + empresa + "')").getResultList());
    }

    @Override
    public Boolean swCobrosAnticiposEliminar(
            String codEmpresa,
            String periodo,
            String tipo,
            String numeroContable) throws Exception {
        Boolean sePuedeAnular = true;
        if (tipo.equals("C-ACLI")) {
            sePuedeAnular = Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM cartera.fun_sw_cobros_anticipos_eliminar("
                    + "'" + codEmpresa + "', "
                    + "'" + periodo + "', "
                    + "'" + tipo + "', "
                    + "'" + numeroContable + "');").getResultList(), 0)[0].toString());
        } else if (tipo.equals("C-APRO")) {
            sePuedeAnular = Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM cartera.fun_sw_pagos_anticipos_eliminar("
                    + "'" + codEmpresa + "', "
                    + "'" + periodo + "', "
                    + "'" + tipo + "', "
                    + "'" + numeroContable + "');").getResultList(), 0)[0].toString());
        }
        return sePuedeAnular;
    }

    @Override
    public List<ConTipoTO> getListaConTipoRrhhTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConTipo_ListaConTipoTO(em.createNativeQuery("SELECT * FROM contabilidad.con_tipo WHERE "
                + "tip_empresa = ('" + empresa + "') AND ("
                + "tip_codigo = 'C-ANT' OR "
                + "tip_codigo = 'C-PRE' OR "
                + "tip_codigo = 'C-PRO' OR "
                + "tip_codigo = 'C-BON' OR "
                + "tip_codigo = 'C-VIA' OR "
                + "tip_codigo = 'C-ROL' OR "
                + "tip_codigo = 'C-VAC')").getResultList());
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConTipo_ListaConTipoTO(em.createNativeQuery("SELECT * FROM contabilidad.con_tipo WHERE "
                + "tip_empresa = ('" + empresa + "') AND ("
                + "tip_codigo = 'C-COB' OR "
                + "tip_codigo = 'C-PAG')").getResultList());
    }

    @Override
    public List<ConTipoTO> getListaConTipoCarteraAnticiposTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConTipo_ListaConTipoTO(em.createNativeQuery("SELECT * FROM contabilidad.con_tipo WHERE "
                + "tip_empresa = ('" + empresa + "') AND ("
                + "tip_codigo = 'C-ACLI' OR "
                + "tip_codigo = 'C-APRO')").getResultList());
    }

    @Override
    public List<ConCuentasTO> getListaConCuentasTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConCuentas_ListaConCuentasTO(em.createNativeQuery("SELECT cta_empresa,  cta_codigo, REPEAT(' ', "
                + "CHAR_LENGTH(TRIM(BOTH ' ' FROM cta_codigo))) || cta_detalle, "
                + "cta_activo, usr_codigo FROM "
                + "contabilidad.con_cuentas WHERE cta_empresa = ('" + empresa + "')"
                + " ORDER BY cta_codigo").getResultList());
//        return ConversionesContabilidad.convertirListaConCuentas_ListaConCuentasTO(em.
//                createNativeQuery("SELECT emp_codigo, cta_codigo, REPEAT(' ', "
//                + "CHAR_LENGTH(TRIM(BOTH ' ' FROM cta_codigo))) || cta_detalle, "
//                + "cta_activo, usr_insert_pcta, usr_insert_pcta FROM "
//                + "contabilidad.con_cuentas WHERE emp_codigo = ('" + empresa + "')"
//                + " ORDER BY cta_codigo").getResultList());
    }

    @Override
    public List<ConCuentasTO> getRangoCuentasTO(
            String empresa,
            String codigoCuentaDesde,
            String codigoCuentaHasta,
            int largoCuenta) throws Exception {
        codigoCuentaDesde = codigoCuentaDesde == null ? codigoCuentaDesde : "'" + codigoCuentaDesde + "'";
        codigoCuentaHasta = codigoCuentaHasta == null ? codigoCuentaHasta : "'" + codigoCuentaHasta + "'";
        return ConversionesContabilidad.convertirListaConCuenta_ListaConCuentaTO(em.createNativeQuery(""
                + "SELECT cta_codigo, cta_detalle FROM contabilidad.con_cuentas "
                + "WHERE cta_empresa = ('" + empresa + "') and "
                + "cta_codigo >= (" + codigoCuentaDesde + ") and "
                + "cta_codigo <= (" + codigoCuentaHasta + ") and "
                + "LENGTH(cta_codigo) = ('" + largoCuenta + "') "
                + "ORDER BY cta_codigo").getResultList());
    }

    @Override
    public List<ConCuentasFlujoTO> getListaConCuentasFlujoTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConCuentasFlujo_ListaConCuentasFlujoTO(em.createNativeQuery("SELECT flu_empresa,  flu_codigo, REPEAT(' ', "
                + "CHAR_LENGTH(TRIM(BOTH ' ' FROM flu_codigo))) || flu_detalle, "
                + "flu_activo, usr_codigo FROM "
                + "contabilidad.con_cuentas_flujo WHERE flu_empresa = ('" + empresa + "')"
                + " ORDER BY flu_codigo").getResultList());
//        return ConversionesContabilidad.convertirListaConCuentas_ListaConCuentasTO(em.
//                createNativeQuery("SELECT emp_codigo, cta_codigo, REPEAT(' ', "
//                + "CHAR_LENGTH(TRIM(BOTH ' ' FROM cta_codigo))) || cta_detalle, "
//                + "cta_activo, usr_insert_pcta, usr_insert_pcta FROM "
//                + "contabilidad.con_cuentas WHERE emp_codigo = ('" + empresa + "')"
//                + " ORDER BY cta_codigo").getResultList());
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaConCuentasFlujoDetalleTO(String empresa) throws Exception {
        String comando = "SELECT det_empresa, det_cuenta_contable, det_debito_credito, det_cuenta_flujo, "
                + " con_cuentas_flujo_detalle.flu_empresa, con_cuentas_flujo_detalle.flu_codigo,"
                + " con_cuentas_flujo_detalle.cta_empresa, con_cuentas_flujo_detalle.cta_codigo,"
                + " con_cuentas_flujo_detalle.usr_empresa, con_cuentas_flujo_detalle.usr_codigo, con_cuentas_flujo_detalle.usr_fecha_inserta,"
                + " con_cuentas.cta_detalle, con_cuentas_flujo.flu_detalle"
                + " FROM contabilidad.con_cuentas_flujo_detalle INNER JOIN contabilidad.con_cuentas"
                + " ON con_cuentas_flujo_detalle.cta_empresa = con_cuentas.cta_empresa AND"
                + "   con_cuentas_flujo_detalle.cta_codigo = con_cuentas.cta_codigo"
                + " INNER JOIN contabilidad.con_cuentas_flujo"
                + " ON con_cuentas_flujo_detalle.flu_empresa = con_cuentas_flujo.flu_empresa AND"
                + " con_cuentas_flujo_detalle.flu_codigo = con_cuentas_flujo.flu_codigo WHERE det_empresa = ('" + empresa + "')";
        return ConversionesContabilidad.convertirListaConCuentasFlujoDetalle_ListaConCuentasFlujoDetalleTO(em.createNativeQuery(comando).getResultList());
    }

    @Override
    public List<contabilidad.TO.ConCuentasFlujoDetalleTO> getListaBuscarConCuentasFlujoDetalleTO(String empresa, String buscar) throws Exception {
        return ConversionesContabilidad.convertirListaConCuentasFlujoDetalle_ListaConCuentasFlujoDetalleTO(em.createNativeQuery("SELECT * FROM contabilidad.con_cuentas_flujo_detalle WHERE "
                + "det_empresa = ('" + empresa + "') AND (det_cuenta_contable || UPPER(det_cuenta_flujo) "
                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + buscar + "') = '' THEN '~' "
                + "ELSE ('" + buscar + "') END || ' ', ' ', '%'))").getResultList());
    }

    @Override
    public java.util.List<contabilidad.TO.ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConCuentasFlujo_ListaConCuentasFlujoTO(
                em.createNativeQuery("SELECT * FROM contabilidad.con_cuentas_flujo WHERE (cta_empresa = '" + empresa + "')").getResultList());
//        return banco.helper.ConversionesBanco.convertirListaBanCuenta_ListaBanCuentaTO(
//                em.createNativeQuery("SELECT cta_secuencia, ban_codigo, cta_numero, cta_titular, "
//                + "cta_oficial, cta_formato_cheque, cta_cuenta "
//                + "FROM banco.ban_cuenta WHERE (emp_codigo = '" + empresa + "')").getResultList());
    }

    @Override
    public List<ConCuentasTO> getListaBuscarConCuentasTO(String empresa, String buscar, String ctaGrupo) throws Exception {
        ctaGrupo = ctaGrupo == null ? ctaGrupo : "'" + ctaGrupo + "'";
        return ConversionesContabilidad.convertirListaConCuentas_ListaConCuentasTO(em.createNativeQuery(
                "SELECT "
                + "cta_empresa, "
                + "cta_codigo, "
                + "REPEAT(' ', CHAR_LENGTH(TRIM(BOTH ' ' FROM cta_codigo))) || cta_detalle cta_detalle, "
                + "cta_activo "
                + "FROM contabilidad.con_cuentas "
                + "WHERE cta_empresa = ('" + empresa + "') AND "
                + "CASE WHEN ('" + buscar + "') = '' THEN TRUE "
                + "ELSE (cta_codigo || UPPER(cta_detalle) LIKE '%' || TRANSLATE('" + buscar + "', ' ', '%') || '%') END AND "
                + "CASE WHEN " + ctaGrupo + " IS NULL THEN TRUE "
                + "ELSE SUBSTRING(cta_codigo,1,LENGTH(" + ctaGrupo + "))=" + ctaGrupo + " END "
                + "ORDER BY cta_codigo;").getResultList());
    }

    @Override
    public List<ConCuentasFlujoTO> getListaBuscarConCuentasFlujoTO(String empresa, String buscar) throws Exception {
        return ConversionesContabilidad.convertirListaConCuentasFlujo_ListaConCuentasFlujoTO(em.createNativeQuery("SELECT flu_empresa, flu_codigo, REPEAT(' ', "
                + "CHAR_LENGTH(TRIM(BOTH ' ' FROM flu_codigo))) || flu_detalle "
                + "CTA_DETALLE, flu_activo FROM contabilidad.con_cuentas_flujo WHERE "
                + "flu_empresa = ('" + empresa + "') AND (flu_codigo || UPPER(flu_detalle) "
                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + buscar + "') = '' THEN '~' "
                + "ELSE ('" + buscar + "') END || ' ', ' ', '%')) ORDER BY flu_codigo").getResultList());
    }

    @Override
    public List<ConEstructuraTO> getListaConEstructuraTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConEstructura_ListaConEstructuraTO(em.createNativeQuery("SELECT * FROM contabilidad.con_estructura WHERE "
                + "est_empresa = ('" + empresa + "')").getResultList());
    }

    @Override
    public List<contabilidad.TO.ConEstructuraFlujoTO> getListaConEstructuraFlujoTO(String empresa) throws Exception {
        return ConversionesContabilidad.convertirListaConEstructuraFlujo_ListaConEstructuraFlujoTO(em.createNativeQuery("SELECT * FROM contabilidad.con_estructura_flujo WHERE "
                + "est_empresa = ('" + empresa + "')").getResultList());
    }

    @Override
    public List<contabilidad.TO.ListaConContableTO> getListaBusquedaConContableTO(String empresa,
            String perCodigo, String tipCodigo, String busqueda,
            String nRegistros) throws Exception {
        String limit = "";
        if (nRegistros != null && nRegistros.compareTo("") != 0 && nRegistros.compareTo("0") != 0) {
            limit = " limit " + nRegistros;
        }
        return ConversionesContabilidad.convertirListaBusquedaConContable_ListaBusquedaConContableTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_contables_listado('" + empresa + "', '"
                + perCodigo + "', '" + tipCodigo + "', '" + busqueda + "')" + limit + ";").getResultList());
//        return ConversionesContabilidad.convertirListaBusquedaConContable_ListaBusquedaConContableTO(em.
//                createNativeQuery("SELECT "
//                + "con_empresa, "
//                + "con_periodo, "
//                + "con_tipo, "
//                + "con_numero, "
//                + "substring(con_fecha::text, 1, 10), "
//                + "CASE WHEN con_pendiente THEN 'PENDIENTE' ELSE ' ' END, "
//                + "CASE WHEN con_anulado THEN 'ANULADO' ELSE ' ' END, "
//                + "CASE WHEN con_bloqueado THEN 'BLOQUEADO' ELSE ' ' END, "
//                + "con_concepto, "
//                + "con_detalle, "
//                + "con_observaciones "
//                + "FROM contabilidad.con_contable "
//                + "WHERE (con_empresa = '" + empresa + "') AND "
//                + "CASE WHEN ('" + perCodigo + "') = '' THEN TRUE ELSE con_periodo = ('" + perCodigo + "') END AND "
//                + "CASE WHEN ('" + tipCodigo + "') = '' THEN TRUE ELSE con_tipo = ('" + tipCodigo + "') END AND "
//                + "con_empresa || con_periodo || con_tipo || con_numero "
//                + "|| con_fecha || CASE WHEN con_pendiente THEN 'PENDIENTE' "
//                + "ELSE ' ' END || CASE WHEN con_anulado THEN 'ANULADO' ELSE ' ' "
//                + "END || con_concepto || con_detalle || con_observaciones "
//                + "LIKE TRANSLATE(' ' || CASE WHEN ('" + busqueda + "') = '' THEN ''  "
//                + "ELSE ('" + busqueda + "') END || ' ', ' ', '%') ORDER BY usr_fecha_inserta").getResultList());
    }

    @Override
    public List<contabilidad.TO.ConContableTO> getListaConContableTO(String empresa,
            String perCodigo, String tipCodigo, String numContable) throws Exception {
//                createNativeQuery("SELECT emp_codigo, per_codigo, tip_codigo, "
//                + "con_numero, substring(con_fecha, 1, 10), con_pendiente, "
//                + "con_revisado, con_anulado, con_generado, con_dcto_origen, "
//                + "con_concepto, con_detalle, con_observaciones, "
//                + "usr_inserta_contable, usr_fecha_inserta_contable FROM contabilidad.con_contable "
//                + "WHERE emp_codigo = ('" + empresa + "') AND tip_codigo = ('" +
//                tipCodigo + "') AND per_codigo = ('" + perCodigo + "') AND con_numero = ('"
//                + numContable + "')").getResultList()).get(0));

        return ConversionesContabilidad.convertirListaConContable_ListaConContableTO(em.createNativeQuery("SELECT con_empresa, con_periodo, con_tipo, "
                + "con_numero, substring(con_fecha::text, 1, 10), con_pendiente, "
                + "con_bloqueado, con_anulado, con_generado, "
                + "con_concepto, con_detalle, con_observaciones, "
                + "usr_codigo, usr_fecha_inserta FROM contabilidad.con_contable "
                + "WHERE con_empresa = ('" + empresa + "') AND con_tipo = ('"
                + tipCodigo + "') AND con_periodo = ('" + perCodigo + "') AND con_numero = ('" + numContable + "')").getResultList());
//        return ConversionesContabilidad.convertirListaConContable_ListaConContableTO(em.
//                createNativeQuery("SELECT emp_codigo, per_codigo, tip_codigo, "
//                + "con_numero, substring(con_fecha::text, 1, 10), con_pendiente, " Hola que tal podri
//                + "con_revisado, con_anulado, con_generado, con_dcto_origen, "
//                + "con_concepto, con_detalle, con_observaciones, "
//                + "usr_inserta_contable, usr_fecha_inserta_contable FROM contabilidad.con_contable "
//                + "WHERE emp_codigo = ('" + empresa + "') AND tip_codigo = ('" +
//                tipCodigo + "') AND per_codigo = ('" + perCodigo + "') AND con_numero = ('"
//                + numContable + "')").getResultList());
    }

    @Override
    public List<contabilidad.TO.ConDetalleTablaTO> getListaConDetalleTO(String empresa,
            String perCodigo, String tipCodigo, String numContable) throws Exception {
        return ConversionesContabilidad.convertirListaConDetalleTabla_ListaConDetalleTablaTO(em.createNativeQuery(
                "SELECT "
                + "con_detalle.cta_codigo, "
                + "con_cuentas.cta_detalle, "
                + "con_detalle.sec_codigo, "
                + "con_detalle.pis_numero, "
                + "con_detalle.det_documento, "
                + "con_detalle.det_debito_credito, "
                + "con_detalle.det_valor, con_detalle.det_observaciones, con_detalle.det_secuencia, "
                + "con_detalle.det_generado, con_detalle.det_referencia FROM contabilidad.con_detalle "
                + "INNER JOIN contabilidad.con_cuentas ON con_detalle.con_empresa||con_detalle.cta_codigo "
                + "= con_cuentas.cta_empresa||con_cuentas.cta_codigo WHERE "
                + "con_detalle.con_empresa = ('" + empresa + "') AND con_detalle.con_tipo "
                + "= ('" + tipCodigo + "') AND con_detalle.con_periodo = ('" + perCodigo + "') AND "
                + "con_detalle.con_numero = ('" + numContable + "') ORDER BY con_detalle.det_orden").getResultList());
//        return ConversionesContabilidad.convertirListaConDetalleTabla_ListaConDetalleTablaTO(em.
//                createNativeQuery("SELECT con_detalle.cta_codigo, con_cuentas.cta_detalle, "
//                + "con_detalle.det_centro_produccion, con_detalle.det_centro_costo, "
//                + "con_detalle.det_documento, con_detalle.det_debito_credito, "
//                + "con_detalle.det_valor, con_detalle.det_secuencia, "
//                + "con_detalle.det_generado FROM contabilidad.con_detalle "
//                + "INNER JOIN contabilidad.con_cuentas ON con_detalle.emp_codigo||con_detalle.cta_codigo "
//                + "= con_cuentas.emp_codigo||con_cuentas.cta_codigo WHERE "
//                + "con_detalle.emp_codigo = ('" + empresa + "') AND con_detalle.tip_codigo "
//                + "= ('" + tipCodigo + "') AND con_detalle.per_codigo = ('" + perCodigo + "') AND "
//                + "con_detalle.con_numero = ('" + numContable + "') ORDER BY con_detalle.det_orden").getResultList());
//
//        return ConversionesContabilidad.convertirListaConDetalle_ListaConDetalleTO(em.
//                createNativeQuery("SELECT * FROM  contabilidad.con_detalle "
//                + "WHERE emp_codigo = ('" + empresa + "') AND tip_codigo = ('" +
//                tipCodigo + "') AND per_codigo = ('" + perCodigo + "') AND con_numero = ('"
//                + numContable + "') ORDER BY det_orden").getResultList());
    }

    @Override
    public Boolean buscarConDetallesActivosBiologicos(String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT count(cta_activo_biologico) "
                + "FROM contabilidad.con_cuentas_especiales "
                + "WHERE cta_empresa = '" + empresa + "';").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    @Override
    public List<contabilidad.TO.ConFunBalanceResultadosNecTO> getConFunBalanceResultadosNecTO(
            String empresa, String sector, String fechaDesde, String fechaHasta, Integer columnasEstadosFinancieros, Boolean ocultarDetalle) throws Exception {
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        if (columnasEstadosFinancieros == 0) {
            return ConversionesContabilidad.convertirConFunBalanceResultadosNec_ConFunBalanceResultadosNecTOs(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_resultados_nec"
                    + "('" + empresa + "', " + sector + ", " + fechaDesde + ", " + fechaHasta + ");").
                    getResultList());
        } else {
            return ConversionesContabilidad.convertirConFunBalanceResultadosNec_ConFunBalanceResultadosNecTOs(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_resultados"
                    + "('" + empresa + "', " + sector + ", " + fechaDesde + ", " + fechaHasta + ", " + ocultarDetalle + " );").
                    getResultList());
        }
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadoTO> getConFunBalanceFlujoEfectivo(String empresa, String sector, String fechaDesde, String fechaHasta) throws Exception {
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesContabilidad.convertirListaConBalanceResultado_ListaConBalanceResultadoTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_flujo_efectivo"
                + "('" + empresa + "', " + sector + ", " + fechaDesde + ", " + fechaHasta + ");").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConFunBalanceGeneralNecTO> getConFunBalanceGeneralNecTO(String empresa,
            String sector, String fecha, Boolean ocultar, Boolean ocultarDetalle, Integer columnasEstadosFinancieros) throws Exception {
        fecha = fecha == null ? fecha : "'" + fecha + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        if (columnasEstadosFinancieros == 0) {
            return ConversionesContabilidad.convertirConFunBalanceGeneralNec_ConFunBalanceGeneralNecTOs(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_general_nec"
                    + "('" + empresa + "', " + sector + ", " + fecha + ", " + ocultar + ")").
                    getResultList());
        } else {
            return ConversionesContabilidad.convertirConFunBalanceGeneralNec_ConFunBalanceGeneralNecTOs(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_general"
                    + "('" + empresa + "', " + sector + ", " + fecha + ", " + ocultar + ", " + ocultarDetalle + ")").
                    getResultList());
        }
    }

    @Override
    public List<contabilidad.TO.ConBalanceGeneralTO> getFunBalanceGeneralTO(String empresa,
            String secCodigo, String fecha, Boolean ocultar) throws Exception {
        fecha = fecha == null ? fecha : "'" + fecha + "'";
        return ConversionesContabilidad.convertirListaConBalanceGeneral_ListaConBalanceGeneralTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_general"
                + "('" + empresa + "', " + secCodigo + ", " + fecha + ", " + ocultar + ")").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConBalanceGeneralTO> getFunCuentasSobregiradasTO(String empresa,
            String secCodigo, String fecha) throws Exception {
        fecha = fecha == null ? fecha : "'" + fecha + "'";
        return ConversionesContabilidad.convertirListaConBalanceGeneral_ListaConBalanceGeneralTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_cuentas_sobregiradas"
                + "('" + empresa + "', " + secCodigo + ", " + fecha + ")").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConBalanceGeneralComparativoTO> getFunBalanceGeneralComparativoTO(String empresa,
            String secCodigo, String fechaAnterior, String fechaActual, Boolean ocultar) throws Exception {
        return ConversionesContabilidad.convertirListaConBalanceGeneralComparativo_ListaConBalanceGeneralComparativoTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_general_comparativo"
                + "('" + empresa + "', " + secCodigo + ", '" + fechaAnterior + "', '" + fechaActual + "', " + ocultar + ")").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConBalanceComprobacionTO> getListaBalanceComprobacionTO(String empresa, String codigoSector,
            String fechaInicio, String fechaFin, Boolean ocultarDetalle) throws Exception {
        fechaInicio = fechaInicio == null ? fechaInicio : "'" + fechaInicio + "'";
        fechaFin = fechaFin == null ? fechaFin : "'" + fechaFin + "'";
        return ConversionesContabilidad.convertirListaConBalanceComprobacion_ListaConBalanceComprobacionTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_comprobacion"
                + "('" + empresa + "', " + codigoSector + ", " + fechaInicio + ", " + fechaFin + ", " + ocultarDetalle + " )").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConBalanceResultadoTO> getListaBalanceResultadoTO(String empresa, String codigoSector, String fechaInicio, String fechaFin, Boolean ocultarDetalle) throws Exception {
        fechaInicio = fechaInicio == null ? fechaInicio : "'" + fechaInicio + "'";
        fechaFin = fechaFin == null ? fechaFin : "'" + fechaFin + "'";
        return ConversionesContabilidad.convertirListaConBalanceResultado_ListaConBalanceResultadoTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_resultados"
                + "('" + empresa + "', " + codigoSector + ", " + fechaInicio + ", " + fechaFin + " ," + ocultarDetalle + " )").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConMayorAuxiliarTO> getListaMayorAuxiliarTO(String empresa, String codigoCuenta, String fechaInicio, String fechaFin, String sector) throws Exception {
        fechaInicio = fechaInicio == null ? fechaInicio : "'" + fechaInicio + "'";
        fechaFin = fechaFin == null ? fechaFin : "'" + fechaFin + "'";
        return ConversionesContabilidad.convertirListaConMayorAuxiliar_ListaConMayorAuxiliarTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_mayor_auxiliar"
                + "('" + empresa + "', '" + codigoCuenta + "', " + sector + ", " + fechaInicio + ", " + fechaFin + ")").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConMayorGeneralTO> getListaMayorGeneralTO(String empresa, String codigoSector, String codigoCuenta, String fechaFin) throws Exception {
        fechaFin = fechaFin == null ? fechaFin : "'" + fechaFin + "'";
        return ConversionesContabilidad.convertirListaConMayorGeneral_ListaConMayorGeneralTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_mayor_general"
                + "('" + empresa + "', " + codigoSector + ", '" + codigoCuenta + "', " + fechaFin + ")").
                getResultList());
    }

    @Override
    public List<contabilidad.TO.ConDiarioAuxiliarTO> getListaDiarioAuxiliarTO(String empresa, String codigoTipo, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio == null ? fechaInicio : "'" + fechaInicio + "'";
        fechaFin = fechaFin == null ? fechaFin : "'" + fechaFin + "'";
        return ConversionesContabilidad.convertirListaConDiarioAuxiliar_ListaDiarioAuxiliarTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_libro_diario("
                + "'" + empresa + "', '" + codigoTipo + "', " + fechaInicio + ", " + fechaFin + ")").
                getResultList());
    }

    @Override
    public String buscarTipoContablePorMotivoCompra(String empresa, String codigoMotivo) throws Exception {
        String retorno = "";

        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT tip_codigo "
                + "FROM inventario.inv_compras_motivo where cm_empresa = ('" + empresa + "') "
                + "AND cm_codigo = ('" + codigoMotivo + "')").getResultList(), 0);

        if (array != null) {
            retorno = array[0].toString().trim();
        } else {
            retorno = "";
        }


        return retorno;
    }

    @Override
    public String buscarTipoContablePorMotivoVenta(String empresa, String codigoMotivo) throws Exception {
        String retorno = "";

        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT tip_codigo "
                + "FROM inventario.inv_ventas_motivo where vm_empresa = ('" + empresa + "') "
                + "AND vm_codigo = ('" + codigoMotivo + "')").getResultList(), 0);

        if (array != null) {
            retorno = array[0].toString().trim();
        } else {
            retorno = "";
        }


        return retorno;
    }

    @Override
    public java.util.List<contabilidad.TO.ConNumeracionTO> getListaConNumeracionTO(String empresa, String periodo, String tipo) throws Exception {
        return contabilidad.helper.ConversionesContabilidad.convertirListaConNumeracion_ListaConNumeracionTO(em.createNativeQuery("SELECT * FROM contabilidad.con_numeracion "
                + "WHERE (num_empresa = '" + empresa + "') "
                + "AND CASE WHEN ('" + periodo + "') = '' THEN TRUE ELSE (num_periodo = '" + periodo + "') END "
                + "AND CASE WHEN ('" + tipo + "') = '' THEN TRUE ELSE num_tipo = ('" + tipo + "') END").getResultList());
    }

    // <editor-fold defaultstate="collapsed" desc="CONSULTAS">
    @Override
    public java.util.List<contabilidad.TO.ConListaBalanceResultadosVsInventarioTO> getConListaBalanceResultadosVsInventarioTO(String empresa, String desde, String hasta, String sector) throws Exception {
        desde = desde.isEmpty() ? null : desde;
        hasta = hasta.isEmpty() ? null : hasta;
//        sector = sector == null ? null : "'" + sector + "'";
        return contabilidad.helper.ConversionesContabilidad.convertirConListaBalanceResultadosVsInventario_ConListaBalanceResultadosVsInventarioTO(em.createNativeQuery(
                "SELECT * FROM contabilidad.fun_balance_resultados_vs_inventario("
                + "'" + empresa + "', "
                + "" + sector + ", "
                + "'" + desde + "', "
                + "'" + hasta + "')").getResultList());
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> getBalanceResultadoMensualizado(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        return contabilidad.helper.ConversionesContabilidad.convertirConListaBalanceResultadoMensualizado_ConListaBalanceResultadoMensualizado(em.createNativeQuery(
                "SELECT * FROM contabilidad.fun_balance_resultados_mensualizado("//'UT', 'IN', '2011-05-01', current_date) where br_cuenta = '410101001' order by br_cuenta"
                + "'" + empresa + "', "
                + "" + codigoSector + ", "
                + "" + fechaInicio + ", "
                + "" + fechaFin + ")").getResultList());
//                "SELECT * FROM contabilidad.fun_balance_resultados_vs_inventario("
//                + "'" + empresa + "', "
//                + "'" + desde + "', "
//                + "'" + hasta + "')").getResultList());
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesTO> getFunContablesVerificacionesTO(String empresa) throws Exception {
        return contabilidad.helper.ConversionesContabilidad.convertirConFunContablesVerificaciones_ConFunContablesVerificacionesTO(em.createNativeQuery(
                "SELECT * FROM contabilidad.fun_contables_verificaciones('" + empresa + "')").getResultList());
    }
    // </editor-fold>

    @Override
    public java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> getFunContabilizarTransferencias(String empresa, String codigoSector, String fechaInicio, String fechaFin, String parametro) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        if (parametro.trim().equals("DIRECTO")) //            return contabilidad.helper.ConversionesContabilidad.
        //                    convertirConFunContabilizarTransferenciasTO_ConFunContabilizarTransferenciasTO(em.createNativeQuery(
        //                "SELECT * FROM contabilidad.fun_contabilizar_transferencia_ipp('" + empresa + "',"
        //                    + ""+ codigoSector + ", " + fechaInicio + ", " + fechaFin + ")").getResultList());
        {
            return contabilidad.helper.ConversionesContabilidad.convertirConFunContabilizarTransferenciasTO_ConFunContabilizarTransferenciasTO(em.createNativeQuery(
                    "SELECT * FROM contabilidad.fun_contabilizar_ipp_material_directo('" + empresa + "',"
                    + "" + codigoSector + ", " + fechaInicio + ", " + fechaFin + ")").getResultList());
        } else {
            return contabilidad.helper.ConversionesContabilidad.convertirConFunContabilizarTransferenciasTO_ConFunContabilizarTransferenciasTO(em.createNativeQuery(
                    "SELECT * FROM contabilidad.fun_contabilizar_ipp_material_indirecto('" + empresa + "',"
                    + "" + codigoSector + ", " + fechaInicio + ", " + fechaFin + ")").getResultList());
        }
    }

    @Override
    public List<contabilidad.TO.ConDetalleTO> getConDetalleTO(String empresa,
            String perCodigo, String tipCodigo, String numContable) throws Exception {

        return ConversionesContabilidad.convertirConDetalle_ConDetalleTO(em.createNativeQuery(""
                + "SELECT "
                + "con_empresa, "
                + "con_periodo, "
                + "con_tipo, "
                + "con_numero, "
                + "det_secuencia, "
                + "cta_codigo, "
                + "sec_codigo, "
                + "pis_sector, "
                + "pis_numero, "
                + "det_documento, "
                + "det_debito_credito, "
                + "det_valor, "
                + "det_generado, "
                + "det_referencia, "
                + "det_observaciones, "
                + "det_orden "
                + "FROM contabilidad.con_detalle WHERE con_empresa = ('" + empresa + "') AND con_tipo "
                + "= ('" + tipCodigo + "') AND con_periodo = ('" + perCodigo + "') AND "
                + "con_numero = ('" + numContable + "') ORDER BY det_orden").getResultList());
    }

    public contabilidad.entity.ConCuentasFlujo buscarCuentasFlujo(String codEmpresa, String codTipo) throws Exception {
        return conCuentasFlujoFacadeLocal.find(new contabilidad.entity.ConCuentasFlujoPK(codEmpresa, codTipo));
    }

    @Override
    public java.util.List<contabilidad.TO.ConBalanceResultadoCierreTO> getfun_balance_resultados_cierre(String empresa, String sector, String fecha) throws Exception {
        return ConversionesContabilidad.convertirConBalanceResultadoCierre_ConBalanceResultadoCierreTO(em.createNativeQuery("SELECT * FROM contabilidad.fun_balance_resultados_cierre('" + empresa + "', '" + sector + "', '" + fecha + "')").getResultList());
    }

    @Override
    public ConCuentas buscarCuentas2(String empresa, String cuenta) throws Exception {

        java.util.List<contabilidad.TO.ConCuentasTO> conCuentasFormaPago = new java.util.ArrayList(ConversionesContabilidad.convertirConCuentas_ConCuentasTO(em.createNativeQuery("SELECT cta_empresa,cta_codigo,cta_detalle,cta_activo,usr_codigo,usr_fecha_inserta"
                + " FROM contabilidad.con_cuentas where cta_empresa = ('" + empresa + "') AND cta_codigo "
                + "= ('" + cuenta + "') ").getResultList()));

        contabilidad.entity.ConCuentasPK conCuentasPK = null;
        conCuentasPK = new contabilidad.entity.ConCuentasPK();
        contabilidad.entity.ConCuentas conCuentas = null;
        conCuentas = new contabilidad.entity.ConCuentas();

        if (conCuentasFormaPago.size() > 0) {
            conCuentasPK.setCtaCodigo(conCuentasFormaPago.get(0).getCuentaCodigo());
            conCuentasPK.setCtaEmpresa(conCuentasFormaPago.get(0).getEmpCodigo());

            conCuentas.setConCuentasPK(conCuentasPK);
            conCuentas.setCtaDetalle(conCuentasFormaPago.get(0).getCuentaDetalle());
            conCuentas.setCtaActivo(conCuentasFormaPago.get(0).getCuentaActivo());
            conCuentas.setUsrEmpresa(conCuentasFormaPago.get(0).getEmpCodigo());
            conCuentas.setUsrCodigo(conCuentasFormaPago.get(0).getUsrInsertaCuenta());
            conCuentas.setUsrFechaInserta(Validacion.fechaString_Date(conCuentasFormaPago.get(0).getUsrFechaInsertaCuenta()));

        }
        return conCuentas;
    }

    @Override
    public java.util.List<contabilidad.TO.ConFunContablesVerificacionesComprasTO> getConFunContablesVerificacionesComprasTOs(String empresa, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        empresa = "'" + empresa + "'";
        return contabilidad.helper.ConversionesContabilidad.convertirConFunContablesVerificacionesCompras_ConFunContablesVerificacionesComprasTO(em.createNativeQuery("SELECT * "
                + "FROM contabilidad.fun_contables_verificaciones_compras( " + empresa + ", " + fechaInicio + ", " + fechaFin + ");").getResultList());
    }
    @Override
    public java.util.List<contabilidad.TO.PersonaTO> getFunPersonaTOs(String empresa, String busquedad) throws Exception {
        busquedad = busquedad.isEmpty() ? null : "'" + busquedad + "'";
        empresa = "'" + empresa + "'";
        return contabilidad.helper.ConversionesContabilidad.convertirFunPerson_FunPersonaTO(em.createNativeQuery(
                "SELECT * FROM fun_personas( " + empresa + ", " + busquedad +");").getResultList());
    }
}
