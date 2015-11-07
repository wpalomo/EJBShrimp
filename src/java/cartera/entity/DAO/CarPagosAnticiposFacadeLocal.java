/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosAnticipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarPagosAnticiposFacadeLocal {

    void create(CarPagosAnticipos carPagosAnticipos);

    void edit(CarPagosAnticipos carPagosAnticipos);

    void remove(CarPagosAnticipos carPagosAnticipos);

    CarPagosAnticipos find(Object id);

    List<CarPagosAnticipos> findAll();

    List<CarPagosAnticipos> findRange(int[] range);

    int count();
    
}
