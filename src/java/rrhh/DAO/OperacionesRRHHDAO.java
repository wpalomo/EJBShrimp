/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.DAO;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rrhh.TO.*;
import rrhh.entity.DAO.*;
import rrhh.entity.*;
import rrhh.helper.ConversionesRRHH;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesRRHHDAO implements OperacionesRRHHDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "EJBShrimpPU")
    EntityManager em;
    @EJB
    RhCategoriaFacadeLocal rhCategoriaFacadeLocal;
    @EJB
    RhEmpleadoFacadeLocal rhEmpleadoFacadeLocal;
    @EJB
    RhFormaPagoFacadeLocal rhFormaPagoFacadeLocal;
    @EJB
    RhFormaPagoBeneficiosSocialesFacadeLocal rhFormaPagoBeneficiosSocialesFacadeLocal;
    @EJB
    RhBonoConceptoFacadeLocal rhBonoConceptoFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhRolFacadeLocal rhRolFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhFormulario107FacadeLocal rhRolRhFormulario107FacadeLocal;
    @EJB
    rrhh.entity.DAO.RhAnticipoMotivoFacadeLocal rhAnticipoMotivoFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhEmpleadoDescuentosFijosFacadeLocal rhEmpleadoDescuentosFijosFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhXiiiSueldoPeriodoFacadeLocal xiiiSueldoPeriodoFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhXivSueldoPeriodoFacadeLocal xivSueldoPeriodoFacadeLocal;
    @EJB
    rrhh.entity.DAO.RhUtilidadesFacadeLocal rhUtilidadesFacadeLocal;
    private boolean comprobar;

    // <editor-fold defaultstate="collapsed" desc="BUSCAR ENTIDADES">
    @Override
    public RhCategoria buscarCategoria(String empCodigo, String catNombre) throws Exception {
        return rhCategoriaFacadeLocal.find(new RhCategoriaPK(empCodigo, catNombre));
    }

    @Override
    public RhEmpleado buscarEmpleado(String empCodigo, String empId) throws Exception {
        return rhEmpleadoFacadeLocal.find(new RhEmpleadoPK(empCodigo, empId));
    }
    //serial

    @Override
    public RhFormaPago buscarFormaPago(Integer fpSecuencia) throws Exception {
        return rhFormaPagoFacadeLocal.find(fpSecuencia);
    }
    //serial

    @Override
    public RhFormaPagoBeneficiosSociales buscarFormaPagoBeneficioSocial(Integer fpSecuencia) throws Exception {
        return rhFormaPagoBeneficiosSocialesFacadeLocal.find(fpSecuencia);
    }
    //serial

    @Override
    public RhBonoConcepto buscarBonoConcepto(Integer bcSecuencia) throws Exception {
        return rhBonoConceptoFacadeLocal.find(bcSecuencia);
    }
    //serial

    @Override
    public rrhh.entity.RhRol buscarRol(Integer secuencial) throws Exception {
        return rhRolFacadeLocal.find(secuencial);
    }
    //serial

    @Override
    public rrhh.entity.RhAnticipoMotivo buscarAnticipoMotivo(String empresa, String detalle) throws Exception {
        return rhAnticipoMotivoFacadeLocal.find(new rrhh.entity.RhAnticipoMotivoPK(empresa, detalle));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CATEGORIA">
    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return RhCtaIessTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCtaIessTO buscarCtaRhIess(String empCodigo, String empId) throws Exception {
        return ConversionesRRHH.convertirCtaRhIess_CtaRhIessTO(em.createNativeQuery("SELECT rh_categoria.cta_aportepersonal, "
                + "rh_empleado.emp_fecha_afiliacion_iess, "
                + "emp_fecha_primer_ingreso, emp_fecha_primera_salida, "
                + "emp_fecha_ultimo_ingreso, emp_fecha_ultima_salida, emp_extension_cobertura_iess "
                + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                + "AND (rh_empleado.emp_id = '" + empId + "')").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param prdCategoriaTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarRhCategoria(RhCategoriaTO rhCategoriaTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("").getResultList(), 0)[0].toString());
//        return Boolean.parseBoolean(((List)em.createNativeQuery("SELECT * FROM "
//                + "produccion.fun_eliminar_produccion('S', '"+prdSectorTO.getEmpCodigo()+
//                "', '"+prdSectorTO.getSecCodigo()+"', null, null)").getResultList().get(0)).
//                get(0).toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return Categoria
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCategoriaTO getCategoria(String empCodigo, String catNombre) throws Exception {
        return ConversionesRRHH.convertirRhCategoria_RhCategoriaTO(em.createNativeQuery("SELECT "
                + "cta_anticipos, "
                + "cta_prestamos, "
                + "cta_por_pagar_bonos, "
                + "cta_por_pagar_sueldo, "
                + "cta_por_pagar_impuesto_renta, "
                + "cta_por_pagar_utilidades, "
                + "cta_gasto_bonos, "
                + "cta_gasto_bonos_nd, "
                + "cta_gasto_bono_fijo, "
                + "cta_gasto_bono_fijo_nd, "
                + "cta_gasto_otros_ingresos, "
                + "cta_gasto_otros_ingresos_nd, "
                + "cta_gasto_sueldos, "
                + "cta_aportepersonal, "
                + "cta_aportepatronal, "
                + "cta_iece, "
                + "cta_secap, "
                + "cta_xiii, "
                + "cta_xiv, "
                + "cta_fondoreserva, "
                + "cta_vacaciones, "
                + "cta_desahucio, "
                + "cta_gasto_aporteindividual, "
                + "cta_gasto_aportepatronal, "
                + "cta_gasto_iece, "
                + "cta_gasto_secap, "
                + "cta_gasto_xiii, "
                + "cta_gasto_xiv, "
                + "cta_gasto_fondoreserva, "
                + "cta_gasto_vacaciones, "
                + "cta_gasto_salario_digno, "
                + "cta_gasto_desahucio, "
                + "cta_gasto_desahucio_intempestivo, "
                + "tip_codigo, "
                + "cta_gasto_liquidacion_bono "
                + "FROM recursoshumanos.rh_categoria "
                + "WHERE (cat_empresa = '" + empCodigo + "') AND (cat_nombre = '" + catNombre + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de CategoriaS
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhComboCategoriaTO> getComboCategoria(String empresa) throws Exception {
        return ConversionesRRHH.convertirComboRhCategoria_ComboRhCategoriaTO(em.createNativeQuery("SELECT cat_nombre "
                + "FROM recursoshumanos.rh_categoria "
                + "WHERE (cat_empresa = '" + empresa + "') ORDER BY cat_nombre;").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPLEADO falta empleado lote">
    @Override
    public String getRhEmpleadoApellidosNombres(String empresa, String id) throws Exception {
        id = id.isEmpty() ? null : "'" + id + "'";
        return validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT emp_apellidos || ' ' || emp_nombres emp_apellidos_nombres "
                + "FROM recursoshumanos.rh_empleado "
                + "WHERE (emp_empresa = '" + empresa + "') "
                + "AND (emp_id = " + id + ");").getResultList(), 0)[0].toString();
    }

    public boolean repetidoRhEmpleado(String empresa, String id, String apellidos, String nombres) throws Exception {
        id = id.isEmpty() ? null : "'" + id + "'";
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT * FROM recursoshumanos.fun_sw_empleado_repetido("
                + "'" + empresa + "', "
                + "" + id + ", "
                + "'" + apellidos + "', "
                + "'" + nombres + "');").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param prdEmpleadoTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarRhEmpleado(RhEmpleadoTO rhEmpleadoTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT * FROM recursoshumanos.fun_sw_elimina_empleado("
                + "'" + rhEmpleadoTO.getEmpCodigo() + "', "
                + "'" + rhEmpleadoTO.getEmpId() + "');").getResultList(), 0)[0].toString());
//        return Boolean.parseBoolean(((List)em.createNativeQuery("SELECT * FROM "
//                + "produccion.fun_eliminar_produccion('S', '"+prdSectorTO.getEmpCodigo()+
//                "', '"+prdSectorTO.getSecCodigo()+"', null, null)").getResultList().get(0)).
//                get(0).toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de Empleados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhEmpleadoTO> getListaEmpleado(String empresa, String buscar, boolean estado) throws Exception {
        return ConversionesRRHH.convertirListaRhEmpleado_ListaRhEmpleadoTO(em.createNativeQuery("SELECT "
                + "emp_residencia_tipo, "
                + "emp_residencia_pais, "
                + "emp_convenio, "
                + "emp_tipo_id, "
                + "emp_id, "
                + "emp_apellidos, "
                + "emp_nombres, "
                + "emp_genero, "
                + "emp_lugar_nacimiento, "
                + "SUBSTRING(emp_fecha_nacimiento::TEXT, 1, 10), "
                + "emp_estado_civil, "
                + "emp_cargas_familiares, "
                + "emp_provincia, "
                + "emp_canton, "
                + "emp_domicilio, "
                + "emp_numero, "
                + "emp_telefono, "
                + "sec_codigo, "
                + "SUBSTRING(emp_fecha_primer_ingreso::TEXT, 1, 10), "
                + "SUBSTRING(emp_fecha_primera_salida::TEXT, 1, 10), "
                + "SUBSTRING(emp_fecha_ultimo_ingreso::TEXT, 1, 10), "
                + "SUBSTRING(emp_fecha_ultima_salida::TEXT, 1, 10), "
                + "emp_motivo_salida, "
                + "SUBSTRING(emp_fecha_afiliacion_iess::TEXT, 1, 10), "
                + "emp_codigo_afiliacion_iess, "
                + "emp_codigo_cargo, "
                + "emp_cargo, "
                + "emp_sueldo_iess, "
                + "emp_forma_pago, "
                + "emp_dias_trabajados, "
                + "emp_dias_descanso, "
                + "emp_bono_fijo, "
                + "emp_bono_fijo_nd, "
                + "emp_cancelar_xiii_sueldo_mensualmente, "
                + "emp_cancelar_xiv_sueldo_mensualmente, "
                + "emp_cancelar_fondo_reserva_mensualmente, "
                + "emp_retencion, "
                + "emp_educacion, "
                + "emp_alimentacion, "
                + "emp_salud, "
                + "emp_vivienda, "
                + "emp_vestuario, "
                + "emp_rebaja_discapacidad, "
                + "emp_rebaja_tercera_edad, "
                + "emp_sueldo_otra_compania, "
                + "emp_otras_deducciones, "
                + "emp_otras_rebajas, "
                + "emp_utilidades, "
                + "emp_otros_ingresos, "
                + "emp_otros_ingresos_nd, "
                + "emp_extension_cobertura_iess, "
                + "emp_observaciones, "
                + "emp_discapacidad_tipo, "
                + "emp_discapacidad_porcentaje, "
                + "emp_discapacidad_id_tipo, "
                + "emp_discapacidad_id_numero, "
                + "emp_banco, "
                + "emp_cuenta_tipo, "
                + "emp_cuenta_numero, "
                + "emp_inactivo, "
                + "cat_nombre, "
                + "emp_salario_neto, "
                + "emp_correo_electronico "
                + "FROM recursoshumanos.rh_empleado "
                + "WHERE CASE WHEN " + estado + " THEN TRUE ELSE emp_inactivo = FALSE END AND "
                + "(emp_empresa = '" + empresa + "') AND "
                + "(emp_id || emp_apellidos || emp_nombres || sec_codigo || "
                + "sec_codigo || emp_nombres || emp_apellidos || emp_id "
                + "LIKE TRANSLATE(' ' || '" + buscar + "' || ' ', ' ', '%')) "
                + "ORDER BY emp_apellidos, emp_nombres;").
                getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de Empleados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaEmpleadoTO> getListaConsultaEmpleado(String empresa, String buscar, Boolean interno, boolean estado) throws Exception {
        if (interno) {
            return ConversionesRRHH.convertirListaConsultaRhEmpleado_ListaConsultaRhEmpleadoTO(em.createNativeQuery("SELECT sec_codigo, emp_id, emp_apellidos || ' ' || emp_nombres emp_apellidos_nombre, "
                    + "emp_cargo, emp_fecha_afiliacion_iess IS NOT NULL, emp_salario_neto, emp_residencia_tipo "
                    + "FROM recursoshumanos.rh_empleado WHERE (emp_empresa = '" + empresa + "') AND "
                    + "(emp_id = '" + buscar + "');").getResultList());
        } else {
            return ConversionesRRHH.convertirListaConsultaRhEmpleado_ListaConsultaRhEmpleadoTO(em.createNativeQuery("SELECT sec_codigo, emp_id, emp_apellidos || ' ' || emp_nombres emp_apellidos_nombre, "
                    + "emp_cargo, emp_fecha_afiliacion_iess IS NOT NULL, emp_salario_neto, emp_residencia_tipo "
                    + "FROM recursoshumanos.rh_empleado WHERE (emp_empresa = '" + empresa + "') AND "
                    + "(emp_id || emp_apellidos || emp_nombres || sec_codigo || "
                    + "sec_codigo || emp_nombres || emp_apellidos || emp_id "
                    + "LIKE TRANSLATE(' ' || '" + buscar + "' || ' ', ' ', '%')) AND "
                    + "CASE WHEN " + estado + " THEN TRUE ELSE emp_inactivo = FALSE END;").getResultList());
        }
    }

    /**
     * @autor misayo
     *
     * @param empCodigo
     * @param empId
     * @return RhEmpleadoRolTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhEmpleadoRolTO getEmpleadoRolTO(String empCodigo, String empId) throws Exception {
        return ConversionesRRHH.convertirRhEmpleado_RhEmpleadoRolTO(em.createNativeQuery("SELECT emp_dias_trabajados, emp_dias_descanso, emp_sueldo_iess, "
                + "emp_retencion, emp_utilidades, emp_sueldo_otra_compania, emp_educacion, "
                + "emp_alimentacion, emp_salud, emp_vivienda, emp_vestuario, cat_nombre "
                + "FROM recursoshumanos.rh_empleado "
                + "WHERE (emp_empresa = '" + empCodigo + "') AND(emp_id = '" + empId + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empCodigo
     * @param empId
     * @return true si esta afiliado
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean getRhEmpleadoAfiliacion(String empCodigo, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT emp_fecha_afiliacion_iess IS NOT NULL afiliado "
                + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                + "WHERE (emp_empresa = '" + empCodigo + "') "
                + "AND(emp_id = '" + empId + "');").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empCodigo
     * @param empId
     * @return true si se aplica retencion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean getRhEmpleadoRetencion(String empCodigo, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT emp_retencion "
                + "FROM recursoshumanos.rh_empleado "
                + "WHERE (emp_empresa = '" + empCodigo + "') "
                + "AND(emp_id = '" + empId + "');").getResultList(), 0)[0].toString());
    }

    /**
     * @autor misayo
     *
     * @param empCodigo
     * @param catNombre
     * @param fechaHasta
     * @return lista de Empleados por Lote
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaEmpleadoLoteTO> getListaEmpleadoLote(
            String empCodigo,
            String catNombre,
            String sector,
            String fechaHasta,
            String motivo) throws Exception {
        catNombre = catNombre == null ? null : catNombre.isEmpty() ? null : "'" + catNombre + "'";
        sector = sector == null ? null : sector.isEmpty() ? null : "'" + sector + "'";
        motivo = motivo == null ? null : motivo.isEmpty() ? null : "'" + motivo + "'";
        return ConversionesRRHH.convertirListaConsultaRhEmpleadoLote_ListaConsultaRhEmpleadoLoteTO(em.createNativeQuery(
                "SELECT * "
                + "FROM recursoshumanos.fun_plantilla_descuentosfijos_anticipos_y_bonos_por_lote("
                + "'" + empCodigo + "', "
                + "'" + fechaHasta + "', "
                + "" + catNombre + ", "
                + "" + sector + ", "
                + "" + motivo + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empCodigo
     * @param fechaDesde
     * @param fechaHasta
     * @param categoria
     * @param sector
     * @return lista de Empleados por Lote
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhFunPlantillaSueldosLoteTO> getFunPlantillaSueldosLote(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        categoria = categoria == null ? null : categoria.isEmpty() ? null : "'" + categoria + "'";
        sector = sector == null ? null : sector.isEmpty() ? null : "'" + sector + "'";
        return ConversionesRRHH.convertirRhFunPlantillaSueldosLote_RhFunPlantillaSueldosLoteTO(em.createNativeQuery(
                "SELECT * "
                + "FROM recursoshumanos.fun_plantilla_sueldos_lote("
                + "'" + empCodigo + "', "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "', "
                + "" + categoria + ", "
                + "" + sector + ");").getResultList());
    }

    @Override
    public List<RhFunPlantillaSueldosLotePreliminarTO> getFunPlantillaSueldosLotePreliminar(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String categoria,
            String sector) throws Exception {
        categoria = categoria == null ? null : categoria.isEmpty() ? null : "'" + categoria + "'";
        sector = sector == null ? null : sector.isEmpty() ? null : "'" + sector + "'";
        String sql = "SELECT * "
                + "FROM recursoshumanos.fun_plantilla_sueldos_lote("
                + "'" + empCodigo + "', "
                + "'" + fechaDesde + "', "
                + "'" + fechaHasta + "', "
                + "" + categoria + ", "
                + "" + sector + ");";
        return ConversionesRRHH.convertirRhFunPlantillaSueldosLotePreliminar_RhFunPlantillaSueldosLotePreliminarTO(em.createNativeQuery(
                sql).getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param fechaDesde
     * @param fechaHasta
     * @param categoria
     * @param sector
     * @return lista de Empleados por Lote
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhFunPlantillaRolesTO> getRhFunPlantillaRolesTO(String empresa, String fechaDesde, String fechaHasta, String categoria, String sector) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        return ConversionesRRHH.convertirRhFunPlantillaRoles_RhFunPlantillaRolesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_plantilla_roles("
                + empresa + ", "
                + fechaDesde + ", "
                + fechaHasta + ", "
                + categoria + ", "
                + sector + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param provincia
     * @param canton
     * @param sector
     * @param categoria
     * @return lista de RhFunListadoEmpleadosTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<RhFunListadoEmpleadosTO> getRhFunListadoEmpleadosTO(String empresa, String provincia, String canton, String sector, String categoria, boolean estado) throws Exception {
        provincia = provincia == null ? provincia : "'" + provincia + "'";
        canton = canton == null ? canton : "'" + canton + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        categoria = categoria == null ? categoria : "'" + categoria + "'";
        return rrhh.helper.ConversionesRRHH.convertirRhFunListadoEmpleados_RhFunListadoEmpleadosTO(
                em.createNativeQuery("SELECT * FROM recursoshumanos.fun_listado_empleados('"
                + empresa + "', "
                + provincia + ", "
                + canton + ", "
                + sector + ", "
                + categoria + ") "
                + "WHERE CASE WHEN " + estado + " THEN TRUE ELSE emp_inactivo = FALSE END;").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGO">
    @Override
    public Boolean buscarRhFormaPago(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM recursoshumanos.rh_forma_pago "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de FormaPagos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaFormaPagoTO> getListaFormaPago(String empresa) throws Exception {
        return ConversionesRRHH.convertirListaRhFormaPago_ListaRhFormaPagoTO(em.createNativeQuery("SELECT cta_codigo, fp_secuencial, fp_detalle, "
                + "sec_codigo, fp_inactivo FROM recursoshumanos.rh_forma_pago "
                + "WHERE (cta_empresa = '" + empresa + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de FormaPagos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhComboFormaPagoTO> getComboFormaPago(String empresa) throws Exception {
        return ConversionesRRHH.convertirRhComboFormaPago_RhComboFormaPagoTO(em.createNativeQuery("SELECT sec_codigo || ' | ' || fp_detalle fp_detalle, "
                + "rh_forma_pago.cta_codigo, ban_cuenta.cta_empresa IS NOT NULL validar "
                + "FROM recursoshumanos.rh_forma_pago LEFT JOIN banco.ban_cuenta ON "
                + "rh_forma_pago.cta_empresa = ban_cuenta.cta_empresa AND "
                + "rh_forma_pago.cta_codigo = ban_cuenta.cta_cuenta_contable "
                + "WHERE rh_forma_pago.cta_empresa = '" + empresa + "' AND NOT fp_inactivo ORDER "
                + "BY sec_codigo, fp_detalle").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String secFormasPago
     * @return rhCtaFormaPagoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCtaFormaPagoTO buscarCtaRhFormaPago(String empCodigo, String fpDetalle) throws Exception {
        String sql = "SELECT cta_codigo, sec_codigo "
                + "FROM recursoshumanos.rh_forma_pago "
                + "WHERE (fp_detalle = '" + fpDetalle + "') "
                + "AND (cta_empresa = '" + empCodigo + "') "
                + "AND (NOT fp_inactivo)";
        return ConversionesRRHH.convertirRhCtaFormaPago_RhCtaFormaPagoTO(em.createNativeQuery(sql).getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String secFormasPago
     * @return rhCtaFormaPagoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCtaFormaPagoTO buscarCtaRhAnticipoMotivo(String empCodigo, String fpDetalle) throws Exception {
        return ConversionesRRHH.convertirRhCtaFormaPago_RhCtaFormaPagoTO(em.createNativeQuery("SELECT cta_codigo, sec_codigo "
                + "FROM recursoshumanos.rh_anticipo_motivo "
                + "WHERE (mot_detalle = '" + fpDetalle + "') "
                + "AND (cta_empresa = '" + empCodigo + "') "
                + "AND (NOT mot_inactivo)").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMAPAGOBENEFICIOSOCIAL">
    @Override
    public Boolean buscarRhFormaPagoBeneficioSocial(String ctaContable, String empresa) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COUNT(*) "
                + "FROM recursoshumanos.rh_forma_pago_beneficios_sociales "
                + "WHERE (cta_codigo = '" + ctaContable + "') AND (cta_empresa = '" + empresa + "');").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de FormaPagos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaFormaPagoBeneficioSocialTO> getListaFormaPagoBeneficioSocial(String empresa) throws Exception {
        return ConversionesRRHH.convertirListaRhFormaPagoBeneficioSocial_ListaRhFormaPagoBeneficioSocialTO(em.createNativeQuery("SELECT cta_codigo, fp_secuencial, fp_detalle, "
                + "fp_codigo_ministerial, sec_codigo, fp_inactivo "
                + "FROM recursoshumanos.rh_forma_pago_beneficios_sociales "
                + "WHERE (cta_empresa = '" + empresa + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de FormaPagos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhComboFormaPagoBeneficioSocialTO> getComboFormaPagoBeneficioSocial(String empresa) throws Exception {
        return ConversionesRRHH.convertirRhComboFormaPagoBeneficioSocial_RhComboFormaPagoBeneficioSocialTO(em.createNativeQuery("SELECT fp_detalle, sec_codigo, fp_codigo_ministerial "
                + "FROM recursoshumanos.rh_forma_pago_beneficios_sociales "
                + "WHERE (cta_empresa = '" + empresa + "') "
                + "AND (NOT fp_inactivo)").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String secFormasPago
     * @return rhCtaFormaPagoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCtaFormaPagoBeneficioSocialTO buscarCtaRhFormaPagoBeneficioSocial(String empCodigo, String fpDetalle) throws Exception {
        return ConversionesRRHH.convertirRhCtaFormaPagoBeneficioSocial_RhCtaFormaPagoBeneficioSocialTO(em.createNativeQuery("SELECT cta_codigo, sec_codigo, fp_codigo_ministerial "
                + "FROM recursoshumanos.rh_forma_pago_beneficios_sociales "
                + "WHERE (fp_detalle = '" + fpDetalle + "') "
                + "AND (cta_empresa = '" + empCodigo + "') "
                + "AND (NOT fp_inactivo)").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhAnticipoTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhAnticipoTO> getRhAnticipo(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhAnticipo_RhAnticipoTO(
                em.createNativeQuery("SELECT ant_secuencial, ant_valor, ant_forma_pago, "
                + "ant_reversado, emp_id, sec_codigo "
                + "FROM recursoshumanos.rh_anticipo "
                + "WHERE rh_anticipo.emp_empresa = '" + empresa + "' "
                + "AND rh_anticipo.con_periodo = '" + periodo + "' "
                + "AND rh_anticipo.con_tipo = 'C-ANT' "
                + "AND rh_anticipo.con_numero = '" + numero + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta anticipo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhAnticipo(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_anticipos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhPrestamoTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhPrestamoTO> getRhPrestamo(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhPrestamo_RhPrestamoTO(
                em.createNativeQuery("SELECT pre_secuencial, pre_valor, pre_numero_pagos, "
                + "pre_forma_pago, pre_reversado, emp_id, sec_codigo "
                + "FROM recursoshumanos.rh_prestamo "
                + "WHERE rh_prestamo.emp_empresa = '" + empresa + "' "
                + "AND rh_prestamo.con_periodo = '" + periodo + "' "
                + "AND rh_prestamo.con_tipo = 'C-PRE' "
                + "AND rh_prestamo.con_numero = '" + numero + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta prestamo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPrestamo(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_prestamos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhVacacionesTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhVacacionesTO> getRhVacaciones(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhVacaciones_RhVacacionesTO(
                em.createNativeQuery("SELECT vac_secuencial, vac_desde, vac_hasta, "
                + "vac_valor, vac_forma_pago, vac_reversado, emp_id, sec_codigo, "
                + "vac_gozadas, vac_gozadas_desde, vac_gozadas_hasta "
                + "FROM recursoshumanos.rh_vacaciones "
                + "WHERE rh_vacaciones.emp_empresa = '" + empresa + "' "
                + "AND rh_vacaciones.con_periodo = '" + periodo + "' "
                + "AND rh_vacaciones.con_tipo = 'C-VAC' "
                + "AND rh_vacaciones.con_numero = '" + numero + "';").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhViaticoTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhViaticoTO> getRhViatico(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhViatico_RhViaticoTO(
                em.createNativeQuery("via_secuencial, via_valor, via_reversado, "
                + "emp_id, sec_codigo "
                + "FROM recursoshumanos.rh_viatico "
                + "WHERE rh_viatico.emp_empresa = '" + empresa + "' "
                + "AND rh_viatico.con_periodo = '" + periodo + "' "
                + "AND rh_viatico.con_tipo = 'C-VIA' "
                + "AND rh_viatico.con_numero = '" + numero + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto viatico
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoViaticos(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_viaticos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta por pagar viatico
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPorPagarViaticos(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_por_pagar_viaticos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta por impuesto renta
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPorPagarImpuestoRenta(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_por_pagar_impuesto_renta "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta por impuesto renta
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPorPagarUtilidades(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_por_pagar_utilidades "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO CONCEPTO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhAnticipoTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhBonoTO> getRhBono(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhBono_RhBonoTO(
                em.createNativeQuery("SELECT bono_secuencial, bono_concepto, "
                + "bono_cantidad, bono_precio, bono_valor, bono_deducible, "
                + "bono_observacion, bono_reversado, emp_id, "
                + "sec_codigo, pis_numero "
                + "FROM recursoshumanos.rh_bono "
                + "WHERE rh_bono.emp_empresa = '" + empresa + "' "
                + "AND rh_bono.con_periodo = '" + periodo + "' "
                + "AND rh_bono.con_tipo = 'C-BON' "
                + "AND rh_bono.con_numero = '" + numero + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param prdBonoConceptoTO Objeto TO
     * @return false si esta relacionado con otras tablas
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarRhBonoConcepto(RhBonoConceptoTO rhBonoConceptoTO) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("").getResultList(), 0)[0].toString());
//        return Boolean.parseBoolean(((List)em.createNativeQuery("SELECT * FROM "
//                + "produccion.fun_eliminar_produccion('S', '"+prdSectorTO.getEmpCodigo()+
//                "', '"+prdSectorTO.getSecCodigo()+"', null, null)").getResultList().get(0)).
//                get(0).toString());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de BonoConceptos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaBonoConceptoTO> getListaBonoConcepto(String empresa) throws Exception {
        return ConversionesRRHH.convertirListaRhBonoConcepto_ListaRhBonoConceptoTO(em.createNativeQuery("SELECT bc_secuencial, bc_detalle, "
                + "bc_valor, bc_valor_fijo, bc_inactivo "
                + "FROM recursoshumanos.rh_bono_concepto "
                + "WHERE (usr_empresa = '" + empresa + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @return lista de BonoConceptos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhComboBonoConceptoTO> getComboBonoConcepto(String empresa) throws Exception {
        return ConversionesRRHH.convertirRhComboBonoConcepto_RhComboBonoConceptoTO(em.createNativeQuery("SELECT bc_detalle, bc_valor, bc_valor_fijo "
                + "FROM recursoshumanos.rh_bono_concepto "
                + "WHERE (usr_empresa = '" + empresa + "') "
                + "AND (NOT bc_inactivo)").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta por pagar bono
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPorPagarBonos(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_por_pagar_bonos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto bono fijo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoBonoFijo(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_bono_fijo "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto bono fijo nd
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoBonoFijoND(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_bono_fijo_nd "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto OtrosIngresos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoOtrosIngresos(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_otros_ingresos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto OtrosIngresos nd
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoOtrosIngresosND(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_otros_ingresos_nd "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto no deducible
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoBonosND(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_bonos_nd "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta GastoBono
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoBonos(String empCodigo, String empId) throws Exception {
        try {
            //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_bonos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ROL">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhAnticipoTO>
     * @throws Exception Cualquier error inesperado
     */
    public List<rrhh.TO.RhRolBDTO> getRhRol(String empresa, String periodo, String numero) throws Exception {
        return ConversionesRRHH.convertirRhRol_RhRolBDTO(
                em.createNativeQuery("SELECT rol_secuencial, rol_desde, "
                + "rol_hasta, rol_fecha_ultimo_sueldo, rol_dias_laborados_reales, "
                + "rol_dias_faltas_reales, rol_dias_extras_reales, "
                + "rol_dias_descanso_reales, rol_dias_pagados_reales, "
                + "rol_dias_permiso_medico, rol_saldo_anterior, rol_ingresos, "
                + "rol_bonos, rol_bonosnd, rol_bono_fijo, rol_bono_fijo_nd, "
                + "rol_otros_ingresos, rol_otros_ingresos_nd, rol_viaticos, "
                + "rol_liq_fondo_reserva, rol_liq_xiii, rol_liq_xiv, "
                + "rol_liq_vacaciones, rol_liq_salario_digno, rol_liq_desahucio, "
                + "rol_liq_desahucio_intempestivo, rol_liq_bonificacion, rol_anticipos, rol_prestamos, "
                + "rol_iess, rol_retencion_fuente, rol_descuento_permiso_medico, "
                + "rol_total, rol_forma_pago, rol_aporte_patronal, rol_iece, "
                + "rol_secap, rol_xiii, rol_xiv, rol_fondo_reserva, "
                + "rol_vacaciones, rol_desahucio, rol_reversado, emp_id, "
                + "emp_cargo, emp_sueldo, emp_bono_fijo, emp_bono_fijo_nd, "
                + "emp_otros_ingresos, emp_otros_ingresos_nd, emp_dias_laborados, "
                + "emp_dias_descanso, emp_cancelar_xiii_sueldo_mensualmente, "
                + "emp_cancelar_xiv_sueldo_mensualmente, "
                + "emp_cancelar_fondo_reserva_mensualmente, sec_codigo, "
                + "con_provision_periodo, con_provision_tipo, con_provision_numero "
                + "FROM recursoshumanos.rh_rol "
                + "WHERE rh_rol.emp_empresa = '" + empresa + "' "
                + "AND rh_rol.con_periodo = '" + periodo + "' "
                + "AND rh_rol.con_tipo = 'C-ROL' "
                + "AND rh_rol.con_numero = '" + numero + "';").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String catNombre
     * @return tipo detalle de categoria para el contable
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCategoriaTipo(String empCodigo, String empId, String catNombre) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery("SELECT rh_categoria.tip_codigo "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "') "
                    + "AND (rh_empleado.cat_nombre = '" + catNombre + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @param String fechaHasta
     * @param Integer diasLaborados
     * @param java.math.BigDecimal rolIngresos
     * @return valorImpuestoRenta
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.math.BigDecimal getRhValorImpuestoRenta(String empCodigo, String empId, String fechaHasta, Integer diasLaborados, java.math.BigDecimal rolIngresos) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        try {
            return java.math.BigDecimal.valueOf(Double.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_calcula_ir('" + empCodigo + "', "
                    + "'" + empId + "', '" + fechaHasta + "', " + diasLaborados + ", " + rolIngresos + ");").getResultList(), 0)[0].toString()));
        } catch (Exception e) {
            return null;
        }
//        return valorImpuestoRenta;
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta por pagar sueldo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhPorPagarSueldos(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_por_pagar_sueldo "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto sueldo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoSueldos(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_sueldos "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor pconza
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta salario neto
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhSalarioNeto(String empCodigo, String empId) throws Exception {
        try {
            System.out.println("SELECT rh_categoria.cta_gasto_aporteindividual "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')");
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_aporteindividual "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gastoXiii
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoXiii(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_xiii "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gastoXiii
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoXiv(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_xiv "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta fondoReserva
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhFondoReserva(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_fondoreserva "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    public String buscarCtaRhLiquidacionBonificacion(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_liquidacion_bono "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta fondoReserva
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoFondoReserva(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_fondoreserva "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta xiii
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhXiii(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_xiii "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String categoria
     * @return codigo de cuenta xiii
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhXiiiCategoria(String empresa, String categoria) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_xiii "
                    + "FROM recursoshumanos.rh_categoria "
                    + "WHERE (rh_categoria.cat_empresa = '" + empresa + "') "
                    + "AND (rh_categoria.cat_nombre = '" + categoria + "');").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta xiv
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhXiv(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_xiv "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String categoria
     * @return codigo de cuenta xiv
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhXivCategoria(String empresa, String categoria) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_xiv "
                    + "FROM recursoshumanos.rh_categoria "
                    + "WHERE (rh_categoria.cat_empresa = '" + empresa + "') "
                    + "AND (rh_categoria.cat_nombre = '" + categoria + "');").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta vacaciones
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhVacaciones(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_vacaciones "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String buscarCtaRhSalarioDigno(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_salario_digno "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta gasto salario digno
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoSalarioDigno(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_salario_digno "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta desahucio
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhDesahucio(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_desahucio "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta desahucio Intempestivo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarCtaRhGastoDesahucioIntempestivo(String empCodigo, String empId) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_categoria.cta_gasto_desahucio_intempestivo "
                    + "FROM recursoshumanos.rh_empleado INNER JOIN recursoshumanos.rh_categoria "
                    + "ON (rh_empleado.cat_empresa || rh_empleado.cat_nombre) = "
                    + "(rh_categoria.cat_empresa || rh_categoria.cat_nombre) "
                    + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_empleado.emp_id = '" + empId + "')").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return fechaUltimoSueldo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarFechaRhRol(String empCodigo, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        Object ultimoSueldo = null;
        String fechaUltimoSueldo = "";
        try {
            ultimoSueldo = (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT rh_rol.rol_hasta fecha_ultimo_sueldo "
                    + "FROM recursoshumanos.rh_rol INNER JOIN contabilidad.con_contable "
                    + "ON rh_rol.con_empresa = con_contable.con_empresa AND "
                    + "rh_rol.con_periodo = con_contable.con_periodo AND "
                    + "rh_rol.con_tipo = con_contable.con_tipo AND "
                    + "rh_rol.con_numero = con_contable.con_numero "
                    + "WHERE (rh_rol.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_rol.emp_id = '" + empId + "') "
                    + "AND (NOT con_contable.con_anulado)  AND (NOT rol_reversado)"
                    + "ORDER BY rh_rol.rol_hasta DESC LIMIT 1;").getResultList(), 0)[0]);
        } catch (Exception e) {
            ultimoSueldo = null;
        }
        ultimoSueldo = ultimoSueldo == null ? "" : ultimoSueldo;
        if (!ultimoSueldo.equals("")) {
            //licenciado
            java.util.List<String> fecha = validaciones.Validacion.separar(ultimoSueldo.toString(), "-");
//            fecha.set(2, (fecha.get(1).equals("12") && fecha.get(2).equals("31")) ? "30" : fecha.get(2));
            fechaUltimoSueldo = fecha.get(0) + "-" + fecha.get(1) + "-" + fecha.get(2);
        }
        return fechaUltimoSueldo;
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return fechaUltimaVacaciones
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String buscarFechaRhVacaciones(String empCodigo, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        Object fechaUltimaVacaciones = null;
        try {
            fechaUltimaVacaciones = (validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery("SELECT rh_vacaciones.vac_hasta fecha_ultimo_sueldo "
                    + "FROM recursoshumanos.rh_vacaciones INNER JOIN contabilidad.con_contable "
                    + "ON rh_vacaciones.con_empresa = con_contable.con_empresa AND "
                    + "rh_vacaciones.con_periodo = con_contable.con_periodo AND "
                    + "rh_vacaciones.con_tipo = con_contable.con_tipo AND "
                    + "rh_vacaciones.con_numero = con_contable.con_numero "
                    + "WHERE (rh_vacaciones.emp_empresa = '" + empCodigo + "') "
                    + "AND (rh_vacaciones.emp_id = '" + empId + "') "
                    + "AND (NOT con_contable.con_anulado AND NOT vac_reversado) "
                    + "ORDER BY rh_vacaciones.vac_hasta DESC LIMIT 1;").getResultList(), 0)[0]);
        } catch (Exception e) {
            fechaUltimaVacaciones = null;
        }
        fechaUltimaVacaciones = fechaUltimaVacaciones == null ? "" : fechaUltimaVacaciones;
        return fechaUltimaVacaciones.toString();
    }

    /**
     * @autor Misayo
     *
     * @param empresa
     * @param empleadoId
     * @return true acumulaFondoReserva, false noAcumulaFondoReserva
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhCancelarBeneficioSocialTO getRhCancelarBeneficioSocialTO(String empresa, String empleadoId) throws Exception {
        try {
            return ConversionesRRHH.convertirRhCancelarBeneficioSocial_RhCancelarBeneficioSocialTO(em.createNativeQuery("SELECT "
                    + "emp_cancelar_xiii_sueldo_mensualmente, "
                    + "emp_cancelar_xiv_sueldo_mensualmente, "
                    + "emp_cancelar_fondo_reserva_mensualmente "
                    + "FROM recursoshumanos.rh_empleado "
                    + "WHERE (emp_empresa = '" + empresa + "') AND (emp_id = '" + empleadoId + "');").getResultList());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return RhRolSueldoEmpleadoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhRolSueldoEmpleadoTO getRhRolSueldoEmpleado(String empCodigo, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        RhRolSueldoEmpleadoTO rhRolSueldoEmpleadoTO = ConversionesRRHH.convertirRhRolSueldoEmpleado_RhRolSueldoEmpleadoTO(em.createNativeQuery("SELECT rh_empleado.emp_cargo, rh_empleado.emp_forma_pago, "
                + "rh_empleado.emp_sueldo_iess, "
                + "CASE WHEN con_contable.con_anulado OR rol_reversado THEN (null) ELSE rh_rol.rol_hasta END fecha_ultimo_sueldo "
                + "FROM recursoshumanos.rh_rol "
                + "RIGHT JOIN recursoshumanos.rh_empleado "
                + "ON rh_rol.emp_empresa = rh_empleado.emp_empresa AND rh_rol.emp_id = rh_empleado.emp_id "
                + "LEFT JOIN contabilidad.con_contable "
                + "ON rh_rol.con_empresa = con_contable.con_empresa AND "
                + "rh_rol.con_periodo = con_contable.con_periodo AND "
                + "rh_rol.con_tipo = con_contable.con_tipo AND "
                + "rh_rol.con_numero = con_contable.con_numero "
                + "WHERE (rh_empleado.emp_empresa = '" + empCodigo + "') AND (rh_empleado.emp_id='" + empId + "') "
                + "GROUP BY rh_empleado.emp_cargo, rh_empleado.emp_sueldo_iess, rh_empleado.emp_forma_pago, "
                + "rh_rol.rol_hasta, con_contable.con_anulado, rol_reversado, con_contable.usr_fecha_inserta "
                + "ORDER BY rh_rol.rol_hasta DESC LIMIT 1;").getResultList());
//                + "ORDER BY con_contable.usr_fecha_inserta_contable DESC LIMIT 1;").getResultList());
        if (rhRolSueldoEmpleadoTO != null) {
            rhRolSueldoEmpleadoTO.setRolFechaUltimoSueldo(buscarFechaRhRol(empCodigo, empId));
        }
        return rhRolSueldoEmpleadoTO;
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @param String fechaDesde
     * @param String fechaHasta
     * @return RhRolSaldoEmpleadoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhRolSaldoEmpleadoTO getRhRolSaldoEmpleado(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhRolSaldoEmpleado_RhRolSaldoEmpleadoTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_empleado('" + empCodigo + "', "
                + "'" + empId + "', 'T', '" + fechaDesde + "', '" + fechaHasta + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @param String fechaDesde
     * @param String fechaHasta
     * @return lista de RhListaRolSaldoEmpleadoDetalladoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetallado(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
//    public List<RhListaRolSaldoEmpleadoDetalladoTO> getRhRolSaldoEmpleadoDetallado(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception{
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhRolSaldoEmpleadoDetallado_RhRolSaldoEmpleadoDetalladoTO(em. //                SELECT * FROM recursoshumanos.fun_saldo_empleado_detallado('UT', '0704478817', 'T', '2010-11-01'::date,'2010-12-31'::date);
                createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_empleado_detallado('" + empCodigo + "', "
                + "'" + empId + "', 'T', '" + fechaDesde + "', '" + fechaHasta + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @param String fechaDesde
     * @param String fechaHasta
     * @return saldoPrestamo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.math.BigDecimal getRhRolSaldoPrestamo(String empCodigo, String empId, String fechaDesde, String fechaHasta) throws Exception {
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        java.math.BigDecimal saldoPrestamo = null;
        saldoPrestamo = java.math.BigDecimal.valueOf(Double.valueOf(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT COALESCE(saldo_prestamo, 0) FROM recursoshumanos.fun_saldo_empleado('" + empCodigo + "', "
                + "'" + empId + "', 'P', " + fechaDesde + ", " + fechaHasta + ");").getResultList(), 0)[0].toString()));
        return saldoPrestamo;
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ANULACIONES">
    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String periodo
     * @param String tipo
     * @param String numero
     * @return RhAnulacionesTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhAnulacionesTO> getRhAnulacionesTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        periodo = periodo == null ? null : "'" + periodo + "'";
        tipo = tipo == null ? null : "'" + tipo + "'";
        numero = numero == null ? null : "'" + numero + "'";
        return ConversionesRRHH.convertirRhAnulaciones_RhAnulacionesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_anulaciones("
                + "'" + empresa + "', "
                + "" + periodo + ", "
                + "" + tipo + ", "
                + "" + numero + ");").getResultList());
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DETALLES">
    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetalleAnticiposTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleAnticiposTO> getRhDetalleAnticiposTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId, String formaPago) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        formaPago = formaPago.isEmpty() ? null : "'" + formaPago + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhDetalleAnticipos_DetalleAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_anticipos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ", " + formaPago + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String periodo
     * @param String tipo
     * @param String numero
     * @return RhListaDetalleAnticiposLoteTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleAnticiposLoteTO> getRhDetalleAnticiposLoteTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhListaDetalleAnticiposLote_RhListaDetalleAnticiposLoteTO(em.createNativeQuery("SELECT dal_fecha, dal_id, dal_nombres, dal_valor, "
                + "dal_forma_pago_detalle, dal_documento, dal_observaciones "
                + "FROM recursoshumanos.fun_detalle_anticipos_por_lote("
                + "'" + empresa + "', "
                + "'" + periodo + "', "
                + "'" + tipo + "', "
                + "'" + numero + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String periodo
     * @param String tipo
     * @param String numero
     * @return RhListaDetalleAnticiposLoteTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleBonosLoteTO> getRhDetalleBonosLoteTO(String empresa, String periodo, String tipo, String numero) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhListaDetalleBonosLote_RhListaDetalleBonosLoteTO(em.createNativeQuery("SELECT dbl_fecha, dbl_id, dbl_nombres, dbl_valor, "
                + "dbl_forma_pago_detalle, dbl_documento, dbl_observaciones "
                + "FROM recursoshumanos.fun_detalle_bonos_por_lote("
                + "'" + empresa + "', "
                + "'" + periodo + "', "
                + "'" + tipo + "', "
                + "'" + numero + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetalleAnticiposPrestamosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleAnticiposPrestamosTO> getRhDetalleAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhDetalleAnticiposPrestamos_DetalleAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_anticipos_prestamos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetallePrestamosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetallePrestamosTO> getRhDetallePrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhDetallePrestamos_DetallePrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_prestamos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetalleBonosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleBonosTO> getRhDetalleBonosTO(
            String empCodigo,
            String fechaDesde,
            String fechaHasta,
            String empCategoria,
            String empId,
            String estadoDeducible) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        String condicion = "";
        if (estadoDeducible.equals("TODOS")) {
            condicion = ";";
        } else {
            if (estadoDeducible.equals("DEDUCIBLE")) {
                condicion = "WHERE db_deducible;";
            } else {
                condicion = "WHERE NOT db_deducible;";
            }
        }
        return ConversionesRRHH.convertirRhDetalleBonos_DetalleBonosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_bonos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ")" + condicion).getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetalleViaticosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleViaticosTO> getRhDetalleViaticosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhDetalleViaticos_DetalleViaticosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_viaticos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaDetalleRolesTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaDetalleRolesTO> getRhDetalleRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        sector = sector.isEmpty() ? null : "'" + sector + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhDetalleRoles_DetalleRolesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_detalle_roles('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + sector + ", " + empCategoria + ", " + empId + ");").getResultList());
    }

    @Override
    public List<RhDetalleVacionesPagadasGozadasTO> getRhDetalleVacacionesPagadasGozadasTO(String empCodigo, String empId, String sector, String fechaDesde, String fechaHasta, String tipo) throws Exception {

        empId = empId.isEmpty() ? null : "'" + empId + "'";
        sector = sector.isEmpty() ? null : "'" + sector + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";

        String pFechaDesde = null, pFechaHasta = null, gFechaDesde = null, gFechaHasta = null;
        if ("P".equals(tipo)) {
            pFechaDesde = fechaDesde;
            pFechaHasta = fechaHasta;
            gFechaDesde = null;
            gFechaHasta = null;
        }
        if ("G".equals(tipo)) {
            pFechaDesde = null;
            pFechaHasta = null;
            gFechaDesde = fechaDesde;
            gFechaHasta = fechaHasta;
        }
        return ConversionesRRHH.convertirRhDetalleVacionesPagadasGozadas_DetalleVacionesPagadasGozadasTO(em.createNativeQuery("SELECT * from recursoshumanos.fun_detalle_vacaciones(" + empCodigo + ", "
                + "" + sector + ", " + empId + ", " + pFechaDesde + ", " + pFechaHasta + ", " + gFechaDesde + ", " + gFechaHasta + ");").getResultList());

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONSOLIDADOS">
    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaConsolidadoAnticiposPrestamosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaConsolidadoAnticiposPrestamosTO> getRhConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empCategoria, String empId) throws Exception {
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhConsolidadoAnticiposPrestamos_ConsolidadoAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_consolidado_anticipos_prestamos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + empCategoria + ", " + empId + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaConsolidadoBonosViaticosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaConsolidadoBonosViaticosTO> getRhConsolidadoBonosViaticosTO(String empCodigo, String fechaDesde, String fechaHasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhConsolidadoBonosViaticos_ConsolidadoBonosViaticosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_consolidado_bonos_viaticos('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String sector
     * @param String empCategoria
     * @param String empId
     * @return RhListaConsolidadoRolesTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaConsolidadoRolesTO> getRhConsolidadoRolesTO(String empCodigo, String fechaDesde, String fechaHasta, String sector, String empCategoria, String empId) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        empCategoria = empCategoria.isEmpty() ? null : "'" + empCategoria + "'";
        empId = empId.isEmpty() ? null : "'" + empId + "'";
        sector = sector.isEmpty() ? null : "'" + sector + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        String sql = "SELECT * FROM recursoshumanos.fun_consolidado_roles('" + empCodigo + "', "
                + "" + fechaDesde + ", " + fechaHasta + ", " + sector + ", " + empCategoria + ", " + empId + ");";
        return ConversionesRRHH.convertirRhConsolidadoRoles_ConsolidadoRolesTO(em.createNativeQuery(sql).getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALDOS CONSOLIDADOS">
    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empCategoria
     * @param String empId
     * @return RhListaSaldoConsolidadoAnticiposPrestamosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaSaldoConsolidadoAnticiposPrestamosTO> getRhSaldoConsolidadoAnticiposPrestamosTO(String empCodigo, String fechaHasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhSaldoConsolidadoAnticiposPrestamos_SaldoConsolidadoAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_consolidado_anticipos_prestamos('" + empCodigo + "', "
                + "" + fechaHasta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaHasta
     * @return RhListaSaldoConsolidadoBonosViaticosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaSaldoConsolidadoBonosViaticosTO> getRhSaldoConsolidadoBonosViaticosTO(String empCodigo, String fechaHasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhSaldoConsolidadoBonosViaticos_SaldoConsolidadoBonosViaticosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_consolidado_bonos_viaticos('" + empCodigo + "', "
                + "" + fechaHasta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaHasta
     * @return RhListaSaldoConsolidadoSueldosPorPagarTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaSaldoConsolidadoSueldosPorPagarTO> getRhSaldoConsolidadoSueldosPorPagarTO(String empCodigo, String fechaHasta) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return ConversionesRRHH.convertirRhSaldoConsolidadoSueldosPorPagar_SaldoConsolidadoSueldosPorPagarTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_consolidado_sueldos_por_pagar('" + empCodigo + "', "
                + "" + fechaHasta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String fechaDesde
     * @param String fechaHasta
     * @param String empId
     * @return RhListaSaldoIndividualAnticiposPrestamosTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaSaldoIndividualAnticiposPrestamosTO> getRhSaldoIndividualAnticiposPrestamosTO(String empCodigo, String fechaDesde, String fechaHasta, String empId, String tipo) throws Exception {
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        if (tipo.equals("PRESTAMOS")) //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        {

            return ConversionesRRHH.convertirRhSaldoIndividualAnticiposPrestamos_SaldoIndividualAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_individual_anticipos_prestamos('" + empCodigo + "', "
                    + "" + fechaDesde + ", " + fechaHasta + ", '" + empId + "', '" + tipo + "');").getResultList());
        } else if (tipo.equals("ANTICIPOS")) //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        {

            return ConversionesRRHH.convertirRhSaldoIndividualAnticiposPrestamos_SaldoIndividualAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_individual_anticipos_prestamos('" + empCodigo + "', "
                    + "" + fechaDesde + ", " + fechaHasta + ", '" + empId + "', '" + tipo + "');").getResultList());
        } else //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        {

            return ConversionesRRHH.convertirRhSaldoIndividualAnticiposPrestamos_SaldoIndividualAnticiposPrestamosTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_saldo_individual_anticipos_prestamos('" + empCodigo + "', "
                    + "" + fechaDesde + ", " + fechaHasta + ", '" + empId + "', 'AMBOS');").getResultList());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROVISIONES">
    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String periodo
     * @param String sector
     * @param String status
     * @return RhListaProvisionesTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaProvisionesTO> getRhListaProvisionesTO(String empresa, String periodo, java.lang.String sector, String status) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhListaProvisiones_RhListaProvisionesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_provisiones("
                + "'" + empresa + "', "
                + "'" + periodo + "', "
                + "'" + sector + "', "
                + "'" + status + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String periodo
     * @param String tipo
     * @param String numero
     * @return RhListaProvisionesTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhListaProvisionesTO> getRhListaProvisionesComprobanteContableTO(String empresa, String periodo, java.lang.String tipo, String numero) throws Exception {
        //se convierte la consulta nativeQuery en un List para obtener la posicion 0,0
        return ConversionesRRHH.convertirRhListaProvisiones_RhListaProvisionesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_provisiones_por_comprobante_contable("
                + "'" + empresa + "', "
                + "'" + periodo + "', "
                + "'" + tipo + "', "
                + "'" + numero + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param String empresa
     * @param String categoria
     * @return rhCategoriaProvisionesTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public rrhh.TO.RhCategoriaProvisionesTO getRhCategoriaProvisionesTO(String empresa, String categoria) throws Exception {
        try {
            return ConversionesRRHH.convertirRhCategoriaProvisionesTO_RhCategoriaProvisionesTO(em.createNativeQuery("SELECT cta_aportepatronal, cta_iece, cta_secap, "
                    + "cta_xiii, cta_xiv, cta_fondoreserva, cta_vacaciones, cta_desahucio, "
                    + "cta_gasto_aportepatronal, cta_gasto_iece, cta_gasto_secap, "
                    + "cta_gasto_xiii, cta_gasto_xiv, cta_gasto_fondoreserva, "
                    + "cta_gasto_vacaciones, cta_gasto_desahucio "
                    + "FROM recursoshumanos.rh_categoria "
                    + "WHERE (cat_empresa = '" + empresa + "') AND "
                    + "(cat_nombre = '" + categoria + "');").getResultList());
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PARAMETROS">
    /**
     * @autor misayo
     *
     * @param String fechaHasta
     * @return RhParametros
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhParametrosTO getRhParametros(String fechaHasta) throws Exception {
        return ConversionesRRHH.convertirRhParametros_RhParametrosTO(em.createNativeQuery("SELECT par_iess_porcentaje_aporte_individual, "
                + "par_iess_porcentaje_aporte_patronal, par_iess_porcentaje_iece, "
                + "par_iess_porcentaje_secap, par_salario_minimo_vital, par_iess_porcentaje_aporte_extendido "
                + "FROM recursoshumanos.rh_parametros "
                + "WHERE (par_desde <= '" + fechaHasta + "' and par_hasta >= '" + fechaHasta + "') OR "
                + "(par_desde <= '" + fechaHasta + "' and par_hasta IS NULL)").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIII">
    /**
     * @autor misayo
     *
     * @return lista de RhXiiiSueldoPeriodoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhXiiiSueldoPeriodoTO> getRhComboXiiiSueldoPeriodoTO() throws Exception {
        return ConversionesRRHH.convertirRhXiiiSueldoPeriodo_RhXiiiSueldoPeriodoTO(em.createNativeQuery("SELECT xiii_descripcion, xiii_desde, xiii_hasta, xiii_fecha_maxima_pago, xiii_secuencial "
                + "FROM recursoshumanos.rh_xiii_sueldo_periodo;").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param descripcion
     * @return lista de RhXiiiSueldoPeriodoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhXiiiSueldoPeriodoTO buscarRhXiiiSueldoPeriodoTO(String descripcion) throws Exception {
        descripcion = descripcion == null ? descripcion : "'" + descripcion + "'";
        return ConversionesRRHH.convertirRhXIIISueldoPeriodo_RhXIIISueldoPeriodoTO(em.createNativeQuery("SELECT xiii_descripcion, xiii_desde, xiii_hasta, xiii_fecha_maxima_pago "
                + "FROM recursoshumanos.rh_xiii_sueldo_periodo "
                + "WHERE (xiii_descripcion = " + descripcion + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param desde
     * @param hasta
     * @return lista de RhFunXiiiSueldoCalcularTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhFunXiiiSueldoCalcularTO> getRhFunCalcularXiiiSueldo(String empresa, String sector, String desde, String hasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesRRHH.convertirRhFunCalcularXiiiSueldo_RhFunCalcularXiiiSueldoTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_xiii_sueldo_calcular("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param desde
     * @param hasta
     * @return lista de RhFunXiiiSueldoConsultarTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhFunXiiiSueldoConsultarTO> getRhFunConsultarXiiiSueldo(String empresa, String sector, String desde, String hasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesRRHH.convertirRhFunConsultarXiiiSueldo_RhFunConsultarXiiiSueldoTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_xiii_sueldo_consultar("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ");").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIV">
    /**
     * @autor misayo
     *
     * @return lista de RhXivSueldoPeriodoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhXivSueldoPeriodoTO> getRhComboXivSueldoPeriodoTO() throws Exception {
        return ConversionesRRHH.convertirRhXIVSueldoPeriodo_RhXIVSueldoPeriodoTO(em.createNativeQuery("SELECT xiv_descripcion, xiv_desde, xiv_hasta, xiv_fecha_maxima_pago,xiv_secuencial "
                + "FROM recursoshumanos.rh_xiv_sueldo_periodo;").getResultList());
    }

    @Override
    public List<RhUtilidadesPeriodoTO> getRhComboUtilidadesPeriodoTO(java.lang.String empresa) throws Exception {
        return ConversionesRRHH.convertirRhUtilidadesPeriodo_RhUtilidadesPeriodoTO(em.createNativeQuery("SELECT uti_descripcion, uti_desde, uti_hasta, uti_fecha_maxima_pago, uti_total_dias, uti_total_cargas, uti_total_pagar, uti_empresa "
                + "FROM recursoshumanos.rh_utilidades_periodo where (uti_empresa = '" + empresa + "');").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param descripcion
     * @return lista de RhXivSueldoPeriodoTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public RhXivSueldoPeriodoTO buscarRhXivSueldoPeriodoTO(String descripcion) throws Exception {
        descripcion = descripcion == null ? descripcion : "'" + descripcion + "'";
        return ConversionesRRHH.convertirRhXivSueldoPeriodo_RhXivSueldoPeriodoTO(em.createNativeQuery("SELECT xiv_descripcion, xiv_desde, xiv_hasta, xiv_fecha_maxima_pago "
                + "FROM recursoshumanos.rh_xiv_sueldo_periodo "
                + "WHERE (xiv_descripcion = " + descripcion + ");").getResultList());
    }

    @Override
    public RhUtilidadesPeriodoTO buscarRhUtilidadesPeriodoTO(String descripcion) throws Exception {
        descripcion = descripcion == null ? descripcion : "'" + descripcion + "'";
        return ConversionesRRHH.convertirRHUtilidadesPeriodo_RHUtilidadesPeriodoTO(em.createNativeQuery("SELECT uti_descripcion, uti_desde, uti_hasta, uti_fecha_maxima_pago "
                + "FROM recursoshumanos.rh_utilidades_periodo "
                + "WHERE (uti_descripcion = " + descripcion + ");").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param sector
     * @param desde
     * @param hasta
     * @return lista de RhFunXivSueldoCalcularTO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<RhFunXivSueldoCalcularTO> getRhFunCalcularXivSueldo(String empresa, String sector, String desde, String hasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesRRHH.convertirRhFunCalcularXivSueldo_RhFunCalcularXivSueldoTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_xiv_sueldo_calcular("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ");").getResultList());
    }

    @Override
    public List<RhFunUtilidadesCalcularTO> getRhFunCalcularUtilidades(String empresa, String sector, String desde, String hasta, Integer totalDias, Integer totalCargas, BigDecimal totalPagar) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";

        return ConversionesRRHH.convertirRhFunCalculartUilidades_RhFunCalcularUtilidadesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_utilidades_calcular("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ", "
                + totalDias + ", "
                + totalCargas + ", "
                + totalPagar + ");").getResultList());
    }
//    /**
//     * @autor misayo
//     * @param empresa
//     * @param sector
//     * @param desde
//     * @param hasta
//     * @return lista de RhFunXivSueldoConsultarTO
//     * @throws Exception Cualquier error inesperado
//     */

    @Override
    public List<RhFunXivSueldoConsultarTO> getRhFunConsultarXivSueldo(String empresa, String sector, String desde, String hasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesRRHH.convertirRhFunConsultarXivSueldo_RhFunConsultarXivSueldoTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_xiv_sueldo_consultar("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ");").getResultList());
    }

    @Override
    public List<RhFunUtilidadesConsultarTO> getRhFunConsultarUtilidades(String empresa, String sector, String desde, String hasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        sector = sector == null ? sector : "'" + sector + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        return ConversionesRRHH.convertirRhFunConsultarUtilidades_RhFunConsultarUtilidadesTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_xiv_sueldo_consultar("
                + empresa + ", "
                + sector + ", "
                + desde + ", "
                + hasta + ");").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param desde Una fecha
     * <code>desde</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param hasta Una fecha
     * <code>hasta</code> con formato
     * <code>yyyy-MM-dd</code>
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107ConsultaTO(String empresa, String desde, String hasta, String empleadoID) throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirRhFormulario107_RhFormulario107TO(em.createNativeQuery("SELECT * "
                + "FROM recursoshumanos.fun_formulario_107('" + empresa + "', '" + desde + "', '" + hasta + "', '" + empleadoID + "')").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param anio El año del ejercicio fiscal
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser llenado en el formulario en el lado
     * del cliente para poder ser impreso
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.TO.RhFormulario107TO getRhFormulario107TO(String empresa, String anio, String empleadoID) throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirRhFormulario107_RhFormulario107TO(rhRolRhFormulario107FacadeLocal.find(new rrhh.entity.RhFormulario107PK(empresa, anio, empleadoID)));
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param anio El año del ejercicio fiscal
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser manipulado en el lado del servidor
     * @throws Exception Cualquier error inesperado
     */
    public rrhh.entity.RhFormulario107 getRhFormulario107(String empresa, String anio, String empleadoID) throws Exception {
        return rhRolRhFormulario107FacadeLocal.find(new rrhh.entity.RhFormulario107PK(empresa, anio, empleadoID));
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa La empresa
     * @param anio El año del ejercicio fiscal
     * @param empleadoID La cedula o pasaporte del empleado a consultar
     * @return Datos del empleado para ser manipulado en el lado del servidor
     * @throws Exception Cualquier error inesperado
     */
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Recalculo IR">
    /**
     *
     * @param valor El valor sobre el cual se va a recalcular el IR (impuesto a
     * la renta)
     * @param desde La fecha desde del periodo fiscal
     * @param hasta La fecha desde del periodo fiscal
     * @return un BigDecimal con el valor recalculado del IR
     * @throws Exception Cualquier error inesperado
     */
    public java.math.BigDecimal getValorRecalculadoIR(java.math.BigDecimal valor, String desde, String hasta) throws Exception {
        return new java.math.BigDecimal(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * "
                + "FROM recursoshumanos.fun_calcular_ir(" + valor + ", '" + desde + "', '" + hasta + "')").getResultList(), 0)[0].toString());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PERIODO FISCAL FORMULARIO 107">
    /**
     * @autor Jack Krauser
     *
     * @return Periodo Fiscal en forma de Lista para un combo
     * @throws Exception Cualquier error inesperado
     */
    public java.util.List<rrhh.TO.RhFormulario107PeriodoFiscalTO> getRhFormulario107PeriodoFiscalComboTO() throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirRhFormulario107PeriodoFiscalCombo_RhFormulario107PeriodoFiscalComboTO(em.createNativeQuery("SELECT * FROM recursoshumanos."
                + "rh_formulario_107_periodo").getResultList());
    }
    // </editor-fold>

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Xiiis Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXiiis(String empresa, String fecha, String cuenta) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preaviso_xiii_sueldo('" + empresa + "', '" + fecha + "', '" + cuenta + "')").getResultList());
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoXivs(String empresa, String fecha, String cuenta) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preaviso_xiv_sueldo('" + empresa + "', '" + fecha + "', '" + cuenta + "')").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Anticipos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoAnticipos(
            String empresa,
            String fecha,
            String cuenta,
            String tipoPreAviso,
            String servicio) throws Exception {
        //String sql = '';
        String sql = "";
        if (tipoPreAviso.equals("ANTICIPOS")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_anticipos('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("PRESTAMO")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_prestamos('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("SUELDO")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_sueldos('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("XIII_SUELDO")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_xiii_sueldo('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("XIV_SUELDO")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_xiv_sueldo('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("VACACIONES")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_vacaciones('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        if (tipoPreAviso.equals("UTILIDADES")) {
            sql = "SELECT * FROM recursoshumanos.fun_preaviso_vacaciones('" + empresa + "', '" + fecha + "', '" + cuenta + "', '" + servicio + "')";
        }
        System.out.println("sql: "+sql);
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery(sql).getResultList());

    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoPichinchaTO> getRhFunPreavisoAnticiposPichincha(String empresa, String fecha, String cuenta, String tipo) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticiposPichincha_RhPreavisoAnticiposPichinchaTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preavisos_pichincha_internacional('" + empresa + "', '" + fecha + "','" + cuenta + "', '" + tipo + "')").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Prestamos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoPrestamos(String empresa, String fecha, String cuenta) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preaviso_prestamos('" + empresa + "', '" + fecha + "', '" + cuenta + "')").getResultList());
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa
     * @return lista de Sueldos Preavisados
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoSueldos(String empresa, String fecha, String cuenta) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preaviso_sueldos('" + empresa + "', '" + fecha + "', '" + cuenta + "')").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @return lista RhFunFormulario107TO
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107TO> getRhFunFormulario107(String empresa, String desde, String hasta, Character status) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";
        String condicion = "";
        if (status == 'T') {
            condicion = "WHERE TRUE";
        }
        if (status == 'A') {
            condicion = "WHERE NOT f107_empleado_inactivo";
        }
        if (status == 'I') {
            condicion = "WHERE f107_empleado_inactivo";
        }
        return ConversionesRRHH.convertirRhFunFormulario107_RhFunFormulario107TO(em.createNativeQuery(
                "SELECT f107_id, f107_nombres, f107_sueldo, f107_bonos, "
                + "f107_xiii_sueldo, f107_xiv_sueldo, f107_fondo_reserva, "
                + "f107_salario_digno, f107_utilidades, f107_desahucio, "
                + "f107_iess, f107_vivienda, f107_salud, f107_educacion, "
                + "f107_alimentacion, f107_vestuario, f107_rebaja_discapacitado, "
                + "f107_rebaja_tercera_edad, f107_subtotal, f107_meses_trabajados, "
                + "f107_otros_ingresos, f107_otras_deducciones, f107_otras_rebajas, "
                + "f107_base_imponible, f107_impuesto_causado, f107_valor_retenido, "
                + "f107_numero_retenciones, f107_empleado_inactivo "
                + "FROM recursoshumanos.fun_formulario_107(" + empresa + ", " + desde + ", " + hasta + ", null)"
                + " " + condicion + ";").getResultList());
    }

    /**
     * @autor charly
     *
     * @param empresa
     * @param desde
     * @param hasta
     * @return lista RhFunFormulario107_2013
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public java.util.List<rrhh.TO.RhFunFormulario107_2013TO> getRhFunFormulario107_2013(String empresa, String desde, String hasta, Character status) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        desde = desde == null ? desde : "'" + desde + "'";
        hasta = hasta == null ? hasta : "'" + hasta + "'";

        String condicion = "";
        if (status == 'T') {
            condicion = "WHERE TRUE";
        }
        if (status == 'A') {
            condicion = "WHERE NOT f107_empleado_inactivo";
        }
        if (status == 'I') {
            condicion = "WHERE f107_empleado_inactivo";
        }
        return ConversionesRRHH.convertirRhFunFormulario107_2013_RhFunFormulario107_2013TO(em.createNativeQuery(
                "SELECT f107_tipo ,f107_id ,f107_apellidos ,f107_nombres ,f107_establecimiento ,f107_residencia_tipo ,f107_residencia_pais ,"
                + "f107_convenio ,f107_discapacidad_tipo ,f107_discapacidad_porcentaje ,f107_discapacidad_id_tipo ,f107_discapacidad_id_numero ,"
                + "f107_sueldo ,f107_bonos ,f107_utilidades ,f107_sueldo_otros_empleadores ,f107_impuesto_asumido ,f107_xiii_sueldo ,"
                + "f107_xiv_sueldo ,f107_fondo_reserva ,f107_salario_digno ,f107_desahucio ,f107_subtotal  ,f107_salario_neto ,f107_iess ,"
                + "f107_iess_otros_empleadores ,f107_vivienda ,f107_salud ,f107_educacion ,f107_alimentacion ,f107_vestuario ,f107_rebaja_discapacitado ,"
                + "f107_rebaja_tercera_edad ,f107_base_imponible ,f107_impuesto_causado ,f107_impuesto_asumido_otros_empleadores ,"
                + "f107_impuesto_asumido_este_empleador ,f107_valor_retenido ,f107_empleado_inactivo  "
                + "FROM recursoshumanos.fun_formulario_107_2013(" + empresa + ", " + desde + ", " + hasta + ", null)"
                + " " + condicion + ";").getResultList());
    }

    /**
     * @autor misayo
     *
     * @param empresa
     * @param empleado
     * @return true or false
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean getSwInactivaEmpleado(String empresa, String empleado) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT * FROM recursoshumanos.fun_sw_inactiva_empleado("
                + "'" + empresa + "', '" + empleado + "');").getResultList(), 0)[0].toString());
    }

    @Override
    public java.util.List<rrhh.TO.RhPreavisoAnticiposPrestamosSueldoTO> getRhFunPreavisoVacaciones(String empresa, String fecha, String cuenta) throws Exception {
        return ConversionesRRHH.convertirRhPreavisoAnticipos_RhPreavisoAnticiposTO(em.createNativeQuery("SELECT * FROM recursoshumanos.fun_preaviso_vacaciones('" + empresa + "', '" + fecha + "', '" + cuenta + "')").getResultList());
    }

    @Override
    public java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> getConsolidadoIngresosTabulado(String empresa, String codigoSector, String fechaInicio, String fechaFin) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        return ConversionesRRHH.convertirRhConsolidadoIngresosTabulado_RhConsolidadoIngresosTabuladoTO(em.createNativeQuery(
                "SELECT * FROM recursoshumanos.fun_consolidado_ingresos_tabulado("//'UT', 'IN', '2011-05-01', current_date) where br_cuenta = '410101001' order by br_cuenta"
                + "'" + empresa + "', "
                + "" + codigoSector + ", "
                + "" + fechaInicio + ", "
                + "" + fechaFin + ")").getResultList());
    }

    @Override
    public rrhh.entity.RhEmpleadoDescuentosFijos getRhEmpleadoDescuentosFijos(Integer secuencial) throws Exception {
        return rhEmpleadoDescuentosFijosFacadeLocal.find(secuencial);
    }

    @Override
    public java.util.List<rrhh.TO.RhEmpleadoDescuentosFijosTO> getRhEmpleadoDescuentosFijosTO(String empresa, String empresaID) throws Exception {
        java.util.List<rrhh.TO.RhEmpleadoDescuentosFijosTO> descuentosFijosTOs = rrhh.helper.ConversionesRRHH.convertirRhEmpleadoDescuentosFijos_RhEmpleadoDescuentosFijosTO(
                em.createNativeQuery("SELECT * FROM recursoshumanos.rh_empleado_descuentos_fijos WHERE recursoshumanos.rh_empleado_descuentos_fijos.emp_empresa = '" + empresa + "' AND "
                + " recursoshumanos.rh_empleado_descuentos_fijos.emp_id = '" + empresaID + "'").getResultList());
        return descuentosFijosTOs;
    }

    @Override
    public java.util.List<rrhh.entity.RhEmpleadoDescuentosFijos> getRhEmpleadoDescuentosFijos(String empresa, String empresaID) throws Exception {
        java.util.List<rrhh.entity.RhEmpleadoDescuentosFijos> rhEmpleadoDescuentosFijos = em.createQuery("SELECT a FROM RhEmpleadoDescuentosFijos a WHERE "
                + "a.rhEmpleado.rhEmpleadoPK.empEmpresa = :empresa AND a.rhEmpleado.rhEmpleadoPK.empId = :empID ORDER BY a.descSecuencial").
                setParameter("empresa", empresa).setParameter("empId", empresaID).getResultList();
        return rhEmpleadoDescuentosFijos;
    }

    public java.util.List<rrhh.TO.RhProvisionFechasTO> getProvisionPorFechas(String empresa, String codigoSector, String fechaInicio, String fechaFin, String agrupacion) throws Exception {
        fechaInicio = fechaInicio.isEmpty() ? null : "'" + fechaInicio + "'";
        fechaFin = fechaFin.isEmpty() ? null : "'" + fechaFin + "'";
        codigoSector = codigoSector.isEmpty() ? null : "'" + codigoSector + "'";
        agrupacion = agrupacion.isEmpty() ? null : "'" + agrupacion + "'";
        return ConversionesRRHH.convertirRhProvisionFechas_RhProvisionFechasTO(em.createNativeQuery(
                "SELECT * FROM recursoshumanos.fun_provision_por_fechas("//'UT', 'IN', '2011-05-01', current_date) where br_cuenta = '410101001' order by br_cuenta"
                + "'" + empresa + "', "
                + "" + codigoSector + ", "
                + "" + fechaInicio + ", "
                + "" + fechaFin + ", "
                + "" + agrupacion + ")").getResultList());

    }

    public Boolean buscarRhAnticipoMotivo(String empresa, String detalle) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery(
                "SELECT COUNT(*) "
                + "FROM recursoshumanos.rh_anticipo_motivo "
                + "WHERE (mot_empresa = '" + empresa + "') AND (mot_detalle = '" + detalle + "');").
                getResultList(), 0)[0].toString()) == 1 ? true : false;
    }

    public Boolean comprobarEliminarRhAnticipoMotivo(String empresa, String detalle) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT recursoshumanos.fun_sw_elimina_motivo_descuento_fijo("
                + "'" + empresa + "', '" + detalle + "');").
                getResultList(), 0)[0].toString());
    }

    public rrhh.TO.RhAnticipoMotivoTO getRhAnticipoMotivoTO(String empresa, String detalle) throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirRhAnticipoMotivo_RhAnticipoMotivoTO(rhAnticipoMotivoFacadeLocal.find(new rrhh.entity.RhAnticipoMotivoPK(empresa, detalle)));
    }

    public rrhh.entity.RhAnticipoMotivo getRhAnticipoMotivo(String empresa, String codigo) throws Exception {
        return rhAnticipoMotivoFacadeLocal.find(new rrhh.entity.RhAnticipoMotivoPK(empresa, codigo));
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTablaTO(String empresa) throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirListaRhAnticipoMotivo_ListaRhAnticipoMotivoTablaTO(
                em.createNativeQuery(
                "SELECT mot_empresa, mot_detalle, mot_inactivo, sec_codigo, cta_codigo, usr_empresa, usr_codigo, usr_fecha_inserta "
                + "FROM recursoshumanos.rh_anticipo_motivo "
                + "WHERE mot_empresa = ('" + empresa + "') ORDER BY mot_detalle").
                getResultList());
    }

    public List<RhAnticipoMotivoTO> getListaRhAnticipoMotivoTOTablaTO(String empresa, String codigo) throws Exception {
        return rrhh.helper.ConversionesRRHH.convertirListaRhAnticipoMotivo_ListaRhAnticipoMotivoTablaTO(
                em.createNativeQuery("SELECT * FROM recursoshumanos.rh_anticipo_motivo "
                + "WHERE mot_empresa = ('" + empresa + "') AND mot_detalle LIKE '%" + codigo + "%' ORDER BY mot_detalle").
                getResultList());
    }
    /*
     * @Override public RhXiiiSueldoPeriodoTO buscarRhXiiiSueldoPeriodoTO(String
     * descripcion) throws Exception{ descripcion = descripcion == null ?
     * descripcion : "'"+descripcion+"'"; return
     * ConversionesRRHH.convertirRhXIIISueldoPeriodo_RhXIIISueldoPeriodoTO(em.
     * createNativeQuery("SELECT xiii_descripcion, xiii_desde, xiii_hasta,
     * xiii_fecha_maxima_pago " + "FROM recursoshumanos.rh_xiii_sueldo_periodo "
     * + "WHERE (xiii_descripcion = "+descripcion+");").getResultList()); }
     */

    public boolean comprobarRhXiiiSueldoPeriodoTO(String descripcion) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM recursoshumanos.rh_xiii_sueldo_periodo "
                + "WHERE (xiii_descripcion = '" + descripcion + "');").
                getResultList(), 0)[0].toString());
    }

    //serial
    @Override
    public RhXiiiSueldoPeriodo buscarRhXiiiSueldoPeriodo(Integer secucenciaPeriodo) throws Exception {
        return xiiiSueldoPeriodoFacadeLocal.find(secucenciaPeriodo);
    }

    /*
     * @Override public RhFormaPagoBeneficiosSociales
     * buscarFormaPagoBeneficioSocial(Integer fpSecuencia) throws Exception{
     * return rhFormaPagoBeneficiosSocialesFacadeLocal.find(fpSecuencia); }
     */
    /*
     *
     * public inventario.entity.InvVendedor buscarInvVendedor(String empresa,
     * String codigo) throws Exception { return invVendedorFacadeLocal.find(new
     * inventario.entity.InvVendedorPK(empresa, codigo)); }
     *
     * public boolean comprobarEliminarInvVendedor(String empresa, String
     * codigo) throws Exception { return
     * Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
     * em.createNativeQuery("SELECT inventario.fun_sw_vendedor_eliminar(" +
     * "'"+empresa+"', '"+codigo+"');"). getResultList(), 0)[0].toString()); }
     */
    //****************************
    @Override
    public boolean comprobarRhXivSueldoPeriodoTO(String descripcion) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM recursoshumanos.rh_xiv_sueldo_periodo "
                + "WHERE (xiv_descripcion = '" + descripcion + "');").
                getResultList(), 0)[0].toString());
    }

    @Override
    public RhXivSueldoPeriodo buscarRhXivSueldoPeriodo(Integer secucenciaPeriodo) throws Exception {
        return xivSueldoPeriodoFacadeLocal.find(secucenciaPeriodo);
    }

    @Override
    public boolean comprobarRhUtilidadesPeriodo(String utiEmpresa, String utiDescripcion) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM recursoshumanos.rh_utilidades_periodo "
                + "WHERE (uti_empresa = '" + utiEmpresa + "' and uti_descripcion = '" + utiDescripcion + "');").
                getResultList(), 0)[0].toString());
    }
    /*
     * @Override public RhUtilidadesPeriodo buscarRhXivSueldoPeriodo(String
     * utiEmpresa, String utiDescripcion) throws Exception{ return
     * rhUtilidadesFacadeLocal.find(secucenciaPeriodo); }
     */
    // <editor-fold defaultstate="collapsed" desc="DESCUENTO FIJO">
    /**
     * @autor misayo
     *
     * @param empresa
     * @param periodo
     * @param tipo
     * @param numero
     * @return List<rrhh.TO.RhAnticipoTO>
     * @throws Exception Cualquier error inesperado
     */
    // </editor-fold>
}
