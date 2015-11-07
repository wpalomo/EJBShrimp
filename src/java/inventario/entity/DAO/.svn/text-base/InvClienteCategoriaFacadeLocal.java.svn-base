/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvClienteCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvClienteCategoriaFacadeLocal {

    void create(InvClienteCategoria invClienteCategoria);

    void edit(InvClienteCategoria invClienteCategoria);

    void remove(InvClienteCategoria invClienteCategoria);

    InvClienteCategoria find(Object id);

    List<InvClienteCategoria> findAll();

    List<InvClienteCategoria> findRange(int[] range);

    int count();
    
}
