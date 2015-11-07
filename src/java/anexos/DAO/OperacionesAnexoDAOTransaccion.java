/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.DAO;

import javax.ejb.Stateless;

/**
 *
 * @author jack
 */
@Stateless
public class OperacionesAnexoDAOTransaccion implements OperacionesAnexoDAOTransaccionLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.persistence.PersistenceContext (type = javax.persistence.PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private javax.persistence.EntityManager em;

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(anxNumeracion);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(anxNumeracion);
        em.flush();
        return true;
    }
    ///
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean eliminarAnexoNumeracion(anexos.entity.AnxNumeracion anxNumeracion, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(anxNumeracion));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean insertarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(anxAnulados);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean modificarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(anxAnulados);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarAnexoAnulados(anexos.entity.AnxAnulados anxAnulados, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(anxAnulados));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
 
    /**
     * @autor misayo
     * Metodo para actualizar anxCuentascontables
     * @param anxCuentascontables
     * @param sisSuceso
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean actualizarAnxCuentascontables(anexos.entity.AnxCuentascontables anxCuentascontables, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception{
        em.merge(anxCuentascontables);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    
    public Boolean eliminarAnxVentas(anexos.entity.AnxVenta anxVenta, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception{
        em.remove(em.merge(anxVenta));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    public Boolean reestructurarRetencion(anexos.entity.AnxCompra anxCompra, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception{
        em.merge(anxCompra);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionAnxVenta(anexos.entity.AnxVenta anxVenta, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(anxVenta);
        if (accion == 'M')
            em.merge(anxVenta);
        if (accion == 'E')
            em.remove(em.merge(anxVenta));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionAnxUrlWebServixce(anexos.entity.AnxUrlWebServices anxUrlWebServices, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(anxUrlWebServices);
        if (accion == 'M')
            em.merge(anxUrlWebServices);
        if (accion == 'E')
            em.remove(em.merge(anxUrlWebServices));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
     
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionAnxVentaElectronica(anexos.entity.AnxVentaElectronica anxVentaElectronica, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(anxVentaElectronica);
        if (accion == 'M')
            em.merge(anxVentaElectronica);
        if (accion == 'E')
            em.remove(em.merge(anxVentaElectronica));
        if(sisSuceso != null)
            em.persist(sisSuceso);
        em.flush();
        return true;
    }
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionAnxCompraElectronica(
            anexos.entity.AnxCompraElectronica anxCompraElectronica, 
            anexos.entity.AnxCompra anxCompra,
            sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(anxCompraElectronica);
        if (accion == 'M')
            em.merge(anxCompraElectronica);
        if (accion == 'E')
            em.remove(em.merge(anxCompraElectronica));
        if(anxCompra != null)
             em.merge(anxCompra);
        
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
}
