/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvTransferenciasNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvTransferenciasNumeracionFacadeLocal {

    void create(InvTransferenciasNumeracion invTransferenciasNumeracion);

    void edit(InvTransferenciasNumeracion invTransferenciasNumeracion);

    void remove(InvTransferenciasNumeracion invTransferenciasNumeracion);

    InvTransferenciasNumeracion find(Object id);

    List<InvTransferenciasNumeracion> findAll();

    List<InvTransferenciasNumeracion> findRange(int[] range);

    int count();
    
}
