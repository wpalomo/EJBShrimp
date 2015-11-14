/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import banco.entity.BanBanco;
import banco.entity.BanCaja;
import banco.entity.BanCheque;
import banco.entity.BanCuenta;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import javax.ejb.Local;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author jack
 */
@Local
public interface OperacionesBancoDAOTransaccionLocal {

    boolean insertarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception;

//    boolean insertarBanChequesNumeracion(BanChequeNumeracion banBanco, SisSuceso sisSuceso) throws Exception;

    boolean insertarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception;

    boolean insertarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception;

    boolean insertarBanCheque(BanCheque banCheque, SisSuceso sisSuceso, ConContable conContable, ConDetalle conDetalle) throws Exception;

    boolean insertarBanCheque(BanCheque banCheque, SisSuceso sisSuceso) throws Exception;

    boolean modificarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception;

    boolean modificarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception;

    boolean modificarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception;

    boolean modificarBanCheque(BanCheque banCheque, SisSuceso sisSuceso) throws Exception;

    boolean eliminarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception;

    boolean eliminarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception;

    boolean eliminarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception;

    Boolean accionBanConciliacion(banco.entity.BanConciliacion banConciliacion, java.util.List<banco.entity.BanCheque> banCheques, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception;

    Boolean accionBanCheques(java.util.List<banco.entity.BanCheque> banCheques, java.util.List<contabilidad.TO.ConContableConDetalle> conContableConDetalles, java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos, char accion) throws java.lang.Exception;

    Boolean eliminarBanCheques(BanCheque banCheque, SisSuceso sisSuceso) throws Exception;

    Boolean insertarPreaviso(banco.entity.BanPreavisos banPreavisos, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;

    boolean eliminarBanPreaviso(banco.entity.BanPreavisos banPreavisos, SisSuceso sisSuceso) throws Exception;
}
