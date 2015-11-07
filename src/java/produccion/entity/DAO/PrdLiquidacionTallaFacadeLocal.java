/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdLiquidacionTalla;

/**
 *
 * @author developer1
 */
@Local
public interface PrdLiquidacionTallaFacadeLocal {

    void create(PrdLiquidacionTalla prdLiquidacionTalla);

    void edit(PrdLiquidacionTalla prdLiquidacionTalla);

    void remove(PrdLiquidacionTalla prdLiquidacionTalla);

    PrdLiquidacionTalla find(Object id);

    List<PrdLiquidacionTalla> findAll();

    List<PrdLiquidacionTalla> findRange(int[] range);

    int count();
    
}
