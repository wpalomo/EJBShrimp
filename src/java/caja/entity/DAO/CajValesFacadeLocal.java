/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity.DAO;

import caja.entity.CajVales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface CajValesFacadeLocal {

    void create(CajVales cajVales);

    void edit(CajVales cajVales);

    void remove(CajVales cajVales);

    CajVales find(Object id);

    List<CajVales> findAll();

    List<CajVales> findRange(int[] range);

    int count();
    
}
