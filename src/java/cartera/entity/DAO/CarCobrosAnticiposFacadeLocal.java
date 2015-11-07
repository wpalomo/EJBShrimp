/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarCobrosAnticipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarCobrosAnticiposFacadeLocal {

    void create(CarCobrosAnticipos carCobrosAnticipos);

    void edit(CarCobrosAnticipos carCobrosAnticipos);

    void remove(CarCobrosAnticipos carCobrosAnticipos);

    CarCobrosAnticipos find(Object id);

    List<CarCobrosAnticipos> findAll();

    List<CarCobrosAnticipos> findRange(int[] range);

    int count();
    
}
