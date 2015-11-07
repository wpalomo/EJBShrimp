/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConTipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConTipoFacadeLocal {

    void create(ConTipo conTipo);

    void edit(ConTipo conTipo);

    void remove(ConTipo conTipo);

    ConTipo find(Object id);

    List<ConTipo> findAll();

    List<ConTipo> findRange(int[] range);

    int count();
    
}
