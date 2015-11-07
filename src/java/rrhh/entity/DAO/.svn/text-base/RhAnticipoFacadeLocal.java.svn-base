/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhAnticipo;

/**
 *
 * @author fconza
 */
@Local
public interface RhAnticipoFacadeLocal {

    void create(RhAnticipo rhAnticipo);

    void edit(RhAnticipo rhAnticipo);

    void remove(RhAnticipo rhAnticipo);

    RhAnticipo find(Object id);

    List<RhAnticipo> findAll();

    List<RhAnticipo> findRange(int[] range);

    int count();
    
}
