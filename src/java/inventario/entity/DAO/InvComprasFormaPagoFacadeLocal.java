/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity.DAO;

import inventario.entity.InvComprasFormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer1
 */
@Local
public interface InvComprasFormaPagoFacadeLocal {

    void create(InvComprasFormaPago invComprasFormaPago);

    void edit(InvComprasFormaPago invComprasFormaPago);

    void remove(InvComprasFormaPago invComprasFormaPago);

    InvComprasFormaPago find(Object id);

    List<InvComprasFormaPago> findAll();

    List<InvComprasFormaPago> findRange(int[] range);

    int count();
    
}
