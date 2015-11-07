/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.DAO;

import javax.ejb.Stateless;
/**
 *
 * @author jack
 */
@Stateless
public class OperacionesCajaDAOTransaccion implements OperacionesCajaDAOTransaccionLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.persistence.PersistenceContext (type = javax.persistence.PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private javax.persistence.EntityManager em;
    
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @javax.ejb.EJB
    caja.DAO.OperacionesCajaDAOLocal operacionesCajaDAOLocal;


    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean accionCajCaja(caja.entity.CajCaja cajCaja, sistemaWeb.entity.SisSuceso sisSuceso, String accion) throws Exception {
        if (accion.equals("I")){
            em.persist(sisSuceso);
            em.persist(cajCaja);
        }
        if (accion.equals("U")){
            em.persist(sisSuceso);
            em.merge(cajCaja);
        }
        if (accion.equals("D")){
            em.persist(sisSuceso);
            em.remove(em.merge(cajCaja));
        }
        em.flush();
        return true;
    }
// es la implemetacion 
    
   @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean accionCajVales(caja.entity.CajVales cajVales,sistemaWeb.entity.SisSuceso sisSuceso, 
            caja.entity.CajValesNumeracion cajValesNumeracion, boolean nuevo,char accion) throws Exception{
       
         if(accion=='I'){
             em.persist(sisSuceso);
             em.persist(cajVales);
             if (nuevo)
                 em.persist(cajValesNumeracion);
             else{
                em.merge(cajValesNumeracion);
            }
         }
         if(accion=='E'){
             //em.merge(cajValesNumeracion);
             em.persist(sisSuceso);
             em.remove(cajVales);
         }
         if(accion=='M'){
             //em.merge(cajValesNumeracion);
             em.persist(sisSuceso);
             em.merge(cajVales);
         }
         
         /*else
              em.merge(cajValesNumeracion);*/
         em.flush();
        return true;
    }
  
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public java.lang.Boolean accionCajValesConceptos(caja.entity.CajValesConceptos cajValesConceptos, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws java.lang.Exception{
        if (accion == 'I')
            em.persist(cajValesConceptos);
        if (accion == 'M')
            em.merge(cajValesConceptos);
        if (accion == 'E')
            em.remove(em.merge(cajValesConceptos));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
   
   public java.lang.Boolean accionCajaValesTO(caja.entity.CajVales cajVales,sistemaWeb.entity.SisSuceso sisSuceso,
           caja.entity.CajValesNumeracion cajValesNumeracion, char accion)throws Exception{
       String rellenarConCeros ="";
       boolean bandera = false;
       try{
           
            int numeracion = operacionesCajaDAOLocal.buscarConteoUltimaNumeracionCajaVale(
                    cajVales.getCajValesPK().getValeEmpresa(),
                    cajVales.getCajValesPK().getValePeriodo(), 
                    cajVales.getCajValesPK().getValeMotivo());
            boolean nuevo = false;//, retorno = false;
            if(numeracion == 0)
                nuevo = true;
            if(accion =='I'){
                do{
                    numeracion ++;
                    int numeroCerosAponer = 7 - String.valueOf(numeracion).trim().length();
                    rellenarConCeros ="";
                    for (int i=0; i< numeroCerosAponer; i++){
                        rellenarConCeros = rellenarConCeros + "0";
                    }
                    cajVales.setCajValesPK(new caja.entity.CajValesPK( 
                            cajVales.getCajValesPK().getValeEmpresa(), 
                            cajVales.getCajValesPK().getValePeriodo(), 
                            cajVales.getCajValesPK().getValeMotivo(),
                            rellenarConCeros+numeracion));
                    cajValesNumeracion.setNumSecuencia(rellenarConCeros+numeracion);
                }while(operacionesCajaDAOLocal.buscarCajVales(
                        cajVales.getCajValesPK().getValeEmpresa(), 
                        cajVales.getCajValesPK().getValePeriodo(), 
                        cajVales.getCajValesPK().getValeMotivo(),
                        rellenarConCeros + numeracion)!= null);
            }
            sisSuceso.setSusClave(
                        cajVales.getCajValesPK().getValePeriodo()+" "
                        + cajVales.getCajValesPK().getValeMotivo() + " "
                        + cajVales.getCajValesPK().getValeNumero());
            String detalle = "Caja de Vale por " + cajVales.getValeObservaciones();
            sisSuceso.setSusDetalle(detalle.trim().length() > 300 ? detalle.trim().substring(0, 300) : detalle);
            bandera = accionCajVales(cajVales, sisSuceso, cajValesNumeracion, nuevo,accion);
       }catch(Exception e){
           e.printStackTrace();
       }
       return bandera;
   }
}
