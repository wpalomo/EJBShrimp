/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosDetalleAnticipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarPagosDetalleAnticiposFacadeLocal {

    void create(CarPagosDetalleAnticipos carPagosDetalleAnticipos);

    void edit(CarPagosDetalleAnticipos carPagosDetalleAnticipos);

    void remove(CarPagosDetalleAnticipos carPagosDetalleAnticipos);

    CarPagosDetalleAnticipos find(Object id);

    List<CarPagosDetalleAnticipos> findAll();

    List<CarPagosDetalleAnticipos> findRange(int[] range);

    int count();
    
}
