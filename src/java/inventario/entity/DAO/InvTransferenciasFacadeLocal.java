/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferencias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvTransferenciasFacadeLocal {

    void create(InvTransferencias invTransferencias);

    void edit(InvTransferencias invTransferencias);

    void remove(InvTransferencias invTransferencias);

    InvTransferencias find(Object id);

    List<InvTransferencias> findAll();

    List<InvTransferencias> findRange(int[] range);

    int count();
    
}
