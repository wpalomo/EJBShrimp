/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasMotivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasMotivoFacadeLocal {

    void create(InvComprasMotivo invComprasMotivo);

    void edit(InvComprasMotivo invComprasMotivo);

    void remove(InvComprasMotivo invComprasMotivo);

    InvComprasMotivo find(Object id);

    List<InvComprasMotivo> findAll();

    List<InvComprasMotivo> findRange(int[] range);

    int count();
    
}
