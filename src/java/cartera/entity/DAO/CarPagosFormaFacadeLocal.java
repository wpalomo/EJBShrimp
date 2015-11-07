/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosForma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarPagosFormaFacadeLocal {

    void create(CarPagosForma carPagosForma);

    void edit(CarPagosForma carPagosForma);

    void remove(CarPagosForma carPagosForma);

    CarPagosForma find(Object id);

    List<CarPagosForma> findAll();

    List<CarPagosForma> findRange(int[] range);

    int count();
    
}
