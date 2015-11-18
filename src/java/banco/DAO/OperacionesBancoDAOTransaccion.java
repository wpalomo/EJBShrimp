/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import banco.entity.*;
import contabilidad.entity.ConContable;
import contabilidad.entity.ConDetalle;
import javax.ejb.Stateless;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesBancoDAOTransaccion implements OperacionesBancoDAOTransaccionLocal {

    @javax.persistence.PersistenceContext(type = javax.persistence.PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private javax.persistence.EntityManager em;
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    banco.DAO.OperacionesBancoDAOLocal operacionesBancoDAOLocal;

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(banBanco);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanChequesNumeracion(BanChequeNumeracion banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(banBanco);
        em.flush();
        return true;
    }
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(banCaja);

        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanCheque(BanCheque banCheque, SisSuceso sisSuceso, ConContable conContable, ConDetalle conDetalle) throws Exception {
        em.merge(conContable);
        em.merge(conDetalle);
        em.merge(banCheque);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanCheque(BanCheque banCheque, SisSuceso sisSuceso) throws Exception {
        em.persist(banCheque);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception {
        em.persist(banCuenta);
        sisSuceso.setSusDetalle("Se ingreso la Cuenta con número " + banCuenta.getCtaNumero());
//            sisSuceso.setSusDetalle("Se ingreso la Cuenta con número " + banCuenta.getCtaNumero() +
//                    " con la cuenta contable " + banCuenta.getBanCuentaPK().getCtaCuentaContable());
//            sisSuceso.setSusDetalle("Se ingreso la Cuenta con número de secuencia " + banCuenta.getCtaSecuencia());
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(banBanco);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarBanChequeNumeracion(BanChequeNumeracion banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(banBanco);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(banCaja);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception {
        em.merge(banCuenta);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarBanCheque(BanCheque banCheque, SisSuceso sisSuceso) throws Exception {
        em.merge(banCheque);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarBanBanco(BanBanco banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.remove(em.merge(banBanco));
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarBanChequeNumeracion(BanChequeNumeracion banBanco, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.remove(em.merge(banBanco));
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarBanCaja(BanCaja banCaja, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.remove(em.merge(banCaja));
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarBanCuenta(BanCuenta banCuenta, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(banCuenta));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar Conciliacion
     *
     * @param banConciliacion
     * @param sisSuceso
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionBanConciliacion(banco.entity.BanConciliacion banConciliacion, java.util.List<banco.entity.BanCheque> banCheques, SisSuceso sisSuceso, char accion) throws Exception {
        if (accion == 'I') {
            em.persist(banConciliacion);
        }
        if (accion == 'M') {
            em.merge(banConciliacion);
        }
        if (accion == 'E') {
            em.remove(em.merge(banConciliacion));
        }
        for (banco.entity.BanCheque banCheque : banCheques) {
            if (accion == 'E') {
                banCheque.setConcCodigo(null);
                banCheque.setConcCuentaContable(null);
                banCheque.setConcEmpresa(null);
            }
            em.merge(banCheque);
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor misayo Metodo para ingresar, modificar o eliminar Conciliacion
     *
     * @param banCheques
     * @param sisSucesos
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean accionBanCheques(java.util.List<banco.entity.BanCheque> banCheques, java.util.List<contabilidad.TO.ConContableConDetalle> conContableConDetalles, java.util.List<SisSuceso> sisSucesos, char accion) throws Exception {
        for (banco.entity.BanCheque banCheque : banCheques) {
            if (accion == 'E') {
                banCheque.setConcCodigo(null);
                banCheque.setConcCuentaContable(null);
                banCheque.setConcEmpresa(null);
            }
            em.merge(banCheque);
        }
        for (contabilidad.TO.ConContableConDetalle conContableConDetalle : conContableConDetalles) {
            em.merge(conContableConDetalle.getConContable());
            em.merge(conContableConDetalle.getConDetalle());
        }
        for (sistemaWeb.entity.SisSuceso sisSuceso : sisSucesos) {
            em.persist(sisSuceso);
        }
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean eliminarBanCheques(BanCheque banCheque, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(banCheque));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor jack krauser Metodo para ingresar informacion con respecto a
     * archivo de preaviso
     *
     * @param banPreavisos objeto con la informacion de preaviso
     * @param sisSuceso el suceso que genera
     * @return true indicando que la transaccion termino correctamente
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public Boolean insertarPreaviso(banco.entity.BanPreavisos banPreavisos, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(banPreavisos);
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarBanPreaviso(banco.entity.BanPreavisos banPreavisos, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.remove(em.merge(banPreavisos));
        return true;
    }
}
