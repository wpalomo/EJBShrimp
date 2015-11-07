/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConEstructuraFlujo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConEstructuraFlujoFacadeLocal {

    void create(ConEstructuraFlujo conEstructuraFlujo);

    void edit(ConEstructuraFlujo conEstructuraFlujo);

    void remove(ConEstructuraFlujo conEstructuraFlujo);

    ConEstructuraFlujo find(Object id);

    List<ConEstructuraFlujo> findAll();

    List<ConEstructuraFlujo> findRange(int[] range);

    int count();
    
}
