/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarCobrosDetalleAnticipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarCobrosDetalleAnticiposFacadeLocal {

    void create(CarCobrosDetalleAnticipos carCobrosDetalleAnticipos);

    void edit(CarCobrosDetalleAnticipos carCobrosDetalleAnticipos);

    void remove(CarCobrosDetalleAnticipos carCobrosDetalleAnticipos);

    CarCobrosDetalleAnticipos find(Object id);

    List<CarCobrosDetalleAnticipos> findAll();

    List<CarCobrosDetalleAnticipos> findRange(int[] range);

    int count();
    
}
