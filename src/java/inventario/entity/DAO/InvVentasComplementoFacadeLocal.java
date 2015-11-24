/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasComplemento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasComplementoFacadeLocal {

    void create(InvVentasComplemento invVentasComplemento);

    void edit(InvVentasComplemento invVentasComplemento);

    void remove(InvVentasComplemento invVentasComplemento);

    InvVentasComplemento find(Object id);

    List<InvVentasComplemento> findAll();

    List<InvVentasComplemento> findRange(int[] range);

    int count();
    
}
