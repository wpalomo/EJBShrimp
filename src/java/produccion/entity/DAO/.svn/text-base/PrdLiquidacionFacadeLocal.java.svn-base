/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdLiquidacion;

/**
 *
 * @author developer1
 */
@Local
public interface PrdLiquidacionFacadeLocal {

    void create(PrdLiquidacion prdLiquidacion);

    void edit(PrdLiquidacion prdLiquidacion);

    void remove(PrdLiquidacion prdLiquidacion);

    PrdLiquidacion find(Object id);

    List<PrdLiquidacion> findAll();

    List<PrdLiquidacion> findRange(int[] range);

    int count();
    
}
