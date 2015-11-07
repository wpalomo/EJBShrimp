/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxDpaEcuador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxDpaEcuadorFacadeLocal {

    void create(AnxDpaEcuador anxDpaEcuador);

    void edit(AnxDpaEcuador anxDpaEcuador);

    void remove(AnxDpaEcuador anxDpaEcuador);

    AnxDpaEcuador find(Object id);

    List<AnxDpaEcuador> findAll();

    List<AnxDpaEcuador> findRange(int[] range);

    int count();
    
}
