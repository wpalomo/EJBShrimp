/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarCobros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarCobrosFacadeLocal {

    void create(CarCobros carCobros);

    void edit(CarCobros carCobros);

    void remove(CarCobros carCobros);

    CarCobros find(Object id);

    List<CarCobros> findAll();

    List<CarCobros> findRange(int[] range);

    int count();
    
}
