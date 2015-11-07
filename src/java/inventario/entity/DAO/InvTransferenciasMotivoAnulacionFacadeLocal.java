/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasMotivoAnulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvTransferenciasMotivoAnulacionFacadeLocal {

    void create(InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion);

    void edit(InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion);

    void remove(InvTransferenciasMotivoAnulacion invTransferenciasMotivoAnulacion);

    InvTransferenciasMotivoAnulacion find(Object id);

    List<InvTransferenciasMotivoAnulacion> findAll();

    List<InvTransferenciasMotivoAnulacion> findRange(int[] range);

    int count();
    
}
