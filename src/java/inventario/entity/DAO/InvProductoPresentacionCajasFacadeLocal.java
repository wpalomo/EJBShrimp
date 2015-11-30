/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvProductoPresentacionCajas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvProductoPresentacionCajasFacadeLocal {

    void create(InvProductoPresentacionCajas invProductoPresentacionCajas);

    void edit(InvProductoPresentacionCajas invProductoPresentacionCajas);

    void remove(InvProductoPresentacionCajas invProductoPresentacionCajas);

    InvProductoPresentacionCajas find(Object id);

    List<InvProductoPresentacionCajas> findAll();

    List<InvProductoPresentacionCajas> findRange(int[] range);

    int count();
    
}
