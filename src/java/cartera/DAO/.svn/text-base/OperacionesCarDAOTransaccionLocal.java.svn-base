/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartera.DAO;

import javax.ejb.Local;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesCarDAOTransaccionLocal {

    java.lang.Boolean insertarTransaccionCarteraPagos(
            cartera.entity.CarPagos carPagos, 
            java.util.List<cartera.entity.CarPagosDetalleCompras> carPagosDetalleCompras, 
            java.util.List<cartera.entity.CarPagosDetalleForma> carPagosDetalleFormas, 
            java.util.List<cartera.entity.CarPagosDetalleAnticipos> carPagosDetalleAnticiposes,
            contabilidad.entity.ConContable conContable, 
            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            contabilidad.entity.ConNumeracion conNumeracion,sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
    java.lang.Boolean insertarTransaccionCarteraCobros(
            cartera.entity.CarCobros carCobros, 
            java.util.List<cartera.entity.CarCobrosDetalleVentas> carCobrosDetalleVentas, 
            java.util.List<cartera.entity.CarCobrosDetalleForma> carCobrosDetalleFormas, 
            java.util.List<cartera.entity.CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposes,
            contabilidad.entity.ConContable conContable,
            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            contabilidad.entity.ConNumeracion conNumeracion,
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;

    java.lang.Boolean accionCarFormaPago(cartera.entity.CarPagosForma carPagosForma, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionCarFormaCobro(cartera.entity.CarCobrosForma carCobrosForma, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
}
