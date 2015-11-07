/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarCobrosDetalleForma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarCobrosDetalleFormaFacadeLocal {

    void create(CarCobrosDetalleForma carCobrosDetalleForma);

    void edit(CarCobrosDetalleForma carCobrosDetalleForma);

    void remove(CarCobrosDetalleForma carCobrosDetalleForma);

    CarCobrosDetalleForma find(Object id);

    List<CarCobrosDetalleForma> findAll();

    List<CarCobrosDetalleForma> findRange(int[] range);

    int count();
    
}
