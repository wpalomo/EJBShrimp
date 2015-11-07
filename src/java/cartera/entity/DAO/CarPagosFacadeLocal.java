/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarPagosFacadeLocal {

    void create(CarPagos carPagos);

    void edit(CarPagos carPagos);

    void remove(CarPagos carPagos);

    CarPagos find(Object id);

    List<CarPagos> findAll();

    List<CarPagos> findRange(int[] range);

    int count();
    
}
