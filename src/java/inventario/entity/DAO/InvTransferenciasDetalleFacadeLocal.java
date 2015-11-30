/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvTransferenciasDetalleFacadeLocal {

    void create(InvTransferenciasDetalle invTransferenciasDetalle);

    void edit(InvTransferenciasDetalle invTransferenciasDetalle);

    void remove(InvTransferenciasDetalle invTransferenciasDetalle);

    InvTransferenciasDetalle find(Object id);

    List<InvTransferenciasDetalle> findAll();

    List<InvTransferenciasDetalle> findRange(int[] range);

    int count();
    
}
