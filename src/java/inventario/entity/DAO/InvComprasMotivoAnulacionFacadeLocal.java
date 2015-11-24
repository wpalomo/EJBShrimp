/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasMotivoAnulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */

@Local
public interface InvComprasMotivoAnulacionFacadeLocal {

    void create(InvComprasMotivoAnulacion invComprasMotivoAnulacion);

    void edit(InvComprasMotivoAnulacion invComprasMotivoAnulacion);

    void remove(InvComprasMotivoAnulacion invComprasMotivoAnulacion);

    InvComprasMotivoAnulacion find(Object id);

    List<InvComprasMotivoAnulacion> findAll();

    List<InvComprasMotivoAnulacion> findRange(int[] range);

    int count();
    
}
