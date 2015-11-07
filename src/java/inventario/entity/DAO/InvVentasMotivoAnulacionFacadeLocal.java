/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvVentasMotivoAnulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvVentasMotivoAnulacionFacadeLocal {

    void create(InvVentasMotivoAnulacion invVentasMotivoAnulacion);

    void edit(InvVentasMotivoAnulacion invVentasMotivoAnulacion);

    void remove(InvVentasMotivoAnulacion invVentasMotivoAnulacion);

    InvVentasMotivoAnulacion find(Object id);

    List<InvVentasMotivoAnulacion> findAll();

    List<InvVentasMotivoAnulacion> findRange(int[] range);

    int count();
    
}
