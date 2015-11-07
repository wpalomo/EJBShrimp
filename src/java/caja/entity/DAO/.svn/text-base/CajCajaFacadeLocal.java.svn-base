/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity.DAO;

import caja.entity.CajCaja;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface CajCajaFacadeLocal {

    void create(CajCaja cajCaja);

    void edit(CajCaja cajCaja);

    void remove(CajCaja cajCaja);

    CajCaja find(Object id);

    List<CajCaja> findAll();

    List<CajCaja> findRange(int[] range);

    int count();
    
}
