/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdPiscina;

/**
 *
 * @author developer1
 */
@Local
public interface PrdPiscinaFacadeLocal {

    void create(PrdPiscina prdPiscina);

    void edit(PrdPiscina prdPiscina);

    void remove(PrdPiscina prdPiscina);

    PrdPiscina find(Object id);

    List<PrdPiscina> findAll();

    List<PrdPiscina> findRange(int[] range);

    int count();
    
}
