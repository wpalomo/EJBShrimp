/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdLiquidacionDetalle;

/**
 *
 * @author developer1
 */
@Local
public interface PrdLiquidacionDetalleFacadeLocal {

    void create(PrdLiquidacionDetalle prdLiquidacionDetalle);

    void edit(PrdLiquidacionDetalle prdLiquidacionDetalle);

    void remove(PrdLiquidacionDetalle prdLiquidacionDetalle);

    PrdLiquidacionDetalle find(Object id);

    List<PrdLiquidacionDetalle> findAll();

    List<PrdLiquidacionDetalle> findRange(int[] range);

    int count();
    
}
