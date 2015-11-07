/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhSalarioDigno;

/**
 *
 * @author fconza
 */
@Local
public interface RhSalarioDignoFacadeLocal {

    void create(RhSalarioDigno rhSalarioDigno);

    void edit(RhSalarioDigno rhSalarioDigno);

    void remove(RhSalarioDigno rhSalarioDigno);

    RhSalarioDigno find(Object id);

    List<RhSalarioDigno> findAll();

    List<RhSalarioDigno> findRange(int[] range);

    int count();
    
}
