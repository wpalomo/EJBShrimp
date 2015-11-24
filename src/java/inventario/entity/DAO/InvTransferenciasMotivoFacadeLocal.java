/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasMotivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvTransferenciasMotivoFacadeLocal {

    void create(InvTransferenciasMotivo invTransferenciasMotivo);

    void edit(InvTransferenciasMotivo invTransferenciasMotivo);

    void remove(InvTransferenciasMotivo invTransferenciasMotivo);

    InvTransferenciasMotivo find(Object id);

    List<InvTransferenciasMotivo> findAll();

    List<InvTransferenciasMotivo> findRange(int[] range);

    int count();
    
}
