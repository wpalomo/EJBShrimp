/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvConsumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvConsumosFacadeLocal {

    void create(InvConsumos invConsumos);

    void edit(InvConsumos invConsumos);

    void remove(InvConsumos invConsumos);

    InvConsumos find(Object id);

    List<InvConsumos> findAll();

    List<InvConsumos> findRange(int[] range);

    int count();
    
}
