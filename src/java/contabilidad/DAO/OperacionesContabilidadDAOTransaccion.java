/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.DAO;

import cartera.entity.*;
import contabilidad.entity.*;
import inventario.DAO.OperacionesInventarioDAOLocal;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import rrhh.entity.*;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesContabilidadDAOTransaccion implements OperacionesContabilidadDAOTransaccionLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesContabilidadDAOLocal operacionesContabilidadDAOLocal;
    @EJB
    OperacionesInventarioDAOLocal operacionesInventarioDAOLocal;
    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;
    public SisErrorTO sisErrorTO = null;

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA TIPO CONTABLE">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception {
        em.persist(conTipo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception {
        em.merge(conTipo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarConTipo(ConTipo conTipo, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conTipo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA CUENTAS">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception {
        em.persist(conCuentas);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarConCuentaFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception {
        em.persist(conCuentasFlujoDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception {
        em.merge(conCuentas);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuentaFlujo(ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception {
        em.merge(conCuentasFlujo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuentaFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception {
        em.merge(conCuentasFlujoDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuentaLlavePrincipal(ConCuentas conCuentasEliminar, ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentasEliminar));
        em.merge(conCuentas);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuentaFlujoLlavePrincipal(ConCuentasFlujo conCuentasFlujoEliminar, ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentasFlujoEliminar));
        em.merge(conCuentasFlujo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConCuentaLlavePrincipalFlujoDetalle(contabilidad.entity.ConCuentasFlujoDetalle conCuentasFlujoEliminarDetalle, contabilidad.entity.ConCuentasFlujoDetalle conFlujoCuentasDetalle, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentasFlujoEliminarDetalle));
        em.persist(conFlujoCuentasDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarListaConCuenta(List<ConCuentas> listaConCuentas) throws Exception {
        for (int i = 0; i < listaConCuentas.size(); i++) {
            em.merge(listaConCuentas.get(i));
        }
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarListaConCuentaFlujo(List<ConCuentasFlujo> listaConCuentasFlujo, SisSuceso sisSuceso) throws Exception {
        for (int i = 0; i < listaConCuentasFlujo.size(); i++) {
            em.merge(listaConCuentasFlujo.get(i));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarConCuenta(ConCuentas conCuentas, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentas));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarConCuentaFlujoDetalle(ConCuentasFlujoDetalle conCuentasFlujoDetalle, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentasFlujoDetalle));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarConCuentaFlujo(ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(conCuentasFlujo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA INGRESAR CONTABLE">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConContable(ConContable conContable, List<ConDetalle> listaConDetalle, List<ConDetalle> listaConDetalleEliminar, SisSuceso sisSuceso) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.merge(listaConDetalle.get(i));
        }

        if (listaConDetalleEliminar != null) {
            for (int i = 0; i < listaConDetalleEliminar.size(); i++) {
                listaConDetalleEliminar.get(i).setConContable(conContable);
                em.remove(em.merge(listaConDetalleEliminar.get(i)));
            }
        }

        em.merge(conContable);
        em.persist(sisSuceso);
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConContableCompras(ConContable conContable, List<ConDetalle> listaConDetalle, inventario.entity.InvCompras invCompras, SisSuceso sisSuceso) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.merge(listaConDetalle.get(i));
        }
        em.merge(invCompras);

        em.merge(conContable);
        em.persist(sisSuceso);
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConContableComprasMayorizar(
            ConContable conContable, 
            List<ConDetalle> listaConDetalle, 
            List<ConDetalle> listaConDetalleEliminar, 
            inventario.entity.InvCompras invCompras,
            List<banco.entity.BanCheque> listaBanChequeEliminar,
            SisSuceso sisSuceso) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        for (int i = 0; i < listaConDetalleEliminar.size(); i++) {
            listaConDetalleEliminar.get(i).setConContable(conContable);
            em.remove(em.merge(listaConDetalleEliminar.get(i)));
        }
        
        for (int i = 0; i < listaBanChequeEliminar.size(); i++) {
            if(listaBanChequeEliminar.get(i)!= null)
                em.remove(em.merge(listaBanChequeEliminar.get(i)));
        }
        em.merge(invCompras);

        em.merge(conContable);
        em.persist(sisSuceso);
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConContableVentasMayorizar(ConContable conContable, List<ConDetalle> listaConDetalle, List<ConDetalle> listaConDetalleEliminar,
            inventario.entity.InvVentas invVentas, SisSuceso sisSuceso) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        for (int i = 0; i < listaConDetalleEliminar.size(); i++) {
            listaConDetalleEliminar.get(i).setConContable(conContable);
            em.remove(em.merge(listaConDetalleEliminar.get(i)));
        }
        em.merge(invVentas);

        em.merge(conContable);
        em.persist(sisSuceso);
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean anularConContable(ConContable conContable, SisSuceso sisSuceso) throws Exception {
        em.merge(conContable);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean anularReversarConContable(
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
            SisSuceso sisSuceso) throws Exception {
        if (conContable != null) {
            em.merge(conContable);
        }
        if (carPagos != null) {
            em.merge(carPagos);
        }
        if (carPagosAnticipos != null) {
            em.merge(carPagosAnticipos);
        }
        if (carCobros != null) {
            em.merge(carCobros);
        }
        if (carCobrosAnticipos != null) {
            em.merge(carCobrosAnticipos);
        }
        for (rrhh.entity.RhAnticipo rhAnticipo : rhAnticipos) {
            em.merge(rhAnticipo);
        }
        for (rrhh.entity.RhBono rhBono : rhBonos) {
            em.merge(rhBono);
        }
        for (rrhh.entity.RhPrestamo rhPrestamo : rhPrestamos) {
            em.merge(rhPrestamo);
        }
        for (rrhh.entity.RhRol rhRol : rhRols) {
            em.merge(rhRol);
        }
        for (rrhh.entity.RhVacaciones rhVacaciones : rhVacacioneses) {
            em.merge(rhVacaciones);
        }
        for (rrhh.entity.RhViatico rhViatico : rhViaticos) {
            em.merge(rhViatico);
        }
        for (contabilidad.entity.ConDetalle conDetalle : conDetalles) {
            conDetalle.setPisNumero(null);
            em.merge(conDetalle);
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.merge(conContable);
        em.persist(sisSuceso);
        return true;
    }

// <editor-fold defaultstate="collapsed" desc="RRHH">
    // <editor-fold defaultstate="collapsed" desc="ANTICIPO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarAnticipoConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, List<RhAnticipo> rhAnticipos) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);

        for (RhAnticipo rhAnticipo : rhAnticipos) {
            em.persist(rhAnticipo);
        }

        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PRESTAMO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarPrestamoConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, RhPrestamo rhPrestamo) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        em.persist(rhPrestamo);
        em.persist(sisSuceso);
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VACACIONES">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarVacacionesConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, RhVacaciones rhVacaciones) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        em.persist(rhVacaciones);
        em.persist(sisSuceso);
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALARIO DIGNO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarSalarioDignoConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, RhSalarioDigno rhSalarioDigno) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero()); 
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        em.persist(rhSalarioDigno);
        em.persist(sisSuceso);
        return true;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="VIATICO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarViaticoConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, RhViatico rhViatico) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        em.persist(rhViatico);
        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BONO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarBonoConContable(ConContable conContable, List<ConDetalle> listaConDetalle, SisSuceso sisSuceso, ConNumeracion conNumeracion, boolean nuevo, java.util.List<RhBono> rhBonos) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);

        for (RhBono rhBono : rhBonos) {
            em.persist(rhBono);
        }

        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ROL">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRolConContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos,
            ConNumeracion conNumeracion,
            boolean nuevo,
            java.util.List<RhRol> rhRoles,
            RhEmpleado rhEmpleado) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            //listaConDetalle.get(i).setDetSaldo(BigDecimal.ZERO);
            // listaConDetalle.get(i).setSecEmpresa(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        if (rhEmpleado != null) {
            em.merge(rhEmpleado);
        }
        em.persist(conContable);
        for (RhRol rhRol : rhRoles) {
            em.merge(rhRol);
        }
        for (int i = 0; i < sisSucesos.size(); i++) {
            em.persist(sisSucesos.get(i));
        }
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROVISIONES">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhProvisionesConContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos,
            ConNumeracion conNumeracion,
            boolean nuevo,
            java.util.List<RhRol> rhRoles) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        for (RhRol rhRol : rhRoles) {
            em.merge(rhRol);
        }
        for (int i = 0; i < sisSucesos.size(); i++) {
            em.persist(sisSucesos.get(i));
        }
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIII SUELDO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhXiiiSueldoConContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos,
            ConNumeracion conNumeracion,
            boolean nuevo,
            java.util.List<RhXiiiSueldo> rhXiiiSueldos) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        for (RhXiiiSueldo rhXiiiSueldo : rhXiiiSueldos) {
            em.persist(rhXiiiSueldo);
        }
        for (int i = 0; i < sisSucesos.size(); i++) {
            em.persist(sisSucesos.get(i));
        }
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="XIV SUELDO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhXivSueldoConContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos,
            ConNumeracion conNumeracion,
            boolean nuevo,
            java.util.List<RhXivSueldo> rhXivSueldos) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        for (RhXivSueldo rhXivSueldo : rhXivSueldos) {
            em.merge(rhXivSueldo);
        }
        for (int i = 0; i < sisSucesos.size(); i++) {
            em.persist(sisSucesos.get(i));
        }
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UTILIDADES">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarRhUtilidadesConContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos,
            ConNumeracion conNumeracion,
            boolean nuevo,
            java.util.List<RhUtilidades> rhUtilidades) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
//                listaConDetalle.get(i).setConNumero(conContable.getConContablePK().getConNumero());
//                listaConDetalle.get(i).setPerCodigo(conContable.getConContablePK().getPerCodigo());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }
        em.persist(conContable);
        for (RhUtilidades rhUtilidad : rhUtilidades) {
            em.merge(rhUtilidad);
        }
        for (int i = 0; i < sisSucesos.size(); i++) {
            em.persist(sisSucesos.get(i));
        }
        return true;
    }// </editor-fold>
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarCarPagos(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo,
            CarPagos carPagos,
            List<CarPagosDetalleCompras> carPagosDetalleCompras,
            List<CarPagosDetalleForma> carPagosDetalleFormas,
            List<cartera.entity.CarPagosDetalleAnticipos> carPagosDetalleAnticiposes) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        em.persist(conContable);
        em.persist(carPagos);

        for (CarPagosDetalleCompras carPagosDetalleCompra : carPagosDetalleCompras) {
            em.persist(carPagosDetalleCompra);
        }

        for (CarPagosDetalleForma carPagosDetalleForma : carPagosDetalleFormas) {
            em.persist(carPagosDetalleForma);
        }

        for (cartera.entity.CarPagosDetalleAnticipos carPagosDetalleAnticipos : carPagosDetalleAnticiposes) {
            em.persist(carPagosDetalleAnticipos);
        }

        em.persist(sisSuceso);
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="COBRO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarCarCobros(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo,
            CarCobros carCobros,
            List<CarCobrosDetalleVentas> carCobrosDetalleVentas,
            List<CarCobrosDetalleForma> carCobrosDetalleFormas,
            List<cartera.entity.CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposes) throws Exception {
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        em.persist(conContable);
        em.persist(carCobros);

        for (CarCobrosDetalleVentas carCobrosDetalleVenta : carCobrosDetalleVentas) {
            em.persist(carCobrosDetalleVenta);
        }

        for (CarCobrosDetalleForma carCobrosDetalleForma : carCobrosDetalleFormas) {
            em.persist(carCobrosDetalleForma);
        }

        for (cartera.entity.CarCobrosDetalleAnticipos carCobrosDetalleAnticipos : carCobrosDetalleAnticiposes) {
            em.persist(carCobrosDetalleAnticipos);
        }

        em.persist(sisSuceso);
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="COMPRAS-CONTABLE">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarCompraContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo, inventario.entity.InvCompras invCompras) throws Exception {
        em.persist(conContable);
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        invCompras.setConEmpresa(conContable.getConContablePK().getConEmpresa());
        invCompras.setConNumero(conContable.getConContablePK().getConNumero());
        invCompras.setConPeriodo(conContable.getConContablePK().getConPeriodo());
        invCompras.setConTipo(conContable.getConContablePK().getConTipo());
        em.merge(invCompras);
        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VENTAS-CONTABLE">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarVentasContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo, java.util.List<inventario.entity.InvVentas> invVentas) throws Exception {
        em.persist(conContable);
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
////            javax.swing.JOptionPane.showMessageDialog(null,
////                    "Contable: "+listaConDetalle.get(i).getConContable()+
////                    "\nCuentas: "+listaConDetalle.get(i).getConCuentas()+
////                    "\nD/C: "+listaConDetalle.get(i).getDetDebitoCredito()+
////                    "\nCentro Costo: "+listaConDetalle.get(i).getDetCentroCosto()+
////                    "\nProduccion: "+listaConDetalle.get(i).getDetCentroProduccion()+
////                    "\nDocumento: "+listaConDetalle.get(i).getDetDocumento()+
////                    "\nReferencia: "+listaConDetalle.get(i).getDetReferencia()+
////                    "\nGenerado: "+listaConDetalle.get(i).getDetGenerado()+
////                    "\nOrden: "+listaConDetalle.get(i).getDetOrden()+
////                    "\nSecuencia: "+listaConDetalle.get(i).getDetSecuencia()+
////                    "\nValor: "+listaConDetalle.get(i).getDetValor());
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        if (invVentas != null) {
            if (!invVentas.isEmpty()) {
                for (int i = 0; i < invVentas.size(); i++) {
                    invVentas.get(i).setConEmpresa(conContable.getConContablePK().getConEmpresa());
                    invVentas.get(i).setConNumero(conContable.getConContablePK().getConNumero());
                    invVentas.get(i).setConPeriodo(conContable.getConContablePK().getConPeriodo());
                    invVentas.get(i).setConTipo(conContable.getConContablePK().getConTipo());
                    em.merge(invVentas.get(i));
                }
            }
        }

        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO PAGO - CARTERA">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarAnticipoPagoCarteraContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo, cartera.entity.CarPagosAnticipos carPagosAnticipos) throws Exception {
        em.persist(conContable);
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        carPagosAnticipos.setCarPagosAnticiposPK(new cartera.entity.CarPagosAnticiposPK(conContable.getConContablePK().getConEmpresa(),
                conContable.getConContablePK().getConPeriodo(), conContable.getConContablePK().getConTipo(), conContable.getConContablePK().getConNumero()));
        em.merge(carPagosAnticipos);
        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ANTICIPO COBRO - CARTERA">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertarAnticipoCobroCarteraContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo, cartera.entity.CarCobrosAnticipos carCobrosAnticipos) throws Exception {
        em.persist(conContable);
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        carCobrosAnticipos.setCarCobrosAnticiposPK(new cartera.entity.CarCobrosAnticiposPK(conContable.getConContablePK().getConEmpresa(),
                conContable.getConContablePK().getConPeriodo(), conContable.getConContablePK().getConTipo(), conContable.getConContablePK().getConNumero()));
        em.merge(carCobrosAnticipos);
        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CAMBIO DE CHEQUE - BANCO">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean cambioChequeContable(
            ConContable conContable,
            List<ConDetalle> listaConDetalle,
            SisSuceso sisSuceso,
            ConNumeracion conNumeracion,
            boolean nuevo, banco.entity.BanCheque banCheque) throws Exception {
        em.persist(conContable);
        for (int i = 0; i < listaConDetalle.size(); i++) {
            listaConDetalle.get(i).setConContable(conContable);
            em.persist(listaConDetalle.get(i));
        }
        if (nuevo) {
            em.persist(conNumeracion);
        } else {
            em.merge(conNumeracion);
        }

        em.merge(banCheque);

//        banco.entity.BanCheque banChequeNuevo = new banco.entity.BanCheque();
//        banChequeNuevo.setChqAnulado(false);
//        banChequeNuevo.setChqAnuladoFecha(null);
//        banChequeNuevo.setChqAnuladoObservacion("");
//        banChequeNuevo.setChqBeneficiario(banCheque.getChqBeneficiario());
//        banChequeNuevo.setChqCantidad(banCheque.getChqCantidad());
//        banChequeNuevo.setChqCiudad(banCheque.getChqCiudad());
//        banChequeNuevo.setChqCruzado(banCheque.getChqCruzado());
//        banChequeNuevo.setChqEntregado(banCheque.getChqEntregado());
//        banChequeNuevo.setChqEntregadoFecha(banCheque.getChqEntregadoFecha());
//        banChequeNuevo.setChqEntregadoObservacion(banCheque.getChqEntregadoObservacion());
//        banChequeNuevo.setChqFecha(banCheque.getChqFecha());
//        banChequeNuevo.setChqImpreso(banCheque.getChqImpreso());
//        banChequeNuevo.setChqImpresoFecha(banCheque.getChqImpresoFecha());
//        banChequeNuevo.setChqNoEsCheque(banCheque.getChqNoEsCheque());
//        banChequeNuevo.setChqReversado(banCheque.getChqReversado());
//        banChequeNuevo.setChqReversadoFecha(banCheque.getChqReversadoFecha());
//        banChequeNuevo.setChqReversadoObservacion(banCheque.getChqReversadoObservacion());
//        banChequeNuevo.setChqRevisado(banCheque.getChqRevisado());
//        banChequeNuevo.setChqRevisadoFecha(banCheque.getChqRevisadoFecha());
//        banChequeNuevo.setChqRevisadoObservacion(banCheque.getChqRevisadoObservacion());
//        banChequeNuevo.setConcCodigo(banCheque.getConcCodigo());
//        banChequeNuevo.setConcCuentaContable(banCheque.getConcCuentaContable());
//        banChequeNuevo.setConcEmpresa(banCheque.getConcEmpresa());
//        banChequeNuevo.setChqSecuencia(banCheque.getConcEmpresa());
//        banChequeNuevo.setDetSecuencia(0);
//        em.persist(banChequeNuevo);

        em.persist(sisSuceso);
        return true;
    }// </editor-fold>

    @Override
    public boolean insertarTransaccionContable(
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
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String rellenarConCeros = "";
        int numeracion = operacionesContabilidadDAOLocal.buscarConteoUltimaNumeracion(
                conContable.getConContablePK().getConEmpresa(),
                conContable.getConContablePK().getConPeriodo(),
                conContable.getConContablePK().getConTipo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        //String tipoComprobante = conNumeracion.getConNumeracionPK().getNumTipo().length()>5?conNumeracion.getConNumeracionPK().getNumTipo().substring(0, 5):conNumeracion.getConNumeracionPK().getNumTipo();
        if (operacionesContabilidadDAOLocal.buscarContable(
                conContable.getConContablePK().getConEmpresa(),
                conContable.getConContablePK().getConPeriodo(),
                conContable.getConContablePK().getConTipo(),
                String.format("%07d", conNumeracion.getNumSecuencia())) == null
                && (invCompras != null || invVentas != null)) {
            conContable.setConContablePK(new ConContablePK(
                    conNumeracion.getConNumeracionPK().getNumEmpresa(),
                    conNumeracion.getConNumeracionPK().getNumPeriodo(),
                    conNumeracion.getConNumeracionPK().getNumTipo(),
                    String.format("%07d", conNumeracion.getNumSecuencia())));
        } else {
            do {
                numeracion++;
                int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
                rellenarConCeros = "";
                for (int i = 0; i < numeroCerosAponer; i++) {
                    rellenarConCeros = rellenarConCeros + "0";
                }
                conContable.setConContablePK(new ConContablePK(
                        conNumeracion.getConNumeracionPK().getNumEmpresa(),
                        conNumeracion.getConNumeracionPK().getNumPeriodo(),
                        conNumeracion.getConNumeracionPK().getNumTipo(),
                        rellenarConCeros + numeracion));
                conNumeracion.setNumSecuencia(numeracion);
            } while (operacionesContabilidadDAOLocal.buscarContable(
                    conContable.getConContablePK().getConEmpresa(),
                    conContable.getConContablePK().getConPeriodo(),
                    conContable.getConContablePK().getConTipo(),
                    rellenarConCeros + numeracion) != null);
            conContable.getConContablePK().getConNumero();
        }

        if (rhAnticipos == null && rhPrestamo == null && rhVacaciones == null
                && rhViatico == null && rhBonos == null && rhRoles == null
                && rhXiiiSueldos == null && rhXivSueldos == null && rhUtilidades == null && rhSalarioDigno == null) {
            sisSuceso.setSusDetalle("Se insertó contable del periodo "
                    + conContable.getConContablePK().getConPeriodo() + ", del tipo contable "
                    + conContable.getConContablePK().getConTipo() + ", de la numeracion "
                    + conContable.getConContablePK().getConNumero());
        }

        
        if(listaConDetalle!= null && invCompras == null){
            for (int i = 0; i < listaConDetalle.size(); i++) {
                listaConDetalle.get(i).setDetSaldo(new BigDecimal("0.00"));
                listaConDetalle.get(i).setSecEmpresa(listaConDetalle.get(i).getConContable().getConContablePK().getConEmpresa());
            }
        }


        sisSuceso.setSusClave(conContable.getConContablePK().getConPeriodo() + " "
                + conContable.getConContablePK().getConTipo() + " "
                + rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
        ////// aqui va el metodo a llamar
        try {
            //CONTABLE
            if (rhAnticipos == null
                    && rhPrestamo == null
                    && rhVacaciones == null
                    && rhViatico == null
                    && rhBonos == null
                    && rhRoles == null
                    && rhXiiiSueldos == null
                    && rhXivSueldos == null
                    && rhUtilidades == null
                    && rhSalarioDigno == null
                    && carPagos == null
                    && carCobros == null
                    && invCompras == null
                    && invVentas == null
                    && carPagosAnticipos == null
                    && carCobrosAnticipos == null
                    && banCheque == null) {

                retorno = insertarConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo);

            } else {
                //ANTICIPO
                if (rhAnticipos != null) {
                    for (RhAnticipo rhAnticipo : rhAnticipos) {
                        rhAnticipo.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarAnticipoConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhAnticipos);
                }
                //PRESTAMO
                if (rhPrestamo != null) {
                    rhPrestamo.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarPrestamoConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhPrestamo);
                }
                //VACACIONES
                if (rhVacaciones != null) {
                    rhVacaciones.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarVacacionesConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhVacaciones);
                }
                //SALARIO DIGNO
                if (rhSalarioDigno != null) {
                    rhSalarioDigno.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarSalarioDignoConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhSalarioDigno);
                }
                //VIATICO
                if (rhViatico != null) {
                    rhViatico.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarViaticoConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhViatico);
                }
                //BONO
                if (rhBonos != null) {
                    for (RhBono rhBono : rhBonos) {
                        rhBono.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarBonoConContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, rhBonos);
                }
                //ROL
                if ((rhRoles != null) && (provisiones == false)) {
                    java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList();
                    sisSucesos.add(sisSuceso);
                    if (rhEmpleado.getEmpInactivo() == true) {
                        sistemaWeb.entity.SisSuceso sisSucesoEmpleado = validaciones.Suceso.crearSisSuceso(
                                "recursoshumanos.rh_empleado",
                                rhEmpleado.getRhEmpleadoPK().getEmpId(),
                                "DELETE",
                                "Se inactiva a " + rhEmpleado.getEmpApellidos() + " " + rhEmpleado.getEmpNombres(),
                                sisInfoTO);
                        sisSucesos.add(sisSucesoEmpleado);
                    }
                    for (RhRol rhRol : rhRoles) {
                        rhRol.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarRolConContable(conContable, listaConDetalle, sisSucesos, conNumeracion, nuevo, rhRoles, rhEmpleado);
                }
                //PROVISIONES
                if ((rhRoles != null) && (provisiones == true)) {
                    java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList();
                    sisSucesos.add(sisSuceso);

                    for (RhRol rhRol : rhRoles) {
                        rhRol.setConProvisionNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarRhProvisionesConContable(conContable, listaConDetalle, sisSucesos, conNumeracion, nuevo, rhRoles);
                }
                //PROVISIONES
               
                if ((rhXiiiSueldos != null)) {
                    java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList();
                    sisSucesos.add(sisSuceso);

                    for (RhXiiiSueldo rhXiiiSueldo : rhXiiiSueldos) {
                        rhXiiiSueldo.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarRhXiiiSueldoConContable(conContable, listaConDetalle, sisSucesos, conNumeracion, nuevo, rhXiiiSueldos);
                }
                if ((rhXivSueldos != null)) {
                    java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList();
                    sisSucesos.add(sisSuceso);

                    for (RhXivSueldo rhXivSueldo : rhXivSueldos) {
                        rhXivSueldo.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }
                    retorno = insertarRhXivSueldoConContable(conContable, listaConDetalle, sisSucesos, conNumeracion, nuevo, rhXivSueldos);
                }
                if ((rhUtilidades != null)) {
                    java.util.List<sistemaWeb.entity.SisSuceso> sisSucesos = new java.util.ArrayList();
                    sisSucesos.add(sisSuceso);

                    for (RhUtilidades rhUtilidad : rhUtilidades) {
                        rhUtilidad.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    }

                    retorno = insertarRhUtilidadesConContable(conContable, listaConDetalle, sisSucesos, conNumeracion, nuevo, rhUtilidades);
                }
                //PAGOS
                if (carPagos != null) {
                    carPagos.setCarPagosPK(new CarPagosPK(
                            conContable.getConContablePK().getConEmpresa(),
                            conContable.getConContablePK().getConPeriodo(),
                            carPagos.getCarPagosPK().getPagTipo(),
                            conContable.getConContablePK().getConNumero()));
                    java.math.BigDecimal valorPago = new java.math.BigDecimal("0.00");
                    for (int i = 0; i < carPagosDetalleCompras.size(); i++) {
                        carPagosDetalleCompras.get(i).setCarPagos(carPagos);
                        valorPago = valorPago.add(carPagosDetalleCompras.get(i).getDetValor());
                    }
                    for (int i = 0; i < carPagosDetalleFormas.size(); i++) {
                        carPagosDetalleFormas.get(i).setCarPagos(carPagos);
                    }
                    for (int i = 0; i < carPagosDetalleAnticiposes.size(); i++) {
                        carPagosDetalleAnticiposes.get(i).setCarPagos(carPagos);
                    }

                    String detalle = "Pago a " + operacionesInventarioDAOLocal.buscarInvProveedor(carPagos.getCarPagosPK().getPagEmpresa(), carPagos.getProvCodigo()).getProvNombre()
                            + " por $" + valorPago.toPlainString();
                    sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);

                    retorno = insertarCarPagos(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, carPagos, carPagosDetalleCompras, carPagosDetalleFormas, carPagosDetalleAnticiposes);
                }
                //COBROS
                if (carCobros != null) {
                    carCobros.setCarCobrosPK(new CarCobrosPK(
                            conContable.getConContablePK().getConEmpresa(),
                            conContable.getConContablePK().getConPeriodo(),
                            carCobros.getCarCobrosPK().getCobTipo(),
                            conContable.getConContablePK().getConNumero()));
                    java.math.BigDecimal valorPago = new java.math.BigDecimal("0.00");
                    for (int i = 0; i < carCobrosDetalleVentas.size(); i++) {
                        carCobrosDetalleVentas.get(i).setCarCobros(carCobros);
                        valorPago = valorPago.add(carCobrosDetalleVentas.get(i).getDetValor());
                    }
                    for (int i = 0; i < carCobrosDetalleFormas.size(); i++) {
                        carCobrosDetalleFormas.get(i).setCarCobros(carCobros);
                    }
                    for (int i = 0; i < carCobrosDetalleAnticiposes.size(); i++) {
                        carCobrosDetalleAnticiposes.get(i).setCarCobros(carCobros);
                    }

                    String detalle = "Cobro a " + operacionesInventarioDAOLocal.buscarInvCliente(carCobros.getCarCobrosPK().getCobEmpresa(), carCobros.getCliCodigo()).getCliNombre()
                            + " por $" + valorPago.toPlainString();
                    sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);

                    retorno = insertarCarCobros(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, carCobros, carCobrosDetalleVentas, carCobrosDetalleFormas, carCobrosDetalleAnticiposes);
                }

                //COMPRAS
                if (invCompras != null) {
//                    rhRol.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarCompraContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, invCompras);
                }
                //VENTAS
                if (invVentas != null) {
//                    rhRol.setConNumero(rellenarConCeros + String.valueOf(conNumeracion.getNumSecuencia()));
                    retorno = insertarVentasContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, invVentas);
                }
                //PAGO ANTICIPO - MODULO DE CARTERA
                if (carPagosAnticipos != null) {
                    retorno = insertarAnticipoPagoCarteraContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, carPagosAnticipos);
                }
                //COBRO ANTICIPO - MODULO DE CARTERA
                if (carCobrosAnticipos != null) {
                    retorno = insertarAnticipoCobroCarteraContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, carCobrosAnticipos);
                }
                //CAMBIO DE CHEQUE
                if (banCheque != null) {
                    retorno = cambioChequeContable(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo, banCheque);
                }
            }
            return retorno;
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarTransaccionContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
            return false;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA INGRESAR NUMERACIONES">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarConNumeracion(ConNumeracion conNumeracion, String empresa, String usuario) throws Exception {
        em.persist(conNumeracion);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConNumeracion(ConNumeracion conNumeracion, String empresa, String usuario) throws Exception {
        em.merge(conNumeracion);
        em.flush();
        return true;
    }
    // </editor-fold>

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarConDetalleTO(contabilidad.entity.ConDetalle conDetalle, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.merge(conDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @Override
    public boolean insertarTransaccionContableAgrupado(
            java.util.List<contabilidad.entity.ConContable> conContable,
            java.util.List<java.util.List<contabilidad.entity.ConDetalle>> listaConDetalle,
            java.util.List<sistemaWeb.entity.SisSuceso> sisSuceso,
            java.util.List<contabilidad.entity.ConNumeracion> conNumeracion) throws Exception {
        String rellenarConCeros = "";
        int numeracion = operacionesContabilidadDAOLocal.buscarConteoUltimaNumeracion(
                conContable.get(0).getConContablePK().getConEmpresa(),
                conContable.get(0).getConContablePK().getConPeriodo(),
                conContable.get(0).getConContablePK().getConTipo());
        boolean nuevo = false, retorno = false;
        if (numeracion == 0) {
            nuevo = true;
        }
        do {
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            conContable.get(0).setConContablePK(new ConContablePK(
                    conNumeracion.get(0).getConNumeracionPK().getNumEmpresa(),
                    conNumeracion.get(0).getConNumeracionPK().getNumPeriodo(),
                    conNumeracion.get(0).getConNumeracionPK().getNumTipo(),
                    rellenarConCeros + numeracion));
            conNumeracion.get(0).setNumSecuencia(numeracion);
        } while (operacionesContabilidadDAOLocal.buscarContable(
                conContable.get(0).getConContablePK().getConEmpresa(),
                conContable.get(0).getConContablePK().getConPeriodo(),
                conContable.get(0).getConContablePK().getConTipo(),
                rellenarConCeros + numeracion) != null);
        sisSuceso.get(0).setSusDetalle("Se insertó contable del periodo "
                + conContable.get(0).getConContablePK().getConPeriodo() + ", del tipo contable "
                + conContable.get(0).getConContablePK().getConTipo() + ", de la numeracion "
                + conContable.get(0).getConContablePK().getConNumero() + ","
                + conContable.get(0).getConObservaciones());

        sisSuceso.get(0).setSusClave(conContable.get(0).getConContablePK().getConPeriodo() + " "
                + conContable.get(0).getConContablePK().getConTipo() + " "
                + rellenarConCeros + String.valueOf(conNumeracion.get(0).getNumSecuencia()));
        //CONTABLE
        int num = Integer.parseInt(conContable.get(0).getConContablePK().getConNumero());
        for (int i = 1; i < conContable.size(); i++) {
            num++;
            int numeroCerosAponer = 7 - String.valueOf(num).trim().length();
            rellenarConCeros = "";
            for (int j = 0; j < numeroCerosAponer; j++) {
                rellenarConCeros = rellenarConCeros + "0";
            }

            conContable.get(i).setConContablePK(new ConContablePK(
                    conNumeracion.get(i).getConNumeracionPK().getNumEmpresa(),
                    conNumeracion.get(i).getConNumeracionPK().getNumPeriodo(),
                    conNumeracion.get(i).getConNumeracionPK().getNumTipo(),
                    rellenarConCeros + num));
            conNumeracion.get(i).setNumSecuencia(num);
            sisSuceso.get(i).setSusDetalle("Se insertó contable del periodo "
                    + conContable.get(i).getConContablePK().getConPeriodo() + ", del tipo contable "
                    + conContable.get(i).getConContablePK().getConTipo() + ", de la numeracion "
                    + conContable.get(i).getConContablePK().getConNumero() + ","
                    + conContable.get(i).getConObservaciones());

            sisSuceso.get(i).setSusClave(conContable.get(i).getConContablePK().getConPeriodo() + " "
                    + conContable.get(i).getConContablePK().getConTipo() + " "
                    + rellenarConCeros + String.valueOf(conNumeracion.get(i).getNumSecuencia()));
        }
        return retorno = insertarConContableAgrupado(conContable, listaConDetalle, sisSuceso, conNumeracion, nuevo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean insertarConContableAgrupado(List<ConContable> conContable, List<List<ConDetalle>> listaConDetalle, List<SisSuceso> sisSuceso, List<ConNumeracion> conNumeracion, boolean nuevo) throws Exception {
        for (int i = 0; i < conContable.size(); i++) {
            em.merge(conContable.get(i));
        }
        for (int i = 0; i < conContable.size(); i++) {
            List<ConDetalle> conDetalleSeparada = listaConDetalle.get(i);
            for (int j = 0; j < conDetalleSeparada.size(); j++) {
                conDetalleSeparada.get(j).setConContable(conContable.get(i));
                em.persist(conDetalleSeparada.get(j));
            }
        }
        if (nuevo) {
            for (int i = 0; i < conContable.size(); i++) {
                if (i == 0) {
                    em.persist(conNumeracion.get(i));
                } else {
                    em.merge(conNumeracion.get(i));
                }
            }
        } else {
            for (int i = 0; i < conContable.size(); i++) {
                em.merge(conNumeracion.get(i));
            }
        }
        for (int i = 0; i < conContable.size(); i++) {
            em.persist(sisSuceso.get(i));
        }
        em.flush();

        return true;
    }

    @Override
    public boolean modificarTransaccionConContableAgrupado(
            List<ConContable> conContable,
            List<List<ConDetalle>> listaConDetalle,
            List<List<ConDetalle>> listaConDetalleEliminar,
            List<SisSuceso> sisSuceso) throws Exception {
        for (int i = 0; i < conContable.size(); i++) {
            List<ConDetalle> conDetalleSeparadaEliminar = listaConDetalleEliminar.get(i);
            if (conContable.get(i).getConAnulado()) {
                for (int j = 0; j < conDetalleSeparadaEliminar.size(); j++) {
                    conDetalleSeparadaEliminar.get(j).setConContable(conContable.get(i));
                    em.persist(conDetalleSeparadaEliminar.get(j));
                }
            } else {

                List<ConDetalle> conDetalleSeparada = listaConDetalle.get(i);
                for (int j = 0; j < conDetalleSeparada.size(); j++) {
                    conDetalleSeparada.get(j).setConContable(conContable.get(i));
                    em.persist(conDetalleSeparada.get(j));
                }
                for (int j = 0; j < conDetalleSeparadaEliminar.size(); j++) {
                    conDetalleSeparadaEliminar.get(j).setConContable(conContable.get(i));
                    em.remove(em.merge(conDetalleSeparadaEliminar.get(j)));
                }
            }
            em.merge(conContable.get(i));
            em.persist(sisSuceso.get(i));
        }
        em.flush();
        return true;
    }

    @Override
    public boolean ReversarTransaccionConContableAgrupado(
            List<ConContable> conContable,
            List<List<ConDetalle>> listaConDetalleReversar,
            List<SisSuceso> sisSuceso) throws Exception {
        for (int i = 0; i < conContable.size(); i++) {
            List<ConDetalle> conDetalleSeparadaEliminar = listaConDetalleReversar.get(i);
            for (int j = 0; j < conDetalleSeparadaEliminar.size(); j++) {
                conDetalleSeparadaEliminar.get(j).setConContable(conContable.get(i));
                em.persist(conDetalleSeparadaEliminar.get(j));
            }

            em.merge(conContable.get(i));
            em.persist(sisSuceso.get(i));
        }
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean insertarConCuentaFlujo(contabilidad.entity.ConCuentasFlujo conCuentasFlujo, SisSuceso sisSuceso) throws Exception {
        em.persist(conCuentasFlujo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
}