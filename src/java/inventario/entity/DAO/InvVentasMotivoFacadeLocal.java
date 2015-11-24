/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasMotivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasMotivoFacadeLocal {

    void create(InvVentasMotivo invVentasMotivo);

    void edit(InvVentasMotivo invVentasMotivo);

    void remove(InvVentasMotivo invVentasMotivo);

    InvVentasMotivo find(Object id);

    List<InvVentasMotivo> findAll();

    List<InvVentasMotivo> findRange(int[] range);

    int count();
    
}
