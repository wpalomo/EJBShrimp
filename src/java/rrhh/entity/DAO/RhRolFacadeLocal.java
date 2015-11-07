/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhRol;

/**
 *
 * @author fconza
 */
@Local
public interface RhRolFacadeLocal {

    void create(RhRol rhRol);

    void edit(RhRol rhRol);

    void remove(RhRol rhRol);

    RhRol find(Object id);

    List<RhRol> findAll();

    List<RhRol> findRange(int[] range);

    int count();
    
}
