/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvBodega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvBodegaFacadeLocal {

    void create(InvBodega invBodega);

    void edit(InvBodega invBodega);

    void remove(InvBodega invBodega);

    InvBodega find(Object id);

    List<InvBodega> findAll();

    List<InvBodega> findRange(int[] range);

    int count();
    
}
