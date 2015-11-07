/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdCorrida;

/**
 *
 * @author developer1
 */
@Local
public interface PrdCorridaFacadeLocal {

    void create(PrdCorrida prdCorrida);

    void edit(PrdCorrida prdCorrida);

    void remove(PrdCorrida prdCorrida);

    PrdCorrida find(Object id);

    List<PrdCorrida> findAll();

    List<PrdCorrida> findRange(int[] range);

    int count();
    
}
