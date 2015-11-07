/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdSector;

/**
 *
 * @author developer1
 */
@Local
public interface PrdSectorFacadeLocal {

    void create(PrdSector prdSector);

    void edit(PrdSector prdSector);

    void remove(PrdSector prdSector);

    PrdSector find(Object id);

    List<PrdSector> findAll();

    List<PrdSector> findRange(int[] range);

    int count();
    
}
