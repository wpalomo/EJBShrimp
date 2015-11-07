/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.DAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import produccion.entity.*;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesProduccionDAOTransaccion implements OperacionesProduccionDAOTransaccionLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    

    @PersistenceContext (type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;

    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;

    @EJB
    OperacionesProduccionDAOLocal operacionesProduccionDAOLocal;
    
    public SisErrorTO sisErrorTO = null;

    // <editor-fold defaultstate="collapsed" desc="SECTOR">
    /**
     * @autor misayo
     * Metodo para ingresar sector
     * @param prdSector
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception{
        em.persist(prdSector);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception {
        em.merge(prdSector);
//            em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(prdSector));
//            em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PISCINA">
    /**
     * @autor misayo
     * Metodo para ingresar empresa
     * @param sisGrupoTO
     * @param sisEmpresaTO Objeto TO
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception{
        em.persist(prdPiscina);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception {
        em.merge(prdPiscina);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(prdPiscina));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CORRIDA">
    /**
     * @autor misayo
     * Metodo para ingresar, modificar o eliminar prdCorrida
     * @param prdCorrida
     * @param sisSuceso
     * @param accion
     * @return true o false
     * @throws Exception Cualquier error inesperado
     */
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    @Override
    public Boolean accionPrdCorrida(produccion.entity.PrdCorrida prdCorrida, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception{
        if (accion == 'I')
            em.persist(prdCorrida);
        if (accion == 'M')
            em.merge(prdCorrida);
        if (accion == 'E')
            em.remove(em.merge(prdCorrida));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    @Override
    public Boolean accionPrdVehiculos(
            produccion.entity.PrdVehiculos prdVehiculos, 
            produccion.entity.PrdPiscina prdPiscina, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            char accion) throws Exception{
        if (accion == 'I'){
            em.persist(prdPiscina);
            em.persist(prdVehiculos);
        }
        if (accion == 'M'){
            em.merge(prdVehiculos);
        }
        if (accion == 'E'){
            em.remove(em.merge(prdPiscina));
            em.remove(em.merge(prdVehiculos));
        }
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarPrdGrameaje(PrdGrameaje prdGrameaje, SisSuceso sisSuceso) throws Exception {
        em.persist(prdGrameaje);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarPrdGrameaje(produccion.entity.PrdGrameaje prdGrameaje, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception{
        em.remove(em.merge(prdGrameaje));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="SOBREVIVENCIA">
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception {
        em.persist(prdSobrevivencia);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception {
        em.merge(prdSobrevivencia);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(prdSobrevivencia));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarPrdLiquidacionLotesValorizada(PrdLiquidacion prdLiquidacion, SisSuceso sisSuceso) throws Exception {
        em.persist(prdLiquidacion);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarBooleanoCorrida(java.util.List<PrdCorrida> prdCorrida) throws Exception {
        for (int i = 0; i < prdCorrida.size(); i++)
            em.merge(prdCorrida.get(i));
//        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    @Override
    public Boolean modificarCorrida(java.util.List<produccion.entity.PrdCorrida> prdCorrida) throws Exception{
        for (int i = 0; i < prdCorrida.size(); i++){
            em.merge(prdCorrida.get(i));
        }
        em.flush();
        return true;
    }
    
    public boolean insertarPrdLiquidacionMotivo(produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(prdLiquidacionMotivo);
        em.flush();
        return true;
    }

    public boolean modificarPrdLiquidacionMotivo(produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(prdLiquidacionMotivo);
        em.flush();
        return true;
    }

    public boolean insertarPrdLiquidacionTalla(produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(prdLiquidacionTalla);
        em.flush();
        return true;
    }

    public boolean modificarPrdLiquidacionTalla(produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(prdLiquidacionTalla);
        em.flush();
        return true;
    }

    public boolean insertarPrdLiquidacionProducto(produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.persist(prdLiquidacionProducto);
        em.flush();
        return true;
    }

    public boolean modificarPrdLiquidacionProducto(produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto, SisSuceso sisSuceso) throws Exception {
        em.persist(sisSuceso);
        em.merge(prdLiquidacionProducto);
        em.flush();
        return true;
    }
    
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public void insertarPrdLiquidacion(produccion.entity.PrdLiquidacion prdLiquidacion, java.util.List<produccion.entity.PrdLiquidacionDetalle> listaPrdLiquidacionDetalle,
            sistemaWeb.entity.SisSuceso sisSuceso, produccion.entity.PrdLiquidacionNumeracion prdLiquidacionNumeracion, boolean nuevo) 
            throws Exception {
        em.persist(prdLiquidacion);
        for (int i = 0; i < listaPrdLiquidacionDetalle.size(); i++){
            listaPrdLiquidacionDetalle.get(i).setDetOrden((i+1));
            listaPrdLiquidacionDetalle.get(i).setPrdLiquidacion(prdLiquidacion);            
                em.persist(listaPrdLiquidacionDetalle.get(i));
        }

        if (nuevo)
            em.persist(prdLiquidacionNumeracion);
        else
            em.merge(prdLiquidacionNumeracion);

        em.persist(sisSuceso);
        em.flush();
    }

    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRES_NEW)
    public boolean modificarPrdLiquidacion (produccion.entity.PrdLiquidacion prdLiquidacion,
            java.util.List <produccion.entity.PrdLiquidacionDetalle> listaPrdDetalle,
            java.util.List <produccion.entity.PrdLiquidacionDetalle> listaPrdDetalleEliminar,
            sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
            em.merge(prdLiquidacion);
            for (int i = 0; i < listaPrdDetalle.size(); i++){
                listaPrdDetalle.get(i).setDetOrden((i+1));
                listaPrdDetalle.get(i).setPrdLiquidacion(prdLiquidacion);
                em.merge(listaPrdDetalle.get(i));
            }

            if (!listaPrdDetalleEliminar.isEmpty())
                for (int i = 0; i < listaPrdDetalleEliminar.size(); i++){
                    listaPrdDetalleEliminar.get(i).setPrdLiquidacion(prdLiquidacion);
                    em.remove(em.merge(listaPrdDetalleEliminar.get(i)));
                }
            
            if (sisSuceso != null)
                em.persist(sisSuceso);
            em.flush();
            return true;
    }
        
    public boolean insertarTransaccionPrdLiquidacion(produccion.entity.PrdLiquidacion prdLiquidacion,
            java.util.List<produccion.entity.PrdLiquidacionDetalle> listaPrdLiquidacionDetalles,
            sistemaWeb.entity.SisSuceso sisSuceso,
            produccion.entity.PrdLiquidacionNumeracion prdLiquidacionNumeracion) throws Exception {

        String rellenarConCeros = "";
        int numeracion = operacionesProduccionDAOLocal.buscarConteoUltimaNumeracionLiquidacion(
                prdLiquidacion.getPrdLiquidacionPK().getLiqEmpresa(),
                prdLiquidacion.getPrdLiquidacionPK().getLiqMotivo());
        boolean nuevo = false;
        if (numeracion == 0)
            nuevo = true;
        do{
            numeracion++;
            int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
            rellenarConCeros = "";
            for (int i = 0; i < numeroCerosAponer; i++){
                rellenarConCeros = rellenarConCeros + "0";
            }

            prdLiquidacion.setPrdLiquidacionPK(new produccion.entity.PrdLiquidacionPK(prdLiquidacion.
                    getPrdLiquidacionPK().getLiqEmpresa(), prdLiquidacion.
                    getPrdLiquidacionPK().getLiqMotivo(), rellenarConCeros + numeracion));
            prdLiquidacionNumeracion.setNumSecuencia(rellenarConCeros + numeracion);

        }while(operacionesProduccionDAOLocal.buscarPrdLiquidacion(prdLiquidacion.
                getPrdLiquidacionPK().getLiqEmpresa(), prdLiquidacion.getPrdLiquidacionPK().getLiqMotivo(),
                rellenarConCeros + numeracion)!= null);
        sisSuceso.setSusClave(prdLiquidacion.getPrdLiquidacionPK().getLiqMotivo() + " "
                + prdLiquidacion.getPrdLiquidacionPK().getLiqNumero());
        String detalle = "Se insertó la liquidacion: "+prdLiquidacion.getPrdLiquidacionPK().getLiqNumero()+", con el motivo: "+prdLiquidacion.getPrdLiquidacionPK().getLiqNumero();        
        sisSuceso.setSusDetalle(detalle.length() > 300 ? detalle.substring(0, 300) : detalle);
        insertarPrdLiquidacion(prdLiquidacion, listaPrdLiquidacionDetalles, sisSuceso, prdLiquidacionNumeracion, nuevo);
        return true;
    }
    
    
}