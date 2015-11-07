/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.DAO;

import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesCajaDAOLocal {

    caja.entity.CajCaja getCajCaja(
            java.lang.String empresa,
            java.lang.String codigo) throws java.lang.Exception;

    java.util.List<caja.TO.CajCajaTO> getListadoCajCajaTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<caja.TO.CajCajaComboTO> getCajCajaComboTO(
            java.lang.String empresa) throws java.lang.Exception;

    java.util.List<caja.TO.CajValesConceptosComboTO> getCajValesConceptosComboTOs(
            java.lang.String empresa) throws Exception;

    boolean comprobarCajValesConceptos(
            String empresa,
            String codigo) throws Exception;

    caja.entity.CajValesConceptos buscarCajValesConceptos(
            String empresa,
            String codigo) throws Exception;

    int buscarConteoUltimaNumeracionCajaVale(
            String empCodigo,
            String perCodigo,
            String motCodigo) throws Exception;

    caja.entity.CajVales buscarCajVales(
            String empresa,
            String perCodigo,
            String motCodigo,
            String compNumero) throws Exception;

    java.util.List<caja.TO.CajCajaValesTO> getListadoCajValesTO(
            java.lang.String empresa,
            java.lang.String motCodigo,
            java.lang.String fechaDesde,
            java.lang.String fechaHasta) throws Exception;

    caja.TO.CajCajaValesTO getCajCajaValesTO(
            String empresa,
            String perCodigo,
            String motCodigo,
            String valeNumero) throws Exception;

    java.util.List<caja.TO.CajCuadreCajaTO> getCajCuadreCajaTOs(
            String empresa,
            String codigoMotivo,
            String fechaDesde,
            String fechaHasta) throws Exception;

    caja.TO.CajCajaTO getCajCajaTO(
            String empresa,
            String usuarioCodigo) throws Exception;
}
//interfaz del DAO PASO 2