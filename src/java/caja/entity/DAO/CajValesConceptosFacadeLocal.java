/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity.DAO;

import caja.entity.CajValesConceptos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface CajValesConceptosFacadeLocal {

    void create(CajValesConceptos cajValesConceptos);

    void edit(CajValesConceptos cajValesConceptos);

    void remove(CajValesConceptos cajValesConceptos);

    CajValesConceptos find(Object id);

    List<CajValesConceptos> findAll();

    List<CajValesConceptos> findRange(int[] range);

    int count();
    
}
