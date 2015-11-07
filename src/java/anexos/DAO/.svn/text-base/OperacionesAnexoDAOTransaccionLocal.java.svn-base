/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.DAO;

import javax.ejb.Local;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesAnexoDAOTransaccionLocal {

    boolean insertarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean eliminarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception; 

    boolean insertarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean modificarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    boolean eliminarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    java.lang.Boolean actualizarAnxCuentascontables(anexos.entity.AnxCuentascontables anxCuentascontables, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;
    
    java.lang.Boolean eliminarAnxVentas(anexos.entity.AnxVenta anxVenta, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;
    
    Boolean reestructurarRetencion(anexos.entity.AnxCompra anxCompra, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    java.lang.Boolean accionAnxVenta(anexos.entity.AnxVenta anxVenta, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionAnxUrlWebServixce(anexos.entity.AnxUrlWebServices anxUrlWebServices, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionAnxVentaElectronica(anexos.entity.AnxVentaElectronica anxVentaElectronica, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;
    java.lang.Boolean accionAnxCompraElectronica(
            anexos.entity.AnxCompraElectronica anxCompraElectronica, 
            anexos.entity.AnxCompra anxCompra,
            sistemaWeb.entity.SisSuceso sisSuceso, 
            char accion) throws java.lang.Exception;
}
