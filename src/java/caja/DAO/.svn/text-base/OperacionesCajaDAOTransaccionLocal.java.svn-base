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
public interface OperacionesCajaDAOTransaccionLocal {
    
    boolean accionCajCaja(caja.entity.CajCaja cajCaja, sistemaWeb.entity.SisSuceso sisSuceso, String accion) throws java.lang.Exception;
    // inserta directamente en la base de datos es el ultimo para para realizar la insercion correctamente

    public java.lang.Boolean accionCajaValesTO(caja.entity.CajVales cajVales,sistemaWeb.entity.SisSuceso sisSuceso,caja.entity.CajValesNumeracion cajValesNumeracion, char accion)throws Exception;
    public java.lang.Boolean accionCajValesConceptos(caja.entity.CajValesConceptos cajValesConceptos, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception;
}
