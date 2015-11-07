/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdLiquidacionProducto;

/**
 *
 * @author developer1
 */
@Local
public interface PrdLiquidacionProductoFacadeLocal {

    void create(PrdLiquidacionProducto prdLiquidacionProducto);

    void edit(PrdLiquidacionProducto prdLiquidacionProducto);

    void remove(PrdLiquidacionProducto prdLiquidacionProducto);

    PrdLiquidacionProducto find(Object id);

    List<PrdLiquidacionProducto> findAll();

    List<PrdLiquidacionProducto> findRange(int[] range);

    int count();
    
}
