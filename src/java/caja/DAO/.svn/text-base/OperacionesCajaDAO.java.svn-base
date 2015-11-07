/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.DAO;

import caja.TO.CajCajaValesTO;
import javax.ejb.Stateless;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesCajaDAO implements OperacionesCajaDAOLocal {

    @javax.persistence.PersistenceContext(unitName = "EJBShrimpPU")
    javax.persistence.EntityManager em;
    @javax.ejb.EJB
    caja.entity.DAO.CajCajaFacadeLocal cajCajaFacadeLocal;
    @javax.ejb.EJB
    caja.entity.DAO.CajValesFacadeLocal cajvaleFacadelocal;
    @javax.ejb.EJB
    caja.entity.DAO.CajValesConceptosFacadeLocal cajValesConceptosFacadeLocal;

    @Override
    public caja.entity.CajCaja getCajCaja(
            String empresa,
            String codigo) throws Exception {
        return cajCajaFacadeLocal.find(new caja.entity.CajCajaPK(empresa, codigo));
    }

    @Override
    public java.util.List<caja.TO.CajCajaTO> getListadoCajCajaTO(
            String empresa) throws Exception {
        return caja.helper.ConversionesCaja.convertirListaCajCaja_CajCajaTO(
                em.createNativeQuery("SELECT * FROM caja.caj_caja "
                + "WHERE caja_empresa = ('" + empresa + "') ORDER BY caja_codigo").getResultList());
    }

    @Override
    public java.util.List<caja.TO.CajCajaComboTO> getCajCajaComboTO(
            String empresa) throws Exception {
        return caja.helper.ConversionesCaja.convertirListaCajCajaCombo_ListaCajCajaComboTO(
                em.createNativeQuery("SELECT caja_codigo, caja_nombre FROM caja.caj_caja WHERE "
                + "caja_empresa = ('" + empresa + "') AND caja_activa ORDER BY caja_codigo").getResultList());
    }

    @Override
    public java.util.List<caja.TO.CajValesConceptosComboTO> getCajValesConceptosComboTOs(
            String empresa) throws Exception {
        return caja.helper.ConversionesCaja.convertirListaCajValesConceptosCombo_ListaCajValesConceptosComboTO(
                em.createNativeQuery("SELECT conc_codigo, conc_detalle, conc_empresa, conc_inactivo, usr_empresa, usr_codigo, usr_fecha_inserta "
                + "FROM caja.caj_vales_conceptos WHERE "
                + "conc_empresa = '" + empresa + "' AND conc_inactivo = FALSE  ORDER BY conc_codigo").getResultList());
    }

    @Override
    public boolean comprobarCajValesConceptos(
            String empresa,
            String codigo) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT COUNT(*)!=0 FROM caja.caj_vales_conceptos "
                + "WHERE (conc_empresa = '" + empresa + "' AND conc_codigo = '" + codigo + "');").
                getResultList(), 0)[0].toString());
    }

    public caja.entity.CajValesConceptos buscarCajValesConceptos(
            String empresa, String codigo) throws Exception {
        return cajValesConceptosFacadeLocal.find(new caja.entity.CajValesConceptosPK(empresa, codigo));
    }

    @Override
    public int buscarConteoUltimaNumeracionCajaVale(
            String empCodigo,
            String perCodigo,
            String motCodigo) throws Exception {
        try {
            return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                    "SELECT num_secuencia FROM caja.caj_vales_numeracion "
                    + "WHERE num_empresa = ('" + empCodigo + "') AND num_periodo = "
                    + "('" + perCodigo + "') AND num_motivo = ('" + motCodigo + "') ").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public caja.entity.CajVales buscarCajVales(
            String empresa,
            String perCodigo,
            String motCodigo,
            String compNumero) throws Exception {
        return cajvaleFacadelocal.find(new caja.entity.CajValesPK(empresa, perCodigo, motCodigo, compNumero));
    }

    @Override
    public java.util.List<CajCajaValesTO> getListadoCajValesTO(
            String empresa,
            String motCadigo,
            String fechaDesde,
            String fechaHasta) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        motCadigo = motCadigo == null ? motCadigo : "'" + motCadigo + "'";
        fechaDesde = fechaDesde == null ? fechaDesde : "'" + fechaDesde + "'";
        fechaHasta = fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'";
        return caja.helper.ConversionesCaja.convertirCajCajaListaVales_CajCajaListaValesTO(
                em.createNativeQuery("SELECT vale_empresa, vale_periodo, vale_motivo, vale_numero, vale_fecha, "
                + "vale_valor * -1, vale_beneficiario, vale_observaciones, vale_anulado,  usr_empresa, "
                + "usr_codigo, usr_fecha_inserta , conc_empresa, conc_codigo "
                + "FROM caja.caj_vales "
                + "WHERE ( vale_fecha >= " + fechaDesde + " AND vale_fecha <= " + fechaHasta + " "
                + "AND vale_empresa = " + empresa + " "
                + "AND vale_motivo = " + motCadigo + ") ORDER BY vale_empresa, vale_periodo, vale_motivo, vale_numero").getResultList());
    }

    @Override
    public caja.TO.CajCajaValesTO getCajCajaValesTO(
            String empresa,
            String perCodigo,
            String motCodigo,
            String valeNumero) throws Exception {
        caja.TO.CajCajaValesTO cajCajaValeTO = null;
        cajCajaValeTO = caja.helper.ConversionesCaja.convertirCajCajaVales_CajCajaValesTO(em.createNativeQuery("SELECT vale_empresa, vale_periodo, vale_motivo, vale_numero, vale_fecha, "
                + "vale_valor, vale_beneficiario, vale_observaciones, vale_anulado,  usr_empresa, "
                + "usr_codigo, usr_fecha_inserta, conc_empresa, conc_codigo  "
                + "FROM caja.caj_vales  where vale_empresa = '" + empresa + "' and "
                + "vale_periodo = '" + perCodigo + "' and vale_motivo= '" + motCodigo + "' and "
                + "vale_numero = '" + valeNumero + "';").getResultList());
        return cajCajaValeTO;
    }

    @Override
    public java.util.List<caja.TO.CajCuadreCajaTO> getCajCuadreCajaTOs(
            String empresa,
            String codigoMotivo,
            String fechaDesde,
            String fechaHasta) throws Exception {       

        return caja.helper.ConversionesCaja.convertirCajCuadreCaja_CajCuadreCajaTO(
                em.createNativeQuery("SELECT * FROM caja.fun_cuadre_de_caja("
                + "'" + (empresa) + "',"
                + (codigoMotivo == null ? codigoMotivo : "'" + codigoMotivo + "'") + ","
                + (fechaHasta == null ? fechaHasta : "'" + fechaHasta + "'") + ");").getResultList());
    }

    @Override
    public caja.TO.CajCajaTO getCajCajaTO(String empresa, String usuarioCodigo) throws Exception {
//        String retorno = "";
        caja.TO.CajCajaTO cajCajaTO = null;
        Object[] array = validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT "
                + "caja_empresa, "
                + "caja_codigo, "
                + "caja_nombre, "
                + "caja_usuario_responsable, "
                + "caja_certificado_firma_digital_nombre, "
                + "caja_certificado_firma_digital_clave, "
                + "caja_activa, "
                + "permiso_secuencial_permitido "
                + "FROM caja.caj_caja "
                + "WHERE caja_empresa= '" + empresa + "' AND caja_usuario_responsable = '" + usuarioCodigo + "';").getResultList(), 0);
        if (array != null) {
            cajCajaTO = new caja.TO.CajCajaTO();
            cajCajaTO.setCajaEmpresa(array[0] == null ? null : array[0].toString().trim());
            cajCajaTO.setCajaCodigo(array[1] == null ? null : array[1].toString().trim());
            cajCajaTO.setCajaNombre(array[2] == null ? null : array[2].toString().trim());
            cajCajaTO.setCajaUsuarioResponsable(array[3] == null ? null : array[3].toString().trim());
            cajCajaTO.setCajaCertificadoFirmaDigitalNombre(array[4] == null ? null : array[4].toString().trim());
            cajCajaTO.setCajaCertificadoFirmaDigitalClave(array[5] == null ? null : array[5].toString().trim());
            cajCajaTO.setCajaActiva(array[6] == null ? null : Boolean.parseBoolean(array[6].toString()));
            cajCajaTO.setPermisoSecuencialPermitido(array[7] == null ? null : array[7].toString().trim());
        } else {
            cajCajaTO = null;
        }
        return cajCajaTO;
    }
    /*
     * "SELECT caja_empresa, caja_codigo, caja_nombre, caja_usuario_responsable,
     * " + "caja_tipo_ambiente, caja_certificado_firma_digital_nombre,
     * caja_certificado_firma_digital_clave, caja_activa "
     */
}
  //DAO paso 1