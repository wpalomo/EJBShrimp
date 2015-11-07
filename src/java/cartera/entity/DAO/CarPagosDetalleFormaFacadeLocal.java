/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity.DAO;

import cartera.entity.CarPagosDetalleForma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface CarPagosDetalleFormaFacadeLocal {

    void create(CarPagosDetalleForma carPagosDetalleForma);

    void edit(CarPagosDetalleForma carPagosDetalleForma);

    void remove(CarPagosDetalleForma carPagosDetalleForma);

    CarPagosDetalleForma find(Object id);

    List<CarPagosDetalleForma> findAll();

    List<CarPagosDetalleForma> findRange(int[] range);

    int count();
    
}
