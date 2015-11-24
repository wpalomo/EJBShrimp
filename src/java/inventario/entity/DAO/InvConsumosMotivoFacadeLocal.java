/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvConsumosMotivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvConsumosMotivoFacadeLocal {

    void create(InvConsumosMotivo invConsumosMotivo);

    void edit(InvConsumosMotivo invConsumosMotivo);

    void remove(InvConsumosMotivo invConsumosMotivo);

    InvConsumosMotivo find(Object id);

    List<InvConsumosMotivo> findAll();

    List<InvConsumosMotivo> findRange(int[] range);

    int count();
    
}
