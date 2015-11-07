/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdVehiculos;

/**
 *
 * @author developer1
 */
@Local
public interface PrdVehiculosFacadeLocal {

    void create(PrdVehiculos prdVehiculos);

    void edit(PrdVehiculos prdVehiculos);

    void remove(PrdVehiculos prdVehiculos);

    PrdVehiculos find(Object id);

    List<PrdVehiculos> findAll();

    List<PrdVehiculos> findRange(int[] range);

    int count();
    
}
