/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhCategoria;

/**
 *
 * @author fconza
 */
@Local
public interface RhCategoriaFacadeLocal {

    void create(RhCategoria rhCategoria);

    void edit(RhCategoria rhCategoria);

    void remove(RhCategoria rhCategoria);

    RhCategoria find(Object id);

    List<RhCategoria> findAll();

    List<RhCategoria> findRange(int[] range);

    int count();
    
}
