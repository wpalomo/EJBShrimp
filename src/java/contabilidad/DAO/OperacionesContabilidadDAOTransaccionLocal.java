/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.DAO;

import contabilidad.entity.*;
import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesContabilidadDAOTransaccionLocal {

    ///// METODOS PARA TIPOS CONTABLE
    boolean insertarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception;
    boolean modificarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception;
    boolean eliminarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception;

    ///// METODOS PARA CUENTAS CONTABLE
    boolean insertarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception;
    boolean insertarConCuentaFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuentaFlujo(ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuentaFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuentaLlavePrincipal(ConCuentas conCuentasEliminar, ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuentaFlujoLlavePrincipal(ConCuentasFlujo conCuentasFlujoEliminar, ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception;
    boolean modificarConCuentaLlavePrincipalFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalleEliminar, contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception;
    boolean modificarListaConCuenta(List<ConCuentas> listaConCuentas) throws Exception;
    boolean modificarListaConCuentaFlujo(List<ConCuentasFlujo> listaConCuentasFlujo, SisSuceso sisSuceso) throws Exception;
    boolean eliminarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception;
    boolean eliminarConCuentaFlujoDetalle(ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception;
    boolean eliminarConCuentaFlujo(ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception;

    ///// METODOS PARA INSERTAR CONTABLE
    boolean insertarTransaccionContable(
            contabilidad.entity.ConContable conContable,
            java.util.List<contabilidad.entity.ConDetalle> listaConDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso,
            contabilidad.entity.ConNumeracion conNumeracion,
            java.util.List<rrhh.entity.RhAnticipo> rhAnticipos,
            rrhh.entity.RhPrestamo rhPrestamo,
            rrhh.entity.RhVacaciones rhVacaciones,
            rrhh.entity.RhViatico rhViatico,
            java.util.List<rrhh.entity.RhBono> rhBonos,
            java.util.List<rrhh.entity.RhRol> rhRoles,
            java.util.List<rrhh.entity.RhXiiiSueldo> rhXiiiSueldos,
            java.util.List<rrhh.entity.RhXivSueldo> rhXivSueldos,
            java.util.List<rrhh.entity.RhUtilidades> rhUtilidades,
            rrhh.entity.RhSalarioDigno rhSalarioDigno,
            boolean provisiones,
            rrhh.entity.RhEmpleado rhEmpleado,
            cartera.entity.CarPagos carPagos,
            java.util.List<cartera.entity.CarPagosDetalleAnticipos> carPagosDetalleAnticiposes,
            java.util.List<cartera.entity.CarPagosDetalleCompras> carPagosDetalleCompras,
            java.util.List<cartera.entity.CarPagosDetalleForma> carPagosDetalleFormas,
            inventario.entity.InvCompras invCompras,
            cartera.entity.CarCobros carCobros, 
            java.util.List<cartera.entity.CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposes, 
            java.util.List<cartera.entity.CarCobrosDetalleVentas> carCobrosDetalleVentas, 
            java.util.List<cartera.entity.CarCobrosDetalleForma> carCobrosDetalleFormas,
            java.util.List<inventario.entity.InvVentas> invVentas,
            cartera.entity.CarPagosAnticipos carPagosAnticipos,
            cartera.entity.CarCobrosAnticipos carCobrosAnticipos,
            banco.entity.BanCheque banCheque, 
            sistema.TO.SisInfoTO sisInfoTO) throws java.lang.Exception;
//    boolean insertarTransaccionContable(ConContable conContable, List <ConDetalle> listaConDetalle,  SisSuceso sisSuceso, ConNumeracion conNumeracion, java.util.List<RhAnticipo> rhAnticipos, RhPrestamo rhPrestamo, RhViatico rhViatico, java.util.List<RhBono> rhBonos, RhRol rhRol) throws Exception;
    boolean modificarConContable(ConContable conContable, List <ConDetalle> listaConDetalle, List <ConDetalle> listaConDetalleEliminar,  SisSuceso sisSuceso) throws Exception;
    boolean modificarConContableCompras(ConContable conContable, List <ConDetalle> listaConDetalle, inventario.entity.InvCompras invCompras,  SisSuceso sisSuceso) throws Exception;
    boolean modificarConContableComprasMayorizar(
            ConContable conContable, 
            List <ConDetalle> listaConDetalle, 
            List <ConDetalle> listaConDetalleEliminar, 
            inventario.entity.InvCompras invCompras,  
            SisSuceso sisSuceso) throws Exception;
    boolean modificarConContableVentasMayorizar(ConContable conContable, List <ConDetalle> listaConDetalle, List <ConDetalle> listaConDetalleEliminar, inventario.entity.InvVentas invVentas,  SisSuceso sisSuceso) throws Exception;
    boolean anularConContable(ConContable conContable, SisSuceso sisSuceso) throws Exception;
    boolean anularReversarConContable(
            ConContable conContable, 
            List<contabilidad.entity.ConDetalle> conDetalles, 
            cartera.entity.CarPagos carPagos, 
            cartera.entity.CarPagosAnticipos carPagosAnticipos, 
            cartera.entity.CarCobros carCobros, 
            cartera.entity.CarCobrosAnticipos carCobrosAnticipos, 
            List<rrhh.entity.RhAnticipo> rhAnticipos, 
            List<rrhh.entity.RhBono> rhBonos, 
            List<rrhh.entity.RhPrestamo> rhPrestamos, 
            List<rrhh.entity.RhRol> rhRols, 
            List<rrhh.entity.RhVacaciones> rhVacacioneses, 
            List<rrhh.entity.RhViatico> rhViaticos, 
            SisSuceso sisSuceso) throws Exception;

    ///// METODOS PARA INSERTAR CONTABLE
    boolean insertarConNumeracion(ConNumeracion conNumeracion, String empresa, String usuario) throws Exception;
    boolean modificarConNumeracion(ConNumeracion conNumeracion, String empresa, String usuario) throws Exception;

    boolean modificarConDetalleTO(contabilidad.entity.ConDetalle conDetalle, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    
    boolean insertarTransaccionContableAgrupado(
            java.util.List<contabilidad.entity.ConContable> conContable,
            java.util.List<java.util.List<contabilidad.entity.ConDetalle>> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSuceso,
            java.util.List<contabilidad.entity.ConNumeracion> conNumeracion) throws java.lang.Exception;
    public boolean modificarTransaccionConContableAgrupado (
            List <ConContable> conContable, 
            List <List <ConDetalle>> listaConDetalle, 
            List <List <ConDetalle>> listaConDetalleEliminar, 
            List <SisSuceso> sisSuceso) throws Exception ;
    public boolean ReversarTransaccionConContableAgrupado (
            List <ConContable> conContable, 
            List <List <ConDetalle>> listaConDetalleReversar, 
            List <SisSuceso> sisSuceso) throws Exception;


    boolean insertarConCuentaFlujo(contabilidad.entity.ConCuentasFlujo conCuentasFlujo, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;

}
