/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvConsumosMotivoAnulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvConsumosMotivoAnulacionFacadeLocal {

    void create(InvConsumosMotivoAnulacion invConsumosMotivoAnulacion);

    void edit(InvConsumosMotivoAnulacion invConsumosMotivoAnulacion);

    void remove(InvConsumosMotivoAnulacion invConsumosMotivoAnulacion);

    InvConsumosMotivoAnulacion find(Object id);

    List<InvConsumosMotivoAnulacion> findAll();

    List<InvConsumosMotivoAnulacion> findRange(int[] range);

    int count();
    
}
